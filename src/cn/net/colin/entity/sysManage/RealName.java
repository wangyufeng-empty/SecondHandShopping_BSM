package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 实名认证表（实名信息库） real_name_verification

 * date:2020/05/02 15:30
 */
public class RealName implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 6111072851509835367L;

    /** 
     * 学生ID=用户ID（学号）
     */ 
    private String studentId;

    /** 
     * 学生姓名=用户名
     */ 
    private String studentName;

    /** 
     * 获取 学生ID=用户ID（学号） real_name_verification.student_id
     * @return 学生ID=用户ID（学号）
     */
    public String getStudentId() {
        return studentId;
    }

    /** 
     * 设置 学生ID=用户ID（学号） real_name_verification.student_id
     * @param studentId 学生ID=用户ID（学号）
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /** 
     * 获取 学生姓名=用户名 real_name_verification.student_name
     * @return 学生姓名=用户名
     */
    public String getStudentName() {
        return studentName;
    }

    /** 
     * 设置 学生姓名=用户名 real_name_verification.student_name
     * @param studentName 学生姓名=用户名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", studentId=").append(studentId);
        sb.append(", studentName=").append(studentName);
        sb.append("]");
        return sb.toString();
    }
}