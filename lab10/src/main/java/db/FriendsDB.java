package db;

import java.util.ArrayList;
import java.util.List;

public class FriendsDB {

    private List<String> users;

    private List<Message> messages;

    private List<Pair> friendships;

    public FriendsDB() {
        users = new ArrayList<>();
        friendships = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public String addUser(String user){
        if (userExists(user))
            return user + " already exists";

        users.add(user);
        return "Successfully registered";
    }

    public String addFriendships(String currentUser, List<String> users){
        if (currentUser == null)
            return " not logged";
        if (!userExists(currentUser))
            return currentUser + "does not exist";

        for (String user : users)
            if (!userExists(user))
                return user + " does not exist";

        for (String user : users) {
            friendships.add(new Pair(currentUser, user));
            friendships.add(new Pair(user, currentUser));
        }

        return "Friendships added successfully";
    }

    public String login(String user){
        if (userExists(user))
            return user + "logged";
        return user + "does not exist";
    }

    public String sendMessages(String fromUser, String message){
        if (fromUser == null)
            return " not logged";
        for (Pair pair : friendships)
            if (pair.from.equals(fromUser))
                messages.add(new Message(pair, message));
        return "message sent";
    }

    public String readMessages(String toUser){
        if (toUser == null)
            return " not logged";
        StringBuilder messagesBuilder = new StringBuilder();
        for (Message message : messages)
            if (message.fromToInfo.to.equals(toUser))
                messagesBuilder.append(message);

        return new String(messagesBuilder);
    }

    private boolean userExists(String currentUser) {
        for (String user : users)
            if (currentUser.equals(user))
                return true;
        return false;
    }
}
