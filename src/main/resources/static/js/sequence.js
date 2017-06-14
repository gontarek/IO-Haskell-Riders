/**
 * Created by mruga on 11.06.2017.
 */
$(document).ready(function() {
        $.ajax({
            url: 'sequence'
        }).done(function(data) {
            $('#seq').text(data)
        });
});