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
import lab.DButils.MyConnection;
import lab.DTOs.DTOuser;

/**
 *
 * @author nhoxq
 */
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
    
    public DTOuser getUserProfile (String userID) throws SQLException {
        DTOuser user = null;
        try {
            String sql = "select username, email, phone, photo from TBLuser where userID = ?";
        } finally {
            closeConnection();
        }
        return user;
    }
}
