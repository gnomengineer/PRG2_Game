package Interfaces;

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
