package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentWishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentWishExample() {
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

        public Criteria andStudentidIsNull() {
            addCriterion("studentID is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(String value) {
            addCriterion("studentID =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(String value) {
            addCriterion("studentID <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(String value) {
            addCriterion("studentID >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(String value) {
            addCriterion("studentID >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(String value) {
            addCriterion("studentID <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(String value) {
            addCriterion("studentID <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLike(String value) {
            addCriterion("studentID like", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotLike(String value) {
            addCriterion("studentID not like", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<String> values) {
            addCriterion("studentID in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<String> values) {
            addCriterion("studentID not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(String value1, String value2) {
            addCriterion("studentID between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(String value1, String value2) {
            addCriterion("studentID not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andProfessionid1IsNull() {
            addCriterion("professionID1 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionid1IsNotNull() {
            addCriterion("professionID1 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionid1EqualTo(String value) {
            addCriterion("professionID1 =", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1NotEqualTo(String value) {
            addCriterion("professionID1 <>", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1GreaterThan(String value) {
            addCriterion("professionID1 >", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1GreaterThanOrEqualTo(String value) {
            addCriterion("professionID1 >=", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1LessThan(String value) {
            addCriterion("professionID1 <", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1LessThanOrEqualTo(String value) {
            addCriterion("professionID1 <=", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1Like(String value) {
            addCriterion("professionID1 like", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1NotLike(String value) {
            addCriterion("professionID1 not like", value, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1In(List<String> values) {
            addCriterion("professionID1 in", values, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1NotIn(List<String> values) {
            addCriterion("professionID1 not in", values, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1Between(String value1, String value2) {
            addCriterion("professionID1 between", value1, value2, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid1NotBetween(String value1, String value2) {
            addCriterion("professionID1 not between", value1, value2, "professionid1");
            return (Criteria) this;
        }

        public Criteria andProfessionid2IsNull() {
            addCriterion("professionID2 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionid2IsNotNull() {
            addCriterion("professionID2 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionid2EqualTo(String value) {
            addCriterion("professionID2 =", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2NotEqualTo(String value) {
            addCriterion("professionID2 <>", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2GreaterThan(String value) {
            addCriterion("professionID2 >", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2GreaterThanOrEqualTo(String value) {
            addCriterion("professionID2 >=", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2LessThan(String value) {
            addCriterion("professionID2 <", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2LessThanOrEqualTo(String value) {
            addCriterion("professionID2 <=", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2Like(String value) {
            addCriterion("professionID2 like", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2NotLike(String value) {
            addCriterion("professionID2 not like", value, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2In(List<String> values) {
            addCriterion("professionID2 in", values, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2NotIn(List<String> values) {
            addCriterion("professionID2 not in", values, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2Between(String value1, String value2) {
            addCriterion("professionID2 between", value1, value2, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid2NotBetween(String value1, String value2) {
            addCriterion("professionID2 not between", value1, value2, "professionid2");
            return (Criteria) this;
        }

        public Criteria andProfessionid3IsNull() {
            addCriterion("professionID3 is null");
            return (Criteria) this;
        }

        public Criteria andProfessionid3IsNotNull() {
            addCriterion("professionID3 is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionid3EqualTo(String value) {
            addCriterion("professionID3 =", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3NotEqualTo(String value) {
            addCriterion("professionID3 <>", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3GreaterThan(String value) {
            addCriterion("professionID3 >", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3GreaterThanOrEqualTo(String value) {
            addCriterion("professionID3 >=", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3LessThan(String value) {
            addCriterion("professionID3 <", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3LessThanOrEqualTo(String value) {
            addCriterion("professionID3 <=", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3Like(String value) {
            addCriterion("professionID3 like", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3NotLike(String value) {
            addCriterion("professionID3 not like", value, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3In(List<String> values) {
            addCriterion("professionID3 in", values, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3NotIn(List<String> values) {
            addCriterion("professionID3 not in", values, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3Between(String value1, String value2) {
            addCriterion("professionID3 between", value1, value2, "professionid3");
            return (Criteria) this;
        }

        public Criteria andProfessionid3NotBetween(String value1, String value2) {
            addCriterion("professionID3 not between", value1, value2, "professionid3");
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