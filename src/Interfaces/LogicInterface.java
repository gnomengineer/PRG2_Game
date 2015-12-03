package Interfaces;

import GameObjects.Point;

/**
 *
 * @author Andre
 */
public interface LogicInterface {
    void initializeGame(int height, int width, OpponentInterface opponent);
    void setLine(Point startPoint, Point endPoint);
}
