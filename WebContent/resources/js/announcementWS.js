var identifier = $("#identifier").val();
var baseWsPath = $("#baseWsPath").val();
var socket = null;  // 判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    socket = new WebSocket("ws://"+baseWsPath+"/BWS/"+identifier);
} else {
    alert('该浏览器不支持本系统即时通讯功能，推荐使用谷歌或火狐浏览器！');
}
// 连接成功建立的回调方法
socket.onopen = function(event) {
    console.log("ws连接成功!");
}
// 连接发生错误的回调方法
socket.onerror = function() {
    console.log("ws连接失败!");
};
// 接收到消息的回调方法
socket.onmessage = function(res) {
    console.log("ws收到消息啦:" +res.data);
    layui.use([ 'layer'], function(){
        var layer = layui.layer; //弹层
        var contenthtml ='<div><p style="font-size: 16px;padding: 10px;">'+res.data+'</p></div>';
        layer.open({
            id:'announcement',
            skin: 'layui-layer-lan',
            offset:'rb',
            type: 1 //Page层类型
            ,area: ['320px', '200px']
            ,title: '<span class="ssdtitle">公告</span>'
            ,shade: 0 //遮罩透明度
            //,maxmin: true //允许全屏最小化
            //,anim: 1 //0-6的动画形式，-1不开启
            ,content: contenthtml
            ,resize: false
        });
    });
}
// 连接关闭的回调方法
socket.onclose = function() {
    console.log("ws关闭连接!");
}
$(window).on('beforeunload',function(){
    socket.close();
});