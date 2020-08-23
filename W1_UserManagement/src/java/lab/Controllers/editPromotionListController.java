/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.DTOs.DTOpromotion;
import lab.DTOs.errorObj;
import lab.nghiaBean.processBean;

/**
 *
 * @author nhoxq
 */
public class editPromotionListController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "promotion.jsp";
    private static final String FORM = "editPromotion.jsp";

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
            HttpSession session = request.getSession();
            String acion = request.getParameter("action");
            if (acion.equals("Edit Promotion")) {
                String userID = request.getParameter("txtUserID");
                processBean bean = new processBean();
                bean.setUserID(userID);
                DTOpromotion dto = bean.getPromotion();
                session.setAttribute("PROMOTION", dto);
                url = FORM;
            } else if (acion.equals("Edit")) {
                DTOpromotion dto = (DTOpromotion) session.getAttribute("PROMOTION");
                String rank = request.getParameter("txtRank");
                String regex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
                boolean valid = true;
                errorObj err = new errorObj();
                if (Double.parseDouble(rank) > 10 || Double.parseDouble(rank) < 1) {
                    valid = false;
                    err.setRankError("Rank has value from 1 to 10!");
                } else if (rank.matches(regex) == false) {
                    valid = false;
                    err.setRankError("Rank must be number!");
                }

                if (valid) {
                    processBean bean = new processBean();
                    bean.setUserID(dto.getUserID());
                    bean.setRank(rank);
                    boolean check = bean.editPromotion();
                    if (check) {
                        url = SUCCESS;
                        List<DTOpromotion> list = bean.loadPromotionList();
                        request.setAttribute("LIST_PROMO", list);
                        session.removeAttribute("PROMOTION");
                    } else {
                        log("Error at bean edit promo");
                    }
                } else {
                    url = FORM;
                    request.setAttribute("INVALID", err);
                }

            }

        } catch (Exception e) {
            request.setAttribute("ERROR", "Some Thing wrong in remove promotion funtion! Please contact developer.");
            log("Error at removePromotionList: " + e.getMessage());
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
