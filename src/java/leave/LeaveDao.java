
package leave;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class LeaveDao {
    Connection conn;
    DatabaseConnection db = new DatabaseConnection();
    
    public LeaveDao() throws ClassNotFoundException, SQLException{
        conn = db.getConnection();
    }
    
    public int saveLeave(JSONObject obj) throws SQLException{

        String sql =    "insert into empleave(empid,uname,uemail,uphone,leavetype,start_date,end_date,reason) \n" +
                        "values('"+obj.get("id")+"','"+obj.get("name")+"','"+obj.get("email")+"','"+obj.get("phone")+"'"
                        + ",'"+obj.get("leave")+"','"+obj.get("sdate")+"','"+obj.get("edate")+"','"+obj.get("reason")+"')";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    public JSONArray showEmployeeById(String id,String role) throws SQLException{
        JSONArray arr = new JSONArray();
        if(role.equals("ADMIN")){
            String sql = "select * from employee inner join empleave on employee.id =  empleave.empid ";
                        
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getString("id"));
                obj.put("lid", rs.getString("lid"));
                obj.put("name", rs.getString("name"));
                obj.put("uname", rs.getString("uname"));
                obj.put("uemail", rs.getString("uemail"));
                obj.put("uphone", rs.getString("uphone"));
                obj.put("leavetype", rs.getString("leavetype"));
                obj.put("leavetype", rs.getString("leavetype"));
                obj.put("start_date", rs.getString("start_date"));
                obj.put("end_date", rs.getString("end_date"));
                obj.put("reason", rs.getString("reason"));
                obj.put("status", rs.getString("status"));
                arr.add(obj);
            }
             return arr;
        }else{
            String sql = "select * from employee inner join empleave on employee.id =  empleave.empid \n" +
                        "where employee.id="+id+" ";
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getString("id"));
                obj.put("lid", rs.getString("lid"));
                obj.put("name", rs.getString("name"));
                obj.put("uname", rs.getString("uname"));
                obj.put("uemail", rs.getString("uemail"));
                obj.put("uphone", rs.getString("uphone"));
                obj.put("leavetype", rs.getString("leavetype"));
                obj.put("leavetype", rs.getString("leavetype"));
                obj.put("start_date", rs.getString("start_date"));
                obj.put("end_date", rs.getString("end_date"));
                obj.put("reason", rs.getString("reason"));
                obj.put("status", rs.getString("status"));
                arr.add(obj);
            }
             return arr;
        }
       
    }

    public int approLeave(String id) throws SQLException{

        String sql ="update empleave set status ='Approved' where lid="+id+" ";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    public int approNotLeave(String id) throws SQLException{

        String sql ="update empleave set status ='Not Approved' where lid="+id+" ";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }

    
}
