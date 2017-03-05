package HospitalSimulator;

public class Doctor extends Thread {
    private Room room;

    public Doctor(Room room) {
        this.room = room;
    }

    public void run() {
        try {
            sleep(1000);
            room.enterDoc();
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        room.exitDoc();
    }
}
