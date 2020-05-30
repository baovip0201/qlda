/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.DangNhap;
/**
 *
 * @author Thanh Phuc
 */
public class DangNhap_Bus {
    public DangNhap_Bus(){
        
    }
    public void DNhap(String tk, String pass){
        DangNhap data = new DangNhap();
        data.DNhap(tk, pass);
    }
    public String comparePassword(String pass) {
        DangNhap data = new DangNhap();
        data.comparePassword(pass);
        return pass;
    }
    public void DoiMatKhau(String tk,String pass) {    
        DangNhap data = new DangNhap();
        data.DoiMatKhau(tk, pass);
    }     

}
