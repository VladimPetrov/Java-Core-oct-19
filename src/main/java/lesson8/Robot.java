package lesson8;

public class Robot implements Participant {
    private String name;
    private float maxHeight;
    private int maxLength;

    public Robot(String name, float maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public boolean run(int length) {
        if(maxLength < length) {
            System.out.printf("Робот %s не пробежал дистанцию\n", name);
            return false;
        }
        System.out.printf("Робот %s пробежал дистанцию\n", name);
        return true;
    }

    @Override
    public boolean jump(float height) {
        if(maxHeight < height) {
            System.out.printf("Робот %s не перепрыгнул препятствие\n", name);
            return false;
        }
        System.out.printf("Робот %s перепрыгнул препятствие\n", name);
        return true;
    }

    @Override
    public String toString() {
        return "Робот " + name +
                " высота прыжка=" + maxHeight +
                " длина бега=" + maxLength;
    }
}
