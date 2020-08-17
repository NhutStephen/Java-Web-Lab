/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.DTOs;

import java.io.Serializable;

/**
 *
 * @author nhoxq
 */
public class DTOuser implements Serializable{
    private String username;
    private String password;
    private String email;
    private String phone;
    private String photo;
    private String role;
    private String status;

    public DTOuser(String username, String password, String email, String phone, String photo, String role, String status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.role = role;
        this.status = status;
    }

    public DTOuser(String role, String status) {
        this.role = role;
        this.status = status;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
   
}