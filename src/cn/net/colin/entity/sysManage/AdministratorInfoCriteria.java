package cn.net.colin.entity.sysManage;

import java.util.ArrayList;
import java.util.List;

/**

 * date:2020/05/04 19:20
 */
public class AdministratorInfoCriteria {
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
    public AdministratorInfoCriteria() {
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
     * 管理员信息表，用户保存管理员的个人信息administrator_info
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(String value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(String value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(String value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(String value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(String value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLike(String value) {
            addCriterion("admin_id like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotLike(String value) {
            addCriterion("admin_id not like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<String> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<String> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(String value1, String value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(String value1, String value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminPswIsNull() {
            addCriterion("admin_psw is null");
            return (Criteria) this;
        }

        public Criteria andAdminPswIsNotNull() {
            addCriterion("admin_psw is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPswEqualTo(String value) {
            addCriterion("admin_psw =", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswNotEqualTo(String value) {
            addCriterion("admin_psw <>", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswGreaterThan(String value) {
            addCriterion("admin_psw >", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswGreaterThanOrEqualTo(String value) {
            addCriterion("admin_psw >=", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswLessThan(String value) {
            addCriterion("admin_psw <", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswLessThanOrEqualTo(String value) {
            addCriterion("admin_psw <=", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswLike(String value) {
            addCriterion("admin_psw like", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswNotLike(String value) {
            addCriterion("admin_psw not like", value, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswIn(List<String> values) {
            addCriterion("admin_psw in", values, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswNotIn(List<String> values) {
            addCriterion("admin_psw not in", values, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswBetween(String value1, String value2) {
            addCriterion("admin_psw between", value1, value2, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminPswNotBetween(String value1, String value2) {
            addCriterion("admin_psw not between", value1, value2, "adminPsw");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminSexIsNull() {
            addCriterion("admin_sex is null");
            return (Criteria) this;
        }

        public Criteria andAdminSexIsNotNull() {
            addCriterion("admin_sex is not null");
            return (Criteria) this;
        }

        public Criteria andAdminSexEqualTo(String value) {
            addCriterion("admin_sex =", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotEqualTo(String value) {
            addCriterion("admin_sex <>", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexGreaterThan(String value) {
            addCriterion("admin_sex >", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexGreaterThanOrEqualTo(String value) {
            addCriterion("admin_sex >=", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexLessThan(String value) {
            addCriterion("admin_sex <", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexLessThanOrEqualTo(String value) {
            addCriterion("admin_sex <=", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexLike(String value) {
            addCriterion("admin_sex like", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotLike(String value) {
            addCriterion("admin_sex not like", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexIn(List<String> values) {
            addCriterion("admin_sex in", values, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotIn(List<String> values) {
            addCriterion("admin_sex not in", values, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexBetween(String value1, String value2) {
            addCriterion("admin_sex between", value1, value2, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotBetween(String value1, String value2) {
            addCriterion("admin_sex not between", value1, value2, "adminSex");
            return (Criteria) this;
        }
    }

    /**
     * 管理员信息表，用户保存管理员的个人信息administrator_info的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 管理员信息表，用户保存管理员的个人信息administrator_info的动态SQL对象.
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