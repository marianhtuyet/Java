/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexam;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author MyPC
 */
public class dbconnect {
public static Connection connection;
	 public static Connection ConnectDB() {
		 try
			{
                            
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 connection = DriverManager.getConnection("jdbc:sqlserver://Localhost:1433;databaseName=QuanLyGaraxe;user=sa;password=1234");
				return connection;
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
	 }
          public static int dbExcuteQuery(String sql) throws SQLException{
        Statement stmt = null;
        int i = 0;
        try {
            ConnectDB();
            stmt = connection.createStatement();
              i = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Thông báo");
            alert1.setHeaderText("");
            alert1.setContentText(e.getMessage());
            alert1.show();
            System.out.print(e);
            System.out.print("Can't execute update!");
        }
       dbDisconnect();
       return i;
        }
    public static void dbDisconnect() throws SQLException{
       
        try {
            if(connection != null )
            {
                
                connection.close();
            }
            
        } catch (Exception e) {
                throw e;
        }

        
    }
    public static ResultSet dbExcute(String sql) throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;
        try {
            ConnectDB();
            stmt = connection.createStatement();
              rs =  stmt.executeQuery(sql);
              crs = new CachedRowSetImpl();
              crs.populate(rs);
        } catch (SQLException e) {
            System.out.print(e);
            System.out.print("Can't execute!");
        }
       dbDisconnect();
       return crs;
        }
    
}
