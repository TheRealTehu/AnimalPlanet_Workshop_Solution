package org.example.animal;

import org.example.Util;
import org.example.animal.exceptions.NoAnimalsFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnimalReader {
    private File file;

    public AnimalReader(String filePath) {
        this.file = new File(filePath);
    }

    public List<String> readAnimalsFromFile() throws NoAnimalsFoundException {
        List<String> animals = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                animals.addAll(
                        Arrays.stream(scanner.nextLine().split(";")) //Elválasztó karaktert lehetne Utilba rakni!
                                .filter(s -> Util.validAnimals.contains(s))
                                .toList()
                );
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file found!");
        }

        if(animals.size() == 0){
            throw new NoAnimalsFoundException();
        }

        return animals;
    }

    public int[] numberOfNonAnimalsInEachRow(){
        int[] numberOfNonAnimals = new int[getNumberOfRows()];
        try(Scanner scanner = new Scanner(file)) {
            int row = 0;
            while (scanner.hasNextLine()){
                numberOfNonAnimals[row] = (int) Arrays.stream(scanner.nextLine().split(";"))
                        .filter(s -> !Util.validAnimals.contains(s))
                        .count();
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file found!");
        }

        return numberOfNonAnimals;
    }

    private int getNumberOfRows() {
        int counter = 0;
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                counter++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file found!");
        }
        return counter;
    }
}
