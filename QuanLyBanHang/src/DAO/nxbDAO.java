/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.NhaXuatBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vukieuanh
 */
public class nxbDAO {
    public static Connection conn=ConnectDatabase.getConnection();
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    
    public static void them(NhaXuatBan nxb){
        String sql = "INSERT INTO capnhatnxb(maNXB,tenNXB,diaChi,Email,soDienThoai)"
                + " values(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nxb.getMaNXB());
            ps.setString(2, nxb.getTenNXB());
            ps.setString(3, nxb.getDiaChi());
            ps.setString(4, nxb.getEmail());
            ps.setString(5, nxb.getSoDienThoai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
                
    }
    
    public static void sua(NhaXuatBan nxb){
        String sql="update capnhatnxb set tenNXB ='"+nxb.getTenNXB()+"', diaChi ='"+nxb.getDiaChi()+"', Email ='"
                +nxb.getEmail()+"',soDienThoai='"+nxb.getSoDienThoai()+"' where maNXB = '"+nxb.getMaNXB()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        
    }
    
    public static void xoa(NhaXuatBan nxb){
        String sql="delete from capnhatnxb where maNXB = '"+nxb.getMaNXB()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa khi có ít nhất 1 nhân viên đảm nhiệm chức vụ đó");
        }
    }
    
    public static ArrayList getListNXB(){
        ArrayList<NhaXuatBan> dsnxb =new ArrayList<>();
        String sql = "select* from capnhatnxb";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setMaNXB(rs.getString("maNXB"));
                nxb.setTenNXB(rs.getString("tenNXB"));
                nxb.setDiaChi(rs.getString("Email"));
                nxb.setSoDienThoai(rs.getString("soDienThoai"));
                dsnxb.add(nxb);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc");
        }
         return dsnxb;   
    }
    
    public static ArrayList getListCBB_NXB(){
        ArrayList<String> listOf_maNXB=new ArrayList<>();
        String sql="select maNXB from capnhanxb";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                listOf_maNXB.add(rs.getString("maNXB"));
                
            }
        } catch (SQLException ex) {
            
        }
        return listOf_maNXB;
    }
    
    public static boolean testPrimaryKey(String txt){
        String sql="Select * from capnhatnxb where maNXB='"+txt+"'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }
    public static ArrayList<String> getListMaNXB(){
        ArrayList<String> listNXB=new ArrayList();
        String sql="select maNXB from capnhatnxb";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                listNXB.add(rs.getString("maNXB"));
            }
        } catch (SQLException e) {
        }
        return listNXB;
    }
}
