package db;

public class Message {
    public Pair fromToInfo;

    public String message;

    public Message(Pair fromToInfo, String message) {
        this.fromToInfo = fromToInfo;
        this.message = message;
    }

    @Override
    public String toString() {
        return  fromToInfo +
                message + '\n';
    }
}
