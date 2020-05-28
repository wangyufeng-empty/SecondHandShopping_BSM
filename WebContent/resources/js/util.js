/**
 * js工具类
 */
/**
 * 缓存用户信息以及地区信息
通过 sessionStorage["area"]的方式获取
 */

function getRootPath(){
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    if (webName == "") {
        return window.location.protocol + '//' + window.location.host;
    }
    else {
        return window.location.protocol + '//' + window.location.host + '/' + webName;
    }

}
function cacheCurrentUserAndAreaInfo(){
    var rootPath =getRootPath();
    $.ajax({
        url:rootPath+"/sysarea/currUserInfo",
        async: false,
        success:function(result){

            if(result){
                var area = result.area;
                var user = result.user;
                if(area){
                    window.sessionStorage.setItem("area",JSON.stringify(area));
                }
                if(user) {
                    window.sessionStorage.setItem("user", JSON.stringify(user));
                }
            }


        }
    });

    $.ajax({
        url:rootPath+"/sysarea/allAreas",
        success:function(result){

            if(result){
                sessionStorage.setItem("allAreas",JSON.stringify(result));
            }
        }
    });
    //省级
    $.ajax({
        url:rootPath+"/sysarea/allAreas",
        data:{'level':1},
        success:function(result){

            if(result){
                sessionStorage.setItem("provinces",JSON.stringify(result));
            }
        }
    });
    //市级
    $.ajax({
        url:rootPath+"/sysarea/allAreas",
        data:{'level':3},
        success:function(result){
            if(result){
                sessionStorage.setItem("citys",JSON.stringify(result));
            }
        }
    });
    //县区级
    $.ajax({
        url:rootPath+"/sysarea/allAreas",
        data:{'level':4},
        success:function(result){

            if(result){
                sessionStorage.setItem("countys",JSON.stringify(result));
            }
        }
    });
    //社区/街道
    $.ajax({
        url:rootPath+"/sysarea/allAreas",
        data:{'level':5},
        success:function(result){

            if(result){
                sessionStorage.setItem("towns",JSON.stringify(result));
            }
        }
    });

    $.ajax({
        url:rootPath+"/sysarea/ztree",
        data:{"parent":"1"},
        success:function(result){

            if(result){

                sessionStorage.setItem("areaZtree",JSON.stringify(result));

                // console.log(sessionStorage["areaZtree"])

            }


        }
    });

    $.ajax({
        url:rootPath+"/dic/allDic",

        success:function(result){

            if(result){
                sessionStorage.setItem("dic",JSON.stringify(result));
                // console.log(sessionStorage["areaZtree"])
            }


        }
    });

    $.ajax({
        url:rootPath+"/dic/disTypeZtree",

        success:function(result){
            if(result){
                sessionStorage.setItem("disTypeZtree",JSON.stringify(result));
                // console.log(sessionStorage["areaZtree"])
            }


        }
    });
}

function getAreaNameByCode(areaCode){
    var allAreas = sessionStorage["allAreas"];
    if(allAreas){
        var areas=JSON.parse(allAreas);
        return areas[areaCode];
    }
    return null;
}
function getAreaNameByCodeProvinces(areaCode){
    var allAreas = sessionStorage["provinces"];
    if(allAreas){
        var areas=JSON.parse(allAreas);
        return areas[areaCode];
    }
    return null;
}
function getAreaNameByCodeCitys(areaCode){
    var allAreas = sessionStorage["citys"];
    if(allAreas){
        var areas=JSON.parse(allAreas);
        return areas[areaCode];
    }
    return null;
}
function getAreaNameByCodeCountys(areaCode){
    var allAreas = sessionStorage["countys"];
    if(allAreas){
        var areas=JSON.parse(allAreas);
        return areas[areaCode];
    }
    return null;
}
function getAreaNameByCodeTowns(areaCode){
    var allAreas = sessionStorage["towns"];
    if(allAreas){
        var areas=JSON.parse(allAreas);
        return areas[areaCode];
    }
    return null;
}
function getAreaNamsByCodes(codes){
    var allAreas = sessionStorage["allAreas"];
    var names =new Array();
    if(allAreas){
        var areas=JSON.parse(allAreas);
        var cc =codes.split(",")
        for(var i=0;i<cc.length;i++){
            //mod by lsz 判断cc[i]的长度是否大于12位，大于12位截取12位字符
            var code = cc[i];
            if(code.length>12){
                code = code.substring(0,12);
            }
            names.push(areas[code]);
        }
        return names.join(",");
    }
    return "";
}

