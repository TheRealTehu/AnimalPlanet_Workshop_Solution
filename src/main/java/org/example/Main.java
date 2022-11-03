package org.example;

import org.example.animal.AnimalPlanet;

public class Main {
    public static void main(String[] args) {
        AnimalPlanet planet = new AnimalPlanet(Util.animalFile1);

        planet.listen();

        System.out.println("FEEDING TIME");

        planet.feedAnimalsWithThreeFoods();
    }
}