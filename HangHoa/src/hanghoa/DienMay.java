/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanghoa;

/**
 *
 * @author MyPC
 */
public class DienMay extends HangHoa{
    private String ThuongHieu;
    private String LoaiMay;

    public DienMay(String ThuongHieu, String LoaiMay, int MaHang, String TenHang, int SLTon, int DonGia) {
        super(MaHang, TenHang, SLTon, DonGia);
        this.ThuongHieu = ThuongHieu;
        this.LoaiMay = LoaiMay;
    }

    public DienMay(String ThuongHieu, String LoaiMay) {
        this.ThuongHieu = ThuongHieu;
        this.LoaiMay = LoaiMay;
    }

    public DienMay() {}

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public String getLoaiMay() {
        return LoaiMay;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public void setLoaiMay(String LoaiMay) {
        this.LoaiMay = LoaiMay;
    }
    @Override
   public  String MucDoBanBuon(){
       if(this.SLTon < 3)
           return "Ban Duoc";
       return null;
   }
    @Override
   public  double ThanhTien(){
       return SLTon * DonGia * 1.1;
   }
    
}
