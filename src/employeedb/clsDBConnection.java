/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedb;

/**
 *
 * @author steve
 */
import java.sql.*;
public class clsDBConnection {
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?user=root&password=28!uk8@uf2843");
            System.out.println("Connection with MySQL successful");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        return con;
    }
    }
