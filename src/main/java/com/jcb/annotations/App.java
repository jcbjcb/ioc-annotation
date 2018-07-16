package com.jcb.annotations;

import com.jcb.annotations.context.ApplicationContext;
import com.jcb.annotations.context.IocContext;
import com.jcb.annotations.model.Student;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IocContext applicationContext = new ApplicationContext();
        try {
            applicationContext.initBean("com.jcb.annotations");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student student = (Student) applicationContext.getBean(Student.class.getTypeName());
        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(student.getClasses().getName());
        System.out.println(student.getClasses().getSchool().getName());
    }
}
