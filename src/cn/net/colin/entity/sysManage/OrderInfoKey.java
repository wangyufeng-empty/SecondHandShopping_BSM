package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 订单信息总览表 order_info

 * date:2020/04/30 18:43
 */
public class OrderInfoKey implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 7130754061289435722L;

    /** 
     * 用户ID（学号）
     */ 
    private String userId;

    /** 
     * 订单ID
     */ 
    private String orderId;

    /** 
     * 获取 用户ID（学号） order_info.user_id
     * @return 用户ID（学号）
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * 设置 用户ID（学号） order_info.user_id
     * @param userId 用户ID（学号）
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /** 
     * 获取 订单ID order_info.order_id
     * @return 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /** 
     * 设置 订单ID order_info.order_id
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}