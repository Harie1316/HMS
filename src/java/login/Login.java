
package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("uname"); 
        String password = request.getParameter("pass"); 
        JSONObject obj = null;

        try{
            LoginDao db = new LoginDao();
            obj = new JSONObject();
            obj = db.loginUser(username, password);
            if(obj!=null){
                out.print(obj); 
            }else{
                out.print("Invalid");
            }
            
        }catch(ClassNotFoundException | SQLException e){
            out.print("Invalid Cridential" );      
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
