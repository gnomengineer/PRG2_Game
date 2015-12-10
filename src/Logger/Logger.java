package Logger;

import Enums.MessageTypeEnum;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class Logger{    
    /**
     * logs an exception to .
     * 
     * @param type
     * @param ex 
     */
    public static void log(MessageTypeEnum type, Exception ex){
        switch(type){
            case Error:
                printMessage("ERROR", ex);
                break;
            case Information:
                printMessage("INFORMATION", ex);
                break;
            case Warning:
                printMessage("WARNING", ex);
                break;
            default:
                break;
        }
    }
    
    private static void printMessage(String type, Exception ex){
        try(FileWriter logfile = new FileWriter(new File("DotsAndBoxes.log"))){
            logfile.write(type + ": " + ex.getClass() + " - " + ex.getMessage());
            logfile.write(System.getProperty("line.separator"));
            logfile.flush();
            logfile.close();
        } catch (IOException ioe){
            System.err.println("ERROR: log file error - " + ioe.getMessage());
        }
    }
}
