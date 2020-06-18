/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Thanh Phuc
 */
public class ThongKe {
    String mahd;
    String manv;
    String ngayBan;
    String gioBan;
    int tongtien;
    
    public ThongKe(){
        
    }
    public ThongKe(String mahd, String manv, String ngayBan, String gioBan, int tongtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.ngayBan = ngayBan;
        this.gioBan = gioBan;
        this.tongtien = tongtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getGioBan() {
        return gioBan;
    }

    public void setGioBan(String gioBan) {
        this.gioBan = gioBan;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
