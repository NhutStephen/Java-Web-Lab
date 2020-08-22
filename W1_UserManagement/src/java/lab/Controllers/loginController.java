/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.DTOs.DTOuser;
import lab.DTOs.errorObj;
import lab.nghiaBean.processBean;

/**
 *
 * @author nhoxq
 */
public class loginController extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String USER = "profile.jsp";
    private static final String ADMIN = "search.jsp";
    private static final String INVALID = "login.jsp";

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean valid = true;
            errorObj err = new errorObj();
            String username = request.getParameter("txtUsername");
            if (username.length() == 0) {
                valid = false;
                err.setUsernameError("Username can not be blank!");
            } else if (username.length() > 25) {
                valid = false;
                err.setUsernameError("Username can not be more than 25 characters!");
            }
            
            String password = request.getParameter("txtPassword");
            if (password.length() == 0) {
                valid = false;
                err.setPasswordError("Password can not be blank!");
            } else if (password.length() < 8) {
                valid = false;
                err.setUsernameError("Password can not be less than 8 characters!");
            }
            
            if (valid) {
                HttpSession session = request.getSession();
                processBean bean = new processBean();
                bean.setUsername(username);
                bean.setPassword(password);
                String role = bean.checkLogin();
                DTOuser welcome = bean.loadProfile();
                if (role.equals("fail")) {
                    request.setAttribute("ERROR", "Wrong username or password");
                } else if (role.equals("admin")) {
                    url = ADMIN;
                    request.setAttribute("WELCOME", "admin");
                } else if (role.equals("sub")) {
                    url = USER;
                    request.setAttribute("WELCOME", welcome);
                } else {
                    request.setAttribute("ERROR", "Wrong username or password");
                }
            } else {
                request.setAttribute("INVALID", err);
            }
        } catch (Exception e) {
            request.setAttribute("ERROR", "Some Thing wrong in Login funtion! Please contact developer.");
            log("Error at login: " + e.getMessage());
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
