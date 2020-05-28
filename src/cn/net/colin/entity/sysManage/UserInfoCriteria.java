package cn.net.colin.entity.sysManage;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2020/04/30 18:43
 */
public class UserInfoCriteria {
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
    public UserInfoCriteria() {
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
     * 用户信息表user_info
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPswIsNull() {
            addCriterion("user_psw is null");
            return (Criteria) this;
        }

        public Criteria andUserPswIsNotNull() {
            addCriterion("user_psw is not null");
            return (Criteria) this;
        }

        public Criteria andUserPswEqualTo(String value) {
            addCriterion("user_psw =", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotEqualTo(String value) {
            addCriterion("user_psw <>", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswGreaterThan(String value) {
            addCriterion("user_psw >", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswGreaterThanOrEqualTo(String value) {
            addCriterion("user_psw >=", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswLessThan(String value) {
            addCriterion("user_psw <", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswLessThanOrEqualTo(String value) {
            addCriterion("user_psw <=", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswLike(String value) {
            addCriterion("user_psw like", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotLike(String value) {
            addCriterion("user_psw not like", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswIn(List<String> values) {
            addCriterion("user_psw in", values, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotIn(List<String> values) {
            addCriterion("user_psw not in", values, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswBetween(String value1, String value2) {
            addCriterion("user_psw between", value1, value2, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotBetween(String value1, String value2) {
            addCriterion("user_psw not between", value1, value2, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserGradeIsNull() {
            addCriterion("user_grade is null");
            return (Criteria) this;
        }

        public Criteria andUserGradeIsNotNull() {
            addCriterion("user_grade is not null");
            return (Criteria) this;
        }

        public Criteria andUserGradeEqualTo(String value) {
            addCriterion("user_grade =", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotEqualTo(String value) {
            addCriterion("user_grade <>", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeGreaterThan(String value) {
            addCriterion("user_grade >", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeGreaterThanOrEqualTo(String value) {
            addCriterion("user_grade >=", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeLessThan(String value) {
            addCriterion("user_grade <", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeLessThanOrEqualTo(String value) {
            addCriterion("user_grade <=", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeLike(String value) {
            addCriterion("user_grade like", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotLike(String value) {
            addCriterion("user_grade not like", value, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeIn(List<String> values) {
            addCriterion("user_grade in", values, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotIn(List<String> values) {
            addCriterion("user_grade not in", values, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeBetween(String value1, String value2) {
            addCriterion("user_grade between", value1, value2, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserGradeNotBetween(String value1, String value2) {
            addCriterion("user_grade not between", value1, value2, "userGrade");
            return (Criteria) this;
        }

        public Criteria andUserHobbyIsNull() {
            addCriterion("user_hobby is null");
            return (Criteria) this;
        }

        public Criteria andUserHobbyIsNotNull() {
            addCriterion("user_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andUserHobbyEqualTo(String value) {
            addCriterion("user_hobby =", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyNotEqualTo(String value) {
            addCriterion("user_hobby <>", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyGreaterThan(String value) {
            addCriterion("user_hobby >", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("user_hobby >=", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyLessThan(String value) {
            addCriterion("user_hobby <", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyLessThanOrEqualTo(String value) {
            addCriterion("user_hobby <=", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyLike(String value) {
            addCriterion("user_hobby like", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyNotLike(String value) {
            addCriterion("user_hobby not like", value, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyIn(List<String> values) {
            addCriterion("user_hobby in", values, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyNotIn(List<String> values) {
            addCriterion("user_hobby not in", values, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyBetween(String value1, String value2) {
            addCriterion("user_hobby between", value1, value2, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserHobbyNotBetween(String value1, String value2) {
            addCriterion("user_hobby not between", value1, value2, "userHobby");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("user_tel is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("user_tel =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("user_tel <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("user_tel >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("user_tel >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("user_tel <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("user_tel <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("user_tel like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("user_tel not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("user_tel in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("user_tel not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("user_tel between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("user_tel not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("user_address is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("user_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("user_address =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("user_address <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("user_address >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_address >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("user_address <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("user_address <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("user_address like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("user_address not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("user_address in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("user_address not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("user_address between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("user_address not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceIsNull() {
            addCriterion("self_introduce is null");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceIsNotNull() {
            addCriterion("self_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceEqualTo(String value) {
            addCriterion("self_introduce =", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotEqualTo(String value) {
            addCriterion("self_introduce <>", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceGreaterThan(String value) {
            addCriterion("self_introduce >", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("self_introduce >=", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceLessThan(String value) {
            addCriterion("self_introduce <", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceLessThanOrEqualTo(String value) {
            addCriterion("self_introduce <=", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceLike(String value) {
            addCriterion("self_introduce like", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotLike(String value) {
            addCriterion("self_introduce not like", value, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceIn(List<String> values) {
            addCriterion("self_introduce in", values, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotIn(List<String> values) {
            addCriterion("self_introduce not in", values, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceBetween(String value1, String value2) {
            addCriterion("self_introduce between", value1, value2, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfIntroduceNotBetween(String value1, String value2) {
            addCriterion("self_introduce not between", value1, value2, "selfIntroduce");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingIsNull() {
            addCriterion("self_blessing is null");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingIsNotNull() {
            addCriterion("self_blessing is not null");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingEqualTo(String value) {
            addCriterion("self_blessing =", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingNotEqualTo(String value) {
            addCriterion("self_blessing <>", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingGreaterThan(String value) {
            addCriterion("self_blessing >", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingGreaterThanOrEqualTo(String value) {
            addCriterion("self_blessing >=", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingLessThan(String value) {
            addCriterion("self_blessing <", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingLessThanOrEqualTo(String value) {
            addCriterion("self_blessing <=", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingLike(String value) {
            addCriterion("self_blessing like", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingNotLike(String value) {
            addCriterion("self_blessing not like", value, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingIn(List<String> values) {
            addCriterion("self_blessing in", values, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingNotIn(List<String> values) {
            addCriterion("self_blessing not in", values, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingBetween(String value1, String value2) {
            addCriterion("self_blessing between", value1, value2, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andSelfBlessingNotBetween(String value1, String value2) {
            addCriterion("self_blessing not between", value1, value2, "selfBlessing");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameIsNull() {
            addCriterion("userQuestion_motherName is null");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameIsNotNull() {
            addCriterion("userQuestion_motherName is not null");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameEqualTo(String value) {
            addCriterion("userQuestion_motherName =", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameNotEqualTo(String value) {
            addCriterion("userQuestion_motherName <>", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameGreaterThan(String value) {
            addCriterion("userQuestion_motherName >", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameGreaterThanOrEqualTo(String value) {
            addCriterion("userQuestion_motherName >=", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameLessThan(String value) {
            addCriterion("userQuestion_motherName <", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameLessThanOrEqualTo(String value) {
            addCriterion("userQuestion_motherName <=", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameLike(String value) {
            addCriterion("userQuestion_motherName like", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameNotLike(String value) {
            addCriterion("userQuestion_motherName not like", value, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameIn(List<String> values) {
            addCriterion("userQuestion_motherName in", values, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameNotIn(List<String> values) {
            addCriterion("userQuestion_motherName not in", values, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameBetween(String value1, String value2) {
            addCriterion("userQuestion_motherName between", value1, value2, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionMothernameNotBetween(String value1, String value2) {
            addCriterion("userQuestion_motherName not between", value1, value2, "userquestionMothername");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveIsNull() {
            addCriterion("userQuestion_firstLove is null");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveIsNotNull() {
            addCriterion("userQuestion_firstLove is not null");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveEqualTo(String value) {
            addCriterion("userQuestion_firstLove =", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveNotEqualTo(String value) {
            addCriterion("userQuestion_firstLove <>", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveGreaterThan(String value) {
            addCriterion("userQuestion_firstLove >", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveGreaterThanOrEqualTo(String value) {
            addCriterion("userQuestion_firstLove >=", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveLessThan(String value) {
            addCriterion("userQuestion_firstLove <", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveLessThanOrEqualTo(String value) {
            addCriterion("userQuestion_firstLove <=", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveLike(String value) {
            addCriterion("userQuestion_firstLove like", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveNotLike(String value) {
            addCriterion("userQuestion_firstLove not like", value, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveIn(List<String> values) {
            addCriterion("userQuestion_firstLove in", values, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveNotIn(List<String> values) {
            addCriterion("userQuestion_firstLove not in", values, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveBetween(String value1, String value2) {
            addCriterion("userQuestion_firstLove between", value1, value2, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andUserquestionFirstloveNotBetween(String value1, String value2) {
            addCriterion("userQuestion_firstLove not between", value1, value2, "userquestionFirstlove");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(String value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(String value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(String value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(String value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(String value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(String value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLike(String value) {
            addCriterion("register_time like", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotLike(String value) {
            addCriterion("register_time not like", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<String> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<String> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(String value1, String value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(String value1, String value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andAccountStateIsNull() {
            addCriterion("account_state is null");
            return (Criteria) this;
        }

        public Criteria andAccountStateIsNotNull() {
            addCriterion("account_state is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStateEqualTo(Integer value) {
            addCriterion("account_state =", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotEqualTo(Integer value) {
            addCriterion("account_state <>", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateGreaterThan(Integer value) {
            addCriterion("account_state >", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_state >=", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLessThan(Integer value) {
            addCriterion("account_state <", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLessThanOrEqualTo(Integer value) {
            addCriterion("account_state <=", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateIn(List<Integer> values) {
            addCriterion("account_state in", values, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotIn(List<Integer> values) {
            addCriterion("account_state not in", values, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateBetween(Integer value1, Integer value2) {
            addCriterion("account_state between", value1, value2, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotBetween(Integer value1, Integer value2) {
            addCriterion("account_state not between", value1, value2, "accountState");
            return (Criteria) this;
        }
    }

    /**
     * 用户信息表user_info的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 用户信息表user_info的动态SQL对象.
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