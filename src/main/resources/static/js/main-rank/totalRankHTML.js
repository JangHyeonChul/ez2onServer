function drawTotalRank() {

    $.ajax({
        url: '/rank/total',
        type: 'GET',
        contentType: 'application/json',
        dataType: 'text',

        success: function (data) {
            const dataJSON = JSON.parse(data);
            drawTotalHTML(dataJSON, null)
        }
    })

}

function drawTotalHTML(data, keyValue) {
    const contentItem = $('.content-item');
    var tier0List_up = '';
    var tier0List_down = '';

    var tier1List_up = '';
    var tier1List_down = '';

    var tier2List_up = '';
    var tier2List_down = '';

    var tier3List_up = '';
    var tier3List_down = '';

    var keyNav = '';

    if (keyValue != null) {
        keyNav += '            <div class="rank-key">\n' +
            '                <ul>\n' +
            '                    <h3>옵션</h3>\n' +
            '                    <li><a onclick="drawButtonRank(\'4K\')">4키</a></li>\n' +
            '                    <li><a onclick="drawButtonRank(\'5K\')">5키</a></li>\n' +
            '                    <li><a onclick="drawButtonRank(\'6K\')">6키</a></li>\n' +
            '                    <li><a onclick="drawButtonRank(\'8K\')">8키</a></li>\n' +
            '                </ul>\n' +
            '                <h2 id="current-tier">현재 서열표 : ' + keyValue + '</h2>\n' +
            '            </div>';
    }

    $.each(data, function (index, dataList) {
        if (2 < index && index < 8) {
            tier0List_up += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (8 <= index && index < 13) {
            tier0List_down += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (13 <= index && index < 18) {
            tier1List_up += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (18 <= index && index < 23) {
            tier1List_down += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (23 <= index && index < 28) {
            tier2List_up += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (28 <= index && index < 33) {
            tier2List_down += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (33 <= index && index < 38) {
            tier3List_up += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        if (38 <= index && index < 43) {
            tier3List_down += '<div class="img-hover-container">\n' +
                '  <div class="img-hover-box">\n' +
                '  <div class="item-box ranking">\n' +
                '  <a class="img-hover" >\n' +
                '   <img class="main-item-sumnail" src="' + dataList.re_sumnail + '"  /></a>\n' +
                '                                <div onclick="moveItemInfo(' + dataList.re_num + ')" class="item-profile">\n' +
                '                                    <p>평가점수 ' + dataList.selectLevel + '</p>\n' +
                '                                </div>\n' +
                '                                </a>\n' +
                '                                </div>\n' +
                '                                <p class="main-name">' + dataList.re_name + '</p>\n' +
                '                                </div>\n' +
                '                            </div>'
        }

        var itemHtml =  keyNav +
            '<div class="rank-box ">\n' +
            '\n' +
'                                <div class="ranking">\n' +
            '                                    <h3>1위</h3>\n' +
            '                                    <div class="img-hover-box">\n' +
            '\n' +
            '                                        <a class="img-hover"onclick="moveItemInfo(' + data[0].re_num + ')" >\n' +
            '                                                <img class="main-item-sumnail" src="' + data[0].re_sumnail + '" />\n' +
            '                                            <div class="item-profile">\n' +
            '                                                <p>평가점수 ' + data[0].selectLevel + '</p>\n' +
            '                                            </div>\n' +
            '\n' +
            '                                        </a>\n' +
            '                                        <p>' + data[0].re_name + '</p>\n' +
            '                                    </div>\n' +
            '                                </div>' +

            '                                <div class="ranking">\n' +
            '                                    <h3>2위</h3>\n' +
            '                                    <div class="img-hover-box">\n' +
            '\n' +
            '                                        <a class="img-hover"onclick="moveItemInfo(' + data[1].re_num + ')" >\n' +
            '                                                <img class="main-item-sumnail" src="' + data[1].re_sumnail + '" />\n' +
            '                                            <div class="item-profile">\n' +
            '                                                <p>평가점수 ' + data[1].selectLevel + '</p>\n' +
            '                                            </div>\n' +
            '\n' +
            '                                        </a>\n' +
            '                                        <p>' + data[1].re_name + '</p>\n' +
            '                                    </div>\n' +
            '                                </div>' +

            '                                <div class="ranking">\n' +
            '                                    <h3>3위</h3>\n' +
            '                                    <div class="img-hover-box">\n' +
            '\n' +
            '                                        <a class="img-hover"onclick="moveItemInfo(' + data[2].re_num + ')" >\n' +
            '                                                <img class="main-item-sumnail" src="' + data[2].re_sumnail + '" />\n' +
            '                                            <div class="item-profile">\n' +
            '                                                <p>평가점수 ' + data[2].selectLevel + '</p>\n' +
            '                                            </div>\n' +
            '\n' +
            '                                        </a>\n' +
            '                                        <p>' + data[2].re_name + '</p>\n' +
            '                                    </div>\n' +
            '                                </div>' +
            '                                </div>' +

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
            '                </div>' +
        '            <div class="maring-auto">\n' +
        '                <div class="content-h3"><h3>3티어</h3></div>\n' +
        '                <div class="content-item-box">\n' +
        tier3List_up +
        '                </div>\n' +
        '                <div class="content-item-box">\n' +
        tier3List_down +
        '                </div>';
        contentItem.html(itemHtml);

    })
}

