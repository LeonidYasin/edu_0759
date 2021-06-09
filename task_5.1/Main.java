/*
 * Дана коллекция имён.
 * 1) удалить все повторяющиеся имена из коллекции
 * 2) вывести коллекцию на экран
 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");

        System.out.println("\nИсходная коллекция:\n"+names+"\n");
        System.out.println("Совпадают имена:");
        int size = names.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (names.get(i).contentEquals(names.get(j))) {

                    System.out.println("элемента "+i +" "+names.get(i)+ " и элемента "+j +" " + names.get(j));
                    names.remove(j);
                    size = names.size();
                }
            }
        }


        System.out.println("\nРезультат удаления повторяющихся имён:\n"+names);
    }


}