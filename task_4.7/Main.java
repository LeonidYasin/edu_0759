/*
Реализуй в классе Fox интерфейс Animal.
Учти, что создавать дополнительные классы и удалять методы нельзя!
Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

import java.awt.*;

public class Main {
    public static void main(String[] args){

        System.out.println(new Fox().getColor());
    }
}

interface Animal {
    Color getColor();
}

class Fox implements Animal {
    public String getName() {
        return "Fox";
    }

    @Override
    public Color getColor() {

        return  Color.ORANGE;
    }
}