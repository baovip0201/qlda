/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author vukieuanh
 */
public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    private String Email;
    private String soDienThoai;

    public NhaXuatBan() {
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    
}
