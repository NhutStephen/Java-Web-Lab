/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.DTOs.DTOuser;
import lab.DTOs.errorObj;
import lab.nghiaBean.processBean;

public class insertController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "insert.jsp";
    private static final String SUCCESS = "addAvatar.jsp";

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        

        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String roleID = request.getParameter("txtRoleID");
            String avatar = "image/person.jpg";
            
            processBean bean = new processBean();
            bean.setUsername(username);
                    
            errorObj err = new errorObj();
            boolean valid = true;

            if (username.trim().length() == 0) {
                err.setUsernameError("Username can not be blank!");
                valid = false;
            } else if (bean.checkUserExist()) {
                err.setUsernameError("Username is existed!");
                valid = false;
            }
            if (password.trim().length() == 0) {
                err.setPasswordError("Password can not be blank!");
                valid = false;
            } else if (password.trim().length() < 8 || password.trim().length() > 40) {
                err.setPasswordError("Use 8 - 40 characters for your password.");
                valid = false;
            }
            if (confirm.trim().length() == 0) {
                err.setConfirmError("Confirm can not be blank!");
                valid = false;
            } else if (!confirm.equals(password)) {
                err.setConfirmError("Those password didn't match.Try again.");
                valid = false;
            }
            if (email.trim().length() == 0) {
                err.setEmailError("Email can not be blank!");
                valid = false;
            }
            if (phone.trim().length() == 0) {
                err.setPhoneError("Phone can not be blank!");
                valid = false;
            }

            if (valid) {
                //add into user obj
                DTOuser user = new DTOuser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.setPhone(phone);
                user.setPhoto(avatar);
                user.setRoleID(roleID);

                
                bean.setUser(user);
                boolean check = bean.insertUser();

                if (check) {
                    url = SUCCESS;
                    HttpSession session = request.getSession();
                    session.setAttribute("USERNAME", username);
                }
            } else {
                request.setAttribute("INVALID", err);
                url = INVALID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            if (e.getMessage().contains("duplicate")) {
                errorObj err = new errorObj();
                err.setUsernameError("Username is exited!");
                request.setAttribute("INVALID", err);
                url = INVALID;
            } else {
                request.setAttribute("ERROR", "Some Thing wrong in insert user funtion! Please contact developer.");
                log("Error at insertUserController: " + e.getMessage());
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
