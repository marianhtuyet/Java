/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanghoa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author MyPC
 */
public class GiaDung extends HangHoa{
    private Calendar NgaySX;
    private Calendar NgayNhap;
    private String Loai;

    public Calendar getNgaySX() {
        return NgaySX;
    }

    public Calendar getNgayNhap() {
        return NgayNhap;
    }

    public String getLoai() {
        return Loai;
    }

    public void setNgaySX(Calendar NgaySX) {
        this.NgaySX = NgaySX;
    }

    public void setNgayNhap(Calendar NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public GiaDung() {
    }

    public GiaDung(Calendar NgaySX, Calendar NgayNhap, String Loai) {
        this.NgaySX = NgaySX;
        this.NgayNhap = NgayNhap;
        this.Loai = Loai;
    }
    
    
    
    @Override
   public  String MucDoBanBuon(){
       Calendar now = Calendar.getInstance();
         now.add(Calendar.DATE, -20);
         if(now.compareTo(this.NgayNhap) == 1 && SLTon > 10 )
             return "Ban cham";
       return null;
   }
    @Override
   public  double ThanhTien(){
       return SLTon * DonGia * 1.1;
   }
    
}
