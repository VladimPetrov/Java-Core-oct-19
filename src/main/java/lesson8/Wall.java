package lesson8;

public class Wall implements Obstacle {
    private float hieght;

    public Wall(float hieght) {
        this.hieght = hieght;
    }

    public float getHieght() {
        return hieght;
    }

    @Override
    public String toString() {
        return "Стена" +
                " высота=" + hieght;
    }
}
