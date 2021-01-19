package com.zou.factorymethod.abstractfactory;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Description
 * @Author zou
 * @Date 2021/1/19 21:40
 */
public class Cat extends Animal {
    @Override
    void name() {
        System.out.println("cat");
    }
}
