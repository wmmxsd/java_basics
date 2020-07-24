package com.wmm.basics.compare;

/**
 * @author wangmingming160328
 * @date @2020/7/24 11:41
 */
public class User implements Comparable<User>{
    private Integer id;
    private Integer age;

    public User() {
    }

    public User(Integer id, Integer age) {
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
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }
}

