function drawButtonRank(keyValue) {
    const contentItem = $('.content-item');



    $.ajax({
        url: '/rank/key?keyvalue=' + keyValue,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            drawTotalHTML(data, keyValue);

        }
    })

}

