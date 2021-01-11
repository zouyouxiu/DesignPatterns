package com.zou.singleton;

/**
 * lazy loading
 * 也称懒汉模式
 * 虽然达到了按需求初始化的目的，但却带来了线程不安全问题
 */
public class Singleton03 {
    private  static Singleton03 INSTANCE;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton03.getInstance().hashCode())).start();
        }
    }
}
