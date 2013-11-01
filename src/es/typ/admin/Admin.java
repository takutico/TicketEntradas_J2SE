package es.typ.admin;

import javax.swing.JOptionPane;

/**
 *
 * @author TYP - Takuya Yamaguchi Padilla
 */
public class Admin {

    private AdminDAO adminDAO = new AdminDAO();
    private AdminData adminData = new AdminData("","");

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public AdminData getAdminData() {
        return adminData;
    }

    public void setAdminData(AdminData adminData) {
        this.adminData = adminData;
    }

    public int loginAdmin(AdminData admindata){
        this.adminData = admindata;
        return adminDAO.loginAdmin(adminData);
    }

}
