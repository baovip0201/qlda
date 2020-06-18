/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.ChiTietHoaDon;
import DAO.ChiTietHoaDon_DAO;
import DTO.LoaiSach;
import DTO.Sach;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Thanh Phuc
 */
public class ChiTietHoaDon_BUS {
    ChiTietHoaDon_DAO data = new ChiTietHoaDon_DAO();
    List<ChiTietHoaDon> listCthd = new ArrayList<>();
    List<LoaiSach> listLS = new ArrayList<>();
    List<Sach> listS = new ArrayList<>();
    public void insert(ChiTietHoaDon cthd){
    data.insert(cthd);
    listCthd.add(cthd);
    }
    
     public void delete(int stt){
         data.delete(stt);
     }
     
     public void update(ChiTietHoaDon hd){
         data.update(hd);
     }
     
     public List<LoaiSach> fill_cbb_ls(){
         listLS = data.fill_cbb_ls();
         return listLS;
     }
     
     public List<Sach> fill_cbb_sach(String loaisach){
         listS = data.fill_cbb_sach(loaisach);
         return listS;
     }
     
      public List<ChiTietHoaDon> getList(String mahd){
         if(listCthd==null) listCthd=new ArrayList<>();
         listCthd = data.getList(mahd);
         return listCthd;
    }
   public String getTenSach(String masach){
       String tensach=data.getTenSach(masach);
       return tensach;
   }
   public int getDonGia(String masach){
       int dongia = data.getDonGia(masach);
       return dongia;
   }
}
