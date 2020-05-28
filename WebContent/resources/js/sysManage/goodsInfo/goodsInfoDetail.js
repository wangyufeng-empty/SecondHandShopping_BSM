$(function(){
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;
        //图片轮播
        carousel.render({
            elem: '#test10'
            ,width: '100%'
            ,height: '450px'
            ,interval: 3000
        });
    });
});

function homePageChange(goodsId,homepageShow,idAuto){
    var params = {};
    params.goodsId = goodsId;
    params.homepageShow = homepageShow;
    params.goodsPictureId = idAuto;
    Common.ajax('goodsInfo/homePageChange',params,true,'POST',pageReload);
}

function pageReload(data){
    location.reload();
}