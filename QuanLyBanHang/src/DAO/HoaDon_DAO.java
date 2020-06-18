/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DB.ConnectDatabase;
import DTO.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.ThongKe;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.BasicConfigurator;


/**
 *
 * @author Thanh Phuc
 */
public class HoaDon_DAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private PreparedStatement ps = null;
    private ResultSet rs= null;
    public void insert(HoaDon hd){
        ConnectDatabase.getConnection();
        String sql = "update hoadon set maNV='"+hd.getMaNv()+"', maKH='"+hd.getMaKh()+"', maGiamGia='"+hd.getMaGg()+"', ngayLap='"+hd.getNgayLap()+"'"
                +", gioLap='"+hd.getGioLap()+"', tongTien='"+hd.getTongtien()+"', tienGiamGia='"+hd.getTienGiamGia()+"' where maHoaDon='"+hd.getMaHD()+"'";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            int i= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void create(HoaDon hd){
        ConnectDatabase.getConnection();
        String sql = "insert into hoadon(maHoaDon, maNV, maKH, maGiamGia, ngayLap,gioLap, tongtien, tienGiamGia) "+
                "values(?,NULL,NULL,NULL,NULL,NULL,NULL,NULL)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());  
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getSlHoadon(){
        int soluong = 0;
        ConnectDatabase.getConnection();
        try {
            String sql = "SELECT count(maHoaDon) FROM hoadon";
            ResultSet rs = connect.executeSQL(sql);
            while(rs.next()){
                soluong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soluong;
    }
    
    public int getThanhTien(String mahd){
        int tongtien = 0 ;
        ConnectDatabase.getConnection();
        try {
            String sql = "select sum(thanhTien) from chitiethoadon where maHoaDon='" + mahd + "'";
            ResultSet rs = connect.executeSQL(sql);
            while (rs.next()) {
                tongtien = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongtien;
    } 
    public void deleteHD(String mahd){
        ConnectDatabase.getConnection();
        String sql = "delete from hoadon where maHoaDon='"+mahd+"'";
        try {
            ps=ConnectDatabase.connection.prepareCall(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void deleteCthd(String mahd){
        ConnectDatabase.getConnection();
        String sql = "delete from chitiethoadon where maHoaDon='"+mahd+"'";
        try {
            ps = ConnectDatabase.connection.prepareCall(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void thanhToan(ThongKe tk){
        ConnectDatabase.getConnection();
        String sql = "insert into thongkedoanhthu(maHoaDon, maNV, gioBan, ngayBan, tongTienHoaDon) "+
                "values(?,?,?,?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1, tk.getMahd());  
            ps.setString(2, tk.getManv());
            ps.setString(3, tk.getGioBan());
            ps.setString(4, tk.getNgayBan());
            ps.setInt(5, tk.getTongtien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<HoaDon> fill_cbb_hd(){
        List<HoaDon> listhd = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from hoadon";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("maHoaDon"));
                listhd.add(hd);
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
        return listhd;
    }
    public void xuatHoaDon(){
       
        try {
            JasperDesign jdesign = JRXmlLoader.load("D:\\Java\\QuanLyBanHang\\src\\iReport\\XuatHoaDon.jrxml");
            String sql = "select * from hoadon";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(sql);
            jdesign.setQuery(updateQuery);
            JasperReport jsreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jsreport, null,ConnectDatabase.getConnection());
            JasperViewer.viewReport(jprint);
        } catch (JRException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void xuatHoaDon2(String mahd) {
        try{
        Hashtable map = new Hashtable();
        
        JasperReport report = JasperCompileManager.compileReport("src/iReport/XuatHoaDon.jrxml");
        map.put("maHoaDon", mahd);
        JasperPrint jprint = JasperFillManager.fillReport(report, map,ConnectDatabase.getConnection());
        JasperViewer.viewReport(jprint,false);
        }catch (JRException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<HoaDon> getList(){
        List<HoaDon> listhd = new ArrayList<>();
        ConnectDatabase.getConnection();        
        try {
            String sql = "select * from hoadon ";
            rs = connect.executeSQL(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("maHoaDon"),
                        rs.getString("maNV"),
                        rs.getString("maKH"),                         
                        rs.getString("maGiamGia"),
                        rs.getString("ngayLap"),
                        rs.getString("gioLap"),
                        rs.getInt("tongTien"),
                        rs.getInt("tienGiamGia"));
                listhd.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhd;
    }
}
