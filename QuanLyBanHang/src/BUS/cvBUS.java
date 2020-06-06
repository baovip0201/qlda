/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.cvDAO;
import DTO.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class cvBUS {
    public ArrayList<ChucVu> dscv;
    public ArrayList<String> list;
    public cvBUS(){
        
    }
    public void doc(){
        if(dscv==null) dscv=new ArrayList<>();
        dscv=cvDAO.getListCV();
    }
    public void add(ChucVu cv){
        cvDAO.them(cv);
        dscv.add(cv);
    }
    public void sua(ChucVu cv){
        cvDAO.sua(cv);
    }
    public void xoa(ChucVu cv){
        cvDAO.xoa(cv);
    }
    public void loadCbb(){
        if(list==null) list=new ArrayList<>();
        list=cvDAO.getListCBB();
    }
    public static boolean checkPrimaryKey(String txt){
        return cvDAO.testPrimaryKey(txt);
    }
    public void sort(){
        if(dscv==null)  dscv=new ArrayList<>();
        dscv=cvDAO.sortByLuong();
    }
}
