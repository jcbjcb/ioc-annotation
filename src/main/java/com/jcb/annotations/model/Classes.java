package com.jcb.annotations.model;

import com.jcb.annotations.annotation.Component;
import com.jcb.annotations.annotation.Inject;
import com.jcb.annotations.annotation.Value;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-16 20:21
 **/
@Component
public class Classes {
    @Inject
    private School school;

    @Value("一年级")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
