var realNameTable;
//定义处理数据结构转化的适配器
var parseDataFun = function (res){
    return {
        "code": res.code
        , "message": res.msg
        , "data": res.data
        , "count": res.total
    };
};

/**
 * 保存或者更新成功后回调
 */
function realNameSaveOrUpdateSuccess(){
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.closeAll('iframe'); //关闭弹框
    });
    search();
}
$(function(){
    layui.use([ 'layer', 'table','form','upload'], function(){
        var layer = layui.layer //弹层
            ,table = layui.table //表格
            ,form = layui.form //表格
            ,upload = layui.upload; //上传

        //执行一个 table 实例
        realNameTable = table.render({
            id: 'realNameTable'
            ,elem: '#realNameList'
            ,height: "full-135"
            ,limit:10
            ,method:'GET'
            ,url: Common.ctxPath+'userInfo/realNameDataList' //数据接口
            ,parseData :parseDataFun
            ,title: '用户信息表'
            ,page: true //开启分页
            ,toolbar: '#info_toolbar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,defaultToolbar: ['filter', 'print']
            ,totalRow: false //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'studentId', title: '学号'}
                ,{field: 'studentName', title: '姓名'}
                ,{fixed: 'right',  align:'center', toolbar: '#barRealNamelist',width:180}
            ]]
        });


        //监听头工具栏事件
        table.on('toolbar(realNameTable)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.open({
                        title:"添加实名用户",
                        type: 2,
                        area: ['40%','40%'],
                        btn: ['保存', '取消'],
                        content: Common.ctxPath+'userInfo/realName',
                        yes: function(index,layero){
                            // 获取iframe层的body
                            var body = layer.getChildFrame('body', index);
                            // 找到隐藏的提交按钮模拟点击提交
                            body.find('#permissionSubmit').click();
                        }
                    });
                    break;
                case 'delete':
                    if(data.length === 0){
                        Common.info("请至少选择一行");
                    } else {
                        var ids = "";
                        for(var i=0;i<data.length;i++){
                            if(i == data.length - 1){
                                ids+=data[i].studentId
                            }else{
                                ids+=data[i].studentId+',';
                            }
                        }
                        Common.openConfirm("确定删除吗?",function () {
                            Common.ajax('userInfo/realName/'+ids,null,true,'DELETE',search);
                        });
                    }
                    break;
                case 'export':
                    var params = '';
                    var studentName = $('#studentName').val();
                    if(!$.isEmpty(studentName)){
                        studentName = encodeURI(encodeURI(studentName));
                        params += "?studentName="+studentName;
                    }
                    var studentId = $('#studentId').val();
                    if(!$.isEmpty(studentId)){
                        if(!$.isEmpty(params)){
                            params += "&studentId="+studentId;
                        }else{
                            params += "?studentId="+studentId;
                        }
                    }
                    window.location.href=Common.ctxPath+'userInfo/exportRealNameExcel'+params;
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(realNameTable)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
            } else if(layEvent === 'del'){
                Common.openConfirm("确定删除吗?",function () {
                    Common.ajax('userInfo/realName/'+data.studentId,null,true,'DELETE',search);
                })
            } else if(layEvent === 'edit'){
                layer.open({
                    title:"更新实名信息",
                    type: 2,
                    area: ['40%','40%'],
                    btn: ['修改', '取消'],
                    content: Common.ctxPath+'userInfo/realName/'+data.studentId,
                    yes: function(index,layero){
                        // 获取iframe层的body
                        var body = layer.getChildFrame('body', index);
                        // 找到隐藏的提交按钮模拟点击提交
                        body.find('#permissionSubmit').click();

                    }
                });
            }else if(layEvent === 'details'){
                layer.open({
                    type: 2,
                    title: '实名信息详情',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['40%','40%'],
                    content: Common.ctxPath+'userInfo/realName/'+data.studentId
                });
            }
        });
        $("#chongzhi").click(function () {
            layui.use(['form'], function(){
                var form = layui.form;
                $("#studentId").val("");
                $("#studentName").val("");
                form.render();
            });
        });
        initImport();
    });
});
function search(){
    var whereParam = {};
    var studentId = $('#studentId').val();
    if(!$.isEmpty(studentId)){
        whereParam.studentId = studentId;
    }
    var studentName = $('#studentName').val();
    if(!$.isEmpty(studentName)){
        whereParam.studentName = studentName;
    }
    realNameTable.reload({
        page: {
            curr: 1 //重新从第 1 页开始
        }
        ,where: whereParam
    });
    initImport();
}

function initImport(){
    layui.use([ 'layer', 'table','form','upload'], function(){
        var layer = layui.layer //弹层
            ,upload = layui.upload; //上传
        upload.render({
            elem: '#importFile'
            ,url: Common.ctxPath+'userInfo/importRealName'
            ,accept: 'file' //普通文件Ev
            ,exts: 'xlsx|xls'
            ,before: function () {
                layer.load();
            }
            ,done: function(res){
                layer.closeAll('loading'); //关闭loading
                if(res.code == 0){
                    layer.msg("导入完成");
                }else{
                    layer.msg(res.msg);
                }
                search();
            }
            ,error: function(index, upload){
                layer.closeAll('loading'); //关闭loading
                layer.msg("请求失败！");
            }
        });
    });
}