package lesson2.jca;

import java.time.chrono.MinguoChronology;

public class lesson2 {

    public static void main(String[] args) {

// Задание 1
        System.out.println("Задание 1");
        Metod1();

// Задание 2
        System.out.println("Задание 2");
        Metod2();

// Задание 3
        System.out.println("Задание 3");
        Metod3();

// Задание 4
        System.out.println("Задание 4");
        Metod4(4);

// Задание 5
        System.out.println("Задание 5");
        System.out.println(Metod5(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}));

// Задание 6
        System.out.println("Задание 6");
        System.out.println(Metod6(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));

// Задание 7
        System.out.println("Задание 7");
        printArrayVar1(Metod7(new int[]{5,3,1,7,6},-2));
    }

    public static int[] Metod7(int[] arr, int n) {
        if (Math.abs(n) > arr.length) { n = n/arr.length; }
        if (n < 0) { n = arr.length + n;}
        for(int i = 1; i <= n; i++){
            arr = SdvigNaOdin(arr);
        }
        return arr;
    }

    public static int[] SdvigNaOdin(int [] arr) {
        int temp = arr[arr.length -1];
        int temp2;
        for(int i=0; i < arr.length -2; i += 2) {
            temp2 = arr[i+1];
            arr[i+1] = arr[i];
            arr[i] = temp;
            temp = temp2;
        }
       arr[arr.length -1] = temp;
       return arr;
    }

    public static Boolean Metod6(int[] arr) {
        int sumArr = 0;
        for(int i = 0 ; i <= arr.length - 1; i++){
            sumArr += arr[i];
        }
        boolean checkBalance = false;
        int sumRab = 0;
        for(int i = 0 ; i <= arr.length - 1; i++){
            if (sumRab + arr[i] == sumArr - arr[i]) {
                checkBalance = true;
                break;
            } else {
                sumRab += arr[i];
                sumArr -= arr[i];
            }
        }
        return checkBalance;
    }

    public static String Metod5(int[] arr) {
        int elemMax = arr[0], elemMin = arr[0];
        for(int i=1; i <= arr.length - 1; i++){
            if (arr[i] > elemMax ) {
                elemMax = arr[i];
            }
            if (arr[i] < elemMin ) {
                elemMin = arr[i];
            }
        }
        return "Max="+elemMax+"   Min="+elemMin;
    }


    public static void Metod4(int n) {
        int[][] arr = new int[n][n];
        for(int i = 0; i <= arr.length - 1; i++){
            arr[i][i] = 1;
            arr[(arr.length - 1) - i][i]=1;
        }
        printArrayVar2(arr);
    }

    public static void Metod3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArrayVar1(arr);
        for(int i = 0; i <= arr.length - 1; i++){
            if(arr[i]<6){
                arr[i] = arr[i]*2;
            }
        }
        printArrayVar1(arr);
    }

    public static void Metod2() {
        int[] arr = new int[8];
        for(int i = 0; i <= arr.length - 1; i++){
            arr[i] = i*3;
        }
        printArrayVar1(arr);
    }

    public static void Metod1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArrayVar1(arr);
        for (int i = 0; i <= arr.length - 1; i++) {
            switch (arr[i]) {
                case 1:
                    arr[i] = 0;
                    break;
                case 0:
                    arr[i] = 1;
            }
        }
        printArrayVar1(arr);
    }

    public static void printArrayVar1(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
}
    public static void printArrayVar2(int[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print("[ ");
            for (int j = 0; j <= arr[i].length - 1; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
