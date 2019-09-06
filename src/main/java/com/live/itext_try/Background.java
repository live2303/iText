/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.live.itext_try;

import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.*;
import static com.itextpdf.kernel.pdf.PdfName.Event;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfXObject;
import java.io.IOException;

;

/**
 *
 * @author T43422
 */
class Background implements IEventHandler {

    PdfXObject stationery_1;
    PdfXObject stationery_2;

    public Background(PdfDocument pdf, String src) throws IOException {
        PdfDocument template = new PdfDocument(new PdfReader(src));
        
        
        stationery_1 = template.getPage(1).copyAsFormXObject(pdf);
        stationery_2 = template.getPage(2).copyAsFormXObject(pdf);
        template.close();
    }

    @Override
    public void handleEvent(com.itextpdf.kernel.events.Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfDocument pdf = docEvent.getDocument();
        PdfPage page = docEvent.getPage();
        PdfCanvas pdfCanvas = new PdfCanvas(
                page.newContentStreamBefore(), page.getResources(), pdf);
        if(pdf.getNumberOfPages()>1){
            pdfCanvas.addXObject(stationery_2, 0, 0);
            
        }else{
            pdfCanvas.addXObject(stationery_1, 0, 0);
        }
        
        
    }
}
