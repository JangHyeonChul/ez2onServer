function DLCRankBtn(dlcNumber) {

    $.ajax({
        url : '/rank/dlc?dlcnumber=' + dlcNumber,
        type: 'GET',

        success: function (data) {
            drawDlcRank(data, dlcNumber)
        },
        error: function (request) {

        }


    })
    
}





$(document).ready(function() {
    $(document).on("mouseenter", ".item-profile", function () {
        $(this).stop().animate({ opacity: 1 }, 300);
    })

    $(document).on("mouseleave", ".item-profile", function () {
        $(this).stop().animate({ opacity: 0 }, 300);
    })
});