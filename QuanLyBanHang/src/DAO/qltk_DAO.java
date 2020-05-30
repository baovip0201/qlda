/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DB.ConnectDatabase;
import DTO.TaiKhoan;
import GUI.ThongKeDoanhThu_Frame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.NhanVien;
import java.sql.Date;
import sun.net.www.content.audio.aiff;
/**
 *
 * @author Thanh Phuc
 */
public class qltk_DAO {
    private static final ConnectDatabase connect = new ConnectDatabase("localhost","root","","qlbansach");
    public qltk_DAO(){
        ConnectDatabase.getConnection();
    }
    public List<TaiKhoan> findAll(){
        List<TaiKhoan> tkList = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from qltaikhoan";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString("tenDN"),
                        rs.getString("matKhau"),
                        rs.getString("loaiTK"),
                        rs.getString("maNV"),
                        rs.getString("ngayTao"));
                tkList.add(tk);
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
        return tkList;
    }
    
    public void themTK(TaiKhoan tk){
        PreparedStatement pstm;
        ConnectDatabase.getConnection();
        try {
            String sql = "insert into qltaikhoan(tenDN,matKhau,loaiTK,maNV,ngayTao) values(?,?,?,?,?)";
            pstm = ConnectDatabase.connection.prepareCall(sql);
            pstm.setString(1, tk.getTenDangNhap());
            pstm.setString(2, tk.getMatKhau());
            pstm.setString(3, tk.getPhanLoai());
            pstm.setString(4, tk.getMaNV());
            pstm.setString(5, tk.getNgayTao());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(qltk_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void delete(String id){
        PreparedStatement statement = null;
        
        try {            
            ConnectDatabase.getConnection();
            //query
            String sql = "delete from qltaikhoan where tenDN = ?";
            statement = ConnectDatabase.connection.prepareCall(sql);            
            statement.setString(1, id);            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
             if (ConnectDatabase.connection != null){
                 ConnectDatabase.closeConnection();
            }
        }
        //ket thuc.
    }
    
    public void update(TaiKhoan tk){
        ConnectDatabase.getConnection();
        PreparedStatement statement = null;        
        try {           
            String sql = "update qltaikhoan matKhau=?,loaiTK=?,maNV=?,ngayTao=? where tenDN = ?";
            statement = ConnectDatabase.connection.prepareCall(sql);
            
            statement.setString(1, tk.getTenDangNhap());
            statement.setString(2, tk.getMatKhau());
            statement.setString(3, tk.getPhanLoai());
            statement.setString(4, tk.getMaNV());
            statement.setString(5, tk.getNgayTao());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ConnectDatabase.connection != null){
                ConnectDatabase.closeConnection();
            }
        }
    }
    public List<NhanVien> fill_cbb(){
        List<NhanVien> nvList = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from thongtinnhanvien";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                NhanVien tk = new NhanVien(rs.getString("maNV")                        
                        );
                nvList.add(tk);
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
        return nvList;
    }
    public String fill_ThongTinNhanVien(String maNV){
        String nv = new String();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from thongtinnhanvien where maNV='"+maNV+"'";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                String hoten = new String(rs.getString("hoTen")                        
                        );
                nv=hoten;
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
        return nv;
    }
    public List<TaiKhoan> findByDate(String ngayBD,String ngayKT){
        List<TaiKhoan> tkList=new ArrayList<>();
        String sql="select * from qltaikhoan where ngayTao between '"+ngayBD+"' and '"+ngayKT+"'";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectDatabase.connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                TaiKhoan nv=new TaiKhoan();
                nv.setMaNV(rs.getString("maNV"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setNgayTao(rs.getString("ngayTao"));
                nv.setPhanLoai(rs.getString("loaiTK"));
                nv.setTenDangNhap(rs.getString("tenDN"));
                
                tkList.add(nv);
            }
        } catch (SQLException e) {
        }
        return tkList;
    }
}
