package com.jcb.annotations.util;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-16 22:04
 **/
public class BaseTypeUtil {

    public static Object initBaseType(Class<?> clazz ,String value){
        if(clazz == Integer.TYPE){
            return Integer.parseInt(value);
        }else if(clazz ==  Long.TYPE){
            return Long.parseLong(value);
        }else if(clazz ==  Boolean.TYPE){
            return Boolean.parseBoolean(value);
        }else if(clazz ==  Short.TYPE){
            return Short.parseShort(value);
        }else if(clazz ==  Double.TYPE){
            return Double.parseDouble(value);
        }else if(clazz ==  Float.TYPE){
            return Float.parseFloat(value);
        }else if(clazz ==  Character.TYPE){
            return value.charAt(0);
        }else if(clazz ==  Byte.TYPE){
            return value.getBytes();
        }
        return value;
    }
}
