/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PNHDAO;
import DAO.nvDAO;
import DAO.nxbDAO;
import DTO.PhieuNhapHang;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class PNHBUS {
    public ArrayList<PhieuNhapHang> dspn;
    public ArrayList<String> listNV;
    public ArrayList<String> listNXB;
    
    public void load(){
        if(dspn==null) dspn=new ArrayList<>();
        dspn=PNHDAO.load();
    }
    public void add(PhieuNhapHang s){
        PNHDAO.add(s);
        dspn.add(s);
    }
    public void update(PhieuNhapHang s){
        PNHDAO.update(s);
    }
    public void delete(PhieuNhapHang s){
        PNHDAO.delete(s);
    }
    public void getListNV(){
        if(listNV==null) listNV=new ArrayList<>();
        listNV=nvDAO.getListMaNV();
    }
    public void getListNXB(){
        if(listNXB==null) listNXB=new ArrayList<>();
        listNXB=nxbDAO.getListMaNXB();
    }
    public void searchByMaNH(String tf){
        if(dspn==null) dspn=new ArrayList<>();
        dspn=PNHDAO.searchByMaNH(tf);
    }
    public void searchByMaNV(String tf){
        if(dspn==null) dspn=new ArrayList<>();
        dspn=PNHDAO.searchByMaNV(tf);
    }
    public void searchByMaNXB(String tf){
        if(dspn==null) dspn=new ArrayList<>();
        dspn=PNHDAO.searchByMaNXB(tf);
    }
    public static boolean checkPrimaryKey(String txt){
        return PNHDAO.checkPrimaryKey(txt);
    }
}
