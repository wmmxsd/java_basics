package com.wmm.basics.keyword.staticdemo;

public class EmpTest {
    private Integer id;
    private Integer empLevel;
    private String mappingOrderLevel;
    private String empNo;
    private Integer orderNumLimit;


    /**
     * 外部类私有的构造方法
     */
    private EmpTest(Builder builder) {
        setId(builder.id);
        setEmpLevel(builder.empLevel);
        setMappingOrderLevel(builder.mappingOrderLevel);
        setEmpNo(builder.empNo);
        setOrderNumLimit(builder.orderNumLimit);
    }

    /**
     * 对外提供初始化EmpTest类的唯一接口，通过这个方法，获得内部类的实例
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * 静态内部类：Builder
     */
    public static final class Builder {
        private Integer id;
        private Integer empLevel;
        private String mappingOrderLevel;
        private String empNo;
        private Integer orderNumLimit;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder empLevel(Integer val) {
            empLevel = val;
            return this;
        }

        public Builder mappingOrderLevel(String val) {
            mappingOrderLevel = val;
            return this;
        }

        public Builder empNo(String val) {
            empNo = val;
            return this;
        }

        public Builder orderNumLimit(Integer val) {
            orderNumLimit = val;
            return this;
        }

        //通过内部类的build方法，实例化外部类，并给其实例各个字段赋值
        public EmpTest build() {
            return new EmpTest(this);
        }

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(Integer empLevel) {
        this.empLevel = empLevel;
    }

    public String getMappingOrderLevel() {
        return mappingOrderLevel;
    }

    public void setMappingOrderLevel(String mappingOrderLevel) {
        this.mappingOrderLevel = mappingOrderLevel;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Integer getOrderNumLimit() {
        return orderNumLimit;
    }

    public void setOrderNumLimit(Integer orderNumLimit) {
        this.orderNumLimit = orderNumLimit;
    }

}
