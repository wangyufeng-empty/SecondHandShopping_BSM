package cn.net.colin.entity.sysManage;

import java.util.ArrayList;
import java.util.List;

/**

 * date:2020/05/03 15:08
 */
public class GoodsInfoCriteria {
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
    public GoodsInfoCriteria() {
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
     * 商品信息表goods_info
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherIsNull() {
            addCriterion("goods_publisher is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherIsNotNull() {
            addCriterion("goods_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherEqualTo(String value) {
            addCriterion("goods_publisher =", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherNotEqualTo(String value) {
            addCriterion("goods_publisher <>", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherGreaterThan(String value) {
            addCriterion("goods_publisher >", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("goods_publisher >=", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherLessThan(String value) {
            addCriterion("goods_publisher <", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherLessThanOrEqualTo(String value) {
            addCriterion("goods_publisher <=", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherLike(String value) {
            addCriterion("goods_publisher like", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherNotLike(String value) {
            addCriterion("goods_publisher not like", value, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherIn(List<String> values) {
            addCriterion("goods_publisher in", values, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherNotIn(List<String> values) {
            addCriterion("goods_publisher not in", values, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherBetween(String value1, String value2) {
            addCriterion("goods_publisher between", value1, value2, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsPublisherNotBetween(String value1, String value2) {
            addCriterion("goods_publisher not between", value1, value2, "goodsPublisher");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateIsNull() {
            addCriterion("goods_issuDate is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateIsNotNull() {
            addCriterion("goods_issuDate is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateEqualTo(String value) {
            addCriterion("goods_issuDate =", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateNotEqualTo(String value) {
            addCriterion("goods_issuDate <>", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateGreaterThan(String value) {
            addCriterion("goods_issuDate >", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateGreaterThanOrEqualTo(String value) {
            addCriterion("goods_issuDate >=", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateLessThan(String value) {
            addCriterion("goods_issuDate <", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateLessThanOrEqualTo(String value) {
            addCriterion("goods_issuDate <=", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateLike(String value) {
            addCriterion("goods_issuDate like", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateNotLike(String value) {
            addCriterion("goods_issuDate not like", value, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateIn(List<String> values) {
            addCriterion("goods_issuDate in", values, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateNotIn(List<String> values) {
            addCriterion("goods_issuDate not in", values, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateBetween(String value1, String value2) {
            addCriterion("goods_issuDate between", value1, value2, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsIssudateNotBetween(String value1, String value2) {
            addCriterion("goods_issuDate not between", value1, value2, "goodsIssudate");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIsNull() {
            addCriterion("goods_category is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIsNotNull() {
            addCriterion("goods_category is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryEqualTo(String value) {
            addCriterion("goods_category =", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotEqualTo(String value) {
            addCriterion("goods_category <>", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryGreaterThan(String value) {
            addCriterion("goods_category >", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("goods_category >=", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryLessThan(String value) {
            addCriterion("goods_category <", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryLessThanOrEqualTo(String value) {
            addCriterion("goods_category <=", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryLike(String value) {
            addCriterion("goods_category like", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotLike(String value) {
            addCriterion("goods_category not like", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIn(List<String> values) {
            addCriterion("goods_category in", values, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotIn(List<String> values) {
            addCriterion("goods_category not in", values, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryBetween(String value1, String value2) {
            addCriterion("goods_category between", value1, value2, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotBetween(String value1, String value2) {
            addCriterion("goods_category not between", value1, value2, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeIsNull() {
            addCriterion("goods_describe is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeIsNotNull() {
            addCriterion("goods_describe is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeEqualTo(String value) {
            addCriterion("goods_describe =", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotEqualTo(String value) {
            addCriterion("goods_describe <>", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeGreaterThan(String value) {
            addCriterion("goods_describe >", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_describe >=", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeLessThan(String value) {
            addCriterion("goods_describe <", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeLessThanOrEqualTo(String value) {
            addCriterion("goods_describe <=", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeLike(String value) {
            addCriterion("goods_describe like", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotLike(String value) {
            addCriterion("goods_describe not like", value, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeIn(List<String> values) {
            addCriterion("goods_describe in", values, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotIn(List<String> values) {
            addCriterion("goods_describe not in", values, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeBetween(String value1, String value2) {
            addCriterion("goods_describe between", value1, value2, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribeNotBetween(String value1, String value2) {
            addCriterion("goods_describe not between", value1, value2, "goodsDescribe");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Double value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Double value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Double value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Double value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Double value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Double> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Double> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Double value1, Double value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Double value1, Double value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNull() {
            addCriterion("goods_stock is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNotNull() {
            addCriterion("goods_stock is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockEqualTo(Integer value) {
            addCriterion("goods_stock =", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotEqualTo(Integer value) {
            addCriterion("goods_stock <>", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThan(Integer value) {
            addCriterion("goods_stock >", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_stock >=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThan(Integer value) {
            addCriterion("goods_stock <", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThanOrEqualTo(Integer value) {
            addCriterion("goods_stock <=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIn(List<Integer> values) {
            addCriterion("goods_stock in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotIn(List<Integer> values) {
            addCriterion("goods_stock not in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockBetween(Integer value1, Integer value2) {
            addCriterion("goods_stock between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_stock not between", value1, value2, "goodsStock");
            return (Criteria) this;
        }
    }

    /**
     * 商品信息表goods_info的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 商品信息表goods_info的动态SQL对象.
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