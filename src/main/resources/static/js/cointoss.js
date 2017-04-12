$(function() {
    $('#coin').on('click', function() {
        $.ajax({
            url: 'coin',
            type: 'GET'
        }).done(function(data) {
            if (data.value === 0) {
                $('#coin').attr('src', 'img/50-groszy-awers.jpg');
            } else {
                $('#coin').attr('src', 'img/50-groszy-rewers.jpg');
            }
        });
    });
});