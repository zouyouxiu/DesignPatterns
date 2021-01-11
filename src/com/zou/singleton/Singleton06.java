package com.zou.singleton;

/**
 * lazy loading
 * 也称懒汉模式
 * 虽然达到了按需求初始化的目的，但却带来了线程不安全问题
 * 可以通过synchronized解决，但却带来效率下降
 */
public class Singleton06 {
    private static volatile Singleton06 INSTANCE;

    private Singleton06() {
    }

    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton06.class) {
                //双重检查
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton06.getInstance().hashCode())).start();
        }
    }
}
