package cn.net.colin.common.utils;

/**
 * 日志类型
 */
public enum LogType {

    SYSTEM(1,"系统日志"),
    BUSINESS(2,"业务日志");

    private Integer code;
    private String  desc;

    LogType(Integer code,String desc){
        this.code=code;
        this.desc = desc;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

}
