/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Введите число");
            array[i] = scanner.nextInt();
            System.out.println(array[i]);

        }

        for (int i = 0; i < 10; i++) {

            System.out.print(array[i] + " ");

        }
        System.out.println("");


        int sequence = 1;
        int sequenceMax = 0;

        for (int i = 0; i < array.length - 1; i++) {


            if (array[i] == array[i + 1]) {
                sequence++;
            } else {
                if (sequenceMax < sequence) {
                    sequenceMax = sequence;
                }
                sequence = 1;
            }
        }


        System.out.println(sequenceMax);

    }
}
