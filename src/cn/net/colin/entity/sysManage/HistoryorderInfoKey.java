package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 历史订单详情表; historyorder_info

 * date:2020/04/30 18:43
 */
public class HistoryorderInfoKey implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 3192767277280812271L;

    /** 
     * 自增ID
     */ 
    private Integer idAuto;

    /** 
     * 订单ID
     */ 
    private String orderId;

    /** 
     * 获取 自增ID historyorder_info.id-auto
     * @return 自增ID
     */
    public Integer getIdAuto() {
        return idAuto;
    }

    /** 
     * 设置 自增ID historyorder_info.id-auto
     * @param idAuto 自增ID
     */
    public void setIdAuto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    /** 
     * 获取 订单ID historyorder_info.order_id
     * @return 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /** 
     * 设置 订单ID historyorder_info.order_id
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
        sb.append(", idAuto=").append(idAuto);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}