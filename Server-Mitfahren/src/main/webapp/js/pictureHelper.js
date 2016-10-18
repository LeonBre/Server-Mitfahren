// Shows a base64 converted picture on the jQuery div imgDiv
function showPicture(base64picture, imgDiv) {
  imgDiv.append(getPictureString(base64picture))
}

// Makes a String to append on a Html Element to show the picture
// Stored in base64picture
function getPictureString(base64picture) {
  return '<img src="data:image/png;base64, ' + base64picture + '" alt="ProfilePicture" />'
}

// Author James Harrington 2014
// Saves a file as a base64 String
function base64(file, callback){
  var coolFile = {};
  function readerOnload(e){
    var base64 = btoa(e.target.result);
    coolFile.base64 = base64;
    callback(coolFile)
  };

  var reader = new FileReader();
  reader.onload = readerOnload;

  var file = file[0].files[0];
  coolFile.filetype = file.type;
  coolFile.size = file.size;
  coolFile.filename = file.name;
  reader.readAsBinaryString(file);
}

/*
EXAMPLE:
<input id="inputFileToLoad" type="file"/>
<div id="imgTest"></div>

function test(){
  base64( $('#inputFileToLoad'), function(data){
    console.log(data.base64)
    showPicture(data.base64, $('#imgTest'))
    asdf = data.base64
  })
}
*/
