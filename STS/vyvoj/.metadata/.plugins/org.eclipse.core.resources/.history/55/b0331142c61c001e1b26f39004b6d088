package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
  private String logString;
  
  private final String logPath;
  
  public Logger(String logPath) {
    this.logPath = logPath;
    this.logString = "";
  }
  
  public Logger() {
    this.logPath = "log.txt";
    this.logString = "";
  }
  
  public void addLine(String line) {
    this.logString = String.valueOf(this.logString) + line + "\n";
  }
  
  public void writeToFile() {
    FileWriter fw = null;
    try {
      File f = new File(this.logPath);
      fw = new FileWriter(f);
      fw.write(this.logString);
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
