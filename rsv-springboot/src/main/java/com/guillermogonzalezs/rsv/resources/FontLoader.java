package com.guillermogonzalezs.rsv.resources;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.PdfEncodings;

import java.io.InputStream;
import java.io.IOException;

public class FontLoader {

    private static PdfFont regularFont;
    private static PdfFont boldFont;
    private static PdfFont italicFont;

    public static void loadFonts() throws IOException {
        regularFont = loadFont("fonts/Cardo-Regular.ttf");
        boldFont = loadFont("fonts/Cardo-Bold.ttf");
        italicFont = loadFont("fonts/Cardo-Italic.ttf");
    }

    private static PdfFont loadFont(String fontPath) throws IOException {
        try (InputStream fontStream = FontLoader.class.getClassLoader().getResourceAsStream(fontPath)) {
            if (fontStream == null) {
                throw new IOException("Font file " + fontPath + " not found");
            }
            byte[] fontBytes = fontStream.readAllBytes();
            FontProgram fontProgram = FontProgramFactory.createFont(fontBytes);
            return PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        }
    }

    public static PdfFont getRegularFont() {
        return regularFont;
    }

    public static PdfFont getBoldFont() {
        return boldFont;
    }

    public static PdfFont getItalicFont() {
        return italicFont;
    }
}