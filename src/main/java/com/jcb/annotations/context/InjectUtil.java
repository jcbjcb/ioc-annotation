package com.jcb.annotations.context;

import com.jcb.annotations.annotation.Inject;
import com.jcb.annotations.annotation.Value;
import com.jcb.annotations.util.BaseTypeUtil;

import java.lang.reflect.Field;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-16 21:42
 **/
public class InjectUtil {

    public static void inject(Object obj){
        for (Field field : obj.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)){
                field.setAccessible(true);
                Object injecObj=ApplicationContext.appContext.get(field.getType().getTypeName());
//                System.out.println("field.getType():"+field.getType().getTypeName());
                try {
                    field.set(obj,injecObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            if(field.isAnnotationPresent(Value.class)){
                field.setAccessible(true);
                Class<?> type= field.getType();
                Value value= field.getAnnotation(Value.class);
                String valueStr=  value.value();
                try {
                    Object injecObj=  BaseTypeUtil.initBaseType(type,valueStr);
                    field.set(obj,injecObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
