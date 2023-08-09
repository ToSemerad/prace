package main;

import java.io.File;
import loader.Loader;
import logger.Logger;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;

public class main {
  private static Loader loader;
  
  private static Logger logger;
  
  public static void main(String[] args) {
    try {
      String fileNameOut;
      Ini cfg = new Ini(new File("config.ini"));
      IniPreferences iniPreferences = new IniPreferences(cfg);
      logger = new Logger(iniPreferences.node("Settings").get("log_file", ""));
      if (args.length != 1) {
        fileNameOut = "Output";
      } else {
        fileNameOut = args[0];
      } 
      loader = new Loader(iniPreferences.node("Settings").get("input_directory", ""), logger, iniPreferences.node("Settings").get("output_directory", ""), fileNameOut, iniPreferences.node("Settings").get("ghost_script", ""));
      logger.writeToFile();
    } catch (Exception ex) {
      logger = new Logger("log.txt");
      logger.addLine("Nespecifikovanchyba: " + ex.getMessage());
      StackTraceElement[] els = ex.getStackTrace();
      byte b;
      int i;
      StackTraceElement[] arrayOfStackTraceElement1;
      for (i = (arrayOfStackTraceElement1 = els).length, b = 0; b < i; ) {
        StackTraceElement el = arrayOfStackTraceElement1[b];
        logger.addLine(el.toString());
        b++;
      } 
      logger.writeToFile();
    } 
  }
}
