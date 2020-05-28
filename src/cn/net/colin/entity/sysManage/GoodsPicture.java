package cn.net.colin.entity.sysManage;

import java.io.Serializable;

/** 
 * 商品图片表 goods_picture

 * date:2020/05/03 15:09
 */
public class GoodsPicture implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -6536385306799648935L;

    /** 
     * 自增ID
     */ 
    private Integer idAuto;

    /** 
     * 商品ID
     */ 
    private String goodsId;

    /** 
     * 商品图片，一张图片一条记录（保存的路径）
     */ 
    private String productImage;

    /** 
     * 首页展示（0 否，1 是）  默认：0
     */ 
    private Integer homepageShow;

    /** 
     * 获取 自增ID goods_picture.id-auto
     * @return 自增ID
     */
    public Integer getIdAuto() {
        return idAuto;
    }

    /** 
     * 设置 自增ID goods_picture.id-auto
     * @param idAuto 自增ID
     */
    public void setIdAuto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    /** 
     * 获取 商品ID goods_picture.goods_id
     * @return 商品ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /** 
     * 设置 商品ID goods_picture.goods_id
     * @param goodsId 商品ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /** 
     * 获取 商品图片，一张图片一条记录（保存的路径） goods_picture.product_image
     * @return 商品图片，一张图片一条记录（保存的路径）
     */
    public String getProductImage() {
        return productImage;
    }

    /** 
     * 设置 商品图片，一张图片一条记录（保存的路径） goods_picture.product_image
     * @param productImage 商品图片，一张图片一条记录（保存的路径）
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    /** 
     * 获取 首页展示（0 否，1 是） goods_picture.homePage_show
     * @return 首页展示（0 否，1 是）
     */
    public Integer getHomepageShow() {
        return homepageShow;
    }

    /** 
     * 设置 首页展示（0 否，1 是） goods_picture.homePage_show
     * @param homepageShow 首页展示（0 否，1 是）
     */
    public void setHomepageShow(Integer homepageShow) {
        this.homepageShow = homepageShow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", idAuto=").append(idAuto);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", productImage=").append(productImage);
        sb.append(", homepageShow=").append(homepageShow);
        sb.append("]");
        return sb.toString();
    }
}