package Seminar4;

//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
//        Постараться не обращаться к листу по индексам.
//        Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент
//        в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его,
//        first() - возвращает первый элемент из очереди, не удаляя.
//        Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор

import java.util.Iterator;
import java.util.LinkedList;

public class Task1 {
    public static void main(String[] args) {
        // Создание и заполнение LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        // Вывод исходного списка
        System.out.println("Исходный список: " + linkedList);

        // Переворачивание списка
        LinkedList<Integer> reversedList = reverseLinkedList(linkedList);
        System.out.println("Перевернутый список: " + reversedList);

        // Создание и использование очереди на основе LinkedList
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Первый элемент в очереди: " + queue.first());
        System.out.println("Удаление и возвращение элемента из очереди: " + queue.dequeue());

        // Сумма всех элементов в LinkedList
        int sum = calculateSum(linkedList);
        System.out.println("Сумма всех элементов списка: " + sum);
    }

    static class QueueUsingLinkedList<T> {
        private LinkedList<T> queue;

        public QueueUsingLinkedList() {
            queue = new LinkedList<>();
        }

        public void enqueue(T element) {
            queue.addLast(element);
        }

        public T dequeue() {
            return queue.pollFirst();
        }

        public T first() {
            return queue.peekFirst();
        }
    }

    static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        Iterator<Integer> iterator = list.descendingIterator();

        while (iterator.hasNext()) {
            reversedList.add(iterator.next());
        }

        return reversedList;
    }

    static int calculateSum(LinkedList<Integer> list) {
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }
}

