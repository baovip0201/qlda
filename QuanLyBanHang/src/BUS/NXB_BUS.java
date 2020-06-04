/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NXB_DAO;
import DTO.NXB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Phuc
 */
public class NXB_BUS {
     NXB_DAO data = new NXB_DAO();
    List<NXB> listNxb = new ArrayList<>();
    public List<NXB> getList(){
         //if(listNxb==null) listNxb=new ArrayList<>();
         listNxb = data.getList();
         return listNxb;
    }
    
    public void insert(NXB sach){
        data.insert(sach);
        listNxb.add(sach);
    }
    
    public boolean testPrimaryKey(String txt){
         return data.testPrimaryKey(txt);
    }
    
    public void update(NXB nxb){
        data.update(nxb);
    }
    public void delete(String nxb){
        data. delete(nxb);
    }
}
