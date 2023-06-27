/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author TPV
 */
public class Logger {
    
    private String logString;
    private final String logPath;
    
    public Logger(String logPath) {
        this.logPath = logPath;
        this.logString = "";
    }
    
    public void addLine(String line) {
        this.logString += line + "\n";
    }
    
    public void writeToFile() {
        FileWriter fw = null;
        try {
            File f = new File(logPath);
            fw = new FileWriter(f);
            fw.write(logString);
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}
