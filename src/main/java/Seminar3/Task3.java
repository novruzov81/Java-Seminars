package Seminar3;

//Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
//Вывести название каждой планеты и количество его повторений в списке. Collections.frequency(list, item)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Task3 {
    public static void main(String[] args) {
        List<String> planetList = new ArrayList<String>();
        Random random = new Random();

        // Adding planet names to the list
        planetList.add("Mercury");
        planetList.add("Venus");
        planetList.add("Earth");
        planetList.add("Mars");
        planetList.add("Jupiter");
        planetList.add("Saturn");
        planetList.add("Uranus");
        planetList.add("Neptune");

        // Adding the planet names again with repetitions
        planetList.add("Mercury");
        planetList.add("Venus");
        planetList.add("Earth");
        planetList.add("Mars");

        // Shuffling the list to get random order
        Collections.shuffle(planetList, random);

        // Printing each planet name and its frequency
        for (String planet : planetList) {
            int frequency = Collections.frequency(planetList, planet);
            System.out.println("Planet: " + planet + ", Frequency: " + frequency);
        }
    }
}
