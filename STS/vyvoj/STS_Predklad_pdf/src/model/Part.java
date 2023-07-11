package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;

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
  
  public static final int A4V = 11;
  
  public static final int A4H = 12;
  
  public static final int A3V = 21;
  
  public static final int A3H = 22;
  
  public static final int A2V = 31;
  
  public static final int A2H = 32;
  
  public static final int A1V = 41;
  
  public static final int A1H = 42;
  
  public static final int A0V = 51;
  
  public static final int A0H = 52;
  
  public static final int A0 = 5;
  
  private float coordinatesTop;
  
  private float coordinatesLeft;
  
  private final String orderNumber;
  
  private final int quantity;
  
  private final String drawing;
  
  private final String partNumber;
  
  private final String vrchol;
  
  private final String pozice;
  
  private final String creeator;
  
  private final String date;
  
  private final String assemblies;
  
  private final String ghostScriptPath;
  
  private int position;
  
  private final File filePath;
  
  private final boolean is_vydat_sklad;
  
  private boolean zmena_vel = false;
  
  private boolean chyb_scen = false;
  
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
  
  float koeficientZmenseniHeight = 1.0F;
  
  float koeficientZmenseniWidth = 1.0F;
  
  List<PDAnnotation> annot;
  
  private static Logger logger;
  
  public Part(float coordinatesTop, float coordinatesLeft, String orderNumber, int quantity, String drawing, String partNumber, String creeator, String date, int position, String assemblies, File filePath, String ghostScriptPath, String vrchol, int i, boolean is_vydat_sklad, String pozice) {
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
    this.i = i;
    this.is_vydat_sklad = is_vydat_sklad;
    this.vrchol = vrchol;
    this.pozice = pozice;
  }
  
  public boolean isPrinted(int i) {
    return (this.assemblies.charAt(i) == '1');
  }
  
  public void loadDrawing() throws IOException, InterruptedException {
    int xText_ks;
    File partFile = new File(this.drawing);
    if (!partFile.exists())
      throw new FileNotFoundException(partFile.getAbsolutePath()); 
    this.vykresOrigDoc = PDDocument.load(partFile);
    int horizontalne = 1;
    this.vykresOrig = this.vykresOrigDoc.getDocumentCatalog().getPages().get(this.i);
    float height = this.vykresOrig.getArtBox().getHeight();
    float width = this.vykresOrig.getArtBox().getWidth();
    System.out.println("rozmery:" + height + " x " + width);
    this.pageWidth = this.vykresOrig.getMediaBox().getWidth();
    this.pageHeight = this.vykresOrig.getMediaBox().getHeight();
    System.out.println("rozmery:" + this.pageHeight + " x " + this.pageWidth);
    this.pageWidthMM = Math.round(this.pageWidth * 25.4F / 72.0F);
    this.pageHeightMM = Math.round(this.pageHeight * 25.4F / 72.0F);
    System.out.println("rozmery:" + this.pageHeightMM + " x " + this.pageWidthMM);
    this.rotation = this.vykresOrig.getRotation();
    if (212 > this.pageWidthMM && this.pageWidthMM > 200 && 287 < this.pageHeightMM && this.pageHeightMM < 310) { //A4 na vzsku
      this.format = 11;
      if (this.pageWidthMM != 210 || this.pageHeightMM != 297)
        this.chyb_scen = true; 
    } else if (287 < this.pageWidthMM && this.pageWidthMM < 310 && 220 > this.pageHeightMM && this.pageHeightMM > 200) {
      this.format = 12;
      if (this.pageWidthMM != 297 || this.pageHeightMM != 210)
        this.chyb_scen = true; 
    } else if (410 < this.pageWidthMM && this.pageWidthMM < 430 && 310 > this.pageHeightMM && this.pageHeightMM > 280) {
      this.format = 22;
      if (this.pageWidthMM != 420 || this.pageHeightMM != 297)
        this.chyb_scen = true; 
    } else if (287 < this.pageWidthMM && this.pageWidthMM < 310 && 310 > this.pageHeightMM && this.pageHeightMM > 280) {
      this.format = 21;
      if (this.pageWidthMM != 297 || this.pageHeightMM != 420)
        this.chyb_scen = true; 
    } else if (this.pageWidthMM == 594 && this.pageHeightMM == 420) {
      this.format = 32;
    } else if (this.pageWidthMM == 420 && this.pageHeightMM == 594) {
      this.format = 31;
    } else if (this.pageWidthMM == 841 && this.pageHeightMM == 594) {
      this.format = 42;
    } else if (this.pageWidthMM == 594 && this.pageHeightMM == 841) {
      this.format = 41;
    } else if (this.pageWidthMM == 1189 && this.pageHeightMM == 841) {
      this.format = 52;
    } else if (this.pageWidthMM == 841 && this.pageHeightMM == 1189) {
      this.format = 51;
    } else {
      this.format = 5;
    } 
    this.puvodniFormat = this.format;
    if (this.format == 22 || this.format == 21 || this.format == 12 || this.format == 11) {
      PDPage page = this.vykresOrigDoc.getPages().get(this.i);
      this.annot = page.getAnnotations();
      if (this.annot.isEmpty()) {
        System.out.println("Bez poznamky");
      } else {
        System.out.println("S poznamkama");
      } 
    } 
    this.vykresOrigDoc.close();
    System.out.println(String.valueOf(partFile.getName()) + ": " + this.pageWidthMM + " x " + this.pageHeightMM + "; Rotation: " + this.rotation + 
        "; Format: " + this.format);
    if (this.format == 52 || 
      this.format == 51 || 
      this.format == 42 || 
      this.format == 41 || 
      this.format == 31 || 
      this.format == 32 || (
      this.format == 22 && !this.annot.isEmpty()) || (
      this.format == 21 && !this.annot.isEmpty()) || (
      this.format == 11 && !this.annot.isEmpty()) || (
      this.format == 12 && !this.annot.isEmpty()) || 
      this.chyb_scen) {
      Process pr;
      Runtime rt = Runtime.getRuntime();
      File newFile = new File(String.valueOf(partFile.getParent()) + "\\" + 
          partFile.getName().substring(0, partFile.getName().indexOf(".")) + "_r.pdf");
      switch (this.format) {
        case 52:
          this.coordinatesLeft = (int)(this.coordinatesLeft / 2.83095D);
          this.coordinatesTop = (int)(this.coordinatesTop / 2.83165D);
          this.pageHeight = (int)(this.pageHeight / 2.83165D);
          this.pageWidth = (int)(this.pageWidth / 2.83165D);
          this.koeficientZmenseniHeight = 2.83F;
          this.koeficientZmenseniWidth = 2.83F;
          break;
        case 51:
          this.coordinatesLeft = (int)(this.coordinatesLeft / 2.83D);
          this.coordinatesTop = (int)(this.coordinatesTop / 2.83D);
          this.pageHeight = (int)(this.pageHeight / 2.83D);
          this.pageWidth = (int)(this.pageWidth / 2.83D);
          this.koeficientZmenseniHeight = 2.83F;
          this.koeficientZmenseniWidth = 2.83F;
          break;
        case 41:
          this.coordinatesLeft = (int)(this.coordinatesLeft / 2.0F);
          this.coordinatesTop = (int)(this.coordinatesTop / 2.0F);
          this.pageHeight = (int)(this.pageHeight / 2.0F);
          this.pageWidth = (int)(this.pageWidth / 2.0F);
          this.koeficientZmenseniHeight = 2.0F;
          this.koeficientZmenseniWidth = 2.0F;
          break;
        case 42:
          this.coordinatesLeft = (int)(this.coordinatesLeft / 2.0F);
          this.coordinatesTop = (int)(this.coordinatesTop / 2.0F);
          this.pageHeight = (int)(this.pageHeight / 2.0F);
          this.pageWidth = (int)(this.pageWidth / 2.0F);
          this.koeficientZmenseniHeight = 2.0F;
          this.koeficientZmenseniWidth = 2.0F;
          break;
        case 31:
          this.coordinatesLeft = (int)(this.coordinatesLeft / 1.41414D);
          this.coordinatesTop = (int)(this.coordinatesTop / 1.41414D);
          this.pageHeight = (int)(this.pageHeight / 1.41414D);
          this.pageWidth = (int)(this.pageWidth / 1.41414D);
          this.pageHeightMM = (int)(this.pageHeightMM / 1.41414D);
          this.koeficientZmenseniHeight = 1.41414F;
          this.koeficientZmenseniWidth = 1.41414F;
          break;
        case 32:
          this.coordinatesLeft = (int)(this.coordinatesLeft / 1.41414D);
          this.coordinatesTop = (int)(this.coordinatesTop / 1.41414D);
          this.pageHeight = (int)(this.pageHeight / 1.41414D);
          this.pageWidth = (int)(this.pageWidth / 1.41414D);
          this.koeficientZmenseniHeight = 1.41414F;
          this.koeficientZmenseniWidth = 1.41414F;
          break;
      } 
      horizontalne = this.format % 2;
      if (this.format == 11 || this.format == 12) {
        pr = rt.exec("\"" + this.ghostScriptPath + "\" -o " + newFile.getAbsolutePath() + 
            " -sDEVICE=pdfwrite -sPAPERSIZE=a4 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 -dAutoRotatePages=/All " + 
            partFile.getAbsolutePath());
      } else {
        pr = rt.exec("\"" + this.ghostScriptPath + "\" -o " + newFile.getAbsolutePath() + 
            " -sDEVICE=pdfwrite -sPAPERSIZE=a3 -dFIXEDMEDIA -dPDFFitPage -dCompatibilityLevel=1.4 " + 
            partFile.getAbsolutePath());
        this.zmena_vel = true;
      } 
      BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
      String line = null;
      while ((line = input.readLine()) != null)
        System.out.println(line); 
      int exitVal = pr.waitFor();
      System.out.println("Exited with error code " + exitVal);
      this.vykresOrigDoc = PDDocument.load(newFile);
      this.vykresOrig = this.vykresOrigDoc.getDocumentCatalog().getPages().get(this.i);
      if (this.format != 12 && this.format % 2 == 0) {
        this.format = 22;
      } else if (this.format != 11) {
        this.format = 21;
      } 
    } else {
      this.vykresOrigDoc = PDDocument.load(partFile);
    } 
    this.vykresOrig = this.vykresOrigDoc.getDocumentCatalog().getPages().get(this.i);
    COSDictionary dicOrig = this.vykresOrig.getCOSObject();
    COSDictionary dicNew = new COSDictionary(dicOrig);
    this.vykresNew = new PDPage(dicNew);
    this.vykresNewDoc = new PDDocument();
    PDPageContentStream csInput = new PDPageContentStream(this.vykresNewDoc, this.vykresNew, true, false, true);
    int xText = 0;
    int yText = 0;
    int yText_ks = 0;
    int pageOffsetX = 0;
    int pageOffsetY = 0;
    if (this.position != 9)
      switch (this.format) {
        case 11:
          pageOffsetX = 30;
          pageOffsetY = 25;
          break;
        case 12:
          pageOffsetX = 25;
          pageOffsetY = 30;
          break;
        case 21:
          pageOffsetX = 30;
          pageOffsetY = 27;
          break;
        case 22:
          pageOffsetX = 27;
          pageOffsetY = 30;
          break;
        default:
          pageOffsetX = 35;
          pageOffsetY = 50;
          break;
      }  
    if (this.rotation == 90) {
      int offse_help = pageOffsetX;
      pageOffsetX = pageOffsetY;
      pageOffsetY = offse_help * 3;
      switch (this.position) {
        case 1:
          this.position = 6;
          break;
        case 4:
          this.position = 7;
          break;
        case 6:
          this.position = 8;
          break;
        case 2:
          this.position = 4;
          break;
        case 7:
          this.position = 5;
          break;
        case 3:
          this.position = 1;
          break;
        case 5:
          this.position = 2;
          break;
        case 8:
          this.position = 3;
          break;
      } 
    } 
    PDFont fnt = FontLoader.getFont(this.vykresNewDoc, "c:/windows/fonts/ARIALUNI.ttf");
    String radek1 = this.orderNumber + " - " + String.valueOf(this.quantity) + " ks";
    float text_width = fnt.getStringWidth(radek1) / 1000.0F * 20.0F;
    float text_width_r3 = fnt.getStringWidth(this.pozice) / 1000.0F * 20.0F;
    float text_width_r2 = fnt.getStringWidth(this.vrchol) / 1000.0F * 20.0F;
    int maxDelka = 10;
    if (maxDelka < (int)text_width)
      maxDelka = (int)text_width; 
    if (maxDelka < (int)text_width_r2)
      maxDelka = (int)text_width_r2; 
    if (maxDelka < (int)text_width_r3)
      maxDelka = (int)text_width_r3; 
    switch (this.position) {
      case 1:
        xText = pageOffsetX + maxDelka;
        yText = (int)this.pageHeight - pageOffsetY;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 4:
        xText = pageOffsetX + maxDelka;
        yText = (int)this.pageHeight / 2;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 6:
        xText = pageOffsetX + maxDelka;
        yText = pageOffsetY + 92;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 2:
        xText = (int)this.pageWidth / 2;
        yText = (int)this.pageHeight - pageOffsetY;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 7:
        xText = (int)this.pageWidth / 2;
        yText = pageOffsetY + 92;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 3:
        xText = (int)this.pageWidth - pageOffsetX;
        yText = (int)this.pageHeight - pageOffsetY;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 5:
        xText = (int)this.pageWidth - pageOffsetX;
        yText = (int)this.pageHeight / 2;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 8:
        xText = (int)this.pageWidth - pageOffsetX;
        yText = pageOffsetY + 92;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 10:
        xText = (int)this.pageWidth / 2;
        yText = (int)this.pageHeight / 2;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      case 9:
        System.out.println("velikost stranky :" + (this.pageWidth * 25.0F / 72.0F) + " x " + (this.pageHeight * 25.0F / 72.0F));
        System.out.println("koordinasou:" + this.coordinatesLeft + " x " + this.coordinatesTop + "mm");
        xText = (int)Math.round((this.coordinatesLeft * 72.0F) / 25.4D);
        yText = (int)Math.round(this.pageHeight - (this.coordinatesTop * 72.0F) / 25.4D);
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
      default:
        xText = pageOffsetX;
        yText = (int)this.pageHeight - pageOffsetY;
        yText_ks = yText - 20;
        xText_ks = xText;
        break;
    } 
    if (this.zmena_vel && horizontalne == 0) {
      int tmp = xText;
      xText = (int)(this.pageHeight - yText);
      yText = tmp;
      System.out.println("zmena velikosti " + xText + " x " + yText);
    } 
    csInput.beginText();
    csInput.newLineAtOffset(xText, yText);
    this.pageWidthMM = Math.round(yText * 25.4F / 72.0F);
    this.pageHeightMM = Math.round(xText * 25.4F / 72.0F);
    System.out.println("rozmery umisteni razitka:" + this.pageHeightMM + " x " + this.pageWidthMM);
    this.pageHeightMM = (int)(this.pageHeightMM / this.koeficientZmenseniHeight);
    this.pageWidthMM = (int)(this.pageWidthMM / this.koeficientZmenseniWidth);
    System.out.println("rozmery umisteni razitka:" + this.pageHeightMM + " x " + this.pageWidthMM);
    if (this.zmena_vel && horizontalne == 0)
      csInput.setTextRotation(1.5707963D, xText, yText); 
    if (this.rotation != 0)
      csInput.setTextRotation(1.5707963D, xText, yText); 
    csInput.setFont(fnt, 20.0F);
    csInput.setStrokingColor(Color.red);
    csInput.setNonStrokingColor(Color.red);
    csInput.newLineAtOffset(-text_width, -20.0F);
    csInput.showText(radek1);
    csInput.newLineAtOffset(text_width - text_width_r3, -24.0F);
    csInput.showText(this.pozice);
    if (this.is_vydat_sklad) {
      float vydatSklad = fnt.getStringWidth("VYDAT ZE SKLADU") / 1000.0F * 20.0F;
      csInput.newLineAtOffset(text_width_r3 - vydatSklad, -24.0F);
      csInput.showText("VYDAT ZE SKLADU");
    } 
    csInput.setStrokingColor(Color.black);
    csInput.setNonStrokingColor(Color.black);
    csInput.endText();
    csInput.close();
    this.vykresNewDoc.addPage(this.vykresNew);
    if (this.format == 11 || this.format == 12) {
      this.postupVzor = PDDocument.load(new File(String.valueOf(this.filePath.getParent()) + "\\pa4.pdf"));
    } else {
      this.postupVzor = PDDocument.load(new File(String.valueOf(this.filePath.getParent()) + "\\pa3.pdf"));
    } 
    this.postupPageVzor = this.postupVzor.getPage(0);
    COSDictionary dicVzor = this.postupPageVzor.getCOSObject();
    COSDictionary dicCopy = new COSDictionary(dicVzor);
    dicCopy.removeItem(COSName.ANNOTS);
    this.postupPageCopy = new PDPage(dicCopy);
    if (this.format == 11) {
      PDPageContentStream cpA4 = new PDPageContentStream(this.vykresNewDoc, this.postupPageCopy, true, false, true);
      cpA4.beginText();
      cpA4.setFont(fnt, 12.0F);
      cpA4.newLineAtOffset(315.0F, 470.0F);
      cpA4.showText(this.orderNumber);
      cpA4.newLineAtOffset(0.0F, -22.0F);
      cpA4.showText(String.valueOf(this.quantity));
      cpA4.newLineAtOffset(0.0F, -23.0F);
      cpA4.showText(this.partNumber);
      cpA4.newLineAtOffset(295.0F, -5.0F);
      cpA4.showText(this.date);
      cpA4.newLineAtOffset(0.0F, 17.0F);
      cpA4.showText(this.creeator);
      cpA4.newLineAtOffset(-525.0F, -75.0F);
      for (Operation o : this.operations) {
        cpA4.setFont(fnt, 9.0F);
        cpA4.showText(String.valueOf(o.getNumber()));
        cpA4.newLineAtOffset(35.0F, 0.0F);
        cpA4.showText(o.getDescription());
        cpA4.newLineAtOffset(85.0F, 0.0F);
        if (o.getWorkplace().length() < 41) {
          cpA4.showText(o.getWorkplace());
          cpA4.setFont(fnt, 8.0F);
        } else if (o.getWorkplace().length() < 110) {
          cpA4.setFont(fnt, 7.0F);
          cpA4.newLineAtOffset(0.0F, 5.0F);
          cpA4.showText(o.getWorkplace().substring(0, 41));
          cpA4.newLineAtOffset(0.0F, -8.0F);
          cpA4.showText(o.getWorkplace().substring(41));
          cpA4.setFont(fnt, 8.0F);
          cpA4.newLineAtOffset(0.0F, 3.0F);
        } else if (o.getWorkplace().length() < 160) {
          cpA4.setFont(fnt, 7.0F);
          cpA4.newLineAtOffset(0.0F, 5.0F);
          cpA4.showText(String.valueOf(o.getWorkplace().substring(0, 50)) + "-");
          cpA4.newLineAtOffset(0.0F, -8.0F);
          cpA4.showText(o.getWorkplace().substring(50, 110));
          cpA4.newLineAtOffset(0.0F, -18.0F);
          cpA4.showText(o.getWorkplace().substring(110));
          cpA4.newLineAtOffset(120.0F, -5.0F);
          cpA4.setFont(fnt, 9.0F);
          cpA4.showText(String.valueOf(o.getNumber()));
          cpA4.newLineAtOffset(35.0F, 0.0F);
          cpA4.showText(o.getDescription());
          cpA4.newLineAtOffset(85.0F, 0.0F);
        } 
        cpA4.newLineAtOffset(180.0F, 0.0F);
        cpA4.showText(String.valueOf(o.getTac()));
        cpA4.newLineAtOffset(34.0F, 0.0F);
        cpA4.showText(String.valueOf(o.getTbc()));
        cpA4.newLineAtOffset(-334.0F, -22.0F);
      } 
      cpA4.endText();
      cpA4.close();
    } else {
      PDPageContentStream cpA3 = new PDPageContentStream(this.vykresNewDoc, this.postupPageCopy, true, false, true);
      cpA3.beginText();
      cpA3.setFont(fnt, 12.0F);
      cpA3.newLineAtOffset(315.0F, 1065.0F);
      cpA3.showText(this.orderNumber);
      cpA3.newLineAtOffset(0.0F, -22.0F);
      cpA3.showText(String.valueOf(this.quantity));
      cpA3.newLineAtOffset(0.0F, -23.0F);
      cpA3.showText(this.partNumber);
      cpA3.newLineAtOffset(295.0F, -5.0F);
      cpA3.showText(this.date);
      cpA3.newLineAtOffset(0.0F, 17.0F);
      cpA3.showText(this.creeator);
      cpA3.newLineAtOffset(-525.0F, -75.0F);
      for (Operation o : this.operations) {
        cpA3.setFont(fnt, 9.0F);
        cpA3.showText(String.valueOf(o.getNumber()));
        cpA3.newLineAtOffset(35.0F, 0.0F);
        cpA3.showText(o.getDescription());
        cpA3.newLineAtOffset(85.0F, 0.0F);
        if (o.getWorkplace().length() < 40) {
          cpA3.showText(o.getWorkplace());
          cpA3.setFont(fnt, 8.0F);
        } else if (o.getWorkplace().length() >= 40 && o.getWorkplace().length() < 110) {
          cpA3.setFont(fnt, 7.0F);
          cpA3.newLineAtOffset(0.0F, 5.0F);
          int index1 = o.getWorkplace().substring(0, 40).lastIndexOf(' ');
          cpA3.showText(o.getWorkplace().substring(0, index1));
          cpA3.newLineAtOffset(0.0F, -8.0F);
          cpA3.showText(o.getWorkplace().substring(index1));
          cpA3.setFont(fnt, 8.0F);
          cpA3.newLineAtOffset(0.0F, 3.0F);
        } else if (o.getWorkplace().length() >= 110 && o.getWorkplace().length() < 150) {
          cpA3.setFont(fnt, 7.0F);
          cpA3.newLineAtOffset(0.0F, 5.0F);
          int index1 = o.getWorkplace().substring(0, 50).lastIndexOf(' ');
          cpA3.showText(o.getWorkplace().substring(0, index1));
          cpA3.newLineAtOffset(0.0F, -8.0F);
          int index2 = o.getWorkplace().substring(0, 100 - 50 - index1).lastIndexOf(' ');
          cpA3.showText(o.getWorkplace().substring(index1, index2));
          cpA3.newLineAtOffset(0.0F, -13.0F);
          cpA3.showText(o.getWorkplace().substring(index2));
          cpA3.newLineAtOffset(-120.0F, -5.0F);
          cpA3.setFont(fnt, 9.0F);
          cpA3.showText(String.valueOf(o.getNumber()));
          cpA3.newLineAtOffset(35.0F, 0.0F);
          cpA3.showText(o.getDescription());
          cpA3.newLineAtOffset(85.0F, 0.0F);
        } else if (o.getWorkplace().length() >= 150 && o.getWorkplace().length() < 200) {
          cpA3.setFont(fnt, 7.0F);
          cpA3.newLineAtOffset(0.0F, 5.0F);
          int index1 = o.getWorkplace().substring(0, 50).lastIndexOf(' ');
          cpA3.showText(o.getWorkplace().substring(0, index1));
          cpA3.newLineAtOffset(0.0F, -8.0F);
          int index2 = o.getWorkplace().substring(0, 100).lastIndexOf(' ');
          cpA3.showText(o.getWorkplace().substring(index1, index2));
          cpA3.newLineAtOffset(0.0F, -13.0F);
          int index3 = o.getWorkplace().substring(0, 150).lastIndexOf(' ');
          cpA3.showText(o.getWorkplace().substring(index2, index3));
          cpA3.newLineAtOffset(0.0F, -8.0F);
          cpA3.showText(o.getWorkplace().substring(index3));
          cpA3.newLineAtOffset(-120.0F, 3.0F);
          cpA3.setFont(fnt, 9.0F);
          cpA3.showText(String.valueOf(o.getNumber()));
          cpA3.newLineAtOffset(35.0F, 0.0F);
          cpA3.showText(o.getDescription());
          cpA3.newLineAtOffset(85.0F, 0.0F);
        } 
        cpA3.newLineAtOffset(180.0F, 0.0F);
        cpA3.showText(String.valueOf(o.getTac()));
        cpA3.newLineAtOffset(34.0F, 0.0F);
        cpA3.showText(String.valueOf(o.getTbc()));
        cpA3.newLineAtOffset(-334.0F, -22.0F);
      } 
      cpA3.endText();
      cpA3.close();
    } 
    this.vykresNewDoc.addPage(this.postupPageCopy);
  }
  
  public PDDocument getDocument() {
    return this.vykresNewDoc;
  }
  
  public void addOperation(Operation operation) {
    this.operations.add(operation);
  }
  
  public float getcoordinatesTop() {
    return this.coordinatesTop;
  }
  
  public float getcoordinatesLeft() {
    return this.coordinatesLeft;
  }
  
  public String getOrderNumber() {
    return this.orderNumber;
  }
  
  public int getQuantity() {
    return this.quantity;
  }
  
  public String getDrawing() {
    return this.drawing;
  }
  
  public String getPartNumber() {
    return this.partNumber;
  }
  
  public String getCreeator() {
    return this.creeator;
  }
  
  public String getDate() {
    return this.date;
  }
  
  public int getPosition() {
    return this.position;
  }
  
  public List<Operation> get() {
    return this.operations;
  }
  
  public String toString() {
    String str = "";
    for (Operation oper : this.operations)
      str = String.valueOf(str) + "\t" + oper.getNumber() + " - " + oper.getWorkplace() + " - " + oper.getDescription() + "\n"; 
    return str;
  }
}