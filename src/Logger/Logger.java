package Logger;

import Enums.MessageTypeEnum;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Daniel
 */
public class Logger{    
    /**
     * logs an exception to file 'DotsAndBoxes.log' .
     * 
     * @param type
     * @param ex 
     */
    public static void logToFile(MessageTypeEnum type, Exception ex){
        try{
            File file = new File("DotsAndBoxes.log");
            FileOutputStream output = new FileOutputStream(file);
            
            printMessage(type, ex, output);
        } catch (FileNotFoundException fne){
            System.err.println("ERROR while opening logfile");
        }
    }
    
    public static void logToConsole(MessageTypeEnum type, String msg){
        Exception ex = new Exception(msg);
        
        printMessage(type, ex, System.out);
    }
    
    /**
     * logs an exception to 
     * @param type
     * @param ex 
     */
    public static void logToConsole(MessageTypeEnum type, Exception ex){
        printMessage(type, ex, System.out);
    }
    
    /**
     * handles the file IO Streams.
     * opens a FileWriter from a new File object targeting the file called
     * 'DotsAndBoxes.log'
     * 
     * @param type
     * @param ex 
     * @param output
     */
    private static void printMessage(MessageTypeEnum type, Exception ex, OutputStream output){
        PrintWriter logger = new PrintWriter(output);

        logger.write(getMessageByType(type) + ": " + ex.getClass() + " - " + ex.getMessage());
        logger.write(System.getProperty("line.separator"));
        if(type == MessageTypeEnum.Debug){
            logger.write("" + ex.getStackTrace());
        }
        logger.flush();
        logger.close();
    }
    
    /**
     * returns a string corresponding to the given MessagTypeEnum.
     * 
     * 
     * @param type
     * @return 
     */
    private static String getMessageByType(MessageTypeEnum type){
        switch(type){
            case Error:
                return "ERROR";
            case Information:
                return "INFORMATION";
            case Warning:
                return "WARNING";
            case Debug:
                return "DEBUG";
            default:
                return "";
        }
    }
}
