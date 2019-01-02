/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import com.sun.org.apache.xerces.internal.xs.XSConstants;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import finalexam.DBConnect1;
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
import javafx.scene.control.ComboBox;
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
public class CauD {

    JFrame frame;
    JLabel jlbSoXe, jlbTenCongViec;
    JTable tbJTable;
    JButton jbtnThem;
    JComboBox cmbCongViec, cmbSoXe;
    DefaultTableModel defaultTableModel;
    List<CongViec> listCV;
    List<BaoDuong> listBD;

    public CauD() throws SQLException {
        layout();
        LoadCombobox();

        LoadCmbSoXe();
        cmbCongViec.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    CongViec cv = (CongViec) cmbCongViec.getSelectedItem();
                    Vector v = new Vector();
                    v.add(cv.getTenCongViec());
                    v.add(cv.getDonGia());
                    defaultTableModel.addRow(v);
                }
            }
        });
        jbtnThem.addActionListener(e -> {
            BaoDuong bd = (BaoDuong) cmbSoXe.getSelectedItem();
            int row = tbJTable.getRowCount();

            for (int i = 0; i < row; i++) {
                String TenCV = tbJTable.getValueAt(i, 0).toString();
                String MaCV = getCongViec(TenCV).getMaCV();
                DBConnect1.dbConnect();
                String sql = "insert into CT_BD values ('" + bd.getMaBD() + "', '" + MaCV + "')";
                System.out.println(sql);
                try {
                    int rs = DBConnect1.connection.createStatement().executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(CauD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public CongViec getCongViec(String TenCV) {
        for (CongViec cv : listCV) {
            if (cv.getTenCongViec().equals(TenCV)) {
                return cv;
            }
        }
        return null;
    }

    public void LoadCombobox() throws SQLException {
        listCV = new ArrayList<CongViec>();
        //load het tat ca cong viec len cmb
        String sql = "select * from CongViec";
        DBConnect1.dbConnect();
        ResultSet rs = DBConnect1.connection.createStatement().executeQuery(sql);

        while (rs.next()) {
            CongViec cv = new CongViec();
            cv.setMaCV(rs.getString("MaCV"));
            cv.setTenCongViec(rs.getString("TenCongViec"));
            cv.setDonGia(rs.getInt("DonGia"));
            listCV.add(cv);
        }
        for (CongViec cv : listCV) {
            cmbCongViec.addItem(cv);
        }

    }

    public void LoadCmbSoXe() throws SQLException {
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        listBD = new ArrayList<>();
        String sql = "select * from BaoDuong where NgayGioNhan = '" + date + "'";
        DBConnect1.dbConnect();
        ResultSet rs = DBConnect1.connection.createStatement().executeQuery(sql);

        while (rs.next()) {
            BaoDuong bd = new BaoDuong();
            bd.setMaBD(rs.getString("MaBD"));
            bd.setNgayGioNhan(rs.getString("NgayGioNhan"));
            bd.setSoXe(rs.getString("SoXe"));
            listBD.add(bd);
        }
        for (BaoDuong bd : listBD) {
            cmbSoXe.addItem(bd);
        }

    }

    void layout() {
        frame = new JFrame("Cau D");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        jlbSoXe = new JLabel("Ho Ten");
        jlbSoXe.setSize(100, 15);
        jlbSoXe.setLocation(25, 50);

        jlbTenCongViec = new JLabel("So xe");
        jlbTenCongViec.setSize(100, 15);
        jlbTenCongViec.setLocation(225, 50);

        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Ten Cong Viec");
        defaultTableModel.addColumn("Don Gia");

        tbJTable = new JTable();
        tbJTable.setModel(defaultTableModel);

        tbJTable.setBounds(100, 200, 300, 300);

        jbtnThem = new JButton("Them");
        jbtnThem.setSize(100, 50);
        jbtnThem.setLocation(100, 600);

        cmbCongViec = new JComboBox();
        cmbCongViec.setSize(100, 25);
        cmbCongViec.setLocation(300, 50);

        cmbSoXe = new JComboBox();
        cmbSoXe.setSize(100, 25);
        cmbSoXe.setLocation(80, 50);

        frame.add(jlbSoXe);
        frame.add(jlbTenCongViec);
        frame.add(cmbCongViec);
        frame.add(cmbSoXe);
        frame.add(jbtnThem);
        frame.add(tbJTable);
        frame.setVisible(true);
    }

//    JComboBox<String> BaoDuong
    public static void main(String[] args) throws SQLException {
        new CauD();
    }

}
