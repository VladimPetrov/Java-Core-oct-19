package lesson8;

public class Track implements Obstacle{
    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Беговая дорожка" +
                " длинна=" + length;
    }
}
