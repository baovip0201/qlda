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
import DB.Help;
import DTO.ChucVu;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanh Phuc
 */
public class QLNV_Frame extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    DefaultTableModel model=new DefaultTableModel();
    List<NhanVien> nvList = new ArrayList<>();
    List<ChucVu> cvList= new ArrayList<>();
    nvBUS bus = new nvBUS();
    cvBUS bus1=new cvBUS();
    public QLNV_Frame() {
        initComponents();
        disenabled();
        tableModel = (DefaultTableModel) jTable1.getModel();
        //model= (DefaultTableModel) jTable2.getModel();
        showNv();
        getCb_Box();
        //showCV();
    }
    
    private void showNv(){
        //nvBUS.docDSNV();
        nvDAO data = new nvDAO();
        nvList=data.getListNV();
        tableModel.setRowCount(0);
        nvList.forEach((nhanvien)->{
        tableModel.addRow(new Object[] {nhanvien.getMaNv(),
        nhanvien.getHoTen(),nhanvien.getMaCv(),nhanvien.getDob(),nhanvien.getGender(),
        nhanvien.getDiaChi(),nhanvien.getSdt(),nhanvien.getEmail(),nhanvien.getLuong()});
        });
        
    }
    private void showCV(){
        cvList=cvDAO.getListCV();
        model.setRowCount(0);
        cvList.forEach((cv)->{
            model.addRow(new Object[]{
                cv.getMaChucVu(), cv.getChucVu(), cv.getLuong()
            });
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
     private void getCb_Box(){
         if (bus.list == null) {
            bus1.loadCbb();
        }
        for (String s : bus1.list) {
            cbb_chucVu.addItem(s);
        }
     }
    private void disenabled(){
        txt_diaChi.setEnabled(false);
        txt_hoTen.setEnabled(false);
        txt_luong.setEnabled(false);
        txt_luongChucvu.setEnabled(false);
        txt_maChucvu.setEnabled(false);
        txt_maNv.setEnabled(false);
        txt_mail.setEnabled(false);
        txt_sdt.setEnabled(false);
        txt_tenChucvu.setEnabled(false);
        cbb_chucVu.setEnabled(false);
        cbb_gioiTinh.setEnabled(false);
        jDateChooser1.setEnabled(false);
    }
   public void showTableCV() {
        Vector header = new Vector();
        header.add("Mã chức vụ");
        header.add("Chức vụ");
        header.add("Lương");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        for (ChucVu cv : bus1.dscv) {
            model.addRow(new Object[]{
                cv.getMaChucVu(), cv.getChucVu(), cv.getLuong()
            });
        }
        jTable2.setModel(model);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_maChucvu = new javax.swing.JTextField();
        txt_tenChucvu = new javax.swing.JTextField();
        txt_luongChucvu = new javax.swing.JTextField();
        btn_tailai_chucvu = new javax.swing.JButton();
        btn_themCV = new javax.swing.JButton();
        btn_suaCV = new javax.swing.JButton();
        btn_xoaCV = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        taiBtn = new javax.swing.JButton();
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

        btn_tailai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_tailai.setText("Tải lại");
        btn_tailai.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_tailai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tailaiActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_luu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_In.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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
                .addGap(93, 93, 93)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbb_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cbb_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
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
        btn_tailai_chucvu.setText("Tải lại");
        btn_tailai_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tailai_chucvuActionPerformed(evt);
            }
        });

        btn_themCV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_themCV.setText("Thêm");
        btn_themCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themCVActionPerformed(evt);
            }
        });

        btn_suaCV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_suaCV.setText("Sửa");
        btn_suaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaCVActionPerformed(evt);
            }
        });

        btn_xoaCV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoaCV.setText("Xóa");
        btn_xoaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaCVActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_save.setText("Lưu");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        taiBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        taiBtn.setText("Đọc dữ liệu");
        taiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taiBtnActionPerformed(evt);
            }
        });

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
                        .addComponent(btn_themCV)
                        .addGap(61, 61, 61)
                        .addComponent(btn_suaCV))
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
                        .addGap(183, 183, 183)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_xoaCV)
                        .addGap(66, 66, 66)
                        .addComponent(btn_save)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_luongChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taiBtn))
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
                    .addComponent(btn_themCV)
                    .addComponent(btn_suaCV)
                    .addComponent(btn_xoaCV)
                    .addComponent(btn_save)
                    .addComponent(taiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Cập nhật chức vụ", jPanel2);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý nhân viên");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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
                nv.setDob(new java.sql.Date(jDateChooser1.getDate().getTime())); 
                nv.setDiaChi(txt_diaChi.getText());
                nv.setSdt(txt_sdt.getText());
                nv.setEmail(txt_mail.getText());
                nv.setLuong(Float.parseFloat(txt_luong.getText()));
                bus.them(nv);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                jTable1.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập vào không hợp lệ, do bị trùng khóa chính");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
        showNv();
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        txt_diaChi.setEnabled(true);
        txt_hoTen.setEnabled(true);
        txt_luong.setEnabled(true);
        txt_maNv.setEnabled(true);
        txt_mail.setEnabled(true);
        txt_sdt.setEnabled(true);
        cbb_chucVu.setEnabled(true);
        cbb_gioiTinh.setEnabled(true);
        jDateChooser1.setEnabled(true);
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int i = jTable1.getSelectedRow();
        NhanVien nv = new NhanVien();
        nv.setMaNv(txt_maNv.getText());
        nv.setMaCv(cbb_chucVu.getSelectedItem().toString());
        nv.setHoTen(txt_hoTen.getText());
        nv.setGender(cbb_gioiTinh.getSelectedItem().toString());
        nv.setDob(new java.sql.Date(jDateChooser1.getDate().getTime())); 
        nv.setDiaChi(txt_diaChi.getText());
        nv.setSdt(txt_sdt.getText());
        nv.setEmail(txt_mail.getText());
        nv.setLuong(Float.parseFloat(txt_luong.getText()));
        tableModel.setValueAt(nv.getMaCv(), i, 1);
        tableModel.setValueAt(nv.getHoTen(), i, 2);
        tableModel.setValueAt(nv.getGender(), i, 3);
        tableModel.setValueAt(nv.getDob(), i, 4);
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
                //nvBUS bus=new nvBUS();
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

    private void btn_themCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themCVActionPerformed
        // TODO add your handling code here:
        txt_maChucvu.setEnabled(true);
        txt_tenChucvu.setEnabled(true);
        txt_luongChucvu.setEnabled(true);
    }//GEN-LAST:event_btn_themCVActionPerformed

    private void btn_suaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaCVActionPerformed
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        ChucVu cv = new ChucVu();
        cv.setMaChucVu(txt_maChucvu.getText());
        cv.setChucVu(txt_tenChucvu.getText());
        cv.setLuong(Float.parseFloat(txt_luongChucvu.getText()));
        model.setValueAt(cv.getLuong(), i, 2);
        bus1.sua(cv);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
    }//GEN-LAST:event_btn_suaCVActionPerformed

    private void btn_xoaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaCVActionPerformed
        // TODO add your handling code here:
        int selectIndext = jTable2.getSelectedRow();
         if(selectIndext >= 0){
            ChucVu tk =  bus1.dscv.get(selectIndext);
            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
                //SinhVien.delete(std.getId());
               bus1.xoa(tk);
               bus1.dscv.remove(tk);
               model.removeRow(selectIndext);
               jTable2.setModel(model);
            }
        }
    }//GEN-LAST:event_btn_xoaCVActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        ChucVu cv = new ChucVu();
        if (!batLoi.Catch(txt_maChucvu.getText()) && !batLoi.Catch(txt_tenChucvu.getText()) && !batLoi.Catch(txt_luongChucvu.getText())) {
            if (!cvBUS.checkPrimaryKey(txt_maChucvu.getText())) {
                cv.setMaChucVu(txt_maChucvu.getText());
                cv.setChucVu(txt_tenChucvu.getText());
                cv.setLuong(Float.parseFloat(txt_luongChucvu.getText()));
                bus1.add(cv);
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập vào không hợp lệ, do bị trùng khóa chính");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ dữ liệu, vui lòng nhập lại");
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_tailai_chucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tailai_chucvuActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        showTableCV();
    }//GEN-LAST:event_btn_tailai_chucvuActionPerformed

    private void btn_tailaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tailaiActionPerformed
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        showNv();
    }//GEN-LAST:event_btn_tailaiActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        ChucVu cv = bus1.dscv.get(i);
        txt_maChucvu.setText(cv.getMaChucVu());
        txt_tenChucvu.setText(cv.getChucVu());
        txt_luongChucvu.setText(cv.getLuong().toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void taiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taiBtnActionPerformed
        // TODO add your handling code here:
        if(bus1.dscv==null){
            bus1.doc();
        }
        showTableCV();
    }//GEN-LAST:event_taiBtnActionPerformed

    private void btn_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InActionPerformed
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
        pol.writeFileExcel("DSNHANVIEN", a);
        JOptionPane.showMessageDialog(rootPane, "Đã xuất ra excel");}
        else{
            JOptionPane.showMessageDialog(rootPane, "Dữ liệu rỗng");
        }
    }//GEN-LAST:event_btn_InActionPerformed

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
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_suaCV;
    private javax.swing.JButton btn_tailai;
    private javax.swing.JButton btn_tailai_chucvu;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_themCV;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xoaCV;
    private javax.swing.JComboBox<String> cbb_chucVu;
    private javax.swing.JComboBox<String> cbb_gioiTinh;
    private javax.swing.JComboBox<String> cbb_search;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JButton taiBtn;
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
    // End of variables declaration//GEN-END:variables
}
