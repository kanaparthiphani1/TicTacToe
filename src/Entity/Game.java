package Entity;

import Enums.GameState;
import Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int currentPlayerIndex;
    private GameState gameState;
    private WinningStrategy winningStrategy;
    private Player winner;

    private Game(int dimension,List<Player> players, WinningStrategy winningStrategy) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameState = GameState.INPROGRESS;
        this.winningStrategy = winningStrategy;
        this.winner = null;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static class GameBuilder{
        private int dimension;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public GameBuilder() {

        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Game build(){
            return new Game(dimension,players,winningStrategy);
        }


    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void makeMove(int row, int col){
       Player cur = this.players.get(currentPlayerIndex);
       Move move = cur.makeMove(row,col,board);
       this.moves.add(move);

        if(winningStrategy.checkWinning(move,board)){
            this.setGameState(GameState.COMPLETED);
            this.setWinner(cur);
        }
        if(this.moves.size()==board.getDimension()*board.getDimension()){
            this.setGameState(GameState.DRAW);
        }
        this.currentPlayerIndex = (this.currentPlayerIndex+1)% players.size();
    }
}
