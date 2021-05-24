package gamepackage;

import java.util.List;

public class Game {

    private Board board;

    private List<Player> players;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;

        for (Player player : this.players) {
            player.setFromBoard(this.board);
        }
    }

    public void play(){

        board.setPlayersSchedule(players);

        for (Player player : players)
            (new Thread(player)).start();

//        for (Player player : players){
//            player.setScore();
//        }
    }


}
