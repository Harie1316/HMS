package login;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONObject;

public class LoginDao {
    Connection conn;
    DatabaseConnection db = new DatabaseConnection();
    public LoginDao() throws ClassNotFoundException, SQLException{
        conn = db.getConnection();
    }
    
    public JSONObject loginUser(String uname,String pass) throws SQLException{
        String sql = "SELECT * FROM employee where uname='"+uname+"' and password='"+pass+"' ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        JSONObject obj = new JSONObject();
        while(rs.next()){
            obj.put("username", rs.getString("uname"));
            obj.put("email", rs.getString("email"));
            obj.put("role", rs.getString("role"));
            obj.put("phone", rs.getString("phone"));
            obj.put("id", rs.getString("id"));
        }
        
        return obj;
    }
}
