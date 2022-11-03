package org.example.animal;

import org.example.animal.exceptions.NoAnimalsFoundException;
import org.example.animal.species.Chicken;
import org.example.animal.species.Elephant;
import org.example.animal.species.Horse;
import org.example.animal.species.Parrot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalFactory {
    private AnimalReader reader;
    Random random;

    public AnimalFactory(String filePath) {
        this.reader = new AnimalReader(filePath);
        random = new Random();
    }

    public List<Animal> getAnimalListFromFile(){
        List<Animal> animals = new ArrayList<>();

        try{
            List<String> types = reader.readAnimalsFromFile();
            for (String type : types) {
                switch (type.toLowerCase()){
                    case "parrot": animals.add(new Parrot(randomizeName(), randomizeAge(), randomizeOwnerStatus()));
                    case "horse": animals.add(new Horse(randomizeName(), randomizeAge(), randomizeOwnerStatus()));
                    case "elephant": animals.add(new Elephant(randomizeName(), randomizeAge(), randomizeOwnerStatus()));
                    case "chicken": animals.add(new Chicken(randomizeName(), randomizeAge(), randomizeOwnerStatus()));
                }
            }

        } catch (NoAnimalsFoundException e){
            System.out.println("There are no animals in this file!");
        }

        return animals;
    }

    private boolean randomizeOwnerStatus() {
        return random.nextBoolean();
    }

    private int randomizeAge() {
        return random.nextInt(0,101);
    }

    private String randomizeName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
