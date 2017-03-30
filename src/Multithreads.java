import java.util.Random;

public class Multithreads {
    private static class WorkerThread extends Thread {
        public void run() {
            int m = 0;
            int x = 0;
            int tmp;
            for (int i = 1; i <= 10000; i++){
                tmp = getDividerAmount(i);
                if (m < tmp){
                    x = i;
                    m=tmp;
                }
            }
            System.out.println(x);
        }
        }
        static int getDividerAmount(int val){
            int r=0;
            for(int i=1;i<=val;i++){
                if (val%i==0){
                    r+=(i==val)?1:2;
                }
            }
            return r;
        }
//        int max = Integer.MIN_VALUE;
//        int[] array;
//
//        public WorkerThread(int[] array) {
//            this.array = array;
//        }
//
//        public void run() {
//            for (int i = 0; i < array.length; i++)
//                max = Math.max(max, array[i]);
//        }
//
//        public int getMax() {
//            return max;
//        }
    }

//    public static void main(String[] args) {
//        Random r = new Random(1000);
//        WorkerThread[] threads = new WorkerThread[4];
//        int[]arr = new int[100];
//        for(int i = 0; i<arr.length;i++) {
//            arr[i]= i;
//            System.out.print( arr[i]);
//        }
//
//        int max = Integer.MIN_VALUE;
//
//        for (int i=0; i < 4; i++) {
//            threads[i] = new WorkerThread(new int[]{arr[i]});
//            threads[i].start();
//        }
//
//        try {
//            for (int i=0; i < 4; i++) {
//                threads[i].join();
//                max = Math.max(max, threads[i].getMax());
//            }
//        }
//        catch (InterruptedException e) {
//        }
//
//        System.out.println("Maximum value: " + max);
//    }
//}

