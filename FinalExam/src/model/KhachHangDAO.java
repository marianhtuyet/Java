/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import finalexam.DBConnect1;
import finalexam.dbconnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MyPC
 */
public class KhachHangDAO {
    private KhachHang createKhachHang(ResultSet rs) throws SQLException
    {
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKH(rs.getString("MaKH"));
        khachHang.setTenKH(rs.getString("HoTenKH"));
        khachHang.setDiaChi(rs.getString("DiaChi"));
        khachHang.setDienThoai(rs.getString("SDT"));
        return  khachHang;
    }
    
    public  void AddKhachHang(KhachHang kh){
        String sql = "insert into KhachHang values ( '"+kh.getMaKH()+"',"
                + " '"+kh.getTenKH()+"', '"+kh.getDiaChi()+"', "
                + "'" + kh.getDienThoai() + "'  )";
        System.out.println(sql);
        
        try {
            int stmt = DBConnect1.dbExcuteQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Can't Add Khach hang!");
        }
    }
}
