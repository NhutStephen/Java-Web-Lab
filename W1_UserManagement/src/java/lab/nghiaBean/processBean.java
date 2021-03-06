/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.nghiaBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import lab.DAO.RegistrationDao;
import lab.DTOs.DTOpromotion;
import lab.DTOs.DTOrole;
import lab.DTOs.DTOuser;

public class processBean implements Serializable {

    private String userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String photo;
    private String roleID;
    private String status;
    private String rank;
    private DTOuser user;
    private DTOrole DTOrole;
    private DTOpromotion DTOpromotion;
    
    private String find;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public DTOpromotion getDTOpromotion() {
        return DTOpromotion;
    }

    public void setDTOpromotion(DTOpromotion DTOpromotion) {
        this.DTOpromotion = DTOpromotion;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
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
    
    public DTOuser loadProfile() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.getUserProfile(username);
    }
    
    public List<DTOuser> getAllUser() throws Exception {
        RegistrationDao dao = new RegistrationDao();
        List<DTOuser> listUser = dao.getListUser();
        for (DTOuser dtoUser : listUser) {
            dtoUser.setRole(dao.checkRole(dtoUser.getRoleID()));
            String check = dao.checkAssignPromotion(dtoUser.getUserID());
            if (check == null) {
                dtoUser.setPromotionStatus("Free");
            } else {
                dtoUser.setPromotionStatus("Joining");
            }
        }
        return listUser;
    }
    
/////////////////Search/////////////////////////////////////////////////////////

    public List<DTOuser> findRoleAll() throws Exception {
        RegistrationDao dao = new RegistrationDao();
        List<DTOuser> listUser = dao.findAllRole(find);
        for (DTOuser dtoUser : listUser) {
            dtoUser.setRole(dao.checkRole(dtoUser.getRoleID()));
            String check = dao.checkAssignPromotion(dtoUser.getUserID());
            if (check == null) {
                dtoUser.setPromotionStatus("Free");
            } else {
                dtoUser.setPromotionStatus("Joining");
            }
        }
        return listUser;
    }
    
    public List<DTOuser> findAdmin() throws Exception {
        RegistrationDao dao = new RegistrationDao();
        List<DTOuser> listUser = dao.findAdmin(find);
        for (DTOuser dtoUser : listUser) {
            dtoUser.setRole(dao.checkRole(dtoUser.getRoleID()));
            String check = dao.checkAssignPromotion(dtoUser.getUserID());
            if (check == null) {
                dtoUser.setPromotionStatus("Free");
            } else {
                dtoUser.setPromotionStatus("Joining");
            }
        }
        return listUser;
    }
    
    public List<DTOuser> findUser() throws Exception {
        RegistrationDao dao = new RegistrationDao();
        List<DTOuser> listUser = dao.findUser(find);
        for (DTOuser dtoUser : listUser) {
            dtoUser.setRole(dao.checkRole(dtoUser.getRoleID()));
            String check = dao.checkAssignPromotion(dtoUser.getUserID());
            if (check == null) {
                dtoUser.setPromotionStatus("Free");
            } else {
                dtoUser.setPromotionStatus("Joining");
            }
        }
        return listUser;
    }
    
//////////////////////////////Insert user///////////////////////////////////////
    
    public boolean insertUser() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.insertUser(user);
    }
    
    public boolean addAvatar() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.addAvatar(username, photo);
    }
    
    public boolean checkUserExist() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.checkUserExist(username) != null;
    }
    
////////////////////////////update user/////////////////////////////////////////
    
    public boolean deleteUser() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.deleteUser(username);
    }
    
    public boolean updateUser() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.updateUser(username, email, phone, roleID);
    }
    
    public DTOuser getUsertoUPdate() throws ClassNotFoundException, SQLException {
        RegistrationDao dao = new RegistrationDao();
        return dao.getUsertoUpdate(username);
    }
    
///////////////////////////promotion////////////////////////////////////////////
    
    public boolean assignPromotion() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.assignPromotion(DTOpromotion);
    }
    
    public String takeUserID() throws ClassNotFoundException, SQLException {
        RegistrationDao dao = new RegistrationDao();
        return dao.getUserID(username);
    }
    
    public List<DTOpromotion> loadPromotionList() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        List<DTOpromotion> list = dao.loadPromotionList();
        for (DTOpromotion dto : list) {
            dto.setUsername(dao.takeUsername(dto.getUserID()));
        }
        return list;
    }
    
    public boolean removePromo() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        return dao.removePromotion(userID);
    }
    
    public DTOpromotion getPromotion() throws SQLException, ClassNotFoundException {
        RegistrationDao dao = new RegistrationDao();
        DTOpromotion dto = dao.getPromotion(userID);
        dto.setUsername(dao.takeUsername(userID));
        return dto;
    }
    
    public boolean editPromotion() throws ClassNotFoundException, SQLException {
        RegistrationDao dao = new RegistrationDao();
        return dao.updatePromotion(userID, rank);
    }
}
