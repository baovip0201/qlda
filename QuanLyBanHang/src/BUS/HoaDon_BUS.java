/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.HoaDon;
import DAO.HoaDon_DAO;
import DTO.ThongKe;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
/**
 *
 * @author Thanh Phuc
 */
public class HoaDon_BUS {
    HoaDon_DAO data = new HoaDon_DAO();
    List<HoaDon> listHd = new ArrayList<>();
    List<ThongKe> listTk = new ArrayList<>();
    public List<HoaDon> getList(){
        if(listHd==null) listHd=new ArrayList<>();
         listHd = data.getList();
         return listHd;
    }
    public void insert(HoaDon hd){
        data.insert(hd);
        listHd.add(hd);
    }
    public int getSlHoadon(){
       int sl= data.getSlHoadon();
       return sl;
    }
    public void create(HoaDon hd){
        data.create(hd);
        listHd.add(hd);
    }
    public int getThanhTien(String mahd){
        int thanhtien = data.getThanhTien(mahd);
        return thanhtien;
    }
    public void deleteHd(String mahd){
        data.deleteHD(mahd);
    }
    public void deleteCthd(String mahd){
        data.deleteCthd(mahd);
    }
    public void thanhToan(ThongKe tk){
        data.thanhToan(tk);
        listTk.add(tk);
    }
    public List<HoaDon> fill_cbb_hd(){
        listHd = data.fill_cbb_hd();
        return listHd;
    }
      public void xuatHoaDon(){
          data.xuatHoaDon();
      }
      public void xuatHoaDon2(String mahd){
          data.xuatHoaDon2(mahd);
      }
}
