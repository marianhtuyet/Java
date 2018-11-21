/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author MyPC
 */
public class EmployeeDAO implements DAO{
 private Employee createEmployee(ResultSet rs) {
        Employee e = new Employee();
        try {
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setEmail(rs.getString("email"));
            e.setPassword(rs.getString("password"));
            e.setGender(rs.getInt("gender"));
            e.setId_card_number(rs.getInt("id_card_number"));
            e.setProvince_id(rs.getString("provinceName"));
            e.setAddress(rs.getString("address"));

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Can't load database!");
        }
        return e;
 }
 
public ObservableList<Employee> getEmployee() {
       // String sql = "SELECT employees.id, employees.name, employees.email, employees.gender, employees.id_card_number,provinces.name as province, employees.address FROM `employees` INNER JOIN `provinces` on employees.province_id = provinces.id ";
       String sql = "SELECT employees.id, employees.name, employees.email, employees.password, "
               + "employee.gender, employees.id_card_number, provinces.name as provinceName,"
               + " employees.address FROM employees INNER JOIN provinces "
               + "on employees.province_id = provinces.id"; 
       ObservableList<Employee> list = FXCollections.observableArrayList();
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employee e = createEmployee(rs);
                list.add(e);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Can't load database!");
        }

        return list;
    }

   
    
 }
 
