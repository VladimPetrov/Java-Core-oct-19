package lesson8;

public class Human implements Participant {
    private String name;
    private float maxHeight;
    private int maxLength;

    public Human(String name, float maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public boolean run(int length) {
        if(maxLength < length) {
            System.out.printf("Человек %s не пробежал дистанцию\n", name);
            return false;
        }
        System.out.printf("Человек %s пробежал дистанцию\n", name);
        return true;
    }

    @Override
    public boolean jump(float height) {
        if(maxHeight < height) {
            System.out.printf("Человек %s не перепрыгнул препятствие\n", name);
            return false;
        }
        System.out.printf("Человек %s перепрыгнул препятствие\n", name);
        return true;
    }

    @Override
    public String toString() {
        return "Человек " + name +
                " высота прыжка=" + maxHeight +
                " длина бега=" + maxLength;
    }
}
