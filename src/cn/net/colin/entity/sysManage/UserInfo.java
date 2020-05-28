package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 用户信息表 user_info

 * date:2020/04/30 18:43
 */
public class UserInfo implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 4507040690794871517L;

    /** 
     * 用户ID（学号）
     */ 
    private String userId;

    /** 
     * 用户名
     */ 
    private String userName;

    /** 
     * 用户密码
     */ 
    private String userPsw;

    /** 
     * 性别
     */ 
    private String userSex;

    /** 
     * 年级
     */ 
    private String userGrade;

    /** 
     * 爱好
     */ 
    private String userHobby;

    /** 
     * 电话号码
     */ 
    private String userTel;

    /** 
     * 电子邮箱
     */ 
    private String userEmail;

    /** 
     * 用户收货地址
     */ 
    private String userAddress;

    /** 
     * 自我介绍
     */ 
    private String selfIntroduce;

    /** 
     * 对自己的祝福
     */ 
    private String selfBlessing;

    /** 
     * 密保问题为：母亲的姓名
     */ 
    private String userquestionMothername;

    /** 
     * 密保问题为：初恋是谁
     */ 
    private String userquestionFirstlove;

    /** 
     * 注册时间
     */ 
    private String registerTime;

    /** 
     * 账号状态（1为正常，0为被封禁）  默认：1
     */ 
    private Integer accountState;

    /** 
     * 获取 用户ID（学号） user_info.user_id
     * @return 用户ID（学号）
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * 设置 用户ID（学号） user_info.user_id
     * @param userId 用户ID（学号）
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /** 
     * 获取 用户名 user_info.user_name
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /** 
     * 设置 用户名 user_info.user_name
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /** 
     * 获取 用户密码 user_info.user_psw
     * @return 用户密码
     */
    public String getUserPsw() {
        return userPsw;
    }

    /** 
     * 设置 用户密码 user_info.user_psw
     * @param userPsw 用户密码
     */
    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw == null ? null : userPsw.trim();
    }

    /** 
     * 获取 性别 user_info.user_sex
     * @return 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /** 
     * 设置 性别 user_info.user_sex
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    /** 
     * 获取 年级 user_info.user_grade
     * @return 年级
     */
    public String getUserGrade() {
        return userGrade;
    }

    /** 
     * 设置 年级 user_info.user_grade
     * @param userGrade 年级
     */
    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade == null ? null : userGrade.trim();
    }

    /** 
     * 获取 爱好 user_info.user_hobby
     * @return 爱好
     */
    public String getUserHobby() {
        return userHobby;
    }

    /** 
     * 设置 爱好 user_info.user_hobby
     * @param userHobby 爱好
     */
    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby == null ? null : userHobby.trim();
    }

    /** 
     * 获取 电话号码 user_info.user_tel
     * @return 电话号码
     */
    public String getUserTel() {
        return userTel;
    }

    /** 
     * 设置 电话号码 user_info.user_tel
     * @param userTel 电话号码
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    /** 
     * 获取 电子邮箱 user_info.user_email
     * @return 电子邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /** 
     * 设置 电子邮箱 user_info.user_email
     * @param userEmail 电子邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /** 
     * 获取 用户收货地址 user_info.user_address
     * @return 用户收货地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /** 
     * 设置 用户收货地址 user_info.user_address
     * @param userAddress 用户收货地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /** 
     * 获取 自我介绍 user_info.self_introduce
     * @return 自我介绍
     */
    public String getSelfIntroduce() {
        return selfIntroduce;
    }

    /** 
     * 设置 自我介绍 user_info.self_introduce
     * @param selfIntroduce 自我介绍
     */
    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce == null ? null : selfIntroduce.trim();
    }

    /** 
     * 获取 对自己的祝福 user_info.self_blessing
     * @return 对自己的祝福
     */
    public String getSelfBlessing() {
        return selfBlessing;
    }

    /** 
     * 设置 对自己的祝福 user_info.self_blessing
     * @param selfBlessing 对自己的祝福
     */
    public void setSelfBlessing(String selfBlessing) {
        this.selfBlessing = selfBlessing == null ? null : selfBlessing.trim();
    }

    /** 
     * 获取 密保问题为：母亲的姓名 user_info.userQuestion_motherName
     * @return 密保问题为：母亲的姓名
     */
    public String getUserquestionMothername() {
        return userquestionMothername;
    }

    /** 
     * 设置 密保问题为：母亲的姓名 user_info.userQuestion_motherName
     * @param userquestionMothername 密保问题为：母亲的姓名
     */
    public void setUserquestionMothername(String userquestionMothername) {
        this.userquestionMothername = userquestionMothername == null ? null : userquestionMothername.trim();
    }

    /** 
     * 获取 密保问题为：初恋是谁 user_info.userQuestion_firstLove
     * @return 密保问题为：初恋是谁
     */
    public String getUserquestionFirstlove() {
        return userquestionFirstlove;
    }

    /** 
     * 设置 密保问题为：初恋是谁 user_info.userQuestion_firstLove
     * @param userquestionFirstlove 密保问题为：初恋是谁
     */
    public void setUserquestionFirstlove(String userquestionFirstlove) {
        this.userquestionFirstlove = userquestionFirstlove == null ? null : userquestionFirstlove.trim();
    }

    /** 
     * 获取 注册时间 user_info.register_time
     * @return 注册时间
     */
    public String getRegisterTime() {
        return registerTime;
    }

    /** 
     * 设置 注册时间 user_info.register_time
     * @param registerTime 注册时间
     */
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime == null ? null : registerTime.trim();
    }

    /** 
     * 获取 账号状态（1为正常，0为被封禁） user_info.account_state
     * @return 账号状态（1为正常，0为被封禁）
     */
    public Integer getAccountState() {
        return accountState;
    }

    /** 
     * 设置 账号状态（1为正常，0为被封禁） user_info.account_state
     * @param accountState 账号状态（1为正常，0为被封禁）
     */
    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPsw=").append(userPsw);
        sb.append(", userSex=").append(userSex);
        sb.append(", userGrade=").append(userGrade);
        sb.append(", userHobby=").append(userHobby);
        sb.append(", userTel=").append(userTel);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", selfIntroduce=").append(selfIntroduce);
        sb.append(", selfBlessing=").append(selfBlessing);
        sb.append(", userquestionMothername=").append(userquestionMothername);
        sb.append(", userquestionFirstlove=").append(userquestionFirstlove);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", accountState=").append(accountState);
        sb.append("]");
        return sb.toString();
    }
}