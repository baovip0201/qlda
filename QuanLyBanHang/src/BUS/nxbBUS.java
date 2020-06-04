/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.loaisachDAO;
import DAO.nxbDAO;
import DAO.sachDAO;
import DTO.LoaiSach;
import DTO.NhaXuatBan;
import java.util.ArrayList;

/**
 *
 * @author vukieuanh
 */
public class nxbBUS {
    public ArrayList<NhaXuatBan> dsnxb;
    public ArrayList<String> listOf_maNXB;
    public nxbBUS() {
    }
    
    public void doc(){
        if(dsnxb==null) dsnxb=new ArrayList<>();
        dsnxb=nxbDAO.getListNXB();
    }
    
    public void add(NhaXuatBan nxb){
        nxbDAO.them(nxb);
        dsnxb.add(nxb);
        
    }
    public void sua(NhaXuatBan nxb){
        nxbDAO.sua(nxb);
    }
    public void xoa(NhaXuatBan nxb){
        nxbDAO.xoa(nxb);
        dsnxb.remove(nxb);
    }
    public void loadCbb(){
        if(listOf_maNXB==null) listOf_maNXB=new ArrayList<>();
        listOf_maNXB=nxbDAO.getListCBB_NXB();
    }
    public static boolean checkPrimaryKey(String txt){
        return nxbDAO.testPrimaryKey(txt);
    }
    
    
}
