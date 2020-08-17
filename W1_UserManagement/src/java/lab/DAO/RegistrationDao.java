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
     
    private DTOuser checkLogin (String username, String password) throws SQLException, Exception{
        DTOuser userCheck = null;
        try {
            String sql = "select roleID, statusID from user where username = ? and password = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                String role = rs.getString("roleID");
                String status = rs.getString("statusID");
                userCheck = new DTOuser(role, status);
            }
        } finally {
            closeConnection();
        }
        return userCheck;
    }
    
    private String checkRole (String roleID) throws SQLException, Exception {
        String role = "fail";
        try {
            String sql = "select role from role where roleID = ?";
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
    
    private String checkStatus (String statusID) throws SQLException, Exception {
        String status = "fail";
        try {
            String sql = "select status from status where statusID = ?";
            con = MyConnection.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, statusID);
            rs = stm.executeQuery();
            if (rs.next()) {
                status = rs.getString("status");
            }
        } finally {
            closeConnection();
        }
        return status;
    }
}
