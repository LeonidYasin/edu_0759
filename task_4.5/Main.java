/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal,
 в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse,
 в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main {
    public static void main(String[] args) {
        new Horse().run();
        new Pegasus().fly();
    }
}

abstract class Animal {
    // public abstract void run();
    // public  abstract void fly();

}

class Horse extends Animal {

    String say = "Игого, я поскакал(а)";

    public void run() {
        System.out.println(say);
    }

}

class Pegasus extends Horse {


    public void fly() {
        System.out.println("Игого, я полетел(а)");
    }
}


