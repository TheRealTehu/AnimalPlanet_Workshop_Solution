package org.example.animal.species;

import org.example.animal.Animal;
import org.example.animal.Talkative;

import java.util.Arrays;

public class Parrot extends Animal implements Talkative {
    public Parrot(String name, int age, boolean hasOwner) {
        super(name, age, hasOwner);
    }

    @Override
    public void makeNoise() {
        System.out.println("KARR-KARR");
    }

    @Override
    public <T> void eat(T... food) {
        Arrays.stream(food).forEach(System.out::println);
    }

    @Override
    public void speak() {
        System.out.println("Jó napot kívánok");
    }
}
