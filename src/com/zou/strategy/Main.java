package com.zou.strategy;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/12/16 21:16
 */
public class Main {
    public static void main(String[] args) {
        Cat[] arr = {new Cat(3, 3), new Cat(4, 4), new Cat(1, 1)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(arr, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1.weight > o2.weight) return 1;
                else if (o1.weight < o2.weight) return -1;
                else return 0;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
