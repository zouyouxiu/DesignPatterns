package com.zou.singleton;

/**
 * lazy loading
 * 也称懒汉模式
 * 虽然达到了按需求初始化的目的，但却带来了线程不安全问题
 * 可以通过synchronized解决，但却带来效率下降
 */
public class Singleton05 {
    private  static Singleton05 INSTANCE;

    private Singleton05() {
    }

    public static  Singleton05 getInstance() {
        if (INSTANCE == null) {
            //妄图通过减小同步代码块的方式提高效率，然而不能保证多线程情况下，同一个实例
            synchronized(Singleton05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton05.getInstance().hashCode())).start();
        }
    }
}
