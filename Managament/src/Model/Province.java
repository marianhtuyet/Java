/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Iterator;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author MyPC
 */
public enum Province {
    
    A(1, "Ha Noi"), B(2, "Ho Chi Minh"), C(3, "Dong Nai");
    private int IdProvince;
    private String NameProvinceString;
   
    
    private Province(int IdProvince, String NameProvinceString) {
        this.IdProvince = IdProvince;
        this.NameProvinceString = NameProvinceString;
    }
    public int getIdProvince() {
        return IdProvince;
    }

    public String getNameProvinceString() {
        return NameProvinceString;
    }

    public void setIdProvince(int IdProvince) {
        this.IdProvince = IdProvince;
    }

    public void setNameProvinceString(String NameProvinceString) {
        this.NameProvinceString = NameProvinceString;
    }
    public static Province getByCode( int ID){
       for(Province p : Province.values())
       {
           if(p.IdProvince == ID)
               return p;
       }
       return null;
    }
   @Override
   public String toString() {
       return this.NameProvinceString;
   }
}
