/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.ghost4j.Ghostscript;
import org.ghost4j.GhostscriptException;
import org.ghost4j.document.PDFDocument;

/**
 *
 * @author TPV
 */
public class Part {

    public static final int LEFT_TOP_CORNER = 1;
    public static final int CENTER_TOP = 2;
    public static final int RIGHT_TOP_CORNER = 3;
    public static final int LEFT_CENTER = 4;
    public static final int RIGHT_CENTER = 5;
    public static final int LEFT_BOTTOM_CORNER = 6;
    public static final int CENTER_BOTTOM = 7;
    public static final int RIGHT_BOTTOM_CORNER = 8;
    public static final int CUSTOM = 9;

    public static final int A4 = 1;
    public static final int A3 = 2;
    public static final int A2 = 3;
    public static final int A1 = 4;
    public static final int A0 = 5;

    private final float percentTop;
    private final float percentLeft;
    private final String orderNumber;
    private final float quantity;
    private final String drawing;
    private final String partNumber;
    private final String creeator;
    private final String date;
    private final String assemblies;
    private final String ghostScriptPath;
    private final int position;
    private final File filePath;

    private final List<Operation> operations;

    private PDDocument vykresOrigDoc;
    private PDDocument vykresNewDoc;
    private PDPage vykresOrig;
    private PDPage vykresNew;
    private float pageWidth;
    private float pageHeight;
    private int pageWidthMM;
    private int pageHeightMM;
    private int rotation;
    private int format;

    private PDDocument postupVzor;
    private PDPage postupPageVzor;
    private PDPage postupPageCopy;

    public Part(float percentTop, float percentLeft, String orderNumber, float quantity, String drawing, String partNumber, String creeator, String date, int position, String assemblies, File filePath, String ghostScriptPath) {
        this.percentTop = percentTop;
        this.percentLeft = percentLeft;
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.drawing = drawing;
        this.partNumber = partNumber;
        this.creeator = creeator;
        this.date = date;
        this.position = position;
        this.operations = new ArrayList<>();
        this.assemblies = assemblies;
        this.filePath = filePath;
        this.ghostScriptPath = ghostScriptPath;
    }

    public boolean isPrinted(int i) {
        return (assemblies.charAt(i) == '1');
    }

    public void loadDrawing() throws IOException, InterruptedException {
        File f = new File(drawing);
        if (!f.exists()) {
            throw new FileNotFoundException(f.getAbsolutePath());
        }
        /*
         Runtime rt = Runtime.getRuntime();
         //Process pr = rt.exec("cmd /c dir");
         Process pr = rt.exec("\"C:\\Program Files (x86)\\gs\\gs9.22\\bin\\gswin32c\" -o E:\\Instalace\\PDF\\INPUT\\Resized\\" + f.getName() + " -sDEVICE=pdfwrite -sPAPERSIZE=a4 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 " + f.getAbsolutePath());

         BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

         String line = null;

         while ((line = input.readLine()) != null) {
         System.out.println(line);
         }

         int exitVal = pr.waitFor();
         System.out.println("Exited with error code " + exitVal);
         */
        /*
         Ghostscript gs = Ghostscript.getInstance();
         String[] gsArgs = new String[7];
         gsArgs[0] = "-o E:\\Instalace\\PDF\\INPUT\\Resized\\" + f.getName();
         gsArgs[1] = "-sDEVICE=pdfwrite";
         gsArgs[2] = "-sPAPERSIZE=a4";
         gsArgs[3] = "-dFIXEDMEDIA";
         gsArgs[4] = "-dPDFFitPage";
         gsArgs[5] = "-dCompatibilityLevel=1.4";        
         gsArgs[6] = f.getAbsolutePath();
        
         System.out.println("Resizing... " + f.getName());
        
         try { 
         gs.initialize(gsArgs);
         gs.runFile(f.getAbsolutePath());
         gs.exit();
         } catch (GhostscriptException ex) {
         ex.printStackTrace();
         }
         */
        vykresOrigDoc = PDDocument.load(f);
        vykresOrig = vykresOrigDoc.getDocumentCatalog().getPages().get(0);

        pageWidth = vykresOrig.getMediaBox().getWidth();
        pageHeight = vykresOrig.getMediaBox().getHeight();

        pageWidthMM = (int) Math.round(pageWidth * (float) 25.4 / (float) 72.0);
        pageHeightMM = (int) Math.round(pageHeight * (float) 25.4 / (float) 72.0);

        rotation = vykresOrig.getRotation();

        if (pageWidthMM == 210 && pageHeightMM == 297) {
            format = Part.A4;
        } else if (pageWidthMM == 297 && pageHeightMM == 210) {
            format = Part.A4;
        } else if (pageWidthMM == 420 && pageHeightMM == 297) {
            format = Part.A3;
        } else if (pageWidthMM == 297 && pageHeightMM == 420) {
            format = Part.A3;
        } else if (pageWidthMM == 594 && pageHeightMM == 420) {
            format = Part.A2;
        } else if (pageWidthMM == 420 && pageHeightMM == 594) {
            format = Part.A2;
        } else if (pageWidthMM == 841 && pageHeightMM == 594) {
            format = Part.A1;
        } else if (pageWidthMM == 594 && pageHeightMM == 841) {
            format = Part.A1;
        } else if (pageWidthMM == 1189 && pageHeightMM == 841) {
            format = Part.A0;
        } else if (pageWidthMM == 841 && pageHeightMM == 1189) {
            format = Part.A0;
        } else {
            format = Part.A0;
        }

        vykresOrigDoc.close();

        System.out.println(f.getName() + ": " + pageWidthMM + " x " + pageHeightMM + "; Rotation: " + rotation + "; Format: " + format);

        if (format == Part.A0 || format == Part.A1 || format == Part.A2) {
            Runtime rt = Runtime.getRuntime();
            File newFile = new File(f.getParent() + "\\" + f.getName().substring(0, f.getName().indexOf(".")) + "_r.pdf");
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec("\"" + ghostScriptPath + "\" -o " + newFile.getAbsolutePath() + " -sDEVICE=pdfwrite -sPAPERSIZE=a3 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 " + f.getAbsolutePath());
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);

            vykresOrigDoc = PDDocument.load(newFile);
            
            pageWidth = vykresOrig.getMediaBox().getWidth();
            pageHeight = vykresOrig.getMediaBox().getHeight();

            pageWidthMM = (int) Math.round(pageWidth * (float) 25.4 / (float) 72.0);
            pageHeightMM = (int) Math.round(pageHeight * (float) 25.4 / (float) 72.0);
            
            format = Part.A3;
        } else {
            vykresOrigDoc = PDDocument.load(f);
        }

