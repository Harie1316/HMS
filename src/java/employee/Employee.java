/*
    Employee Model
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


@WebServlet(name = "Employee", urlPatterns = {"/Employee"})
public class Employee extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONArray arr=  new JSONArray();
        try{
            EmployeeDao ed = new EmployeeDao();
            arr = ed.showEmployee();
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
        
        JSONObject obj = new JSONObject();
        obj.put("name", request.getParameter("name"));
        obj.put("age", Integer.parseInt(request.getParameter("age")));
        obj.put("gender", request.getParameter("gender"));
        obj.put("email", request.getParameter("email"));
        obj.put("phone", request.getParameter("phone"));
        obj.put("address", request.getParameter("address"));
        obj.put("password", request.getParameter("password"));
        obj.put("role", request.getParameter("role"));
        obj.put("dept", request.getParameter("dept"));
        obj.put("uname", request.getParameter("uname"));
        obj.put("id", request.getParameter("id"));
        if(request.getParameter("id").equals(null)||request.getParameter("id").equals("")||request.getParameter("id").equals("null")){
            try{
                EmployeeDao ed = new EmployeeDao();
                int a = ed.addEmployee(obj);
                if(a==1){
                    out.print("Record added");
                }else{
                    out.print("Error");
                }
            }catch(Exception e){
                    System.out.println(e);
            }
        }else{
            try{
                EmployeeDao ed = new EmployeeDao();
                int a = ed.updateEmployee(obj,request.getParameter("id"));
                if(a==1){
                    out.print("Record Updated");
                }else{
                    out.print("Error");
                }
            }catch(Exception e){
                    System.out.println(e);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
