package com.jcb.annotations.context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-16 20:26
 **/
public interface IocContext {

    public static final Map<String,Object> appContext = new HashMap<>();

    Object getBean(String id);

    void initBean(String packageName) throws IOException;

}
