package com.tdzx.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusiStudentinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusiStudentinfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdIsNull() {
            addCriterion("org_full_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdIsNotNull() {
            addCriterion("org_full_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdEqualTo(String value) {
            addCriterion("org_full_id =", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdNotEqualTo(String value) {
            addCriterion("org_full_id <>", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdGreaterThan(String value) {
            addCriterion("org_full_id >", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_full_id >=", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdLessThan(String value) {
            addCriterion("org_full_id <", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdLessThanOrEqualTo(String value) {
            addCriterion("org_full_id <=", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdLike(String value) {
            addCriterion("org_full_id like", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdNotLike(String value) {
            addCriterion("org_full_id not like", value, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdIn(List<String> values) {
            addCriterion("org_full_id in", values, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdNotIn(List<String> values) {
            addCriterion("org_full_id not in", values, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdBetween(String value1, String value2) {
            addCriterion("org_full_id between", value1, value2, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andOrgFullIdNotBetween(String value1, String value2) {
            addCriterion("org_full_id not between", value1, value2, "orgFullId");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("studentname is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentname is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentname =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentname <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentname >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentname >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentname <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentname <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentname like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentname not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentname in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentname not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentname between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentname not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andXhIsNull() {
            addCriterion("xh is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("xh is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(String value) {
            addCriterion("xh =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(String value) {
            addCriterion("xh <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(String value) {
            addCriterion("xh >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(String value) {
            addCriterion("xh >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(String value) {
            addCriterion("xh <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(String value) {
            addCriterion("xh <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLike(String value) {
            addCriterion("xh like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotLike(String value) {
            addCriterion("xh not like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<String> values) {
            addCriterion("xh in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<String> values) {
            addCriterion("xh not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(String value1, String value2) {
            addCriterion("xh between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(String value1, String value2) {
            addCriterion("xh not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andSfpksIsNull() {
            addCriterion("sfpks is null");
            return (Criteria) this;
        }

        public Criteria andSfpksIsNotNull() {
            addCriterion("sfpks is not null");
            return (Criteria) this;
        }

        public Criteria andSfpksEqualTo(String value) {
            addCriterion("sfpks =", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksNotEqualTo(String value) {
            addCriterion("sfpks <>", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksGreaterThan(String value) {
            addCriterion("sfpks >", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksGreaterThanOrEqualTo(String value) {
            addCriterion("sfpks >=", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksLessThan(String value) {
            addCriterion("sfpks <", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksLessThanOrEqualTo(String value) {
            addCriterion("sfpks <=", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksLike(String value) {
            addCriterion("sfpks like", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksNotLike(String value) {
            addCriterion("sfpks not like", value, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksIn(List<String> values) {
            addCriterion("sfpks in", values, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksNotIn(List<String> values) {
            addCriterion("sfpks not in", values, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksBetween(String value1, String value2) {
            addCriterion("sfpks between", value1, value2, "sfpks");
            return (Criteria) this;
        }

        public Criteria andSfpksNotBetween(String value1, String value2) {
            addCriterion("sfpks not between", value1, value2, "sfpks");
            return (Criteria) this;
        }

        public Criteria andJzxmIsNull() {
            addCriterion("jzxm is null");
            return (Criteria) this;
        }

        public Criteria andJzxmIsNotNull() {
            addCriterion("jzxm is not null");
            return (Criteria) this;
        }

        public Criteria andJzxmEqualTo(String value) {
            addCriterion("jzxm =", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmNotEqualTo(String value) {
            addCriterion("jzxm <>", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmGreaterThan(String value) {
            addCriterion("jzxm >", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmGreaterThanOrEqualTo(String value) {
            addCriterion("jzxm >=", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmLessThan(String value) {
            addCriterion("jzxm <", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmLessThanOrEqualTo(String value) {
            addCriterion("jzxm <=", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmLike(String value) {
            addCriterion("jzxm like", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmNotLike(String value) {
            addCriterion("jzxm not like", value, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmIn(List<String> values) {
            addCriterion("jzxm in", values, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmNotIn(List<String> values) {
            addCriterion("jzxm not in", values, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmBetween(String value1, String value2) {
            addCriterion("jzxm between", value1, value2, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzxmNotBetween(String value1, String value2) {
            addCriterion("jzxm not between", value1, value2, "jzxm");
            return (Criteria) this;
        }

        public Criteria andJzmobileIsNull() {
            addCriterion("jzmobile is null");
            return (Criteria) this;
        }

        public Criteria andJzmobileIsNotNull() {
            addCriterion("jzmobile is not null");
            return (Criteria) this;
        }

        public Criteria andJzmobileEqualTo(String value) {
            addCriterion("jzmobile =", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileNotEqualTo(String value) {
            addCriterion("jzmobile <>", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileGreaterThan(String value) {
            addCriterion("jzmobile >", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileGreaterThanOrEqualTo(String value) {
            addCriterion("jzmobile >=", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileLessThan(String value) {
            addCriterion("jzmobile <", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileLessThanOrEqualTo(String value) {
            addCriterion("jzmobile <=", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileLike(String value) {
            addCriterion("jzmobile like", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileNotLike(String value) {
            addCriterion("jzmobile not like", value, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileIn(List<String> values) {
            addCriterion("jzmobile in", values, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileNotIn(List<String> values) {
            addCriterion("jzmobile not in", values, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileBetween(String value1, String value2) {
            addCriterion("jzmobile between", value1, value2, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andJzmobileNotBetween(String value1, String value2) {
            addCriterion("jzmobile not between", value1, value2, "jzmobile");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNull() {
            addCriterion("schoolid is null");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNotNull() {
            addCriterion("schoolid is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolidEqualTo(String value) {
            addCriterion("schoolid =", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotEqualTo(String value) {
            addCriterion("schoolid <>", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThan(String value) {
            addCriterion("schoolid >", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThanOrEqualTo(String value) {
            addCriterion("schoolid >=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThan(String value) {
            addCriterion("schoolid <", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThanOrEqualTo(String value) {
            addCriterion("schoolid <=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLike(String value) {
            addCriterion("schoolid like", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotLike(String value) {
            addCriterion("schoolid not like", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidIn(List<String> values) {
            addCriterion("schoolid in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotIn(List<String> values) {
            addCriterion("schoolid not in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidBetween(String value1, String value2) {
            addCriterion("schoolid between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotBetween(String value1, String value2) {
            addCriterion("schoolid not between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNull() {
            addCriterion("schoolname is null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNotNull() {
            addCriterion("schoolname is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameEqualTo(String value) {
            addCriterion("schoolname =", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotEqualTo(String value) {
            addCriterion("schoolname <>", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThan(String value) {
            addCriterion("schoolname >", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThanOrEqualTo(String value) {
            addCriterion("schoolname >=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThan(String value) {
            addCriterion("schoolname <", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThanOrEqualTo(String value) {
            addCriterion("schoolname <=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLike(String value) {
            addCriterion("schoolname like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotLike(String value) {
            addCriterion("schoolname not like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIn(List<String> values) {
            addCriterion("schoolname in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotIn(List<String> values) {
            addCriterion("schoolname not in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameBetween(String value1, String value2) {
            addCriterion("schoolname between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotBetween(String value1, String value2) {
            addCriterion("schoolname not between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andGradeidIsNull() {
            addCriterion("gradeid is null");
            return (Criteria) this;
        }

        public Criteria andGradeidIsNotNull() {
            addCriterion("gradeid is not null");
            return (Criteria) this;
        }

        public Criteria andGradeidEqualTo(String value) {
            addCriterion("gradeid =", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotEqualTo(String value) {
            addCriterion("gradeid <>", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidGreaterThan(String value) {
            addCriterion("gradeid >", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidGreaterThanOrEqualTo(String value) {
            addCriterion("gradeid >=", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidLessThan(String value) {
            addCriterion("gradeid <", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidLessThanOrEqualTo(String value) {
            addCriterion("gradeid <=", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidLike(String value) {
            addCriterion("gradeid like", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotLike(String value) {
            addCriterion("gradeid not like", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidIn(List<String> values) {
            addCriterion("gradeid in", values, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotIn(List<String> values) {
            addCriterion("gradeid not in", values, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidBetween(String value1, String value2) {
            addCriterion("gradeid between", value1, value2, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotBetween(String value1, String value2) {
            addCriterion("gradeid not between", value1, value2, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classid is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classid is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(String value) {
            addCriterion("classid =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(String value) {
            addCriterion("classid <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(String value) {
            addCriterion("classid >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(String value) {
            addCriterion("classid >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(String value) {
            addCriterion("classid <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(String value) {
            addCriterion("classid <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLike(String value) {
            addCriterion("classid like", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotLike(String value) {
            addCriterion("classid not like", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<String> values) {
            addCriterion("classid in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<String> values) {
            addCriterion("classid not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(String value1, String value2) {
            addCriterion("classid between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(String value1, String value2) {
            addCriterion("classid not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andGsnameIsNull() {
            addCriterion("gsname is null");
            return (Criteria) this;
        }

        public Criteria andGsnameIsNotNull() {
            addCriterion("gsname is not null");
            return (Criteria) this;
        }

        public Criteria andGsnameEqualTo(String value) {
            addCriterion("gsname =", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameNotEqualTo(String value) {
            addCriterion("gsname <>", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameGreaterThan(String value) {
            addCriterion("gsname >", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameGreaterThanOrEqualTo(String value) {
            addCriterion("gsname >=", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameLessThan(String value) {
            addCriterion("gsname <", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameLessThanOrEqualTo(String value) {
            addCriterion("gsname <=", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameLike(String value) {
            addCriterion("gsname like", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameNotLike(String value) {
            addCriterion("gsname not like", value, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameIn(List<String> values) {
            addCriterion("gsname in", values, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameNotIn(List<String> values) {
            addCriterion("gsname not in", values, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameBetween(String value1, String value2) {
            addCriterion("gsname between", value1, value2, "gsname");
            return (Criteria) this;
        }

        public Criteria andGsnameNotBetween(String value1, String value2) {
            addCriterion("gsname not between", value1, value2, "gsname");
            return (Criteria) this;
        }

        public Criteria andGscodeIsNull() {
            addCriterion("gscode is null");
            return (Criteria) this;
        }

        public Criteria andGscodeIsNotNull() {
            addCriterion("gscode is not null");
            return (Criteria) this;
        }

        public Criteria andGscodeEqualTo(String value) {
            addCriterion("gscode =", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeNotEqualTo(String value) {
            addCriterion("gscode <>", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeGreaterThan(String value) {
            addCriterion("gscode >", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeGreaterThanOrEqualTo(String value) {
            addCriterion("gscode >=", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeLessThan(String value) {
            addCriterion("gscode <", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeLessThanOrEqualTo(String value) {
            addCriterion("gscode <=", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeLike(String value) {
            addCriterion("gscode like", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeNotLike(String value) {
            addCriterion("gscode not like", value, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeIn(List<String> values) {
            addCriterion("gscode in", values, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeNotIn(List<String> values) {
            addCriterion("gscode not in", values, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeBetween(String value1, String value2) {
            addCriterion("gscode between", value1, value2, "gscode");
            return (Criteria) this;
        }

        public Criteria andGscodeNotBetween(String value1, String value2) {
            addCriterion("gscode not between", value1, value2, "gscode");
            return (Criteria) this;
        }

        public Criteria andMobilecreateIsNull() {
            addCriterion("mobileCreate is null");
            return (Criteria) this;
        }

        public Criteria andMobilecreateIsNotNull() {
            addCriterion("mobileCreate is not null");
            return (Criteria) this;
        }

        public Criteria andMobilecreateEqualTo(Integer value) {
            addCriterion("mobileCreate =", value, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateNotEqualTo(Integer value) {
            addCriterion("mobileCreate <>", value, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateGreaterThan(Integer value) {
            addCriterion("mobileCreate >", value, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateGreaterThanOrEqualTo(Integer value) {
            addCriterion("mobileCreate >=", value, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateLessThan(Integer value) {
            addCriterion("mobileCreate <", value, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateLessThanOrEqualTo(Integer value) {
            addCriterion("mobileCreate <=", value, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateIn(List<Integer> values) {
            addCriterion("mobileCreate in", values, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateNotIn(List<Integer> values) {
            addCriterion("mobileCreate not in", values, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateBetween(Integer value1, Integer value2) {
            addCriterion("mobileCreate between", value1, value2, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andMobilecreateNotBetween(Integer value1, Integer value2) {
            addCriterion("mobileCreate not between", value1, value2, "mobilecreate");
            return (Criteria) this;
        }

        public Criteria andCreuseridIsNull() {
            addCriterion("creuserid is null");
            return (Criteria) this;
        }

        public Criteria andCreuseridIsNotNull() {
            addCriterion("creuserid is not null");
            return (Criteria) this;
        }

        public Criteria andCreuseridEqualTo(Integer value) {
            addCriterion("creuserid =", value, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridNotEqualTo(Integer value) {
            addCriterion("creuserid <>", value, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridGreaterThan(Integer value) {
            addCriterion("creuserid >", value, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("creuserid >=", value, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridLessThan(Integer value) {
            addCriterion("creuserid <", value, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridLessThanOrEqualTo(Integer value) {
            addCriterion("creuserid <=", value, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridIn(List<Integer> values) {
            addCriterion("creuserid in", values, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridNotIn(List<Integer> values) {
            addCriterion("creuserid not in", values, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridBetween(Integer value1, Integer value2) {
            addCriterion("creuserid between", value1, value2, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("creuserid not between", value1, value2, "creuserid");
            return (Criteria) this;
        }

        public Criteria andCreusernameIsNull() {
            addCriterion("creusername is null");
            return (Criteria) this;
        }

        public Criteria andCreusernameIsNotNull() {
            addCriterion("creusername is not null");
            return (Criteria) this;
        }

        public Criteria andCreusernameEqualTo(String value) {
            addCriterion("creusername =", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameNotEqualTo(String value) {
            addCriterion("creusername <>", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameGreaterThan(String value) {
            addCriterion("creusername >", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameGreaterThanOrEqualTo(String value) {
            addCriterion("creusername >=", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameLessThan(String value) {
            addCriterion("creusername <", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameLessThanOrEqualTo(String value) {
            addCriterion("creusername <=", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameLike(String value) {
            addCriterion("creusername like", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameNotLike(String value) {
            addCriterion("creusername not like", value, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameIn(List<String> values) {
            addCriterion("creusername in", values, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameNotIn(List<String> values) {
            addCriterion("creusername not in", values, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameBetween(String value1, String value2) {
            addCriterion("creusername between", value1, value2, "creusername");
            return (Criteria) this;
        }

        public Criteria andCreusernameNotBetween(String value1, String value2) {
            addCriterion("creusername not between", value1, value2, "creusername");
            return (Criteria) this;
        }

        public Criteria andCretimeIsNull() {
            addCriterion("cretime is null");
            return (Criteria) this;
        }

        public Criteria andCretimeIsNotNull() {
            addCriterion("cretime is not null");
            return (Criteria) this;
        }

        public Criteria andCretimeEqualTo(Date value) {
            addCriterion("cretime =", value, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeNotEqualTo(Date value) {
            addCriterion("cretime <>", value, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeGreaterThan(Date value) {
            addCriterion("cretime >", value, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cretime >=", value, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeLessThan(Date value) {
            addCriterion("cretime <", value, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeLessThanOrEqualTo(Date value) {
            addCriterion("cretime <=", value, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeIn(List<Date> values) {
            addCriterion("cretime in", values, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeNotIn(List<Date> values) {
            addCriterion("cretime not in", values, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeBetween(Date value1, Date value2) {
            addCriterion("cretime between", value1, value2, "cretime");
            return (Criteria) this;
        }

        public Criteria andCretimeNotBetween(Date value1, Date value2) {
            addCriterion("cretime not between", value1, value2, "cretime");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidIsNull() {
            addCriterion("creuserdepid is null");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidIsNotNull() {
            addCriterion("creuserdepid is not null");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidEqualTo(Integer value) {
            addCriterion("creuserdepid =", value, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidNotEqualTo(Integer value) {
            addCriterion("creuserdepid <>", value, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidGreaterThan(Integer value) {
            addCriterion("creuserdepid >", value, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidGreaterThanOrEqualTo(Integer value) {
            addCriterion("creuserdepid >=", value, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidLessThan(Integer value) {
            addCriterion("creuserdepid <", value, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidLessThanOrEqualTo(Integer value) {
            addCriterion("creuserdepid <=", value, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidIn(List<Integer> values) {
            addCriterion("creuserdepid in", values, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidNotIn(List<Integer> values) {
            addCriterion("creuserdepid not in", values, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidBetween(Integer value1, Integer value2) {
            addCriterion("creuserdepid between", value1, value2, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepidNotBetween(Integer value1, Integer value2) {
            addCriterion("creuserdepid not between", value1, value2, "creuserdepid");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameIsNull() {
            addCriterion("creuserdepname is null");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameIsNotNull() {
            addCriterion("creuserdepname is not null");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameEqualTo(String value) {
            addCriterion("creuserdepname =", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameNotEqualTo(String value) {
            addCriterion("creuserdepname <>", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameGreaterThan(String value) {
            addCriterion("creuserdepname >", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameGreaterThanOrEqualTo(String value) {
            addCriterion("creuserdepname >=", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameLessThan(String value) {
            addCriterion("creuserdepname <", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameLessThanOrEqualTo(String value) {
            addCriterion("creuserdepname <=", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameLike(String value) {
            addCriterion("creuserdepname like", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameNotLike(String value) {
            addCriterion("creuserdepname not like", value, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameIn(List<String> values) {
            addCriterion("creuserdepname in", values, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameNotIn(List<String> values) {
            addCriterion("creuserdepname not in", values, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameBetween(String value1, String value2) {
            addCriterion("creuserdepname between", value1, value2, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andCreuserdepnameNotBetween(String value1, String value2) {
            addCriterion("creuserdepname not between", value1, value2, "creuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuseridIsNull() {
            addCriterion("modifyuserid is null");
            return (Criteria) this;
        }

        public Criteria andModifyuseridIsNotNull() {
            addCriterion("modifyuserid is not null");
            return (Criteria) this;
        }

        public Criteria andModifyuseridEqualTo(Integer value) {
            addCriterion("modifyuserid =", value, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridNotEqualTo(Integer value) {
            addCriterion("modifyuserid <>", value, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridGreaterThan(Integer value) {
            addCriterion("modifyuserid >", value, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("modifyuserid >=", value, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridLessThan(Integer value) {
            addCriterion("modifyuserid <", value, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridLessThanOrEqualTo(Integer value) {
            addCriterion("modifyuserid <=", value, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridIn(List<Integer> values) {
            addCriterion("modifyuserid in", values, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridNotIn(List<Integer> values) {
            addCriterion("modifyuserid not in", values, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridBetween(Integer value1, Integer value2) {
            addCriterion("modifyuserid between", value1, value2, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("modifyuserid not between", value1, value2, "modifyuserid");
            return (Criteria) this;
        }

        public Criteria andModifyusernameIsNull() {
            addCriterion("modifyusername is null");
            return (Criteria) this;
        }

        public Criteria andModifyusernameIsNotNull() {
            addCriterion("modifyusername is not null");
            return (Criteria) this;
        }

        public Criteria andModifyusernameEqualTo(String value) {
            addCriterion("modifyusername =", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameNotEqualTo(String value) {
            addCriterion("modifyusername <>", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameGreaterThan(String value) {
            addCriterion("modifyusername >", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameGreaterThanOrEqualTo(String value) {
            addCriterion("modifyusername >=", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameLessThan(String value) {
            addCriterion("modifyusername <", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameLessThanOrEqualTo(String value) {
            addCriterion("modifyusername <=", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameLike(String value) {
            addCriterion("modifyusername like", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameNotLike(String value) {
            addCriterion("modifyusername not like", value, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameIn(List<String> values) {
            addCriterion("modifyusername in", values, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameNotIn(List<String> values) {
            addCriterion("modifyusername not in", values, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameBetween(String value1, String value2) {
            addCriterion("modifyusername between", value1, value2, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifyusernameNotBetween(String value1, String value2) {
            addCriterion("modifyusername not between", value1, value2, "modifyusername");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifytime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidIsNull() {
            addCriterion("modifyuserdepid is null");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidIsNotNull() {
            addCriterion("modifyuserdepid is not null");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidEqualTo(Integer value) {
            addCriterion("modifyuserdepid =", value, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidNotEqualTo(Integer value) {
            addCriterion("modifyuserdepid <>", value, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidGreaterThan(Integer value) {
            addCriterion("modifyuserdepid >", value, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidGreaterThanOrEqualTo(Integer value) {
            addCriterion("modifyuserdepid >=", value, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidLessThan(Integer value) {
            addCriterion("modifyuserdepid <", value, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidLessThanOrEqualTo(Integer value) {
            addCriterion("modifyuserdepid <=", value, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidIn(List<Integer> values) {
            addCriterion("modifyuserdepid in", values, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidNotIn(List<Integer> values) {
            addCriterion("modifyuserdepid not in", values, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidBetween(Integer value1, Integer value2) {
            addCriterion("modifyuserdepid between", value1, value2, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepidNotBetween(Integer value1, Integer value2) {
            addCriterion("modifyuserdepid not between", value1, value2, "modifyuserdepid");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameIsNull() {
            addCriterion("modifyuserdepname is null");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameIsNotNull() {
            addCriterion("modifyuserdepname is not null");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameEqualTo(String value) {
            addCriterion("modifyuserdepname =", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameNotEqualTo(String value) {
            addCriterion("modifyuserdepname <>", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameGreaterThan(String value) {
            addCriterion("modifyuserdepname >", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameGreaterThanOrEqualTo(String value) {
            addCriterion("modifyuserdepname >=", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameLessThan(String value) {
            addCriterion("modifyuserdepname <", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameLessThanOrEqualTo(String value) {
            addCriterion("modifyuserdepname <=", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameLike(String value) {
            addCriterion("modifyuserdepname like", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameNotLike(String value) {
            addCriterion("modifyuserdepname not like", value, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameIn(List<String> values) {
            addCriterion("modifyuserdepname in", values, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameNotIn(List<String> values) {
            addCriterion("modifyuserdepname not in", values, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameBetween(String value1, String value2) {
            addCriterion("modifyuserdepname between", value1, value2, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andModifyuserdepnameNotBetween(String value1, String value2) {
            addCriterion("modifyuserdepname not between", value1, value2, "modifyuserdepname");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andFacctidIsNull() {
            addCriterion("fAcctID is null");
            return (Criteria) this;
        }

        public Criteria andFacctidIsNotNull() {
            addCriterion("fAcctID is not null");
            return (Criteria) this;
        }

        public Criteria andFacctidEqualTo(Integer value) {
            addCriterion("fAcctID =", value, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidNotEqualTo(Integer value) {
            addCriterion("fAcctID <>", value, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidGreaterThan(Integer value) {
            addCriterion("fAcctID >", value, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fAcctID >=", value, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidLessThan(Integer value) {
            addCriterion("fAcctID <", value, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidLessThanOrEqualTo(Integer value) {
            addCriterion("fAcctID <=", value, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidIn(List<Integer> values) {
            addCriterion("fAcctID in", values, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidNotIn(List<Integer> values) {
            addCriterion("fAcctID not in", values, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidBetween(Integer value1, Integer value2) {
            addCriterion("fAcctID between", value1, value2, "facctid");
            return (Criteria) this;
        }

        public Criteria andFacctidNotBetween(Integer value1, Integer value2) {
            addCriterion("fAcctID not between", value1, value2, "facctid");
            return (Criteria) this;
        }

        public Criteria andWxIdIsNull() {
            addCriterion("wx_id is null");
            return (Criteria) this;
        }

        public Criteria andWxIdIsNotNull() {
            addCriterion("wx_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxIdEqualTo(String value) {
            addCriterion("wx_id =", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotEqualTo(String value) {
            addCriterion("wx_id <>", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdGreaterThan(String value) {
            addCriterion("wx_id >", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_id >=", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdLessThan(String value) {
            addCriterion("wx_id <", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdLessThanOrEqualTo(String value) {
            addCriterion("wx_id <=", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdLike(String value) {
            addCriterion("wx_id like", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotLike(String value) {
            addCriterion("wx_id not like", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdIn(List<String> values) {
            addCriterion("wx_id in", values, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotIn(List<String> values) {
            addCriterion("wx_id not in", values, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdBetween(String value1, String value2) {
            addCriterion("wx_id between", value1, value2, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotBetween(String value1, String value2) {
            addCriterion("wx_id not between", value1, value2, "wxId");
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