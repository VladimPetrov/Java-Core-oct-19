package lesson6;

public class Cat extends Animal {
    private static int count;

    public Cat(String name, String color) {
        super(name, color);
        super.setMaxLengthRun(200);
        count++;
    }

    @Override
    public String getName() {
        return "Кот "+super.getName();
    }

    public static int getCount() {
        return count;
    }
}
