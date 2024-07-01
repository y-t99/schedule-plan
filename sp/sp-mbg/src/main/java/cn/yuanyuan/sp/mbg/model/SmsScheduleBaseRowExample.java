package cn.yuanyuan.sp.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class SmsScheduleBaseRowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsScheduleBaseRowExample() {
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

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(Integer value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(Integer value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(Integer value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(Integer value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<Integer> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<Integer> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(Integer value1, Integer value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTimePointIsNull() {
            addCriterion("time_point is null");
            return (Criteria) this;
        }

        public Criteria andTimePointIsNotNull() {
            addCriterion("time_point is not null");
            return (Criteria) this;
        }

        public Criteria andTimePointEqualTo(Long value) {
            addCriterion("time_point =", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotEqualTo(Long value) {
            addCriterion("time_point <>", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointGreaterThan(Long value) {
            addCriterion("time_point >", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointGreaterThanOrEqualTo(Long value) {
            addCriterion("time_point >=", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointLessThan(Long value) {
            addCriterion("time_point <", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointLessThanOrEqualTo(Long value) {
            addCriterion("time_point <=", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointIn(List<Long> values) {
            addCriterion("time_point in", values, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotIn(List<Long> values) {
            addCriterion("time_point not in", values, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointBetween(Long value1, Long value2) {
            addCriterion("time_point between", value1, value2, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotBetween(Long value1, Long value2) {
            addCriterion("time_point not between", value1, value2, "timePoint");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationViewIsNull() {
            addCriterion("duration_view is null");
            return (Criteria) this;
        }

        public Criteria andDurationViewIsNotNull() {
            addCriterion("duration_view is not null");
            return (Criteria) this;
        }

        public Criteria andDurationViewEqualTo(Integer value) {
            addCriterion("duration_view =", value, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewNotEqualTo(Integer value) {
            addCriterion("duration_view <>", value, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewGreaterThan(Integer value) {
            addCriterion("duration_view >", value, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration_view >=", value, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewLessThan(Integer value) {
            addCriterion("duration_view <", value, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewLessThanOrEqualTo(Integer value) {
            addCriterion("duration_view <=", value, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewIn(List<Integer> values) {
            addCriterion("duration_view in", values, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewNotIn(List<Integer> values) {
            addCriterion("duration_view not in", values, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewBetween(Integer value1, Integer value2) {
            addCriterion("duration_view between", value1, value2, "durationView");
            return (Criteria) this;
        }

        public Criteria andDurationViewNotBetween(Integer value1, Integer value2) {
            addCriterion("duration_view not between", value1, value2, "durationView");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNull() {
            addCriterion("relation_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationIdEqualTo(Integer value) {
            addCriterion("relation_id =", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotEqualTo(Integer value) {
            addCriterion("relation_id <>", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThan(Integer value) {
            addCriterion("relation_id >", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("relation_id >=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThan(Integer value) {
            addCriterion("relation_id <", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThanOrEqualTo(Integer value) {
            addCriterion("relation_id <=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdIn(List<Integer> values) {
            addCriterion("relation_id in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotIn(List<Integer> values) {
            addCriterion("relation_id not in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdBetween(Integer value1, Integer value2) {
            addCriterion("relation_id between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("relation_id not between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsDelayIsNull() {
            addCriterion("is_delay is null");
            return (Criteria) this;
        }

        public Criteria andIsDelayIsNotNull() {
            addCriterion("is_delay is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelayEqualTo(Integer value) {
            addCriterion("is_delay =", value, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayNotEqualTo(Integer value) {
            addCriterion("is_delay <>", value, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayGreaterThan(Integer value) {
            addCriterion("is_delay >", value, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delay >=", value, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayLessThan(Integer value) {
            addCriterion("is_delay <", value, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayLessThanOrEqualTo(Integer value) {
            addCriterion("is_delay <=", value, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayIn(List<Integer> values) {
            addCriterion("is_delay in", values, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayNotIn(List<Integer> values) {
            addCriterion("is_delay not in", values, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayBetween(Integer value1, Integer value2) {
            addCriterion("is_delay between", value1, value2, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delay not between", value1, value2, "isDelay");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNull() {
            addCriterion("is_finish is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNotNull() {
            addCriterion("is_finish is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishEqualTo(Integer value) {
            addCriterion("is_finish =", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotEqualTo(Integer value) {
            addCriterion("is_finish <>", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThan(Integer value) {
            addCriterion("is_finish >", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_finish >=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThan(Integer value) {
            addCriterion("is_finish <", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThanOrEqualTo(Integer value) {
            addCriterion("is_finish <=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishIn(List<Integer> values) {
            addCriterion("is_finish in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotIn(List<Integer> values) {
            addCriterion("is_finish not in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishBetween(Integer value1, Integer value2) {
            addCriterion("is_finish between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("is_finish not between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdIsNull() {
            addCriterion("schedule_factor_category_id is null");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdIsNotNull() {
            addCriterion("schedule_factor_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdEqualTo(Integer value) {
            addCriterion("schedule_factor_category_id =", value, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdNotEqualTo(Integer value) {
            addCriterion("schedule_factor_category_id <>", value, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdGreaterThan(Integer value) {
            addCriterion("schedule_factor_category_id >", value, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_factor_category_id >=", value, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdLessThan(Integer value) {
            addCriterion("schedule_factor_category_id <", value, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_factor_category_id <=", value, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdIn(List<Integer> values) {
            addCriterion("schedule_factor_category_id in", values, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdNotIn(List<Integer> values) {
            addCriterion("schedule_factor_category_id not in", values, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("schedule_factor_category_id between", value1, value2, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_factor_category_id not between", value1, value2, "scheduleFactorCategoryId");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameIsNull() {
            addCriterion("schedule_factor_category_name is null");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameIsNotNull() {
            addCriterion("schedule_factor_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameEqualTo(String value) {
            addCriterion("schedule_factor_category_name =", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameNotEqualTo(String value) {
            addCriterion("schedule_factor_category_name <>", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameGreaterThan(String value) {
            addCriterion("schedule_factor_category_name >", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_factor_category_name >=", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameLessThan(String value) {
            addCriterion("schedule_factor_category_name <", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("schedule_factor_category_name <=", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameLike(String value) {
            addCriterion("schedule_factor_category_name like", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameNotLike(String value) {
            addCriterion("schedule_factor_category_name not like", value, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameIn(List<String> values) {
            addCriterion("schedule_factor_category_name in", values, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameNotIn(List<String> values) {
            addCriterion("schedule_factor_category_name not in", values, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameBetween(String value1, String value2) {
            addCriterion("schedule_factor_category_name between", value1, value2, "scheduleFactorCategoryName");
            return (Criteria) this;
        }

        public Criteria andScheduleFactorCategoryNameNotBetween(String value1, String value2) {
            addCriterion("schedule_factor_category_name not between", value1, value2, "scheduleFactorCategoryName");
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