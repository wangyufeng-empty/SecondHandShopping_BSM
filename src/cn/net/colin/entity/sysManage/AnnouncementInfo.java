package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 公告信息表，用于保存管理员发布公告的信息 announcement_info

 * date:2020/04/30 18:43
 */
public class AnnouncementInfo implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -6719300482655049005L;

    /** 
     * 公告的ID（后台生成）
     */ 
    private String announcementId;

    /** 
     * 发布的公告内容
     */ 
    private String announcementContent;

    /** 
     * 发布时间
     */ 
    private String announcementDate;

    /** 
     * 发布者ID（管理员）
     */ 
    private String publisherId;

    /**
     * 发布者实体类
     */
    private AdministratorInfo administratorInfo;

    /** 
     * 获取 公告的ID（后台生成） announcement_info.announcement_id
     * @return 公告的ID（后台生成）
     */
    public String getAnnouncementId() {
        return announcementId;
    }

    /** 
     * 设置 公告的ID（后台生成） announcement_info.announcement_id
     * @param announcementId 公告的ID（后台生成）
     */
    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId == null ? null : announcementId.trim();
    }

    /** 
     * 获取 发布的公告内容 announcement_info.announcement_content
     * @return 发布的公告内容
     */
    public String getAnnouncementContent() {
        return announcementContent;
    }

    /** 
     * 设置 发布的公告内容 announcement_info.announcement_content
     * @param announcementContent 发布的公告内容
     */
    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent == null ? null : announcementContent.trim();
    }

    /** 
     * 获取 发布时间 announcement_info.announcement_date
     * @return 发布时间
     */
    public String getAnnouncementDate() {
        return announcementDate;
    }

    /** 
     * 设置 发布时间 announcement_info.announcement_date
     * @param announcementDate 发布时间
     */
    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate == null ? null : announcementDate.trim();
    }

    /** 
     * 获取 发布者ID（管理员） announcement_info.publisher_id
     * @return 发布者ID（管理员）
     */
    public String getPublisherId() {
        return publisherId;
    }

    /** 
     * 设置 发布者ID（管理员） announcement_info.publisher_id
     * @param publisherId 发布者ID（管理员）
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId == null ? null : publisherId.trim();
    }

    public AdministratorInfo getAdministratorInfo() {
        return administratorInfo;
    }

    public void setAdministratorInfo(AdministratorInfo administratorInfo) {
        this.administratorInfo = administratorInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", announcementId=").append(announcementId);
        sb.append(", announcementContent=").append(announcementContent);
        sb.append(", announcementDate=").append(announcementDate);
        sb.append(", publisherId=").append(publisherId);
        sb.append("]");
        return sb.toString();
    }
}