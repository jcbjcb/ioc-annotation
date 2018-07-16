package com.jcb.annotations.context;

import com.jcb.annotations.annotation.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @program: deu
 * @description: ${description}
 * @author: jcb
 * @create: 2018-07-16 20:32
 **/
public class ApplicationContext implements  IocContext{


    @Override
    public Object getBean(String id) {
        if(appContext.get(id)!=null) {
            return appContext.get(id);
        }
        return null;
    }

    @Override
    public void initBean(String packageName) throws IOException {
        Enumeration<URL>  urls= Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.","/"));
        List<File> list = new ArrayList<>();
        while(urls.hasMoreElements()){
//            System.out.println(urls.nextElement().getPath());
            list.addAll(getFiles(urls.nextElement().getPath().substring(1)));
        }
        list.forEach(p-> loadClass(p.getPath()));
    }

    public void loadClass(String path){

        String classPath= Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);
        String className= path.substring(classPath.length()).replaceAll("\\\\",".").replace(".class","");
//        System.out.println(className);
        try {
            Class<?> clazz= Class.forName(className);
            if(clazz.isAnnotationPresent(Component.class)){

                Object obj=  clazz.newInstance();
                this.appContext.put(className,obj);

            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        this.appContext.values().forEach(bean->InjectUtil.inject(bean));
    }

    private List<File> getFiles(String path){
//        System.out.println(path);
        List<File> list = new ArrayList<>();

        File file = new File(path);
        if(file.isDirectory()){
            for (File file1 : file.listFiles()) {
//                System.out.println(file1.getPath());
                list.addAll(getFiles(file1.getPath()));
            }
        }else{
            if (file.getPath().endsWith(".class"))
                list.add(file);
        }
     return  list;
    }

}
