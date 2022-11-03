package org.example.animal.species;

import org.example.animal.Animal;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Chicken extends Animal {
    public Chicken(String name, int age, boolean hasOwner) {
        super(name, age, hasOwner);
    }

    @Override
    public void makeNoise() {
        System.out.println("CSIPP!");
    }

    @Override
    public <T> void eat(T... food) {
        System.out.println(Arrays.stream(food).map(Object::toString).collect(Collectors.joining()));
    }


}
