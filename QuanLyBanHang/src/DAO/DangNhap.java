/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import GUI.Admin_Frame;
import DTO.TaiKhoan;
import GUI.User_Frame;
import java.awt.Component;
import DB.ConnectDatabase;

/**
 *
 * @author Thanh Phuc
 */
public class DangNhap{
    private static final ConnectDatabase connect = new ConnectDatabase("localhost","root","","qlbansach");
    private Component rootPane;
    public DangNhap(){
        ConnectDatabase.getConnection();
    }
     public  void DNhap(String user,String password){
         PreparedStatement stm = null;
         PreparedStatement stm2 = null;
         boolean check=false;
         try {
             
             String sql = "select * from qltaikhoan where tenDN=? and matKhau=? and loaiTK='admin'";//admin
             String sql2= "select * from qltaikhoan where tenDN=? and matKhau=? and loaiTK='user'";//user
             stm= ConnectDatabase.connection.prepareCall(sql);
             stm.setString(1, user);
             stm.setString(2, password);
             
             stm2= ConnectDatabase.connection.prepareCall(sql2);
             stm2.setString(1, user);
             stm2.setString(2, password);
             
             ResultSet rs = stm.executeQuery();
             ResultSet rs2 = stm2.executeQuery();
         
             if(rs.next()){                 
                 
                 JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công.");
                 Admin_Frame DN_admin = new Admin_Frame();
                 DN_admin.setVisible(true);
                 
             }
             else if(rs2.next()){
                 JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công.");
                 User_Frame DN_user = new User_Frame();
                 DN_user.setVisible(true);
         }
             else{
                JOptionPane.showMessageDialog(rootPane, "Thông tin đăng nhập sai."); 
             }
         } catch (SQLException ex) {
             Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            if(connect != null){
                    connect.closeConnection();
                
            }      
        }     
     }
    public String comparePassword(String pass) {
                try {        
            //Query( truy van )
            String sql = "select * from qltaikhoan";
            ResultSet resultSet = connect.executeSQL(sql);
            //con tro tra ve du lieu truy van
            if (resultSet.next()) {              
                pass = resultSet.getString("matKhau");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "lỗi");
        } finally {
            if (connect != null) {
                    connect.closeConnection();
               
                }
            }
        return pass;
    }
     public void DoiMatKhau(String tk,String pass) {         
        Statement stm=null;
        TaiKhoan tentk = new TaiKhoan();
        try {
            //Lay tat ca danh sach sinh vien
                    ConnectDatabase.getConnection();
            //Query( truy van )
            stm = ConnectDatabase.connection.createStatement();
            String sql="update qltaikhoan  set matKhau= '"+pass+"' where tenDN= '"+tk+"'";            
            int rs = stm.executeUpdate(sql);                   
        } catch (SQLException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connect != null) {
                connect.closeConnection();
            }
        }
     }

}
