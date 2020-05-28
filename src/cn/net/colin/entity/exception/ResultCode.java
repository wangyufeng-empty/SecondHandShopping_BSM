package cn.net.colin.entity.exception;

/**
 * Created by sxf on 2019-5-15.
 * 错误码
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("0", "操作成功!"),
    FAILED("-1","操作失败"),
    UPLOADSUCCESS("1", "上传成功!"),
    REPETITION("-2","该数据已存在，请重新填写！！"),
    NODATA("-3", "空数据"),
    /**未知错误*/
    UNKNOWN_ERROR("0x10001", "系统异常请与管理员联系！"),

    USERNAME_EMPTY("0x10002", "用户名不能为空"),

    PASSWORD_EMPTY("0x10003", "密码不能为空"),

    USERNAME_ERROR("0x10004", "用户名错误或不存在"),

    PASSWORD_ERROR("0x10005", "密码错误"),

    LOGIN_ERROR("0x10006", "用户名或密码错误");




    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;


    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}