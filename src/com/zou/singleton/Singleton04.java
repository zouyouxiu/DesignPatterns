package com.zou.singleton;

/**
 * lazy loading
 * 也称懒汉模式
 * 虽然达到了按需求初始化的目的，但却带来了线程不安全问题
 * 可以通过synchronized解决，但却带来效率下降
 */
public class Singleton04 {
    private  static Singleton04 INSTANCE;

    private Singleton04() {
    }

    public static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton04.getInstance().hashCode())).start();
        }
    }
}
