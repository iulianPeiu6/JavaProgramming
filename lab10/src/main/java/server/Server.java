package server;

import db.FriendsDB;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;

    public static FriendsDB friends;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        friends = new FriendsDB();
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                (new Thread(new ClientHandlerThread(socket))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

}
