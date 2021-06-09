/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> newCollection = new ArrayList<Integer>();

        numbers.add(23);
        numbers.add(32);
        numbers.add(5);
        numbers.add(63);
        numbers.add(38);
        numbers.add(2);
        numbers.add(45);
        numbers.add(3);

        numbers.forEach((Integer n) -> {
            if (n < 10 && n > 0) newCollection.add(n);
        });

        System.out.println("Исходная коллекция: " + numbers);
        System.out.println("Новая коллекция: " + newCollection);

    }
}
