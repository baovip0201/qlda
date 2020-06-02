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
import DTO.Sach;
import java.util.ArrayList;

/**
 *
 * @author vukieuanh
 */
public class SachBUS {
    public ArrayList<Sach> dss;
    public ArrayList<String> listOfLS;
    public ArrayList<String> listOf_maNXB;

    public SachBUS() {
    }
    
    public void Doc(){
        if(dss == null) dss = new ArrayList<>();
        dss = sachDAO.getListSach();
    }
    
    public void them (Sach s){
        sachDAO.them(s);
        dss.add(s);
    }
    
    public void xoa(Sach s){
        sachDAO.xoa(s);
        dss.remove(s);
    }
    
    public void sua(Sach s){
        sachDAO.sua(s);
    }
    
    public static boolean checkPrimaryKey(String txt){
        return sachDAO.testPrimaryKey(txt);
    }
    
    public ArrayList<LoaiSach> fill_CBB2(){
        ArrayList<LoaiSach> listOfLS = new ArrayList<>();
        listOfLS = loaisachDAO.getListCBB();
        return listOfLS;
    }
    
    public ArrayList<NhaXuatBan> fill_CBB1(){
        ArrayList<NhaXuatBan> listOf_maNXB = new ArrayList<>();
        listOf_maNXB = nxbDAO.getListCBB_NXB();
        return listOf_maNXB;
    }
    
    //Tong bao nhieu loai sach trong kho
    public int thongkesach(){
        Doc();
        int soluong = 0;
        for(Sach x : dss){
            soluong = soluong + x.getSoLuong();
        }
        return soluong;
    }
    
    public int soluongsach(String masach){
        Doc();
        int soluongsach = 0;
        for(Sach x : dss){
            if(x.getMaSach().equals(masach))
                soluongsach = x.getSoLuong();
        }
        return soluongsach;
    }
    
    
}
