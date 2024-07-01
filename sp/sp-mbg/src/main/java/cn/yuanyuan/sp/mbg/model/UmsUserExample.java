package cn.yuanyuan.sp.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class UmsUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsUserExample() {
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andIsForbidIsNull() {
            addCriterion("is_forbid is null");
            return (Criteria) this;
        }

        public Criteria andIsForbidIsNotNull() {
            addCriterion("is_forbid is not null");
            return (Criteria) this;
        }

        public Criteria andIsForbidEqualTo(Integer value) {
            addCriterion("is_forbid =", value, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidNotEqualTo(Integer value) {
            addCriterion("is_forbid <>", value, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidGreaterThan(Integer value) {
            addCriterion("is_forbid >", value, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_forbid >=", value, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidLessThan(Integer value) {
            addCriterion("is_forbid <", value, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidLessThanOrEqualTo(Integer value) {
            addCriterion("is_forbid <=", value, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidIn(List<Integer> values) {
            addCriterion("is_forbid in", values, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidNotIn(List<Integer> values) {
            addCriterion("is_forbid not in", values, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidBetween(Integer value1, Integer value2) {
            addCriterion("is_forbid between", value1, value2, "isForbid");
            return (Criteria) this;
        }

        public Criteria andIsForbidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_forbid not between", value1, value2, "isForbid");
            return (Criteria) this;
        }

        public Criteria andStatueIsNull() {
            addCriterion("statue is null");
            return (Criteria) this;
        }

        public Criteria andStatueIsNotNull() {
            addCriterion("statue is not null");
            return (Criteria) this;
        }

        public Criteria andStatueEqualTo(Integer value) {
            addCriterion("statue =", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotEqualTo(Integer value) {
            addCriterion("statue <>", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueGreaterThan(Integer value) {
            addCriterion("statue >", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueGreaterThanOrEqualTo(Integer value) {
            addCriterion("statue >=", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueLessThan(Integer value) {
            addCriterion("statue <", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueLessThanOrEqualTo(Integer value) {
            addCriterion("statue <=", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueIn(List<Integer> values) {
            addCriterion("statue in", values, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotIn(List<Integer> values) {
            addCriterion("statue not in", values, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueBetween(Integer value1, Integer value2) {
            addCriterion("statue between", value1, value2, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotBetween(Integer value1, Integer value2) {
            addCriterion("statue not between", value1, value2, "statue");
            return (Criteria) this;
        }

        public Criteria andIsNotifyIsNull() {
            addCriterion("is_notify is null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyIsNotNull() {
            addCriterion("is_notify is not null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyEqualTo(Integer value) {
            addCriterion("is_notify =", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyNotEqualTo(Integer value) {
            addCriterion("is_notify <>", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyGreaterThan(Integer value) {
            addCriterion("is_notify >", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_notify >=", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyLessThan(Integer value) {
            addCriterion("is_notify <", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("is_notify <=", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyIn(List<Integer> values) {
            addCriterion("is_notify in", values, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyNotIn(List<Integer> values) {
            addCriterion("is_notify not in", values, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBetween(Integer value1, Integer value2) {
            addCriterion("is_notify between", value1, value2, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_notify not between", value1, value2, "isNotify");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLikedBookIsNull() {
            addCriterion("liked_book is null");
            return (Criteria) this;
        }

        public Criteria andLikedBookIsNotNull() {
            addCriterion("liked_book is not null");
            return (Criteria) this;
        }

        public Criteria andLikedBookEqualTo(String value) {
            addCriterion("liked_book =", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookNotEqualTo(String value) {
            addCriterion("liked_book <>", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookGreaterThan(String value) {
            addCriterion("liked_book >", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookGreaterThanOrEqualTo(String value) {
            addCriterion("liked_book >=", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookLessThan(String value) {
            addCriterion("liked_book <", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookLessThanOrEqualTo(String value) {
            addCriterion("liked_book <=", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookLike(String value) {
            addCriterion("liked_book like", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookNotLike(String value) {
            addCriterion("liked_book not like", value, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookIn(List<String> values) {
            addCriterion("liked_book in", values, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookNotIn(List<String> values) {
            addCriterion("liked_book not in", values, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookBetween(String value1, String value2) {
            addCriterion("liked_book between", value1, value2, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedBookNotBetween(String value1, String value2) {
            addCriterion("liked_book not between", value1, value2, "likedBook");
            return (Criteria) this;
        }

        public Criteria andLikedThingIsNull() {
            addCriterion("liked_thing is null");
            return (Criteria) this;
        }

        public Criteria andLikedThingIsNotNull() {
            addCriterion("liked_thing is not null");
            return (Criteria) this;
        }

        public Criteria andLikedThingEqualTo(String value) {
            addCriterion("liked_thing =", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingNotEqualTo(String value) {
            addCriterion("liked_thing <>", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingGreaterThan(String value) {
            addCriterion("liked_thing >", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingGreaterThanOrEqualTo(String value) {
            addCriterion("liked_thing >=", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingLessThan(String value) {
            addCriterion("liked_thing <", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingLessThanOrEqualTo(String value) {
            addCriterion("liked_thing <=", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingLike(String value) {
            addCriterion("liked_thing like", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingNotLike(String value) {
            addCriterion("liked_thing not like", value, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingIn(List<String> values) {
            addCriterion("liked_thing in", values, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingNotIn(List<String> values) {
            addCriterion("liked_thing not in", values, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingBetween(String value1, String value2) {
            addCriterion("liked_thing between", value1, value2, "likedThing");
            return (Criteria) this;
        }

        public Criteria andLikedThingNotBetween(String value1, String value2) {
            addCriterion("liked_thing not between", value1, value2, "likedThing");
            return (Criteria) this;
        }

        public Criteria andSayingIsNull() {
            addCriterion("saying is null");
            return (Criteria) this;
        }

        public Criteria andSayingIsNotNull() {
            addCriterion("saying is not null");
            return (Criteria) this;
        }

        public Criteria andSayingEqualTo(String value) {
            addCriterion("saying =", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingNotEqualTo(String value) {
            addCriterion("saying <>", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingGreaterThan(String value) {
            addCriterion("saying >", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingGreaterThanOrEqualTo(String value) {
            addCriterion("saying >=", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingLessThan(String value) {
            addCriterion("saying <", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingLessThanOrEqualTo(String value) {
            addCriterion("saying <=", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingLike(String value) {
            addCriterion("saying like", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingNotLike(String value) {
            addCriterion("saying not like", value, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingIn(List<String> values) {
            addCriterion("saying in", values, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingNotIn(List<String> values) {
            addCriterion("saying not in", values, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingBetween(String value1, String value2) {
            addCriterion("saying between", value1, value2, "saying");
            return (Criteria) this;
        }

        public Criteria andSayingNotBetween(String value1, String value2) {
            addCriterion("saying not between", value1, value2, "saying");
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