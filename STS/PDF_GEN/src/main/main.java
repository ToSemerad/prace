/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import loader.Loader;
import logger.Logger;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;


/**
 *
 * @author TPV
 */
public class main {

    private static Loader loader;
    private static Logger logger;

    public static void main(String[] args) {
        try {
            //JOptionPane.showMessageDialog(null, "Začátek aplikace !!");
            
            Ini cfg = new Ini(new File("config.ini"));
            Preferences p = new IniPreferences(cfg);
            String fileNameOut;
            
            //JOptionPane.showMessageDialog(null, "Začátek inicializace CFG!!");
            
            logger = new Logger(p.node("Settings").get("log_file", ""));
            if (args.length != 1) {
                fileNameOut = "Output";
            } else {            
                fileNameOut = args[0];
            }
            //JOptionPane.showMessageDialog(null, "Inicializován log!!");
            
            loader = new Loader(p.node("Settings").get("input_directory", ""), logger, p.node("Settings").get("output_directory", ""), fileNameOut, p.node("Settings").get("ghost_script", ""));
            
            //JOptionPane.showMessageDialog(null, "Načteno - zpracováno!!");
            
            logger.writeToFile();
            
            //JOptionPane.showMessageDialog(null, "Zapsán log!!");
        } catch (Exception ex) {
            logger = new Logger("log.txt");
            logger.addLine("Nespecifikovaná chyba: " + ex.getMessage());
            StackTraceElement[] els = ex.getStackTrace();
            for (StackTraceElement el : els) {
                logger.addLine(el.toString());
            }
            logger.writeToFile();
        }
    }

}
