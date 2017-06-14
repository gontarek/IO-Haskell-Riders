/**
 * Created by mruga on 14.06.2017.
 */
/**
 * Created by mruga on 11.06.2017.
 */
function load_lotto(){
    $.ajax({
        url: '/api/lotto',
        method: 'POST'
    }).done(function(data) {
        $('#lotto').text(JSON.stringify(data["value"]))
    });
}
$(document).ready(function() {
    load_lotto();
});

$('#load_lotto').click(function () {
    load_lotto();
    return true;
});