        vykresOrig = vykresOrigDoc.getDocumentCatalog().getPages().get(0);

        COSDictionary dicOrig = vykresOrig.getCOSObject();
        COSDictionary dicNew = new COSDictionary(dicOrig);
        dicNew.removeItem(COSName.ANNOTS);

        vykresNew = new PDPage(dicNew);
        vykresNewDoc = new PDDocument();

        // Vykres
        PDPageContentStream csInput = new PDPageContentStream(vykresNewDoc, vykresNew, true, false, true);
        //csInput.setNonStrokingColor(Color.white);
        //csInput.addRect(0, pageHeight - 20, 500, 20);
        //csInput.fill();
        
        int xText;
        int yText;
        int pageOffsetX;
        int pageOffsetY;
        
        switch (format) {
            case A4:
                pageOffsetX = 35;
                pageOffsetY = 45;
                break;
            case A3:
                pageOffsetX = 50;
                pageOffsetY = 60;
                break;
            default:
                pageOffsetX = 35;
                pageOffsetY = 45;
                break;
        }
        
        
        switch (position) {
            case LEFT_TOP_CORNER:
                xText = pageOffsetX;
                yText = (int) pageHeight - pageOffsetY;
                break;
            case LEFT_CENTER:
                xText = pageOffsetX;
                yText = (int) pageHeight / 2;
                break;
            case LEFT_BOTTOM_CORNER:
                xText = pageOffsetX;
                yText = pageOffsetY;
                break;
            case CENTER_TOP:
                xText = (int) pageWidth / 2;
                yText = (int) pageHeight - pageOffsetY;
                break;
            case CENTER_BOTTOM:
                xText = (int) pageWidth / 2;
                yText = pageOffsetY;
                break;
            case RIGHT_TOP_CORNER:
                xText = (int) pageWidth - (pageOffsetX + 200);
                yText = (int) pageHeight - pageOffsetY;
                break;
            case RIGHT_CENTER:
                xText = (int) pageWidth - (pageOffsetX + 200);
                yText = (int) pageHeight / 2;
                break;
            case RIGHT_BOTTOM_CORNER:
                xText = (int) pageWidth - (pageOffsetX + 200);
                yText = pageOffsetY;
                break;
            case CUSTOM:
                xText = (int) ((percentLeft / 100.0) * pageWidth);
                yText = (int) (pageHeight - ((percentTop / 100.0) * pageHeight));
                break;
            default:
                xText = pageOffsetX;
                yText = (int) pageHeight - pageOffsetY;
                break;
        }

        csInput.beginText();
        csInput.newLineAtOffset(xText, yText);
        //csInput.setFont(PDType1Font.COURIER, 20);
        PDFont fnt = PDType0Font.load(vykresNewDoc, new FileInputStream("c:/windows/fonts/ARIALUNI.ttf"));
        
