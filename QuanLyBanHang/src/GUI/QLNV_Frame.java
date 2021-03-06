/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import BUS.nvBUS;
import DAO.nvDAO;
import BUS.batLoi;
import BUS.cvBUS;
import DAO.cvDAO;
import DB.ExcelPoiUtil;
import DB.Help;
import DTO.ChucVu;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Thanh Phuc
 */
public class QLNV_Frame extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    DefaultTableModel tableModel2;
    List<NhanVien> nvList = new ArrayList<>();
    List<ChucVu> cvList = new ArrayList<>();
    nvBUS bus = new nvBUS();
    public QLNV_Frame() {
        initComponents();
        disenabled();
        tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel2 = (DefaultTableModel) jTable2.getModel();
        showNv();
        showCv();
       // showTableCV();
       //showTableNV();
       getCb_Box();
       jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListMouseClicked(evt);
                
            }
        });
       jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               
                tbList2MouseClicked(evt);
            }
        });
    }
    
    private void showNv(){
        nvList=bus.getListNV();
        tableModel.setRowCount(0);
        nvList.forEach((nhanvien)->{
        tableModel.addRow(new Object[] {nhanvien.getMaNv(),
        nhanvien.getHoTen(),nhanvien.getMaCv(),nhanvien.getDob(),nhanvien.getGender(),
        nhanvien.getDiaChi(),nhanvien.getSdt(),nhanvien.getEmail(),nhanvien.getLuong()});
        });
        
    }
    private void showCv(){
        //nvBUS.docDSNV();        
        cvList=cvBUS.getListCV();
        tableModel2.setRowCount(0);
        cvList.forEach((nhanvien)->{
        tableModel2.addRow(new Object[] {nhanvien.getMaChucVu(),
        nhanvien.getChucVu(),nhanvien.getLuong()});
        });
        
    }
    
      public void showTableNV() {
        Vector header = new Vector();
        header.add("Mã nhân viên");
        header.add("Mã chức vụ");
        header.add("Họ tên");
        header.add("Giới tính");
        header.add("Ngày sinh");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        header.add("Email");
        header.add("Lương");
        if (tableModel.getRowCount() == 0) {
            tableModel = new DefaultTableModel(header, 0);
        }
        for (NhanVien nv : bus.dsnv) {
            tableModel.addRow(new Object[]{
                nv.getMaNv(), nv.getMaCv(), nv.getHoTen(), nv.getGender(), nv.getDob(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getLuong()
            });
        }
        jTable1.setModel(tableModel);
    }
      
      public void showTableCV() {
        Vector header = new Vector();
        header.add("Mã chức vụ");
        header.add("Chức vụ");
        header.add("Lương");
//        if (tableModel2.getRowCount() == 0) {
           // tableModel2 = new DefaultTableModel(header, 0);
        //}
        for (ChucVu cv : cvBUS.dscv) {
            tableModel2.addRow(new Object[]{
                cv.getMaChucVu(), cv.getChucVu(), cv.getLuong()
            });
        }
        jTable2.setModel(tableModel2);
    }
     private void getCb_Box(){        
        List<ChucVu> list=new ArrayList<>();
        nvBUS bus = new nvBUS();
        list = bus.fill_cbb();
        for(ChucVu item: list){
            cbb_chucVu.addItem(item.getMaChucVu());
        }
        
     }
    private void disenabled(){        
        txt_luong.setEnabled(false);        
        txt_maChucvu.setEnabled(false);
        txt_maNv.setEnabled(false);
        
    }
   
    private void tbListMouseClicked(java.awt.event.MouseEvent evt) {                                        
         int Row = jTable1.getSelectedRow();
           txt_maNv.setText(jTable1.getModel().getValueAt(Row, 0).toString());
           txt_hoTen.setText(jTable1.getModel().getValueAt(Row, 1).toString());
           cbb_chucVu.setSelectedItem(jTable1.getModel().getValueAt(Row, 2).toString());
           jDateChooser1.setDateFormatString(jTable1.getModel().getValueAt(Row, 3).toString());
           cbb_gioiTinh.setSelectedItem(jTable1.getModel().getValueAt(Row, 4).toString());
           txt_diaChi.setText(jTable1.getModel().getValueAt(Row, 5).toString());
           txt_sdt.setText(jTable1.getModel().getValueAt(Row, 6).toString());
           txt_mail.setText(jTable1.getModel().getValueAt(Row, 7).toString());
           txt_luong.setText(jTable1.getModel().getValueAt(Row, 8).toString());
    }
    
    private void tbList2MouseClicked(java.awt.event.MouseEvent evt) {                                        
         int Row = jTable2.getSelectedRow();
           txt_maChucvu.setText(jTable2.getModel().getValueAt(Row, 0).toString());
           txt_tenChucvu.setText(jTable2.getModel().getValueAt(Row, 1).toString());
           txt_luongChucvu.setText(jTable2.getModel().getValueAt(Row, 2).toString());           
    }
    public java.sql.Date Convert(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maNv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbb_chucVu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        cbb_gioiTinh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_diaChi = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_luong = new javax.swing.JTextField();
        btn_tailai = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_In = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        cbb_search = new javax.swing.JComboBox<>();
        jExcel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_maChucvu = new javax.swing.JTextField();
        txt_tenChucvu = new javax.swing.JTextField();
        txt_luongChucvu = new javax.swing.JTextField();
        btn_tailai_chucvu = new javax.swing.JButton();
        them_cv = new javax.swing.JButton();
        sua_cv = new javax.swing.JButton();
        xoa_cv = new javax.swing.JButton();
        luu_cv = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        txt_maNv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Chức vụ:");

        cbb_chucVu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbb_chucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_chucVuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Họ tên:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Giới tính:");

        txt_hoTen.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        cbb_gioiTinh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbb_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Ngày sinh:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Địa chỉ:");

        txt_diaChi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_diaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diaChiActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("MMM dd, yyyy");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Số điện thoại:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Lương:");

        txt_sdt.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        txt_mail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Chức vụ", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txt_luong.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_luong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_luongActionPerformed(evt);
            }
        });

        btn_tailai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_tailai.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\reload-icon.png")); // NOI18N
        btn_tailai.setText("Tải lại");
        btn_tailai.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_tailai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tailaiActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Sign-Add-icon.png")); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Repair-icon.png")); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Trash-icon.png")); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_luu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\save.png")); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_In.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_In.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\print.png")); // NOI18N
        btn_In.setText("In danh sách");
        btn_In.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_In.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InActionPerformed(evt);
            }
        });

        txt_search.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_search.setText("Tìm kiếm...");
        txt_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_searchMouseClicked(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        cbb_search.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbb_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên nhân viên", "Mã nhân viên" }));

        jExcel.setText("Import Excel");
        jExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maNv))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbb_gioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_tailai)
                                .addGap(240, 240, 240))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(49, 49, 49)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_sua)
                        .addGap(64, 64, 64)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_diaChi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(57, 57, 57)
                                .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_xoa)
                        .addGap(50, 50, 50)
                        .addComponent(btn_luu)
                        .addGap(48, 48, 48)
                        .addComponent(btn_In)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cbb_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396)
                .addComponent(jExcel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_diaChi, txt_hoTen, txt_maNv, txt_mail, txt_sdt});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_maNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbb_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbb_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tailai)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_luu)
                    .addComponent(btn_In))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Thông tin nhân viên", jPanel1);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Mã chức vụ:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Chức vụ:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Lương:");

        txt_maChucvu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txt_tenChucvu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txt_luongChucvu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btn_tailai_chucvu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_tailai_chucvu.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\reload-icon.png")); // NOI18N
        btn_tailai_chucvu.setText("Tải lại");
        btn_tailai_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tailai_chucvuActionPerformed(evt);
            }
        });

        them_cv.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        them_cv.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Sign-Add-icon.png")); // NOI18N
        them_cv.setText("Thêm");
        them_cv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them_cvActionPerformed(evt);
            }
        });

        sua_cv.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sua_cv.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Repair-icon.png")); // NOI18N
        sua_cv.setText("Sửa");
        sua_cv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua_cvActionPerformed(evt);
            }
        });

        xoa_cv.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        xoa_cv.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Trash-icon.png")); // NOI18N
        xoa_cv.setText("Xóa");
        xoa_cv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa_cvActionPerformed(evt);
            }
        });

        luu_cv.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        luu_cv.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\print.png")); // NOI18N
        luu_cv.setText("Lưu");
        luu_cv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luu_cvActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã chức vụ", "Chức vụ", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_tailai_chucvu)
                        .addGap(60, 60, 60)
                        .addComponent(them_cv)
                        .addGap(61, 61, 61)
                        .addComponent(sua_cv))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(xoa_cv)
                        .addGap(66, 66, 66)
                        .addComponent(luu_cv))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_luongChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_luongChucvu, txt_maChucvu, txt_tenChucvu});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txt_maChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_tenChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_luongChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tailai_chucvu)
                    .addComponent(them_cv)
                    .addComponent(sua_cv)
                    .addComponent(xoa_cv)
                    .addComponent(luu_cv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Cập nhật chức vụ", jPanel2);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý nhân viên");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\arrow-back-icon.png")); // NOI18N
        jButton1.setText("Hệ thống");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(328, 328, 328)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_diaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diaChiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Admin_Frame admin = new Admin_Frame();
        admin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        NhanVien nv = new NhanVien();
        if (!batLoi.Catch(txt_maNv.getText()) && !batLoi.Catch(txt_hoTen.getText()) && !batLoi.Catch(txt_diaChi.getText()) && !batLoi.Catch(txt_sdt.getText()) && !batLoi.Catch(txt_mail.getText()) && !batLoi.Catch(txt_luong.getText())) {
            if (!bus.checkPrimaryKey(txt_maNv.getText())) {
                nv.setMaNv(txt_maNv.getText());
                nv.setMaCv(cbb_chucVu.getSelectedItem().toString());
                nv.setHoTen(txt_hoTen.getText());
                nv.setGender(cbb_gioiTinh.getSelectedItem().toString());               
                nv.setDob(Convert(jDateChooser1.getDate()).toString()); 
                nv.setDiaChi(txt_diaChi.getText());
                nv.setSdt(txt_sdt.getText());
                nv.setEmail(txt_mail.getText());
                nv.setLuong(Float.parseFloat(txt_luong.getText()));
                bus.them(nv);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                jTable1.setModel(tableModel);
                showTableNV();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập vào không hợp lệ, do bị trùng khóa chính");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
        //showNv();
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        txt_maNv.setEnabled(true);
        txt_diaChi.setText("");
        txt_hoTen.setText("");
        txt_maNv.setText("");
        txt_mail.setText("");
        txt_sdt.setText("");
        
   
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int i = jTable1.getSelectedRow();
        NhanVien nv = new NhanVien();
        nv.setMaNv(txt_maNv.getText());
        nv.setMaCv(cbb_chucVu.getSelectedItem().toString());
        nv.setHoTen(txt_hoTen.getText());
        nv.setGender(cbb_gioiTinh.getSelectedItem().toString());
        nv.setDob(Convert(jDateChooser1.getDate()).toString()); 
        nv.setDiaChi(txt_diaChi.getText());
        nv.setSdt(txt_sdt.getText());
        nv.setEmail(txt_mail.getText());
        nv.setLuong(Float.parseFloat(txt_luong.getText()));
        tableModel.setValueAt(nv.getMaNv(), i, 0);
        tableModel.setValueAt(nv.getHoTen(), i, 1);
        tableModel.setValueAt(nv.getMaCv(), i, 2);
        tableModel.setValueAt(nv.getDob(), i, 3);
        tableModel.setValueAt(nv.getGender(), i, 4);
        tableModel.setValueAt(nv.getDiaChi(), i, 5);
        tableModel.setValueAt(nv.getSdt(), i, 6);
        tableModel.setValueAt(nv.getEmail(), i, 7);
        tableModel.setValueAt(nv.getLuong(), i, 8);

        bus.sua(nv);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
        showNv();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int selectIndext = jTable1.getSelectedRow();
         if(selectIndext >= 0){
            NhanVien tk =  nvList.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
                //SinhVien.delete(std.getId());
               bus.xoa(tk.getMaNv());
                showNv();
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        String tf = txt_search.getText();
        String select = (String) cbb_search.getSelectedItem();
        switch (select) {
            case "Mã nhân viên":
                bus.searchMaNV(tf);
                tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);
                showTableNV();
                break;
            case "Tên nhân viên":
                bus.searchTenNV(tf);
                tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);
                showTableNV();
                break;
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_searchMouseClicked
        
        txt_search.setText("");
    }//GEN-LAST:event_txt_searchMouseClicked

    private void them_cvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them_cvActionPerformed
        txt_maChucvu.setEnabled(true); 
        txt_luongChucvu.setText("");
        txt_tenChucvu.setText("");
        txt_maChucvu.setText("");
    }//GEN-LAST:event_them_cvActionPerformed

    private void luu_cvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luu_cvActionPerformed
        ChucVu cv = new ChucVu();
        if (!batLoi.Catch(txt_maChucvu.getText()) && !batLoi.Catch(txt_tenChucvu.getText()) && !batLoi.Catch(txt_luongChucvu.getText())) {
            if (!cvBUS.checkPrimaryKey(txt_maChucvu.getText())) {
                cv.setMaChucVu(txt_maChucvu.getText());
                cv.setChucVu(txt_tenChucvu.getText());
                cv.setLuong(Float.parseFloat(txt_luongChucvu.getText()));
                cvBUS.them(cv);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                showTableCV();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập vào không hợp lệ, do bị trùng khóa chính");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
    }//GEN-LAST:event_luu_cvActionPerformed

    private void sua_cvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua_cvActionPerformed
       int i = jTable2.getSelectedRow();
        ChucVu cv = new ChucVu();
        cv.setMaChucVu(txt_maChucvu.getText());
        cv.setChucVu(txt_tenChucvu.getText());
        cv.setLuong(Float.parseFloat(txt_luongChucvu.getText()));
        tableModel2.setValueAt(cv.getChucVu(), i, 1);
        tableModel2.setValueAt(cv.getLuong(), i, 2);
        cvBUS.sua(cv);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
    }//GEN-LAST:event_sua_cvActionPerformed

    private void xoa_cvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa_cvActionPerformed
        int selectIndext = jTable2.getSelectedRow();
         if(selectIndext >= 0){
            ChucVu tk =  cvList.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
               cvBUS.xoa(tk.getMaChucVu());
               showCv();
            }
        }
    }//GEN-LAST:event_xoa_cvActionPerformed

    private void cbb_chucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_chucVuActionPerformed
        Float nv = new Float(0);
       // qltk_BUS bus = new qltk_BUS();
        nv=bus.fill_LuongNhanVien(cbb_chucVu.getSelectedItem().toString());
        txt_luong.setText(Float.toString(nv));
        txt_luong.setEnabled(false);
    }//GEN-LAST:event_cbb_chucVuActionPerformed

    private void btn_tailaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tailaiActionPerformed
        showNv();
    }//GEN-LAST:event_btn_tailaiActionPerformed

    private void btn_tailai_chucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tailai_chucvuActionPerformed
        showCv();
    }//GEN-LAST:event_btn_tailai_chucvuActionPerformed

    private void txt_luongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_luongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_luongActionPerformed

    private void btn_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InActionPerformed
        tableModel = (DefaultTableModel) jTable1.getModel();
        int k = 0;
        int n = tableModel.getRowCount();
        int m = tableModel.getColumnCount();
        String a[][] = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                try {                    
                    a[i][j] = tableModel.getValueAt(i, j).toString();
                } catch (Exception e) {
                    k = 1;
                }
            };
            
        }
        if (k != 1) {
            Help pol = new Help();
            pol.writeFileExcel("DSNHANVIEN", a);
            JOptionPane.showMessageDialog(rootPane, "Đã xuất ra excel");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Dữ liệu rỗng");
        }
    }//GEN-LAST:event_btn_InActionPerformed
    JFileChooser fileDialog= new JFileChooser();
    private void jExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcelActionPerformed
       int result = fileDialog.showOpenDialog(null);
       NhanVien nv = new NhanVien();
        if (result == JFileChooser.APPROVE_OPTION) {
            List<NhanVien> excelvalues = new ArrayList<>();
            File f = fileDialog.getSelectedFile();
            String fileLocation = f.getAbsolutePath();
            String fileName = f.getName();
             Workbook workbook;
             System.err.println(fileName);
            try {
                workbook = ExcelPoiUtil.getWorkBook(fileName, fileLocation);
                Sheet sheet = workbook.getSheetAt(0);
             
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    //get date from excel in java
                    DataFormatter dataFormatter = new DataFormatter();
                    String cellStringValue = dataFormatter.formatCellValue(row.getCell(4));                    
                    
                    nv.setMaNv(ExcelPoiUtil.getCellValue(row.getCell(0)));
                    nv.setMaCv(ExcelPoiUtil.getCellValue(row.getCell(1)));
                    nv.setHoTen(ExcelPoiUtil.getCellValue(row.getCell(2)));
                    nv.setGender(ExcelPoiUtil.getCellValue(row.getCell(3)));
                    nv.setDob(cellStringValue);
                    nv.setDiaChi(ExcelPoiUtil.getCellValue(row.getCell(5)));
                    nv.setSdt(ExcelPoiUtil.getCellValue(row.getCell(6)));
                    nv.setEmail(ExcelPoiUtil.getCellValue(row.getCell(7)));
                    nv.setLuong(Float.parseFloat(ExcelPoiUtil.getCellValue(row.getCell(8))));
                    excelvalues.add(nv);
                    
                }
                }catch (IOException ex) {
                Logger.getLogger(QLNV_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            bus.them(nv);
        }
    }//GEN-LAST:event_jExcelActionPerformed

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
            java.util.logging.Logger.getLogger(QLNV_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNV_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNV_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNV_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNV_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_In;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_tailai;
    private javax.swing.JButton btn_tailai_chucvu;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_chucVu;
    private javax.swing.JComboBox<String> cbb_gioiTinh;
    private javax.swing.JComboBox<String> cbb_search;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JButton jExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton luu_cv;
    private javax.swing.JButton sua_cv;
    private javax.swing.JButton them_cv;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_luong;
    private javax.swing.JTextField txt_luongChucvu;
    private javax.swing.JTextField txt_maChucvu;
    private javax.swing.JTextField txt_maNv;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tenChucvu;
    private javax.swing.JButton xoa_cv;
    // End of variables declaration//GEN-END:variables
}
