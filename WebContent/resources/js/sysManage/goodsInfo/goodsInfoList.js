var goodstable;
//定义处理数据结构转化的适配器
var parseDataFun = function (res){
    return {
        "code": res.code
        , "message": res.msg
        , "data": res.data
        , "count": res.total
    };
};

$(function(){
    layui.use([ 'layer', 'table','form'], function(){
        var layer = layui.layer //弹层
            ,table = layui.table //表格
            ,form = layui.form //表格

        //执行一个 table 实例
        goodstable = table.render({
            id: 'goodstable'
            ,elem: '#goodslist'
            ,height: "full-135"
            ,limit:10
            ,method:'GET'
            ,url: Common.ctxPath+'goodsInfo/goodsInfoDataList' //数据接口
            ,parseData :parseDataFun
            ,title: '商品信息表'
            ,page: true //开启分页
            ,toolbar: '#info_toolbar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,defaultToolbar: ['filter', 'print']
            ,totalRow: false //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'goodsName', title: '商品名称'}
                ,{field: 'goodsPublisher', title: '发布人'}
                ,{field: 'goodsCategory', title: '商品类别'}
                ,{field: 'goodsPrice', title: '商品价格'}
                ,{field: 'goodsStock', title: '库存'}
                ,{field: 'goodsIssudate', title: '发布日期'}
                ,{fixed: 'right',  align:'center', toolbar: '#barGoodslist',width:180}
            ]]
        });


        //监听头工具栏事件
        table.on('toolbar(goodstable)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'delete':
                    if(data.length === 0){
                        Common.info("请至少选择一行");
                    } else {
                        var ids = "";
                        for(var i=0;i<data.length;i++){
                            if(i == data.length - 1){
                                ids+=data[i].goodsId
                            }else{
                                ids+=data[i].goodsId+',';
                            }
                        }
                        Common.openConfirm("确定删除吗?",function () {
                            Common.ajax('goodsInfo/goods/'+ids,null,true,'DELETE',search);
                        });
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(goodstable)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
            } else if(layEvent === 'del'){
                Common.openConfirm("确定删除吗?",function () {
                    Common.ajax('goodsInfo/goods/'+data.goodsId,null,true,'DELETE',search);
                })
            } else if(layEvent === 'details'){
                layer.open({
                    type: 2,
                    title: '商品详情',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['75%','90%'],
                    content: Common.ctxPath+'goodsInfo/infoDetail/'+data.goodsId
                });
            }
        });
        $("#chongzhi").click(function () {
            layui.use(['form'], function(){
                var form = layui.form;
                $("#queryStr").val("");
                $("#homepageShow").val("");
                form.render();
            });
        });
    });
});
function search(){
    var whereParam = {};
    var queryStr = $('#queryStr').val();
    if(!$.isEmpty(queryStr)){
        whereParam.queryStr = queryStr;
    }
    var homepageShow = $('#homepageShow').val();
    if(!$.isEmpty(homepageShow)){
        whereParam.homepageShow = homepageShow;
    }
    goodstable.reload({
        page: {
            curr: 1 //重新从第 1 页开始
        }
        ,where: whereParam
    });
}