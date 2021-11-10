package lesson6;

import java.util.Random;


public class HomeWork {
    public static String[] catsName = {"Барсик", "Мурка", "Багира", "Том", "Китти", "Марго"};
    public static String[] dogsName = {"Мухтар", "Бобик", "Найда", "Арчи", "Барон", "Пират"};
    public static String[] animalsColor = {"Белый", "Черный", "Коричневый", "Рыжий"};
    public static Animal[] animals = new Animal[8];

    public static void main(String[] args) {

        newAnimals();
        printAnimals();
        runAnimals(400);
        swimAnimals(8);
        System.out.println("Колличество животных: "+(Animal.getCount()));
        System.out.println("Колличество кошек: "+(Cat.getCount()));
        System.out.println("Колличество собак: "+(Dog.getCount()));
    }

    public static void swimAnimals(int distance) {
        System.out.println("-------Заплыв-----------");
        for (int i = 0; i < animals.length; i++) {
            animals[i].swim(distance);
        }
        System.out.println("------------------------");
    }

    public static void runAnimals(int distance) {
        System.out.println("-------Забег-----------");
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(distance);
        }
        System.out.println("-----------------------");
    }

    public static void newAnimals() {
        Random rand = new Random();
        for (int i = 0; i < animals.length; i++) {
            switch (rand.nextInt(2)) {
                case 0 : {
                    animals[i] = new Cat(catsName[rand.nextInt(catsName.length)],animalsColor[rand.nextInt(animalsColor.length)]);
                    break;
                }
                case 1 : {
                    animals[i] = new Dog(dogsName[rand.nextInt(dogsName.length)],animalsColor[rand.nextInt(animalsColor.length)]);
                    break;
                }


            }
        }
    }

    public static void printAnimals() {
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].getName());
        }
    }

}
