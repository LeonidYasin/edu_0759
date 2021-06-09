/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        list.add("Москва");
        list.add("Ивановы");
        list.add("Киев");
        list.add("Петровы");
        list.add("Лондон");
        list.add("Абрамовичи");
        list.add("Саратов");
        list.add("Саратовы");

        while (true) {
            System.out.println("Введите город проживания семьи или enter, чтобы завершить ввод");
            String town = scanner.nextLine();
            if (town.isEmpty() || town.contentEquals("enter")) {
                break;
            }
            list.add(town);
            System.out.println("Введите фамилию семьи в этом городе ");
            String family = scanner.nextLine();

            list.add(family);

        }

        while (true) {
            System.out.println("Введите город или \"exit\", чтобы выйти из программы");

            String town = scanner.nextLine();

            if (town.isEmpty() || town.contentEquals("exit")) {
                break;
            }

            if (list.contains(town)) {


                System.out.println("В этом городе живут: " + list.get(list.indexOf(town) + 1));
            }
        }
    }
}

