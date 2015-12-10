
import GameObjects.SaveGame;
import ArtificialIntelligence.AIController;
import Enums.GameModeEnum;
import FactorySet.OpponentFactory;
import GameObjects.Line;
import GameObjects.Map;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interfaces.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public void saveOptions() {
        //Setup SaveGame
        SaveGame saveGame = new SaveGame();
        
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("javaObjects.txt"))){
            objectOutputStream.writeObject(saveGame);
            objectOutputStream.flush();
            objectOutputStream.close();

        }catch(Exception e)
        {
            
        }
    }

    @Override
    public void openOptions(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("javaObjects.txt"))){
            SaveGame saveGame = (SaveGame) objectInputStream.readObject();
            drawMap(saveGame.getMap());
            gameView.updateOpponentState(saveGame.getOpponent().getPoints());
            gameView.updatePlayerState(saveGame.getPlayer().getPoints());

            gameLogic.loadGame(saveGame);
            
            objectInputStream.close();
        }catch(Exception e){
            
        }
    }
    
    private void drawMap(Map map)
    {
        if(map != null){
            map.getLines().forEach(l -> gameView.drawLine(l,l.getOwner().isOpponent()));
        }
    }
}
