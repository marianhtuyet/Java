/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import com.sun.org.apache.xerces.internal.xs.XSConstants;
import com.sun.webkit.plugin.Plugin;
import finalexam.DBConnect1;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.BaoDuong;
import model.CongViec;

/**
 *
 * @author MyPC
 */
public class CauE {

    JFrame frame;
    JLabel jlbSoXe, jlbNgayNhan, jlbThanhTien;
    JTable tbJTable;
    JButton jbtnThanhToan;
    JTextField jtfNgayNhan, jtfThanhTien;
    JComboBox cmbSoXe;
    DefaultTableModel defaultTableModel;
    List<BaoDuong> listBD;

    public CauE() {

        layout();
        jtfNgayNhan.addActionListener(e -> {
            String date = jtfNgayNhan.getText();
            listBD = new ArrayList<>();
            String sql = "select * from BaoDuong where  NgayGioNhan = '" + date + "'";
            DBConnect1.dbConnect();
            ResultSet rs = null;
            try {
                rs = DBConnect1.connection.createStatement().executeQuery(sql);
                 while (rs.next()) {
                    BaoDuong bd = new BaoDuong();
                    bd.setMaBD(rs.getString("MaBD"));
                    bd.setSoXe(rs.getString("SoXe"));
                    listBD.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CauE.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            for (BaoDuong bd : listBD) {
                cmbSoXe.addItem(bd);
            }
        });
        cmbSoXe.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int TongTien = 0;
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    BaoDuong cv = (BaoDuong) cmbSoXe.getSelectedItem();

                    String sql = "select CongViec.TenCongViec, CongViec.DonGia from CT_BD inner join CongViec "
                            + "on CT_BD.MaCV = CongViec.MaCv where MaBD = '" + cv.getMaBD() + "'";
                    DBConnect1.dbConnect();
                    try {
                        ResultSet rs = DBConnect1.connection.createStatement().executeQuery(sql);
                        while (rs.next()) {
                            Vector v = new Vector();
                            v.add(rs.getString("TenCongViec"));
                            v.add(rs.getInt("DonGia"));
                            int Tong = rs.getInt("DonGia");
                            defaultTableModel.addRow(v);
                            TongTien += Tong;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CauE.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jtfThanhTien.setText(String.valueOf(TongTien));
                }
            }
        });

        jbtnThanhToan.addActionListener(e -> {
            LocalDate date = LocalDate.now();
            BaoDuong cv = (BaoDuong) cmbSoXe.getSelectedItem();
            String sql = "UPDATE dbo.BaoDuong SET NgayGioTra = '" + date.toString() + "' WHERE MaBD = '" + cv.getMaBD() + "'";
            System.out.println(sql);
            DBConnect1.dbConnect();
            try {
                int i = DBConnect1.connection.createStatement().executeUpdate(sql);
                System.out.println("pkgfinal.CauE.<init>()");
            } catch (SQLException ex) {
                Logger.getLogger(CauE.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    void layout() {
        frame = new JFrame("Cau E");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        jlbSoXe = new JLabel("So xe");
        jlbSoXe.setSize(100, 15);
        jlbSoXe.setLocation(25, 50);

        jlbNgayNhan = new JLabel("Ngay Nhan");
        jlbNgayNhan.setSize(100, 15);
        jlbNgayNhan.setLocation(300, 50);

        jlbThanhTien = new JLabel("Thanh Tien");
        jlbThanhTien.setSize(100, 15);
        jlbThanhTien.setLocation(300, 100);

        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Ten Cong Viec");
        defaultTableModel.addColumn("Don Gia");

        jtfNgayNhan = new JTextField();
        jtfNgayNhan.setBounds(400, 50, 100, 20);

        jtfThanhTien = new JTextField();
        jtfThanhTien.setBounds(400, 100, 100, 20);

        tbJTable = new JTable();
        tbJTable.setModel(defaultTableModel);
        tbJTable.setBounds(100, 200, 500, 200);

        cmbSoXe = new JComboBox();
        cmbSoXe.setSize(100, 25);
        cmbSoXe.setLocation(100, 50);

        jbtnThanhToan = new JButton("Thanh Toan");
        jbtnThanhToan.setBounds(250, 500, 150, 50);

        frame.add(jlbSoXe);
        frame.add(jlbNgayNhan);
        frame.add(jlbThanhTien);
        frame.add(cmbSoXe);
        frame.add(jtfNgayNhan);
        frame.add(jtfThanhTien);
        frame.add(tbJTable);
        frame.add(jbtnThanhToan);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CauE();
    }
//    JComboBox<String> BaoDuon
}
