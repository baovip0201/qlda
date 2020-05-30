/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Phuc
 */
public class ConnectDatabase {
     public static Connection connection;
    public Statement stm=null;
    public ResultSet rs;
    private static String url="";
    private static String host="localhost";
    private static String userName="root";
    private static String password="";
    private static String database="qlbansach";
    
    public ConnectDatabase(String host,String userName, String password,String database){
        this.url=url;
        this.userName=userName;
        this.password=password;
        this.database=database;
        this.host=host;
        this.url="jdbc:mysql://"+host+"/"+database;
    }
    public static synchronized Connection getConnection(){
        if(connection !=null){
            return connection;
        }
        else{           
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url,userName,password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return connection;
    }
    
    public static synchronized void closeConnection(){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                connection=null;
            }
        }         
    }
    
    public ResultSet executeSQL(String sql){
        try{
            stm=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs= stm.executeQuery(sql);
            
        }catch(Exception e){
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return this.rs;
    }
    public int executeUpdate(String sql){
        int res=0;
        try{
            stm=connection.createStatement();
            res= stm.executeUpdate(sql);
        }catch(Exception e){
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return res;
    }

}
