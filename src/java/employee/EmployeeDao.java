/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class EmployeeDao {

    Connection conn;
    DatabaseConnection db = new DatabaseConnection();
    
    public EmployeeDao() throws ClassNotFoundException, SQLException{
        conn = db.getConnection();
    }
    
    public int updateEmployee(JSONObject obj,String id) throws SQLException{
        String sql ="UPDATE employee SET "
                + "name='"+obj.get("name")+"',email='"+obj.get("email")+"',gender='"+obj.get("gender")+"',age="+obj.get("age")+","
                + "phone='"+obj.get("phone")+"',address='"+obj.get("address")+"',role='"+obj.get("role")+"'"
                + ",password='"+obj.get("password")+"',department="+obj.get("dept")+",uname='"+obj.get("uname")+"' where id="+obj.get("id")+"";
        
       
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    public int deleteEmployee(String id) throws SQLException{
        String sql ="delete from employee where id="+id+" ";
       
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    
    public int addEmployee(JSONObject obj) throws SQLException{
        String sql = "insert into employee (name, email, gender, age, phone, address, role, password, department, uname) "
                + "values('"+obj.get("name")+"','"+obj.get("email")+"','"+obj.get("gender")+"',"+obj.get("age")+""
                + ",'"+obj.get("phone")+"','"+obj.get("address")+"','"+obj.get("role")+"','"+obj.get("password")+"',"+obj.get("dept")+",'"+obj.get("uname")+"')";
        Statement stmt = conn.createStatement();
        int a = stmt.executeUpdate(sql);
        return a;
    }
    
    public JSONArray showEmployee() throws SQLException{
        String sql = "select * from employee inner join dept on employee.department=dept.id ";
        JSONArray arr = new JSONArray();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            JSONObject obj = new JSONObject();
            obj.put("name", rs.getString("name"));
            obj.put("id", rs.getString("id"));
            obj.put("age", rs.getString("age"));
            obj.put("gender", rs.getString("gender"));
            obj.put("email", rs.getString("email"));
            obj.put("phone", rs.getString("phone"));
            obj.put("address", rs.getString("address"));
            obj.put("role", rs.getString("role"));
            obj.put("deartment", rs.getString("deptn"));
            obj.put("uname", rs.getString("uname"));
            
            arr.add(obj);
        }
        return arr;
    }
    
    public JSONObject showEmployeeById(String id) throws SQLException{
        String sql = "select * from employee inner join empleave on employee.id =  empleave.empid \n" +
                        "where employee.id="+id+" ";
        JSONArray arr = new JSONArray();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        JSONObject obj = new JSONObject();
        while(rs.next()){
            
            obj.put("name", rs.getString("name"));
            obj.put("id", rs.getString("id"));
            obj.put("age", rs.getString("age"));
            obj.put("gender", rs.getString("gender"));
            obj.put("email", rs.getString("email"));
            obj.put("phone", rs.getString("phone"));
            obj.put("address", rs.getString("address"));
            obj.put("role", rs.getString("role"));
            obj.put("deartment", rs.getString("department"));
            obj.put("uname", rs.getString("uname"));
            obj.put("password", rs.getString("password"));
            
        }
        return obj;
    }
    
    
}
