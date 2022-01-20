package org.lanqiao.entity;

import org.lanqiao.annotation.FruitColor;
import org.lanqiao.annotation.FruitName;
import org.lanqiao.annotation.FruitProvider;

public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = "RED")
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市未央区红富士大厦")
    private String appleProvider;
}