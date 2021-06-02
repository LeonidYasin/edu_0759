/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] massiv =  {2, 3, 4, 5};

        String str = "Нет";
        for (int i=0; i< massiv.length-1; i++) {

            if (massiv[i] == massiv[i+1]) str = "Да";

        }
        System.out.println(str);

    }
}