function getDisTypeByCodes(codes){
    var alldis = sessionStorage["disTypeZtree"];
    var names =new Array();
    if(alldis){
        var areas=JSON.parse(alldis);
        var cc =codes.split(",")
        for(var i=0;i<cc.length;i++){
            var key = areas.find(function(e){return e.id==cc[i]});
            names.push(key.name);
        }
        return names.join(",");
    }
    return "";
}

/**
 * 从内存中读取字典值
 * @param code 字典keycode
 * @param pcode 父节点code
 */
function getDicTionaryByCode(code,pcode){
    var dics = sessionStorage["dic"];
    if(dics){
        var dic=JSON.parse(dics);
        var args = dic.filter(function(e){return e.parentCode==pcode});
        var key = args.find(function(e){return e.keyCode==code});
        if(key != null){
            return key.keyValue;
        }
        return code;
    }
    return code;
}

/**
 *
 * @param code
 * @param pcode
 * @returns {null|*}
 */
function getDisasterByCode(code){
    var dis = sessionStorage["disTypeZtree"];
    if(dis){
        var dic=JSON.parse(dis);
        var key = dic.find(function(e){return e.id==code});
        if (key == undefined){
            return "数据有误！！！";
        }else{
            return key.name;
        }
    }
    return null;
}

/**
 * 获取当前登录用户信息
 */
function getCurrentUser(){

    var user =sessionStorage["user"];

    return JSON.parse(user);

}

/**
 * 获取当前登录用户所在的地区信息
 */
function getCurrentUserArea(){
    var area = sessionStorage["area"];
    return JSON.parse(area);
}
/**
 * 城市选择下拉框
 * @param currentCode
 * @param cityTypes 0 国家  1 省 2 直辖市  3 地级市 4 县 5 乡/镇 6 村
 * @param selectId 下拉选择框ID
 */
var cityOptions = function (selectCode,cityTypes,selectId) {
    var selectEle= $("#"+selectId).empty();
    var rootPath =getRootPath();
    $.ajax({
        url:rootPath+"/sysarea/currCities",
        async:false,
        success:function(result){

            if(result && result.length>0){
                for(var i=0;i<result.length;i++){
                    var d = result[i];
                    var code = d.areaCode;
                    if(code ==selectCode){
                        $("<option value ='"+code+"' selected>"+d.areaName+"</option>").appendTo(selectEle);
                    }else{
                        $("<option value ='"+code+"' >"+d.areaName+"</option>").appendTo(selectEle);

                    }
                }
            }


        }
    });

}
/**
 *通过父节点地区编码获取下级城市
 * @param parentCode 父节点地区编码
 * @param selectIde  下拉选择框的ID
 * @param defaultCode 默认选中的地区
 */
var cityChildrenOptions =function (parentCode,selectId,defaultCode){
    var selectEle= $("#"+selectId).empty();
    var rootPath =getRootPath();
    $.ajax({
        url:rootPath+"/sysarea/getAreasByParentCode",
        data:{parentCode:parentCode},
        async:false,
        success:function(result){

            if(result && result.length>0){
                for(var i=0;i<result.length;i++){
                    var d = result[i];
                    var code = d.areaCode;
                    if(code ==defaultCode){
                        $("<option value ='"+code+"' selected>"+d.areaName+"</option>").appendTo(selectEle);
                    }else{
                        $("<option value ='"+code+"' >"+d.areaName+"</option>").appendTo(selectEle);
                    }
                }
            }


        }
    });
}



