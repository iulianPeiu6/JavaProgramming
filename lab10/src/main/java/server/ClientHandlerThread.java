package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandlerThread implements Runnable {
    private Socket socket = null ;

    public ClientHandlerThread(Socket socket) {
        this.socket = socket ;
    }

    private String loggedUser = null;

    public void run () {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                String response = getResponseToRequest(request);
                out.println(response);
                out.flush();

                if (response.equals("exit"))
                    break;
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println (e);
            }
        }
    }



    private String getResponseToRequest(String request) {
        System.out.println("[handling request] " + request);
        var cmd = request.split(" ");

        if (cmd[0].equals("exit"))
            return "exit";

        if (cmd[0].equals("login")){
            String response = Server.friends.login(cmd[1]);
            if (response.equals(cmd[1] + "logged"))
                loggedUser = cmd[1];
            return response;
        }

        if (cmd[0].equals("register"))
            return Server.friends.addUser(cmd[1]);

        if (cmd[0].equals("friend")) {
            List <String> users = new ArrayList<>();
            for (int i=1; i < cmd.length; i++)
                users.add(cmd[i]);
            return Server.friends.addFriendships(loggedUser, users);
        }

        if (cmd[0].equals("send")){
            StringBuilder message = new StringBuilder();
            for (int i=1; i < cmd.length; i++)
                message.append(cmd[i] + " ");
            return Server.friends.sendMessages(loggedUser, new String(message));
        }

        if (cmd[0].equals("read"))
            return Server.friends.readMessages(loggedUser);

        return "not a valid command";
    }
}
