package lesson11;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private ArrayList<T> array;

    public Box() {

    }

    public Box(ArrayList<T> array) {
        this.array = array;
    }

    public int getCount() {
        return this.array.size();
    }

    public boolean isEmpty() {
        if(this.array == null) { return true;}
        return (this.array.size() == 0);
    }

    public T getFruit(int x) {
        return this.array.get(x);
    }

    public Float getWeight() {
        if (this.array.size() == 0 ) return 0.0f;
        return this.array.size()*this.array.get(0).getWeight();
    }

    public boolean compare(Box<?> box) {
        return (Math.abs(this.getWeight() - box.getWeight()) < 0.001);
    }

    public void add(T elem) {
        if(this.array ==  null) {
            this.array = new ArrayList<>();
        }
        this.array.add(elem);
    }

    public void remoteAll() {
        this.array.clear();
    }

    public void addAll (Box<T> anotherBox) {
        if (anotherBox.isEmpty()) { return; }
        //if (this.isEmpty())  { return; }
        for (int i = 0; i < anotherBox.getCount(); i++) {
            this.add(anotherBox.getFruit(i));
        }
        anotherBox.remoteAll();
    }

    @Override
    public String toString() {
        if(this.isEmpty()) { return "In box is empty"; }
        return "In box " + array.size() + " " +array.get(0).toString() +
                ". Weight=" + this.getWeight().toString();
    }
}
