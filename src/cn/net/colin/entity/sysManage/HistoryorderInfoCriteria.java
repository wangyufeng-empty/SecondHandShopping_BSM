package cn.net.colin.entity.sysManage;

import java.util.ArrayList;
import java.util.List;

/**

 * date:2020/04/30 18:43
 */
public class HistoryorderInfoCriteria {
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
    public HistoryorderInfoCriteria() {
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
     * 历史订单详情表;historyorder_info
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andSelectedquantityIsNull() {
            addCriterion("selectedQuantity is null");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityIsNotNull() {
            addCriterion("selectedQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityEqualTo(Integer value) {
            addCriterion("selectedQuantity =", value, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityNotEqualTo(Integer value) {
            addCriterion("selectedQuantity <>", value, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityGreaterThan(Integer value) {
            addCriterion("selectedQuantity >", value, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("selectedQuantity >=", value, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityLessThan(Integer value) {
            addCriterion("selectedQuantity <", value, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityLessThanOrEqualTo(Integer value) {
            addCriterion("selectedQuantity <=", value, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityIn(List<Integer> values) {
            addCriterion("selectedQuantity in", values, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityNotIn(List<Integer> values) {
            addCriterion("selectedQuantity not in", values, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityBetween(Integer value1, Integer value2) {
            addCriterion("selectedQuantity between", value1, value2, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSelectedquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("selectedQuantity not between", value1, value2, "selectedquantity");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNull() {
            addCriterion("subtotal is null");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNotNull() {
            addCriterion("subtotal is not null");
            return (Criteria) this;
        }

        public Criteria andSubtotalEqualTo(Double value) {
            addCriterion("subtotal =", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotEqualTo(Double value) {
            addCriterion("subtotal <>", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThan(Double value) {
            addCriterion("subtotal >", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThanOrEqualTo(Double value) {
            addCriterion("subtotal >=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThan(Double value) {
            addCriterion("subtotal <", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThanOrEqualTo(Double value) {
            addCriterion("subtotal <=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalIn(List<Double> values) {
            addCriterion("subtotal in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotIn(List<Double> values) {
            addCriterion("subtotal not in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalBetween(Double value1, Double value2) {
            addCriterion("subtotal between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotBetween(Double value1, Double value2) {
            addCriterion("subtotal not between", value1, value2, "subtotal");
            return (Criteria) this;
        }
    }

    /**
     * 历史订单详情表;historyorder_info的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 历史订单详情表;historyorder_info的动态SQL对象.
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