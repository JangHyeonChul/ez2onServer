$('document').ready(function () {
    const musicNumber = $('.music_num').text();
    var number = typeof musicNumber;
    console.log(number);

    $.ajax({
        url : '/comment/pagenation',
        type : 'POST',
        contentType: 'application/json',
        dataType: 'text',
        data : JSON.stringify({
            'musicNumber' : musicNumber
        }),

        success: function (data) {
            var dataJSON = JSON.parse(data);
            var a = '';
            var totalCnt = dataJSON[1].comment_cnt;
            var pageSize = 10;
            var naviSize = 10;
            var totalPage = Math.ceil(totalCnt / pageSize)
            var page = 1;
            var beginPage = (page-1) / naviSize * naviSize + 1;
            var endPage = Math.min(beginPage + naviSize-1, totalPage);
            var showPrev;
            var showNext;

            if (beginPage != 1) {
                showPrev = true;
            } else if (endPage != totalPage) {
                showNext = true;
            }
            // boolean showNext;

            for (var num = beginPage; num <= endPage; num++) {
                if (num == 2) {
                    a += '<a class="comment-pagenav-item" ' +
                        'onclick="commentPage(' + musicNumber + ', ' + num +','+ pageSize +')">' + num + '</a>'
                }else {
                    a += '<a class="comment-pagenav-item" ' +
                        'onclick="commentPage(' + musicNumber + ', ' + num +','+ pageSize +')">' + num + '</a>'
                }
            }
            $('.comment-pagenav').html(a);
        }

    })
})


function commentPage(board_id, pageNum, pageSize) {
    var offset = (pageNum - 1) * pageSize;
    console.log(offset);

    var commentRequestMap = {
        board_id: board_id,
        offset: offset,
    }

    $.ajax({
        url : '/comment/page',
        type : 'POST',
        contentType: 'application/json',
        dataType: 'text',
        data : JSON.stringify(commentRequestMap),

        success: function (data) {
            var dataJSON = JSON.parse(data);
            var commentBox = $('.comment');
            commentBox.empty();
            console.log(dataJSON);

            $.each(dataJSON, function (index, commentList) {
                drawPagingComment(commentList, commentBox);
            })
        }
    });
}

function drawPagingComment(commentList, commentBox) {
    commentBox.append(
        ' <div class="comment-box">' +
        '<p> ' + commentList.co_content  + '</p>'+
        '<div class="comment-footer">'+
        '<p> 평가 난이도 : ' + commentList.co_level +'/100</p>'+
        '</div>'+
        ' </div>'
    );
}

