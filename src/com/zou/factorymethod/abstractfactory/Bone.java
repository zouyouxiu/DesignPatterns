package com.zou.factorymethod.abstractfactory;


public class Bone extends Food {
    @Override
    void eat() {
        System.out.println("吃骨头");
    }
}
