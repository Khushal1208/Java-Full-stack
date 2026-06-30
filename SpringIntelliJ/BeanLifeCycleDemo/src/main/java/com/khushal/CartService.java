package com.khushal;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService  implements BeanNameAware, ApplicationContextAware  /*InitializingBean  , DisposableBean */ {
    Map<Integer,String> mp;

    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService constructor Called");
    }
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName is : " + name);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext is : " + applicationContext.getClass());
    }

    public void addToCart(){
        System.out.println("Added to cart");
    }
    public String getValue(int key){
        return mp.get(key);
    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting destroyed");
//    }

//    @PostConstruct
//    public void start2(){
//        System.out.println("Bean is Ready");
//        mp.put(1,"Aditya");
//        mp.put(2,"Khushal");
//    }

    //    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("InitializingBean afterPropertiesSet Called");
//        mp.put(1,"Aditya");
//        mp.put(2,"Khushal");
//    }


    public void start(){
        mp.put(1,"Aditya");
        mp.put(2,"Khushal");
    }

    public void stop(){
        mp.clear();
        System.out.println("Bean is getting destroyed");
    }

    @PreDestroy
    public void stop2(){
        mp.clear();
        System.out.println("Bean is getting destroyed");
    }

}
