var destinationURL = "http://localhost:8080"
var userUrl = "user.html"

var isLoggedIn = false;

var $navbarRight = $('#nav-mobile');
var $navMobile = $('#nav-mobile');
var $navbarFirst = $('navbarFirst');
var $narbarSearch= $('navbarSearch')
var $navbarAbout = $('navbarAbout');
var $navbarRegister = $('#navbarRegister');
var $navbarLogin = $('#navbarLogin');

var $loginButton = $('#loginButton');
var $loginUsername = $('#loginUsername');
var $loginPassword = $('#loginPassword');

$(document).ready(function() {
  //Checks if the user is already logged in.
  if(Cookies.get('username') != null && Cookies.get('password') != null){
    isLoggedIn = true;
    makeLoginVisible(Cookies.get('username'),
                      Cookies.get('password'),
                      Cookies.get('userId'))
  }else {
    isLoggedIn = false;
  }

  //If the user is logged in the Register tab should disappear.
  if(isLoggedIn == true){
    $navbarRegister.empty();
  }

});

  //Navbar Login Code.
  //When the user is not logged in, a click on login opens the login modal.
  //when the usr is logged in, a click on login logs the user out.
  $navbarLogin.on('click', function() {
    if(isLoggedIn == false){
      $('#loginModal').openModal();
    } else {
      logout()
    }
  });

  //Logs the user in.
  //First it gets the username, then it saves the password as an SHA512 //encripted String
  //Then it verifies the username, password compination on the server.
  $loginButton.on('click', function() {
    var username = $loginUsername.val()

    //Hash Password
    var hashWordArray = CryptoJS.SHA512($loginPassword.val());
    var base64HashString = hashWordArray.toString(CryptoJS.enc.Base64);

    //store Data
    var data = {
      username : username,
      password : base64HashString
    }
    data = JSON.stringify(data)

    //send Data
    //TODO Change the destinationURL from testAuthenticate to authenticate
    $.ajax({
      type: 'POST',
      url: destinationURL + '/Server-Mitfahren/apiv1/authenticate',
      contentType: "application/json",
      data: data,
      success: function(response) {
        console.log("From Server: ", JSON.stringify(response))
        //If the combination is valid the user is able to log in.
        if(response.isAuthenticated == true){
          login(username, base64HashString, response.userId)
        //if the combination is not valid the username and the password will
        // be removed and the user will be prompted
        } else{
          $loginUsername.val("");
          $loginPassword.val("");
          makeToast("Nutzername oder Password ist falsch.")
        }
      },
      error: function() {
        console.log("Error");
      }
    });
  });

  //A Cookie will be set for the username and the password.
  //The modal will be closed and the website will change.
  function login(username, password, userId) {
    Cookies.set('username', username);
    Cookies.set('password', password)
    Cookies.set('userId', userId)
    isLoggedIn = true;
    $('#loginModal').closeModal();
    makeToast("Erfolgreich eingeloggt.")
    makeLoginVisible(username, password, userId)
  }

  //The Login changes will be made visible to the Website
  //The Login Text changes to Logout and a tab for the username is visible
  //The Register Button disappears
  function makeLoginVisible(username, password, userId) {
    $navbarLogin.text('Logout');
    $navbarRight.append('<li><a id="navbarUsername" '
                        + 'onclick="window.location=\'' + userUrl
                        + '?userId=' + userId +'\';">'
                        + username + '</a></li>');
    $navbarRegister.empty();
  }

  //Makes the logout visible to the website.
  //The Cookies will be removed.
  //The logout will be visible on the website.
  function logout(){
    Cookies.remove('username')
    Cookies.remove('password')
    isLoggedIn = false;
    $navbarLogin.text('Login');
    $navbarRegister.append('<li><a id="navbarRegister" href="register.html">Registrieren</a></li>')
    makeToast("Erfolgreich ausgeloggt.")
    $('#navbarUsername').remove()
  }

  //Makes a toast for the website
  function makeToast(toast) {
    Materialize.toast(toast, 3000, 'rounded')
  }
