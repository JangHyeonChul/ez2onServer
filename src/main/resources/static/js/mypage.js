$('#mypage').click(function () {
    var mypageWidth = $('#mypage-drop').width();

    if (mypageWidth == 0) {
        $('#mypage-drop').animate({ width: '90' }, 500);

    } else {
        $('#mypage-drop').animate({ width: '0' }, 500);
    }



})