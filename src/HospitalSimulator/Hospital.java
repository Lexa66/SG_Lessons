package HospitalSimulator;

import java.util.Random;

public class Hospital extends Thread {

    public void run() {
        Random r = new Random();
        Room room = new Room();
        Display display = new Display(room);
        display.start();
        while (true) {
            if (r.nextInt(5) < 4) {
                new Visitor(room).start();
            } else {
                new Doctor(room).start();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
