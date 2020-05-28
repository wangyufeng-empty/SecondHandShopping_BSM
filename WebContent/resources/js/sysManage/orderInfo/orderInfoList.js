var ordertable;
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
        ordertable = table.render({
            id: 'ordertable'
            ,elem: '#orderlist'
            ,height: "full-135"
            ,limit:10
            ,method:'GET'
            ,url: Common.ctxPath+'orderInfo/orderInfoListDataList' //数据接口
            ,parseData :parseDataFun
            ,title: '订单信息表'
            ,page: true //开启分页
            ,defaultToolbar: ['filter', 'print']
            ,totalRow: false //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'userId', title: '下单学号'}
                ,{field: 'orderId', title: '订单号'}
                ,{field: 'consignee', title: '收货人'}
                ,{field: 'telNum', title: '收货人电话'}
                ,{field: 'address', title: '收货地址'}
                ,{field: 'orderTime', title: '下单时间'}
                ,{fixed: 'right',  align:'center', toolbar: '#barOrderlist',width:80}
            ]]
        });

        //监听行工具事件
        table.on('tool(ordertable)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'details'){
                layer.open({
                    type: 2,
                    title: '订单详情',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['75%','90%'],
                    content: Common.ctxPath+'orderInfo/orderInfoDetai/'+data.userId+'/'+data.orderId
                });
            }
        });
        $("#chongzhi").click(function () {
            layui.use(['form'], function(){
                var form = layui.form;
                $("#userId").val("");
                $("#orderId").val("");
                $("#consignee").val("");
                $("#telNum").val("");
                form.render();
            });
        });
    });
});
function search(){
    var whereParam = {};
    var userId = $('#userId').val();
    if(!$.isEmpty(userId)){
        whereParam.userId = userId;
    }
    var orderId = $('#orderId').val();
    if(!$.isEmpty(orderId)){
        whereParam.orderId = orderId;
    }
    var consignee = $('#consignee').val();
    if(!$.isEmpty(consignee)){
        whereParam.consignee = consignee;
    }
    var telNum = $('#telNum').val();
    if(!$.isEmpty(telNum)){
        whereParam.telNum = telNum;
    }
    ordertable.reload({
        page: {
            curr: 1 //重新从第 1 页开始
        }
        ,where: whereParam
    });
}