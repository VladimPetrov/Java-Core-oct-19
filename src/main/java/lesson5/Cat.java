package lesson5;

import java.time.Year;

public class Cat {
    private String name;
    private String color;
    private int birthYaer;
    private boolean happy;

    public Cat() {
        System.out.println("Cat born");
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat(String name, String color, int age) {
        this(name);
        this.color = color;
        this.birthYaer = Year.now().getValue()-age;
    }

    public Cat bornCat() {
        return new Cat("unknown","unknown", 1);
    }


    public void run() {
        System.out.printf("Cat %s runnning\n", name);
    }

    public void voice() {
        System.out.printf("%s meaw\n", name);
    }

    public int countLetterInMyName() {
        return name.length();
    }

    @Override
    public String toString() {
        return String.format("Cat: name - %s, color - %s, age - %d",name,color,getAge());
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return Year.now().getValue() - birthYaer;
    }

    public void setName(String str) {
        name = str;
    }

}
