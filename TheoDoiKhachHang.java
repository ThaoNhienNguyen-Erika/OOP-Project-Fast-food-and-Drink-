/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodanddrinkstore;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TheoDoiKhachHang 
{
    Scanner in = new Scanner(System.in);
	private String maKh;
	private String ngaybatdaumua;
	private int tongtienchi;
	//Constructor
	public TheoDoiKhachHang() {
	}
	public TheoDoiKhachHang(String maKh, String ngaybatdaumua, int tongtienchi) 
        {
		this.maKh = maKh;
		this.ngaybatdaumua = ngaybatdaumua;
		this.tongtienchi = tongtienchi;
	}
	public TheoDoiKhachHang(TheoDoiKhachHang kt) 
        {
		maKh = kt.maKh;
		ngaybatdaumua = kt.ngaybatdaumua;
		tongtienchi = kt.tongtienchi;
	}
	//Getter & Setter
	public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
        public String getNgaybatdaumua(String ngaybatdaumua) {
		return ngaybatdaumua;
	}
	public void setNgaybatdaumua(String ngaybatdaumua) {
		this.ngaybatdaumua = ngaybatdaumua;
	}
        public int getTongtienchi() {
		return tongtienchi;
	}
	public void setTongtienchi(int tongtienchi) {
		this.tongtienchi = tongtienchi;
	}
        public void nhap() {
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.print("Nhap ma khach hang(5 so): ");
			this.setMaKh(sc.nextLine());
		}while(maKh.length()!=5);
		
		System.out.print("Nhap ngay bat dau mua:");
		this.setNgaybatdaumua(sc.nextLine());
		
		System.out.print("Nhap tong tien chi: ");
		this.setTongtienchi(sc.nextInt());
		sc.nextLine();
		sc.close();
	}
	public void xuat()
	{
		System.out.println(maKh + " | " + ngaybatdaumua + " | " + tongtienchi);
	}
}
