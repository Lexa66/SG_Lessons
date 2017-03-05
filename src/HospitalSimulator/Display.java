package HospitalSimulator;

public class Display extends Thread {
    private Room room;

    public Display(Room room) {
        this.room = room;
    }

    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Doctors: " + room.getDoctors() +
                    " Visitors: " + room.getVisitors());
        }
    }
}

