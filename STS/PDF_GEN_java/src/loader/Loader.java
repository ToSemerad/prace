/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import logger.Logger;
import model.Operation;
import model.Part;
import model.PrintAssembly;

/**
 *
 * @author TPV
 */
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
            File dir = new File(directory);
            files = Arrays.asList(dir.listFiles());
            
            pa1 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_1.pdf");
            pa2 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_2.pdf");
            pa3 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_3.pdf");
            pa4 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_4.pdf");
            pa5 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_5.pdf");
            pa6 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_6.pdf");
            pa7 = new PrintAssembly(outputDirectory + "\\" + outputFileName + "_7.pdf");
            
            for (File f : files) {
                if (f.getName().endsWith(".tpv")) {
                    BufferedReader br = null;
                    String line = "";
                    try {                        
                        br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
                        logger.addLine("INF: Reading file " + f.getPath());
                        boolean cOrder = false, cQuantity = false, cPosition = false, cDrawing = false, cPartNumber = false, cCreator = false, cDate = false, cAssembly = false, cPart = false;
                        
                        String orderNumber = "";
                        float quantity = 0;
                        String sPosition = "";
                        int position = 0;
                        float percentTop = 0;
                        float percentLeft = 0;
                        String drawing = "";
                        String partNumber = "";
                        String assembly = "";
                        String operNumber = "";
                        String workplace = "";
                        String description = "";
                        String creator = "";
                        String date = "";
                        float tac = 0;
                        float tbc = 0;
                        List<Operation> operations = new ArrayList<>();
                        
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("Z")) {
                                orderNumber = line.split("#")[1];
                                if (!orderNumber.equals("")) {
                                    cOrder = true;
                                }
                            }
                            
                            if (line.startsWith("K")) {
                                quantity = Float.valueOf(line.split("#")[1]);
                                if (quantity > 0) {
                                    cQuantity = true;
                                }
                            }
                            
                            if (line.startsWith("U")) {
                                position = 0;
                                sPosition = line.split("#")[1];
                                if (sPosition.equals("LH_Roh")) {
                                    position = Part.LEFT_TOP_CORNER;
                                } else if (sPosition.equals("H_Stred")) {
                                    position = Part.CENTER_TOP;
                                } else if (sPosition.equals("RH_Roh")) {
                                    position = Part.RIGHT_TOP_CORNER;
                                } else if (sPosition.equals("L_Stred")) {
                                    position = Part.LEFT_CENTER;
                                } else if (sPosition.equals("R_Stred")) {
                                    position = Part.RIGHT_CENTER;
                                } else if (sPosition.equals("LD_Roh")) {
                                    position = Part.LEFT_BOTTOM_CORNER;
                                } else if (sPosition.equals("D_Stred")) {
                                    position = Part.CENTER_BOTTOM;
                                } else if (sPosition.equals("RD_Roh")) {
                                    position = Part.RIGHT_BOTTOM_CORNER;
                                } else if (sPosition.startsWith("P")) {
                                    position = Part.CUSTOM;
                                    
                                    sPosition = sPosition.replace("P", "");
                                    // Souradnice (procenta)
                                    String[] vals = sPosition.split("x");
                                    percentTop = Float.valueOf(vals[0]);
                                    percentLeft = Float.valueOf(vals[1]);
                                } else {
                                    position = Part.LEFT_TOP_CORNER;
                                }
                                
                                if (position > 0) {
                                    cPosition = true;
                                }
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
                            
                            if (line.startsWith("TS")) {
                                assembly = line.split("#")[1];
                                cAssembly = true;
                            }
                            
                            // Vsechny udaje k zalozeni dilu jsou dostupne
                            if (line.startsWith("TO")) {
                                String[] vals = line.split("#");
                                
                                operNumber = vals[1];
                                workplace = vals[2];
                                description = vals[3];
                                tbc = Float.valueOf(vals[4]);
                                tac = Float.valueOf(vals[5]);
                                
                                operations.add(new Operation(operNumber, workplace, tac, tbc, description));
                            }
                        }
                        
                        Part part = new Part(percentTop, percentLeft, orderNumber, quantity, drawing, partNumber, creator, date, position, assembly, f, ghostScriptPath);
                        
                        for (Operation o : operations) {
                            part.addOperation(o);
                        }
                        
                        part.loadDrawing();
                        
                        if (part.isPrinted(0)) {
                            pa1.addPart(part);
                        }
                        if (part.isPrinted(1)) {
                            pa2.addPart(part);
                        }
                        if (part.isPrinted(2)) {
                            pa3.addPart(part);
                        }
                        if (part.isPrinted(3)) {
                            pa4.addPart(part);
                        }
                        if (part.isPrinted(4)) {
                            pa5.addPart(part);
                        }
                        if (part.isPrinted(5)) {
                            pa6.addPart(part);
                        }
                        if (part.isPrinted(6)) {
                            pa7.addPart(part);
                        }
                        
                    } catch (FileNotFoundException ex) {
                        logger.addLine("ERR: Cannot open: " + f.getPath() + " / " + ex.getMessage());
                    } catch (IOException ex) {
                        logger.addLine("ERR: Cannot read: " + f.getPath() + " / " + ex.getMessage());
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        logger.addLine("ERR: Incorrect file syntax near: " + line + " / " + f.getName() + " / " + ex.getMessage());
                    } catch (NumberFormatException ex) {
                        logger.addLine("ERR: Cannot convert value to number: " + line + " / " + f.getName() + " / " + ex.getMessage());
                    } catch (ClassCastException ex) {
                        logger.addLine("ERR: Cannot convert value to number: " + line + " / " + f.getName() + " / " + ex.getMessage());
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            br.close();
                        } catch (IOException ex) {
                            logger.addLine("ERR: Unspecified: " + f.getPath() + " / " + ex.getMessage());
                        }
                    }
                }
            }
            
            pa1.save();
            pa2.save();
            pa3.save();
            pa4.save();
            pa5.save();
            pa6.save();
            pa7.save();
            
            /*
            System.out.println(pa1.toString());
            System.out.println(pa2.toString());
            System.out.println(pa3.toString());
            System.out.println(pa4.toString());
            System.out.println(pa5.toString());
            System.out.println(pa6.toString());
            System.out.println(pa7.toString());
            */
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.addLine("ERR: Cannot save document");
        }
    }

}
