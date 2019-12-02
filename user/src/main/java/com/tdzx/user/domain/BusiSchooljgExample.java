package com.tdzx.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusiSchooljgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusiSchooljgExample() {
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

        public Criteria andParentsIsNull() {
            addCriterion("parents is null");
            return (Criteria) this;
        }

        public Criteria andParentsIsNotNull() {
            addCriterion("parents is not null");
            return (Criteria) this;
        }

        public Criteria andParentsEqualTo(String value) {
            addCriterion("parents =", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotEqualTo(String value) {
            addCriterion("parents <>", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsGreaterThan(String value) {
            addCriterion("parents >", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsGreaterThanOrEqualTo(String value) {
            addCriterion("parents >=", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsLessThan(String value) {
            addCriterion("parents <", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsLessThanOrEqualTo(String value) {
            addCriterion("parents <=", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsLike(String value) {
            addCriterion("parents like", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotLike(String value) {
            addCriterion("parents not like", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsIn(List<String> values) {
            addCriterion("parents in", values, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotIn(List<String> values) {
            addCriterion("parents not in", values, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsBetween(String value1, String value2) {
            addCriterion("parents between", value1, value2, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotBetween(String value1, String value2) {
            addCriterion("parents not between", value1, value2, "parents");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andSortsIsNull() {
            addCriterion("sorts is null");
            return (Criteria) this;
        }

        public Criteria andSortsIsNotNull() {
            addCriterion("sorts is not null");
            return (Criteria) this;
        }

        public Criteria andSortsEqualTo(String value) {
            addCriterion("sorts =", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotEqualTo(String value) {
            addCriterion("sorts <>", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThan(String value) {
            addCriterion("sorts >", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThanOrEqualTo(String value) {
            addCriterion("sorts >=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThan(String value) {
            addCriterion("sorts <", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThanOrEqualTo(String value) {
            addCriterion("sorts <=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLike(String value) {
            addCriterion("sorts like", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotLike(String value) {
            addCriterion("sorts not like", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsIn(List<String> values) {
            addCriterion("sorts in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotIn(List<String> values) {
            addCriterion("sorts not in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsBetween(String value1, String value2) {
            addCriterion("sorts between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotBetween(String value1, String value2) {
            addCriterion("sorts not between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNull() {
            addCriterion("levels is null");
            return (Criteria) this;
        }

        public Criteria andLevelsIsNotNull() {
            addCriterion("levels is not null");
            return (Criteria) this;
        }

        public Criteria andLevelsEqualTo(Integer value) {
            addCriterion("levels =", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotEqualTo(Integer value) {
            addCriterion("levels <>", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThan(Integer value) {
            addCriterion("levels >", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsGreaterThanOrEqualTo(Integer value) {
            addCriterion("levels >=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThan(Integer value) {
            addCriterion("levels <", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsLessThanOrEqualTo(Integer value) {
            addCriterion("levels <=", value, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsIn(List<Integer> values) {
            addCriterion("levels in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotIn(List<Integer> values) {
            addCriterion("levels not in", values, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsBetween(Integer value1, Integer value2) {
            addCriterion("levels between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andLevelsNotBetween(Integer value1, Integer value2) {
            addCriterion("levels not between", value1, value2, "levels");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(String value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(String value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(String value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(String value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(String value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(String value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLike(String value) {
            addCriterion("school_id like", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotLike(String value) {
            addCriterion("school_id not like", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<String> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<String> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(String value1, String value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(String value1, String value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Integer value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Integer value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Integer value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Integer value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Integer> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Integer> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
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

        public Criteria andZbmIsNull() {
            addCriterion("zbm is null");
            return (Criteria) this;
        }

        public Criteria andZbmIsNotNull() {
            addCriterion("zbm is not null");
            return (Criteria) this;
        }

        public Criteria andZbmEqualTo(String value) {
            addCriterion("zbm =", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmNotEqualTo(String value) {
            addCriterion("zbm <>", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmGreaterThan(String value) {
            addCriterion("zbm >", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmGreaterThanOrEqualTo(String value) {
            addCriterion("zbm >=", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmLessThan(String value) {
            addCriterion("zbm <", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmLessThanOrEqualTo(String value) {
            addCriterion("zbm <=", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmLike(String value) {
            addCriterion("zbm like", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmNotLike(String value) {
            addCriterion("zbm not like", value, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmIn(List<String> values) {
            addCriterion("zbm in", values, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmNotIn(List<String> values) {
            addCriterion("zbm not in", values, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmBetween(String value1, String value2) {
            addCriterion("zbm between", value1, value2, "zbm");
            return (Criteria) this;
        }

        public Criteria andZbmNotBetween(String value1, String value2) {
            addCriterion("zbm not between", value1, value2, "zbm");
            return (Criteria) this;
        }

        public Criteria andMobileaddIsNull() {
            addCriterion("mobileadd is null");
            return (Criteria) this;
        }

        public Criteria andMobileaddIsNotNull() {
            addCriterion("mobileadd is not null");
            return (Criteria) this;
        }

        public Criteria andMobileaddEqualTo(Integer value) {
            addCriterion("mobileadd =", value, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddNotEqualTo(Integer value) {
            addCriterion("mobileadd <>", value, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddGreaterThan(Integer value) {
            addCriterion("mobileadd >", value, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddGreaterThanOrEqualTo(Integer value) {
            addCriterion("mobileadd >=", value, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddLessThan(Integer value) {
            addCriterion("mobileadd <", value, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddLessThanOrEqualTo(Integer value) {
            addCriterion("mobileadd <=", value, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddIn(List<Integer> values) {
            addCriterion("mobileadd in", values, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddNotIn(List<Integer> values) {
            addCriterion("mobileadd not in", values, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddBetween(Integer value1, Integer value2) {
            addCriterion("mobileadd between", value1, value2, "mobileadd");
            return (Criteria) this;
        }

        public Criteria andMobileaddNotBetween(Integer value1, Integer value2) {
            addCriterion("mobileadd not between", value1, value2, "mobileadd");
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

        public Criteria andWenlikeIsNull() {
            addCriterion("wenlike is null");
            return (Criteria) this;
        }

        public Criteria andWenlikeIsNotNull() {
            addCriterion("wenlike is not null");
            return (Criteria) this;
        }

        public Criteria andWenlikeEqualTo(String value) {
            addCriterion("wenlike =", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeNotEqualTo(String value) {
            addCriterion("wenlike <>", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeGreaterThan(String value) {
            addCriterion("wenlike >", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeGreaterThanOrEqualTo(String value) {
            addCriterion("wenlike >=", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeLessThan(String value) {
            addCriterion("wenlike <", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeLessThanOrEqualTo(String value) {
            addCriterion("wenlike <=", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeLike(String value) {
            addCriterion("wenlike like", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeNotLike(String value) {
            addCriterion("wenlike not like", value, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeIn(List<String> values) {
            addCriterion("wenlike in", values, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeNotIn(List<String> values) {
            addCriterion("wenlike not in", values, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeBetween(String value1, String value2) {
            addCriterion("wenlike between", value1, value2, "wenlike");
            return (Criteria) this;
        }

        public Criteria andWenlikeNotBetween(String value1, String value2) {
            addCriterion("wenlike not between", value1, value2, "wenlike");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsIsNull() {
            addCriterion("open_statistics is null");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsIsNotNull() {
            addCriterion("open_statistics is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsEqualTo(Integer value) {
            addCriterion("open_statistics =", value, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsNotEqualTo(Integer value) {
            addCriterion("open_statistics <>", value, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsGreaterThan(Integer value) {
            addCriterion("open_statistics >", value, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_statistics >=", value, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsLessThan(Integer value) {
            addCriterion("open_statistics <", value, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsLessThanOrEqualTo(Integer value) {
            addCriterion("open_statistics <=", value, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsIn(List<Integer> values) {
            addCriterion("open_statistics in", values, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsNotIn(List<Integer> values) {
            addCriterion("open_statistics not in", values, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsBetween(Integer value1, Integer value2) {
            addCriterion("open_statistics between", value1, value2, "openStatistics");
            return (Criteria) this;
        }

        public Criteria andOpenStatisticsNotBetween(Integer value1, Integer value2) {
            addCriterion("open_statistics not between", value1, value2, "openStatistics");
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