/*var areaSelect = function (citySelect,countySelect,townSelect,cityCode,countyCode,townCode) {
    var rootPath =getRootPath();
    $.ajax({
        url:rootPath+"/sysarea/getAreaSelect",
        success:function(result){
            if(result == null){
                alert("无法获取地区信息!请联系管理员");
                return false;
            }
            if(null != result.city){
                //加载市级下拉框
                var o = result.city;
                if(o.length>1){
                    $("<option value =''>请选择</option>").appendTo($("#"+citySelect).empty());
                }
                for(var i=0;i<o.length;i++){
                    var d = o[i];
                    var code = d.areaCode;
                    if(code ==cityCode){
                        $("<option value ='"+code+"' selected>"+d.areaName+"</option>").appendTo($("#"+citySelect).empty());
                    }else{
                        $("<option value ='"+code+"' >"+d.areaName+"</option>").appendTo($("#"+citySelect).empty());
                    }
                }
            }
            if(null != result.county){
                //加载区级下拉框
                var o = result.county;
                if(o.length>1){
                    $("<option value =''>请选择</option>").appendTo($("#"+countySelect).empty());
                }
                for(var i=0;i<o.length;i++){
                    var d = o[i];
                    var code = d.areaCode;
                    if(code ==countyCode){
                        $("<option value ='"+code+"' selected>"+d.areaName+"</option>").appendTo($("#"+countySelect).empty());
                    }else{
                        $("<option value ='"+code+"' >"+d.areaName+"</option>").appendTo($("#"+countySelect).empty());
                    }
                }
            }
            if(null != result.town){
                //加载乡镇下拉框 townCode
                var o = result.county;
                if(o.length>1){
                    $("<option value =''>请选择</option>").appendTo($("#"+townSelect).empty());
                }
                for(var i=0;i<o.length;i++){
                    var d = o[i];
                    var code = d.areaCode;
                    if(code ==townCode){
                        $("<option value ='"+code+"' selected>"+d.areaName+"</option>").appendTo($("#"+townSelect).empty());
                    }else{
                        $("<option value ='"+code+"' >"+d.areaName+"</option>").appendTo($("#"+townSelect).empty());
                    }
                }
            }

        }
    });

}*/


/**
 * 获取字典项
 * @param parentCode 父节点编码
 * @param selectId   下拉框id
 * @param defaultCode 默认值/选中值
 */
var getDictionary = function(parentCode,selectId,defaultCode){
    var selectEle= $("#"+selectId).empty();
    var rootPath =getRootPath();
    $.ajax({
        url:rootPath+"/dic/getDictionary",
        data:{parentCode:parentCode},
        async:false,
        success:function(result){
            if(result && result.length>0){
                for(var i=0;i<result.length;i++){
                    var d = result[i];
                    var code = d.keyCode;
                    if(code ==defaultCode){
                        $("<option value ='"+code+"' selected>"+d.keyValue+"</option>").appendTo(selectEle);
                    }else{
                        $("<option value ='"+code+"' >"+d.keyValue+"</option>").appendTo(selectEle);

                    }
                }
            }


        }
    });

}
var getQueryDictionary = function(parentCode,selectId,defaultCode){
    var selectEle= $("#"+selectId).empty();
    var rootPath =getRootPath();
    $.ajax({
        url:rootPath+"/dic/getDictionary",
        data:{parentCode:parentCode},
        async:false,
        success:function(result){
            if(result && result.length>0){
                $("<option value ='' selected>请选择</option>").appendTo(selectEle);
                for(var i=0;i<result.length;i++){
                    var d = result[i];
                    var code = d.keyCode;
                    if(code ==defaultCode){
                        $("<option value ='"+code+"' >"+d.keyValue+"</option>").appendTo(selectEle);
                    }else{
                        $("<option value ='"+code+"' >"+d.keyValue+"</option>").appendTo(selectEle);

                    }
                }
            }


        }
    });

}


