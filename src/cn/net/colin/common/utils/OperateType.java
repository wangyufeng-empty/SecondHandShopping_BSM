package cn.net.colin.common.utils;

/**
 * 日志操作类型
 */
public enum OperateType {

    SAVE(1,"数据保存"),
    UPDATE(2,"数据更新"),
    DELETE(3,"数据删除"),
    SELECT(4,"数据查看");

    private Integer code;
    private String desc;
    OperateType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return this.code;
    }
    public String getDesc(){
        return this.desc;
    }



}
