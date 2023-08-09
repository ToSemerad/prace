/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author TPV
 */
public class PrintAssembly {
    
    private final List<Part> parts;
    private final String fileName;
    
    public PrintAssembly(String fileName) {
        parts = new ArrayList<>();
        this.fileName = fileName;
    }
    
    public void addPart(Part part) {
        this.parts.add(part);
    }
    
    public void save() throws IOException {
        PDDocument docNew = new PDDocument();
        
        for (Part p : parts) {
            PDDocument doc = p.getDocument();
            PDPage p1 = doc.getPage(0);
            PDPage p2 = doc.getPage(1);
            
            COSDictionary d1 = p1.getCOSObject();
            COSDictionary d1c = new COSDictionary(d1);
            d1c.removeItem(COSName.ANNOTS);
            PDPage p1c = new PDPage(d1c);
            docNew.addPage(p1c);
            
            
            COSDictionary d2 = p2.getCOSObject();
            COSDictionary d2c = new COSDictionary(d2);
            d2c.removeItem(COSName.ANNOTS);
            PDPage p2c = new PDPage(d2c);
            docNew.addPage(p2c);
            
        }
        
        docNew.save(fileName);
    }
    
    @Override
    public String toString() {
        String str = "*** SESTAVA TISKU ***\n";
        for (Part part : this.parts) {
          str = String.valueOf(str) + "--------------------------\n";
          str = String.valueOf(str) + "D" + part.getPartNumber() + "\n";
          str = String.valueOf(str) + "V" + part.getDrawing() + "\n";
          str = String.valueOf(str) + part.toString();
          str = String.valueOf(str) + "--------------------------\n";
        } 
        str = String.valueOf(str) + "*** KONEC SESTAVY ***\n";
        return str;
      }

    public String getFileName() {
        return fileName;
    }

    public List<Part> getParts() {
        return parts;
    }
    
}
