/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.LoaiSach;
import java.awt.Component;
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
 * @author Thanh Phuc
 */
public class LoaiSachDAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private PreparedStatement ps = null;
    private ResultSet rs= null;
                Component cmpnt;

    public List<LoaiSach> getList(){
        List<LoaiSach> listLS = new ArrayList<>();
        ConnectDatabase.getConnection();        
        try {
            String sql = "select * from capnhatloaisach";
            rs = connect.executeSQL(sql);
            while(rs.next()){
                LoaiSach sach = new LoaiSach(rs.getString("maLoaiSach"),
                        rs.getString("tenLoaiSach"));
                listLS.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLS;
    }
    
    public void insert(LoaiSach ls){
        ConnectDatabase.getConnection();
        String sql = "insert into capnhatloaisach(maLoaiSach, tenLoaiSach) "+
                "values(?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1, ls.getMaLoaiSach());
            ps.setString(2, ls.getTenLoaiSach());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean testPrimaryKey(String txt){
        String sql="Select * from capnhatloaisach where maLoaiSach='"+txt+"'";
        try {
            ps=ConnectDatabase.connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }
    
    public void update(LoaiSach ls){
        ConnectDatabase.getConnection();
        String sql="update capnhatloaisach set tenLoaiSach= '"+ls.getTenLoaiSach()+"' where maLoaiSach= '"+ls.getMaLoaiSach()+"'";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            int i= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String ls){
        ConnectDatabase.getConnection();
        String sql = "delete from capnhatloaisach where maLoaiSach= ?";
        try {
            ps =ConnectDatabase.connection.prepareCall(sql);
            ps.setString(1, ls);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(cmpnt, "Không thể xóa vì loại sách tồn tại trong sách");
        }
    }
}
