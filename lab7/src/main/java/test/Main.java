package test;

import gamepackage.Board;
import gamepackage.Game;
import gamepackage.Player;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void runTest(){
        List<Player> somePlayers = Arrays.asList(new Player("Iulian"),
                new Player("Georgiana"),
                new Player("Darius"));

        Game game = new Game(new Board(5), somePlayers);
        game.play();
    }

    public static void main(String[] args){
        runTest();
    }
}
