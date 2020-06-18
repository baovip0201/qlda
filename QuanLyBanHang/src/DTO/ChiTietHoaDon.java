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
public class ChiTietHoaDon {
    int stt;
    String mahd;
    String masach;
    int soluong;
    int donGia;
    int thanhTien;
    String tensach;
    
    public ChiTietHoaDon(){
        
    }

    public ChiTietHoaDon(int stt,String mahd, String masach, int soluong, int donGia, int thanhTien,String tensach) {
        this.stt=stt;
        this.mahd = mahd;
        this.masach = masach;
        this.soluong = soluong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.tensach=tensach;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
    
    
    
}
