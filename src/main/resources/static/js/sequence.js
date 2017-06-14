/**
 * Created by mruga on 11.06.2017.
 */
$(function() {
    $('#dice').on('click', function() {
        $.ajax({
            url: 'sequence',
            type: 'POST'
        }).done(function(data) {
            $('#seq').text(data)
        });
    });
});