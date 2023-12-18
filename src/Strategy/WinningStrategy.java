package Strategy;

import Entity.Board;
import Entity.Move;

public interface WinningStrategy {
    public boolean checkWinning(Move move, Board board);
}
