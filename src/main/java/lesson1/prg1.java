package lesson1;

public class prg1 {

    public static void main(String[] args){

// Задание 1
        System.out.println(metod1(2f,2f,6f,3f));
// Задание 2
        System.out.println(metod2(10,4));
// Задание 3
        metod3(-3);
// Задание 4
        System.out.println(metod4(-3));
// Задание 5
        metod5("Илья");
// Задание 6
        System.out.println(metod6(1504));

    }

    public static float metod1(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean metod2(int a, int b){
        return  (a + b) >= 10 && (a + b) <= 20;
    }

    public static void metod3(int a){
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean metod4(int a){
        return (a < 0);
    }

    public static void metod5(String s){
        System.out.println("Привет, "+s+"!");
    }

    public static boolean metod6(int a){
        boolean b = false;
        if (a % 400 == 0 ) {
            b = true;
        }else if ((a % 4 == 0) || (a % 100 != 0)){
            b = true;
        }
        return b;
    }
}
