/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.DTOs;

/**
 *
 * @author nhoxq
 */
public class errorObj {
    private String usernameError, passwordError, emailError, phoneError, photoError, limitPromotionError, confirmError;

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getPhotoError() {
        return photoError;
    }

    public void setPhotoError(String photoError) {
        this.photoError = photoError;
    }

    public String getLimitPromotionError() {
        return limitPromotionError;
    }

    public void setLimitPromotionError(String limitPromotionError) {
        this.limitPromotionError = limitPromotionError;
    }
    
}
