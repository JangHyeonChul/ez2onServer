$('document').ready(function () {
   drawTotalRank();
})

function totalRankBtn() {
    drawTotalRank();
}

function moveItemInfo(re_num) {
    window.location.href = '/music/' + re_num;
    console.log(re_num);
}
