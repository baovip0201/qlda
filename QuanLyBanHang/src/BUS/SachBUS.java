<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiSachDAO;
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
=======
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
>>>>>>> 3c93db25c5d87b3b6e8ca1f567e3d39437db10c6
