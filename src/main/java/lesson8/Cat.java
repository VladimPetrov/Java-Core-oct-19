package lesson8;

public class Cat implements Participant {
    private String name;
    private float maxHeight;
    private int maxLength;

    public Cat(String name, float maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public boolean run(int length) {
        if(maxLength < length) {
            System.out.printf("Кот %s не пробежал дистанцию\n", name);
            return false;
        }
        System.out.printf("Кот %s пробежал дистанцию\n", name);
        return true;
    }

    @Override
    public boolean jump(float height) {
        if(maxHeight < height) {
            System.out.printf("Кот %s не перепрыгнул препятствие\n", name);
            return false;
        }
        System.out.printf("Кот %s перепрыгнул препятствие\n", name);
        return true;
    }

    @Override
    public String toString() {
        return "Кот " + name +
                " высота прыжка=" + maxHeight +
                " длина бега=" + maxLength;
    }
}
