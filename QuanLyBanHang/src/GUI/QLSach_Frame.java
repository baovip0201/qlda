/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.SachBUS;
import BUS.batLoi;
import BUS.loaisachBUS;
import BUS.nxbBUS;
import DAO.loaisachDAO;
import DAO.nxbDAO;
import DAO.sachDAO;
import DB.Help;
import DTO.LoaiSach;
import DTO.NhaXuatBan;
import DTO.Sach;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thanh Phuc
 */
public class QLSach_Frame extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    DefaultTableModel model=new DefaultTableModel();
    ArrayList<LoaiSach> lsList = new ArrayList<>();
    ArrayList<NhaXuatBan> nxbList = new ArrayList<>();
    ArrayList<Sach> sList = new ArrayList<>();
    
    loaisachBUS lsBUS = new loaisachBUS();
    nxbBUS nxbBUS = new nxbBUS();
    SachBUS sBUS = new SachBUS();
    
    String pathImg;
    /**
     * Creates new form QLSach
     */
    public QLSach_Frame() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        disenabled();
        tableModel = (DefaultTableModel) jTable1.getModel();
        get_CBB_LS();
        get_CBB_NXB();
        
    }

//Loai sach -----------------------------------------------------------------------------------------
    private void showLS(){
        lsList = loaisachDAO.getListLS();
        tableModel.setRowCount(0);
        lsList.forEach((ls) -> {model.addRow(new Object[]{
            ls.getMaLoaiSach(),ls.getTenLoaiSach()
        });
        });
    }
    
    private void showTableLS(){
        Vector header = new Vector();
        header.add("Mã Loại Sách");
        header.add("Tên Loại Sách");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        for (LoaiSach ls : lsBUS.dsls){
            Vector row = new Vector();
            row.add(ls.getMaLoaiSach());
            row.add(ls.getTenLoaiSach());
            model.addRow(row);
        }
        tbls.setModel(model);
        
    }
    
    private void get_CBB_LS(){
        if(sBUS.listOfLS == null){
            lsBUS.loadCBB();
        }
        
        for(String s : lsBUS.ListOfLS)
            cbb_loaiSach.addItem(s);
        
    }
    //--------------------------------------------------------------------------------------------------------
    
    // Nha Xuat Ban ------------------------------------------------------------------------------------------
    private void ShowNXB(){
        nxbList = nxbDAO.getListNXB();
        tableModel.setRowCount(0);
        nxbList.forEach((nxb) -> {model.addRow(new Object[]{
            nxb.getMaNXB(),nxb.getTenNXB(),nxb.getDiaChi(),nxb.getEmail(),nxb.getSoDienThoai()
        });
        });
    }
            
    void showTableNXB(){
        Vector header = new Vector();
        header.add("Mã Nhà Xuất Bản");
        header.add("Tên Nhà Xuất Bản");
        header.add("Địa Chỉ");
        header.add("Email");
        header.add("Số Điện Thoại");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        for (NhaXuatBan nxb: nxbBUS.dsnxb){
            Vector row = new Vector();
            row.add(nxb.getMaNXB());
            row.add(nxb.getTenNXB());
            row.add(nxb.getDiaChi());
            row.add(nxb.getEmail());
            row.add(nxb.getSoDienThoai());
            model.addRow(row);
        }
        tbnxb.setModel(model);
    } 
            
    private void get_CBB_NXB(){
        if(sBUS.listOf_maNXB == null){
            nxbBUS.loadCbb();
        }
        for(String s : nxbBUS.listOf_maNXB)
            cbb_nhaXuatBan.addItem(s);
        
    }        
            
    //-----------------------------------------------------------------------------------------------     
    
    // Sach ----------------------------------------------------------------------------------------
    private void showSach(){
        sList = sachDAO.getListSach();
        tableModel.setRowCount(0);
        sList.forEach((s) -> { model.addRow(new Object[]{
            s.getMaSach(),s.getTenSach(),s.getMaLoaiSach(),s.getMaNXB(),s.getSoLuong(),s.getGiaTien(),s.getFileAnh()
        });
        });
    }
    
    private void showTableSach(){
        Vector header = new Vector();
        header.add("Mã sách");
        header.add("Tên sách");
        header.add("Loại sách");
        header.add("Số lượng");
        header.add("Giá");
        header.add("Nhà xuất bản");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        for(Sach s : sBUS.dss){
           Vector row = new Vector();
           row.add(s.getMaSach());
           row.add(s.getTenSach());
           row.add(s.getMaLoaiSach());
           row.add(s.getMaNXB());
           row.add(s.getSoLuong());
           row.add(s.getGiaTien());
           row.add(s.getFileAnh());
           model.addRow(row);
        }
        jTable1.setModel(model);
    }
    //-----------------------------------------------------------------------------------------------
     private void disenabled(){
         txt_maLoai_cnls.setEnabled(false);
         txt_tenLoai_cnls.setEnabled(false);
         txt_maNxb_cnnxb.setEnabled(false);
         txt_tenNxb_cnnxb.setEnabled(false);
         txt_sdt_cnnxb.setEnabled(false);
         txt_diaChi_cnnxb.setEnabled(false);
         txt_sdt_cnnxb.setEnabled(false);
         txt_mail_cnnxb.setEnabled(false);
         txt_fileSach.setEnabled(false);
         txt_maSach.setEnabled(false);
         txt_tenSach.setEnabled(false);
         txt_soLuong.setEnabled(false);
         txt_gia.setEnabled(false);
         cbb_loaiSach.setEnabled(false);
         cbb_nhaXuatBan.setEnabled(false);
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
        tbls = new javax.swing.JTable();
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
        tbnxb = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý sách");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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

        lb_hinhanh.setText("Ảnh");

        btn_capNhatAnh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_capNhatAnh.setText("Cập nhật ảnh...");
        btn_capNhatAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capNhatAnhActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Loại sách:");

        txt_fileSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

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
        btn_taiLai_tts.setText("Tải lại");
        btn_taiLai_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLai_ttsActionPerformed(evt);
            }
        });

        btn_them_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them_tts.setText("Thêm");
        btn_them_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them_ttsActionPerformed(evt);
            }
        });

        btn_sua_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua_tts.setText("Sửa");

        btn_xoa_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa_tts.setText("Xóa");
        btn_xoa_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_ttsActionPerformed(evt);
            }
        });

        btn_luu_tts.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu_tts.setText("Lưu");

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
        btn_in_tts.setText("In danh sách");
        btn_in_tts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_in_ttsActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_soLuong)
                            .addComponent(txt_gia))
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btn_in_tts)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbb_loaiSach, cbb_nhaXuatBan, txt_fileSach, txt_maSach, txt_soLuong});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_capNhatAnh)
                            .addComponent(txt_fileSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cbb_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbb_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        btn_taiLai_cnls.setText("Tải lại");
        btn_taiLai_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLai_cnlsActionPerformed(evt);
            }
        });

        btn_them_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them_cnls.setText("Thêm");
        btn_them_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them_cnlsActionPerformed(evt);
            }
        });

        btn_sua_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua_cnls.setText("Sửa");
        btn_sua_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_cnlsActionPerformed(evt);
            }
        });

        btn_xoa_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa_cnls.setText("Xóa");
        btn_xoa_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_cnlsActionPerformed(evt);
            }
        });

        btn_luu_cnls.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu_cnls.setText("Lưu");
        btn_luu_cnls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_cnlsActionPerformed(evt);
            }
        });

        tbls.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbls.setModel(new javax.swing.table.DefaultTableModel(
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
        tbls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbls);

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
                        .addGap(0, 102, Short.MAX_VALUE)
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
        btn_taitai_cnnxb.setText("Tải lại");
        btn_taitai_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taitai_cnnxbActionPerformed(evt);
            }
        });

        btn_them_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them_cnnxb.setText("Thêm");
        btn_them_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them_cnnxbActionPerformed(evt);
            }
        });

        btn_sua_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua_cnnxb.setText("Sửa");
        btn_sua_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_cnnxbActionPerformed(evt);
            }
        });

        btn_xoa_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa_cnnxb.setText("Xóa");
        btn_xoa_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_cnnxbActionPerformed(evt);
            }
        });

        btn_luu_cnnxb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu_cnnxb.setText("Lưu");
        btn_luu_cnnxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_cnnxbActionPerformed(evt);
            }
        });

        tbnxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbnxb.setModel(new javax.swing.table.DefaultTableModel(
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
        tbnxb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnxbMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbnxb);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(33, 33, 33))
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

    private void btn_taiLai_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLai_cnlsActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tbls.getModel();
        model.setRowCount(0);
        showTableLS();
    }//GEN-LAST:event_btn_taiLai_cnlsActionPerformed

    private void btn_taitai_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taitai_cnnxbActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tbnxb.getModel();
        model.setRowCount(0);
        showTableNXB();
    }//GEN-LAST:event_btn_taitai_cnnxbActionPerformed

    private void btn_them_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them_cnlsActionPerformed
        // TODO add your handling code here:
        txt_maLoai_cnls.setEnabled(true);
        txt_tenSach.setEnabled(true);
    }//GEN-LAST:event_btn_them_cnlsActionPerformed

    private void btn_them_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them_cnnxbActionPerformed
        // TODO add your handling code here:
        txt_maNxb_cnnxb.setEnabled(true);
        txt_tenNxb_cnnxb.setEnabled(true);
        txt_sdt_cnnxb.setEnabled(true);
        txt_diaChi_cnnxb.setEnabled(true);
        txt_sdt_cnnxb.setEnabled(true);
        txt_mail_cnnxb.setEnabled(true);
    }//GEN-LAST:event_btn_them_cnnxbActionPerformed

    private void btn_sua_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_cnlsActionPerformed
        // TODO add your handling code here:
        int i = tbls.getSelectedRow();
        LoaiSach ls = new LoaiSach();
        ls.setMaLoaiSach(txt_maLoai_cnls.getText());
        ls.setTenLoaiSach(txt_tenSach.getText());
        model.setValueAt(ls.getTenLoaiSach(), i, 1);
        lsBUS.sua(ls);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
    }//GEN-LAST:event_btn_sua_cnlsActionPerformed

    private void btn_luu_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_cnlsActionPerformed
        // TODO add your handling code here:
        LoaiSach ls = new LoaiSach();
        if(!batLoi.Catch(txt_maLoai_cnls.getText()) && !batLoi.Catch(txt_tenLoai_cnls.getText())){
            if(!loaisachBUS.checkPrimaryKey(txt_maLoai_cnls.getText())){
                ls.setMaLoaiSach(txt_maLoai_cnls.getText());
                ls.setTenLoaiSach(txt_tenLoai_cnls.getText());
                lsBUS.them(ls);
            } else{
             JOptionPane.showMessageDialog(rootPane, "Đã thêm");
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
    }//GEN-LAST:event_btn_luu_cnlsActionPerformed

    private void tblsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsMouseClicked
        // TODO add your handling code here:
        int i = tbls.getSelectedRow();
        LoaiSach ls = lsBUS.dsls.get(i);
        txt_maLoai_cnls.setText(ls.getMaLoaiSach());
        txt_tenLoai_cnls.setText(ls.getTenLoaiSach());
    }//GEN-LAST:event_tblsMouseClicked

    private void btn_sua_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_cnnxbActionPerformed
        // TODO add your handling code here:
        int i = tbnxb.getSelectedRow();
        NhaXuatBan nxb = new NhaXuatBan();
        nxb.setMaNXB(txt_maNxb_cnnxb.getText());
        nxb.setTenNXB(txt_tenNxb_cnnxb.getText());
        nxb.setDiaChi(txt_diaChi_cnnxb.getText());
        nxb.setEmail(txt_mail_cnnxb.getText());
        nxb.setSoDienThoai(txt_sdt_cnnxb.getText());
        
        tableModel.setValueAt(nxb.getMaNXB(), i, 1);
        tableModel.setValueAt(nxb.getTenNXB(), i, 2);
        tableModel.setValueAt(nxb.getDiaChi(), i, 3);
        tableModel.setValueAt(nxb.getEmail(), i, 4);
        tableModel.setValueAt(nxb.getSoDienThoai(), i, 5);
        
        nxbBUS.sua(nxb);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
    }//GEN-LAST:event_btn_sua_cnnxbActionPerformed

    private void tbnxbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnxbMouseClicked
        // TODO add your handling code here:
        int i = tbnxb.getSelectedRow();
        NhaXuatBan nxb = nxbBUS.dsnxb.get(i);
        txt_maNxb_cnnxb.setText(nxb.getMaNXB());
        txt_tenNxb_cnnxb.setText(nxb.getTenNXB());
        txt_diaChi_cnnxb.setText(nxb.getDiaChi());
        txt_mail_cnnxb.setText(nxb.getEmail());
        txt_sdt_cnnxb.setText(nxb.getSoDienThoai());
    }//GEN-LAST:event_tbnxbMouseClicked

    private void btn_xoa_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_cnnxbActionPerformed
        // TODO add your handling code here:
        int SelectIndex = tbnxb.getSelectedRow();
        if (SelectIndex >= 0) {
            NhaXuatBan nxb = nxbList.get(SelectIndex);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
            if (option == 0) {
                nxbBUS.xoa(nxb);
                ShowNXB();
            }
        }
    }//GEN-LAST:event_btn_xoa_cnnxbActionPerformed

    private void btn_xoa_cnlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_cnlsActionPerformed
        // TODO add your handling code here:
        int SelectIndex = tbls.getSelectedRow();
        if(SelectIndex >= 0){
            LoaiSach ls = lsList.get(SelectIndex);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
            if(option == 0){
                lsBUS.xoa(ls);
                showLS();
            }
        }
    }//GEN-LAST:event_btn_xoa_cnlsActionPerformed

    private void btn_luu_cnnxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_cnnxbActionPerformed
        // TODO add your handling code here:
        NhaXuatBan nxb = new NhaXuatBan();
        if (!batLoi.Catch(txt_maNxb_cnnxb.getText()) && !batLoi.Catch(txt_tenNxb_cnnxb.getText()) && !batLoi.Catch(txt_diaChi_cnnxb.getText())
                && !batLoi.Catch(txt_mail_cnnxb.getText()) && !batLoi.Catch(txt_sdt_cnnxb.getText())) {
            if (!nxbBUS.checkPrimaryKey(txt_maNxb_cnnxb.getText())) {
                nxb.setMaNXB(txt_maNxb_cnnxb.getText());
                nxb.setTenNXB(txt_tenNxb_cnnxb.getText());
                nxb.setDiaChi(txt_diaChi_cnnxb.getText());
                nxb.setEmail(txt_mail_cnnxb.getText());
                nxb.setSoDienThoai(txt_sdt_cnnxb.getText());

                nxbBUS.add(nxb);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
            
    }//GEN-LAST:event_btn_luu_cnnxbActionPerformed

    public ImageIcon sizeOfImage(String pathImage, byte[] img) {
        ImageIcon myImage = null;
        if (pathImage != null) {
            myImage = new ImageIcon(pathImage);
        } else {
            myImage = new ImageIcon(img);
        }
        Image  img1 = myImage.getImage();
        Image img2 = img1.getScaledInstance(lb_hinhanh.getWidth(), lb_hinhanh.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    private void btn_capNhatAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capNhatAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lb_hinhanh.setIcon(sizeOfImage(path, null));
            pathImg = path;
        } else {
            JOptionPane.showMessageDialog(null, "No picture chosen");
        }
    }//GEN-LAST:event_btn_capNhatAnhActionPerformed

    private void btn_them_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them_ttsActionPerformed
        // TODO add your handling code here:
        cbb_loaiSach.setEnabled(true);
        txt_fileSach.setEnabled(true);
        txt_maSach.setEnabled(true);
        txt_tenSach.setEnabled(true);
        txt_soLuong.setEnabled(true);
        txt_gia.setEnabled(true);
        cbb_nhaXuatBan.setEnabled(true);
    }//GEN-LAST:event_btn_them_ttsActionPerformed

    private void btn_taiLai_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLai_ttsActionPerformed
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        showSach();
    }//GEN-LAST:event_btn_taiLai_ttsActionPerformed

    private void btn_in_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_in_ttsActionPerformed
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) jTable1.getModel();
        int k = 0;
        int n = tableModel.getRowCount();
        int m = tableModel.getColumnCount();
        String a[][] = new String[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
               try{ 
              a[i][j] = tableModel.getValueAt(i, j).toString();
               }
               catch(Exception e){
                   k=1;
               };
            
        }
        if(k!=1){
        Help pol = new Help();
        pol.writeFileExcel("DSSACH", a);
        JOptionPane.showMessageDialog(rootPane, "Đã xuất ra excel");}
        else{
            JOptionPane.showMessageDialog(rootPane, "Dữ liệu rỗng");
        }
    }//GEN-LAST:event_btn_in_ttsActionPerformed

    private void btn_xoa_ttsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_ttsActionPerformed
        // TODO add your handling code here:
        int selectIndex = jTable1.getSelectedRow();
        if(selectIndex >= 0){
            Sach s = sList.get(selectIndex);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chứ?");
            if(option == 0){
                sBUS.xoa(s);
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
    private javax.swing.JLabel lb_hinhanh;
    private javax.swing.JRadioButton rbtn_gia_tts;
    private javax.swing.JRadioButton rbtn_tensach_tts;
    private javax.swing.JTable tbls;
    private javax.swing.JTable tbnxb;
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
