/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.PhieuNhapHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class PNHDAO {
    public static Connection conn=ConnectDatabase.getConnection();
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    
    public static ArrayList load(){
        ArrayList<PhieuNhapHang> dspn=new ArrayList<>();
        String sql="select * from phieunhaphang";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                PhieuNhapHang s=new PhieuNhapHang();
                s.setMaNH(rs.getString("maNH"));
                s.setMaNV(rs.getString("maNV"));
                s.setMaNXB(rs.getString("maNXB"));
                s.setTinhTrang(rs.getString("tinhTrang"));
                s.setTongTien(rs.getFloat("tongTien"));
                s.setNgayNhap(rs.getDate("ngayNhap"));
                dspn.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc dữ liệu");
        }
        return dspn;
    }
    public static void add(PhieuNhapHang s){
        String sql="insert into phieunhaphang(maNH, maNV, maNXB, tinhTrang, tongTien, ngayNhap) values(?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, s.getMaNH());
            ps.setString(2, s.getMaNV());
            ps.setString(3, s.getMaNXB());
            ps.setString(4, s.getTinhTrang());
            ps.setFloat(5, s.getTongTien());
            ps.setDate(6, s.getNgayNhap());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public static void update(PhieuNhapHang s){
        String sql="update phieunhaphang set tinhTrang='"+s.getTinhTrang()+"', tongTien='"+s.getTongTien()+"', ngayNhap='"+s.getNgayNhap()+"' where maNH='"+s.getMaNH()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public static void delete(PhieuNhapHang s){
        String sql="delete from phieunhaphang where maNH='"+s.getMaNH()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    
    public static boolean checkPrimaryKey(String txt){
        String sql="Select * from phieunhaphang where maNH='"+txt+"'";
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
    public static ArrayList searchByMaNH(String txt){
        ArrayList<PhieuNhapHang> list=new ArrayList<>();
        String sql="select * from phieunhaphang where maNH like '%"+txt+"%'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                PhieuNhapHang s=new PhieuNhapHang();
                s.setMaNH(rs.getString("maNH"));
                s.setMaNV(rs.getString("maNV"));
                s.setMaNXB(rs.getString("maNXB"));
                s.setTinhTrang(rs.getString("tinhTrang"));
                s.setTongTien(rs.getFloat("tongTien"));
                s.setNgayNhap(rs.getDate("ngayNhap"));
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public static ArrayList searchByMaNV(String txt){
        ArrayList<PhieuNhapHang> list=new ArrayList<>();
        String sql="select * from phieunhaphang where maNV like '%"+txt+"%'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                PhieuNhapHang s=new PhieuNhapHang();
                s.setMaNH(rs.getString("maNH"));
                s.setMaNV(rs.getString("maNV"));
                s.setMaNXB(rs.getString("maNXB"));
                s.setTinhTrang(rs.getString("tinhTrang"));
                s.setTongTien(rs.getFloat("tongTien"));
                s.setNgayNhap(rs.getDate("ngayNhap"));
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public static ArrayList searchByMaNXB(String txt){
        ArrayList<PhieuNhapHang> list=new ArrayList<>();
        String sql="select * from phieunhaphang where maNXB like '%"+txt+"%'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                PhieuNhapHang s=new PhieuNhapHang();
                s.setMaNH(rs.getString("maNH"));
                s.setMaNV(rs.getString("maNV"));
                s.setMaNXB(rs.getString("maNXB"));
                s.setTinhTrang(rs.getString("tinhTrang"));
                s.setTongTien(rs.getFloat("tongTien"));
                s.setNgayNhap(rs.getDate("ngayNhap"));
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
