package com.mizgmapr.project.classes;

import java.io.File;

public class Cat extends Pet{
    boolean hypoallergenic;
    boolean fur;
    String color;


    public Cat(String name, String owner_data, String race, double weight, boolean aggressive, String color, boolean fur, boolean hypoallergenic) {
        super(name, owner_data, race, weight, aggressive);
        this.color = color;
        this.fur = fur;
        this.hypoallergenic = hypoallergenic;
    }
}
