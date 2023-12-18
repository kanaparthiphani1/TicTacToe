package Controllers;

import Entity.Game;
import Entity.Player;
import Enums.GameState;
import Strategy.OrderOneWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class GameController {
    public Game startGame(int dimension, List<Player> players){
        Game game = Game.getBuilder()
                .setDimension(3)
                .setPlayers(players)
                .setWinningStrategy(new OrderOneWinningStrategy(3))
                .build();
        return game;
    }

    public void displayBoard(Game game){
         game.getBoard().displayBoard();
    }

    public void makeMove(Game game){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter row : ");
        int row = sc.nextInt();
        System.out.println("Enter column : ");
        int col = sc.nextInt();
        game.makeMove(row, col);
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void getWinner(){

    }
}
