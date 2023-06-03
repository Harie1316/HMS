/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import employee.EmployeeDao;
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
@WebServlet(name = "DepartOpt", urlPatterns = {"/DepartOpt"})
public class DepartOpt extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject arr= new JSONObject();
        String id = request.getParameter("id");
       try{
            DepartmentDao dt = new DepartmentDao();
            arr = dt.getDeptById(id);
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
            DepartmentDao dt = new DepartmentDao();
            int a = dt.delDept(id);
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
