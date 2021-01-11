package com.zou.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVN保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * (话说你不用，你装载它干啥)
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){
    }

    public static Singleton01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01 s1 = Singleton01.getInstance();
        Singleton01 s2 = Singleton01.getInstance();
        System.out.println(s1==s2);
    }
}
