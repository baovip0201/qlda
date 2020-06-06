/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.MAKM_DAO;
import DTO.khuyenMai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vukieuanh
 */
public class KMBUS {
    public List<khuyenMai> dskm;
    public ArrayList<String> list;
    MAKM_DAO data = new MAKM_DAO();

    public KMBUS() {
    }
    
    public List<khuyenMai> docDSKM(){
        if(dskm==null) dskm=new ArrayList<>();
        dskm=data.getListKM();
        return dskm;
    }
    
    public void them(khuyenMai km){
        data.them(km);
        dskm.add(km);
    }
    public void sua(khuyenMai km){
       
       data.sua(km);
    }
    public void xoa(khuyenMai km){
        data.xoa(km);
    }
    
    public boolean checkPrimaryKey(String txt){
        return data.testPrimaryKey(txt);
    }
    
    public void searchMaKM(String tf){
        if(dskm==null) dskm=new ArrayList<>();
        dskm=data.searchByMaKM(tf);
    }
}
