import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Boolean;

public class Test {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        Cat c0 = new Cat("Barsik", 10.5f);
        Cat c1 = new Cat("Vaska", 8f);
        Cat c2 = new Cat("Ludovik Franz Iosif", 5.4f);
        Cat c3 = new Cat ("Mashka", 9.9f);
        cats[0] = c0;
        cats[1] = c1;
        cats[2] = c2;
        cats[3] = c3;

        Plate p = new Plate(25);
        p.fillPlate(24.9f);
        
        System.out.println("6ое задание");
        for (int i =0; i < cats.length; i++){
            cats[i].Eat(p);
            System.out.println(cats[i].name + " satiety: " + cats[i].satiety);
            System.out.println("Plate still has " + p.getFood() + " of food");
        }

        System.out.println();

        System.out.println("7ое задание");
        for (int i =0; i < cats.length; i++){
            if (cats[i].appetite > p.getFood()){
                p.fillPlate(p.getVolume());
            }
            cats[i].Eat(p);
            System.out.println(cats[i].name + " satiety: " + cats[i].satiety);
            System.out.println("Plate still has " + p.getFood() + " of food");
        }
    }
}
