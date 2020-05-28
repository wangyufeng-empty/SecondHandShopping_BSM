$(function(){
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(save)', function(data){
            if(data.field.announcementId==null||data.field.announcementId==''){
                Common.ajax('announcement/announcement',$("#form1").serialize(),true,'POST',announcementSaveSuccess);
            }else{
                Common.ajax('announcement/announcement',$("#form1").serialize(),true,'PUT',announcementSaveSuccess);
            }
            return false;
        });
    });
});
function announcementSaveSuccess(data){
    parent.announcementSaveOrUpdateSuccess();
}