/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDatabase;
import DTO.ChiTietHoaDon;
import DTO.ThongKe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Phuc
 */
public class ThongKe_DAO {
    private static ConnectDatabase connect = new ConnectDatabase("localhost", "root", "", "qlbansach");
    private PreparedStatement ps = null;
    private ResultSet rs= null;
    public List<ThongKe> getList(String mahd){
        List<ThongKe> listTk = new ArrayList<>();
        ConnectDatabase.getConnection();        
        try {
            String sql = "select * from thongkedoanhthu where maHoaDon='"+mahd+"'";
            rs = connect.executeSQL(sql);
            while(rs.next()){
                ThongKe tk = new ThongKe(rs.getString("maHoaDon"),
                        rs.getString("maNV"),
                        rs.getString("gioBan"),                         
                        rs.getString("ngayBan"),
                        rs.getInt("tongTienHoaDon"));
                listTk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTk;
    }
}
