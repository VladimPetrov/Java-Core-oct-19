package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray <T>{
    private T[] array;

    public MyArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void changeElements(int x, int y) {
        T elem;
        if ((x > array.length) || (y > array.length)) return;
        elem = array[x];
        array[x]=array[y];
        array[y]=elem;
    }

    public ArrayList<T> toArrayList() {
        return new ArrayList<T>(List.of(this.array));
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
