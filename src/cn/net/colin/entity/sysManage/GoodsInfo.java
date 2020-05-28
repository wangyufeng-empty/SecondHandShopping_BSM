package cn.net.colin.entity.sysManage;

import java.io.Serializable;
import java.util.List;

/** 
 * 商品信息表 goods_info

 * date:2020/05/03 15:08
 */
public class GoodsInfo implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 2636043654049531841L;

    /** 
     * 商品ID（后台自动生成-线性表）
     */ 
    private String goodsId;

    /** 
     * 商品名
     */ 
    private String goodsName;

    /** 
     * 商品的发布者
     */ 
    private String goodsPublisher;

    /** 
     * 商品的发布日期
     */ 
    private String goodsIssudate;

    /** 
     * 商品的类别
     */ 
    private String goodsCategory;

    /** 
     * 商品的详细描述（卖家描述）
     */ 
    private String goodsDescribe;

    /** 
     * 商品价格  默认：0
     */ 
    private Double goodsPrice;

    /** 
     * 货物的库存
  默认：0
     */ 
    private Integer goodsStock;

    private List<GoodsPicture> goodsPictures;

    /** 
     * 获取 商品ID（后台自动生成-线性表） goods_info.goods_id
     * @return 商品ID（后台自动生成-线性表）
     */
    public String getGoodsId() {
        return goodsId;
    }

    /** 
     * 设置 商品ID（后台自动生成-线性表） goods_info.goods_id
     * @param goodsId 商品ID（后台自动生成-线性表）
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /** 
     * 获取 商品名 goods_info.goods_name
     * @return 商品名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /** 
     * 设置 商品名 goods_info.goods_name
     * @param goodsName 商品名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /** 
     * 获取 商品的发布者 goods_info.goods_publisher
     * @return 商品的发布者
     */
    public String getGoodsPublisher() {
        return goodsPublisher;
    }

    /** 
     * 设置 商品的发布者 goods_info.goods_publisher
     * @param goodsPublisher 商品的发布者
     */
    public void setGoodsPublisher(String goodsPublisher) {
        this.goodsPublisher = goodsPublisher == null ? null : goodsPublisher.trim();
    }

    /** 
     * 获取 商品的发布日期 goods_info.goods_issuDate
     * @return 商品的发布日期
     */
    public String getGoodsIssudate() {
        return goodsIssudate;
    }

    /** 
     * 设置 商品的发布日期 goods_info.goods_issuDate
     * @param goodsIssudate 商品的发布日期
     */
    public void setGoodsIssudate(String goodsIssudate) {
        this.goodsIssudate = goodsIssudate == null ? null : goodsIssudate.trim();
    }

    /** 
     * 获取 商品的类别 goods_info.goods_category
     * @return 商品的类别
     */
    public String getGoodsCategory() {
        return goodsCategory;
    }

    /** 
     * 设置 商品的类别 goods_info.goods_category
     * @param goodsCategory 商品的类别
     */
    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory == null ? null : goodsCategory.trim();
    }

    /** 
     * 获取 商品的详细描述（卖家描述） goods_info.goods_describe
     * @return 商品的详细描述（卖家描述）
     */
    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    /** 
     * 设置 商品的详细描述（卖家描述） goods_info.goods_describe
     * @param goodsDescribe 商品的详细描述（卖家描述）
     */
    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe == null ? null : goodsDescribe.trim();
    }

    /** 
     * 获取 商品价格 goods_info.goods_price
     * @return 商品价格
     */
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    /** 
     * 设置 商品价格 goods_info.goods_price
     * @param goodsPrice 商品价格
     */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /** 
     * 获取 货物的库存
 goods_info.goods_stock
     * @return 货物的库存

     */
    public Integer getGoodsStock() {
        return goodsStock;
    }

    public List<GoodsPicture> getGoodsPictures() {
        return goodsPictures;
    }

    public void setGoodsPictures(List<GoodsPicture> goodsPictures) {
        this.goodsPictures = goodsPictures;
    }

    /**
     * 设置 货物的库存
 goods_info.goods_stock
     * @param goodsStock 货物的库存

     */
    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
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
        sb.append(", goodsPublisher=").append(goodsPublisher);
        sb.append(", goodsIssudate=").append(goodsIssudate);
        sb.append(", goodsCategory=").append(goodsCategory);
        sb.append(", goodsDescribe=").append(goodsDescribe);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsStock=").append(goodsStock);
        sb.append("]");
        return sb.toString();
    }
}