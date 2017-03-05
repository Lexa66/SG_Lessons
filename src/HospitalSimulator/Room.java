package HospitalSimulator;

public class Room {

    int visitors, doctor;

    public Room() {}

    public synchronized void enterVisitor() throws InterruptedException {
        while (visitors >= 4 || doctor > 0)
            wait();
        visitors++;
    }

    public synchronized void exitV() {
        visitors--;
        notify();
    }

    public synchronized void enterDoc() throws InterruptedException {
        while (doctor > 0 || visitors > 0)
            wait();
        doctor++;
    }

    public synchronized void exitDoc() {
        doctor--;
        notify();
    }

    public int getVisitors() {
        return visitors;
    }

    public int getDoctors() {
        return doctor;
    }
}
