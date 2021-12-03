package lesson11;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        myArrayExample();
        fruitBoxExample();
    }

    private static void fruitBoxExample() {
        Box<Apple> boxApple = new Box<>(new ArrayList());
        for(int i = 0; i < 6; i++) {
            boxApple.add(new Apple());
        }
        Box<Orange> boxOrange = new Box<>(new ArrayList());
        for(int i = 0; i < 6; i++) {
            boxOrange.add(new Orange());
        }
        Box<Apple> boxApple1 = new Box<>();

        System.out.println(boxApple);
        System.out.println(boxOrange);
        System.out.println(boxApple.compare(boxOrange));
        boxApple1.addAll(boxApple);

        System.out.println(boxApple1);
        System.out.println(boxApple);
    }

    private static void myArrayExample() {
        MyArray<Integer> arrayInt = new MyArray<>(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        MyArray<String> arrayStr = new MyArray<>(new String[]{"apple", "orange", "lemon", "banana", "cherry", "kiwi", "mango"});
        List<Integer> arrayListInt = new ArrayList<>();
        List<String> arrayListStr = new ArrayList<>();

        System.out.println(arrayInt);
        arrayInt.changeElements(0,6);
        System.out.println(arrayInt);

        System.out.println(arrayStr);
        arrayStr.changeElements(1,2);
        System.out.println(arrayStr);

        arrayListInt = arrayInt.toArrayList();
        System.out.println(arrayListInt);

        arrayListStr = arrayStr.toArrayList();
        System.out.println(arrayListStr);
    }

}
