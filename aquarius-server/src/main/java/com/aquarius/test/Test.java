package com.aquarius.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author zk
 * @since 2020-03-14
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class objClass = Singleton.class;
        Constructor constructor = objClass.getDeclaredConstructor();

        constructor.setAccessible(true);
        Singleton singleton1 = (Singleton)constructor.newInstance();
        Singleton singleton = Singleton.getInstance();


        Method method = objClass.getMethod("getInstance");
        Object instance = method.invoke(new Object());

        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println((Singleton)instance);

    }
}
