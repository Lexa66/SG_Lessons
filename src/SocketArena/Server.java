package SocketArena;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;

public class Server extends Thread {

    private static final int port = 8080;

    public void run() {
        try {

            ServerSocket ss = new ServerSocket(port);
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept();
            System.out.println("Got a client");
            System.out.println();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = in.readUTF();
            System.out.println("The dumb client just sent me this line : " + line);
            System.out.println("I'm sending it back...");
            out.writeUTF(line);
            System.out.println("Game over");
            out.flush();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.run();

    }
}

