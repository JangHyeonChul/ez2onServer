function comment(musicNumber) {
    var text = $("#commentText").val();
    var level = $("#commentLevel").val();

    var commentMap = {
        musicnumber: musicNumber,
        content: text,
        level: level
    }

    var errorMap = commentValid(text, level);

    if (errorMap.size != 0) {
        $(".comment-error-message").text(errorMap.get("errorMessage"));
        return 0;
    }

    $(".comment-error-message").text("");

    $.ajax({
        type : 'post',
        url : '/comment',
        contentType: 'application/json',
        data : JSON.stringify(commentMap),

        success: function (data) {
            var commentBox = $('.comment');
            var commentInput = $('#commentText');
            var commentlevel = $('#commentLevel');
            commentBox.empty();

                $.each(data, function (index, commentList) {

                    drawComment(commentList, commentBox);
                })



            commentInput.val("");
            commentlevel.val("");

        }
    })

    function drawComment(commentList, commentBox) {
        commentBox.append(
            ' <div class="comment-box">' +
            '<p> ' + commentList.co_content  + '</p>'+
            '<div class="comment-footer">'+
            '<p> 평가 난이도 : ' + commentList.co_level +'/100</p>'+
            '</div>'+
            ' </div>'
        );
    }

    function commentValid(text, level) {
        var errorMap = new Map();

        if (text == "") {
            errorMap.set("errorMessage", "댓글 내용이 비어있거나 난이도평가를 내리지 않았습니다");
        }

        if (level == "") {
            errorMap.set("errorMessage", "댓글 내용이 비어있거나 난이도평가를 내리지 않았습니다");
        }
        return errorMap;
    }

}

function commentlevelMax(number) {
    if (number > 101) {
        $("#commentLevel").val(100);
    }

    if (number < 0) {
        $("#commentLevel").val(0);
    }
}

