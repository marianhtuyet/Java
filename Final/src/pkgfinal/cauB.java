/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import finalexam.DBConnect1;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import model.KhachHang;
import model.Xe;

/**
 *
 * @author MyPC
 */
public class cauB {

    JFrame frame;
    JPanel panel;
    JLabel jlbHoTen;
    JLabel jlbSoXe;
    JLabel jlbHangXe;
    JLabel jlbNamSX;
    JComboBox<KhachHang> cmbKhachHang;
    JTextField tfSoXe;
    JTextField tfHangXe;
    JTextField tfNamSX;
    JButton btnThem;

    public cauB() throws SQLException {
        layout();
        List<KhachHang> list = getListKhachHang();
        for (KhachHang kh : list) {
            cmbKhachHang.addItem(kh);
        }
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Xe xe = new Xe();
                xe.setMaKH(((KhachHang) cmbKhachHang.getSelectedItem()).getMaKH());
                xe.setNamSX(Integer.parseInt(tfNamSX.getText()));
                xe.setHangXe(tfHangXe.getText());
                xe.setSoXe(tfSoXe.getText());
                DBConnect1.dbConnect();
                String sql = "insert into Xe values ('" + xe.getSoXe() + "', '" + xe.getHangXe() + "', " + xe.getNamSX()
                        + ", '" + xe.getMaKH() + "')";
                try {
                    int i = DBConnect1.connection.createStatement().executeUpdate(sql);
                } catch (SQLException ex) {
                }

            }
        });

    }

    public List<KhachHang> getListKhachHang() throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang";
        DBConnect1.dbConnect();
        ResultSet rs = null;
        rs = DBConnect1.connection.createStatement().executeQuery(sql);
        while (rs.next()) {
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("MaKH"));
            kh.setTenKH(rs.getString("HoTenKH"));
            kh.setDiaChi(rs.getString("DiaChi"));
            kh.setDienThoai(rs.getString("SDT"));
            list.add(kh);
        }
        return list;
    }

    void layout() {
        frame = new JFrame("Cau b");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setSize(700, 500);
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(new MatteBorder(null));

        jlbHoTen = new JLabel("Ho Ten");
        jlbHoTen.setSize(100, 15);
        jlbHoTen.setLocation(25, 50);

        jlbSoXe = new JLabel("So xe");
        jlbSoXe.setSize(100, 15);
        jlbSoXe.setLocation(25, 150);

        jlbHangXe = new JLabel("Hang xe");
        jlbHangXe.setSize(100, 15);
        jlbHangXe.setLocation(25, 250);

        jlbNamSX = new JLabel("Nam san xuat");
        jlbNamSX.setSize(100, 15);
        jlbNamSX.setLocation(25, 350);

        cmbKhachHang = new JComboBox<KhachHang>();
        cmbKhachHang.setSize(100, 20);
        cmbKhachHang.setLocation(200, 50);

        tfSoXe = new JTextField();
        tfSoXe.setSize(100, 20);
        tfSoXe.setLocation(200, 150);

        tfHangXe = new JTextField();
        tfHangXe.setSize(100, 20);
        tfHangXe.setLocation(200, 250);

        tfNamSX = new JTextField();
        tfNamSX.setSize(100, 20);
        tfNamSX.setLocation(200, 350);

        btnThem = new JButton("Them");
        btnThem.setSize(100, 50);
        btnThem.setLocation(200, 400);

        frame.add(jlbHoTen);
        frame.add(jlbSoXe);
        frame.add(jlbHangXe);
        frame.add(jlbNamSX);
        frame.add(cmbKhachHang);
        frame.add(tfHangXe);
        frame.add(tfSoXe);
        frame.add(tfNamSX);
        frame.add(btnThem);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new cauB();
    }

}
