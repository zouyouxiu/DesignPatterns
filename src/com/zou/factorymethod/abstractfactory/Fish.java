package com.zou.factorymethod.abstractfactory;

/**
 * @Description
 * @Author zou
 * @Date 2021/1/19 21:39
 */
public class Fish extends Food {
    @Override
    void eat() {
        System.out.println("鱼");
    }
}
