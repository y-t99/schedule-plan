package cn.yuanyuan.sp.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class TmsAttributeDefinitionDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmsAttributeDefinitionDictExample() {
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

        public Criteria andAttributeCodeIsNull() {
            addCriterion("attribute_code is null");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeIsNotNull() {
            addCriterion("attribute_code is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeEqualTo(String value) {
            addCriterion("attribute_code =", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeNotEqualTo(String value) {
            addCriterion("attribute_code <>", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeGreaterThan(String value) {
            addCriterion("attribute_code >", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_code >=", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeLessThan(String value) {
            addCriterion("attribute_code <", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeLessThanOrEqualTo(String value) {
            addCriterion("attribute_code <=", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeLike(String value) {
            addCriterion("attribute_code like", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeNotLike(String value) {
            addCriterion("attribute_code not like", value, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeIn(List<String> values) {
            addCriterion("attribute_code in", values, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeNotIn(List<String> values) {
            addCriterion("attribute_code not in", values, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeBetween(String value1, String value2) {
            addCriterion("attribute_code between", value1, value2, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeCodeNotBetween(String value1, String value2) {
            addCriterion("attribute_code not between", value1, value2, "attributeCode");
            return (Criteria) this;
        }

        public Criteria andAttributeNameIsNull() {
            addCriterion("attribute_name is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameIsNotNull() {
            addCriterion("attribute_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEqualTo(String value) {
            addCriterion("attribute_name =", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotEqualTo(String value) {
            addCriterion("attribute_name <>", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameGreaterThan(String value) {
            addCriterion("attribute_name >", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_name >=", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameLessThan(String value) {
            addCriterion("attribute_name <", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameLessThanOrEqualTo(String value) {
            addCriterion("attribute_name <=", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameLike(String value) {
            addCriterion("attribute_name like", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotLike(String value) {
            addCriterion("attribute_name not like", value, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameIn(List<String> values) {
            addCriterion("attribute_name in", values, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotIn(List<String> values) {
            addCriterion("attribute_name not in", values, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameBetween(String value1, String value2) {
            addCriterion("attribute_name between", value1, value2, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributeNameNotBetween(String value1, String value2) {
            addCriterion("attribute_name not between", value1, value2, "attributeName");
            return (Criteria) this;
        }

        public Criteria andAttributetIdIsNull() {
            addCriterion("attributet_id is null");
            return (Criteria) this;
        }

        public Criteria andAttributetIdIsNotNull() {
            addCriterion("attributet_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttributetIdEqualTo(Integer value) {
            addCriterion("attributet_id =", value, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdNotEqualTo(Integer value) {
            addCriterion("attributet_id <>", value, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdGreaterThan(Integer value) {
            addCriterion("attributet_id >", value, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attributet_id >=", value, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdLessThan(Integer value) {
            addCriterion("attributet_id <", value, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdLessThanOrEqualTo(Integer value) {
            addCriterion("attributet_id <=", value, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdIn(List<Integer> values) {
            addCriterion("attributet_id in", values, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdNotIn(List<Integer> values) {
            addCriterion("attributet_id not in", values, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdBetween(Integer value1, Integer value2) {
            addCriterion("attributet_id between", value1, value2, "attributetId");
            return (Criteria) this;
        }

        public Criteria andAttributetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attributet_id not between", value1, value2, "attributetId");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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