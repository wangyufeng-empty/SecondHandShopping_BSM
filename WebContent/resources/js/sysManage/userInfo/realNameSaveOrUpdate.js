$(function(){
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(save)', function(data){
            if(data.field.id==null||data.field.id==''){
                Common.ajax('userInfo/realName',$("#form1").serialize(),true,'POST',realNameSaveSuccess);
            }else{
                Common.ajax('userInfo/realName',$("#form1").serialize(),true,'PUT',realNameSaveSuccess);
            }
            return false;
        });
    });
});
function realNameSaveSuccess(data){
    parent.realNameSaveOrUpdateSuccess();
}