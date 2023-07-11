package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
//import java.util.logging.Logger;
import logger.Logger;
import model.Operation;
import model.Part;
import model.PrintAssembly;
import org.apache.pdfbox.pdmodel.PDDocument;

public class Loader {
  private final String directory;
  
  private final String outputDirectory;
  
  private final String outputFileName;
  
  private final String ghostScriptPath;
  
  private final Logger logger;
  
  private final List<PrintAssembly> prints;
  
  private PrintAssembly pa1;
  
  private PrintAssembly pa2;
  
  private PrintAssembly pa3;
  
  private PrintAssembly pa4;
  
  private PrintAssembly pa5;
  
  private PrintAssembly pa6;
  
  private PrintAssembly pa7;
  
  private PrintAssembly pa8;
  
  public Loader(String directory, Logger logger, String outputDirectory, String outputFileName, String ghostScriptPath) {
    this.directory = directory;
    this.prints = new ArrayList<>();
    this.logger = logger;
    this.outputDirectory = outputDirectory;
    this.outputFileName = outputFileName;
    this.ghostScriptPath = ghostScriptPath;
    initialize();
  }
  
  private void initialize() {
    try {
      List<File> files = new ArrayList<>();
      File dir = new File(this.directory);
      files = Arrays.asList(dir.listFiles());
      this.pa1 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + ".pdf");
      this.pa2 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-Info.pdf");
      this.pa3 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-Kooperace.pdf");
      this.pa4 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-Sestavy.pdf");
      this.pa5 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-Laser.pdf");
      this.pa6 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-Deleni.pdf");
      this.pa7 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-Kook2.pdf");
      this.pa8 = new PrintAssembly(String.valueOf(this.outputDirectory) + "\\" + this.outputFileName + "-OstatniKopie2.pdf");
      for (File f : files) {
        if (f.getName().endsWith(".tpv")) {
          BufferedReader br = null;
          String line = "";
          try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            this.logger.addLine("INF: Reading file " + f.getPath());
            boolean cOrder = false, cQuantity = false, cPosition = false, cDrawing = false, cPartNumber = false, cCreator = false, cDate = false, cAssembly = false, cPart = false;
            boolean is_vydat_sklad = false;
            String orderNumber = "";
            int quantity = 0;
            String sPosition = "";
            int position = 0;
            float percentTop = 0.0F;
            float percentLeft = 0.0F;
            String drawing = "";
            String partNumber = "";
            String vrchol = "";
            String pozice = "";
            String assembly = "";
            String operNumber = "";
            String workplace = "";
            String description = "";
            String creator = "";
            String date = "";
            float tac = 0.0F;
            float tbc = 0.0F;
            List<Operation> operations = new ArrayList<>();
            while ((line = br.readLine()) != null) {
              if (line.startsWith("Z")) {
                orderNumber = line.split("#")[1];
                if (!orderNumber.equals(""))
                  cOrder = true; 
              } 
              if (line.startsWith("K")) {
                quantity = Integer.parseInt(line.split("#")[1]);
                if (quantity > 0)
                  cQuantity = true; 
              } 
              if (line.startsWith("U")) {
                position = 0;
                sPosition = line.split("#")[1];
                if (sPosition.equals("LH_Roh")) {
                  position = 1;
                } else if (sPosition.equals("H_Stred")) {
                  position = 2;
                } else if (sPosition.equals("PH_Roh")) {
                  position = 3;
                } else if (sPosition.equals("L_Stred")) {
                  position = 4;
                } else if (sPosition.equals("P_Stred")) {
                  position = 5;
                } else if (sPosition.equals("LD_Roh")) {
                  position = 6;
                } else if (sPosition.equals("D_Stred")) {
                  position = 7;
                } else if (sPosition.equals("PD_Roh")) {
                  position = 8;
                } else if (sPosition.equals("Stred")) {
                  position = 10;
                } else if (sPosition.startsWith("P")) {
                  position = 9;
                  if (sPosition.contains("x")) {
                    sPosition = sPosition.replace("P", "");
                    String[] vals = sPosition.split("x");
                    percentLeft = Float.valueOf(vals[0]).floatValue();
                    percentTop = Float.valueOf(vals[1]).floatValue();
                  } else {
                    position = 3;
                  } 
                } else {
                  position = 1;
                } 
                if (position > 0)
                  cPosition = true; 
              } 
              if (line.startsWith("I")) {
                drawing = line.split("#")[1];
                cDrawing = true;
              } 
              if (line.startsWith("P")) {
                partNumber = line.split("#")[2];
                creator = line.split("#")[4];
                date = line.split("#")[5];
                cPart = true;
              } 
              if (line.startsWith("N"))
                pozice = line.split("#")[1]; 
              if (line.startsWith("O") && 
                line.split("#")[1].contains("ANO"))
                is_vydat_sklad = true; 
              if (line.startsWith("TS")) {
                assembly = line.split("#")[1];
                cAssembly = true;
              } 
              if (line.startsWith("TO")) {
                String[] vals = line.split("#");
                operNumber = vals[1];
                workplace = vals[2];
                description = vals[3];
                tbc = Float.valueOf(vals[4]).floatValue();
                tac = Float.valueOf(vals[5]).floatValue();
                operations.add(new Operation(operNumber, workplace, tac, tbc, description));
              } 
            } 
            this.logger.addLine("INF: Souradnice tisku " + percentTop + percentLeft + " pozice " + position);
            File partFile = new File(drawing);
            PDDocument vykresOrigDoc = PDDocument.load(partFile);
            int num_pages = vykresOrigDoc.getDocumentCatalog().getPages().getCount();
            for (int i = 0; i < (num_pages + 1) / 2; i++) {
              Part part = new Part(percentTop, percentLeft, orderNumber, quantity, drawing, partNumber, creator, date, position, assembly, f, this.ghostScriptPath, vrchol, i * 2, is_vydat_sklad, pozice);
              int index_op = 0;
              int pocet_radku = 8;
              for (Operation o : operations) {
                part.addOperation(o);
                if (index_op > pocet_radku)
                  break; 
                index_op++;
                if (o.getWorkplace().length() >= 110)
                  pocet_radku--; 
              } 
              part.loadDrawing();
              if (part.isPrinted(0))
                this.pa1.addPart(part); 
              if (part.isPrinted(1))
                this.pa2.addPart(part); 
              if (part.isPrinted(2))
                this.pa3.addPart(part); 
              if (part.isPrinted(3))
                this.pa4.addPart(part); 
              if (part.isPrinted(4))
                this.pa5.addPart(part); 
              if (part.isPrinted(5))
                this.pa6.addPart(part); 
              if (part.isPrinted(6))
                this.pa7.addPart(part); 
              if (part.isPrinted(7))
                this.pa8.addPart(part); 
              for (int remove_index = 0; remove_index < index_op; remove_index++)
                operations.remove(0); 
              if (i < num_pages / 2 && num_pages != 1 && operations.size() > 1)
                operations.remove(0); 
            } 
          } catch (FileNotFoundException ex) {
            this.logger.addLine("ERR: Cannot open: " + f.getPath() + " / " + ex.getMessage());
            continue;
          } catch (IOException ex) {
            this.logger.addLine("ERR: Cannot read: " + f.getPath() + " / " + ex.getMessage());
            continue;
          } catch (ArrayIndexOutOfBoundsException ex) {
            this.logger.addLine("ERR: Incorrect file syntax near: " + line + " / " + f.getName() + " / " + ex.getMessage());
            continue;
          } catch (NumberFormatException ex) {
            this.logger.addLine("ERR: Cannot convert value to number: " + line + " / " + f.getName() + " / " + ex.getMessage());
            continue;
          } catch (ClassCastException ex) {
            this.logger.addLine("ERR: Cannot convert value to number: " + line + " / " + f.getName() + " / " + ex.getMessage());
            continue;
          } catch (InterruptedException ex) {
        	   this.logger.addLine("ERR: Cannot convert value to number: " + line + " / " + f.getName() + " / " + ex.getMessage());
            continue;
          } catch (Exception e) {
            this.logger.addLine("ERR: Nastala chyba: " + line + " / " + f.getName() + " / " + e.getMessage());
            continue;
          } finally {
            try {
              br.close();
            } catch (IOException ex) {
              this.logger.addLine("ERR: Unspecified: " + f.getPath() + " / " + ex.getMessage());
            } 
          } 
        } 
      } 
      this.pa1.save();
      this.pa2.save();
      this.pa3.save();
      this.pa4.save();
      this.pa5.save();
      this.pa6.save();
      this.pa7.save();
      this.pa8.save();
    } catch (IOException ex) {
      ex.printStackTrace();
      this.logger.addLine("ERR: Cannot save document");
    } 
  }
}
