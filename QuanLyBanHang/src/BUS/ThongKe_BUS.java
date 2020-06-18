/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.HoaDon_DAO;
import DTO.ThongKe;
import java.util.ArrayList;
import java.util.List;
import DAO.ThongKe_DAO;

/**
 *
 * @author Thanh Phuc
 */
public class ThongKe_BUS {
    HoaDon_DAO dataHd = new HoaDon_DAO();
    ThongKe_DAO datatk = new ThongKe_DAO();
    List<ThongKe> listTk = new ArrayList<>();
    public void ThanhToan(ThongKe tk){
        dataHd.thanhToan(tk);
        listTk.add(tk);
    }
    public List<ThongKe> getList(String mahd){
         if(listTk==null) listTk=new ArrayList<>();
         listTk = datatk.getList(mahd);
         return listTk;
}
}
