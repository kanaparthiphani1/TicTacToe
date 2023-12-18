package Entity;

import Enums.CellState;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState state;

    public Cell(int row, int col, Player player, CellState state) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
