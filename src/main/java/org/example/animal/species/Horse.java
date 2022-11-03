package org.example.animal.species;

import org.example.animal.Animal;

import java.util.Arrays;

public class Horse extends Animal {
    public Horse(String name, int age, boolean hasOwner) {
        super(name, age, hasOwner);
    }

    @Override
    public void makeNoise() {
        System.out.println("Horse noises!");
    }

    @Override
    public <T> void eat(T... food) {
        System.out.println(Arrays.stream(food).mapToInt(t -> t.toString().length()).reduce(1, (a,b) -> a*b));
    }
}
