/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.nvDAO;
import DTO.ChucVu;
import DTO.NhanVien;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MSI
 */
public class nvBUS{
    public List<NhanVien> dsnv;
    public ArrayList<String> list;
    nvDAO data = new nvDAO();
    public nvBUS(){
        
    }
    public List<NhanVien> docDSNV(){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=data.getListNV();
        return dsnv;
    }
    public void them(NhanVien nv){
        data.them(nv);
        dsnv.add(nv);
    }
    public void sua(NhanVien nv){
       
       data.sua(nv);
    }
    public void xoa(String nv){
        data.xoa(nv);
    }
    public void searchTenNV(String tf){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=data.searchTenNV(tf);
        
    }
    public void searchMaNV(String tf){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=data.searchMaNV(tf);
    }
    public boolean checkPrimaryKey(String txt){
        return data.testPrimaryKey(txt);
    }
    
    public List<ChucVu> fill_cbb() {
        List<ChucVu> list = new ArrayList<>();
        list = data.fill_cbb();
        return list;
    }
    public void report(){
        data.report();
    }
}