var zTree;
var setting = {
    data : {
        simpleData : {
            enable : true, //设置启用简单数据格式[{id, pId, name}, {id, pId, name}]
            idKey : "id",  //节点数据中保存唯一标识的属性名称
            pIdKey : "pId",  //节点数据中保存其父节点唯一标识的属性名称
            rootPId : null,  //根节点id
            type: "type"
        }
    },
    check: {
        enable: true,   //true / false 分别表示 显示 / 不显示 复选框或单选框
        autoCheckTrigger: true,   //true / false 分别表示 触发 / 不触发 事件回调函数
        chkStyle: "checkbox",   //勾选框类型(checkbox 或 radio）
        chkboxType: { "Y": "s", "N": "s" }   //勾选 checkbox 对于父子节点的关联关系

    }
};


//地区ztree
var layerIdex;
var areaZtreePop =function(treeId,codesId,namesId,checkAreaCodes){
    var data =sessionStorage["areaZtree"];
    if(data){
        var areaInfo = JSON.parse(data);
        zTree=$.fn.zTree.init($("#"+treeId),setting,areaInfo);
        if(checkAreaCodes && checkAreaCodes !=""){
            var  codes = checkAreaCodes.split(",");
            for(var i =0;i<codes.length;i++){
                //mod by lsz 判断cc[i]的长度是否大于12位，大于12位截取12位字符
                var code = codes[i];
                if(code.length>12){
                    code = code.substring(0,12);
                }
                var defaultSelectNode =  zTree.getNodeByParam("id", code);
                if(defaultSelectNode ){
                    zTree.checkNode(defaultSelectNode,true);
                }
            }

        }
        //展开第一个
        var ns =zTree.getNodes();
        if(ns && ns.length>0){
            zTree.expandNode(ns[0], true, false, false);//默认展开第一级节点
        }
        layerIdex = layer.open({
            type: 1,
            title:'选择地区',
            area: ['265px', '350px'],
            shadeClose: true, //点击遮罩关闭
            content: $(".content_wrap"),
            btn:['确定', '取消'],
            yes: function(index, layero){

             // 可用来调用弹出层的函数
                //formWin.doSetSelectedNode(index);
                var checkedNodes = zTree.getCheckedNodes();
                var selectCodes= new Array();
                var selectNames = new Array();
                // mod by lsz 添加最多选择5个乡镇限制
                if(checkedNodes && checkedNodes.length>5){
                    layer.msg("最多选择5个区域!");
                    return;
                }
                if(checkedNodes && checkedNodes.length>0){
                    var code ;
                    for(var i=0;i<checkedNodes.length;i++){
                        var node = checkedNodes[i];
                        if(node.checked){
                            //获取树节点id
                            code = node.id;
                            //判断id是否小于20位，小于20位则位数差补0
                            if (code.length<20) {
                                code = (code+Array(20-code.length+1).join('0'));
                            }
                            selectCodes.push(code);
                            selectNames.push(node.name);
                        }
                    }
                    $("#"+codesId).val(selectCodes.join(","));
                    $("#"+namesId).val(selectNames.join(","));
                    layer.close(layerIdex);
                }else{
                    layer.msg("请选择区域");
                }

            },
            btn2: function(index){
                layer.close(layerIdex);
            }

        });
    }
}


/**
 * 自然灾害类型
 */
var diszTree;
var dissetting = {
    data : {
        simpleData : {
            enable : true, //设置启用简单数据格式[{id, pId, name}, {id, pId, name}]
            idKey : "id",  //节点数据中保存唯一标识的属性名称
            pIdKey : "pId",  //节点数据中保存其父节点唯一标识的属性名称
            rootPId : "00000",  //根节点id
            type: "type"
        }
    },
    check: {
        enable: true,   //true / false 分别表示 显示 / 不显示 复选框或单选框
        autoCheckTrigger: true,   //true / false 分别表示 触发 / 不触发 事件回调函数
        chkStyle: "radio",   //勾选框类型(checkbox 或 radio）
        chkboxType: { "Y": "s", "N": "s" }   //勾选 checkbox 对于父子节点的关联关系
    }
};

