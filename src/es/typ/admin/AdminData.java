package es.typ.admin;

/**
 *
 * @author TYP - Takuya Yamaguchi Padilla
 */
public class AdminData {

    private String adminLogin;
    private String adminPass;

    public AdminData(String adminLogin, String adminPass) {
        this.adminLogin = adminLogin;
        this.adminPass = adminPass;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }


}
