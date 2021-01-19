package com.zou.factorymethod.abstractfactory;



/**
 * @ClassName Test
 * @Description TODO
 * @Author zou
 * @Date 2021/1/11 22:53
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new DogFactory();
        Animal animal = abstractFactory.getAnimal();
        animal.name();
        Food food = abstractFactory.getFood();
        food.eat();
    }
}
