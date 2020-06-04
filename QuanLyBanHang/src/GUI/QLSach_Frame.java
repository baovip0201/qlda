/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.SachBUS;
import BUS.NXB_BUS;
import BUS.LoaiSachBUS;
import BUS.batLoi;
import DTO.Sach;
import DTO.LoaiSach;
import DTO.NXB;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thanh Phuc
 */
public class QLSach_Frame extends javax.swing.JFrame {
    DefaultTableModel tablemodel_sach;
    DefaultTableModel tablemodel_loaisach;
    DefaultTableModel tablemodel_nxb;
    List<Sach> listSach = new ArrayList<>();
    List<LoaiSach> listLS = new ArrayList<>();
    List<NXB> listNxb = new ArrayList<>();
    SachBUS busSach = new SachBUS();
    LoaiSachBUS busLS = new LoaiSachBUS();
    NXB_BUS busNxb = new NXB_BUS();
    public QLSach_Frame() {
        initComponents();
        tablemodel_sach = (DefaultTableModel) jTable1.getModel();
        tablemodel_loaisach = (DefaultTableModel) jTable2.getModel();
        tablemodel_nxb = (DefaultTableModel) jTable3.getModel();
        disenable();
        showSach();
        showNXB();
        showLoaiSach();
        getCb_Box();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbList1_MouseClicked(evt);
                
            }
        });
       jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               
                tbList2_MouseClicked(evt);
            }
        });
       jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               
                tbList3_MouseClicked(evt);
            }
        });


    }
    private void disenable(){
        txt_maSach.setEnabled(false);
        txt_fileSach.setEnabled(false);
    }
    private void showSach(){
        listSach = busSach.getList();
        tablemodel_sach.setRowCount(0);
        listSach.forEach(sach -> {
        tablemodel_sach.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(), sach.getMaLoaiSach(),
         sach.getSoLuong(), sach.getGiaTien(),sach.getMaNXB(), sach.getFileAnh()});
        });
    }
    private void showLoaiSach(){
        listLS = busLS.getList();
        tablemodel_loaisach.setRowCount(0);
        listLS.forEach(LS -> {
        tablemodel_loaisach.addRow(new Object[] {LS.getMaLoaiSach(), LS.getTenLoaiSach()});
        });
    }
    private void showNXB(){
        listNxb = busNxb.getList();
        tablemodel_nxb.setRowCount(0);
        listNxb.forEach(nxb -> {
        tablemodel_nxb.addRow(new Object[] {nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(),
         nxb.getEmail(), nxb.getSdt()});
        });
    }
     private void getCb_Box(){              
        listNxb = busSach.fill_cbb_nxb();
        for(NXB item: listNxb){
            cbb_nhaXuatBan.addItem(item.getMaNXB());
        }
        listLS = busSach.fill_cbb_ls();
        for(LoaiSach item2: listLS){
            cbb_loaiSach.addItem(item2.getMaLoaiSach());
        }
     }
     
     private void tbList3_MouseClicked(java.awt.event.MouseEvent evt) {                                        
         int Row = jTable3.getSelectedRow();
           txt_maNxb_cnnxb.setText(jTable3.getModel().getValueAt(Row, 0).toString());
           txt_tenNxb_cnnxb.setText(jTable3.getModel().getValueAt(Row, 1).toString());
           txt_diaChi_cnnxb.setText(jTable3.getModel().getValueAt(Row, 2).toString());
           txt_sdt_cnnxb.setText(jTable3.getModel().getValueAt(Row, 3).toString());
           txt_mail_cnnxb.setText(jTable3.getModel().getValueAt(Row, 4).toString());
    }
     
     private void tbList1_MouseClicked(java.awt.event.MouseEvent evt) {                                        
         int Row = jTable1.getSelectedRow();
           txt_maSach.setText(jTable1.getModel().getValueAt(Row, 0).toString());
           txt_tenSach.setText(jTable1.getModel().getValueAt(Row, 1).toString());
           cbb_loaiSach.setSelectedItem(jTable1.getModel().getValueAt(Row, 2).toString());
           txt_soLuong.setText(jTable1.getModel().getValueAt(Row, 3).toString());
           txt_gia.setText(jTable1.getModel().getValueAt(Row, 4).toString());
           cbb_nhaXuatBan.setSelectedItem(jTable1.getModel().getValueAt(Row, 5).toString());
           txt_fileSach.setText(jTable1.getModel().getValueAt(Row, 6).toString());
           File file = new File(txt_fileSach.getText());
            //lay duong dan luu vao csdl
            String pathFile = file.getAbsolutePath();
            //String pathFile2 = file.getAbsolutePath().replace("//", "--");
            BufferedImage b;
            txt_fileSach.setText(pathFile);
            try {
                b=ImageIO.read(file);
                lb_hinhanh.setIcon(new ImageIcon(b));
            } catch (IOException ex) {
                Logger.getLogger(QLSach_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }            

    }
     
     private void tbList2_MouseClicked(java.awt.event.MouseEvent evt) {                                        
         int Row = jTable2.getSelectedRow();
           txt_maLoai_cnls.setText(jTable2.getModel().getValueAt(Row, 0).toString());
           txt_tenLoai_cnls.setText(jTable2.getModel().getValueAt(Row, 1).toString());           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lb_hinhanh = new javax.swing.JLabel();
        btn_capNhatAnh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_fileSach = new javax.swing.JTextField();
        cbb_loaiSach = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_maSach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_tenSach = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_gia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbb_nhaXuatBan = new javax.swing.JComboBox<>();
        btn_taiLai_tts = new javax.swing.JButton();
        btn_them_tts = new javax.swing.JButton();
        btn_sua_tts = new javax.swing.JButton();
        btn_xoa_tts = new javax.swing.JButton();
        btn_luu_tts = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btn_sapXep_tts = new javax.swing.JButton();
        rbtn_tensach_tts = new javax.swing.JRadioButton();
        rbtn_gia_tts = new javax.swing.JRadioButton();
        btn_in_tts = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_maLoai_cnls = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_tenLoai_cnls = new javax.swing.JTextField();
        btn_taiLai_cnls = new javax.swing.JButton();
        btn_them_cnls = new javax.swing.JButton();
        btn_sua_cnls = new javax.swing.JButton();
        btn_xoa_cnls = new javax.swing.JButton();
        btn_luu_cnls = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_maNxb_cnnxb = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tenNxb_cnnxb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_diaChi_cnnxb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_sdt_cnnxb = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_mail_cnnxb = new javax.swing.JTextField();
        btn_taitai_cnnxb = new javax.swing.JButton();
        btn_them_cnnxb = new javax.swing.JButton();
        btn_sua_cnnxb = new javax.swing.JButton();
        btn_xoa_cnnxb = new javax.swing.JButton();
        btn_luu_cnnxb = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý sách");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\arrow-back-icon.png")); // NOI18N
        jButton1.setText("Hệ thống");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(375, 375, 375)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)))
        );

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btn_capNhatAnh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_capNhatAnh.setText("Cập nhật ảnh...");
        btn_capNhatAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capNhatAnhActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Loại sách:");

        txt_fileSach.setFont(new java.awt.Font("Times New Roman", 0, 5)); // NOI18N
        txt_fileSach.setFocusable(false);
        txt_fileSach.setHighlighter(null);

        cbb_loaiSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mã sách:");

        txt_maSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên sách:");

        txt_tenSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Số lượng:");

        txt_soLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Giá:");

        txt_gia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Nhà xuất bản:");

        cbb_nhaXuatBan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btn_taiLai_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_taiLai_tts.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\reload-icon.png")); // NOI18N
        btn_taiLai_tts.setText("Tải lại");

        btn_them_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them_tts.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Sign-Add-icon.png")); // NOI18N
        btn_them_tts.setText("Thêm");
        btn_them_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them_ttsActionPerformed(evt);
            }
        });

        btn_sua_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua_tts.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Repair-icon.png")); // NOI18N
        btn_sua_tts.setText("Sửa");
        btn_sua_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_ttsActionPerformed(evt);
            }
        });

        btn_xoa_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa_tts.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Trash-icon.png")); // NOI18N
        btn_xoa_tts.setText("Xóa");
        btn_xoa_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_ttsActionPerformed(evt);
            }
        });

        btn_luu_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu_tts.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\save.png")); // NOI18N
        btn_luu_tts.setText("Lưu");
        btn_luu_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_ttsActionPerformed(evt);
            }
        });

        btn_sapXep_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sapXep_tts.setText("Sắp xếp");

        rbtn_tensach_tts.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbtn_tensach_tts.setText("Tên sách");
        rbtn_tensach_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_tensach_ttsActionPerformed(evt);
            }
        });

        rbtn_gia_tts.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbtn_gia_tts.setText("Giá tiền");
        rbtn_gia_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_gia_ttsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_sapXep_tts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtn_tensach_tts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtn_gia_tts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sapXep_tts)
                    .addComponent(rbtn_tensach_tts)
                    .addComponent(rbtn_gia_tts))
                .addGap(22, 22, 22))
        );

        btn_in_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_in_tts.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\save.png")); // NOI18N
        btn_in_tts.setText("In danh sách");

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Loại sách", "Số lượng", "Giá", "Nhà xuất bản", "File ảnh"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_taiLai_tts)
                        .addGap(18, 18, 18)
                        .addComponent(btn_them_tts)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua_tts)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa_tts)
                        .addGap(18, 18, 18)
                        .addComponent(btn_luu_tts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_in_tts)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_capNhatAnh)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_fileSach)
                            .addComponent(cbb_loaiSach, 0, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_maSach)
                            .addComponent(txt_tenSach))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(58, 58, 58)
                                .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_soLuong)))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbb_loaiSach, cbb_nhaXuatBan, txt_maSach, txt_soLuong, txt_tenSach});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_capNhatAnh)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbb_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txt_fileSach, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(cbb_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txt_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_in_tts))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLai_tts)
                            .addComponent(btn_them_tts)
                            .addComponent(btn_sua_tts)
                            .addComponent(btn_xoa_tts)
                            .addComponent(btn_luu_tts))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin sách", jPanel2);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Mã loại:");

        txt_maLoai_cnls.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Tên loại sách:");

        txt_tenLoai_cnls.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_taiLai_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_taiLai_cnls.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\reload-icon.png")); // NOI18N
        btn_taiLai_cnls.setText("Tải lại");

        btn_them_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them_cnls.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Sign-Add-icon.png")); // NOI18N
        btn_them_cnls.setText("Thêm");
        btn_them_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them_cnlsActionPerformed(evt);
            }
        });

        btn_sua_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua_cnls.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Repair-icon.png")); // NOI18N
        btn_sua_cnls.setText("Sửa");
        btn_sua_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_cnlsActionPerformed(evt);
            }
        });

        btn_xoa_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa_cnls.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Trash-icon.png")); // NOI18N
        btn_xoa_cnls.setText("Xóa");
        btn_xoa_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_cnlsActionPerformed(evt);
            }
        });

        btn_luu_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu_cnls.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\save.png")); // NOI18N
        btn_luu_cnls.setText("Lưu");
        btn_luu_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_cnlsActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã loại sách", "Tên loại sách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maLoai_cnls, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_taiLai_cnls)
                        .addGap(117, 117, 117)
                        .addComponent(btn_them_cnls)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenLoai_cnls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addComponent(btn_sua_cnls)
                        .addGap(119, 119, 119)
                        .addComponent(btn_xoa_cnls)
                        .addGap(120, 120, 120)
                        .addComponent(btn_luu_cnls)
                        .addGap(79, 79, 79))))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_maLoai_cnls, txt_tenLoai_cnls});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_maLoai_cnls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_tenLoai_cnls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_taiLai_cnls)
                    .addComponent(btn_them_cnls)
                    .addComponent(btn_sua_cnls)
                    .addComponent(btn_xoa_cnls)
                    .addComponent(btn_luu_cnls))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập nhật loại sách", jPanel3);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Mã nhà xuất bản:");

        txt_maNxb_cnnxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Tên nhà xuất bản:");

        txt_tenNxb_cnnxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Địa chỉ:");

        txt_diaChi_cnnxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Số điện thoại:");

        txt_sdt_cnnxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Email:");

        txt_mail_cnnxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btn_taitai_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_taitai_cnnxb.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\reload-icon.png")); // NOI18N
        btn_taitai_cnnxb.setText("Tải lại");

        btn_them_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them_cnnxb.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Sign-Add-icon.png")); // NOI18N
        btn_them_cnnxb.setText("Thêm");

        btn_sua_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua_cnnxb.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Repair-icon.png")); // NOI18N
        btn_sua_cnnxb.setText("Sửa");
        btn_sua_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_cnnxbActionPerformed(evt);
            }
        });

        btn_xoa_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa_cnnxb.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\Trash-icon.png")); // NOI18N
        btn_xoa_cnnxb.setText("Xóa");
        btn_xoa_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_cnnxbActionPerformed(evt);
            }
        });

        btn_luu_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu_cnnxb.setIcon(new javax.swing.ImageIcon("D:\\Java\\QuanLyBanHang\\img\\save.png")); // NOI18N
        btn_luu_cnnxb.setText("Lưu");
        btn_luu_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_cnnxbActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhà xuất bản", "Tên nhà xuất bản", "Địa chỉ", "Email", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maNxb_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenNxb_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_diaChi_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btn_taitai_cnnxb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_them_cnnxb)
                        .addGap(104, 104, 104)
                        .addComponent(btn_sua_cnnxb)
                        .addGap(109, 109, 109)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sdt_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mail_cnnxb)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_xoa_cnnxb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(btn_luu_cnnxb)
                        .addGap(103, 103, 103))))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_diaChi_cnnxb, txt_maNxb_cnnxb, txt_sdt_cnnxb, txt_tenNxb_cnnxb});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_maNxb_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tenNxb_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_diaChi_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_sdt_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_mail_cnnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_taitai_cnnxb)
                    .addComponent(btn_them_cnnxb)
                    .addComponent(btn_sua_cnnxb)
                    .addComponent(btn_xoa_cnnxb)
                    .addComponent(btn_luu_cnnxb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cập nhật nhà xuất bản", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_tensach_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_tensach_ttsActionPerformed
        if(rbtn_tensach_tts.isSelected()){
            rbtn_gia_tts.setSelected(false);
        }
    }//GEN-LAST:event_rbtn_tensach_ttsActionPerformed

    private void rbtn_gia_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_gia_ttsActionPerformed
        if(rbtn_gia_tts.isSelected()){
            rbtn_tensach_tts.setSelected(false);
        }
    }//GEN-LAST:event_rbtn_gia_ttsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Admin_Frame admin = new Admin_Frame();
        admin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_them_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them_ttsActionPerformed
        txt_maSach.setEnabled(true);
    }//GEN-LAST:event_btn_them_ttsActionPerformed

    private void btn_them_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them_cnlsActionPerformed
        
    }//GEN-LAST:event_btn_them_cnlsActionPerformed

    private void btn_luu_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_cnlsActionPerformed
        LoaiSach ls = new LoaiSach();
        if(!batLoi.Catch(txt_maLoai_cnls.getText()) && !batLoi.Catch(txt_tenLoai_cnls.getText())){
            if(!busLS.testPrimaryKey(txt_maLoai_cnls.getText())){
                ls.setMaLoaiSach(txt_maLoai_cnls.getText());
                ls.setTenLoaiSach(txt_tenLoai_cnls.getText());
                busLS.insert(ls);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                jTable2.setModel(tablemodel_loaisach);
                showLoaiSach();
            }
        }
    }//GEN-LAST:event_btn_luu_cnlsActionPerformed

    private void btn_luu_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_cnnxbActionPerformed
        NXB nxb = new NXB();
        if (!batLoi.Catch(txt_maNxb_cnnxb.getText()) && !batLoi.Catch(txt_tenNxb_cnnxb.getText()) && !batLoi.Catch(txt_diaChi_cnnxb.getText()) && !batLoi.Catch(txt_mail_cnnxb.getText()) && !batLoi.Catch(txt_sdt_cnnxb.getText())) {
            if (!busNxb.testPrimaryKey(txt_maNxb_cnnxb.getText())) {
                nxb.setMaNXB(txt_maNxb_cnnxb.getText());
                nxb.setTenNXB(txt_tenNxb_cnnxb.getText());
                nxb.setDiaChi(txt_diaChi_cnnxb.getText());
                nxb.setEmail(txt_maNxb_cnnxb.getText());               
                nxb.setSdt(txt_sdt_cnnxb.getText());                 
                busNxb.insert(nxb);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                jTable3.setModel(tablemodel_nxb);
                showNXB();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập vào không hợp lệ, do bị trùng khóa chính");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
    }//GEN-LAST:event_btn_luu_cnnxbActionPerformed

    private void btn_capNhatAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capNhatAnhActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            //lay duong dan luu vao csdl
            String pathFile = file.getAbsolutePath();
            //String pathFile2 = file.getAbsolutePath().replace("//", "--");
            BufferedImage b;
            txt_fileSach.setText(pathFile);
            try {
                b=ImageIO.read(file);
                lb_hinhanh.setIcon(new ImageIcon(b));
            } catch (IOException ex) {
                Logger.getLogger(QLSach_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
    }//GEN-LAST:event_btn_capNhatAnhActionPerformed

    private void btn_luu_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_ttsActionPerformed
        Sach sach = new Sach();
        if (!batLoi.Catch(txt_maSach.getText()) && !batLoi.Catch(txt_fileSach.getText()) && !batLoi.Catch(txt_soLuong.getText()) && !batLoi.Catch(txt_tenSach.getText()) && !batLoi.Catch(txt_gia.getText())) {
            if (!busSach.testPrimaryKey(txt_maSach.getText())) {
                sach.setMaSach(txt_maSach.getText());
                sach.setTenSach(txt_tenSach.getText());
                sach.setFileAnh(txt_fileSach.getText());
                sach.setGiaTien(Double.parseDouble(txt_gia.getText()));               
                sach.setMaLoaiSach(cbb_loaiSach.getSelectedItem().toString());  
                sach.setMaNXB(cbb_nhaXuatBan.getSelectedItem().toString());
                sach.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
                busSach.insert(sach);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                jTable1.setModel(tablemodel_sach);
                showSach();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập vào không hợp lệ, do bị trùng khóa chính");
            }
        }
    }//GEN-LAST:event_btn_luu_ttsActionPerformed

    private void btn_sua_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_cnnxbActionPerformed
        int i = jTable3.getSelectedRow();
        NXB nxb = new NXB();
        nxb.setMaNXB(txt_maNxb_cnnxb.getText());
        nxb.setTenNXB(txt_tenNxb_cnnxb.getText());
        nxb.setDiaChi(txt_diaChi_cnnxb.getText());
        nxb.setEmail(txt_mail_cnnxb.getText());
        nxb.setSdt(txt_sdt_cnnxb.getText()); 
        
        tablemodel_nxb.setValueAt(nxb.getMaNXB(), i, 0);
        tablemodel_nxb.setValueAt(nxb.getTenNXB(), i, 1);
        tablemodel_nxb.setValueAt(nxb.getDiaChi(), i, 2);
        tablemodel_nxb.setValueAt(nxb.getSdt(), i, 3);
        tablemodel_nxb.setValueAt(nxb.getEmail(), i, 4);
        
        busNxb.update(nxb);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
        showNXB();
    }//GEN-LAST:event_btn_sua_cnnxbActionPerformed

    private void btn_xoa_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_cnnxbActionPerformed
        int selectIndext = jTable3.getSelectedRow();
         if(selectIndext >= 0){
            NXB nxb =  listNxb.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
                //SinhVien.delete(std.getId());
               busNxb.delete(nxb.getMaNXB());
                showNXB();
            }
        }
    }//GEN-LAST:event_btn_xoa_cnnxbActionPerformed

    private void btn_sua_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_cnlsActionPerformed
        int i = jTable2.getSelectedRow();
        LoaiSach ls = new LoaiSach();
        ls.setMaLoaiSach(txt_maLoai_cnls.getText());
        ls.setTenLoaiSach(txt_tenLoai_cnls.getText());
                
        tablemodel_loaisach.setValueAt(ls.getMaLoaiSach(), i, 0);
        tablemodel_loaisach.setValueAt(ls.getTenLoaiSach(), i, 1);
        busLS.update(ls);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
        showLoaiSach();
    }//GEN-LAST:event_btn_sua_cnlsActionPerformed

    private void btn_xoa_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_cnlsActionPerformed
        int selectIndext = jTable2.getSelectedRow();
         if(selectIndext >= 0){
            LoaiSach ls =  listLS.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
                //SinhVien.delete(std.getId());
               busLS.delete(ls.getMaLoaiSach());
                showLoaiSach();
            }
        }
    }//GEN-LAST:event_btn_xoa_cnlsActionPerformed

    private void btn_sua_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_ttsActionPerformed
         int i = jTable1.getSelectedRow();
        Sach sach = new Sach();
        sach.setMaSach(txt_maSach.getText());
        sach.setTenSach(txt_tenSach.getText());
        sach.setMaLoaiSach(cbb_loaiSach.getSelectedItem().toString());
        sach.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
        sach.setGiaTien(Double.parseDouble(txt_gia.getText())); 
        sach.setMaNXB(cbb_nhaXuatBan.getSelectedItem().toString());
        sach.setFileAnh(txt_fileSach.getText());
        
        tablemodel_sach.setValueAt(sach.getMaSach(), i, 0);
        tablemodel_sach.setValueAt(sach.getTenSach(), i, 1);
        tablemodel_sach.setValueAt(sach.getMaLoaiSach(), i, 2);
        tablemodel_sach.setValueAt(sach.getSoLuong(), i, 3);
        tablemodel_sach.setValueAt(sach.getGiaTien(), i, 4);
        tablemodel_sach.setValueAt(sach.getMaNXB(), i, 5);
        tablemodel_sach.setValueAt(sach.getFileAnh(), i, 6);
        
        busSach.update(sach);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
        showSach();
    }//GEN-LAST:event_btn_sua_ttsActionPerformed

    private void btn_xoa_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_ttsActionPerformed
         int selectIndext = jTable1.getSelectedRow();
         if(selectIndext >= 0){
            Sach sach =  listSach.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
                //SinhVien.delete(std.getId());
               busSach.delete(sach.getMaSach());
                showSach();
            }
        }
    }//GEN-LAST:event_btn_xoa_ttsActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLSach_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSach_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSach_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSach_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSach_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capNhatAnh;
    private javax.swing.JButton btn_in_tts;
    private javax.swing.JButton btn_luu_cnls;
    private javax.swing.JButton btn_luu_cnnxb;
    private javax.swing.JButton btn_luu_tts;
    private javax.swing.JButton btn_sapXep_tts;
    private javax.swing.JButton btn_sua_cnls;
    private javax.swing.JButton btn_sua_cnnxb;
    private javax.swing.JButton btn_sua_tts;
    private javax.swing.JButton btn_taiLai_cnls;
    private javax.swing.JButton btn_taiLai_tts;
    private javax.swing.JButton btn_taitai_cnnxb;
    private javax.swing.JButton btn_them_cnls;
    private javax.swing.JButton btn_them_cnnxb;
    private javax.swing.JButton btn_them_tts;
    private javax.swing.JButton btn_xoa_cnls;
    private javax.swing.JButton btn_xoa_cnnxb;
    private javax.swing.JButton btn_xoa_tts;
    private javax.swing.JComboBox<String> cbb_loaiSach;
    private javax.swing.JComboBox<String> cbb_nhaXuatBan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lb_hinhanh;
    private javax.swing.JRadioButton rbtn_gia_tts;
    private javax.swing.JRadioButton rbtn_tensach_tts;
    private javax.swing.JTextField txt_diaChi_cnnxb;
    private javax.swing.JTextField txt_fileSach;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_maLoai_cnls;
    private javax.swing.JTextField txt_maNxb_cnnxb;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JTextField txt_mail_cnnxb;
    private javax.swing.JTextField txt_sdt_cnnxb;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenLoai_cnls;
    private javax.swing.JTextField txt_tenNxb_cnnxb;
    private javax.swing.JTextField txt_tenSach;
    // End of variables declaration//GEN-END:variables
}
