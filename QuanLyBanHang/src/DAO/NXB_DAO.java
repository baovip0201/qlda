/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.NhaXuatBan;
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
public class NXB_DAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private PreparedStatement ps = null;
    private ResultSet rs= null;
    public List<NhaXuatBan> getList(){
        List<NhaXuatBan> listNxb = new ArrayList<>();
        ConnectDatabase.getConnection();        
        try {
            String sql = "select * from capnhatnxb";
            rs = connect.executeSQL(sql);
            while(rs.next()){
                NhaXuatBan nxb = new NhaXuatBan(rs.getString("maNXB"),
                        rs.getString("tenNXB"),
                        rs.getString("diaChi"),
                        rs.getString("Email"),
                        rs.getString("soDienThoai"));
                listNxb.add(nxb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNxb;
    }
    
    public void insert(NhaXuatBan nxb){
        ConnectDatabase.getConnection();
        String sql = "insert into capnhatnxb(maNXB, tenNXB, diaChi, Email, soDienThoai) "+
                "values(?,?,?,?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1, nxb.getMaNXB());
            ps.setString(2, nxb.getTenNXB());    
            ps.setString(3, nxb.getDiaChi());
            ps.setString(4, nxb.getEmail());
            ps.setString(5, nxb.getSoDienThoai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean testPrimaryKey(String txt){
        String sql="Select * from capnhatnxb where maNXB='"+txt+"'";
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
    
    public void update(NhaXuatBan nxb){
        ConnectDatabase.getConnection();
        String sql = "update capnhatnxb set tenNXB='"+nxb.getTenNXB()+"', diaChi='"+nxb.getDiaChi()+"', Email='"+nxb.getEmail()+"', soDienThoai='"+nxb.getSoDienThoai()+"'"
                +" where maNXB='"+nxb.getMaNXB()+"'";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            int i= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NXB_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void delete(String nxb){
        
        try {
            ConnectDatabase.getConnection();
            //query
            String sql = "delete from capnhatnxb where maNXB = ?";
            ps = ConnectDatabase.connection.prepareCall(sql);            
            ps.setString(1, nxb);            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
}
