package com.zou.factorymethod.simplefactory;


public class CarFactory {
    public Car createCar(){
        System.out.println("crate Car");
        return new Car();
    }
}
