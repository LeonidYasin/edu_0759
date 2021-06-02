/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        int[] massiv =  {2, 3, 4, 5};

        int multiplication =1;
        for (int i=0; i< massiv.length; i++) {
            multiplication *=  massiv[i];

        }
        System.out.println(multiplication);
    }
}
