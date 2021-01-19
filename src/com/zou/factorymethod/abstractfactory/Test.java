package com.zou.factorymethod.abstractfactory;



/**
 * @ClassName Test
 * @Description TODO
 * @Author zou
 * @Date 2021/1/11 22:53
 */
public class Test {
    public static void main(String[] args) {
        //抽象工厂优势：产品一族好扩展，产品维度不好扩展 例如：如果想给特定的产品一族新增一个产品属性，那么所有的产品一族都需要修改
        //AbstractFactory abstractFactory = new DogFactory();
        AbstractFactory abstractFactory = new CatFactory();
        Animal animal = abstractFactory.getAnimal();
        animal.name();
        Food food = abstractFactory.getFood();
        food.eat();
    }
}
