package com.jcb.annotations.model;

import com.jcb.annotations.annotation.Component;
import com.jcb.annotations.annotation.Inject;
import com.jcb.annotations.annotation.Value;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-16 20:22
 **/
@Component
public class Student {

    @Inject
    private Classes classes;

    @Value("小明")
    private String name;
    @Value("男")
    private String sex;
    @Value("10")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
