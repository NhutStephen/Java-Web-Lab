/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.DTOs.DTOuser;
import lab.DTOs.errorObj;
import lab.nghiaBean.processBean;

/**
 *
 * @author nhoxq
 */
public class updateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String FORM = "updateUser.jsp";
    private static final String SUCCESS = "search.jsp";

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
            String action = request.getParameter("action");
            processBean bean = new processBean();
            if (action.equals("Edit User")) {
                String username = request.getParameter("txtUsername");
                log("username = " + username);
                bean.setUsername(username);
                DTOuser user = bean.getUsertoUPdate();
                request.setAttribute("USER", user);
                url = FORM;
            } else if (action.equals("Update User")) {
                String username = request.getParameter("txtUsername");
                String email = request.getParameter("txtEmail");
                String phone = request.getParameter("txtPhone");
                String roleID = request.getParameter("txtRoleID");

                boolean valid = true;
                errorObj err = new errorObj();
                String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                if (email.trim().length() == 0) {
                    err.setEmailError("Email can not be blank!");
                    valid = false;
                } else if (email.matches(regex) == false) {
                    err.setEmailError("Email is not valid!");
                    valid = false;
                }
                String phoneRegex = "^\\d{10}$";
                if (phone.trim().length() == 0) {
                    err.setPhoneError("Phone can not be blank!");
                    valid = false;
                } else if (phone.trim().length() > 13) {
                    err.setPhoneError("Phone length are not valid!");
                    valid = false;
                } else if (phone.matches(phoneRegex) == false) {
                    err.setPhoneError("Phone is not valid!");
                    valid = false;
                }

                if (valid) {
                    bean.setUsername(username);
                    bean.setEmail(email);
                    bean.setPhone(phone);
                    bean.setRoleID(roleID);
                    boolean check = bean.updateUser();
                    if (check) {
                        url = SUCCESS;
                        List<DTOuser> listUser = bean.getAllUser();
                        request.setAttribute("LIST", listUser);
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("ERROR", "Some Thing wrong in Update funtion! Please contact developer.");
            log("Error at updateUserController: " + e.getMessage());
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
            Logger.getLogger(updateController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updateController.class.getName()).log(Level.SEVERE, null, ex);
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
