/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.live.itext_try;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author T43422
 */
public class itextR {

    public itextR(){
        
    }
    public void generateReport(Map param) throws FileNotFoundException, IOException{
        String dest = "sample.pdf";
        PdfWriter writer = new PdfWriter(dest);

        PdfFont regular = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        DeviceRgb BMcolor = new DeviceRgb(0, 39, 91);
        // Creating a PdfDocument       
        PdfDocument pdfDoc = new PdfDocument(writer);
        IEventHandler handler = new Background(pdfDoc, "templante.pdf");
        pdfDoc.addEventHandler(com.itextpdf.kernel.events.PdfDocumentEvent.START_PAGE, handler);
        PdfPage page = pdfDoc.addNewPage();
        Document document = new Document(pdfDoc); //, PageSize.LETTER
        document.setMargins(60, 40, 50, 40);
        document.setFont(regular);
        
        /*FOLIO*/
        Text folio = new Text((String)param.get("folioEvento")).setFont(bold).setFontSize(18).setUnderline();
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        Rectangle rectangle = new Rectangle(450, 630, 100, 50);
        pdfCanvas.rectangle(rectangle);
        pdfCanvas.stroke();
        Canvas canvas = new Canvas(pdfCanvas, pdfDoc, rectangle);       
        canvas.add(new Paragraph().add(folio).add("\n").add(new Text("Folio del evento").setFont(regular).setFontSize(10)).setTextAlignment(TextAlignment.CENTER));
        canvas.close();
        
        /*Fecha/responsable */
        Text fecha = new Text((String)param.get("fechaEvento")).setFont(regular).setFontSize(12);
        Text responsable = new Text((String)param.get("responsableSeguimiento")).setFont(regular).setFontSize(12);
        Rectangle rectangleFR = new Rectangle(40, 630, 300, 50);
        pdfCanvas.rectangle(rectangleFR);
        canvas = new Canvas(pdfCanvas, pdfDoc, rectangleFR);       
        canvas.add(new Paragraph().add(new Text("Fecha: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(fecha).add("\n").add(new Text("Responsable: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(responsable).setTextAlignment(TextAlignment.LEFT));
        canvas.close();
        document.add(new Paragraph("\n\n\n\n\n\n\n\n"));
        /*Descripción*/
        Text desc = new Text((String)param.get("descripcionEvento")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Descripción: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(desc).setTextAlignment(TextAlignment.JUSTIFIED)); //.setFixedPosition(40, 450, null)
        
        /*Causas*/
        Text causas = new Text((String)param.get("descripcionCausa")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Descripción de la(s) causa(s): ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(causas).setTextAlignment(TextAlignment.JUSTIFIED)).add(); //me falta el pinshi salto pero ya me voy alv
        
        /*Consecuencias*/
        Text consecuencias = new Text((String)param.get("descripcionConsecuencia")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Descripción de la(s) consecuencia(s) o afectación: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(consecuencias).setTextAlignment(TextAlignment.JUSTIFIED));
        
        /*AccInmediatas*/
        Text AcInmediatas =new Text((String)param.get("accionesInmediatas")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Acciones de atención inmediata que se llevaron a cabo al presentarse el evento: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(AcInmediatas).setTextAlignment(TextAlignment.JUSTIFIED));

        /*Impacto */
        document.add(new Paragraph().add(new Text("Impacto/Consecuencia").setFont(bold).setFontSize(12).setFontColor(BMcolor)).setTextAlignment(TextAlignment.JUSTIFIED));
        
  
        document.close();
    }
    
}
