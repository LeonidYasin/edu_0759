/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа.
Если их сумма больше 10 - пусть функция вернет true, а если нет - false.

*/


public class Main {
    public static boolean eq(int a, int b) {
        if(a+b > 10) return true; else return false;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(eq(-20, -10));
        System.out.println(eq(-20, 50));
    }
}
