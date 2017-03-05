
public class Del {
    public static void main(String[] args) {
        int count = 4;
        Thread[] athr = new Thread[count];
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < count;i++) {
            athr[i] = new Thread();
            athr[i].start();
        }

        try {
            for (int i = 0; i < count; i++) {
                athr[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }



//        int m = 0;
//        int x=0;
//        int tmp;
//        for (int i = 1; i <= 10000; i++){
//            tmp = getDividerAmount(i);
//            if (m < tmp){
//                x = i;
//                m=tmp;
//            }
//        }
//        System.out.println(x);
    }
//   static int getDividerAmount(int val){
//            int r=0;
//            for(int i=1;i<=val;i++){
//                if (val%i==0){
//                    r+=(i==val)?1:2;
//                }
//            }
//       return r;
//    }
}

