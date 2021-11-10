package lesson6;

public class Animal {
    private String name;
    private String color;
    private int maxLengthRun = 0;
    private static int count;

     public Animal(String name, String color) {
        this.name = name;
        this.color = color;
        count++;
    }

    public void swim (int distance) {
        System.out.printf(getName()+" не умеет плавать\n");
    }

    public void run (int distance) {
         if (distance <= this.maxLengthRun) System.out.printf("%s пробежал %d метров\n",this.getName(),distance);
         else System.out.printf("Некорректная дистанция\n");
    }

    public String getName() {
        return color+" "+name;
    }

    public void setMaxLengthRun(int maxLengthRun) {
        this.maxLengthRun = maxLengthRun;
    }

    public static int getCount() {
        return count;
    }
}
