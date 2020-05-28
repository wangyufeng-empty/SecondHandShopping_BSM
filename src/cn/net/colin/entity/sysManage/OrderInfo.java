package cn.net.colin.entity.sysManage;

import java.io.Serializable;
import java.util.List;

/** 
 * 订单信息总览表 order_info

 * date:2020/04/30 18:43
 */
public class OrderInfo extends OrderInfoKey implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 7162112705717103255L;

    /** 
     * 下单时间
     */ 
    private String orderTime;

    /** 
     * 收货人
     */ 
    private String consignee;

    /** 
     * 收货人电话号码
     */ 
    private String telNum;

    /** 
     * 收货人地址
     */ 
    private String address;

    /** 
     * 订单总价  默认：0
     */ 
    private Double sumAccount;

    /** 
     * 订单状态（物流状态）
     */ 
    private String orderState;

    /** 
     * 此订单所包含的所有商品ID
     */ 
    private String includeGoodsid;

    /**
     * 订单商品集合
     */
    private List<HistoryorderInfo> historyorderInfoList;

    /** 
     * 获取 下单时间 order_info.order_time
     * @return 下单时间
     */
    public String getOrderTime() {
        return orderTime;
    }

    /** 
     * 设置 下单时间 order_info.order_time
     * @param orderTime 下单时间
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    /** 
     * 获取 收货人 order_info.consignee
     * @return 收货人
     */
    public String getConsignee() {
        return consignee;
    }

    /** 
     * 设置 收货人 order_info.consignee
     * @param consignee 收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /** 
     * 获取 收货人电话号码 order_info.tel_num
     * @return 收货人电话号码
     */
    public String getTelNum() {
        return telNum;
    }

    /** 
     * 设置 收货人电话号码 order_info.tel_num
     * @param telNum 收货人电话号码
     */
    public void setTelNum(String telNum) {
        this.telNum = telNum == null ? null : telNum.trim();
    }

    /** 
     * 获取 收货人地址 order_info.address
     * @return 收货人地址
     */
    public String getAddress() {
        return address;
    }

    /** 
     * 设置 收货人地址 order_info.address
     * @param address 收货人地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /** 
     * 获取 订单总价 order_info.sum_account
     * @return 订单总价
     */
    public Double getSumAccount() {
        return sumAccount;
    }

    /** 
     * 设置 订单总价 order_info.sum_account
     * @param sumAccount 订单总价
     */
    public void setSumAccount(Double sumAccount) {
        this.sumAccount = sumAccount;
    }

    /** 
     * 获取 订单状态（物流状态） order_info.order_state
     * @return 订单状态（物流状态）
     */
    public String getOrderState() {
        return orderState;
    }

    /** 
     * 设置 订单状态（物流状态） order_info.order_state
     * @param orderState 订单状态（物流状态）
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /** 
     * 获取 此订单所包含的所有商品ID order_info.include_goodsId
     * @return 此订单所包含的所有商品ID
     */
    public String getIncludeGoodsid() {
        return includeGoodsid;
    }

    /** 
     * 设置 此订单所包含的所有商品ID order_info.include_goodsId
     * @param includeGoodsid 此订单所包含的所有商品ID
     */
    public void setIncludeGoodsid(String includeGoodsid) {
        this.includeGoodsid = includeGoodsid == null ? null : includeGoodsid.trim();
    }

    public List<HistoryorderInfo> getHistoryorderInfoList() {
        return historyorderInfoList;
    }

    public void setHistoryorderInfoList(List<HistoryorderInfo> historyorderInfoList) {
        this.historyorderInfoList = historyorderInfoList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", consignee=").append(consignee);
        sb.append(", telNum=").append(telNum);
        sb.append(", address=").append(address);
        sb.append(", sumAccount=").append(sumAccount);
        sb.append(", orderState=").append(orderState);
        sb.append(", includeGoodsid=").append(includeGoodsid);
        sb.append("]");
        return sb.toString();
    }
}