/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа.
Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {

    public static boolean eq(int a, int b) {
        if(a==b) return true; else return false;

    }

    public static void main(String[] args) {
        System.out.println(eq(-20, -10));
        System.out.println(eq(-20, -20));
    }
}
