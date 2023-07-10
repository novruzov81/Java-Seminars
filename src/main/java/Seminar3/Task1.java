package Seminar3;

//Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List <Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Удаление четных чисел
        numbers.removeIf(n -> n % 2 == 0);

        // Вывод списка после удаления
        System.out.println(numbers);
    }
}
