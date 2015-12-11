
import GameObjects.SaveGame;
import ArtificialIntelligence.AIController;
import Enums.GameModeEnum;
import Enums.MessageTypeEnum;
import FactorySet.OpponentFactory;
import GameObjects.Line;
import GameObjects.Map;
import GameObjects.Point;
import GameObjects.Square;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interfaces.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class GameController implements ObserverInterface {
    private GameViewInterface gameView;
    private GameOptionsViewInterface gameOptionsView;
    private LogicInterface gameLogic;
    
    public GameController(GameOptionsViewInterface gameOptionsView, GameViewInterface gameView, LogicInterface gameLogic){
        this.gameView = gameView;
        this.gameLogic = gameLogic;
        this.gameOptionsView = gameOptionsView;
    }
    
    public void startControlling(){
        ((SubjectInterface)gameOptionsView).registerObserver(this);
        ((SubjectInterface)gameView).registerObserver(this);
        ((SubjectInterface)gameLogic).registerObserver(this);

        gameOptionsView.startOptionsView();
    }
  
    private void startGamePreparation() {
        OpponentFactory factory = new OpponentFactory();
        GameModeEnum gameMode = GameModeEnum.AIMode;
        int mapHeight = gameOptionsView.getFieldHeight();
        int mapWidth = gameOptionsView.getFieldWidth();
        
        // damit default immer AI-Mode ist!!
        if(gameOptionsView.getGameMode() != null)
        {
            gameMode= gameOptionsView.getGameMode();
        }
        
        Map map = new Map(mapHeight, mapWidth);
        
        
        // via Factory erstellen, da ich als Controller den konkretten Opponent nicht kennen will!!
        //@TODO set parameter list correct!
        OpponentInterface opponent =  factory.createOpponent(gameMode,map,0,"");
        
        // damit Controller zu den Spielzügen informiert wird!!
        ((SubjectInterface)opponent).registerObserver(this);
        

        
        // Logic & View initiieren!!        
        //gameLogic.initializeGame(mapHeight, mapWidth, opponent);
        
        gameLogic.initializeGame(map, opponent);
        
        if(gameMode == GameModeEnum.MultiplayerServerMode)
        {
            gameLogic.setStartTurn(true);
        }
        
        gameView.startGameView(mapWidth, mapHeight);
        
    }

    @Override
    public void makeMove(Line selectedLine, boolean isOpponent) {
        //DO SOMETHING
        boolean validMove = gameLogic.isValidLine(selectedLine);
        
        if(validMove){
            gameLogic.setLine(selectedLine, isOpponent);
            gameView.drawLine(selectedLine, isOpponent);
        }
        
        // todo verbessern
        this.gameView.updatePlayerState(gameLogic.getPlayerState());
        this.gameView.updateOpponentState(gameLogic.getOpponentState());

    }

    @Override
    public void submitOptions() {
        startGamePreparation();
    }

    @Override
    public void saveGame(String saveFileDirectory) {
        //Check Filepath
        SaveGame saveGame = new SaveGame(gameLogic.getMap(), gameLogic.getLocalFigur(), gameLogic.getOpponentFigure(), gameLogic.IsOpponentContinuing());             
        
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(saveFileDirectory))){
            objectOutputStream.writeObject(saveGame);
            objectOutputStream.flush();
            objectOutputStream.close();
            
            gameView.showMessage("Der Spielstand wurde erfolgreich gespeichert.", MessageTypeEnum.Information);

        }catch(Exception e)
        {
            gameView.showMessage("Der Spielstand konnte nicht gespeichert werden. Bitte wenden Sie sich an den Administator.", MessageTypeEnum.Error);
        }
    }

    @Override
    public void openGame(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
            
            SaveGame saveGame = (SaveGame) objectInputStream.readObject();

            gameView.startGameView(saveGame.getMap().getWidth(),saveGame.getMap().getHeight());
            
            drawMap(saveGame.getMap());
            gameView.updateOpponentState(saveGame.getOpponent().getPoints());
            gameView.updatePlayerState(saveGame.getPlayer().getPoints());

            gameLogic.loadGame(saveGame);
            objectInputStream.close();
            
            gameView.showMessage("Der Spielstand wurde erfolgreich geladen.", MessageTypeEnum.Information);

        }catch(Exception e){
            gameView.showMessage("Der Spielstand konnte nicht geladen werden. Bitte wenden Sie sich an den Administator.", MessageTypeEnum.Error);
        }
    }
    
    private void drawMap(Map map)
    {
        if(map != null){
            map.getLines().stream().filter(l -> l.getOwner() != null).forEach(l -> gameView.drawLine(l,l.getOwner().isOpponent()));
        }
    }

    @Override
    public void setPlayerTurn(boolean isOpponent) {
       gameView.updatePlayerTurn(isOpponent);
    }

    @Override
    public void gameEnds() {
        gameView.showMessage("Spiel isch fertig, alter", MessageTypeEnum.End);
    }

    @Override
    public void setOwnedSquare(int x1, int y1, boolean isOpponent) {
        gameView.drawSquare(x1, y1, isOpponent);
    }
}
