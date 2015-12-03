/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import GameObjects.Map;
import GameObjects.Point;
import java.awt.Color;

/**
 *
 * @author Andre
 */
public interface GameViewInterface {
    void startGameView(int width, int height);
    void startOptionView();
    
    void drawLine(int startX, int startY, int endX, int endY, boolean isOpponent);
    
    void updatePlayerState(int points);
    void updateOpponentState(int points);

    void showMessage(String message, MessageTypeEnum messageType);
}
