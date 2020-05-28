var usertable;
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
function userSaveOrUpdateSuccess(){
    layui.use('layer', function() {
        var layer = layui.layer;
        layer.closeAll('iframe'); //关闭弹框
    });
    search();
}
$(function(){
    layui.use([ 'layer', 'table','form'], function(){
        var layer = layui.layer //弹层
            ,table = layui.table //表格
            ,form = layui.form //表格

        //执行一个 table 实例
        usertable = table.render({
            id: 'usertable'
            ,elem: '#userlist'
            ,height: "full-135"
            ,limit:10
            ,method:'GET'
            ,url: Common.ctxPath+'userInfo/userInfoDataList' //数据接口
            ,parseData :parseDataFun
            ,title: '用户信息表'
            ,page: true //开启分页
            ,toolbar: '#info_toolbar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,defaultToolbar: ['filter', 'print']
            ,totalRow: false //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'userId', title: '学号'}
                ,{field: 'userName', title: '用户名'}
                ,{field: 'userSex', title: '性别'}
                ,{field: 'userGrade', title: '年级'}
                ,{field: 'userTel', title: '电话号码'}
                ,{field: 'userEmail', title: '邮箱'}
                ,{field: 'accountState', title: '账号状态',templet: function(d){
                    if(d.accountState == 1){
                        return "正常";
                    }else if(d.accountState == 0){
                        return "封禁";
                    }
                }}
                ,{fixed: 'right',  align:'center', toolbar: '#barUserlist',width:180}
            ]]
        });


        //监听头工具栏事件
        table.on('toolbar(usertable)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.open({
                        title:"用户添加",
                        type: 2,
                        area: ['75%','90%'],
                        btn: ['保存', '取消'],
                        content: Common.ctxPath+'userInfo/user',
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
                                ids+=data[i].userId
                            }else{
                                ids+=data[i].userId+',';
                            }
                        }
                        Common.openConfirm("确定删除吗?",function () {
                            Common.ajax('userInfo/user/'+ids,null,true,'DELETE',search);
                        });
                    }
                    break;
                case 'export':
                    var params = '';
                    var userName = $('#userName').val();
                    if(!$.isEmpty(userName)){
                        userName = encodeURI(encodeURI(userName));
                        params += "?userName="+userName;
                    }
                    var userSex = $('#userSex').val();
                    if(!$.isEmpty(userSex)){
                        userSex = encodeURI(encodeURI(userSex));
                        if(!$.isEmpty(params)){
                            params += "&userSex="+userSex;
                        }else{
                            params += "?userSex="+userSex;
                        }
                    }
                    var userGrade = $('#userGrade').val();
                    if(!$.isEmpty(userGrade)){
                        userGrade = encodeURI(encodeURI(userGrade));
                        if(!$.isEmpty(params)){
                            params += "&userGrade="+userGrade;
                        }else{
                            params += "?userGrade="+userGrade;
                        }
                    }
                    var userTel = $('#userTel').val();
                    if(!$.isEmpty(userTel)){
                        if(!$.isEmpty(params)){
                            params += "&userTel="+userTel;
                        }else{
                            params += "?userTel="+userTel;
                        }
                    }
                    window.location.href=Common.ctxPath+'userInfo/exportExcel'+params;
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(usertable)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
            } else if(layEvent === 'del'){
                Common.openConfirm("确定删除吗?",function () {
                    Common.ajax('userInfo/user/'+data.userId,null,true,'DELETE',search);
                })
            } else if(layEvent === 'edit'){
                layer.open({
                    title:"更新用户信息",
                    type: 2,
                    area: ['75%','90%'],
                    btn: ['修改', '取消'],
                    content: Common.ctxPath+'userInfo/user/'+data.userId,
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
                    title: '用户详情',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['75%','90%'],
                    content: Common.ctxPath+'userInfo/user/'+data.userId
                });
            }
        });
        $("#chongzhi").click(function () {
            layui.use(['form'], function(){
                var form = layui.form;
                $("#userName").val("");
                $("#userSex").val("");
                $("#userGrade").val("");
                $("#userTel").val("");
                form.render();
            });
        });
    });
});
function search(){
    var whereParam = {};
    var userName = $('#userName').val();
    if(!$.isEmpty(userName)){
        whereParam.userName = userName;
    }
    var userSex = $('#userSex').val();
    if(!$.isEmpty(userSex)){
        whereParam.userSex = userSex;
    }
    var userGrade = $('#userGrade').val();
    if(!$.isEmpty(userGrade)){
        whereParam.userGrade = userGrade;
    }
    var userTel = $('#userTel').val();
    if(!$.isEmpty(userTel)){
        whereParam.userTel = userTel;
    }
    usertable.reload({
        page: {
            curr: 1 //重新从第 1 页开始
        }
        ,where: whereParam
    });
}