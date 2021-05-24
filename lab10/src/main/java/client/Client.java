package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
        private static final int DISCONNECT_TIMEOUT = 10000;
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            long last=System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - last >= DISCONNECT_TIMEOUT)
                    break;
                last = System.currentTimeMillis();

                String request = scanner.nextLine();
                out.println(request);
                String response = in.readLine();

                if (!response.equals(""))
                    System.out.println("[Response] " + response);
                if (response.equals("exit"))
                    break;

            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
