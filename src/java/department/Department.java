/*
    Department Model
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
@WebServlet(name = "Department", urlPatterns = {"/Department"})
public class Department extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       JSONArray arr= new JSONArray();
       try{
            DepartmentDao dt = new DepartmentDao();
            arr = dt.getDept();
            out.print(arr);
        }catch(Exception e){
                System.out.println(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("id", request.getParameter("id"));
        obj.put("dept", request.getParameter("dept"));
        obj.put("deptd", request.getParameter("deptd"));
        if(request.getParameter("id").equals(null)||request.getParameter("id").equals("")||request.getParameter("id").equals("null")){
            try{
                DepartmentDao dt = new DepartmentDao();
                int a = dt.addDept(obj);
                if(a!=0){
                    out.print("Data Added");
                }else{
                    out.print("Error");
                }
            }catch(Exception e){
                    System.out.println(e);
            }
        }else{
            try{
                DepartmentDao dt = new DepartmentDao();
                int a = dt.updateDept(obj,request.getParameter("id"));
                if(a!=0){
                    out.print("Data Updated");
                }else{
                    out.print("Error");
                }
            }catch(Exception e){
                    System.out.println(e);
            }
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
