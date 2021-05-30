package com.zhuanye.wiki.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
//mybatis-generator会为每个字段产生Criterion，为底层的mapper.xml创建动态sql。
// 如果表的字段比较多,产生的example类会十分庞大。理论上通过example类可以构造你想到的任何筛选条件。
public class EbookSnapshotExample {
    //作用：升序还是降序
    //参数格式：字段+空格+asc(desc)
    protected String orderByClause;
    //作用：去除重复
    //true是选择不重复记录，false，反之
    protected boolean distinct;
    //自定义查询条件
    //Criteria的集合，集合中对象是由or连接
    protected List<Criteria> oredCriteria;
    //构造函数
    public EbookSnapshotExample() {
        oredCriteria = new ArrayList<>();
    }
    //属性的Getter和Setter()函数
    //添加升序排列条件，DESC为降序
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }
    //去除重复，boolean型，true为选择不重复的记录。
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    //判断是否重复
    public boolean isDistinct() {
        return distinct;
    }
    //获得List<Criteria>
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    //添加Criteria
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    //添加Criteria
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    //创建Criteria
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    //清除Criteria
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
    //是mybatis中逆向工程中的代码模型
    //每个函数的解释如下：
    //xxxExample example = new xxxExample();
    //Criteria criteria = example.createCriteria();
    //方法说明：
    //// 1.添加升序排列条件，DESC为降序
    //example.setOrderByClause("字段名ASC")
    //// 2.去除重复，boolean类型，true为选择不重复的记录
    //example.setDistinct(false)
    //// 3.添加字段xxx为null的条件
    //criteria.andXxxIsNull
    //// 4.添加字段xxx不为null的条件
    //criteria.andXxxIsNotNull
    //// 5.添加xxx字段等于value条件
    //criteria.andXxxEqualTo(value)
    //// 6.添加xxx字段不等于value条件
    //criteria.andXxxNotEqualTo(value)
    //// 7.添加xxx字段大于value条件
    //criteria.andXxxGreaterThan(value)
    //// 8.添加xxx字段大于等于value条件
    //criteria.andXxxGreaterThanOrEqualTo(value)
    //// 9.添加xxx字段小于value条件
    //criteria.andXxxLessThan(value)
    //// 10.添加xxx字段小于等于value条件
    //criteria.andXxxLessThanOrEqualTo(value)
    //// 11.添加xxx字段值在List
    //criteria.andXxxIn(List)
    //// 12.不添加xxx字段值在List
    //criteria.andXxxNotIn(List)
    //// 13.添加xxx字段值在之间
    //criteria.andXxxBetween(value1,value2)
    //// 14.添加xxx字段值不在之间
    //criteria.andXxxNotBetween(value1,value2)
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }
        //判断criteria是否为空
        public boolean isValid() {
            return criteria.size() > 0;
        }
        //获得criteria
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEbookIdIsNull() {
            addCriterion("ebook_id is null");
            return (Criteria) this;
        }

        public Criteria andEbookIdIsNotNull() {
            addCriterion("ebook_id is not null");
            return (Criteria) this;
        }

        public Criteria andEbookIdEqualTo(Long value) {
            addCriterion("ebook_id =", value, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdNotEqualTo(Long value) {
            addCriterion("ebook_id <>", value, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdGreaterThan(Long value) {
            addCriterion("ebook_id >", value, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ebook_id >=", value, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdLessThan(Long value) {
            addCriterion("ebook_id <", value, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdLessThanOrEqualTo(Long value) {
            addCriterion("ebook_id <=", value, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdIn(List<Long> values) {
            addCriterion("ebook_id in", values, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdNotIn(List<Long> values) {
            addCriterion("ebook_id not in", values, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdBetween(Long value1, Long value2) {
            addCriterion("ebook_id between", value1, value2, "ebookId");
            return (Criteria) this;
        }

        public Criteria andEbookIdNotBetween(Long value1, Long value2) {
            addCriterion("ebook_id not between", value1, value2, "ebookId");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Integer value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Integer value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Integer value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Integer value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Integer value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Integer> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Integer> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Integer value1, Integer value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountIsNull() {
            addCriterion("vote_count is null");
            return (Criteria) this;
        }

        public Criteria andVoteCountIsNotNull() {
            addCriterion("vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCountEqualTo(Integer value) {
            addCriterion("vote_count =", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotEqualTo(Integer value) {
            addCriterion("vote_count <>", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountGreaterThan(Integer value) {
            addCriterion("vote_count >", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_count >=", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountLessThan(Integer value) {
            addCriterion("vote_count <", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountLessThanOrEqualTo(Integer value) {
            addCriterion("vote_count <=", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountIn(List<Integer> values) {
            addCriterion("vote_count in", values, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotIn(List<Integer> values) {
            addCriterion("vote_count not in", values, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountBetween(Integer value1, Integer value2) {
            addCriterion("vote_count between", value1, value2, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_count not between", value1, value2, "voteCount");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseIsNull() {
            addCriterion("view_increase is null");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseIsNotNull() {
            addCriterion("view_increase is not null");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseEqualTo(Integer value) {
            addCriterion("view_increase =", value, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseNotEqualTo(Integer value) {
            addCriterion("view_increase <>", value, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseGreaterThan(Integer value) {
            addCriterion("view_increase >", value, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_increase >=", value, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseLessThan(Integer value) {
            addCriterion("view_increase <", value, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseLessThanOrEqualTo(Integer value) {
            addCriterion("view_increase <=", value, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseIn(List<Integer> values) {
            addCriterion("view_increase in", values, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseNotIn(List<Integer> values) {
            addCriterion("view_increase not in", values, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseBetween(Integer value1, Integer value2) {
            addCriterion("view_increase between", value1, value2, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andViewIncreaseNotBetween(Integer value1, Integer value2) {
            addCriterion("view_increase not between", value1, value2, "viewIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseIsNull() {
            addCriterion("vote_increase is null");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseIsNotNull() {
            addCriterion("vote_increase is not null");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseEqualTo(Integer value) {
            addCriterion("vote_increase =", value, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseNotEqualTo(Integer value) {
            addCriterion("vote_increase <>", value, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseGreaterThan(Integer value) {
            addCriterion("vote_increase >", value, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_increase >=", value, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseLessThan(Integer value) {
            addCriterion("vote_increase <", value, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseLessThanOrEqualTo(Integer value) {
            addCriterion("vote_increase <=", value, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseIn(List<Integer> values) {
            addCriterion("vote_increase in", values, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseNotIn(List<Integer> values) {
            addCriterion("vote_increase not in", values, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseBetween(Integer value1, Integer value2) {
            addCriterion("vote_increase between", value1, value2, "voteIncrease");
            return (Criteria) this;
        }

        public Criteria andVoteIncreaseNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_increase not between", value1, value2, "voteIncrease");
            return (Criteria) this;
        }
    }
    //内部类Criteria包含一个Cretiron的集合，
    //每一个Criteria对象内包含的Cretiron之间是由 AND连接的
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
    //是最基本,最底层的Where条件，用于字段级的筛选
    public static class Criterion {
        //Criterion属性
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;
        //Criterion类的Getter和Setter函数
        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }
        //判断属性值
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
        //Criterion类的构造函数
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