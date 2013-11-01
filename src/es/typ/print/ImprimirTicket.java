/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.typ.print;

import es.typ.ticket.TicketData;
import es.typ.utils.Log;
import es.typ.utils.PropertyManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TYP - Takuya Yamaguchi Padilla
 */
public class ImprimirTicket {

    private TicketData ticketData;
    private static boolean dialogJasper = PropertyManager.getInstance().getBooleanProperty("mostrarDialogoTicket", true);

    public ImprimirTicket(TicketData ticketData) {
        this.ticketData = ticketData;
        ArrayList al = new ArrayList();
        al.add(ticketData);
        try {
            //ArrayList ticketsAL = ticket.getTicketDAO().getTickets("", null, null);
            //ArrayList ticketsAL = datosAL;
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/es/TicketEntradas_J2SE/informes/reporte2.jasper"));
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/es/TicketEntradas_J2SE/informes/report2.jasper"));
            //JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(ticketsAL));
            Map parametros = new HashMap();
            //String h = ImprimirTicket.class.getResource("/es/TicketEntradas_J2SE/images/iconoBN_S.png").getPath();
            //String j = h.replaceAll("%20", " ");
            parametros.put("LOGOBN", (new javax.swing.ImageIcon(getClass().getResource("/es/TicketEntradas_J2SE/images/iconoBN_S.png"))).getImage());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(al));
            //JRExporter exporter = new JRPdfExporter();
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte2PDF_2.pdf"));
            //"C:\\Documents and Settings\\User\\Mis documentos\\Takuya\\ticket entradas\\Ticket\\src\\es\\TicketEntradas_J2SE\\images\\iconoBN_S.png"

            //El siguiente código es para mostrar un diálogo con el pdf
            if(dialogJasper){
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/es/TicketEntradas_J2SE/images/icono.png")).getImage());
            jasperViewer.setTitle("Informe");
            jasperViewer.setVisible(true);
            } else{
            //Esto es para imprimir directamente en la impresora predeterminada
            JasperPrintManager.printReport(jasperPrint, false);
            }
        } catch (JRException ex) {
            ex.printStackTrace();
            Log.getInstance().log(ex.getMessage());
        }
    }
}
