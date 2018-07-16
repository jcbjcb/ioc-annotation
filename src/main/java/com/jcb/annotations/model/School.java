package com.jcb.annotations.model;

import com.jcb.annotations.annotation.Component;
import com.jcb.annotations.annotation.Value;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-14 15:23
 **/
@Component
public class School {

    @Value("hh学校")
    private String name;

    @Value("大小街道")
    private String areas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }
}
