package lesson14;

public class ArrayUtils {

    public void printArray(int[] arr){
        System.out.print("[ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("]");
    }

    public boolean checkArray(int[] arr) {
        boolean one = false;
        boolean four = false;
        for (int elem: arr) {
            if(elem == 1) one = true;
            if(elem == 4) four = true;
        }
        return (one && four);
    }

    public int[] findLast4(int[] arr) {
        int j = arr.length + 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 4) j = i;
        }
        if(j == arr.length + 1) throw new RuntimeException("Not found 4");
        j++;
        int[] arrNew = new int[arr.length-j];
        for(int i = j; i < arr.length; i++) {
            arrNew[i-j] = arr[i];
        }
        return arrNew;
    }
}
