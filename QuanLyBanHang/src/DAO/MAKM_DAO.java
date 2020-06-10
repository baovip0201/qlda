/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.khuyenMai;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vukieuanh
 */
public class MAKM_DAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;
    
    public void them(khuyenMai km){
        ConnectDatabase.getConnection();
        String sql="insert into khuyenMai(maGiamGia, tenChuongTrinh, thoiGianBatDau, thoiGianKetThuc, noiDungKhuyenMai, tienKhuyenMai)"+
                "values(?,?,?,?,?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1,km.getMaGiamGia());
            ps.setString(2,km.getTenChuongTrinh());
            ps.setDate(3,km.getThoiGianBatDau());
            ps.setDate(4,km.getThoiGianKetThuc());
            ps.setString(5, km.getNoiDungKhuyenMai());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
        }
    }
    
    public void sua(khuyenMai km){
        String sql="update khuyenMai set tenChuongTrinh='"+km.getTenChuongTrinh()+"',thoiGianBatDau='"+km.getThoiGianBatDau()+"',thoiGianKetThuc='"+km.getThoiGianKetThuc()
                +"',noiDungKhuyenMai='"+km.getNoiDungKhuyenMai()+"',tienKhuyenMai='"+km.getTienKhuyenMai()+"' where maGiamGia='"+km.getMaGiamGia()+"'";
        try {
            //ps=conn.prepareStatement(sql);
            int i=ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    
    public void xoa(khuyenMai km){
        
        try {
            ConnectDatabase.getConnection();
            //query
            String sql = "delete from khuyenMai where maGiamGia ='"+km.getMaGiamGia()+"'";
            ps = ConnectDatabase.connection.prepareCall(sql); 
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        
        
    }
    
    public List<khuyenMai> getListKM() {
        List<khuyenMai> dskm = new ArrayList<>();

        ConnectDatabase.getConnection();
        try {
            String sql = "select * from khuyenMai";
            rs = connect.executeSQL(sql);
            while (rs.next()) {
                khuyenMai km = new khuyenMai(
                        rs.getString("maGiamGia"),
                        rs.getString("tenChuongTrinh"),
                        rs.getDate("thoiGianBatDau"),
                        rs.getDate("thoiGianKetThuc"),
                        rs.getString("noiDungKhuyenMai"),
                        rs.getFloat("tienKhuyenMai"));
                dskm.add(km);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc");
        }
        return dskm;
    }
    
    public boolean testPrimaryKey(String txt){
        String sql="Select * from khuyenMai where maGiamGia='"+txt+"'";
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
    
    public static ArrayList searchByMaKM(String txt){
        ArrayList<khuyenMai> list=new ArrayList<>();
        String sql="select * from khuyenMai where maGiamGia like '%"+txt+"%'";
        try {
            ps=ConnectDatabase.connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                khuyenMai km = new khuyenMai();
                km.setMaGiamGia(rs.getString("maGiamGia"));
                km.setTenChuongTrinh(rs.getString("tenChuongTrinh"));
                km.setThoiGianBatDau(rs.getDate("thoiGianBatDau"));
                km.setThoiGianKetThuc(rs.getDate("thoiGianKetThuc"));
                km.setNoiDungKhuyenMai(rs.getString("noiDungKhuyenMai"));
                km.setTienKhuyenMai(rs.getFloat("tienKhuyenMai"));
                list.add(km);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
}
