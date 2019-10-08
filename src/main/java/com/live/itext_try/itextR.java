/*@live2303 
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
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
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
        PdfFont italic = PdfFontFactory.createFont(FontConstants.HELVETICA_OBLIQUE);
        DeviceRgb BMcolor = new DeviceRgb(0, 39, 91);
        DeviceRgb disableColor = new DeviceRgb(224, 224, 224);
        SolidLine line = new SolidLine(0.3f);
        line.setColor(disableColor);

        // Creating a PdfDocument       
        PdfDocument pdfDoc = new PdfDocument(writer);
        IEventHandler handler = new Background(pdfDoc, "templante.pdf");
        pdfDoc.addEventHandler(com.itextpdf.kernel.events.PdfDocumentEvent.START_PAGE, handler);
        PdfPage page = pdfDoc.addNewPage();
        Document document = new Document(pdfDoc); //, PageSize.LETTER
        document.setMargins(60, 40, 50, 40);
        document.setFont(regular).setFontSize(11);

        Text noInfo = new Text("(No existe información)").setFont(italic).setFontColor(disableColor);
        Text sinAfec = new Text("(Sin Afectación)").setFont(italic).setFontColor(disableColor);

        /*FOLIO*/
        Text folio = new Text((String) param.get("folioEvento")).setFont(bold).setFontSize(18).setUnderline();
        PdfCanvas pdfCanvas = new PdfCanvas(page);
        Rectangle rectangle = new Rectangle(450, 630, 100, 50);
        pdfCanvas.rectangle(rectangle);
        pdfCanvas.stroke();
        Canvas canvas = new Canvas(pdfCanvas, pdfDoc, rectangle);
        canvas.add(new Paragraph().add(folio).add("\n").add(new Text("Folio del evento").setFont(regular).setFontSize(10)).setTextAlignment(TextAlignment.CENTER));
        canvas.close();

        /*Fecha/responsable */
        Text tipo = new Text((String) param.get("tipoEv")).setFont(regular).setFontSize(11);
        Text fecha = new Text((String) param.get("fechaEvento")).setFont(regular).setFontSize(11);
        Text responsable = new Text((String) param.get("responsableSeguimiento")).setFont(regular).setFontSize(11);
        Rectangle rectangleFR = new Rectangle(40, 615, 350, 70);
        pdfCanvas.rectangle(rectangleFR);
        canvas = new Canvas(pdfCanvas, pdfDoc, rectangleFR);
        canvas.add(new Paragraph().add(new Text("Tipo de evento: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(tipo).add("\n").add(new Text("Fecha del evento: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(fecha).add("\n").add(new Text("Responsable de seguimiento: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(responsable).setTextAlignment(TextAlignment.LEFT).setFixedLeading(20f)).setBorder(Border.NO_BORDER);
        canvas.close();
        document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n"));
        /*Descripción*/
        Text desc = new Text((String) param.get("descripcionEvento")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Descripción: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(desc).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(15f)); //.setFixedPosition(40, 450, null)

        /*Causas*/
        Text causas = new Text((String) param.get("descripcionCausa")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Descripción de la(s) causa(s): ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(causas).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(15f));

        /*Consecuencias*/
        Text consecuencias = new Text((String) param.get("descripcionConsecuencia")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Descripción de la(s) consecuencia(s) o afectación: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(consecuencias).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(15f));

        /*AccInmediatas*/
        Text AcInmediatas = new Text((String) param.get("accionesInmediatas")).setFont(regular).setFontSize(11);
        document.add(new Paragraph().add(new Text("Acciones de atención inmediata que se llevaron a cabo al presentarse el evento: ").setFont(bold).setFontSize(12).setFontColor(BMcolor)).add(AcInmediatas).setTextAlignment(TextAlignment.JUSTIFIED).setMarginBottom(15f));

        /*Impacto */
        document.add(new Paragraph().add(new Text("Impacto/Consecuencia:").setFont(bold).setFontSize(12).setFontColor(BMcolor)).setTextAlignment(TextAlignment.JUSTIFIED));

        Paragraph oper = new Paragraph(new Text("Operativo ").setFont(bold).setFontColor(param.get("operativo").equals("X") ? BMcolor : BMcolor)).setFontSize(11);
        if (!param.get("operativoAfectacion").equals("")) {
            oper.add(new Text(String.format("(Nivel de afectación: %s)\n", (String) param.get("operativoAfectacion"))).setFont(italic));
        } else {
            oper.add(sinAfec);
        }
        if (!param.get("operativoDetalle").equals("")) {
            oper.add(new Text(String.format(" %s", (String) param.get("operativoDetalle"))).setFont(regular));
        }

        Paragraph mon = new Paragraph(new Text("Monetario ").setFont(bold).setFontColor(param.get("monetario").equals("X") ? BMcolor : BMcolor)).setFontSize(11);
        if (!param.get("monetarioAfectacion").equals("")) {
            mon.add(new Text(String.format("(Nivel de afectación: %s)\n", (String) param.get("monetarioAfectacion"))).setFont(italic));
        } else {
            mon.add(sinAfec);
        }
        if (!param.get("monetarioDetalle").equals("")) {
            mon.add(new Text(String.format(" %s", (String) param.get("monetarioDetalle"))).setFont(regular));
        }

        Paragraph rep = new Paragraph(new Text("Reputación ").setFont(bold).setFontColor(param.get("reputacion").equals("X") ? BMcolor : BMcolor)).setFontSize(11);
        if (!param.get("reputacionAfectacion").equals("")) {
            rep.add(new Text(String.format("(Nivel de afectación: %s)\n", (String) param.get("reputacionAfectacion"))).setFont(italic));
        } else {
            rep.add(sinAfec);
        }
        if (!param.get("reputacionDetalle").equals("")) {
            rep.add(new Text(String.format(" %s", (String) param.get("reputacionDetalle"))).setFont(regular));
        }

        Paragraph salud = new Paragraph(new Text("Salud ").setFont(bold).setFontColor(param.get("salud").equals("X") ? BMcolor : BMcolor)).setFontSize(11);
        if (!param.get("saludAfectacion").equals("")) {
            salud.add(new Text(String.format("(Nivel de afectación: %s)\n", (String) param.get("saludAfectacion"))).setFont(italic));
        } else {
            salud.add(sinAfec);
        }
        if (!param.get("saludDetalle").equals("")) {
            salud.add(new Text(String.format(" %s", (String) param.get("saludDetalle"))).setFont(regular));
        }

        Paragraph medA = new Paragraph(new Text("Medio Ambiente ").setFont(bold).setFontColor(param.get("medioAmbiente").equals("X") ? BMcolor : BMcolor)).setFontSize(11).setMarginBottom(15f);
        if (!param.get("medioAfectacion").equals("")) {
            medA.add(new Text(String.format("(Nivel de afectación: %s)\n", (String) param.get("medioAfectacion"))).setFont(italic));
        } else {
            medA.add(sinAfec);
        }
        if (!param.get("medioDetalle").equals("")) {
            medA.add(new Text(String.format(" %s", (String) param.get("medioDetalle"))).setFont(regular));
        }

        document.add(oper).add(mon).add(rep).add(salud).add(medA);

        /*Acciones*/
        document.add(new Paragraph().add(new Text("Acciones correctivas o preventivas:").setFont(bold).setFontSize(12).setFontColor(BMcolor)).setTextAlignment(TextAlignment.JUSTIFIED));
        int maxAccions = 3;
        boolean acc=false;
        for (int i = 1; i <= maxAccions; i++) {
            if (!param.get("descripcionAccion" + i).equals("")) {
                acc=true;
                if (i > 1) {
                    document.add(new LineSeparator(line).setWidthPercent(90).setMarginBottom(5f).setMarginTop(5f).setHorizontalAlignment(HorizontalAlignment.CENTER));
                }

                Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1})).useAllAvailableWidth();
                table.addCell(new Cell().add(new Paragraph().add(new Text("Responsable: ").setFont(bold).setFontColor(BMcolor)).add(new Text(String.format("%s", param.get("responsable" + i))).setFont(regular)).setTextAlignment(TextAlignment.LEFT)).setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(new Paragraph().add(new Text("Fecha: ").setFont(bold).setFontColor(BMcolor)).add(new Text(String.format("%s", param.get("fecha" + i))).setFont(italic)).setTextAlignment(TextAlignment.RIGHT)).setBorder(Border.NO_BORDER));
                document.add(table);
                Text accion_d = new Text((String) param.get("descripcionAccion" + i)).setFont(regular).setFontSize(11);
                Text accion_c = new Text((String) param.get("comentarios" + i)).setFont(regular).setFontSize(11);
                document.add(new Paragraph().add(new Text("Descripción: ").setFont(bold).setFontSize(11).setFontColor(BMcolor)).add(accion_d).setTextAlignment(TextAlignment.JUSTIFIED));
                if (!accion_c.getText().equals("")) {
                    document.add(new Paragraph().add(new Text("Comentarios del seguimiento: ").setFont(bold).setFontSize(11).setFontColor(BMcolor)).add(accion_c).setTextAlignment(TextAlignment.JUSTIFIED));
                }

            }
        }
        if(acc==false){
            document.add(new Paragraph().add(noInfo));
        }

        /**/
        Table tableF = new Table(UnitValue.createPercentArray(new float[]{1, 1})).useAllAvailableWidth().setMarginTop(25f);
        tableF.addCell(new Cell().add("Estado del evento").setFont(bold).setFontSize(8).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER).setFontColor(BMcolor));
        if (!param.get("fechaSeguimiento").equals("")) {
            tableF.addCell(new Cell().add("Fecha de cierre").setFont(bold).setFontSize(8).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER).setFontColor(BMcolor));
        } else {
            tableF.addCell(new Cell().setBorder(Border.NO_BORDER));
        }
        tableF.addCell(new Cell().setFont(bold).add(String.format("%s", param.get("estadoAtencion"))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        tableF.addCell(new Cell().setFont(regular).add(String.format("%s", param.get("fechaSeguimiento"))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));

        document.add(tableF);

        document.close();
    }
    
}
