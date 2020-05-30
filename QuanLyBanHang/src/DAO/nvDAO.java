/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVien;
import DB.ConnectDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DTO.ChucVu;


/**
 *
 * @author MSI
 */
public class nvDAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;
    public void them(NhanVien nv){
        ConnectDatabase.getConnection();
        String sql="insert into thongtinnhanvien(maNV, maChucVu, hoTen, gioiTinh, ngaySinh, diaChi, soDienthoai, Email, luong)"+
                "values(?,?,?,?,?,?,?,?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1, nv.getMaNv());
            ps.setString(2, nv.getMaCv());
            ps.setString(3, nv.getHoTen());
            ps.setString(4, nv.getGender());
            ps.setDate(5, nv.getDob());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSdt());
            ps.setString(8, nv.getEmail());
            ps.setFloat(9, nv.getLuong());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
        }
    }
    public void sua(NhanVien nv){
        String sql="update ThongTinNhanVien set maChucVu='"+nv.getMaCv()+"', hoTen='"+nv.getHoTen()+"', gioiTinh='"+nv.getGender()+"',"+
                "ngaySinh='"+nv.getDob()+"', diaChi='"+nv.getDiaChi()+"',"+
                "soDienThoai='"+nv.getSdt()+"', email='"+nv.getEmail()+"', luong='"+nv.getLuong()+"' where maNV='"+nv.getMaNv()+"'";
        try {
            //ps=conn.prepareStatement(sql);
            int i=ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public void xoa(String nv){
        
        try {
            ConnectDatabase.getConnection();
            //query
            String sql = "delete from thongtinnhanvien where maNV = ?";
            ps = ConnectDatabase.connection.prepareCall(sql);            
            ps.setString(1, nv);            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public List<NhanVien> searchTenNV(String tf){
        ConnectDatabase.getConnection();
        List<NhanVien> dsnv=new ArrayList<>();
        String sql="select * from ThongTinNhanVien where hoTen like '%"+tf+"%'";
        try {
            ps=ConnectDatabase.connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNv(rs.getString("maNV"));
                nv.setMaCv(rs.getString("maChucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGender(rs.getString("gioiTinh"));
                nv.setDob(rs.getDate("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
        }
        return dsnv;
    }
    public List<NhanVien> searchMaNV(String tf){
                ConnectDatabase.getConnection();

        List<NhanVien> dsnv=new ArrayList<>();
        String sql="select * from ThongTinNhanVien where maNV like '%"+tf+"%'";
        try {
            ps=ConnectDatabase.connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNv(rs.getString("maNV"));
                nv.setMaCv(rs.getString("maChucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGender(rs.getString("gioiTinh"));
                nv.setDob(rs.getDate("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
        }
        return dsnv;
    }
    public List<NhanVien> getListNV(){
        List<NhanVien> dsnv=new ArrayList<>();
        
        ConnectDatabase.getConnection();
        try {
            String sql="select * from thongtinnhanvien";
            rs=connect.executeSQL(sql);
            while(rs.next()){
                NhanVien nv=new NhanVien(
                rs.getString("maNV"),
                rs.getString("maChucVu"),
                rs.getString("hoTen"),
                rs.getString("gioiTinh"),
                rs.getDate("ngaySinh"),
                rs.getString("diaChi"),
                rs.getString("soDienThoai"),
                rs.getString("email"),
                rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc");
        }
        return dsnv;    
    }
    public boolean testPrimaryKey(String txt){
        String sql="Select * from ThongTinNhanVien where maNV='"+txt+"'";
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
    public List<ChucVu> fill_cbb(){
        List<ChucVu> cvList = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from chucvu";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                ChucVu tk = new ChucVu(rs.getString("maChucVu")                        
                        );
                cvList.add(tk);
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
        return cvList;
    }
        
}   
