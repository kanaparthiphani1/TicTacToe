import Controllers.GameController;
import Entity.Game;
import Entity.Player;
import Entity.Symbol;
import Enums.GameState;
import Enums.PlayerType;
import Strategy.OrderOneWinningStrategy;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Player player1 = new Player(1,"phani",new Symbol('X'), PlayerType.HUMAN);
        Player player2 = new Player(2,"sumathi",new Symbol('O'), PlayerType.HUMAN);

        Game game = gameController.startGame(3,List.of(player1,player2));

        System.out.println("Game Starts");
        while(gameController.checkState(game).equals(GameState.INPROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);

        }

        if(gameController.checkState(game).equals(GameState.COMPLETED)){
            System.out.println("Winner is "+game.getWinner().getName());
        }

    }
}
