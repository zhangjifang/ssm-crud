package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class BookInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookInfoExample() {
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

        public Criteria andBookidIsNull() {
            addCriterion("BookID is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("BookID is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(String value) {
            addCriterion("BookID =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(String value) {
            addCriterion("BookID <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(String value) {
            addCriterion("BookID >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(String value) {
            addCriterion("BookID >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(String value) {
            addCriterion("BookID <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(String value) {
            addCriterion("BookID <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLike(String value) {
            addCriterion("BookID like", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotLike(String value) {
            addCriterion("BookID not like", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<String> values) {
            addCriterion("BookID in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<String> values) {
            addCriterion("BookID not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(String value1, String value2) {
            addCriterion("BookID between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(String value1, String value2) {
            addCriterion("BookID not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNull() {
            addCriterion("BookName is null");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNotNull() {
            addCriterion("BookName is not null");
            return (Criteria) this;
        }

        public Criteria andBooknameEqualTo(String value) {
            addCriterion("BookName =", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("BookName <>", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("BookName >", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("BookName >=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThan(String value) {
            addCriterion("BookName <", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("BookName <=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLike(String value) {
            addCriterion("BookName like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotLike(String value) {
            addCriterion("BookName not like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameIn(List<String> values) {
            addCriterion("BookName in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("BookName not in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("BookName between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("BookName not between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooktypeIsNull() {
            addCriterion("BookType is null");
            return (Criteria) this;
        }

        public Criteria andBooktypeIsNotNull() {
            addCriterion("BookType is not null");
            return (Criteria) this;
        }

        public Criteria andBooktypeEqualTo(String value) {
            addCriterion("BookType =", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotEqualTo(String value) {
            addCriterion("BookType <>", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeGreaterThan(String value) {
            addCriterion("BookType >", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeGreaterThanOrEqualTo(String value) {
            addCriterion("BookType >=", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLessThan(String value) {
            addCriterion("BookType <", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLessThanOrEqualTo(String value) {
            addCriterion("BookType <=", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLike(String value) {
            addCriterion("BookType like", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotLike(String value) {
            addCriterion("BookType not like", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeIn(List<String> values) {
            addCriterion("BookType in", values, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotIn(List<String> values) {
            addCriterion("BookType not in", values, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeBetween(String value1, String value2) {
            addCriterion("BookType between", value1, value2, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotBetween(String value1, String value2) {
            addCriterion("BookType not between", value1, value2, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooknumbersIsNull() {
            addCriterion("BookNumbers is null");
            return (Criteria) this;
        }

        public Criteria andBooknumbersIsNotNull() {
            addCriterion("BookNumbers is not null");
            return (Criteria) this;
        }

        public Criteria andBooknumbersEqualTo(String value) {
            addCriterion("BookNumbers =", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersNotEqualTo(String value) {
            addCriterion("BookNumbers <>", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersGreaterThan(String value) {
            addCriterion("BookNumbers >", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersGreaterThanOrEqualTo(String value) {
            addCriterion("BookNumbers >=", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersLessThan(String value) {
            addCriterion("BookNumbers <", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersLessThanOrEqualTo(String value) {
            addCriterion("BookNumbers <=", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersLike(String value) {
            addCriterion("BookNumbers like", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersNotLike(String value) {
            addCriterion("BookNumbers not like", value, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersIn(List<String> values) {
            addCriterion("BookNumbers in", values, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersNotIn(List<String> values) {
            addCriterion("BookNumbers not in", values, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersBetween(String value1, String value2) {
            addCriterion("BookNumbers between", value1, value2, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBooknumbersNotBetween(String value1, String value2) {
            addCriterion("BookNumbers not between", value1, value2, "booknumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersIsNull() {
            addCriterion("BorrowedNumbers is null");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersIsNotNull() {
            addCriterion("BorrowedNumbers is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersEqualTo(String value) {
            addCriterion("BorrowedNumbers =", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersNotEqualTo(String value) {
            addCriterion("BorrowedNumbers <>", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersGreaterThan(String value) {
            addCriterion("BorrowedNumbers >", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersGreaterThanOrEqualTo(String value) {
            addCriterion("BorrowedNumbers >=", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersLessThan(String value) {
            addCriterion("BorrowedNumbers <", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersLessThanOrEqualTo(String value) {
            addCriterion("BorrowedNumbers <=", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersLike(String value) {
            addCriterion("BorrowedNumbers like", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersNotLike(String value) {
            addCriterion("BorrowedNumbers not like", value, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersIn(List<String> values) {
            addCriterion("BorrowedNumbers in", values, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersNotIn(List<String> values) {
            addCriterion("BorrowedNumbers not in", values, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersBetween(String value1, String value2) {
            addCriterion("BorrowedNumbers between", value1, value2, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andBorrowednumbersNotBetween(String value1, String value2) {
            addCriterion("BorrowedNumbers not between", value1, value2, "borrowednumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersIsNull() {
            addCriterion("RemainingNumbers is null");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersIsNotNull() {
            addCriterion("RemainingNumbers is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersEqualTo(String value) {
            addCriterion("RemainingNumbers =", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersNotEqualTo(String value) {
            addCriterion("RemainingNumbers <>", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersGreaterThan(String value) {
            addCriterion("RemainingNumbers >", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersGreaterThanOrEqualTo(String value) {
            addCriterion("RemainingNumbers >=", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersLessThan(String value) {
            addCriterion("RemainingNumbers <", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersLessThanOrEqualTo(String value) {
            addCriterion("RemainingNumbers <=", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersLike(String value) {
            addCriterion("RemainingNumbers like", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersNotLike(String value) {
            addCriterion("RemainingNumbers not like", value, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersIn(List<String> values) {
            addCriterion("RemainingNumbers in", values, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersNotIn(List<String> values) {
            addCriterion("RemainingNumbers not in", values, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersBetween(String value1, String value2) {
            addCriterion("RemainingNumbers between", value1, value2, "remainingnumbers");
            return (Criteria) this;
        }

        public Criteria andRemainingnumbersNotBetween(String value1, String value2) {
            addCriterion("RemainingNumbers not between", value1, value2, "remainingnumbers");
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