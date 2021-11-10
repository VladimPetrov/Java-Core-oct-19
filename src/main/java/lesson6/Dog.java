package lesson6;

public class Dog extends Animal {
    private int maxLengthSwim = 10;
    private static int count;

    public Dog(String name, String color){
        super(name, color);
        setMaxLengthRun(500);
        count++;
    }

    @Override
    public void swim (int distance) {
        if (distance <= this.maxLengthSwim) System.out.printf("%s проплыл %d метров\n",this.getName(),distance);
        else System.out.printf("Некорректная дистанция\n");
    }

    @Override
    public String getName() {
        return "Пес "+super.getName();
    }

    public static int getCount() {
        return count;
    }
}