var dislayerIdex;
var disTypeZtreePop =function(treeId,codesId,namesId,checkAreaCodes){

    var data =sessionStorage["disTypeZtree"];
    if(data){
        var Info = JSON.parse(data);
        diszTree=$.fn.zTree.init($("#"+treeId),dissetting,Info);
        if(checkAreaCodes && checkAreaCodes !=""){
            var  codes = checkAreaCodes.split(",");
            for(var i =0;i<codes.length;i++){
                var defaultSelectNode =  diszTree.getNodeByParam("id", codes[i]);
                if(defaultSelectNode ){
                    diszTree.checkNode(defaultSelectNode,true);
                }
            }

        }
        //展开第一个
        var ns =diszTree.getNodes();
        if(ns && ns.length>0){
            diszTree.expandNode(ns[0], true, false, false);//默认展开第一级节点
        }
        dislayerIdex = layer.open({
            type: 1,
            title:'选择灾害类型',
            area: ['400px', '400px'],
            shadeClose: true, //点击遮罩关闭
            content: $(".content_wrap_dis"),
            btn:['确定', '取消'],
            yes: function(index, layero){

                // 可用来调用弹出层的函数
                //formWin.doSetSelectedNode(index);
                var checkedNodes = diszTree.getCheckedNodes();
                var selectCodes= new Array();
                var selectNames = new Array();
                // mod by lsz 添加最多选择1个限制
                if(checkedNodes && checkedNodes.length>1){
                    layer.msg("最多选择1个区域!");
                    return;
                }

                //lsz 必须是最后一个节点
                if(checkedNodes.isLastNode == false){
                    layer.msg("只能选择最下级子节点!");
                    return;
                }



                if(checkedNodes && checkedNodes.length>0){
                    for(var i=0;i<checkedNodes.length;i++){
                        var node = checkedNodes[i];
                        //lsz 必须是最后一个节点 children
                        if(node.children !=null && node.children.length>0){
                            layer.msg("只能选择最下级子节点!");
                            return;
                        }
                        if(node.checked){
                            selectCodes.push(node.id);
                            selectNames.push(node.name);
                        }
                    }
                    $("#"+codesId).val(selectCodes.join(","));
                    $("#"+namesId).val(selectNames.join(","));
                    layer.close(dislayerIdex);
                }else{
                    layer.msg("请选择灾害类型");
                }

            },
            btn2: function(index){
                layer.close(dislayerIdex);
            }

        });
    }
}

var closeLayer = function () {

    $("#townCode").val("12131312313")
    // 关闭layer弹出层
    layer.close(layerIdex)
}

var mapLayerIndex;


var showMap =function (lonId,latId,longitude,latitude) {
    var rootPath =getRootPath();

    mapLayerIndex=layer.open({
        type: 2,
        title:'选择经纬度',
        area: ['800px', '100%'],
        shadeClose: true, //点击遮罩关闭
        content: rootPath+"/common/showMap?longitude="+longitude+"&latitude="+latitude,
        btn:['确定', '取消'],
        yes: function(index, layero){


            var body = layer.getChildFrame('body', index); //得到iframe页的body内容

            var longitude = body.find("#longitude").val();
            var latitude = body.find("#latitude").val();
            $("#"+lonId).val(longitude);
            $("#"+latId).val(latitude)

            layer.close(mapLayerIndex);



        },
        btn2: function(index){
            layer.close(mapLayerIndex);
        }

    });
    
}

/**************************************时间格式化处理************************************/
function dateFtt(fmt,date){
    var o = {
        "M+" : date.getMonth()+1,                 //月份
        "d+" : date.getDate(),                    //日
        "h+" : date.getHours(),                   //小时
        "m+" : date.getMinutes(),                 //分
        "s+" : date.getSeconds(),                 //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S"  : date.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

