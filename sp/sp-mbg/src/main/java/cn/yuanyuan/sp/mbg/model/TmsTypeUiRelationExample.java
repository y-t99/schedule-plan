package cn.yuanyuan.sp.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class TmsTypeUiRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmsTypeUiRelationExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andIsInputIsNull() {
            addCriterion("is_input is null");
            return (Criteria) this;
        }

        public Criteria andIsInputIsNotNull() {
            addCriterion("is_input is not null");
            return (Criteria) this;
        }

        public Criteria andIsInputEqualTo(Byte value) {
            addCriterion("is_input =", value, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputNotEqualTo(Byte value) {
            addCriterion("is_input <>", value, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputGreaterThan(Byte value) {
            addCriterion("is_input >", value, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_input >=", value, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputLessThan(Byte value) {
            addCriterion("is_input <", value, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputLessThanOrEqualTo(Byte value) {
            addCriterion("is_input <=", value, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputIn(List<Byte> values) {
            addCriterion("is_input in", values, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputNotIn(List<Byte> values) {
            addCriterion("is_input not in", values, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputBetween(Byte value1, Byte value2) {
            addCriterion("is_input between", value1, value2, "isInput");
            return (Criteria) this;
        }

        public Criteria andIsInputNotBetween(Byte value1, Byte value2) {
            addCriterion("is_input not between", value1, value2, "isInput");
            return (Criteria) this;
        }

        public Criteria andUiIdIsNull() {
            addCriterion("ui_id is null");
            return (Criteria) this;
        }

        public Criteria andUiIdIsNotNull() {
            addCriterion("ui_id is not null");
            return (Criteria) this;
        }

        public Criteria andUiIdEqualTo(Integer value) {
            addCriterion("ui_id =", value, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdNotEqualTo(Integer value) {
            addCriterion("ui_id <>", value, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdGreaterThan(Integer value) {
            addCriterion("ui_id >", value, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ui_id >=", value, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdLessThan(Integer value) {
            addCriterion("ui_id <", value, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdLessThanOrEqualTo(Integer value) {
            addCriterion("ui_id <=", value, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdIn(List<Integer> values) {
            addCriterion("ui_id in", values, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdNotIn(List<Integer> values) {
            addCriterion("ui_id not in", values, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdBetween(Integer value1, Integer value2) {
            addCriterion("ui_id between", value1, value2, "uiId");
            return (Criteria) this;
        }

        public Criteria andUiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ui_id not between", value1, value2, "uiId");
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