package HospitalSimulator;

public class Main {

    public static void main(String[] args) throws Exception {
        int count = 5;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(new Hospital());
            threads[i].start();
        }
    }
}

