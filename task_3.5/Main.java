/*
Задание: Дан массив с числами.
Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


static int i =0;
public static void main(String[] args) {

        int num[] = {4,2,6,2,65};



        System.out.println(num[i]);
        i++;
        if(i< num.length) main(null);

        }
