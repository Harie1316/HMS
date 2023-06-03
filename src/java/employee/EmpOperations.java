/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Ruler
 */
@WebServlet(name = "EmpOperations", urlPatterns = {"/EmpOperations"})
public class EmpOperations extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject arr=  new JSONObject();
        String id = request.getParameter("id");
        try{
            EmployeeDao ed = new EmployeeDao();
            arr = ed.showEmployeeById(id);
            System.out.println(arr);
            out.print(arr);
        }catch(Exception e){
            System.out.println(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       String id = request.getParameter("id");
       try{
            EmployeeDao ed = new EmployeeDao();
            int a = ed.deleteEmployee(id);
            if(a==1){
                out.print("Deleted");
            }

        }catch(Exception e){
            out.print("Error");
            System.out.println(e);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
