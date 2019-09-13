/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.live.itext_try;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author T43422
 */
public class main {

    public static void main(String args[]) throws Exception {
        // Creating a PdfWriter       
        Map parameters = new HashMap();
        parameters.put("fechaEvento", "10 de septiembre de 2019");
        parameters.put("folioEvento", "2019131");
        parameters.put("responsableSeguimiento", "Rodríguez Islas Delia Elsa");
        parameters.put("descripcionEvento","Una hoja no localizada en el lote 69 del tiro 12/19 de la denominación 500 G en el proceso de Numeración. El día 9 de julio en la máquina Super Numerota III, de la Fábrica de Billetes Ciudad de México, durante la impresión del lote 69, se presentó una falla en el sistema Parvis (Sistema de Control de la Producción), esta falla no permitió concluir correctamente con el procesamiento y registro del lote en el sistema. Una vez que se logró restablecer el sistema, se decidió dejar pendiente la impresión del lote 70 hasta el final de tiro.  Después de la impresión del lote 70, último lote numerado, el Aprendiz de Prensista, reportó en la bitácora de la máquina el faltante de una hoja en el lote 69, por lo que no se completaron las 10,000 hojas que integran cada uno de los lotes de producción. " );
        parameters.put("descripcionCausa", "Una hoja no localizada en el lote 69 del tiro 12/19 de la denominación 500 G en el proceso de Numeración. El día 9 de julio en la máquina Super Numerota III, de la Fábrica de Billetes Ciudad de México, durante la impresión del lote 69, se presentó una falla en el sistema Parvis (Sistema de Control de la Producción), esta falla no permitió concluir correctamente con el procesamiento y registro del lote en el sistema. Una vez que se logró restablecer el sistema, se decidió dejar pendiente la impresión del lote 70 hasta el final de tiro.  Después de la impresión del lote 70, último lote numerado, el Aprendiz de Prensista, reportó en la bitácora de la máquina el faltante de una hoja en el lote 69, por lo que no se completaron las 10,000 hojas que integran cada uno de los lotes de producción. ");
        parameters.put("descripcionConsecuencia", "Una hoja faltante del lote 69 del tiro 12/19 de la denominación 500 G.  Se requirió de la participación de personal de las Oficinas de Impresión de la Ciudad de México para el recuento de alrededor de 23 lotes.");
        parameters.put("accionesInmediatas", "15/07/2019- Se recontó el lote 70 para confirmar la cantidad de hojas con las que había terminado el tiro y tratar de ubicar la hoja faltante del lote 69.  16/07/2019- Se recontó el lote 69 para buscar la hoja faltante   16 y 17/07/2018- Se recuentan los lotes que se imprimieron el mismo día que el lote 69, esto son: 66, 67, 71, 72, 73, 74 y 75.   17/07/2019- Se dio aviso a los funcionarios correspondientes.  18/07/2019- Se recontaron los lotes que se imprimieron el día previo y el siguiente día a la impresión del lote 69, los cuales son: 68, 76, 77, 78, 79, 82 y 83.  19/07/2019- Se revisaron los registros de los lotes 69 y 70 en el sistema Parvis para rastrear su paso por todos los procesos de impresión e identificar si alguno de ellos tenía diferencias antes de llegar al proceso de Numeración, y de ser el caso, reorientar la búsqueda de la hoja faltante del lote 69.  22 al 24/07/2019- Se recontaron los lotes del tiro 12/19 de 500 “G” que fueron procesados en días cercanos al día en que se imprimió el lote 69, estos son: 85, 86, 87, 88, 89, 90 y 91.   22/07/2019- Personal de las oficinas de Impresión y de Control de Operaciones de Caja y Fabricación de Billetes, recontaron la maculatura controlada, sin localizar la hoja faltante.  26/07/2019- Se solicitó revisar el interior de la máquina Serigráfica en la que se imprimió el tiro 12/19, para lo cual fue necesario remover las tolvas e inspeccionar áreas de difícil acceso en el interior de la máquina, esto permitió observar que en la parte baja de la sección donde las hojas dan vuelta para pasar por las lámparas de secado UV, se encontraba la hoja faltante de $500G perteneciente al tiro 12/19. ");
        parameters.put("operativo", "X");
        parameters.put("operativoAfectacion", "Leve");
        parameters.put("operativoDetalle", "bla bla bla");
        parameters.put("monetario", "");
        parameters.put("monetarioAfectacion", "");
        parameters.put("monetarioDetalle", "");
        parameters.put("reputacion", "");
        parameters.put("reputacionAfectacion", "");
        parameters.put("reputacionDetalle", "");
        parameters.put("salud", "");
        parameters.put("saludAfectacion", "");
        parameters.put("saludDetalle", "");
        parameters.put("medioAmbiente", "");
        parameters.put("medioAfectacion", "");
        parameters.put("medioDetalle", "");
        parameters.put("descripcionAccion1", "Se estará al pendiente de los correos que les haga llegar la Oficina de\nAdministración de esta CR, para que este tipo de evento no se presente.");
        parameters.put("responsable1", "T43422");
        parameters.put("fecha1", "19 de julio de 2019");
        parameters.put("comentarios1", "Mantenimiento entrego la maquina supernumerota 2 el día 25-03-2019 en el turno matutino, iniciando producción el mismo día en el turno vespertino, con ello concluye el evento con un operación normal.");
        parameters.put("descripcionAccion2", "");
        parameters.put("responsable2", "");
        parameters.put("fecha2", "");
        parameters.put("comentarios2", "");
        parameters.put("descripcionAccion3", "El día 25 de julio del presente, durante el Acuerdo entre la Dirección General de Emisión, la Dirección de Fabricación de Billetes y la Dirección de Administración de Emisión, el Lic. Alegre Rabiela informó que las gerencias: Informática de la DGE, Gestión de la DGE y Desarrollo y Reingeniería de Procesos participarían en la revisión del proceso de impresión de billetes y los controles existentes en conjunto con la DFB.");
        parameters.put("responsable3", "K09226");
        parameters.put("fecha3", "30 de agosto de 2019");
        parameters.put("comentarios3", "Se concluyó con el análisis del proceso de impresión. En dicho análisis se identificaron los controles existentes en la operación, las áreas de oportunidad y los controles a reforzar en la operación");
        parameters.put("fechaSeguimiento", "30 de agosto de 2019");
        parameters.put("estadoAtencion", "Cerrado");

        itextR m = new itextR();
        m.generateReport(parameters);
    }

}
