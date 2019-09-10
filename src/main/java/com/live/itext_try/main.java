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
        parameters.put("fechaEvento", "19 de julio de 2019");
        parameters.put("folioEvento", "2019100");
        parameters.put("responsableSeguimiento", "Pedro Antonio Paredes Hernández");
        parameters.put("descripcionEvento", "DESCEl viernes 19 de julio, el Sr. Salomón Guerrero García, Subgerente Administración y Operación Banxico de Santander reportó mediante correo electrónico lo siguiente: Informarles que en la ruta https://extranet.banxico.org.mx/SAM/ConsultaAutenticacion?execution=e1s1 donde nuestras sucursales consultan el dictamen de las piezas y realizan el pago de aquellas que resultaron auténticas, el recibo R2018206719 aparece como “Procede reembolso” debiendo decir “Pieza Pagada”, ya que el importe se le pago al cliente desde el pasado 10 de agosto de 2018 y el comprobante de pago se cargó a SAM ese mismo día. El 12 de junio del presente se presentó el cliente a nuestra sucursal argumentando que no se le había pagado. El personal de la sucursal al consultar el dictamen y observar que el estatus dice “Procede reembolso”, duplicó el pago al cliente.Se trata de una pieza de $500.");
        parameters.put("descripcionCausa", "CAUSAEl viernes 19 de julio, el Sr. Salomón Guerrero García, Subgerente Administración y Operación Banxico de Santander reportó mediante correo electrónico lo siguiente: Informarles que en la ruta https://extranet.banxico.org.mx/SAM/ConsultaAutenticacion?execution=e1s1 donde nuestras sucursales consultan el dictamen de las piezas y realizan el pago de aquellas que resultaron auténticas, el recibo R2018206719 aparece como “Procede reembolso” debiendo decir “Pieza Pagada”, ya que el importe se le pago al cliente desde el pasado 10 de agosto de 2018 y el comprobante de pago se cargó a SAM ese mismo día. El 12 de junio del presente se presentó el cliente a nuestra sucursal argumentando que no se le había pagado. El personal de la sucursal al consultar el dictamen y observar que el estatus dice “Procede reembolso”, duplicó el pago al cliente.Se trata de una pieza de $500.");
        parameters.put("descripcionConsecuencia", "CONSECUENCIAEl viernes 19 de julio, el Sr. Salomón Guerrero García, Subgerente Administración y Operación Banxico de Santander reportó mediante correo electrónico lo siguiente: Informarles que en la ruta https://extranet.banxico.org.mx/SAM/ConsultaAutenticacion?execution=e1s1 donde nuestras sucursales consultan el dictamen de las piezas y realizan el pago de aquellas que resultaron auténticas, el recibo R2018206719 aparece como “Procede reembolso” debiendo decir “Pieza Pagada”, ya que el importe se le pago al cliente desde el pasado 10 de agosto de 2018 y el comprobante de pago se cargó a SAM ese mismo día. El 12 de junio del presente se presentó el cliente a nuestra sucursal argumentando que no se le había pagado. El personal de la sucursal al consultar el dictamen y observar que el estatus dice “Procede reembolso”, duplicó el pago al cliente.Se trata de una pieza de $500.");
        parameters.put("accionesInmediatas", "ACC_InmEl viernes 19 de julio, el Sr. Salomón Guerrero García, Subgerente Administración y Operación Banxico de Santander reportó mediante correo electrónico lo siguiente: Informarles que en la ruta https://extranet.banxico.org.mx/SAM/ConsultaAutenticacion?execution=e1s1 donde nuestras sucursales consultan el dictamen de las piezas y realizan el pago de aquellas que resultaron auténticas, el recibo R2018206719 aparece como “Procede reembolso” debiendo decir “Pieza Pagada”, ya que el importe se le pago al cliente desde el pasado 10 de agosto de 2018 y el comprobante de pago se cargó a SAM ese mismo día. El 12 de junio del presente se presentó el cliente a nuestra sucursal argumentando que no se le había pagado. El personal de la sucursal al consultar el dictamen y observar que el estatus dice “Procede reembolso”, duplicó el pago al cliente.Se trata de una pieza de $500.");
        parameters.put("operativo", "");
        parameters.put("operativoAfectacion", "");
        parameters.put("operativoDetalle", "");
        parameters.put("operativo", "X");
        parameters.put("operativoAfectacion", "leve");
        parameters.put("operativoDetalle", "Prueba detalle operativo");
        parameters.put("monetario", "");
        parameters.put("monetarioAfectacion", "");
        parameters.put("monetarioDetalle", "");
        parameters.put("reputacion", "X");
        parameters.put("reputacionAfectacion", "Grave");
        parameters.put("reputacionDetalle", "Prueba detalle reputación");
        parameters.put("salud", "");
        parameters.put("saludAfectacion", "");
        parameters.put("saludDetalle", "");
        parameters.put("medioAmbiente", "");
        parameters.put("medioAfectacion", "");
        parameters.put("medioDetalle", "");
        itextR m = new itextR();
        m.generateReport(parameters);
    }

}
