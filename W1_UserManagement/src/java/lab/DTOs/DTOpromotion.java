/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.DTOs;

import java.io.Serializable;

public class DTOpromotion implements Serializable{
    private String promotionID;
    private String rank;
    private String dateAssign;
    private String status;
    private String userID;
    private String username;

    public DTOpromotion(String rank, String dateAssign, String status, String userID) {
        this.rank = rank;
        this.dateAssign = dateAssign;
        this.status = status;
        this.userID = userID;
    }

    public DTOpromotion() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(String dateAssign) {
        this.dateAssign = dateAssign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    
    
}
