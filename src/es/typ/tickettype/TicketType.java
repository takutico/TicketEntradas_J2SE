/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.typ.tickettype;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Takuya
 */
public class TicketType {

    private TicketTypeDAO ticketTypeDAO = new TicketTypeDAO();
    private TicketTypeData ticketTypeData = new TicketTypeData();

    public TicketTypeDAO getTicketTypeDAO() {
        return ticketTypeDAO;
    }

    public void setTicketTypeDAO(TicketTypeDAO ticketTypeDAO) {
        this.ticketTypeDAO = ticketTypeDAO;
    }

    public void insertTicketType(TicketTypeData ticketTypeData){
        ticketTypeDAO.insertTicket(ticketTypeData);
    }

    public void updateTicketType(TicketTypeData ticketTypeData){
        ticketTypeDAO.updateTicket(ticketTypeData);
    }

    public TicketTypeData getTicketTypeData() {
        return ticketTypeData;
    }

    public void setTicketTypeData(TicketTypeData ticketTypeData) {
        this.ticketTypeData = ticketTypeData;
    }



}
