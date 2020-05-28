package cn.net.colin.entity.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by sxf on 2019-5-15.
 * 统一的返回结果类
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ApiResult implements Serializable{
    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;

    /**
     * 返回记录条数
     */
    private Long total;

    /**
     * 返回结果数据
     */
    private Object data;


    public ApiResult() {

    }

    public ApiResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public ApiResult(ResultCode resultCode, Object data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
    public ApiResult(ResultCode resultCode, Object data, Long total){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
        this.total = total;
    }

    /**
     * 生成一个ApiResult对象, 并返回
     *
     * @param resultCode
     * @return
     */
    public static ApiResult of(ResultCode resultCode) {
        return new ApiResult(resultCode);
    }

    /**
     * 生成一个ApiResult对象， json返回格式
     * @param resultCode
     * @param data
     * @return
     */
    public static ApiResult ofJson(ResultCode resultCode,Object data){
        return new ApiResult(resultCode, data);
    }

    /**
     * 生成一个带返回结果和返回结果条数的ApiResult对象
     * @param resultCode
     * @param data
     * @return
     */
    public static ApiResult ofDataAndTotal(ResultCode resultCode, Object data, long total){
        return new ApiResult(resultCode, data,total);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}