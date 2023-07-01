package utils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfChunk;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDF {
    private DefaultTableModel lista;

    public void setList(DefaultTableModel tabelaModel) {
        this.lista = tabelaModel;
    }

//    public void gerarPdf() throws DocumentException {
//        Document document = new Document(PageSize.A4, 36, 36, 36, 36);
//        try {
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./PDFs/teste.pdf"));
//            document.open();
//            
//            float[] widths = {150f, 150f, 150f, 150f};
//            Rectangle r = new Rectangle(PageSize.A4.getRight(70), PageSize.A4.getTop(150));
//            PdfPTable table = new PdfPTable(((DefaultTableModel) lista).getColumnCount());
//            
//            table.setWidthPercentage(widths, r);
//            table.setTotalWidth(500);
//            table.setLockedWidth(true);
//            
////            for (int i = 0; i < ((DefaultTableModel) lista).getColumnCount()-5;i++) {
////                table.addCell(((DefaultTableModel) lista).getColumnName(i));
////
////            }
//            
////            for (int i = 0; i < ((DefaultTableModel) lista).getRowCount(); i++) {
////                for (int k = 0; k < ((DefaultTableModel) lista).getColumnCount()-4; k++) {
////                    table.addCell(((DefaultTableModel) lista).getValueAt(i, k).toString());
////                   
////                }
////            }
////            
//            document.add(table);
//            document.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        document.close();
//    }
//}
//


    public void gerarPdf() throws DocumentException {
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./PDFs/teste.pdf"));
            document.open();

            float[] widths = {150f, 150f, 150f, 150f};
            Rectangle r = new Rectangle(PageSize.A4.getRight(70), PageSize.A4.getTop(150));
            PdfPTable table = new PdfPTable(4);

            table.setWidthPercentage(widths, r);
            table.setTotalWidth(500);
            table.setLockedWidth(true);

            for (int i = 0; i < 4; i++) {
                table.addCell(lista.getColumnName(i));
            }

            for (int i = 0; i < lista.getRowCount(); i++) {
                for (int k = 0; k < 4; k++) {
                    Object cellValue = lista.getValueAt(i, k);
                    table.addCell(cellValue.toString());
                }
            }

            document.add(table);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}






//float[] widths = { 150f, 70f, 70f, 70f, 70f, 70f, 70f, 70f, 100f };
//PdfPTable table = new PdfPTable(widths);
//
//for (Object[] cliente : lista) {
//  for (Object valor : cliente) {
//      PdfPCell cell = new PdfPCell(new Paragraph(valor.toString()));
//      table.addCell(cell);
//      
//      
//      
//  }
//  
//}
//
//
//document.add(table);
//document.close();
//
//
//} catch (FileNotFoundException e) {
//e.printStackTrace();
//}
//}
//}	






