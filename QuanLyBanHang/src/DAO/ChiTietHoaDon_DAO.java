/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.ChiTietHoaDon;
import DTO.LoaiSach;
import DTO.Sach;
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
public class ChiTietHoaDon_DAO {
     private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private PreparedStatement ps = null;
    private ResultSet rs= null;
    public List<ChiTietHoaDon> getList(String mahd){
        List<ChiTietHoaDon> listCthd = new ArrayList<>();
        ConnectDatabase.getConnection();        
        try {
            String sql = "select * from chitiethoadon where maHoaDon='"+mahd+"'";
            rs = connect.executeSQL(sql);
            while(rs.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon(rs.getInt("stt"),
                        rs.getString("maHoaDon"),
                        rs.getString("maSach"),                         
                        rs.getInt("soLuong"),
                        rs.getInt("donGia"),
                        rs.getInt("thanhTien"),
                        rs.getString("tensach"));
                listCthd.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCthd;
    }
    public void insert(ChiTietHoaDon cthd){
        ConnectDatabase.getConnection();
        String sql = "insert into chitiethoadon(stt, maHoaDon, maSach, tensach, soLuong, donGia, thanhTien) "+
                "values(?,?,?,?,?,?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setInt(1, cthd.getStt());
            ps.setString(2, cthd.getMahd());
            ps.setString(3, cthd.getMasach());
            ps.setString(4, cthd.getTensach());
            ps.setInt(5, cthd.getSoluong());
            ps.setInt(6, cthd.getDonGia());
            ps.setInt(7, cthd.getThanhTien());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không có hóa đơn này.");
        }
    }
    
    public void delete(int stt){
        
        try {
            ConnectDatabase.getConnection();
            //query
            String sql = "delete from chitiethoadon where stt = ?";
            ps = ConnectDatabase.connection.prepareCall(sql);            
            ps.setInt(1, stt);            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    
    public void update(ChiTietHoaDon hd){
        ConnectDatabase.getConnection();       
        try {
            String sql="update chitiethoadon set maSach='"+hd.getMasach()+"', tensach='"+hd.getTensach()+"', soLuong='"+hd.getSoluong()+"',"+
                "donGia='"+hd.getDonGia()+"', thanhTien='"+hd.getThanhTien()+"' where maHoaDon='"+hd.getMahd()+"'";
            ps=ConnectDatabase.connection.prepareStatement(sql);
            int i=ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(nvDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Lỗi");
        } 
    }
    
    public List<LoaiSach> fill_cbb_ls(){
        List<LoaiSach> listLs = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from capnhatloaisach";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                LoaiSach ls = new LoaiSach(rs.getString("maLoaiSach"));
                listLs.add(ls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(qltk_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        }
         finally {                     
             if (connect != null) {
                 connect.closeConnection();
            }
        }
        return listLs;
    }
    
    public List<Sach> fill_cbb_sach(String loaisach){
        List<Sach> listSach = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from thongtinsach where maLoaiSach='"+loaisach+"'";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                Sach sach = new Sach(rs.getString("maSach"));
                listSach.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(qltk_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        }
         finally {                     
             if (connect != null) {
                 connect.closeConnection();
            }
        }
        return listSach;
    }
    public String getTenSach(String masach){
        String tensach = null;
        ConnectDatabase.getConnection();
        try {
            String sql = "select * from thongtinsach where maSach='" + masach + "'";
            ResultSet rs = connect.executeSQL(sql);
            while (rs.next()) {
                String sach = new String(rs.getString("tenSach"));
                tensach=sach;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tensach;
    }
    public int getDonGia(String masach){
        int dongia = 0 ;
        ConnectDatabase.getConnection();
        try {
            String sql = "select * from thongtinsach where maSach='" + masach + "'";
            ResultSet rs = connect.executeSQL(sql);
            while (rs.next()) {
                Integer tien = new Integer(rs.getString("giaTien"));
                dongia=tien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dongia;
    }
    
}
