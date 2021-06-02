/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] massiv =  {2, 3, 4, 5};

        String str = "Нет";
        for (int i=0; i< massiv.length; i++) {
            if (massiv[i] == 5) str = "Да";

        }
        System.out.println(str);
    }
}
