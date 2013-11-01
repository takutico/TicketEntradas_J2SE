/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.typ.ticket;

/**
 *
 * @author Takuya
 */
public class Ticket {

    private TicketDAO ticketDAO = new TicketDAO();
    private TicketData ticketData = new TicketData();

    public void getTickets(String fechaInicio, String fechaFin, String tipoTicket){
        ticketDAO.getTickets(fechaInicio, fechaFin, tipoTicket);
    }

    public void insertTicket(TicketData ticketData){
        ticketDAO.insertTicket(ticketData);
    }

    public TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public TicketData getTicketData() {
        return ticketData;
    }

    public void setTicketData(TicketData ticketData) {
        this.ticketData = ticketData;
    }

}
