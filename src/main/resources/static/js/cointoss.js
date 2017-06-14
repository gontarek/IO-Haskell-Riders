$(function() {
    $('#button').on('click', function() {
        $.ajax({
            url: 'coin',
            type: 'POST'
        }).done(function(data) {
            if (data.value === 0) {
                $('#coin').attr('src', '../images/50-groszy-awers.jpg');
            } else {
                $('#coin').attr('src', '../images/50-groszy-rewers.jpg');
            }
            $('#message').text("Congratulations! You've tossed the coin.");
        });
    });
});