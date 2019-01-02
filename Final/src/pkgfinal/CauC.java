/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import finalexam.DBConnect1;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import model.KhachHang;

/**
 *
 * @author MyPC
 */
public class CauC {

    JFrame frame;
    JLabel jlbSoXe, jlbTenKh, jlbMaBaoDuong, jlbSoKM, jlbNoiDung;
    JTextField tfSoXe, tfTenKH, tfMaBaoDuong, tfSoKM, tfNoiDung;
    JButton btnThemBaoDuong;

    public CauC() {
        layout();
        tfSoXe.addActionListener(e -> {
            String sql = "SELECT * FROM dbo.KhachHang INNER JOIN dbo.Xe ON Xe.MaKH = KhachHang.MaKH \n"
                    + "WHERE SoXe = '" + tfSoXe.getText() + "'";
            DBConnect1.dbConnect();
            ResultSet rs = null;
            try {
                rs = DBConnect1.connection.createStatement().executeQuery(sql);
                while (rs.next()) {

                    tfTenKH.setText(rs.getString("HoTenKH"));

                }
            } catch (SQLException ex) {
            }
        });

        btnThemBaoDuong.addActionListener(e -> {
            String sql = "insert into BaoDuong values (  '" + tfMaBaoDuong.getText() + "', '"
                    + String.valueOf(LocalDate.now()) + "', null, " + tfSoKM.getText() + ","
                    + " '" + tfNoiDung.getText() + "', '" + tfSoXe.getText() + "')";
            DBConnect1.dbConnect();

            try {
                int i = DBConnect1.connection.createStatement().executeUpdate(sql);
            } catch (SQLException ex) {
            }
        });
    }

    void layout() {
        frame = new JFrame("Cau c");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        jlbTenKh = new JLabel("Ho Ten");
        jlbTenKh.setSize(100, 15);
        jlbTenKh.setLocation(25, 150);

        jlbSoXe = new JLabel("So xe");
        jlbSoXe.setSize(100, 15);
        jlbSoXe.setLocation(25, 50);

        jlbMaBaoDuong = new JLabel("Ma bao duong");
        jlbMaBaoDuong.setSize(100, 15);
        jlbMaBaoDuong.setLocation(25, 250);

        jlbSoKM = new JLabel("so khuyen mai");
        jlbSoKM.setSize(100, 15);
        jlbSoKM.setLocation(25, 350);

        jlbNoiDung = new JLabel("Noi dung bao duong");
        jlbNoiDung.setSize(100, 15);
        jlbNoiDung.setLocation(25, 400);

        tfSoXe = new JTextField();
        tfSoXe.setSize(100, 20);
        tfSoXe.setLocation(200, 50);

        tfTenKH = new JTextField();
        tfTenKH.setSize(100, 20);
        tfTenKH.setLocation(200, 150);

        tfMaBaoDuong = new JTextField();
        tfMaBaoDuong.setSize(100, 20);
        tfMaBaoDuong.setLocation(200, 250);

        tfSoKM = new JTextField();
        tfSoKM.setSize(100, 20);
        tfSoKM.setLocation(200, 350);

        tfNoiDung = new JTextField();
        tfNoiDung.setSize(100, 20);
        tfNoiDung.setLocation(200, 400);

        btnThemBaoDuong = new JButton("Them");
        btnThemBaoDuong.setSize(100, 50);
        btnThemBaoDuong.setLocation(200, 450);

        frame.add(jlbTenKh);
        frame.add(jlbSoXe);
        frame.add(jlbMaBaoDuong);
        frame.add(jlbSoKM);
        frame.add(jlbNoiDung);
        frame.add(tfTenKH);
        frame.add(tfSoXe);
        frame.add(tfMaBaoDuong);
        frame.add(tfSoKM);
        frame.add(tfNoiDung);
        frame.add(btnThemBaoDuong);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new CauC();
    }

}
