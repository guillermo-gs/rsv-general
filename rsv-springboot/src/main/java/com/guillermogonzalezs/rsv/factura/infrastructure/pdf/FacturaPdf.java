package com.guillermogonzalezs.rsv.factura.infrastructure.pdf;

import com.guillermogonzalezs.rsv.factura.application.FindFacturaService;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import com.guillermogonzalezs.rsv.resources.FontLoader;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class FacturaPdf {
    private static final String BUCKET = "rsvfacturas-bucket";
    @Autowired
    private FindFacturaService service;

    @Autowired
    private S3Service s3Service;

//    public static final String REGULAR = "src/main/resources/fonts/Cardo-Regular.ttf";
//    public static final String BOLD = "src/main/resources/fonts/Cardo-Bold.ttf";
//    public static final String ITALIC = "src/main/resources/fonts/Cardo-Italic.ttf";

    public static final String REGULAR = "fonts/Cardo-Regular.ttf";
    public static final String BOLD = "fonts/Cardo-Bold.ttf";
    public static final String ITALIC = "fonts/Cardo-Italic.ttf";


    private  PdfFont bold;
    private Text ponerTitulo(String tipoSerie) {
        if (tipoSerie.equals("F")) {
            return  new Text("FACTURA").setFont(bold);
        }

        if (tipoSerie.equals("NG")) {
            return new Text("NOTA DE GASTOS").setFont(bold);
        }
        return  new Text("").setFont(bold);
    }

    public byte[] crearfacturaPdf(Factura f) throws Exception {
        FontLoader.loadFonts();
//        PdfFont fontProgram = FontLoader.getRegularFont();
//        PdfFont boldFont = FontLoader.getBoldFont();
//        PdfFont italicFont = FontLoader.getBoldFont();
        PdfFont helvetica = PdfFontFactory.createFont(StandardFonts.HELVETICA);




//        Factura f = this.service.obtenerPorUUID(UUID);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        Document doc = new Document(pdfDoc);

 //       String fichero = DEST +  f.getSerieNombre() + "_" + f.getCodigo() + ".pdf";
//        File file = new File(fichero);
//        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(file));
        List<Item> items = this.service.obtenerItems(f.getId());
//        Document doc = new Document(pdfDoc);

       FontProgram fontProgram = FontProgramFactory.createFont(REGULAR);



        PdfFont font = PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        this.bold = PdfFontFactory.createFont(BOLD, PdfEncodings.WINANSI, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        PdfFont italic = PdfFontFactory.createFont(ITALIC, PdfEncodings.WINANSI, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);


        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Paragraph parrafoEmpresa = new Paragraph().add(this.ponerTitulo(f.getSerieTipo())).setFont(helvetica).setBold().setFontSize(25).setTextAlignment(TextAlignment.CENTER);
        parrafoEmpresa.setMarginTop(10);
        doc.add(parrafoEmpresa);

        Table tableEmpresas = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        tableEmpresas.addCell(getCell(f.getNombre() + "\n" + "NIF: " + f.getNif() + "\n" + f.getDireccion() + "\n" + f.getCpostal() + " - " + f.getPoblacion(), TextAlignment.LEFT));
        tableEmpresas.addCell(getCell("ROSEVIGON S.L.\nCIF: B81039240\nC/ GUTIERREZ SOLANA, 3\n28036 - MADRID", TextAlignment.RIGHT));
        tableEmpresas.setMarginBottom(20);
        doc.add(tableEmpresas);

        Table tableDatosFactura = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
        tableDatosFactura.addCell(getCell("NUMERO: " + f.getSerieNombre() + "/" + f.getCodigo(), TextAlignment.LEFT));
        tableDatosFactura.addCell(getCell("FECHA: " + simpleDateFormat.format(f.getFecha()) , TextAlignment.LEFT));
        tableEmpresas.setMarginBottom(14);
        doc.add(tableDatosFactura);

        float[] columnWidths = {85, 15};
        Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();

        for (int i = 0; i < 2; i++) {
            Cell[] headerFooter = new Cell[]{
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("DESCRIPCION")),
                    new Cell().setTextAlignment(TextAlignment.RIGHT).setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("IMPORTE"))
            };

            for (Cell hfCell : headerFooter) {
                if (i == 0) {
                    table.addHeaderCell(hfCell);
                }
            }
        }

        for (Item i : items) {
            table.addCell(new Cell()
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginLeft(5)
                    .add(new Paragraph(String.valueOf(i.getDescripcion()).toUpperCase()))
            );
            table.addCell(new Cell().setFontSize(8).setTextAlignment(TextAlignment.RIGHT).add(new Paragraph(String.format("%.2f", i.getBase()) + " €"  )));
        }

        if (f.getIva().floatValue() > 0 && f.getSerieTipo().equals("F")) {
            table.addCell(getCell("SUBTOTAL", TextAlignment.RIGHT)).setMarginTop(10);
            table.addCell(getCell(  String.format("%.2f", f.getBase()) + " €", TextAlignment.RIGHT)).setMarginTop(10);
        }

        if (f.getIva().floatValue() > 0 && f.getSerieTipo().equals("F")) {
            table.addCell(getCell("IVA " + String.format("%.0f", f.getIva().divide(f.getBase()).multiply(BigDecimal.valueOf(100)))       + " %", TextAlignment.RIGHT));
            table.addCell(getCell(  String.format("%.2f", f.getIva()) + " €", TextAlignment.RIGHT));
        }
        if (f.getIrpf().floatValue()  > 0 && f.getSerieTipo().equals("F")) {
            table.addCell(getCell(" - IRPF " + String.format("%.0f", f.getIrpf().divide(f.getBase()).multiply(BigDecimal.valueOf(100)))       + " %", TextAlignment.RIGHT));
            table.addCell(getCell(  String.format("%.2f", f.getIrpf()) + " €", TextAlignment.RIGHT));
        }
        table.addCell(getCell("TOTAL " , TextAlignment.RIGHT).setBold());
        table.addCell(getCell(  String.format("%.2f", f.getTotal()) + " €", TextAlignment.RIGHT).setBold());
        table.setMarginTop(40);
        doc.add(table);
        doc.close();
        return byteArrayOutputStream.toByteArray();
    }

    public Cell getCell(String text, TextAlignment alignment) {
        Cell cell = new Cell().add(new Paragraph(text));
        cell.setPadding(0);
        cell.setTextAlignment(alignment);
        cell.setBorder(Border.NO_BORDER);
        cell.setFontSize(10);
        return cell;
    }

}
