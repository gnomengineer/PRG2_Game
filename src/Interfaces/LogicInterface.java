package Interfaces;

import GameObjects.Line;
import GameObjects.Point;

/**
 *
 * @author Andre
 */
public interface LogicInterface {
    void initializeGame(int height, int width, OpponentInterface opponent);
    void setLine(Point startPoint, Point endPoint, boolean isOpponent);

    public void setLine(Line selectedLine, boolean isOpponent);
    public boolean isValidLine(Line selectedLine, boolean isOpponent);

    public int getPlayerState();

    public int getOpponentState();
}
