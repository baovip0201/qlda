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
public class HoaDon {
    String maHD;
    String maNv;
    String maKh;
    String maGg;
    String ngayLap;
    String gioLap;
    int tongtien;
    int tienGiamGia;
    public HoaDon(){
        
    }
    public HoaDon(String mahd){
        this.maHD = mahd;
    }
    public HoaDon(String maHD, String maNv, String maKh, String maGg, String ngayLap,String gioLap, int tongtien, int tienGiamGia) {
        this.maHD = maHD;
        this.maNv = maNv;
        this.maKh = maKh;
        this.maGg = maGg;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.tongtien = tongtien;
        this.tienGiamGia = tienGiamGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaGg() {
        return maGg;
    }

    public void setMaGg(String maGg) {
        this.maGg = maGg;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(int tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

    public String getGioLap() {
        return gioLap;
    }

    public void setGioLap(String gioLap) {
        this.gioLap = gioLap;
    }
    
    
    
}
