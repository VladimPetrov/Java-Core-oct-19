package lesson7;

import java.util.Random;

public class lesson7 {
    public static String[] catsName = {"Барсик", "Мурка", "Багира", "Том", "Китти", "Марго"};
    public static String[] animalsColor = {"Белый", "Черный", "Коричневый", "Рыжий"};
    public static Cat[] cats = new Cat[8];
    public static Bowl bowl = new Bowl(50);
    public static void main(String[] args) {

    newCats();
    infoCats();
    eatCats();
    infoCatsSatiety();

    }
    public static void eatCats() {
        System.out.println("-----------------------");
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        System.out.println("-----------------------");
    }
    public static void newCats() {
        Random rand = new Random();
        for (int i = 0; i < cats.length; i++) {
               cats[i] = new Cat(animalsColor[rand.nextInt(animalsColor.length)]+" "+catsName[rand.nextInt(catsName.length)], rand.nextInt(4)*10+rand.nextInt(10));
        }
    }
    public static void infoCats() {
        System.out.println("-----------------------");
        for (Cat cat : cats) {
            cat.infoCat();
        }
        System.out.println("-----------------------");
    }
    public static void infoCatsSatiety() {
        System.out.println("-----------------------");
        for (Cat cat : cats) {
            cat.infoCatSatiety();
        }
        System.out.println("-----------------------");
    }
}
