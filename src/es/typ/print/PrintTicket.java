/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.typ.print;

import es.typ.ticket.TicketData;
import es.typ.utils.Log;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author TYP - Takuya Yamaguchi Padilla
 */
public class PrintTicket {

    Font fuente10 = new Font("Tahoma", Font.PLAIN, 10);
    Font fuente14 = new Font("Tahoma", Font.PLAIN, 14);
    Font fuente18 = new Font("Tahoma", Font.BOLD, 18);
    PrintJob pj;
    Graphics pagina;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdfHr = new SimpleDateFormat("HH:MM:SS");
    int x = 100;
    int y = 100;
    int incrementoy = 20;
    int xTotal = 200;

    public PrintTicket() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    }

    public void imprimirTicket(TicketData ticketData) {
        //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        try {
            String cc = "ticket entradas";
            String CIF = "C.I.F. G-35032150";
            String tipoTicket;
            String total;
            String fecha = sdf.format(new Date());
            String hora = sdfHr.format(new Date());
            String saludo_es = "Bienvenido";
            String saludo_en = "Welcome";
            String saludo_gr = "Willkommen";

            pagina = pj.getGraphics();
            pagina.setFont(fuente14);
            pagina.setColor(Color.black);

            //pagina.drawString(Cadena, x, y);

            pagina.drawImage((new javax.swing.ImageIcon(getClass().getResource("/es/TicketEntradas_J2SE/images/iconoBN_S.png"))).getImage(),
                    100, 20, 40, 60, null);
            pagina.drawString(cc, x - cc.length()/2 - 15, y += incrementoy);
            pagina.setFont(fuente10);
            pagina.drawString(CIF, x - CIF.length()/2, y += incrementoy);
            y += (incrementoy * 2);
            pagina.setFont(fuente18);
            total = ticketData.getTotal() + "€";
            pagina.drawString(total, x - total.length()/2, y += incrementoy);
            pagina.setFont(fuente10);
            y += (incrementoy * 2);
            pagina.drawString(fecha, x - fecha.length()/2, y += incrementoy);
            pagina.drawString(hora, x - hora.length()/2, y += incrementoy);
            y += (incrementoy);
            pagina.drawString(saludo_es, 30, y);
            pagina.drawString(saludo_en, x - saludo_en.length()/2, y);
            pagina.drawString(saludo_gr, 170 - saludo_gr.length(), y);

            //tipoTicket = ticketData.getTicketTypeName();
            
            //pagina.drawString(tipoTicket, x, y += incrementoy);


            pagina.dispose();
            pj.end();
        } catch (Exception e) {
            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
            Log.getInstance().log(e.getMessage());
        }
    }//FIN DEL PROCEDIMIENTO imprimir(String...)
}


