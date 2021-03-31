package level2.homework5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        method1();
        int n = 9;
        method2(n);
    }

    static void method1() {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }


    static void method2(int n) {
        Arrays.fill(arr, 1);

        float[][] miniArr = new float[n][];
        int sizeMiniArr = size / n;
        int sizeMiniArrFirst = sizeMiniArr + size % n;

        long b = System.currentTimeMillis();
        float[] tmp = new float[sizeMiniArrFirst];

        System.arraycopy(arr, 0, tmp, 0, sizeMiniArrFirst);
        miniArr[0] = tmp;

        if (n > 1) {
            for (int i = 1; i < n; i++) {
                float[] tmp1 = new float[sizeMiniArr];
                System.arraycopy(arr, sizeMiniArrFirst + sizeMiniArr * (i - 1), tmp1, 0, sizeMiniArr);
                miniArr[i] = tmp1;
            }
        }


        MyThread threadFirst = new MyThread(sizeMiniArrFirst, miniArr[0]);
        threadFirst.start();
        try {
            threadFirst.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (n > 1) {
            MyThread[] thread = new MyThread[n - 1];

            for (int i = 0; i < n-1; i++) {
                thread[i] = new MyThread(sizeMiniArr, miniArr[i]);
                thread[i].start();
                try {
                    thread[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.arraycopy(miniArr[0], 0, arr, 0, sizeMiniArrFirst);
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                System.arraycopy(miniArr[i], 0, arr, sizeMiniArrFirst + sizeMiniArr * (i - 1), sizeMiniArr);
            }
        }

        System.out.println(System.currentTimeMillis() - b);

    }
}

class MyThread extends Thread{

    private int size;
    private float[] arr;

    public MyThread(int size, float arr[]) {

        this.size = size;
        this.arr = arr;
    }

    @Override
    public void run() {
        array(size,arr);
    }
    public static float[] array(int size, float arr[]){

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
}
