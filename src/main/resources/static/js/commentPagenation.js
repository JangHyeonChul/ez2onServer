$('document').ready(function () {
    const musicNumber = $('.music_num').text();

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
            var prev = '';
            var next = '';
            var totalCnt = dataJSON[1].comment_cnt;
            var pageSize = 10;
            var naviSize = 10;
            var totalPage = Math.ceil(totalCnt / pageSize)
            var page = 1;
            var beginPage = (Math.floor(((page-1) / naviSize)) * naviSize) + 1;
            var endPage = Math.min(beginPage + naviSize-1, totalPage);



            if (beginPage != 1 && page != 1) {
                prev += '<a class="comment-pagenav-item" ' +
                    'onclick="commentPage(' + musicNumber + ', ' + (page-1) +','+ pageSize +')">' + "이전" + '</a>'
            }

            if (endPage != totalPage && page != totalPage) {
                next += '<a class="comment-pagenav-item" ' +
                    'onclick="commentPage(' + musicNumber + ', ' + (page + 1) + ',' + pageSize + ')">' + "다음" + '</a>'
            }

            for (var num = beginPage; num <= endPage; num++) {
                if (num == page) {
                    a += '<a style="color: red" class="comment-pagenav-item" ' +
                        'onclick="commentPage(' + musicNumber + ', ' + num +','+ pageSize +')">' + num + '</a>'
                }else {
                    a += '<a class="comment-pagenav-item" ' +
                        'onclick="commentPage(' + musicNumber + ', ' + num +','+ pageSize +')">' + num + '</a>'
                }
            }
            $('.pageitem').html(a);
            $('.prev').html(prev);
            $('.next').html(next);
        }

    })
})


function commentPage(board_id, pageNum, pageSize) {
    const musicNumber = $('.music_num').text();
    var offset = (pageNum - 1) * pageSize;

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
            var commentBox = $('.comment');
            var dataJSON = JSON.parse(data);
            var a = '';
            var prev = '';
            var next = '';
            var totalCnt = dataJSON[1].comment_cnt;
            var pageSize = 10;
            var naviSize = 10;
            var totalPage = Math.ceil(totalCnt / pageSize)
            var page = pageNum;
            var beginPage = (Math.floor(((page-1) / naviSize)) * naviSize) + 1;
            var endPage = Math.min(beginPage + naviSize-1, totalPage);

            if (beginPage != 1 && page != 1) {
                prev += '<a class="comment-pagenav-item" ' +
                    'onclick="commentPage(' + musicNumber + ', ' + (page-1) +','+ pageSize +')">' + "이전" + '</a>'
            }

            if (endPage != totalPage && page != totalPage) {
                next += '<a class="comment-pagenav-item" ' +
                    'onclick="commentPage(' + musicNumber + ', ' + (page + 1) + ',' + pageSize + ')">' + "다음" + '</a>'
            }

            for (var num = beginPage; num <= endPage; num++) {
                if (num == pageNum) {
                    a += '<a style="color: red;" class="comment-pagenav-item" ' +
                        'onclick="commentPage(' + musicNumber + ', ' + num +','+ pageSize +')">' + num + '</a>'
                }else {
                    a += '<a class="comment-pagenav-item" ' +
                        'onclick="commentPage(' + musicNumber + ', ' + num +','+ pageSize +')">' + num + '</a>'
                }
            }
            $('.pageitem').html(a);
            $('.prev').html(prev);
            $('.next').html(next);
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

