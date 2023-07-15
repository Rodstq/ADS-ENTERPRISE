package utils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfChunk;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDF {
	
    private DefaultTableModel listaInfoCliente;
    private DefaultTableModel listInfoPedidosCliente;
    
    
    
    public void setListInfoCliente(DefaultTableModel tabelaCliente) {
        this.listaInfoCliente = tabelaCliente;
    }
    
    public void setListInfoPedidosCliente(DefaultTableModel tabelaPedidos) {
    	
    	this.listInfoPedidosCliente = tabelaPedidos;
    	
    }
    

    public void gerarPdf() throws DocumentException {
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./PDFs/teste.pdf"));
            
            document.open();
            
            //Header//
            PdfPTable header = new PdfPTable(3);
            header.setTotalWidth(510);
            float[] widthsHeader = {38, 36, 36};
            header.setWidths(widthsHeader);
            header.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            header.getDefaultCell().setPaddingBottom(5);
            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
            
            
            PdfPCell espacoVazio = new PdfPCell(new Paragraph(""));
            espacoVazio.setBorder(Rectangle.NO_BORDER);

            
            header.addCell(espacoVazio);
            
            Paragraph tituloHeader =  new Paragraph("adsGestão", new Font(Font.COURIER, 20, Font.BOLD));
            PdfPCell adsGesta = new PdfPCell(tituloHeader);
            adsGesta.setPaddingBottom(10);
            adsGesta.setHorizontalAlignment(Element.ALIGN_CENTER);
            adsGesta.setBorder(Rectangle.NO_BORDER);
            
            header.addCell(adsGesta);
            header.addCell(espacoVazio);

            Font cellFont = new Font(Font.HELVETICA, 8);
            header.addCell(new Paragraph("Contato: (819) 2424-1212", cellFont));
            header.addCell(new Paragraph("Endereço : Lugar Nenhum", cellFont));
            header.addCell(new Paragraph("Website : http://onlyFans.com.br", cellFont));
            
            document.add(header);
            
            
            
            //tabelas

            float[] widthsColunas = {150,150f, 150f, 150f, 150f};
            
            
            Rectangle r = new Rectangle(PageSize.A4.getRight(70), PageSize.A4.getTop(150));
            PdfPTable infoCliente = new PdfPTable(5);
            
            
            infoCliente.setWidthPercentage(widthsColunas, r);
            infoCliente.setTotalWidth(500);
            infoCliente.setLockedWidth(true);

            Paragraph paragrafoResultadoCliente = new Paragraph(new Chunk(
                    "Lista de clientes: ",
            FontFactory.getFont(FontFactory.HELVETICA, 10)));
            paragrafoResultadoCliente.setSpacingBefore(15);
            
            
            for (int i = 0; i < 5; i++) {
                if (i == 4) {
                    infoCliente.addCell("Complemento");
                } else {
                    infoCliente.addCell(listaInfoCliente.getColumnName(i));
                }
            }

            for (int i = 0; i < listaInfoCliente.getRowCount(); i++) {
            	
                String cpfAtual = listaInfoCliente.getValueAt(i, 1).toString();
                boolean cpfDuplicado = false;

                for (int j = 0; j < i; j++) {
                    String cpfAnterior = listaInfoCliente.getValueAt(j, 1).toString();

                    if (cpfAtual.equals(cpfAnterior)) {
                        cpfDuplicado = true;
                        break;
                    }
                }

                if (!cpfDuplicado) {
                    for (int k = 0; k < 5; k++) {
                        Object celulaUnica = listaInfoCliente.getValueAt(i, k);
                        infoCliente.addCell(celulaUnica.toString());
                    }
                }
            }

            paragrafoResultadoCliente.add(infoCliente);


                 
            Paragraph paragrafoResultadoPedidos = new Paragraph(new Chunk(
                    "Lista de pedidos dos clientes: ",
                    FontFactory.getFont(FontFactory.HELVETICA, 10)));
            paragrafoResultadoPedidos.setSpacingBefore(15);
            PdfPTable pedidosInfo = new PdfPTable(5);
            
            pedidosInfo.setWidthPercentage(widthsColunas, r);
            pedidosInfo.setTotalWidth(500);
            pedidosInfo.setLockedWidth(true);
            
            for (int i = 0; i < 5; i++) {
            	
          
                	
                	if(i==4) {
                		pedidosInfo.addCell("CPF Cliente");
                }else {
                	
                    pedidosInfo.addCell(listInfoPedidosCliente.getColumnName(i));
                }
                	
           }
            	
            
           
            for (int i = 0; i < listInfoPedidosCliente.getRowCount(); i++) {
            	
           
                for (int k = 0; k < 5; k++) {
//                  
//                    if(k==4) {
//                    	
//                    	 	
//                   
//                      	Object cellValue = listaInfoCliente.getValueAt(i,1);
//                      	pedidosInfo.addCell(cellValue.toString());
//                      	
//                    }else {
                    	
                    	Object cellValue = listInfoPedidosCliente.getValueAt(i,k);
                    	 pedidosInfo.addCell(cellValue.toString());
//                    	
//                    }
                   
                }
            }
            paragrafoResultadoPedidos.add(pedidosInfo);
            document.add(paragrafoResultadoCliente);
            document.add(paragrafoResultadoPedidos);
            
            

            /* Footer */
            PdfPTable footer= new PdfPTable(2);
          	footer.setTotalWidth(510);
          	footer.setWidths(new int[]{50,50});
            // Magic about default cell - if you add styling to default cell it will apply to all cells except cells added using addCell(PdfPCell) method.
          	footer.getDefaultCell().setPaddingBottom(5);
          	footer.getDefaultCell().setBorder(Rectangle.TOP);

            Paragraph tituloFooter =  new Paragraph("AdsGestão", new Font(Font.HELVETICA, 10));
            PdfPCell titleCell = new PdfPCell(tituloFooter);
            titleCell.setPaddingTop(4);
            titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            titleCell.setBorder(Rectangle.TOP);
          	footer.addCell(titleCell);

            Paragraph pageNumberText =  new Paragraph("Page "+document.getPageNumber(), new Font(Font.HELVETICA, 10));
            PdfPCell pageNumberCell = new PdfPCell(pageNumberText);
            pageNumberCell.setPaddingTop(4);
            pageNumberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pageNumberCell.setBorder(Rectangle.TOP);
            footer.addCell(pageNumberCell);
      
          	footer.writeSelectedRows(0, -1, 34, 36,writer.getDirectContent());

           

        
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}



