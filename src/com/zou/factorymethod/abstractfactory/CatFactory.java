package com.zou.factorymethod.abstractfactory;


public class CatFactory implements AbstractFactory{
    @Override
    public Food getFood() {
        return new Fish();
    }

    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
