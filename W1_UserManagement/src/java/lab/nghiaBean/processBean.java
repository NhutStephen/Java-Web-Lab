/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.nghiaBean;

import java.io.Serializable;
import lab.DTOs.DTOrole;
import lab.DTOs.DTOstatus;
import lab.DTOs.DTOuser;

/**
 *
 * @author nhoxq
 */
public class processBean implements Serializable{
    private String username;
    private String password;
    private String email;
    private String phone;
    private String photo;
    private String role;
    private String status;
    private DTOuser user;
    private DTOrole DTOrole;
    private DTOstatus DTOstatus;
}
