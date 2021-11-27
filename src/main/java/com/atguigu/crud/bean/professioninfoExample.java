package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class professioninfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public professioninfoExample() {
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

        public Criteria andProfessionidIsNull() {
            addCriterion("professionID is null");
            return (Criteria) this;
        }

        public Criteria andProfessionidIsNotNull() {
            addCriterion("professionID is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionidEqualTo(String value) {
            addCriterion("professionID =", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidNotEqualTo(String value) {
            addCriterion("professionID <>", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidGreaterThan(String value) {
            addCriterion("professionID >", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidGreaterThanOrEqualTo(String value) {
            addCriterion("professionID >=", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidLessThan(String value) {
            addCriterion("professionID <", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidLessThanOrEqualTo(String value) {
            addCriterion("professionID <=", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidLike(String value) {
            addCriterion("professionID like", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidNotLike(String value) {
            addCriterion("professionID not like", value, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidIn(List<String> values) {
            addCriterion("professionID in", values, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidNotIn(List<String> values) {
            addCriterion("professionID not in", values, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidBetween(String value1, String value2) {
            addCriterion("professionID between", value1, value2, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionidNotBetween(String value1, String value2) {
            addCriterion("professionID not between", value1, value2, "professionid");
            return (Criteria) this;
        }

        public Criteria andProfessionnameIsNull() {
            addCriterion("professionName is null");
            return (Criteria) this;
        }

        public Criteria andProfessionnameIsNotNull() {
            addCriterion("professionName is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionnameEqualTo(String value) {
            addCriterion("professionName =", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameNotEqualTo(String value) {
            addCriterion("professionName <>", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameGreaterThan(String value) {
            addCriterion("professionName >", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameGreaterThanOrEqualTo(String value) {
            addCriterion("professionName >=", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameLessThan(String value) {
            addCriterion("professionName <", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameLessThanOrEqualTo(String value) {
            addCriterion("professionName <=", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameLike(String value) {
            addCriterion("professionName like", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameNotLike(String value) {
            addCriterion("professionName not like", value, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameIn(List<String> values) {
            addCriterion("professionName in", values, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameNotIn(List<String> values) {
            addCriterion("professionName not in", values, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameBetween(String value1, String value2) {
            addCriterion("professionName between", value1, value2, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionnameNotBetween(String value1, String value2) {
            addCriterion("professionName not between", value1, value2, "professionname");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonIsNull() {
            addCriterion("professionPerson is null");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonIsNotNull() {
            addCriterion("professionPerson is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonEqualTo(String value) {
            addCriterion("professionPerson =", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonNotEqualTo(String value) {
            addCriterion("professionPerson <>", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonGreaterThan(String value) {
            addCriterion("professionPerson >", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonGreaterThanOrEqualTo(String value) {
            addCriterion("professionPerson >=", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonLessThan(String value) {
            addCriterion("professionPerson <", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonLessThanOrEqualTo(String value) {
            addCriterion("professionPerson <=", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonLike(String value) {
            addCriterion("professionPerson like", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonNotLike(String value) {
            addCriterion("professionPerson not like", value, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonIn(List<String> values) {
            addCriterion("professionPerson in", values, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonNotIn(List<String> values) {
            addCriterion("professionPerson not in", values, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonBetween(String value1, String value2) {
            addCriterion("professionPerson between", value1, value2, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessionpersonNotBetween(String value1, String value2) {
            addCriterion("professionPerson not between", value1, value2, "professionperson");
            return (Criteria) this;
        }

        public Criteria andProfessiondesIsNull() {
            addCriterion("professionDes is null");
            return (Criteria) this;
        }

        public Criteria andProfessiondesIsNotNull() {
            addCriterion("professionDes is not null");
            return (Criteria) this;
        }

        public Criteria andProfessiondesEqualTo(String value) {
            addCriterion("professionDes =", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesNotEqualTo(String value) {
            addCriterion("professionDes <>", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesGreaterThan(String value) {
            addCriterion("professionDes >", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesGreaterThanOrEqualTo(String value) {
            addCriterion("professionDes >=", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesLessThan(String value) {
            addCriterion("professionDes <", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesLessThanOrEqualTo(String value) {
            addCriterion("professionDes <=", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesLike(String value) {
            addCriterion("professionDes like", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesNotLike(String value) {
            addCriterion("professionDes not like", value, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesIn(List<String> values) {
            addCriterion("professionDes in", values, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesNotIn(List<String> values) {
            addCriterion("professionDes not in", values, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesBetween(String value1, String value2) {
            addCriterion("professionDes between", value1, value2, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessiondesNotBetween(String value1, String value2) {
            addCriterion("professionDes not between", value1, value2, "professiondes");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueIsNull() {
            addCriterion("professionIntrodue is null");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueIsNotNull() {
            addCriterion("professionIntrodue is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueEqualTo(String value) {
            addCriterion("professionIntrodue =", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueNotEqualTo(String value) {
            addCriterion("professionIntrodue <>", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueGreaterThan(String value) {
            addCriterion("professionIntrodue >", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueGreaterThanOrEqualTo(String value) {
            addCriterion("professionIntrodue >=", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueLessThan(String value) {
            addCriterion("professionIntrodue <", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueLessThanOrEqualTo(String value) {
            addCriterion("professionIntrodue <=", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueLike(String value) {
            addCriterion("professionIntrodue like", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueNotLike(String value) {
            addCriterion("professionIntrodue not like", value, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueIn(List<String> values) {
            addCriterion("professionIntrodue in", values, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueNotIn(List<String> values) {
            addCriterion("professionIntrodue not in", values, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueBetween(String value1, String value2) {
            addCriterion("professionIntrodue between", value1, value2, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andProfessionintrodueNotBetween(String value1, String value2) {
            addCriterion("professionIntrodue not between", value1, value2, "professionintrodue");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("Number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("Number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("Number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("Number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("Number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("Number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("Number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("Number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("Number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("Number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("Number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("Number not between", value1, value2, "number");
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