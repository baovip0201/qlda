/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietHoaDon_BUS;
import BUS.HoaDon_BUS;
import BUS.batLoi;
import BUS.cvBUS;
import DAO.DangNhap;
import DAO.HoaDon_DAO;
import DAO.SessionUser;
import DB.ConnectDatabase;
import DTO.ChiTietHoaDon;
import DTO.ChucVu;
import DTO.HoaDon;
import DTO.LoaiSach;
import DTO.NhanVien;
import DTO.Sach;
import DTO.ThongKe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Thanh Phuc
 */
public class BanHang_Frame extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    List<ChiTietHoaDon> listCthd = new ArrayList<>(); 
    List<HoaDon> listHd = new ArrayList<>();
    ChiTietHoaDon_BUS busCthd =new ChiTietHoaDon_BUS();
    HoaDon_BUS busHd = new HoaDon_BUS();
    public BanHang_Frame() {
        initComponents();
        tableModel = (DefaultTableModel) jTable1.getModel();
        setttnv();
        String ngayhientai;
        lable_ngay.setText(java.time.LocalDate.now().toString());
        startClock();
        getCb_Box_LS(); 
        getCb_mahd();
        disenable();  
    }
    public void disenable(){
        txt_mahd.setEnabled(false);
        txt_soLuong.setEnabled(false);
        txt_makh.setEnabled(false);
        txt_thanhTien.setEnabled(false);
        txt_magg.setEnabled(false);
        txt_giaTien.setEnabled(false);
        txt_tensach.setEnabled(false);
    }
     public void startClock(){
        Timer timer = new Timer(1000, (ActionEvent e) -> {
        DateTimeFormatter myTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(); 
        lable_gio.setText(String.valueOf(myTime.format(now)));
    });
    timer.setRepeats(true);
    timer.start();
    }
    private void setttnv(){
        DangNhap dn = new DangNhap();        
        String nv = dn.getManv();
        lbl_manv.setText(nv);
        String tennv = dn.getTennv(lbl_manv.getText());
        lbl_tenNV.setText(tennv);
    }
    private void getCb_Box_LS(){        
        List<LoaiSach> list=new ArrayList<>();
        list = busCthd.fill_cbb_ls();
        for(LoaiSach item: list){
            cbb_loaiSach.addItem(item.getMaLoaiSach());
        } 
     }
    private void getCb_mahd(){
        listHd = busHd.fill_cbb_hd();
        for(HoaDon item:listHd){
            cbb_mahd.addItem(item.getMaHD());
        }
    }
    private void showw(){
        ChiTietHoaDon_BUS bus = new ChiTietHoaDon_BUS();
        listCthd=bus.getList(txt_mahd.getText());
        tableModel.setRowCount(0);
        listCthd.forEach((cthd)->{
        tableModel.addRow(new Object[] {tableModel.getRowCount()+1,cthd.getMasach(),
        cthd.getTensach(),cthd.getSoluong(),cthd.getDonGia(),cthd.getThanhTien()});
        });
    } 
    public void reset(){
        txt_mahd.setText("");
        txt_makh.setText("");
        txt_magg.setText("");
        txt_giaTien.setText("");
        txt_soLuong.setText("");
        txt_tensach.setText("");
        txt_thanhTien.setText("");
        lbl_tongtienhd.setText("0");
        lbl_tiengg.setText("0");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbb_loaiSach = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbb_maSach = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_giaTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_thanhTien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_tenNV = new javax.swing.JLabel();
        lable_ngay = new javax.swing.JLabel();
        lable_gio = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_manv = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_makh = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_tensach = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_tenkh = new javax.swing.JTextField();
        btn_chonkh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_hoaDonMoi = new javax.swing.JButton();
        btn_tailai = new javax.swing.JButton();
        btn_themSach = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_thanhToan = new javax.swing.JButton();
        btn_xuatHoaDon = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_magg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        lbl_tiengg = new javax.swing.JLabel();
        lbl_tongtienhd = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbb_mahd = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\arrow-back-icon.png")); // NOI18N
        jButton1.setText("Hệ thống");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Bán hàng");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Loại sách:");

        cbb_loaiSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbb_loaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_loaiSachActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Tên Sách:");

        cbb_maSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbb_maSach.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbb_maSachPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbb_maSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbb_maSachMousePressed(evt);
            }
        });
        cbb_maSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_maSachActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Số lượng:");

        txt_soLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });
        txt_soLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_soLuongKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Đơn giá:");

        txt_giaTien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Thành tiền:");

        txt_thanhTien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Tên nhân viên:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Ngày:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Giờ:");

        lbl_tenNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lable_ngay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lable_gio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Mã nhân viên:");

        lbl_manv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel17)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tenNV)
                    .addComponent(lable_ngay)
                    .addComponent(lable_gio)
                    .addComponent(lbl_manv))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(lbl_manv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_tenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lable_ngay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lable_gio)))
        );

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Mã khách hàng:");

        txt_makh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Mã sách:");

        txt_tensach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel16.setText("jLabel16");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Tên khách hàng:");

        txt_tenkh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btn_chonkh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_chonkh.setText("Chọn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_chonkh))
                            .addComponent(txt_tenkh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbb_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbb_maSach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_giaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(3, 3, 3)
                                .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tensach)))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(397, 397, 397)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_giaTien, txt_soLuong, txt_thanhTien});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbb_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(txt_tensach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btn_chonkh)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel16))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txt_giaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_makh, txt_tenkh});

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Mã hóa đơn:");

        btn_hoaDonMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_hoaDonMoi.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\page-edit-icon (1).png")); // NOI18N
        btn_hoaDonMoi.setText("Hóa đơn mới");
        btn_hoaDonMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoaDonMoiActionPerformed(evt);
            }
        });

        btn_tailai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_tailai.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\reload-icon.png")); // NOI18N
        btn_tailai.setText("Tải lại");

        btn_themSach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_themSach.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Sign-Add-icon.png")); // NOI18N
        btn_themSach.setText("Sách");
        btn_themSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSachActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Repair-icon.png")); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Trash-icon.png")); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_luu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\save.png")); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_thanhToan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_thanhToan.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\62876-money-bag-icon.png")); // NOI18N
        btn_thanhToan.setText("Thanh Toán");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        btn_xuatHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xuatHoaDon.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\print.png")); // NOI18N
        btn_xuatHoaDon.setText("Xuất hóa đơn");
        btn_xuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatHoaDonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Mã giảm giá:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Tiền giảm giá:");
        jLabel12.setToolTipText("");

        txt_magg.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Tổng tiền hóa đơn:");

        txt_mahd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lbl_tiengg.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_tiengg.setText("0");

        lbl_tongtienhd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_tongtienhd.setText("0");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Danh sách hóa đơn");

        cbb_mahd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbb_mahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_mahdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(txt_mahd)))
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbb_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_tailai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hoaDonMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_themSach)
                            .addComponent(btn_sua))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_xoa)
                            .addComponent(btn_luu)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_magg, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tiengg)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tongtienhd)))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_xuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_hoaDonMoi, btn_luu, btn_sua, btn_themSach, btn_xoa});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_hoaDonMoi)
                        .addComponent(btn_themSach)
                        .addComponent(btn_xoa)
                        .addComponent(btn_thanhToan))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tailai)
                            .addComponent(btn_sua)
                            .addComponent(btn_luu)
                            .addComponent(btn_xuatHoaDon)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel15)
                        .addGap(4, 4, 4)
                        .addComponent(cbb_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txt_magg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(lbl_tiengg)
                    .addComponent(lbl_tongtienhd))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Số thự tự", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int option = JOptionPane.showConfirmDialog(this, "Bạn chưa lưu hóa đơn. Bạn có muốn thoát?");
        
        
        if(option == 0){
            busHd.deleteCthd(txt_mahd.getText());
            busHd.deleteHd(txt_mahd.getText());
            
            User_Frame user = new User_Frame();
            user.setVisible(true);
            dispose();
        }
       
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_themSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSachActionPerformed
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        int dongia = busCthd.getDonGia(cbb_maSach.getSelectedItem().toString());
        int soluong = Integer.parseInt(txt_soLuong.getText());
        if (!batLoi.Catch(txt_mahd.getText()) && !batLoi.Catch(cbb_maSach.getSelectedItem().toString()) && !batLoi.Catch(txt_soLuong.getText()) && !batLoi.Catch(txt_giaTien.getText()) && !batLoi.Catch(txt_thanhTien.getText())) {
            
                cthd.setMahd(txt_mahd.getText());
                cthd.setMasach(cbb_maSach.getSelectedItem().toString());
                cthd.setTensach(txt_tensach.getText());
                cthd.setSoluong(Integer.parseInt(txt_soLuong.getText()));
                cthd.setDonGia(dongia);
                cthd.setThanhTien(dongia*soluong);
                ChiTietHoaDon_BUS bus = new ChiTietHoaDon_BUS();
                bus.insert(cthd);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                showw();
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
        Locale locale = new Locale("vi","VN");
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols formatSymbol = new DecimalFormatSymbols();
        formatSymbol.setCurrencySymbol("VND");
        format.setDecimalFormatSymbols(formatSymbol);
        int tongtien = busHd.getThanhTien(cthd.getMahd());
        lbl_tongtienhd.setText(format.format(tongtien));
        
    }//GEN-LAST:event_btn_themSachActionPerformed
    
    private void cbb_loaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_loaiSachActionPerformed
       List<Sach> list=new ArrayList<>();
        cbb_maSach.removeAllItems();
        list = busCthd.fill_cbb_sach(cbb_loaiSach.getSelectedItem().toString());
        for(Sach item: list){
            cbb_maSach.addItem(item.getMaSach());
            
        }
        
        
    }//GEN-LAST:event_cbb_loaiSachActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int selectIndext = jTable1.getSelectedRow();
        ChiTietHoaDon_BUS bus = new ChiTietHoaDon_BUS();

         if(selectIndext >= 0){
            ChiTietHoaDon cthd =  listCthd.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
                //SinhVien.delete(std.getId());
               bus.delete(cthd.getStt());
                showw();
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed
   
    private void cbb_maSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_maSachActionPerformed
       
    }//GEN-LAST:event_cbb_maSachActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_soLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soLuongKeyReleased
        int dongia;
        int soluong;
        Locale locale = new Locale("vi","VN");
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols formatSymbol = new DecimalFormatSymbols();
        formatSymbol.setCurrencySymbol("VND");
        format.setDecimalFormatSymbols(formatSymbol);
        try{
        dongia = busCthd.getDonGia(cbb_maSach.getSelectedItem().toString());
        soluong = Integer.parseInt(txt_soLuong.getText());
        txt_thanhTien.setText(format.format(dongia*soluong));
        }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Số lượng không được ghi bằng kí tự");
            }
        txt_thanhTien.setEnabled(false);    }//GEN-LAST:event_txt_soLuongKeyReleased

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int i = jTable1.getSelectedRow();
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        
        cthd.setMasach(cbb_maSach.getSelectedItem().toString());
        cthd.setTensach(txt_tensach.getText());
        cthd.setSoluong(Integer.parseInt(txt_soLuong.getText()));
        cthd.setDonGia(Integer.parseInt(txt_giaTien.getText()));
        cthd.setThanhTien(Integer.parseInt(txt_thanhTien.getText()));
        tableModel.setValueAt(cthd.getMasach(), i, 1);
        tableModel.setValueAt(cthd.getTensach(), i, 2);
        tableModel.setValueAt(cthd.getSoluong(), i, 3);
        tableModel.setValueAt(cthd.getDonGia(), i, 4);
        tableModel.setValueAt(cthd.getThanhTien(), i, 5);
        busCthd.update(cthd);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        HoaDon hd = new HoaDon();
        int tongtien = busHd.getThanhTien(txt_mahd.getText());
        
        if (!batLoi.Catch(txt_mahd.getText()) && !batLoi.Catch(txt_makh.getText()) && !batLoi.Catch(txt_magg.getText())) {
            
                hd.setMaHD(txt_mahd.getText());
                hd.setMaKh(txt_makh.getText());
                hd.setMaNv(lbl_manv.getText());
                hd.setMaGg(txt_magg.getText());
                hd.setNgayLap(lable_ngay.getText());
                hd.setGioLap(lable_gio.getText());
                hd.setTongtien(tongtien);
                hd.setTienGiamGia(Integer.parseInt(lbl_tiengg.getText()));
                busHd.insert(hd);
                JOptionPane.showMessageDialog(rootPane, "Đã lưu");
                
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_hoaDonMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoaDonMoiActionPerformed
        txt_soLuong.setEnabled(true);
        txt_magg.setEnabled(true);
        txt_makh.setEnabled(true);
        int tang = busHd.getSlHoadon()+1;
        txt_mahd.setText("HD"+tang);
        HoaDon hd = new HoaDon();
        if (!batLoi.Catch(txt_mahd.getText())) {           
                hd.setMaHD(txt_mahd.getText());
                busHd.create(hd);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");          
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
        
    }//GEN-LAST:event_btn_hoaDonMoiActionPerformed

    private void cbb_maSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_maSachMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_maSachMousePressed

    private void cbb_maSachPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbb_maSachPopupMenuWillBecomeInvisible
        String tensach;        
        tensach = busCthd.getTenSach(this.cbb_maSach.getSelectedItem().toString());
        txt_tensach.setText(tensach);
        txt_tensach.setEnabled(false);
        int dongia;  
        Locale locale = new Locale("vi","VN");
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols formatSymbol = new DecimalFormatSymbols();
        formatSymbol.setCurrencySymbol("VND");
        format.setDecimalFormatSymbols(formatSymbol);
        dongia = busCthd.getDonGia(cbb_maSach.getSelectedItem().toString());        
        txt_giaTien.setText(format.format(dongia));
        txt_giaTien.setEnabled(false);
    }//GEN-LAST:event_cbb_maSachPopupMenuWillBecomeInvisible

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        ThongKe tk = new ThongKe();
        int tongtien = busHd.getThanhTien(txt_mahd.getText());        
        if (!batLoi.Catch(txt_mahd.getText()) && !batLoi.Catch(txt_makh.getText()) && !batLoi.Catch(txt_magg.getText())) {            
                tk.setMahd(txt_mahd.getText());                
                tk.setManv(lbl_manv.getText());
                tk.setGioBan(lable_gio.getText());
                tk.setNgayBan(lable_ngay.getText());
                tk.setTongtien(tongtien);
                busHd.thanhToan(tk);
                JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công."); 
                reset();
                cbb_mahd.removeAllItems();
                getCb_mahd();
                disenable();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_xuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatHoaDonActionPerformed
        
            //  busHd.xuatHoaDon();
            busHd.xuatHoaDon2(cbb_mahd.getSelectedItem().toString());
        
      
    }//GEN-LAST:event_btn_xuatHoaDonActionPerformed

    private void cbb_mahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_mahdActionPerformed
        ChiTietHoaDon_BUS bus = new ChiTietHoaDon_BUS();
        listCthd=bus.getList(cbb_mahd.getSelectedItem().toString());
        tableModel.setRowCount(0);
        for(ChiTietHoaDon cthd : listCthd ){
        tableModel.addRow(new Object[] {tableModel.getRowCount()+1,cthd.getMasach(),
        cthd.getTensach(),cthd.getSoluong(),cthd.getDonGia(),cthd.getThanhTien()});
        }
    }//GEN-LAST:event_cbb_mahdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BanHang_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chonkh;
    private javax.swing.JButton btn_hoaDonMoi;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_tailai;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.JButton btn_themSach;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xuatHoaDon;
    private javax.swing.JComboBox<String> cbb_loaiSach;
    private javax.swing.JComboBox<String> cbb_maSach;
    private javax.swing.JComboBox<String> cbb_mahd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lable_gio;
    private javax.swing.JLabel lable_ngay;
    private javax.swing.JLabel lbl_manv;
    private javax.swing.JLabel lbl_tenNV;
    private javax.swing.JLabel lbl_tiengg;
    private javax.swing.JLabel lbl_tongtienhd;
    private javax.swing.JTextField txt_giaTien;
    private javax.swing.JTextField txt_magg;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_makh;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenkh;
    private javax.swing.JTextField txt_tensach;
    private javax.swing.JTextField txt_thanhTien;
    // End of variables declaration//GEN-END:variables
}
