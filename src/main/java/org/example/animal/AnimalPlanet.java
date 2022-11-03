package org.example.animal;

import java.util.List;

public class AnimalPlanet {
    private final List<Animal> animals;
    private final AnimalFactory factory;

    public AnimalPlanet(String filePath) {
        factory = new AnimalFactory(filePath);

        animals = factory.getAnimalListFromFile();
    }

    public void listen() {
        animals.forEach(Animal::makeNoise);
    }

    public void feedAnimalsWithThreeFoods() {
        for (Animal animal : animals) {
            switch (animal.getClass().getSimpleName()) {
                case "Chicken" -> animal.eat("Food", "food", "FOOD");
                case "Elephant" -> animal.eat(true, false, false);
                case "Horse" -> animal.eat(1.0, 22.22, 3.456);
                case "Parrot" -> animal.eat(1, 23, 31);
            }
        }
    }
}
