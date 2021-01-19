package com.zou.factorymethod.simplefactory;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zou
 * @Date 2021/1/11 22:53
 */
public class Main {
    public static void main(String[] args) {
        Moveable car1 = new Car();
        car1.go();
        Moveable car2 = new CarFactory().createCar();
    }
}
