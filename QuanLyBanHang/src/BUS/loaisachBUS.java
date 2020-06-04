/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiSachDAO;
import DTO.LoaiSach;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Phuc
 */
public class LoaiSachBUS {
     LoaiSachDAO data = new LoaiSachDAO();
    List<LoaiSach> listLS = new ArrayList<>();
    public List<LoaiSach> getList(){
         if(listLS==null) listLS=new ArrayList<>();
         listLS = data.getList();
         return listLS;
    }
    
    public void insert(LoaiSach sach){
        data.insert(sach);
        listLS.add(sach);
    }
    
    public boolean testPrimaryKey(String txt){
         return data.testPrimaryKey(txt);
    }
    
    public void delete(String ls){
        data.delete(ls);
    }
    
    public void update(LoaiSach ls){
        data.update(ls);
    }
}
