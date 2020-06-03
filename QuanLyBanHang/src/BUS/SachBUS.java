/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.sachDAO;
import DTO.LoaiSach;
import DTO.NXB;
import DTO.Sach;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Thanh Phuc
 */
public class SachBUS {
    sachDAO data = new sachDAO();
    List<Sach> listSach = new ArrayList<>();
    List<NXB> listNxb = new ArrayList<>();
    List<LoaiSach> listLS = new ArrayList<>();
    public List<Sach> getList(){
         if(listSach==null) listSach=new ArrayList<>();
         listSach = data.getList();
         return listSach;
    }
    
    public void insert(Sach sach){
        data.insert(sach);
        listSach.add(sach);
    }
     public List<NXB> fill_cbb_nxb(){
         listNxb = data.fill_cbb_nxb();
         return listNxb;
     }
     public List<LoaiSach> fill_cbb_ls(){
         listLS = data.fill_cbb_ls();
         return listLS;
     }
     public boolean testPrimaryKey(String txt){
         return data.testPrimaryKey(txt);
    }
     
     public void update(Sach sach){
         data.update(sach);
     }
     
     public void delete(String sach){
         data.delete(sach);
     }
}
