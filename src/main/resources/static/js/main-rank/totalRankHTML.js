function drawTotalRank() {

    $.ajax({
        url: '/rank/total',
        type: 'GET',
        contentType: 'application/json',
        dataType: 'text',

        success: function (data) {
            drawTotalHTML(data)
        }
    })

}

function drawTotalHTML(data) {
    const contentItem = $('.content-item');
    const dataJSON = JSON.parse(data);
    var tier0List_up = '';
    var tier0List_down = '';

    var tier1List_up = '';
    var tier1List_down = '';

    var tier2List_up = '';
    var tier2List_down = '';

    $.each(dataJSON, function (index, data) {
        if (2 < index && index < 8) {
            tier0List_up += ' <div class="item-box ranking">\n' +
                ' <a onclick="moveItemInfo(' + data.re_num + ')">\n' +
                ' <img class="main-item-sumnail"  src="' + data.re_sumnail + '"  /></a>\n' +
                ' <p>' + data.re_name + '</p>\n' +
                ' <p style="color: red;">(평가난이도 : ' + data.re_level + ')</p>\n' +
                ' </div>\n';
        }

        if (8 <= index && index < 13) {
            tier0List_down += ' <div class="item-box ranking">\n' +
                ' <a onclick="moveItemInfo(' + data.re_num + ')">\n' +
                ' <img class="main-item-sumnail"  src="' + data.re_sumnail + '"  /></a>\n' +
                ' <p>' + data.re_name + '</p>\n' +
                ' <p style="color: red;">(평가난이도 : ' + data.re_level + ')</p>\n' +
                ' </div>\n';
        }

        if (13 <= index && index < 18) {
            tier1List_up += ' <div class="item-box ranking">\n' +
                ' <a onclick="moveItemInfo(' + data.re_num + ')">\n' +
                ' <img class="main-item-sumnail"  src="' + data.re_sumnail + '"  /></a>\n' +
                ' <p>' + data.re_name + '</p>\n' +
                ' <p style="color: red;">(평가난이도 : ' + data.re_level + ')</p>\n' +
                ' </div>\n';
        }

        if (18 <= index && index < 23) {
            tier1List_down += ' <div class="item-box ranking">\n' +
                ' <a onclick="moveItemInfo(' + data.re_num + ')">\n' +
                ' <img class="main-item-sumnail"  src="' + data.re_sumnail + '"  /></a>\n' +
                ' <p>' + data.re_name + '</p>\n' +
                ' <p style="color: red;">(평가난이도 : ' + data.re_level + ')</p>\n' +
                ' </div>\n';
        }

        if (23 <= index && index < 28) {
            tier2List_up += ' <div class="item-box ranking">\n' +
                ' <a onclick="moveItemInfo(' + data.re_num + ')">\n' +
                ' <img class="main-item-sumnail"  src="' + data.re_sumnail + '"  /></a>\n' +
                ' <p>' + data.re_name + '</p>\n' +
                ' <p style="color: red;">(평가난이도 : ' + data.re_level + ')</p>\n' +
                ' </div>\n';
        }

        if (28 <= index && index < 33) {
            tier2List_down += ' <div class="item-box ranking">\n' +
                ' <a onclick="moveItemInfo(' + data.re_num + ')">\n' +
                ' <img class="main-item-sumnail"  src="' + data.re_sumnail + '"  /></a>\n' +
                ' <p>' + data.re_name + '</p>\n' +
                ' <p style="color: red;">(평가난이도 : ' + data.re_level + ')</p>\n' +
                ' </div>\n';
        }

        var itemHtml = ' <div class="rank-box ">\n' +
            '\n' +
            '                <div class="ranking">\n' +
            '                        <h3>1위</h3>\n' +
            '                        <a onclick="moveItemInfo(' + dataJSON[0].re_num +')" >\n' +
            '                            <img class="main-item-sumnail" src="' + dataJSON[0].re_sumnail + '" /></a>\n' +
            '                        <p> ' + dataJSON[0].re_name + '</p>\n' +
            '                        <p style="color: red;">(평가난이도 : ' + dataJSON[0].re_level + ')</p>\n' +
            '                    </div>\n'+

            '                    <div class="ranking">\n' +
            '                        <h3>2위</h3>\n' +
            '                        <a onclick="moveItemInfo(' + dataJSON[1].re_num +')" >\n' +
            '                            <img class="main-item-sumnail" src="' + dataJSON[1].re_sumnail + '" /></a>\n' +
            '                        <p> ' + dataJSON[1].re_name + '</p>\n' +
            '                        <p style="color: red;">(평가난이도 : ' + dataJSON[1].re_level + ')</p>\n' +
            '                    </div>\n'+

            '                    <div class="ranking">\n' +
            '                        <h3>3위</h3>\n' +
            '                        <a onclick="moveItemInfo(' + dataJSON[2].re_num +')" >\n' +
            '                            <img class="main-item-sumnail" src="' + dataJSON[2].re_sumnail + '" /></a>\n' +
            '                        <p> ' + dataJSON[2].re_name + '</p>\n' +
            '                        <p style="color: red;">(평가난이도 : ' + dataJSON[2].re_level + ')</p>\n' +
            '                    </div>\n' +
            '                 </div>\n' +

            ' <div class="tier-item-box maring-auto">\n' +
            '                <div class="content-h3"><h3>0티어</h3></div>\n' +
            '                    <div class="content-item-box">\n' +
            tier0List_up +
            '                    </div>\n' +
            '                <div class="content-item-box">\n' +
            tier0List_down +
            '                </div>\n' +
            '            </div>' +
            ' <div class="maring-auto">\n' +
            '                <div class="content-h3"><h3>1티어</h3></div>\n' +
            '                <div class="content-item-box">\n' +
            tier1List_up +
            '                </div>\n' +
            '                <div class="content-item-box">\n' +
            tier1List_down +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="maring-auto">\n' +
            '                <div class="content-h3"><h3>2티어</h3></div>\n' +
            '                <div class="content-item-box">\n' +
            tier2List_up +
            '                </div>\n' +
            '                <div class="content-item-box">\n' +
            tier2List_down +
            '                </div>'
        contentItem.html(itemHtml);

    })
}

