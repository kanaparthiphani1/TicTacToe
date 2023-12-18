package Strategy;

import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements WinningStrategy{

    List<Map<Symbol,Integer>> rowData;
    List<Map<Symbol,Integer>> colData;
    Map<Symbol,Integer> diagDta;
    Map<Symbol,Integer> revDiagDta;
    public OrderOneWinningStrategy(int size) {
        rowData = new ArrayList<>();
        colData = new ArrayList<>();
        diagDta = new HashMap<>();
        revDiagDta = new HashMap<>();
        for(int i=0; i<size; i++){
            rowData.add(new HashMap<>());
            colData.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinning(Move move, Board board) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();
        Player p = cell.getPlayer();

        Map<Symbol,Integer> rowMap = rowData.get(row);
        rowMap.put(p.getSymbol(), rowMap.getOrDefault(p.getSymbol(),0)+1);

        Map<Symbol,Integer> colMap = colData.get(col);
        colMap.put(p.getSymbol(), colMap.getOrDefault(p.getSymbol(),0)+1);

        if(row==col){
            diagDta.put(p.getSymbol(),diagDta.getOrDefault(p.getSymbol(),0)+1);
        }

        if(row+col==board.getDimension()-1){
            revDiagDta.put(p.getSymbol(),revDiagDta.getOrDefault(p.getSymbol(),0)+1);
        }

        return rowMap.get(p.getSymbol())==board.getDimension() ||
                colMap.get(p.getSymbol())==board.getDimension() ||
                diagDta.getOrDefault(p.getSymbol(),0)==board.getDimension() ||
                revDiagDta.getOrDefault(p.getSymbol(),0)==board.getDimension();
    }
}
