package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 管理员信息表，用户保存管理员的个人信息 administrator_info

 * date:2020/05/04 19:20
 */
public class AdministratorInfo implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -6308315452964409882L;

    /** 
     * 管理员ID，开发者分配
     */ 
    private String adminId;

    /** 
     * 管理员密码（开发者初始化）
     */ 
    private String adminPsw;

    /** 
     * 管理员姓名
     */ 
    private String adminName;

    /** 
     * 管理员性别
     */ 
    private String adminSex;

    /** 
     * 获取 管理员ID，开发者分配 administrator_info.admin_id
     * @return 管理员ID，开发者分配
     */
    public String getAdminId() {
        return adminId;
    }

    /** 
     * 设置 管理员ID，开发者分配 administrator_info.admin_id
     * @param adminId 管理员ID，开发者分配
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    /** 
     * 获取 管理员密码（开发者初始化） administrator_info.admin_psw
     * @return 管理员密码（开发者初始化）
     */
    public String getAdminPsw() {
        return adminPsw;
    }

    /** 
     * 设置 管理员密码（开发者初始化） administrator_info.admin_psw
     * @param adminPsw 管理员密码（开发者初始化）
     */
    public void setAdminPsw(String adminPsw) {
        this.adminPsw = adminPsw == null ? null : adminPsw.trim();
    }

    /** 
     * 获取 管理员姓名 administrator_info.admin_name
     * @return 管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /** 
     * 设置 管理员姓名 administrator_info.admin_name
     * @param adminName 管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /** 
     * 获取 管理员性别 administrator_info.admin_sex
     * @return 管理员性别
     */
    public String getAdminSex() {
        return adminSex;
    }

    /** 
     * 设置 管理员性别 administrator_info.admin_sex
     * @param adminSex 管理员性别
     */
    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex == null ? null : adminSex.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", adminId=").append(adminId);
        sb.append(", adminPsw=").append(adminPsw);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminSex=").append(adminSex);
        sb.append("]");
        return sb.toString();
    }
}