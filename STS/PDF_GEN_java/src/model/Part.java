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
    public static final int CENTER_PAGE = 10;

    public static final int A4 = 1;
    public static final int A3 = 2;
    public static final int A2 = 3;
    public static final int A1 = 4;
    public static final int A0 = 5;

    private final float coordinatesTop;
    private final float coordinatesLeft;
    private final String orderNumber;
    private final int quantity;
    private final String drawing;
    private final String partNumber;
    private final String creeator;
    private final String date;
    private final String assemblies;
    private final String ghostScriptPath;
    private final int position;
    private final File filePath;
    private final boolean is_vydat_sklad;

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
    private int puvodniFormat;
    private int i;

    private PDDocument postupVzor;
    private PDPage postupPageVzor;
    private PDPage postupPageCopy;
    
    private static Logger logger;

    public Part(float coordinatesTop, float coordinatesLeft, String orderNumber, int quantity, String drawing, String partNumber, String creeator, String date, int position, String assemblies, File filePath, String ghostScriptPath, int i, boolean is_vydat_sklad) {
        this.coordinatesTop = coordinatesTop;
        this.coordinatesLeft = coordinatesLeft;
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
        this.i=i;
        this.is_vydat_sklad=is_vydat_sklad;
    }

    public boolean isPrinted(int i) {
        return (assemblies.charAt(i) == '1');
    }

    @SuppressWarnings("deprecation")
	public void loadDrawing() throws IOException, InterruptedException {
        File partFile = new File(drawing);
        if (!partFile.exists()) {
            throw new FileNotFoundException(partFile.getAbsolutePath());
        }
        /*
         Runtime rt = Runtime.getRuntime();
         //Process pr = rt.exec("cmd /c dir");
         Process pr = rt.exec("\"C:\\Program Files (x86)\\gs\\gs9.22\\bin\\gswin32c\" -o E:\\Instalace\\PDF\\INPUT\\Resized\\" + partFile.getName() + " -sDEVICE=pdfwrite -sPAPERSIZE=a4 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 " + partFile.getAbsolutePath());

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
         gsArgs[0] = "-o E:\\Instalace\\PDF\\INPUT\\Resized\\" + partFile.getName();
         gsArgs[1] = "-sDEVICE=pdfwrite";
         gsArgs[2] = "-sPAPERSIZE=a4";
         gsArgs[3] = "-dFIXEDMEDIA";
         gsArgs[4] = "-dPDFFitPage";
         gsArgs[5] = "-dCompatibilityLevel=1.4";        
         gsArgs[6] = partFile.getAbsolutePath();
        
         System.out.println("Resizing... " + partFile.getName());
        
         try { 
         gs.initialize(gsArgs);
         gs.runFile(partFile.getAbsolutePath());
         gs.exit();
         } catch (GhostscriptException ex) {
         ex.printStackTrace();
         }
         */
        vykresOrigDoc = PDDocument.load(partFile);
       // int num_pages=vykresOrigDoc.getDocumentCatalog().getPages().getCount();
       // System.out.println("pocet stranek dokumentu = "+num_pages);
        
      /*  vykresOrig = vykresOrigDoc.getDocumentCatalog().getPages().get(0);
        
		COSDictionary dicOrig = vykresOrig.getCOSObject();
		COSDictionary dicNew = new COSDictionary(dicOrig);
		dicNew.removeItem(COSName.ANNOTS);
        vykresNew = new PDPage(dicNew);
        vykresNewDoc = new PDDocument();*/
        
        
        	//ziskani formatu 
        	
	        vykresOrig = vykresOrigDoc.getDocumentCatalog().getPages().get(i);
	
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
	        
	        puvodniFormat = format;
	
	        //vykresOrigDoc.close();
	
	        vykresOrigDoc.close();
	        
	
	        System.out.println(partFile.getName() + ": " + pageWidthMM + " x " + pageHeightMM + "; Rotation: " + rotation + "; Format: " + format);
	        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	        if (format == Part.A0 || format == Part.A1 || format == Part.A2) {
	            Runtime rt = Runtime.getRuntime();
	            File newFile = new File(partFile.getParent() + "\\" + partFile.getName().substring(0, partFile.getName().indexOf(".")) + "_r.pdf");
	            //Process pr = rt.exec("cmd /c dir");
	            
	        
	            Process pr = rt.exec("\"" + ghostScriptPath + "\" -o " + newFile.getAbsolutePath() + " -sDEVICE=pdfwrite -sPAPERSIZE=a3 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 " + partFile.getAbsolutePath());
	            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	            String line = null;
	
	            while ((line = input.readLine()) != null) {
	                System.out.println(line);
	            }
	
	            int exitVal = pr.waitFor();
	            System.out.println("Exited with error code " + exitVal);			
	
	            vykresOrigDoc = PDDocument.load(newFile);
	            vykresOrig = vykresOrigDoc.getDocumentCatalog().getPages().get(i);
	            
	            pageWidth = vykresOrig.getMediaBox().getWidth();
	            pageHeight = vykresOrig.getMediaBox().getHeight();
	
	            pageWidthMM = (int) Math.round(pageWidth * (float) 25.4 / (float) 72.0);
	            pageHeightMM = (int) Math.round(pageHeight * (float) 25.4 / (float) 72.0);
	            
	            format = Part.A3;
	             // posleze poolit
	        } else {
	            vykresOrigDoc = PDDocument.load(partFile);
	        }
	
	      //  vykresOrigDoc = PDDocument.load(partFile);
	        		///
	 
	             vykresOrig = vykresOrigDoc.getDocumentCatalog().getPages().get(i);
	
	        
	       
	        		COSDictionary dicOrig = vykresOrig.getCOSObject();
	        		COSDictionary dicNew = new COSDictionary(dicOrig);
	        		dicNew.removeItem(COSName.ANNOTS);
	        		vykresNew = new PDPage(dicNew);
	        		
			        vykresNewDoc = new PDDocument();
	        		 
	       
	        
	      /*  if (puvodniFormat == Part.A0 || puvodniFormat == Part.A2) {
	        	//vykresNew.setRotation(vykresNew.getRotation() + 90);
	        }
	        */
	        ////////////////
	    
	        
	        
	        PDPageContentStream csInput = new PDPageContentStream(vykresNewDoc, vykresNew, true, false, true);
	       // vykresOrigDoc.close();
	        
	        
	        //csInput.setNonStrokingColor(Color.white);
	        //csInput.addRect(0, pageHeight - 20, 500, 20);
	        //csInput.fill();
	        
	        int xText;
	        int yText;
	        int yText_ks = 0;
	        int xText_ks;
	        int pageOffsetX;
	        int pageOffsetY;
	        
	        switch (format) {
	            case A4:
	                pageOffsetX = 35;
	                pageOffsetY = 55;
	                break;
	            case A3:
	                pageOffsetX = 50;
	                pageOffsetY = 60;
	                break;
	           
	            default:
	                pageOffsetX = 35;
	                pageOffsetY = 50;
	                break;
	        }
	       
	        	
	        
	        switch (position) {
	            case LEFT_TOP_CORNER:
	                xText = pageOffsetX;
	                yText = (int) pageHeight - pageOffsetY;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case LEFT_CENTER:
	                xText = pageOffsetX;
	                yText = (int) pageHeight / 2;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case LEFT_BOTTOM_CORNER:
	                xText = pageOffsetX;
	                yText = pageOffsetY+20;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case CENTER_TOP:
	                xText = (int) pageWidth / 2;
	                yText = (int) pageHeight - pageOffsetY;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case CENTER_BOTTOM:
	                xText = (int) pageWidth / 2;
	                yText = pageOffsetY;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case RIGHT_TOP_CORNER:
	                xText = (int) pageWidth - (pageOffsetX + 100);
	                yText = (int) pageHeight - pageOffsetY;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case RIGHT_CENTER:
	                xText = (int) pageWidth - (pageOffsetX + 100);
	                yText = (int) pageHeight / 2;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case RIGHT_BOTTOM_CORNER:
	                xText = (int) pageWidth - (pageOffsetX + 100);
	                yText = pageOffsetY;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            case CENTER_PAGE:
	            	 xText = (int) pageWidth / 2;
	                 yText = (int) pageHeight / 2 - pageOffsetY;
	                 yText_ks=yText-20;
	                 xText_ks=xText;
	                 break;
	            case CUSTOM:
	                //xText = (int) ((coordinatesLeft / 100.0) * pageWidth);
	                //yText = (int) (pageHeight - ((coordinatesTop / 100.0) * pageHeight));
	            	xText = (int) Math.round((coordinatesLeft*72)/25.4);
	                yText = (int) Math.round(pageHeight-(coordinatesTop*72)/25.4);
	            	yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	            default:
	                xText = pageOffsetX;
	                yText = (int) pageHeight - pageOffsetY;
	                yText_ks=yText-20;
	                xText_ks=xText;
	                break;
	        }
	
	        csInput.beginText();
	        
	        
	        csInput.newLineAtOffset(xText, yText);
	        pageWidthMM = (int) Math.round(yText * (float) 25.4 / (float) 72.0);
	        pageHeightMM = (int) Math.round(xText * (float) 25.4 / (float) 72.0);
	        
	        if (puvodniFormat == Part.A0 || puvodniFormat == Part.A1 || puvodniFormat == Part.A2) {
	        
	        	 switch (position) {
	             case LEFT_TOP_CORNER:
	            	 xText = pageOffsetX;
	                 yText = pageOffsetY;
	                 yText_ks=yText;
	                 xText_ks=xText+20;
	                 break;
	             case LEFT_CENTER:
	                 xText = pageOffsetX;
	                 yText = (int) pageHeight / 2;
	                 yText_ks=yText;
	                 xText_ks=xText-20;
	                 break;
	             case LEFT_BOTTOM_CORNER:
	            	 xText = (int) pageWidth - pageOffsetY;
	                 yText = pageOffsetY;
	                 yText_ks=yText;
	                 xText_ks=xText-20;
	                 break;
	             case CENTER_TOP:
	            	xText = (int) pageWidth - (pageOffsetY);
	                yText = pageOffsetX;
	                yText_ks=yText;
	                xText_ks=xText+20;
	                break;
	             case CENTER_BOTTOM:
	                 xText = (int) pageWidth - pageOffsetY;
	                 yText = (int) pageHeight / 2;
	                 yText_ks=yText;
	                 xText_ks=xText-20;
	                 break;
	             case RIGHT_TOP_CORNER:
	            	 xText = pageOffsetX;
	                 yText =(int) pageHeight -(100 + (orderNumber.length()*3));//
	                 yText_ks=yText;
	                 xText_ks=xText;
	                 break;
	             case RIGHT_CENTER:
	            	  xText = (int) pageWidth / 2;
	                  yText = (int) pageHeight -(100 + (orderNumber.length()*3));
	                  yText_ks=yText;
	                  xText_ks=xText-20;
	                  break;
	             case RIGHT_BOTTOM_CORNER:
	            	 xText = (int) pageWidth - pageOffsetY;
	                 yText = (int) pageHeight -(100 + (orderNumber.length()*3));
	                 yText_ks=yText;
	                 xText_ks=xText;
	                 break;
	             case CENTER_PAGE:
	             	 xText = (int) pageWidth / 2;
	                  yText = (int) pageHeight / 2 - pageOffsetY;
	                  yText_ks=yText;
	                  xText_ks=xText-20;
	                  break;
	             case CUSTOM:
	                 //xText = (int) ((coordinatesLeft / 100.0) * pageWidth);
	                 //yText = (int) (pageHeight - ((coordinatesTop / 100.0) * pageHeight));
	            	 if (puvodniFormat == Part.A2)
	            	 {
	            	 xText = (int) Math.round(((coordinatesTop*72)/25.4)*0.7071);
	                 yText = (int) Math.round(((coordinatesLeft*72)/25.4)*0.7071);
	                 pageWidthMM = (int) Math.round((yText * (float) 25.4 / (float) 72.0));
	                 pageHeightMM = (int) Math.round((xText * (float) 25.4 / (float) 72.0));
	                 
	             		yText_ks=yText-20;
	             		xText_ks=xText;
	            	 }else if (puvodniFormat == Part.A1)
	            	 {
	                	 xText = (int) Math.round(((coordinatesTop*72)/25.4)*0.4994);
	                     yText = (int) Math.round(((coordinatesLeft*72)/25.4)*0.5);
	                     pageWidthMM = (int) Math.round((yText * (float) 25.4 / (float) 72.0));
	                     pageHeightMM = (int) Math.round((xText * (float) 25.4 / (float) 72.0));
	                     
	                 		yText_ks=yText-20;
	                 		xText_ks=xText;
	                 }else if (puvodniFormat == Part.A1)
	                 {
	                    	 xText = (int) Math.round(((coordinatesTop*72)/25.4)*0.3532);
	                         yText = (int) Math.round(((coordinatesLeft*72)/25.4)*0.3532);
	                         pageWidthMM = (int) Math.round((yText * (float) 25.4 / (float) 72.0));
	                         pageHeightMM = (int) Math.round((xText * (float) 25.4 / (float) 72.0));
	                         
	                     		yText_ks=yText-20;
	                     		xText_ks=xText;
	                 }
	                 break;
	             default:
	                 xText = pageOffsetX;
	                 yText = (int) pageHeight - pageOffsetY;
	                 yText_ks=yText-20;
	                 xText_ks=xText;
	                 break;
	         }
	        	
	        	csInput.setTextRotation(1.5707963, xText, yText);
	        }
	        	 
	        //csInput.setFont(PDType1Font.COURIER, 20);
	        
	        //PDFont fnt = PDType0Font.load(vykresNewDoc, new FileInputStream("c:/windows/fonts/ARIALUNI.ttf"));
	        //PDFont fnt = PDType1Font.TIMES_BOLD;
	        PDFont fnt = FontLoader.getFont(vykresNewDoc, "c:/windows/fonts/ARIALUNI.ttf");
	        
	        csInput.setFont(fnt, 24);
	        csInput.setStrokingColor(Color.red);
	        csInput.setNonStrokingColor(Color.red);
	        csInput.showText(orderNumber);
	        csInput.newLineAtOffset(30, -24);
	        csInput.showText(String.valueOf(quantity) + " ks ");//+pageWidthMM+"x"+pageHeightMM
	        if(is_vydat_sklad)
	        {
	        	csInput.newLineAtOffset(-80, -24);
	        	csInput.showText("Vydat ze skladu");
	        }
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
	            cpA4.newLineAtOffset(315, 470);
	            cpA4.showText(orderNumber);
	            cpA4.newLineAtOffset(0, -22);
	            cpA4.showText(String.valueOf(quantity));
	            cpA4.newLineAtOffset(0, -23);
	            cpA4.showText(partNumber);
	            cpA4.newLineAtOffset(295, -5);
	            cpA4.showText(date);
	            cpA4.newLineAtOffset(0, 17);
	            cpA4.showText(creeator);
	            cpA4.newLineAtOffset(-525, -75);
	            for (Operation o : operations) {
	                cpA4.setFont(fnt, 9);
	                cpA4.showText(String.valueOf(o.getNumber()));
	                cpA4.newLineAtOffset(35, 0);
	                cpA4.showText(o.getDescription());
	                cpA4.newLineAtOffset(85, 0);
	               
	               
	                if(o.getWorkplace().length()<41)
	                {
	                cpA4.showText(o.getWorkplace());                
	                cpA4.setFont(fnt, 8);
	                }else if (o.getWorkplace().length()<110)
	                { cpA4.setFont(fnt, 7);	
	                	cpA4.newLineAtOffset(0, 5);
	                	cpA4.showText(o.getWorkplace().substring(0, 41));
	                	cpA4.newLineAtOffset(0, -8);
	                	cpA4.showText(o.getWorkplace().substring(41));
	                	//cpA4.showText(o.getWorkplace());                
	                	cpA4.setFont(fnt, 8);
	                	cpA4.newLineAtOffset(0, 3);
	                    
	                }
	                else if (o.getWorkplace().length()<160)
	                {
	                cpA4.setFont(fnt, 7);	
	            	cpA4.newLineAtOffset(0, 5);
	            	cpA4.showText(o.getWorkplace().substring(0, 50)+"-");
	            	cpA4.newLineAtOffset(0, -8);
	            	cpA4.showText(o.getWorkplace().substring(50,110));
	            	//cpA4.showText(o.getWorkplace());                
	            	cpA4.newLineAtOffset(0, -18);
	            	cpA4.showText(o.getWorkplace().substring(110));
	            	cpA4.newLineAtOffset(120, -5);
	            	cpA4.setFont(fnt, 9);
	                cpA4.showText(String.valueOf(o.getNumber()));
	                cpA4.newLineAtOffset(35, 0);
	                cpA4.showText(o.getDescription());
	                cpA4.newLineAtOffset(85, 0);
	                }
	                cpA4.newLineAtOffset(180, 0);
	                cpA4.showText(String.valueOf(o.getTac()));
	                cpA4.newLineAtOffset(34, 0);
	                cpA4.showText(String.valueOf(o.getTbc()));
	                cpA4.newLineAtOffset(-334, -22);
	                
	            }
	            cpA4.endText();
	            cpA4.close();
	//            operations.remove(i);
	        } else {
	            PDPageContentStream cpA3 = new PDPageContentStream(vykresNewDoc, postupPageCopy, true, false, true);
	            cpA3.beginText();
	            cpA3.setFont(fnt, 12);
	            cpA3.newLineAtOffset(315, 1065);
	            cpA3.showText(orderNumber);
	            cpA3.newLineAtOffset(0, -22);
	            cpA3.showText(String.valueOf(quantity));
	            cpA3.newLineAtOffset(0, -23);
	            cpA3.showText(partNumber);
	            cpA3.newLineAtOffset(295, -5);
	            cpA3.showText(date);
	            cpA3.newLineAtOffset(0, 17);
	            cpA3.showText(creeator);
	            cpA3.newLineAtOffset(-525, -75);
	            for (Operation o : operations) {
	                cpA3.setFont(fnt, 9);
	                cpA3.showText(String.valueOf(o.getNumber()));
	                cpA3.newLineAtOffset(35, 0);
	                cpA3.showText(o.getDescription());
	                cpA3.newLineAtOffset(85, 0);
	                
	                if(o.getWorkplace().length()<40)
	                {
	                cpA3.showText(o.getWorkplace());                
	                cpA3.setFont(fnt, 8);
	                }else if (o.getWorkplace().length()>=40 && o.getWorkplace().length()<110)
	                { cpA3.setFont(fnt, 7);	
	                	cpA3.newLineAtOffset(0, 5);
	                	int index1=o.getWorkplace().substring(0,40).lastIndexOf(' ');
	                	cpA3.showText(o.getWorkplace().substring(0, index1));
	                	cpA3.newLineAtOffset(0, -8);
	                	cpA3.showText(o.getWorkplace().substring(index1));
	                	//cpA4.showText(o.getWorkplace());                
	                	cpA3.setFont(fnt, 8);
	                	cpA3.newLineAtOffset(0, 3);
	                    
	                }else if(o.getWorkplace().length()>=110 && o.getWorkplace().length()<150) 
	                {
	                cpA3.setFont(fnt, 7);	
	            	cpA3.newLineAtOffset(0, 5);
	            	int index1=o.getWorkplace().substring(0,50).lastIndexOf(' ');
	            	cpA3.showText(o.getWorkplace().substring(0, index1));
	            	cpA3.newLineAtOffset(0, -8);
	            	int index2=o.getWorkplace().substring(0,100-(50-index1)).lastIndexOf(' ');
	            	cpA3.showText(o.getWorkplace().substring(index1,index2));
	            	
	            	cpA3.newLineAtOffset(0, -13);            	
	            	cpA3.showText(o.getWorkplace().substring(index2));
	            	cpA3.newLineAtOffset(-120, -5);
	            	cpA3.setFont(fnt, 9);
	                cpA3.showText(String.valueOf(o.getNumber()));
	                cpA3.newLineAtOffset(35, 0);
	                cpA3.showText(o.getDescription());
	                cpA3.newLineAtOffset(85, 0);
	                }
	                else if(o.getWorkplace().length()>=150 && o.getWorkplace().length()<200) 
	                {
	                cpA3.setFont(fnt, 7);	
	               	cpA3.newLineAtOffset(0, 5);
	                 int index1=o.getWorkplace().substring(0,50).lastIndexOf(' ');
	                 cpA3.showText(o.getWorkplace().substring(0, index1));
	                 cpA3.newLineAtOffset(0, -8);
	                 int index2=o.getWorkplace().substring(0,100).lastIndexOf(' ');
	                 cpA3.showText(o.getWorkplace().substring(index1,index2));
	                 	
	                 cpA3.newLineAtOffset(0, -13); 
	                 int index3=o.getWorkplace().substring(0,150).lastIndexOf(' ');
	                 
	                 cpA3.showText(o.getWorkplace().substring(index2,index3));
	                 cpA3.newLineAtOffset(0, -8);
	                 cpA3.showText(o.getWorkplace().substring(index3));
	                 cpA3.newLineAtOffset(-120, 3);
	            	cpA3.setFont(fnt, 9);
	                cpA3.showText(String.valueOf(o.getNumber()));
	                cpA3.newLineAtOffset(35, 0);
	                cpA3.showText(o.getDescription());
	                cpA3.newLineAtOffset(85, 0);
	                }
	                cpA3.newLineAtOffset(180, 0);
	                cpA3.showText(String.valueOf(o.getTac()));
	                cpA3.newLineAtOffset(34, 0);
	                cpA3.showText(String.valueOf(o.getTbc()));
	                cpA3.newLineAtOffset(-334, -22);
	            }
	            
	            cpA3.endText();
	            cpA3.close();
	     //       operations.remove(i);
	        }
	        
	        vykresNewDoc.addPage(postupPageCopy);
	    

    }

    public PDDocument getDocument() {
         return vykresNewDoc;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public float getcoordinatesTop() {
        return coordinatesTop;
    }

    public float getcoordinatesLeft() {
        return coordinatesLeft;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getQuantity() {
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

    public List<Operation> get() {
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