        csInput.setFont(fnt, 14);
        csInput.setStrokingColor(Color.red);
        csInput.setNonStrokingColor(Color.red);
        csInput.showText(orderNumber + " / " + quantity + " ks");
        csInput.setStrokingColor(Color.black);
        csInput.setNonStrokingColor(Color.black);
        csInput.endText();
        csInput.close();

        vykresNewDoc.addPage(vykresNew);

        if (format == Part.A4) {
            postupVzor = PDDocument.load(new File(filePath.getParent() + "\\pa4.pdf"));
        } else {
            postupVzor = PDDocument.load(new File(filePath.getParent() + "\\pa3.pdf"));
        }

        postupPageVzor = postupVzor.getPage(0);
        COSDictionary dicVzor = postupPageVzor.getCOSObject();
        COSDictionary dicCopy = new COSDictionary(dicVzor);
        dicCopy.removeItem(COSName.ANNOTS);
        postupPageCopy = new PDPage(dicCopy);

        if (format == Part.A4) {
            PDPageContentStream cpA4 = new PDPageContentStream(vykresNewDoc, postupPageCopy, true, false, true);

            cpA4.beginText();
            //cpA4.setFont(PDType1Font.COURIER_BOLD, 12);
            //PDFont fnt = PDType0Font.load(vykresNewDoc, new FileInputStream("c:/windows/fonts/Arial Unicode MS Normální.ttf"));
            cpA4.setFont(fnt, 12);
            cpA4.newLineAtOffset(340, 470);
            cpA4.showText(orderNumber);
            cpA4.newLineAtOffset(0, -20);
            cpA4.showText(String.valueOf(quantity));
            cpA4.newLineAtOffset(0, -25);
            cpA4.showText(partNumber);
            cpA4.newLineAtOffset(270, -5);
            cpA4.showText(date);
            cpA4.newLineAtOffset(0, 17);
            cpA4.showText(creeator);
            cpA4.newLineAtOffset(-525, -75);
            for (Operation o : operations) {
                cpA4.setFont(fnt, 10);
                cpA4.showText(String.valueOf(o.getNumber()));
                cpA4.newLineAtOffset(35, 0);
                cpA4.showText(o.getDescription());
                cpA4.newLineAtOffset(140, 0);
                cpA4.showText(o.getWorkplace());
                cpA4.setFont(fnt, 8);
                cpA4.newLineAtOffset(57, 0);
                cpA4.showText(String.valueOf(o.getTbc()));
                cpA4.newLineAtOffset(37, 0);
                cpA4.showText(String.valueOf(o.getTac()));
                cpA4.newLineAtOffset(-269, -22);
            }
            cpA4.endText();
            cpA4.close();
        } else {
            PDPageContentStream cpA3 = new PDPageContentStream(vykresNewDoc, postupPageCopy, true, false, true);
            cpA3.beginText();
            cpA3.setFont(fnt, 12);
            cpA3.newLineAtOffset(340, 1065);
            cpA3.showText(orderNumber);
            cpA3.newLineAtOffset(0, -20);
            cpA3.showText(String.valueOf(quantity));
            cpA3.newLineAtOffset(0, -25);
            cpA3.showText(partNumber);
            cpA3.newLineAtOffset(270, -5);
            cpA3.showText(date);
            cpA3.newLineAtOffset(0, 17);
            cpA3.showText(creeator);
            cpA3.newLineAtOffset(-525, -75);
            for (Operation o : operations) {
                cpA3.setFont(fnt, 10);
                cpA3.showText(String.valueOf(o.getNumber()));
                cpA3.newLineAtOffset(35, 0);
                cpA3.showText(o.getDescription());
                cpA3.newLineAtOffset(140, 0);
                cpA3.showText(o.getWorkplace());
                cpA3.setFont(fnt, 8);
                cpA3.newLineAtOffset(57, 0);
                cpA3.showText(String.valueOf(o.getTbc()));
                cpA3.newLineAtOffset(37, 0);
                cpA3.showText(String.valueOf(o.getTac()));
                cpA3.newLineAtOffset(-269, -22);
            }
            cpA3.endText();
            cpA3.close();
        }
        
        vykresNewDoc.addPage(postupPageCopy);

    }

    public PDDocument getDocument() {
        return vykresNewDoc;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public float getPercentTop() {
        return percentTop;
    }

    public float getPercentLeft() {
        return percentLeft;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getDrawing() {
        return drawing;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getCreeator() {
        return creeator;
    }

    public String getDate() {
        return date;
    }

    public int getPosition() {
        return position;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        String str = "";

        for (Operation oper : operations) {
            str += "\t" + oper.getNumber() + " - " + oper.getWorkplace() + " - " + oper.getDescription() + "\n";
        }

        return str;
    }

}
