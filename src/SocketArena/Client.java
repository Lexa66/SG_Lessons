package SocketArena;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Client extends Thread {
    static int serverPort = 8080;
    static String address = "127.0.0.1";
    private String fighterName;
    private int strength;
    private int ability;
    private int instinct;
    private int health;

    public Client() {
    }

    public Client(String fighterName, int strength, int ability, int instinct, int health) {
        this.fighterName = fighterName;
        this.strength = strength;
        this.ability = ability;
        this.instinct = instinct;
        this.health = health;
    }


    public static Client createFighter(String name) {
        Random r = new Random();

        double str = r.nextInt(100);
        double ab = r.nextInt(100);
        double intuit = r.nextInt(100);

        double probability = (50 / (str + ab + intuit));

        int strength = (int) (str * probability);
        int ability = (int) (ab * probability);
        int instinct = (int) (intuit * probability);

        int health = 100;

        return new Client(name, strength, ability, instinct, health);
    }

    public void kick(Client fighter) {
        Random r = new Random();

        int damage = fighter.getInstinct() + fighter.getStrength();
        if (fighter.getAbility() > damage) {
            damage = r.nextInt(damage / 2);
        }
        fighter.setHealth(fighter.getHealth() - damage);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getInstinct() {
        return instinct;
    }

    public void setInstinct(int instinct) {
        this.instinct = instinct;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getFighterName() {
        return fighterName;
    }

    public void setFighterName(String fighterName) {
        this.fighterName = fighterName;
    }

    public static void fight(List<Client> fighters) {
        Random r = new Random();
        Boolean b = r.nextBoolean();
        Client first = (b == true ? fighters.get(0) : fighters.get(1));
        Client second = (b == false ? fighters.get(0) : fighters.get(1));

        while (true) {
            first.kick(second);
            if (second.getHealth() < 1) {
                fighters.remove(second);
                fighters.add(first);
                fighters.remove(first);
                break;
            }
            second.kick(first);
            if (first.getHealth() < 1) {
                fighters.remove(first);
                fighters.add(second);
                fighters.remove(second);
                break;
            }
        }
    }

    static void action(List<Client> fighters) {

        while (true) {
            fight(fighters);
            if (fighters.size() < 2) {
                System.out.println();
                System.out.println("Winner of tournament: " + fighters.get(0).getName());
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        List<Client> fighters = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            fighters.add(Client.createFighter("Fighter" + i));
        }
        action(fighters);

        Client client = new Client();
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            String line = "Winner of tournament: " + fighters.get(0).getName();
            ;

            System.out.println("Sending this line to the server...");
            out.writeUTF(line);
            out.flush();
            line = in.readUTF();
            System.out.println("The server sent me this : " + line);
            System.out.println();

        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
