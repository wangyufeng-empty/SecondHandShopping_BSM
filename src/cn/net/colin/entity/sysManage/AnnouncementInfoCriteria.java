package cn.net.colin.entity.sysManage;

import java.util.ArrayList;
import java.util.List;

/**

 * date:2020/04/30 18:43
 */
public class AnnouncementInfoCriteria {
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
    public AnnouncementInfoCriteria() {
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
     * 公告信息表，用于保存管理员发布公告的信息announcement_info
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

        public Criteria andAnnouncementIdIsNull() {
            addCriterion("announcement_id is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdIsNotNull() {
            addCriterion("announcement_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdEqualTo(String value) {
            addCriterion("announcement_id =", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdNotEqualTo(String value) {
            addCriterion("announcement_id <>", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdGreaterThan(String value) {
            addCriterion("announcement_id >", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_id >=", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdLessThan(String value) {
            addCriterion("announcement_id <", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdLessThanOrEqualTo(String value) {
            addCriterion("announcement_id <=", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdLike(String value) {
            addCriterion("announcement_id like", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdNotLike(String value) {
            addCriterion("announcement_id not like", value, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdIn(List<String> values) {
            addCriterion("announcement_id in", values, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdNotIn(List<String> values) {
            addCriterion("announcement_id not in", values, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdBetween(String value1, String value2) {
            addCriterion("announcement_id between", value1, value2, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIdNotBetween(String value1, String value2) {
            addCriterion("announcement_id not between", value1, value2, "announcementId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentIsNull() {
            addCriterion("announcement_content is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentIsNotNull() {
            addCriterion("announcement_content is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentEqualTo(String value) {
            addCriterion("announcement_content =", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotEqualTo(String value) {
            addCriterion("announcement_content <>", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentGreaterThan(String value) {
            addCriterion("announcement_content >", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_content >=", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentLessThan(String value) {
            addCriterion("announcement_content <", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentLessThanOrEqualTo(String value) {
            addCriterion("announcement_content <=", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentLike(String value) {
            addCriterion("announcement_content like", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotLike(String value) {
            addCriterion("announcement_content not like", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentIn(List<String> values) {
            addCriterion("announcement_content in", values, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotIn(List<String> values) {
            addCriterion("announcement_content not in", values, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentBetween(String value1, String value2) {
            addCriterion("announcement_content between", value1, value2, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotBetween(String value1, String value2) {
            addCriterion("announcement_content not between", value1, value2, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateIsNull() {
            addCriterion("announcement_date is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateIsNotNull() {
            addCriterion("announcement_date is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateEqualTo(String value) {
            addCriterion("announcement_date =", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateNotEqualTo(String value) {
            addCriterion("announcement_date <>", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateGreaterThan(String value) {
            addCriterion("announcement_date >", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_date >=", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateLessThan(String value) {
            addCriterion("announcement_date <", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateLessThanOrEqualTo(String value) {
            addCriterion("announcement_date <=", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateLike(String value) {
            addCriterion("announcement_date like", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateNotLike(String value) {
            addCriterion("announcement_date not like", value, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateIn(List<String> values) {
            addCriterion("announcement_date in", values, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateNotIn(List<String> values) {
            addCriterion("announcement_date not in", values, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateBetween(String value1, String value2) {
            addCriterion("announcement_date between", value1, value2, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateNotBetween(String value1, String value2) {
            addCriterion("announcement_date not between", value1, value2, "announcementDate");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNull() {
            addCriterion("publisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNotNull() {
            addCriterion("publisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdEqualTo(String value) {
            addCriterion("publisher_id =", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotEqualTo(String value) {
            addCriterion("publisher_id <>", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThan(String value) {
            addCriterion("publisher_id >", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThanOrEqualTo(String value) {
            addCriterion("publisher_id >=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThan(String value) {
            addCriterion("publisher_id <", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThanOrEqualTo(String value) {
            addCriterion("publisher_id <=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLike(String value) {
            addCriterion("publisher_id like", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotLike(String value) {
            addCriterion("publisher_id not like", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIn(List<String> values) {
            addCriterion("publisher_id in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotIn(List<String> values) {
            addCriterion("publisher_id not in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdBetween(String value1, String value2) {
            addCriterion("publisher_id between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotBetween(String value1, String value2) {
            addCriterion("publisher_id not between", value1, value2, "publisherId");
            return (Criteria) this;
        }
    }

    /**
     * 公告信息表，用于保存管理员发布公告的信息announcement_info的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 公告信息表，用于保存管理员发布公告的信息announcement_info的动态SQL对象.
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