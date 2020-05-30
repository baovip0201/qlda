/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.qltk_DAO;
import DTO.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import DTO.NhanVien;
import java.sql.Date;
/**
 *
 * @author Thanh Phuc
 */
public class qltk_BUS {
    private static List<TaiKhoan> tkList = new ArrayList<>();
    public qltk_BUS(){
        
    }
    public void themTK(TaiKhoan tk){
        qltk_DAO data = new qltk_DAO();
        data.themTK(tk);
        tkList.add(tk);
    }
    public void delete(String id){
        qltk_DAO data = new qltk_DAO();
        data.delete(id);
    }
    public void update(TaiKhoan tk){
        qltk_DAO data = new qltk_DAO();
        data.update(tk);
    }
    public List<NhanVien> fill_cbb(){
        List<NhanVien> list=new ArrayList<>();
        qltk_DAO data = new qltk_DAO();
        list = data.fill_cbb();
        return list;
    }
    public String fill_ThongTinNhanVien(String maNV){
        qltk_DAO data = new qltk_DAO();
        String nv=data.fill_ThongTinNhanVien(maNV);
        return nv;
    }
    public List<TaiKhoan> findByDate(String ngayBD,String ngayKT){
        qltk_DAO data = new qltk_DAO();
       tkList= data.findByDate(ngayBD, ngayKT);
        return tkList;
    }
    
}
