
package department;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class DepartmentDao {
    Connection conn;
    DatabaseConnection db = new DatabaseConnection();
    
    public DepartmentDao() throws ClassNotFoundException, SQLException{
        conn = db.getConnection();
    }
    
    public int addDept(JSONObject obj) throws SQLException{
        String sql = "insert into dept(deptn,deptdesc) values('"+obj.get("dept")+"','"+obj.get("deptd")+"')";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    public int delDept(String id) throws SQLException{
        String sql = "delete from dept where id="+id+"  ";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    public int updateDept(JSONObject obj,String id) throws SQLException{
        String sql = "update dept set deptn='"+obj.get("dept")+"',deptdesc='"+obj.get("deptd")+"' where id = "+obj.get("id")+" ";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    public JSONArray getDept() throws SQLException{
        String sql = "select *  from dept";
        JSONArray arr = new JSONArray();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            JSONObject obj = new JSONObject();
            obj.put("deptn", rs.getString("deptn"));
            obj.put("deptdesc", rs.getString("deptdesc"));
            obj.put("id", rs.getString("id"));
            arr.add(obj);
        }
        return arr;
    }
    public JSONObject getDeptById(String id) throws SQLException{
        String sql = "select *  from dept where id="+id+" ";
        JSONArray arr = new JSONArray();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        JSONObject obj = new JSONObject();
        while(rs.next()){
            obj.put("deptn", rs.getString("deptn"));
            obj.put("deptdesc", rs.getString("deptdesc"));
            obj.put("id", rs.getString("id"));
        }
        return obj;
    }
}
