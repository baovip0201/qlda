/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.loaisachDAO;
import DTO.LoaiSach;
import java.util.ArrayList;

/**
 *
 * @author vukieuanh
 */
public class loaisachBUS {
    public ArrayList<LoaiSach> dsls ;
    public ArrayList<String> ListOfLS;
    public loaisachBUS() {
    }
    
    public void doc(){
        if(dsls == null) dsls = new ArrayList<>();
            dsls = loaisachDAO.getListLS();
    }
    
    public void them(LoaiSach ls){
        loaisachDAO.them(ls);
        dsls.add(ls);
    }
    
    public void xoa (LoaiSach ls){
        loaisachDAO.xoa(ls);
        dsls.remove(ls);
    }
    
    public void sua (LoaiSach ls){
        loaisachDAO.sua(ls);
        
    }
    
    public void loadCBB(){
        if(ListOfLS == null) ListOfLS = new ArrayList<>();
            ListOfLS = loaisachDAO.getListCBB();
    }
    
    public static boolean checkPrimaryKey(String txt){
        return loaisachDAO.testPrimaryKey(txt);
    }
}
