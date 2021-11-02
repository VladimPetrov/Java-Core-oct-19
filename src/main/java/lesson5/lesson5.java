package lesson5;

public class lesson5 {
    public static void main(String[] args) {
        //CatWithExample();
        Cat murka = new Cat("Murka", "red", 3);
        Cat barsik = new Cat("Barsik", "black", 5);
        murka.run();
        murka.voice();
        barsik.run();
        barsik.voice();
    }

    private static void CatWithExample() {
        /*Cat cat1 = new Cat();
        cat1.age = 3;
        cat1.setName("Murka");
        cat1.color = "red";

        System.out.println(cat1);

        //System.out.printf("Cat: name - %s, color - %s, age - \n" +
        //        "%d",cat1.name,cat1.color,cat1.age);

        Cat cat2 = new Cat();
        cat2.age = 4;
        cat2.name = "Barsik";
        cat2.color = "black";

        cat1.run();
        cat2.run();
        cat1.voice();
        cat2.voice();
        System.out.println(cat1.countLetterInMyName());
        System.out.println(cat2.countLetterInMyName());

         */
    }


}
