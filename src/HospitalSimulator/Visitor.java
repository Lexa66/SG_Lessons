package HospitalSimulator;

public class Visitor extends Thread {
    private Room room;

    public Visitor(Room room) {
        this.room = room;
    }

    public void run() {
        try {
            sleep(1000);
            room.enterVisitor();
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        room.exitV();
    }
}
