/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;


/**
 *
 * @author vukieuanh
 */
public class khuyenMai {
    private String maGiamGia;
    private String tenChuongTrinh;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private String noiDungKhuyenMai;
    private float tienKhuyenMai;

    public khuyenMai(String maGiamGia, String tenChuongTrinh, Date thoiGianBatDau, Date thoiGianKetThuc, String noiDungKhuyenMai, float tienKhuyenMai) {
        this.maGiamGia = maGiamGia;
        this.tenChuongTrinh = tenChuongTrinh;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.noiDungKhuyenMai = noiDungKhuyenMai;
        this.tienKhuyenMai = tienKhuyenMai;
    }

    public khuyenMai() {
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getNoiDungKhuyenMai() {
        return noiDungKhuyenMai;
    }

    public void setNoiDungKhuyenMai(String noiDungKhuyenMai) {
        this.noiDungKhuyenMai = noiDungKhuyenMai;
    }

    public float getTienKhuyenMai() {
        return tienKhuyenMai;
    }

    public void setTienKhuyenMai(float tienKhuyenMai) {
        this.tienKhuyenMai = tienKhuyenMai;
    }

    

   
    

}
