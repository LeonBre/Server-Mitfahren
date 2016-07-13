(function () {
    var terms;
    terms = [
        'Big Papa',
        'Graystar',
        'Blackout',
        'The Stag',
        'The Bear',
        'The Panther'
    ];
    $(document).on('keyup', 'input', function (e) {
        var i, len, term;
        for (i = 0, len = terms.length; i < len; i++) {
            if (window.CP.shouldStopExecution(1)) {
                break;
            }
            term = terms[i];
            if ($(this).val().length === 0) {
                $('.autoFill').val('');
                return;
            }
            if (term.toUpperCase().indexOf($(this).val().toUpperCase()) === 0) {
                $('.autoFill').val(term);
                if (e.which === 13) {
                    $('input').val(term);
                }
                return;
            }
            $('.autoFill').val('');
        }
        window.CP.exitedLoop(1);
    });
}.call(this));
