function drawDlcRank(data, dlcNumber) {
    const contentItem = $('.content-item');
    var dlcTitle = drawDLCTitle(dlcNumber);

    var dlcList = dlcTitle;

    $.each(data, function (index, dataList) {
        dlcList += '  <div class="dlc-rank maring-auto">\n' +
            '                    <div class="dlc-rank-column"><h4>' + (index + 1) + '위</h4></div>\n' +
            '                    <div class="dlc-rank-column">' +
            '<a onclick="moveItemInfo('+ dataList.re_num +')"><img class="dlc-sumnail " src="' + dataList.re_sumnail +'"/></div></a>\n' +
            '                    <div class="dlc-text">\n' +
            '                        <ul>\n' +
            '                            <li><h2>제목 : ' + dataList.re_name + '</h2></li>\n' +
            '                            <li><h2>BPM : ' + dataList.re_bpm + '</h2></li>\n' +
            '                            <li><h2>평가난이도 : ' + dataList.re_level + '</h2></li>\n' +
            '                        </ul>\n' +
            '                    </div>\n' +
            '                </div>'
    })
    contentItem.html(dlcList);
}

function drawDLCTitle(dlcNumber) {
    switch (dlcNumber) {
        case 1:
            return '<h1 class="dlc-tt">TIME TRAVERLER</h1>';
        case 2:
            return '<h1 class="dlc-cv">CODENAME VIOLET</h1>';
        case 3:
            return '<h1 class="dlc-pp">PRESTIGE PASS</h1>';
        case 4:
            return '<h1 class="dlc-o2jam">O2JAM</h1>';
        case 5:
            return '<h1 class="dlc-groove">GROOVE COASTER</h1>';
        case 6:
            return '<h1 class="dlc-ec">ENDLESS CIRCULATION</h1>';
    }
}