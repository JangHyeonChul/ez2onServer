$('#mypage').click(function () {
    var mypageWidth = $('#mypage-drop').width();

    if (mypageWidth == 0) {
        $('#mypage-drop').animate({ width: '250' }, 1000);

    } else {
        $('#mypage-drop').animate({ width: '0' }, 1000);
    }



})