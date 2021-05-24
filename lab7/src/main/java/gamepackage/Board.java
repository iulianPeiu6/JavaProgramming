package gamepackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private int n;

    private List<Token> tokens;

    public Board(int n){
        this.n = n;
        this.tokens = Token.getDefaultTokenList(n);
    }

    public Board(int n, List<Token> tokens) {
        this.n = n;
        this.tokens = tokens;
    }

    private volatile List<Player> players;
    private volatile List<Boolean> playersSchedule;

    public void setPlayersSchedule(List<Player> players){
        this.players = players;
        playersSchedule = new ArrayList<>();

        for (Player player : players)
                playersSchedule.add(false);

        playersSchedule.set(0,true);
    }

    public synchronized Token getRandomExtractedTokenv0(Player currentPlayer){

        Token extractedToken;

        if (tokens.size() == 0)
            return null;

        int fromIndex = (int) (Math.random() * (tokens.size() - 1));
        extractedToken = tokens.get(fromIndex);
        tokens.remove(fromIndex);

        return extractedToken;
    }

    public synchronized Token getRandomExtractedToken(Player currentPlayer){

        int playerIndex = players.indexOf(currentPlayer);

        while (!playersSchedule.get(playerIndex)){
            System.out.println("Player " + currentPlayer.name + " waiting " );
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        Token extractedToken;

        if (tokens.size() == 0)
            return null;

        int fromIndex = (int) (Math.random() * (tokens.size() - 1));
        extractedToken = tokens.get(fromIndex);
        tokens.remove(fromIndex);

        playersSchedule.set(playerIndex,false);
        playersSchedule.set((playerIndex+1)%playersSchedule.size(),true);

        notifyAll();

        return extractedToken;
    }

}
