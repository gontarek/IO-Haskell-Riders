/**
 * Created by mruga on 11.06.2017.
 */
function load_sequence(){
    $.ajax({
        url: 'sequence'
    }).done(function(data) {
        $('#seq').text(data)
    });
}
$(document).ready(function() {
    load_sequence();
});
$('#load_sequence').click(
    function () {
        load_sequence();
    }
);