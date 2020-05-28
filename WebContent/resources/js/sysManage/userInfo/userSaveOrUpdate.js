$(function(){
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(save)', function(data){
            if(data.field.id==null||data.field.id==''){
                Common.ajax('userInfo/user',$("#form1").serialize(),true,'POST',userSaveSuccess);
            }else{
                Common.ajax('userInfo/user',$("#form1").serialize(),true,'PUT',userSaveSuccess);
            }
            return false;
        });
    });
});
function userSaveSuccess(data){
    parent.userSaveOrUpdateSuccess();
}