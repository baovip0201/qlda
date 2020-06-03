/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DB.ConnectDatabase;
import DTO.NXB;
import DTO.LoaiSach;
import DTO.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.Sach;
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
public class sachDAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private PreparedStatement ps = null;
    private ResultSet rs= null;
    public List<Sach> getList(){
        List<Sach> listSach = new ArrayList<>();
        ConnectDatabase.getConnection();        
        try {
            String sql = "select * from thongtinsach";
            rs = connect.executeSQL(sql);
            while(rs.next()){
                Sach sach = new Sach(rs.getString("maSach"),
                        rs.getString("tenSach"),
                        rs.getString("maLoaiSach"),
                        rs.getString("maNXB"),
                        rs.getInt("soLuong"),
                        rs.getDouble("giaTien"),
                        rs.getString("fileAnh"));
                listSach.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSach;
    }
    
    public void insert(Sach sach){
        ConnectDatabase.getConnection();
        String sql = "insert into thongtinsach(maSach, tenSach, maLoaiSach, maNXB, soLuong, giaTien, fileAnh) "+
                "values(?,?,?,?,?,?,?)";
        try {
            ps = ConnectDatabase.connection.prepareStatement(sql);
            ps.setString(1, sach.getMaSach());
            ps.setString(2, sach.getTenSach());
            ps.setString(3, sach.getMaLoaiSach());
            ps.setString(4, sach.getMaNXB());
            ps.setInt(5, sach.getSoLuong());
            ps.setDouble(6, sach.getGiaTien());
            ps.setString(7, sach.getFileAnh());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<NXB> fill_cbb_nxb(){
        List<NXB> listNxb = new ArrayList<>();
        ConnectDatabase.getConnection();
        try {
        String sql = "select * from capnhatnxb";
        ResultSet rs = connect.executeSQL(sql);
        
            while(rs.next()){
                NXB nxb = new NXB(rs.getString("maNXB"));
                listNxb.add(nxb);
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
        return listNxb;
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
    
    public boolean testPrimaryKey(String txt){
        ConnectDatabase.getConnection();
        String sql="Select * from thongtinsach where maSach='"+txt+"'";
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
    
     public void update(Sach sach){
        ConnectDatabase.getConnection();       
        try {
            String sql="update thongtinsach set tenSach='"+sach.getTenSach()+"', maLoaiSach='"+sach.getMaLoaiSach()+"',"+
                "maNXB='"+sach.getMaNXB()+"', soLuong='"+sach.getSoLuong()+"',giaTien='"+sach.getGiaTien()+"', fileAnh='"+sach.getFileAnh()+"' where maSach='"+sach.getMaSach()+"'";
            ps=ConnectDatabase.connection.prepareStatement(sql);
            int i=ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(nvDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        
       
        
    }
     
     public void delete(String sach){
        
        try {
            ConnectDatabase.getConnection();
            //query
            String sql = "delete from thongtinsach where maSach = ?";
            ps = ConnectDatabase.connection.prepareCall(sql);            
            ps.setString(1, sach);            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }

    
}
