$(function() {
    $('#dice').on('click', function() {
        $.ajax({
            url: 'dice',
            type: 'POST'
        }).done(function(data) {
            $('#dice').attr('src', '../images/dice/dice-' + data.value.toString() +'.jpg');
        });
    });
});