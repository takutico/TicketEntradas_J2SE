/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.typ.print;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Takuya
 */
public class Impresora {
    //Atributos

    /*Font fuente = new Font("Lucida Console", Font.PLAIN, 10);
    PrintJob pj;
    Graphics pagina;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat sdfhour = new SimpleDateFormat("hh:mm:ss");

    //Constructores
	/*Impresora()
    {
    pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);

    }*/
    /**
     *Método para imprimir los ticket, al que se le pasan las líneas
     */
    /*public Impresora(List lista2, String desde, String hasta) {
        //Connection conn=null;
        //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
        try {

            int margenIzqdo = 20; // Posición X de cada línea
            int margenSup = 10;   // Posición Y de la primera línea
            int pasoLinea = 10;   // Incremento o salto entre líneas
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.WHITE);
            String fechaHora = sdf.format(new Date()) + " " + sdfhour.format(new Date());

            pagina.drawString("Arqueo diario", margenIzqdo, margenSup += pasoLinea + 4);
            pagina.drawString(fechaHora, margenIzqdo, margenSup += pasoLinea + pasoLinea);

            pagina.drawString("                    Visitantes          Importe", 30, margenSup += pasoLinea);

            pagina.drawString("Guagua turística            50               35", 30, margenSup += pasoLinea);
            pagina.drawString("General                     50               35", 30, margenSup += pasoLinea);
            pagina.drawString("Agencias                    50               35", 30, margenSup += pasoLinea);
            pagina.drawString("Turista                     50               35", 30, margenSup += pasoLinea);
            pagina.drawString("Estudiante                  50               35", 30, margenSup += pasoLinea);

            //pagina.drawString(desde.substring(8)+desde.substring(4,8)+desde.substring(0,4)+"   "+hasta.substring(8)+hasta.substring(4,8)+hasta.substring(0,4),30,margenSup += pasoLinea);
            //pagina.drawString("", 30, margenSup += pasoLinea);
            //pagina.drawString("Código   hora   camarero   total", 30, margenSup += pasoLinea);

            Iterator it = lista2.iterator();
            float tot = 0;
            //conn=BDConex.obtenerConexion();
            int cont = 0;
            /*if(it.hasNext())
            {
            while(it.hasNext())
            {
            Cuenta cuen = (Cuenta) it.next();
            CUsuarios BDUsu=new CUsuarios(conn);
            String cadLista="  "+cuen.getIdcuenta()+"        "+cuen.getHora()+"  "+BDUsu.tomarNombre(cuen.getIdusuario())+"    "+cuen.getTotal();

            pagina.drawString(cadLista,30,margenSup += pasoLinea );

            tot=tot+cuen.getTotal();
            }
            pagina.drawString(" ",30,margenSup += pasoLinea );
            pagina.drawString("          TOTAL:    "+tot,30,margenSup += pasoLinea );

            }   */

            /*pagina.dispose();
            pj.end();


        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}
