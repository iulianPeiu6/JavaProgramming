package gamepackage;

import java.util.ArrayList;
import java.util.List;

public class Player  implements Runnable {

    int playerId;

    String name;

    private int score;

    private List<Token> extractedTokens;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.extractedTokens = new ArrayList<>();
    }

    private Board fromBoard;


    public void setFromBoard(Board fromBoard) {
        this.fromBoard = fromBoard;
    }

    @Override
    public void run(){
        while (true){
            Token extractedToken = fromBoard.getRandomExtractedToken(this);

            if (extractedToken == null)
                break;

            extractedTokens.add(extractedToken);
            System.out.println("Player " + name + " extracted token " + extractedToken);

        }
    }

    public void setScore(){
        score = 0;
        for (Token extractedToken : extractedTokens)
            score += extractedToken.value;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
