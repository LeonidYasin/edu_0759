/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int[] massiv =  {2, 3, 4, 5};


        int result =0;
        int sum =0;
        for (int i=0; i< massiv.length; i++) {

            sum += massiv[i];
            if (sum > 10) {result = i;
                break;}


        }
        if(result!=0) System.out.println(result);
        else System.out.println("сумма меньше 10");
    }
}
