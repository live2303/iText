/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.live.itext_try;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Font;

/**
 *
 * @author T43422
 */
public class main {

    public static void main(String args[]) throws Exception {
        // Creating a PdfWriter       
        String dest = "sample.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument       
        PdfDocument pdfDoc = new PdfDocument(writer);
        IEventHandler handler = new Background(pdfDoc, "templante.pdf");
        pdfDoc.addEventHandler(com.itextpdf.kernel.events.PdfDocumentEvent.START_PAGE, handler);
        // Adding a new page 
        pdfDoc.addNewPage();

        // Creating a Document        
        Document document = new Document(pdfDoc);
        String para1 = "Tutorials Point originated from the idea that there exists a class of readers who respond better to online content and prefer to learn new skills at their own pace from the comforts of their drawing rooms.";
        String para2 = "The journey commenced with a single tutorial on HTML in 2006 and elated by the response it generated, we worked our way to adding fresh tutorials to our repository which now proudly flaunts a wealth of tutorials and allied articles on topics ranging from programming languages to web designing  academics and much more.";
        document.setMargins(150, 20, 20, 20);
        document.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
        // Creating Paragraphs       
        Paragraph paragraph1 = new Paragraph(para1).setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
        Paragraph paragraph2 = new Paragraph(para2);

        // Adding paragraphs to document       
        document.add(paragraph1);
        document.add(new AreaBreak());
        document.add(paragraph2);

        // Closing the document    
        document.close();
    }

}
