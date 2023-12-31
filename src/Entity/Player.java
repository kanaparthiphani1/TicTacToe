package Entity;

import Enums.CellState;
import Enums.PlayerType;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player() {
    }

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(int row, int col, Board b){
        Cell cell = b.getBoard().get(row).get(col);
        cell.setRow(row);
        cell.setCol(col);
        cell.setState(CellState.FILLED);
        cell.setPlayer(this);
        Move move = new Move(cell);
        return move;
    }
}
