/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.typ.ticket;

import es.typ.utils.Log;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Takuya
 */
public class TicketData {
    /*
    idticket integer NOT NULL,
    date character varying(10) NOT NULL,
    "hour" character varying(8) NOT NULL,
    people integer NOT NULL,
    idtype integer NOT NULL,*/

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfhour = new SimpleDateFormat("HH:mm:ss");
    private int idTicket;
    private String dia = sdf.format(new Date());
    private String hora = sdfhour.format(new Date());
    private int numeroEntradas;
    private String total;
    //lo de ticketType deberia ser un objeto
    private int idType;
    private String ticketTypeName = "";
    private String precio;
    private String categoria;
    private int totalNumeroEntradas;
    private String totalTotal;
    private int totalTotalInt;
    private String totalTipoTicket = "";
    private boolean lastPage = false;

    public TicketData() {
        this.numeroEntradas = 0;
        this.idType = 0;
    }

    public TicketData(int numeroEntradas, String ticketTypeName, String dia, String hora) {
        this.numeroEntradas = numeroEntradas;
        this.ticketTypeName = ticketTypeName;
        this.dia = dia;
        this.hora = hora;
    }

    public TicketData(int numeroEntradas, String ticketTypeName, String dia, String hora, String precio) {
        this.numeroEntradas = numeroEntradas;
        this.dia = dia;
        this.hora = hora;
        if(precio.contains(",")){
            precio = precio.replace(",", ".");
        }
        this.precio = precio;
        this.ticketTypeName = ticketTypeName;
    }

    public TicketData(int numeroEntradas, String total, String ticketTypeName, String precio, String categoria, int totalNumeroEntradas, String totalTotal) {
        this.numeroEntradas = numeroEntradas;
        this.total = total;
        this.ticketTypeName = ticketTypeName;
        if(precio.contains(",")){
            precio = precio.replace(",", ".");
        }
        this.precio = precio;
        this.categoria = categoria;
        this.totalNumeroEntradas = totalNumeroEntradas;
        this.totalTotal = totalTotal;
    }

    public TicketData(int numeroEntradas, int idType) {
        this.numeroEntradas = numeroEntradas;
        this.idType = idType;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getTotal() {
        if(precio.contains(",")){
            precio = precio.replace(",", ".");
        }
        try {
            DecimalFormat df = new DecimalFormat("###.##");
            total = df.format(Float.parseFloat(precio) * numeroEntradas);
            if (total.endsWith(".0")) {
                total = total.replace(".0", "");
            }
        } catch (Exception e) {
        }
        if (total == null || total.equals("")) {
            total = "0";
        }
        if(total.contains(",")){
            total = total.replace(",", ".");
        }
        return total;
    }

    public void setTotal(String total) {
        if(total.contains(",")){
            total = total.replace(",", ".");
        }
        this.total = total;
    }

    public String getPrecio() {
        if (precio == null || precio.equals("")) {
            precio = "0";
        }
        return precio;
    }

    public void setPrecio(String precio) {
        if (precio.contains(",")) {
            precio = precio.replace(",", ".");
        }
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTotalTotal() {
        if(totalTotal.contains(",")){
            totalTotal = totalTotal.replace(",", ".");
        }
        return totalTotal;
    }

    public void setTotalTotal(String totalTotal) {
        if(totalTotal.contains(",")){
            totalTotal = totalTotal.replace(",", ".");
        }
        this.totalTotal = totalTotal;
    }

    public int getTotalNumeroEntradas() {
        return totalNumeroEntradas;
    }

    public void setTotalNumeroEntradas(int totalNumeroEntradas) {
        this.totalNumeroEntradas = totalNumeroEntradas;
    }

    public String getTotalTipoTicket() {
        if(totalTipoTicket == null || totalTipoTicket.equals("")){
            totalTipoTicket = "0";
        }
        return totalTipoTicket;
    }

    public void setTotalTipoTicket(String totalTipoTicket) {
        if(totalTipoTicket.contains(",")){
            totalTipoTicket = totalTipoTicket.replace(",", ".");
        }
        this.totalTipoTicket = totalTipoTicket;
    }

    public void sumarTotalTipoTicket(String numero){
        try{
        if(getTotal().contains(",")){
            setTotal(getTotal().replace(",", "."));
        }
        if(this.totalTipoTicket.contains(",")){
            setTotalTipoTicket(this.totalTipoTicket.replace(",", "."));
        }
        if(numero.contains(",")){
            numero = numero.replace(",", ".");
        }
        //this.totalTipoTicket = Float.parseFloat(this.totalTipoTicket) + Float.parseFloat(getTotal()) + "";
        this.totalTipoTicket = Float.parseFloat(numero) + Float.parseFloat(getTotal()) + "";
        } catch (Exception e){
            Log.getInstance().log(e.getMessage());
        }
    }

    public void sumarTotalNumeroEntradas(int numeroEntradas){
        this.totalNumeroEntradas = numeroEntradas + this.numeroEntradas;
    }

    public int getTotalTotalInt() {
        return totalTotalInt;
    }

    public void setTotalTotalInt(int totalTotalInt) {
        this.totalTotalInt = totalTotalInt;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
