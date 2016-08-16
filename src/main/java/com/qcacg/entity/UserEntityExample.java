package com.qcacg.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("UserId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("UserId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("UserId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("UserId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("UserId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("UserId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("UserId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("UserId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UserId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("UserName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("UserName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("UserName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("UserName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("UserName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("UserName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("UserName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("UserName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("UserName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("UserName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("UserName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("UserName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("UserName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("UserName not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("Telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("Telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("Telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("Telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("Telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("Telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("Telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("Telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("Telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("Telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("Telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("Telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("Telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("Telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("PassWord is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("PassWord is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("PassWord =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("PassWord <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("PassWord >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("PassWord >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("PassWord <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("PassWord <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("PassWord like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("PassWord not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("PassWord in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("PassWord not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("PassWord between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("PassWord not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CreateDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CreateDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CreateDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CreateDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CreateDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CreateDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CreateDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CreateDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CreateDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNull() {
            addCriterion("LastLoginDate is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNotNull() {
            addCriterion("LastLoginDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateEqualTo(Date value) {
            addCriterion("LastLoginDate =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotEqualTo(Date value) {
            addCriterion("LastLoginDate <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThan(Date value) {
            addCriterion("LastLoginDate >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LastLoginDate >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThan(Date value) {
            addCriterion("LastLoginDate <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("LastLoginDate <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIn(List<Date> values) {
            addCriterion("LastLoginDate in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotIn(List<Date> values) {
            addCriterion("LastLoginDate not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateBetween(Date value1, Date value2) {
            addCriterion("LastLoginDate between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("LastLoginDate not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("UserStatus is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("UserStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(String value) {
            addCriterion("UserStatus =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(String value) {
            addCriterion("UserStatus <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(String value) {
            addCriterion("UserStatus >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("UserStatus >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(String value) {
            addCriterion("UserStatus <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(String value) {
            addCriterion("UserStatus <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLike(String value) {
            addCriterion("UserStatus like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotLike(String value) {
            addCriterion("UserStatus not like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<String> values) {
            addCriterion("UserStatus in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<String> values) {
            addCriterion("UserStatus not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(String value1, String value2) {
            addCriterion("UserStatus between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(String value1, String value2) {
            addCriterion("UserStatus not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserHeadIsNull() {
            addCriterion("UserHead is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadIsNotNull() {
            addCriterion("UserHead is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadEqualTo(String value) {
            addCriterion("UserHead =", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadNotEqualTo(String value) {
            addCriterion("UserHead <>", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadGreaterThan(String value) {
            addCriterion("UserHead >", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadGreaterThanOrEqualTo(String value) {
            addCriterion("UserHead >=", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadLessThan(String value) {
            addCriterion("UserHead <", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadLessThanOrEqualTo(String value) {
            addCriterion("UserHead <=", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadLike(String value) {
            addCriterion("UserHead like", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadNotLike(String value) {
            addCriterion("UserHead not like", value, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadIn(List<String> values) {
            addCriterion("UserHead in", values, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadNotIn(List<String> values) {
            addCriterion("UserHead not in", values, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadBetween(String value1, String value2) {
            addCriterion("UserHead between", value1, value2, "userHead");
            return (Criteria) this;
        }

        public Criteria andUserHeadNotBetween(String value1, String value2) {
            addCriterion("UserHead not between", value1, value2, "userHead");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("Sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("Sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("Sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("Sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("Sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("Sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("Sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("Sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("Sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("Sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("Sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("Sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("Sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("Sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleIsNull() {
            addCriterion("InvitePeople is null");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleIsNotNull() {
            addCriterion("InvitePeople is not null");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleEqualTo(String value) {
            addCriterion("InvitePeople =", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleNotEqualTo(String value) {
            addCriterion("InvitePeople <>", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleGreaterThan(String value) {
            addCriterion("InvitePeople >", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("InvitePeople >=", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleLessThan(String value) {
            addCriterion("InvitePeople <", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleLessThanOrEqualTo(String value) {
            addCriterion("InvitePeople <=", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleLike(String value) {
            addCriterion("InvitePeople like", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleNotLike(String value) {
            addCriterion("InvitePeople not like", value, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleIn(List<String> values) {
            addCriterion("InvitePeople in", values, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleNotIn(List<String> values) {
            addCriterion("InvitePeople not in", values, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleBetween(String value1, String value2) {
            addCriterion("InvitePeople between", value1, value2, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andInvitePeopleNotBetween(String value1, String value2) {
            addCriterion("InvitePeople not between", value1, value2, "invitePeople");
            return (Criteria) this;
        }

        public Criteria andIPIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIPIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIPEqualTo(String value) {
            addCriterion("IP =", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotEqualTo(String value) {
            addCriterion("IP <>", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPGreaterThan(String value) {
            addCriterion("IP >", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPLessThan(String value) {
            addCriterion("IP <", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPLike(String value) {
            addCriterion("IP like", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotLike(String value) {
            addCriterion("IP not like", value, "IP");
            return (Criteria) this;
        }

        public Criteria andIPIn(List<String> values) {
            addCriterion("IP in", values, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotIn(List<String> values) {
            addCriterion("IP not in", values, "IP");
            return (Criteria) this;
        }

        public Criteria andIPBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "IP");
            return (Criteria) this;
        }

        public Criteria andIPNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "IP");
            return (Criteria) this;
        }

        public Criteria andInformationIsNull() {
            addCriterion("Information is null");
            return (Criteria) this;
        }

        public Criteria andInformationIsNotNull() {
            addCriterion("Information is not null");
            return (Criteria) this;
        }

        public Criteria andInformationEqualTo(String value) {
            addCriterion("Information =", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotEqualTo(String value) {
            addCriterion("Information <>", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThan(String value) {
            addCriterion("Information >", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThanOrEqualTo(String value) {
            addCriterion("Information >=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThan(String value) {
            addCriterion("Information <", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThanOrEqualTo(String value) {
            addCriterion("Information <=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLike(String value) {
            addCriterion("Information like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotLike(String value) {
            addCriterion("Information not like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationIn(List<String> values) {
            addCriterion("Information in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotIn(List<String> values) {
            addCriterion("Information not in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationBetween(String value1, String value2) {
            addCriterion("Information between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotBetween(String value1, String value2) {
            addCriterion("Information not between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltIsNull() {
            addCriterion("CredentialsSalt is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltIsNotNull() {
            addCriterion("CredentialsSalt is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltEqualTo(String value) {
            addCriterion("CredentialsSalt =", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltNotEqualTo(String value) {
            addCriterion("CredentialsSalt <>", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltGreaterThan(String value) {
            addCriterion("CredentialsSalt >", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltGreaterThanOrEqualTo(String value) {
            addCriterion("CredentialsSalt >=", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltLessThan(String value) {
            addCriterion("CredentialsSalt <", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltLessThanOrEqualTo(String value) {
            addCriterion("CredentialsSalt <=", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltLike(String value) {
            addCriterion("CredentialsSalt like", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltNotLike(String value) {
            addCriterion("CredentialsSalt not like", value, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltIn(List<String> values) {
            addCriterion("CredentialsSalt in", values, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltNotIn(List<String> values) {
            addCriterion("CredentialsSalt not in", values, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltBetween(String value1, String value2) {
            addCriterion("CredentialsSalt between", value1, value2, "credentialsSalt");
            return (Criteria) this;
        }

        public Criteria andCredentialsSaltNotBetween(String value1, String value2) {
            addCriterion("CredentialsSalt not between", value1, value2, "credentialsSalt");
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