package lesson12;

public class HomeWork {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];

        simpleСalculation(arr1);
        threadСalculation(arr2);
        if(compareArray(arr1,arr2)) System.out.println("массивы равны");
            else System.out.println("массивы не равны");

    }

    private static boolean compareArray(float[] a1, float[] a2) {
        for(int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                System.out.printf("a1[%d]=%f\n",i,a1[i]);
                System.out.printf("a2[%d]=%f\n",i,a2[i]);
                return false;
            }
        }
        return true;
    }

    private static void threadСalculation(float[] arr) {

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < h; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < h; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
                }
            }
        });
        t2.start();

        while(!((t1.getState() == Thread.State.TERMINATED) && (t2.getState() == Thread.State.TERMINATED))) {

        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.printf("Время работы расчета c двуми потоками: %d\n",(System.currentTimeMillis() - a));

    }

    private static void simpleСalculation(float[] arr) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }

        long a = System.currentTimeMillis();

        for(int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("Время работы простого расчета: %d\n",(System.currentTimeMillis() - a));
    }

}
