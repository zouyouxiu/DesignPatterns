package com.zou.factorymethod.abstractfactory;


public class DogFactory implements AbstractFactory{
    @Override
    public Food getFood() {
        return new Bone();
    }

    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
