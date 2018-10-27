/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MyPC
 */
public class EmployeeDAO implements DAO{
    private Employee createEmployee(ResultSet rs){
        Employee e = new Employee();
        try{
            e.setID(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setEmail(rs.getString("email"));
            e.setPassword(rs.getString("email"));
            e.setSex(rs.getInt("sex"));
            e.setID_card_number(rs.getInt("id_card_number"));
            e.setProvince_id(rs.getInt("province_id"));
            e.setAddress(rs.getString("address"));
            e.setCreate_at(rs.getDate("create_at"));
            e.setUpdate_at(rs.getDate("update_at"));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return e;
    }
}
