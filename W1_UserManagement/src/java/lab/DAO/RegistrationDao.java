/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lab.DButils.MyConnection;
import lab.DTOs.DTOpromotion;
import lab.DTOs.DTOuser;

public class RegistrationDao implements Serializable{
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
     private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }
     
    public DTOuser checkLogin (String username, String password) throws SQLException, Exception{
        DTOuser userCheck = null;
        try {
            String sql = "select roleID, status from TBLuser where username = ? and password = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                userCheck = new DTOuser(roleID, status);
            }
        } finally {
            closeConnection();
        }
        return userCheck;
    }
    
    public String checkRole (String roleID) throws SQLException, Exception {
        String role = "fail";
        try {
            String sql = "select role from TBLrole where roleID = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, roleID);
            rs = stm.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }
    
    public DTOuser getUserProfile (String username) throws SQLException, ClassNotFoundException {
        DTOuser user = null;
        try {
            String sql = "select email, phone, photo from TBLuser where username = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String photo = rs.getString("photo");
                user = new DTOuser(username, email, phone, photo);
            }
        } finally {
            closeConnection();
        }
        return user;
    }
    
    public List<DTOuser> getListUser () throws SQLException, ClassNotFoundException {
        List<DTOuser> listUser = null;
        DTOuser user;
        try {
            String sql = "Select userID, username, email, phone, photo, roleID, status from TBLuser";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                user = new DTOuser(userID, username, email, phone, photo, roleID, status);
                listUser.add(user);
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }
    
    public List<DTOuser> findAllRole(String find) throws ClassNotFoundException, SQLException {
        List<DTOuser> listUser = null;
        DTOuser user;
        try {
            String sql = "Select userID, username, email, phone, photo, roleID, status from TBLuser where username like ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + find + "%");
            rs = stm.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                user = new DTOuser(userID, username, email, phone, photo, roleID, status);
                listUser.add(user);
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }
    
    public List<DTOuser> findAdmin(String find) throws ClassNotFoundException, SQLException {
        List<DTOuser> listUser = null;
        DTOuser user;
        try {
            String sql = "Select userID, username, email, phone, photo, roleID, status from TBLuser where username like ? and roleID = '1'";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + find + "%");
            rs = stm.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                user = new DTOuser(userID, username, email, phone, photo, roleID, status);
                listUser.add(user);
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }
    
    public List<DTOuser> findUser(String find) throws ClassNotFoundException, SQLException {
        List<DTOuser> listUser = null;
        DTOuser user;
        try {
            String sql = "Select userID, username, email, phone, photo, roleID, status from TBLuser where username like ? and roleID = '2'";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + find + "%");
            rs = stm.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String photo = rs.getString("photo");
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                user = new DTOuser(userID, username, email, phone, photo, roleID, status);
                listUser.add(user);
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }

/////////////////////////////insert user////////////////////////////////////////
    
    public boolean insertUser(DTOuser user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "insert into TBluser (username, password, email, phone, photo, roleID, status) values (?,?,?,?,?,?,?)";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getEmail());
            stm.setString(4, user.getPhone());
            stm.setString(5, user.getPhoto());
            stm.setString(6, user.getRoleID());
            stm.setString(7, "active");
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean addAvatar(String username, String avatar) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "update TBLuser set photo = ? where username = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, avatar);
            stm.setString(2, username);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public String checkUserExist (String username) throws SQLException, ClassNotFoundException {
        String check = null;
        try {
            String sql = "select username from TBLuser where username = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                check = rs.getString("username");
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
/////////////////////////////////update user////////////////////////////////////    
    
    public boolean deleteUser (String username) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "update TBLuser set status = 'inactive' where username = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateUser(String username, String email, String phone, String roleID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "update TBluser set email = ?, phone = ?, roleID = ? where username = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, phone);
            stm.setString(3, roleID);
            stm.setString(4, username);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public DTOuser getUsertoUpdate(String username) throws ClassNotFoundException, SQLException {
        DTOuser user = new DTOuser();
        try {
            String sql = "select username, email, phone, roleID from TBLuser where username = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if(rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRoleID(rs.getString("roleID"));
            }
        } finally {
            closeConnection();
        }
        return user;
    }
    
///////////////////////////////////////assign promotion list////////////////////
    
    public boolean assignPromotion(DTOpromotion dtoPromotion) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "insert into TBLpromotion (userID, promotionID, rank, dateAssign, status) values (?,?,?,?,?)";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dtoPromotion.getUserID());
            stm.setString(2, dtoPromotion.getPromotionID());
            stm.setString(3, dtoPromotion.getRank());
            stm.setString(4, dtoPromotion.getDateAssign());
            stm.setString(5, dtoPromotion.getStatus());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public String checkAssignPromotion(String userID) throws SQLException, ClassNotFoundException {
        String check = null;
        try {
            String sql = "select promotionID from TBLpromotion where userID = ? and status = 'joining'";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            rs = stm.executeQuery();
            if (rs.next()) {
                check = rs.getString("promotionID");
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public String getUserID (String username) throws ClassNotFoundException, SQLException {
        String userID = null;
        try {
            String sql = "select userID from TBLuser where username = ? and status = 'active'";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                userID = rs.getString("userID");
            }
        } finally {
            closeConnection();
        }
        return userID;
    }
    
    public boolean removePromotion (String userID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "update TBLpromotion set status = 'removed' where userID = ? and status = 'joining'";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updatePromotion (String userID, String rank) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            String sql = "update TBLpromotion set rank = ? where userID = ? and status = 'joining'";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, rank);
            stm.setString(2, userID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
