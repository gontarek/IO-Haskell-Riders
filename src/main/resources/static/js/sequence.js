/**
 * Created by mruga on 11.06.2017.
 */
function load_sequence(){
    $.ajax({
        url: 'sequence',
        method: 'POST'
    }).done(function(data) {
        console.log(data);
        $('#seq').text(data)
    });
}
$(document).ready(function() {
    load_sequence();
});

$('#load_sequence').click(function () {
    load_sequence();
});