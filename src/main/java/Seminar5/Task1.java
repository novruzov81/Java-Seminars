package Seminar5;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//        Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
//        Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова,
//        Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
//        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//        Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов");

        Map<String, Integer> namePopularity = new HashMap<>();
        for (String employee : employees) {
            namePopularity.put(employee, namePopularity.getOrDefault(employee, 0) + 1);
        }

        Map<String, Integer> sortedPopularity = new TreeMap<>(Collections.reverseOrder());
        sortedPopularity.putAll(namePopularity);

        for (Map.Entry<String, Integer> entry : sortedPopularity.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            System.out.println(name + ": " + count);
        }
    }
}


