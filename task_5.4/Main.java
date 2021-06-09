
/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String stringPath = scanner.nextLine();
        System.out.println("Вы ввели путь:" + stringPath);

        ArrayList<Integer> sortedList = new ArrayList<Integer>();

        if (stringPath.contentEquals("test")) stringPath = "c:\\temp\\test.txt";
        File file = new File(stringPath);


        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String text;
                try {
                    while (((text = bufferedReader.readLine()) != null)) {

                        Integer i = Integer.parseInt(text);

                        //   System.out.println("text="+text +" int="+ i);
                        if (i != null)
                            if (i.intValue() > 0)
                                sortedList.add(i);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("\n Несортированный список больше нуля:\n" + sortedList);
            Collections.sort(sortedList);
            System.out.println("\n Сортированный список больше нуля:\n" + sortedList);
        } else System.out.println("Файл не найден");

    }
}
