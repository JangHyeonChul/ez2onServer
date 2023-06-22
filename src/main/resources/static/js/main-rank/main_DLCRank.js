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