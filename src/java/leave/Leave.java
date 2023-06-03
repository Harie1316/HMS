/*
    Leave Model
*/
package leave;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet(name = "Leave", urlPatterns = {"/Leave"})
public class Leave extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String role = request.getParameter("role");
        
        
            
            try{
                LeaveDao ld = new LeaveDao();
                JSONArray a = ld.showEmployeeById(id,role);
               
                out.print(a);
           
                
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
        obj.put("name", request.getParameter("name"));
        obj.put("email", request.getParameter("email"));
        obj.put("phone", request.getParameter("phone"));
        obj.put("leave", request.getParameter("leave"));
        obj.put("sdate", request.getParameter("sdate"));
        obj.put("edate", request.getParameter("edate"));
        obj.put("reason", request.getParameter("reason"));
        try{
            LeaveDao ld = new LeaveDao();
            int a = ld.saveLeave(obj);
            if(a==0){
                out.print("Error");
            }else{
                out.print("Save");
            }
        }catch(Exception e){
                System.out.println(e);
            }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
