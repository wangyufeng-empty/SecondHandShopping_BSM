package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 历史订单详情表; historyorder_info

 * date:2020/04/30 18:43
 */
public class HistoryorderInfo extends HistoryorderInfoKey implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -5814385005381943683L;

    /** 
     * 商品ID
     */ 
    private String goodsId;

    /** 
     * 商品名
     */ 
    private String goodsName;

    /** 
     * 此件商品已选数量
     */ 
    private Integer selectedquantity;

    /** 
     * 小计
     */ 
    private Double subtotal;

    /** 
     * 获取 商品ID historyorder_info.goods_id
     * @return 商品ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /** 
     * 设置 商品ID historyorder_info.goods_id
     * @param goodsId 商品ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /** 
     * 获取 商品名 historyorder_info.goods_name
     * @return 商品名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /** 
     * 设置 商品名 historyorder_info.goods_name
     * @param goodsName 商品名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /** 
     * 获取 此件商品已选数量 historyorder_info.selectedQuantity
     * @return 此件商品已选数量
     */
    public Integer getSelectedquantity() {
        return selectedquantity;
    }

    /** 
     * 设置 此件商品已选数量 historyorder_info.selectedQuantity
     * @param selectedquantity 此件商品已选数量
     */
    public void setSelectedquantity(Integer selectedquantity) {
        this.selectedquantity = selectedquantity;
    }

    /** 
     * 获取 小计 historyorder_info.subtotal
     * @return 小计
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /** 
     * 设置 小计 historyorder_info.subtotal
     * @param subtotal 小计
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", selectedquantity=").append(selectedquantity);
        sb.append(", subtotal=").append(subtotal);
        sb.append("]");
        return sb.toString();
    }
}