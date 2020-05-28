package cn.net.colin.entity.sysManage;

import java.util.ArrayList;
import java.util.List;

/**

 * date:2020/05/03 15:09
 */
public class GoodsPictureCriteria {
    /** 
     * 排序字段
    */
    protected String orderByClause;

    /** 
     * 过滤重复数据
    */
    protected boolean distinct;

    /** 
     * 查询条件
    */
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public GoodsPictureCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 商品图片表goods_picture
     */
    protected abstract static class BaseCriteria {
        protected List<Criterion> criteria;

        protected BaseCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdAutoIsNull() {
            addCriterion("id-auto is null");
            return (Criteria) this;
        }

        public Criteria andIdAutoIsNotNull() {
            addCriterion("id-auto is not null");
            return (Criteria) this;
        }

        public Criteria andIdAutoEqualTo(Integer value) {
            addCriterion("id-auto =", value, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoNotEqualTo(Integer value) {
            addCriterion("id-auto <>", value, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoGreaterThan(Integer value) {
            addCriterion("id-auto >", value, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id-auto >=", value, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoLessThan(Integer value) {
            addCriterion("id-auto <", value, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoLessThanOrEqualTo(Integer value) {
            addCriterion("id-auto <=", value, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoIn(List<Integer> values) {
            addCriterion("id-auto in", values, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoNotIn(List<Integer> values) {
            addCriterion("id-auto not in", values, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoBetween(Integer value1, Integer value2) {
            addCriterion("id-auto between", value1, value2, "idAuto");
            return (Criteria) this;
        }

        public Criteria andIdAutoNotBetween(Integer value1, Integer value2) {
            addCriterion("id-auto not between", value1, value2, "idAuto");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andProductImageIsNull() {
            addCriterion("product_image is null");
            return (Criteria) this;
        }

        public Criteria andProductImageIsNotNull() {
            addCriterion("product_image is not null");
            return (Criteria) this;
        }

        public Criteria andProductImageEqualTo(String value) {
            addCriterion("product_image =", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotEqualTo(String value) {
            addCriterion("product_image <>", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageGreaterThan(String value) {
            addCriterion("product_image >", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageGreaterThanOrEqualTo(String value) {
            addCriterion("product_image >=", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageLessThan(String value) {
            addCriterion("product_image <", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageLessThanOrEqualTo(String value) {
            addCriterion("product_image <=", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageLike(String value) {
            addCriterion("product_image like", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotLike(String value) {
            addCriterion("product_image not like", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageIn(List<String> values) {
            addCriterion("product_image in", values, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotIn(List<String> values) {
            addCriterion("product_image not in", values, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageBetween(String value1, String value2) {
            addCriterion("product_image between", value1, value2, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotBetween(String value1, String value2) {
            addCriterion("product_image not between", value1, value2, "productImage");
            return (Criteria) this;
        }

        public Criteria andHomepageShowIsNull() {
            addCriterion("homePage_show is null");
            return (Criteria) this;
        }

        public Criteria andHomepageShowIsNotNull() {
            addCriterion("homePage_show is not null");
            return (Criteria) this;
        }

        public Criteria andHomepageShowEqualTo(Integer value) {
            addCriterion("homePage_show =", value, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowNotEqualTo(Integer value) {
            addCriterion("homePage_show <>", value, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowGreaterThan(Integer value) {
            addCriterion("homePage_show >", value, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("homePage_show >=", value, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowLessThan(Integer value) {
            addCriterion("homePage_show <", value, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowLessThanOrEqualTo(Integer value) {
            addCriterion("homePage_show <=", value, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowIn(List<Integer> values) {
            addCriterion("homePage_show in", values, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowNotIn(List<Integer> values) {
            addCriterion("homePage_show not in", values, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowBetween(Integer value1, Integer value2) {
            addCriterion("homePage_show between", value1, value2, "homepageShow");
            return (Criteria) this;
        }

        public Criteria andHomepageShowNotBetween(Integer value1, Integer value2) {
            addCriterion("homePage_show not between", value1, value2, "homepageShow");
            return (Criteria) this;
        }
    }

    /**
     * 商品图片表goods_picture的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 商品图片表goods_picture的动态SQL对象.
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}