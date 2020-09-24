package com.aquarius.test;

/**
 * @author zk
 * @since 2020-03-14
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){}

    public static Singleton getInstance(){
        if(null == singleton){
            synchronized (Singleton.class){
                if(null == singleton){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
