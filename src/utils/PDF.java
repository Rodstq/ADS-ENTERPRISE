package utils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDF {

    private List<Object[]> lista;

    public void setList(List<Object[]> lista) {
        this.lista = lista;
    }

    public void gerarPdf() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("./PDFs/teste.pdf"));
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD);

            for (Object[] cliente : lista) {
                Paragraph paragraph = new Paragraph();

                // Formate e adicione os dados do cliente ao parágrafo
                for (Object campo : cliente) {
                    paragraph.add(new Chunk(campo.toString(), font));
                    paragraph.add(" ");
                 
                }

                document.add(paragraph);
            }

            document.close();

            System.out.println("teste");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
