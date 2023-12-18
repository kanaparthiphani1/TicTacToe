package Entity;

import Enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board(int size) {
        this.dimension = size;
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> rowCell = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell(i,j,null, CellState.EMPTY);
                rowCell.add(cell);
            }
            this.board.add(rowCell);
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void displayBoard(){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board.get(i).get(j).getState()==CellState.EMPTY){
                    System.out.print('-');
                }else{
                    System.out.print(board.get(i).get(j).getPlayer().getSymbol().getSymbol());
                }
            }
            System.out.println("");
        }
    }
}
