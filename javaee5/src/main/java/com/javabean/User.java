package com.javabean;

/*
 * ①Java语言欠缺属性/事件/多继承功能，为了在Java程序中实现OOP（面向对象）的常见需求，
 * 只能手写大量胶水代码，Java Bean正是这套胶水代码惯用约定
 *
 * ②所有属性private+提供getter/setter+提供默认构造方法+实现serializable接口
 *
 * ③Java Bean>EJB>POJO
 * ④POJO是DO/DTO/BO/VO的统称
 * （DO：数据对象，直接对应数据表名）
 * （DTO：数据传输对象）
 * （BO：业务对象）
 * （VO：展示对象）
 * （PO：持久化对象，跟DO有什么区别？）
 * （DAO：DAO层，操作数据库）
 * */
public class User {

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

}
