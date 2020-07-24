package com.wmm.basics.compare;

/**
 * @author wangmingming160328
 * @date @2020/7/24 11:48
 */
public class Child {
    private Integer id;
    private Integer age;

    public Child() {
    }

    public Child(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}

