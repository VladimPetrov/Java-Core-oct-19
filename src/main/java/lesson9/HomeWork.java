package lesson9;

public class HomeWork {
    public static void main(String[] args) {
        String[][] arr1 = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        String[][] arr2 = {{"1","2","3","4"},{"4","5","6","s"},{"8","9","10","11"},{"12","13","14","15"}};
        String[][] arr3 = {{"4","5","6","1"},{"8","9","10","11"},{"12","13","14","15"}};
        String[][] arr4 = {{"1","2","3"},{"4","5","6","1"},{"8","9","10","11"},{"12","13","14","15"}};

        summArray1(arr1);
        summArray1(arr2);
        summArray1(arr3);
        summArray1(arr4);
    }

    private static void summArray1(String[][] arr) {
        printArray(arr);
        try {
            System.out.println("Сумма массива:" + summArray2(arr));
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } catch (MyArraySizeException e ) {
            System.out.println(e.getMessage());
        }
    }

    public static int summArray2 (String[][] arr) {
        if (arr.length != 4) throw new MyArraySizeException("Неправильная длинна массива");
        for(int i=0; i < 4; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Неправильная длинна массива");
        }
        int summ = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                try {
                    summ += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка данных массива. Элемент["+i+"]["+j+"]="+arr[i][j]);
                }
            }
        }
        return summ;
    }

    public static void printArray (String[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print("{");
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+",");
            }
            System.out.println("}");
        }
    }

}
