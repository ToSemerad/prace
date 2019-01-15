package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class FontLoader {
	
	
    private static PDFont font;
    
    public static PDFont getFont(PDDocument doc, String file) throws IOException {
        if (font == null) {
            FileInputStream fis = new FileInputStream(new File(file));
            font = PDType0Font.load(doc, fis);
            fis.close();
        }
        return font;
    }
    

}
