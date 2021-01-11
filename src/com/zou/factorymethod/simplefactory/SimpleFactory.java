package com.zou.factorymethod.simplefactory;

/**
 * 简单工厂：可扩展性不好
 */
public class SimpleFactory {
    public Car createCar(){
        return new Car();
    }
    public Plane createPlane(){
        return new Plane();
    }
}
