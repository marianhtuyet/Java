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

public class EmployeeDAO implements DAO {

    private Employee createEmployee(ResultSet rs) {
        Employee e = new Employee();
        try {
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setEmail(rs.getString("email"));
            e.setGender(rs.getInt("gender"));
            e.setId_card_number(rs.getInt("id_card_number"));
            e.setProvince_id(rs.getInt("province_id"));
            e.setAddress(rs.getString("address"));

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Can't load database!");
        }
        return e;
    }

    public List<Employee> getEmployee() {
       // String sql = "SELECT employees.id, employees.name, employees.email, employees.gender, employees.id_card_number,provinces.name as province, employees.address FROM `employees` INNER JOIN `provinces` on employees.province_id = provinces.id ";
       String sql = "SELECT * FROM `employees`"; 
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

//    private Province createProvince(ResultSet rs) {
//        Province p = new Province();
//        try {
//            p.setIdProvince(rs.getInt("id"));
//            p.setNameProvinceString(rs.getString("name"));
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Can't load database!");
//        }
//        return p;
//    }
//    public List<Province> getProvinces(){
//    String sql = "select id, name from provinces ";
//        ObservableList<Province> list = FXCollections.observableArrayList();
//        try {
//            Class.forName(DRIVER);
//            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println("Connected");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                Province p = createProvince(rs);
//                list.add(p);
////                p.print();
//            }
//            rs.close();
//            con.close();
//        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Can't load database!");
//        }
//
//        return list;
    //}
    public  void AddEmployee(Employee e)
    {
        String sql = "INSERT INTO `employees`(`id`, `name`, `email`, `password`, `gender`, `id_card_number`, `province_id`, `address`)"
                + " VALUES ('" + e.getId() + "','" + e.getName() + "','" + e.getEmail()+ "','" + e.getPassword()+ "','"
        +  e.getGender()+ "','" +e.getId_card_number()+ "','0','" + e.getAddress()+"');";
        System.out.println(sql);
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
        }catch(ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Can't add employee into database!");
        }
    }
    public void UpdateEmployee(Employee e){
        String sql = "UPDATE `employees` SET name = ' "+ e.getName()+"',email = '"+ e.getEmail()+"' , "
                + "gender = '" +e.getGender()+"', `id_card_number` = '" +e.getId_card_number()+"', "
                + "`province_id` = '"+e.getProvince_id()+"', address = '" +e.getAddress()+"' WHERE `employees`.`id` = " + e.getId();
        System.out.println(sql);
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
        }catch(ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Can't Update employee into database!");
        }
    }

    
}
