/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leave;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ruler
 */
@WebServlet(name = "LeaveUpdate", urlPatterns = {"/LeaveUpdate"})
public class LeaveUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String perm = request.getParameter("perm");
        if(perm.equals("Yes")){
            try {
                LeaveDao ld = new LeaveDao();
                int a = ld.approLeave(id);
                if(a==1){
                    out.print("Change");
                }else{
                    out.print("Error");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LeaveUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LeaveUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             try {
                LeaveDao ld = new LeaveDao();
                int a = ld.approNotLeave(id);
                if(a==1){
                    out.print("Change");
                }else{
                    out.print("Error");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LeaveUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LeaveUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
