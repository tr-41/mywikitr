package com.zhuanye.wiki.domain;

import java.util.ArrayList;
import java.util.List;
//mybatis-generator会为每个字段产生Criterion，为底层的mapper.xml创建动态sql。
// 如果表的字段比较多,产生的example类会十分庞大。理论上通过example类可以构造你想到的任何筛选条件。
public class DocEditExample {
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
    public DocEditExample() {
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
        //添加字段UserId为null的条件
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        //添加字段UserId不为null的条件
        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        //添加UserId字段等于value条件
        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        //添加UserId字段不等于value条件
        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        //添加UserId字段大于value条件
        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        //添加UserId字段大于等于value条件
        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        //添加UserId字段小于value条件
        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        //添加UserId字段小于等于value条件
        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        //添加UserId字段值在List<Long> values条件
        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        //添加UserId字段值不在List<Long> values条件
        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        //添加UserId字段值在value1和value2之间条件
        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        //添加UserId字段值不在value1和value2之间条件
        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        //添加字段WordId为null的条件
        public Criteria andWordIdIsNull() {
            addCriterion("word_id is null");
            return (Criteria) this;
        }

        public Criteria andWordIdIsNotNull() {
            addCriterion("word_id is not null");
            return (Criteria) this;
        }

        public Criteria andWordIdEqualTo(Long value) {
            addCriterion("word_id =", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotEqualTo(Long value) {
            addCriterion("word_id <>", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThan(Long value) {
            addCriterion("word_id >", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("word_id >=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThan(Long value) {
            addCriterion("word_id <", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThanOrEqualTo(Long value) {
            addCriterion("word_id <=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdIn(List<Long> values) {
            addCriterion("word_id in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotIn(List<Long> values) {
            addCriterion("word_id not in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdBetween(Long value1, Long value2) {
            addCriterion("word_id between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotBetween(Long value1, Long value2) {
            addCriterion("word_id not between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andWordnameIsNull() {
            addCriterion("wordname is null");
            return (Criteria) this;
        }

        public Criteria andWordnameIsNotNull() {
            addCriterion("wordname is not null");
            return (Criteria) this;
        }

        public Criteria andWordnameEqualTo(String value) {
            addCriterion("wordname =", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotEqualTo(String value) {
            addCriterion("wordname <>", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameGreaterThan(String value) {
            addCriterion("wordname >", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameGreaterThanOrEqualTo(String value) {
            addCriterion("wordname >=", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameLessThan(String value) {
            addCriterion("wordname <", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameLessThanOrEqualTo(String value) {
            addCriterion("wordname <=", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameLike(String value) {
            addCriterion("wordname like", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotLike(String value) {
            addCriterion("wordname not like", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameIn(List<String> values) {
            addCriterion("wordname in", values, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotIn(List<String> values) {
            addCriterion("wordname not in", values, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameBetween(String value1, String value2) {
            addCriterion("wordname between", value1, value2, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotBetween(String value1, String value2) {
            addCriterion("wordname not between", value1, value2, "wordname");
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