/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.nghiaBean;

import java.io.Serializable;
import lab.DAO.RegistrationDao;
import lab.DTOs.DTOrole;
import lab.DTOs.DTOstatus;
import lab.DTOs.DTOuser;

/**
 *
 * @author nhoxq
 */
public class processBean implements Serializable {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String photo;
    private String roleID;
    private String statusID;
    private DTOuser user;
    private DTOrole DTOrole;
    private DTOstatus DTOstatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public DTOuser getUser() {
        return user;
    }

    public void setUser(DTOuser user) {
        this.user = user;
    }

    public DTOrole getDTOrole() {
        return DTOrole;
    }

    public void setDTOrole(DTOrole DTOrole) {
        this.DTOrole = DTOrole;
    }

    public DTOstatus getDTOstatus() {
        return DTOstatus;
    }

    public void setDTOstatus(DTOstatus DTOstatus) {
        this.DTOstatus = DTOstatus;
    }

///////////////////Process//////////////////////////////////////////////////////
    public String checkLogin() throws Exception {
        RegistrationDao dao = new RegistrationDao();
        DTOuser roleUser = dao.checkLogin(username, password);
        String role = "fail";
        if (roleUser != null) {
            String status = roleUser.getStatus();
            if (status.equals("active")) {
                role = dao.checkRole(roleUser.getRoleID());
            }
        }
        return role;
    }
}
