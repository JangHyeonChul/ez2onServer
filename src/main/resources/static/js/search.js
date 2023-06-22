$('#main-search').ready(function () {
    $('#main-search').blur(function () {
        var searchValue = $('#main-search');
        var searchDropmenu = $('.search-dropmenu');

        searchValue.val('');
        searchDropmenu.height(0);
        searchDropmenu.css("opacity", 0);
    })
})


$('#main-search[type="text"]').on('input', function () {
    var searchValue = $('#main-search').val();
    var searchDropmenu = $('.search-dropmenu');


    if (searchValue.length > 1) {
            searchDropmenu.height(300);
            searchDropmenu.css("opacity", 1);

            $.ajax({
                url: '/search?keyword=' + searchValue,
                type: 'GET',

                success: function (data) {
                    var dropMenuHTML = '';

                    if(data.length == 0) {
                        dropMenuHTML += '<h2 class="no-search">검색된 데이터가 없습니다</h2>'
                    }

                    $.each(data, function (index, dataList) {
                        dropMenuHTML += '                    <a onclick="moveItemInfo('+ dataList.re_num +')">\n' +
                            '                        <div class="drop-item">\n' +
                            '                        <img class="mini-sumnail" src="' + dataList.re_sumnail +'"/>\n' +
                            '                        <h2> ' + dataList.re_name + '</h2>\n' +
                            '                        </div>\n' +
                            '                    </a>'
                    })

                    searchDropmenu.html(dropMenuHTML);
                },

                error: function (request) {
                    console.log("실패");
                }

            })
    }

    if (searchValue.length <= 1) {
        searchDropmenu.height(0);
        searchDropmenu.css("opacity", 0);
    }

})