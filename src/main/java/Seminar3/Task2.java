package Seminar3;

//Задан целочисленный список ArrayList.
//Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()

import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(1);

        // Нахождение минимального значения
        Integer min = Collections.min(arrayList);
        System.out.println("Минимальное значение: " + min);

        // Нахождение максимального значения
        Integer max = Collections.max(arrayList);
        System.out.println("Максимальное значение: " + max);

        // Нахождение среднего арифметического
        double sum = 0;
        for (Integer num : arrayList) {
            sum += num;
        }
        double average = sum / arrayList.size();
        System.out.println("Среднее арифметическое: " + average);
    }
}
