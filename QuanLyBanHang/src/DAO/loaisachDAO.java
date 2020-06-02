/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.LoaiSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vukieuanh
 */
public class loaisachDAO {
    public static Connection conn=ConnectDatabase.getConnection();
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    
    public static void them(LoaiSach ls){
        ConnectDatabase.getConnection();
        String sql = "INSERT INTO capnhatloaisach(maLoaiSach,tenLoaiSach)"
                + "VALUES (?,?)";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ls.getMaLoaiSach());
            ps.setString(2, ls.getTenLoaiSach());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
        }
    }
    
    public static void xoa (LoaiSach ls){
        
        String sql = "DELETE FROM capnhatloaisach WHERE maLoaiSach='"+ls.getMaLoaiSach()+"'";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!");
        }
    }
    
    public static void sua(LoaiSach ls){
        
        String sql = "UPDATE capnhatloaisach SET maLoaiSach = '"
                +ls.getMaLoaiSach()+"', tenLoaiSach = '"+ls.getTenLoaiSach()+"'";
        
        try {
            ps= conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!");
        }
    }
    
    //Đọc danh sách loại sách
    public static ArrayList getListLS(){
        ArrayList<LoaiSach> dsls = new ArrayList<>();
        String sql = "SELECT* FROM capnhatloaisach";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                LoaiSach ls = new LoaiSach();
                ls.setMaLoaiSach(rs.getString("maLoaiSach"));
                ls.setTenLoaiSach(rs.getString("tenLoaiSach"));
                dsls.add(ls);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!");
        }
        
        return dsls;
    }
    
    //Combo box cho ten loai sach
    public static ArrayList getListCBB(){
        ArrayList<String> ListOfLS = new ArrayList<>();
        String sql = "SELECT tenLoaiSach from capnhatloaisach";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ListOfLS.add(rs.getString("tenLoaiSach"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(loaisachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListOfLS;
}
    public boolean testPrimaryKey(String txt){
        String sql = "select from capnhatloaisach where maLoaiSach ='"+txt+"'";
        try {
            ps=ConnectDatabase.connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            
        }
        return false;
    }
}
