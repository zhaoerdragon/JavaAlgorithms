package com.xupt.willscorpio.designs;

/**
 * 线程安全的单例模式
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
