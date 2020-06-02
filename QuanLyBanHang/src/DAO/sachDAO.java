/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.Sach;
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
public class sachDAO {
    public static Connection conn=ConnectDatabase.getConnection();
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    
    public static void them(Sach s){
        String sql = "insert into thongtinsach(maSach,tenSach,maLoaiSach,maNXB,soLuong,giaTien,fileAnh)"
                + "values(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaNXB());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getMaLoaiSach());
            ps.setString(4, s.getMaNXB());
            ps.setInt(5, s.getSoLuong());
            ps.setFloat(6, s.getGiaTien());
            ps.setString(7, s.getFileAnh());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    
    
    public static void sua(Sach s) {
        String sql = "update thongtinsach set tenSach='" + s.getTenSach() + "',maLoaiSach='" + s.getTenSach() + "',maNXB ='"
                + s.getMaNXB() + "',soLuong='" + s.getSoLuong() + "',giaTien='" + s.getGiaTien() + "',fileAnh='" + s.getFileAnh() + ",where ='" + s.getMaSach() + "'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    
    public static void xoa(Sach s){
        String sql="delete from thongtinsach where maSach='"+s.getMaSach()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa khi có ít nhất 1 nhân viên đảm nhiệm chức vụ đó");
        }
    }
    
    public static ArrayList getListSach(){
        ArrayList<Sach> dss = new ArrayList<>(); // dss = danh sach sach
        String sql = "Select* from thongtinsach";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Sach s = new Sach();
                s.setMaSach(rs.getString("maSach"));
                s.setTenSach(rs.getString("tenSach"));
                s.setMaLoaiSach(rs.getString("maLoaiSach"));
                s.setMaNXB(rs.getString("maNXB"));
                s.setSoLuong(rs.getInt("soLuong"));
                s.setGiaTien(rs.getFloat("giaTien"));
                s.setFileAnh(rs.getString("fileAnh"));
                dss.add(s);
            }
        } catch (SQLException ex) {
           System.err.println("không đọc được bảng sach");
        }
        
        return dss;
    }
    
    
    public static boolean testPrimaryKey(String txt){
        String sql="Select * from thongtinsach where maSach='"+txt+"'";
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
}
