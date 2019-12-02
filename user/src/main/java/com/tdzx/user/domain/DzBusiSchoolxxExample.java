package com.tdzx.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DzBusiSchoolxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DzBusiSchoolxxExample() {
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

        public Criteria andSchoolmcIsNull() {
            addCriterion("schoolmc is null");
            return (Criteria) this;
        }

        public Criteria andSchoolmcIsNotNull() {
            addCriterion("schoolmc is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolmcEqualTo(String value) {
            addCriterion("schoolmc =", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcNotEqualTo(String value) {
            addCriterion("schoolmc <>", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcGreaterThan(String value) {
            addCriterion("schoolmc >", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcGreaterThanOrEqualTo(String value) {
            addCriterion("schoolmc >=", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcLessThan(String value) {
            addCriterion("schoolmc <", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcLessThanOrEqualTo(String value) {
            addCriterion("schoolmc <=", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcLike(String value) {
            addCriterion("schoolmc like", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcNotLike(String value) {
            addCriterion("schoolmc not like", value, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcIn(List<String> values) {
            addCriterion("schoolmc in", values, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcNotIn(List<String> values) {
            addCriterion("schoolmc not in", values, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcBetween(String value1, String value2) {
            addCriterion("schoolmc between", value1, value2, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andSchoolmcNotBetween(String value1, String value2) {
            addCriterion("schoolmc not between", value1, value2, "schoolmc");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andLxrIsNull() {
            addCriterion("lxr is null");
            return (Criteria) this;
        }

        public Criteria andLxrIsNotNull() {
            addCriterion("lxr is not null");
            return (Criteria) this;
        }

        public Criteria andLxrEqualTo(String value) {
            addCriterion("lxr =", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotEqualTo(String value) {
            addCriterion("lxr <>", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThan(String value) {
            addCriterion("lxr >", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThanOrEqualTo(String value) {
            addCriterion("lxr >=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThan(String value) {
            addCriterion("lxr <", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThanOrEqualTo(String value) {
            addCriterion("lxr <=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLike(String value) {
            addCriterion("lxr like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotLike(String value) {
            addCriterion("lxr not like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrIn(List<String> values) {
            addCriterion("lxr in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotIn(List<String> values) {
            addCriterion("lxr not in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrBetween(String value1, String value2) {
            addCriterion("lxr between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotBetween(String value1, String value2) {
            addCriterion("lxr not between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andXxdmIsNull() {
            addCriterion("xxdm is null");
            return (Criteria) this;
        }

        public Criteria andXxdmIsNotNull() {
            addCriterion("xxdm is not null");
            return (Criteria) this;
        }

        public Criteria andXxdmEqualTo(String value) {
            addCriterion("xxdm =", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmNotEqualTo(String value) {
            addCriterion("xxdm <>", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmGreaterThan(String value) {
            addCriterion("xxdm >", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmGreaterThanOrEqualTo(String value) {
            addCriterion("xxdm >=", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmLessThan(String value) {
            addCriterion("xxdm <", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmLessThanOrEqualTo(String value) {
            addCriterion("xxdm <=", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmLike(String value) {
            addCriterion("xxdm like", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmNotLike(String value) {
            addCriterion("xxdm not like", value, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmIn(List<String> values) {
            addCriterion("xxdm in", values, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmNotIn(List<String> values) {
            addCriterion("xxdm not in", values, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmBetween(String value1, String value2) {
            addCriterion("xxdm between", value1, value2, "xxdm");
            return (Criteria) this;
        }

        public Criteria andXxdmNotBetween(String value1, String value2) {
            addCriterion("xxdm not between", value1, value2, "xxdm");
            return (Criteria) this;
        }

        public Criteria andZkxxIsNull() {
            addCriterion("zkxx is null");
            return (Criteria) this;
        }

        public Criteria andZkxxIsNotNull() {
            addCriterion("zkxx is not null");
            return (Criteria) this;
        }

        public Criteria andZkxxEqualTo(Double value) {
            addCriterion("zkxx =", value, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxNotEqualTo(Double value) {
            addCriterion("zkxx <>", value, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxGreaterThan(Double value) {
            addCriterion("zkxx >", value, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxGreaterThanOrEqualTo(Double value) {
            addCriterion("zkxx >=", value, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxLessThan(Double value) {
            addCriterion("zkxx <", value, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxLessThanOrEqualTo(Double value) {
            addCriterion("zkxx <=", value, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxIn(List<Double> values) {
            addCriterion("zkxx in", values, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxNotIn(List<Double> values) {
            addCriterion("zkxx not in", values, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxBetween(Double value1, Double value2) {
            addCriterion("zkxx between", value1, value2, "zkxx");
            return (Criteria) this;
        }

        public Criteria andZkxxNotBetween(Double value1, Double value2) {
            addCriterion("zkxx not between", value1, value2, "zkxx");
            return (Criteria) this;
        }

        public Criteria andFkfsIsNull() {
            addCriterion("fkfs is null");
            return (Criteria) this;
        }

        public Criteria andFkfsIsNotNull() {
            addCriterion("fkfs is not null");
            return (Criteria) this;
        }

        public Criteria andFkfsEqualTo(String value) {
            addCriterion("fkfs =", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsNotEqualTo(String value) {
            addCriterion("fkfs <>", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsGreaterThan(String value) {
            addCriterion("fkfs >", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsGreaterThanOrEqualTo(String value) {
            addCriterion("fkfs >=", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsLessThan(String value) {
            addCriterion("fkfs <", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsLessThanOrEqualTo(String value) {
            addCriterion("fkfs <=", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsLike(String value) {
            addCriterion("fkfs like", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsNotLike(String value) {
            addCriterion("fkfs not like", value, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsIn(List<String> values) {
            addCriterion("fkfs in", values, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsNotIn(List<String> values) {
            addCriterion("fkfs not in", values, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsBetween(String value1, String value2) {
            addCriterion("fkfs between", value1, value2, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsNotBetween(String value1, String value2) {
            addCriterion("fkfs not between", value1, value2, "fkfs");
            return (Criteria) this;
        }

        public Criteria andFkfsidIsNull() {
            addCriterion("fkfsid is null");
            return (Criteria) this;
        }

        public Criteria andFkfsidIsNotNull() {
            addCriterion("fkfsid is not null");
            return (Criteria) this;
        }

        public Criteria andFkfsidEqualTo(String value) {
            addCriterion("fkfsid =", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidNotEqualTo(String value) {
            addCriterion("fkfsid <>", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidGreaterThan(String value) {
            addCriterion("fkfsid >", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidGreaterThanOrEqualTo(String value) {
            addCriterion("fkfsid >=", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidLessThan(String value) {
            addCriterion("fkfsid <", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidLessThanOrEqualTo(String value) {
            addCriterion("fkfsid <=", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidLike(String value) {
            addCriterion("fkfsid like", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidNotLike(String value) {
            addCriterion("fkfsid not like", value, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidIn(List<String> values) {
            addCriterion("fkfsid in", values, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidNotIn(List<String> values) {
            addCriterion("fkfsid not in", values, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidBetween(String value1, String value2) {
            addCriterion("fkfsid between", value1, value2, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andFkfsidNotBetween(String value1, String value2) {
            addCriterion("fkfsid not between", value1, value2, "fkfsid");
            return (Criteria) this;
        }

        public Criteria andShengIsNull() {
            addCriterion("sheng is null");
            return (Criteria) this;
        }

        public Criteria andShengIsNotNull() {
            addCriterion("sheng is not null");
            return (Criteria) this;
        }

        public Criteria andShengEqualTo(String value) {
            addCriterion("sheng =", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotEqualTo(String value) {
            addCriterion("sheng <>", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengGreaterThan(String value) {
            addCriterion("sheng >", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengGreaterThanOrEqualTo(String value) {
            addCriterion("sheng >=", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengLessThan(String value) {
            addCriterion("sheng <", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengLessThanOrEqualTo(String value) {
            addCriterion("sheng <=", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengLike(String value) {
            addCriterion("sheng like", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotLike(String value) {
            addCriterion("sheng not like", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengIn(List<String> values) {
            addCriterion("sheng in", values, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotIn(List<String> values) {
            addCriterion("sheng not in", values, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengBetween(String value1, String value2) {
            addCriterion("sheng between", value1, value2, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotBetween(String value1, String value2) {
            addCriterion("sheng not between", value1, value2, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengidIsNull() {
            addCriterion("shengid is null");
            return (Criteria) this;
        }

        public Criteria andShengidIsNotNull() {
            addCriterion("shengid is not null");
            return (Criteria) this;
        }

        public Criteria andShengidEqualTo(String value) {
            addCriterion("shengid =", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidNotEqualTo(String value) {
            addCriterion("shengid <>", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidGreaterThan(String value) {
            addCriterion("shengid >", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidGreaterThanOrEqualTo(String value) {
            addCriterion("shengid >=", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidLessThan(String value) {
            addCriterion("shengid <", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidLessThanOrEqualTo(String value) {
            addCriterion("shengid <=", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidLike(String value) {
            addCriterion("shengid like", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidNotLike(String value) {
            addCriterion("shengid not like", value, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidIn(List<String> values) {
            addCriterion("shengid in", values, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidNotIn(List<String> values) {
            addCriterion("shengid not in", values, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidBetween(String value1, String value2) {
            addCriterion("shengid between", value1, value2, "shengid");
            return (Criteria) this;
        }

        public Criteria andShengidNotBetween(String value1, String value2) {
            addCriterion("shengid not between", value1, value2, "shengid");
            return (Criteria) this;
        }

        public Criteria andShiIsNull() {
            addCriterion("shi is null");
            return (Criteria) this;
        }

        public Criteria andShiIsNotNull() {
            addCriterion("shi is not null");
            return (Criteria) this;
        }

        public Criteria andShiEqualTo(String value) {
            addCriterion("shi =", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotEqualTo(String value) {
            addCriterion("shi <>", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiGreaterThan(String value) {
            addCriterion("shi >", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiGreaterThanOrEqualTo(String value) {
            addCriterion("shi >=", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiLessThan(String value) {
            addCriterion("shi <", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiLessThanOrEqualTo(String value) {
            addCriterion("shi <=", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiLike(String value) {
            addCriterion("shi like", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotLike(String value) {
            addCriterion("shi not like", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiIn(List<String> values) {
            addCriterion("shi in", values, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotIn(List<String> values) {
            addCriterion("shi not in", values, "shi");
            return (Criteria) this;
        }

        public Criteria andShiBetween(String value1, String value2) {
            addCriterion("shi between", value1, value2, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotBetween(String value1, String value2) {
            addCriterion("shi not between", value1, value2, "shi");
            return (Criteria) this;
        }

        public Criteria andShidIsNull() {
            addCriterion("shid is null");
            return (Criteria) this;
        }

        public Criteria andShidIsNotNull() {
            addCriterion("shid is not null");
            return (Criteria) this;
        }

        public Criteria andShidEqualTo(String value) {
            addCriterion("shid =", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotEqualTo(String value) {
            addCriterion("shid <>", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThan(String value) {
            addCriterion("shid >", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThanOrEqualTo(String value) {
            addCriterion("shid >=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThan(String value) {
            addCriterion("shid <", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThanOrEqualTo(String value) {
            addCriterion("shid <=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLike(String value) {
            addCriterion("shid like", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotLike(String value) {
            addCriterion("shid not like", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidIn(List<String> values) {
            addCriterion("shid in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotIn(List<String> values) {
            addCriterion("shid not in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidBetween(String value1, String value2) {
            addCriterion("shid between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotBetween(String value1, String value2) {
            addCriterion("shid not between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andQuIsNull() {
            addCriterion("qu is null");
            return (Criteria) this;
        }

        public Criteria andQuIsNotNull() {
            addCriterion("qu is not null");
            return (Criteria) this;
        }

        public Criteria andQuEqualTo(String value) {
            addCriterion("qu =", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotEqualTo(String value) {
            addCriterion("qu <>", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuGreaterThan(String value) {
            addCriterion("qu >", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuGreaterThanOrEqualTo(String value) {
            addCriterion("qu >=", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuLessThan(String value) {
            addCriterion("qu <", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuLessThanOrEqualTo(String value) {
            addCriterion("qu <=", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuLike(String value) {
            addCriterion("qu like", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotLike(String value) {
            addCriterion("qu not like", value, "qu");
            return (Criteria) this;
        }

        public Criteria andQuIn(List<String> values) {
            addCriterion("qu in", values, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotIn(List<String> values) {
            addCriterion("qu not in", values, "qu");
            return (Criteria) this;
        }

        public Criteria andQuBetween(String value1, String value2) {
            addCriterion("qu between", value1, value2, "qu");
            return (Criteria) this;
        }

        public Criteria andQuNotBetween(String value1, String value2) {
            addCriterion("qu not between", value1, value2, "qu");
            return (Criteria) this;
        }

        public Criteria andQuidIsNull() {
            addCriterion("quid is null");
            return (Criteria) this;
        }

        public Criteria andQuidIsNotNull() {
            addCriterion("quid is not null");
            return (Criteria) this;
        }

        public Criteria andQuidEqualTo(String value) {
            addCriterion("quid =", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotEqualTo(String value) {
            addCriterion("quid <>", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidGreaterThan(String value) {
            addCriterion("quid >", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidGreaterThanOrEqualTo(String value) {
            addCriterion("quid >=", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidLessThan(String value) {
            addCriterion("quid <", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidLessThanOrEqualTo(String value) {
            addCriterion("quid <=", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidLike(String value) {
            addCriterion("quid like", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotLike(String value) {
            addCriterion("quid not like", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidIn(List<String> values) {
            addCriterion("quid in", values, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotIn(List<String> values) {
            addCriterion("quid not in", values, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidBetween(String value1, String value2) {
            addCriterion("quid between", value1, value2, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotBetween(String value1, String value2) {
            addCriterion("quid not between", value1, value2, "quid");
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

        public Criteria andDhIsNull() {
            addCriterion("dh is null");
            return (Criteria) this;
        }

        public Criteria andDhIsNotNull() {
            addCriterion("dh is not null");
            return (Criteria) this;
        }

        public Criteria andDhEqualTo(String value) {
            addCriterion("dh =", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotEqualTo(String value) {
            addCriterion("dh <>", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThan(String value) {
            addCriterion("dh >", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThanOrEqualTo(String value) {
            addCriterion("dh >=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThan(String value) {
            addCriterion("dh <", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThanOrEqualTo(String value) {
            addCriterion("dh <=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLike(String value) {
            addCriterion("dh like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotLike(String value) {
            addCriterion("dh not like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhIn(List<String> values) {
            addCriterion("dh in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotIn(List<String> values) {
            addCriterion("dh not in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBetween(String value1, String value2) {
            addCriterion("dh between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotBetween(String value1, String value2) {
            addCriterion("dh not between", value1, value2, "dh");
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

        public Criteria andDlzhIsNull() {
            addCriterion("dlzh is null");
            return (Criteria) this;
        }

        public Criteria andDlzhIsNotNull() {
            addCriterion("dlzh is not null");
            return (Criteria) this;
        }

        public Criteria andDlzhEqualTo(String value) {
            addCriterion("dlzh =", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhNotEqualTo(String value) {
            addCriterion("dlzh <>", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhGreaterThan(String value) {
            addCriterion("dlzh >", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhGreaterThanOrEqualTo(String value) {
            addCriterion("dlzh >=", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhLessThan(String value) {
            addCriterion("dlzh <", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhLessThanOrEqualTo(String value) {
            addCriterion("dlzh <=", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhLike(String value) {
            addCriterion("dlzh like", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhNotLike(String value) {
            addCriterion("dlzh not like", value, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhIn(List<String> values) {
            addCriterion("dlzh in", values, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhNotIn(List<String> values) {
            addCriterion("dlzh not in", values, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhBetween(String value1, String value2) {
            addCriterion("dlzh between", value1, value2, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlzhNotBetween(String value1, String value2) {
            addCriterion("dlzh not between", value1, value2, "dlzh");
            return (Criteria) this;
        }

        public Criteria andDlmmIsNull() {
            addCriterion("dlmm is null");
            return (Criteria) this;
        }

        public Criteria andDlmmIsNotNull() {
            addCriterion("dlmm is not null");
            return (Criteria) this;
        }

        public Criteria andDlmmEqualTo(String value) {
            addCriterion("dlmm =", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotEqualTo(String value) {
            addCriterion("dlmm <>", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmGreaterThan(String value) {
            addCriterion("dlmm >", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmGreaterThanOrEqualTo(String value) {
            addCriterion("dlmm >=", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLessThan(String value) {
            addCriterion("dlmm <", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLessThanOrEqualTo(String value) {
            addCriterion("dlmm <=", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLike(String value) {
            addCriterion("dlmm like", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotLike(String value) {
            addCriterion("dlmm not like", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmIn(List<String> values) {
            addCriterion("dlmm in", values, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotIn(List<String> values) {
            addCriterion("dlmm not in", values, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmBetween(String value1, String value2) {
            addCriterion("dlmm between", value1, value2, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotBetween(String value1, String value2) {
            addCriterion("dlmm not between", value1, value2, "dlmm");
            return (Criteria) this;
        }

        public Criteria andSapIsNull() {
            addCriterion("sap is null");
            return (Criteria) this;
        }

        public Criteria andSapIsNotNull() {
            addCriterion("sap is not null");
            return (Criteria) this;
        }

        public Criteria andSapEqualTo(String value) {
            addCriterion("sap =", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapNotEqualTo(String value) {
            addCriterion("sap <>", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapGreaterThan(String value) {
            addCriterion("sap >", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapGreaterThanOrEqualTo(String value) {
            addCriterion("sap >=", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapLessThan(String value) {
            addCriterion("sap <", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapLessThanOrEqualTo(String value) {
            addCriterion("sap <=", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapLike(String value) {
            addCriterion("sap like", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapNotLike(String value) {
            addCriterion("sap not like", value, "sap");
            return (Criteria) this;
        }

        public Criteria andSapIn(List<String> values) {
            addCriterion("sap in", values, "sap");
            return (Criteria) this;
        }

        public Criteria andSapNotIn(List<String> values) {
            addCriterion("sap not in", values, "sap");
            return (Criteria) this;
        }

        public Criteria andSapBetween(String value1, String value2) {
            addCriterion("sap between", value1, value2, "sap");
            return (Criteria) this;
        }

        public Criteria andSapNotBetween(String value1, String value2) {
            addCriterion("sap not between", value1, value2, "sap");
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