package org.example.animal.species;

import org.example.animal.Animal;

import java.time.LocalDate;

public class Elephant extends Animal {
    public Elephant(String name, int age, boolean hasOwner) {
        super(name, age, hasOwner);
    }

    @Override
    public void makeNoise() {
        System.out.println(LocalDate.now());
    }

    @Override
    public <T> void eat(T... food) {
        if(food.length % 2 == 0){
            makeNoise();
        } else {
            System.out.println("BRUMM!");
        }
    }
}
