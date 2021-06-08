/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(10, 10, 50);
        Cat cat2 = new Cat(1, 10, 30);
        System.out.println("Бой cat1 сильнее = "+ cat1.fight(cat2));
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat(int age,int weight,int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }



    public boolean fight(Cat anotherCat) {

        int criteria = 0;
        if (age > anotherCat.age) criteria++; else criteria--;
        if (weight > anotherCat.weight) criteria++; else criteria --;
        if (strength > anotherCat.strength) criteria++; else criteria --;
        return criteria>0;

    }
}
