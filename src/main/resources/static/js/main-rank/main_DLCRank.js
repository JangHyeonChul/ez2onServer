function DLCRankBtn(dlcNumber) {

    $.ajax({
        url : '/rank/dlc?dlcnumber=' + dlcNumber,
        type: 'GET',

        success: function (data) {
            drawDlcRank(data, dlcNumber)
        },
        error: function (request) {
            console.log(request);
        }


    })
    
}

function asdf() {
    console.log("11");
}

$(document).ready(function() {
    $('.item-profile').mouseenter(function() {
        console.log("실행");
        $(this).stop().animate({ opacity: 1 }, 300);
    }).mouseleave(function() {
        console.log("실행");
        $(this).stop().animate({ opacity: 0 }, 300);
    });
});

$(document).ready(function() {
    $(document).on("mouseenter", ".item-profile", function () {
        $(this).stop().animate({ opacity: 1 }, 300);
    })

    $(document).on("mouseleave", ".item-profile", function () {
        $(this).stop().animate({ opacity: 0 }, 300);
    })
});