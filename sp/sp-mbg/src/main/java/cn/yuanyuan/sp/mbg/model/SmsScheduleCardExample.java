package cn.yuanyuan.sp.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class SmsScheduleCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsScheduleCardExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCardSnIsNull() {
            addCriterion("card_sn is null");
            return (Criteria) this;
        }

        public Criteria andCardSnIsNotNull() {
            addCriterion("card_sn is not null");
            return (Criteria) this;
        }

        public Criteria andCardSnEqualTo(String value) {
            addCriterion("card_sn =", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnNotEqualTo(String value) {
            addCriterion("card_sn <>", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnGreaterThan(String value) {
            addCriterion("card_sn >", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnGreaterThanOrEqualTo(String value) {
            addCriterion("card_sn >=", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnLessThan(String value) {
            addCriterion("card_sn <", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnLessThanOrEqualTo(String value) {
            addCriterion("card_sn <=", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnLike(String value) {
            addCriterion("card_sn like", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnNotLike(String value) {
            addCriterion("card_sn not like", value, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnIn(List<String> values) {
            addCriterion("card_sn in", values, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnNotIn(List<String> values) {
            addCriterion("card_sn not in", values, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnBetween(String value1, String value2) {
            addCriterion("card_sn between", value1, value2, "cardSn");
            return (Criteria) this;
        }

        public Criteria andCardSnNotBetween(String value1, String value2) {
            addCriterion("card_sn not between", value1, value2, "cardSn");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPnsnsIsNull() {
            addCriterion("pnsns is null");
            return (Criteria) this;
        }

        public Criteria andPnsnsIsNotNull() {
            addCriterion("pnsns is not null");
            return (Criteria) this;
        }

        public Criteria andPnsnsEqualTo(String value) {
            addCriterion("pnsns =", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsNotEqualTo(String value) {
            addCriterion("pnsns <>", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsGreaterThan(String value) {
            addCriterion("pnsns >", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsGreaterThanOrEqualTo(String value) {
            addCriterion("pnsns >=", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsLessThan(String value) {
            addCriterion("pnsns <", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsLessThanOrEqualTo(String value) {
            addCriterion("pnsns <=", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsLike(String value) {
            addCriterion("pnsns like", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsNotLike(String value) {
            addCriterion("pnsns not like", value, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsIn(List<String> values) {
            addCriterion("pnsns in", values, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsNotIn(List<String> values) {
            addCriterion("pnsns not in", values, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsBetween(String value1, String value2) {
            addCriterion("pnsns between", value1, value2, "pnsns");
            return (Criteria) this;
        }

        public Criteria andPnsnsNotBetween(String value1, String value2) {
            addCriterion("pnsns not between", value1, value2, "pnsns");
            return (Criteria) this;
        }

        public Criteria andReasonablenessIsNull() {
            addCriterion("reasonableness is null");
            return (Criteria) this;
        }

        public Criteria andReasonablenessIsNotNull() {
            addCriterion("reasonableness is not null");
            return (Criteria) this;
        }

        public Criteria andReasonablenessEqualTo(Integer value) {
            addCriterion("reasonableness =", value, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessNotEqualTo(Integer value) {
            addCriterion("reasonableness <>", value, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessGreaterThan(Integer value) {
            addCriterion("reasonableness >", value, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessGreaterThanOrEqualTo(Integer value) {
            addCriterion("reasonableness >=", value, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessLessThan(Integer value) {
            addCriterion("reasonableness <", value, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessLessThanOrEqualTo(Integer value) {
            addCriterion("reasonableness <=", value, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessIn(List<Integer> values) {
            addCriterion("reasonableness in", values, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessNotIn(List<Integer> values) {
            addCriterion("reasonableness not in", values, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessBetween(Integer value1, Integer value2) {
            addCriterion("reasonableness between", value1, value2, "reasonableness");
            return (Criteria) this;
        }

        public Criteria andReasonablenessNotBetween(Integer value1, Integer value2) {
            addCriterion("reasonableness not between", value1, value2, "reasonableness");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

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