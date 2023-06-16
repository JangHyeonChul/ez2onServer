function comment(musicNumber) {
    var commentMap = {
        musicnumber: musicNumber,
        content: $("#commentText").val(),
        level: $("#commentLevel").val()
    }

    console.log(JSON.stringify(commentMap));

    $.ajax({
        type : 'post',
        url : '/comment',
        contentType: 'application/json',
        data : JSON.stringify(commentMap),

        success: function (data) {
            console.log("성공")
        }
    })

}