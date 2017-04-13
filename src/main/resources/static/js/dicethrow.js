$(function() {
    $('#dice').on('click', function() {
        $.ajax({
            url: 'dice',
            type: 'GET'
        }).done(function(data) {
            $('#dice').attr('src', 'img/dice/dice-' + data.value.toString() +'.jpg');
        });
    });
});