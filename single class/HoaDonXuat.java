package fastfoodanddrinkstore;

import java.sql.Date;
import java.util.Scanner;

public class HoaDonXuat {
	private String	ma;
	private String	ngxuat;
	private String	manv;
	private String	ghichu;
	private int		tongtien;
	private String	makh;
	private String	makm;
	private int	tienkm;
	
	//GETTER SETTER
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getNgxuat() {
		return ngxuat;
	}
	public void setNgxuat(String ngxuat) {
		this.ngxuat = ngxuat;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getMakm() {
		return makm;
	}
	public void setMakm(String makm) {
		this.makm = makm;
	}
	public int getTienkm() {
		return tienkm;
	}
	public void setTienkm(int tienkm) {
		this.tienkm = tienkm;
	}
	
	//Constructor
	public HoaDonXuat() {
		this("DCT11","17/8/2018","FGH01","No",65000,"KH001","KM0001",20000);
		
	}
	public HoaDonXuat(String ma, String ngxuat, String manv, String ghichu, int tongtien, String makh, String makm,
			int tienkm) {
		this.ma = ma;
		this.ngxuat = ngxuat;
		this.manv = manv;
		this.ghichu = ghichu;
		this.tongtien = tongtien;
		this.makh = makh;
		this.makm = makm;
		this.tienkm = tienkm;
	}
	public HoaDonXuat(HoaDonXuat hd) {
		 this(hd.ma, hd.ngxuat, hd.manv, hd.ghichu, hd.tongtien, hd.makh, hd.makm, hd.tienkm);
	}
	
	//nhap
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.print("Nhap ma hoa don(5 ki tu): ");
			this.setMa(sc.nextLine());
		}while(ma.length()!=5);
		
		System.out.print("Nhap ngay xuat:");
		this.setNgxuat(sc.nextLine());
		
		do {
			System.out.print("Nhap ma nhan vien(5 ki tu):");
			this.setManv(sc.nextLine());
		}while(manv.length()!=5);
		
		System.out.print("Ghi chu: ");
		this.setGhichu(sc.nextLine());
		
		System.out.print("Nhap tong tien: ");
		this.setTongtien(sc.nextInt());
		sc.nextLine();
		do {
			System.out.print("Nhap ma khach hang(5 ki tu): ");
			this.setMakh(sc.nextLine());
		}while(makh.length()!=5);
		
		do {
			System.out.print("Nhap ma khuyen mai: ");
			this.setMakm(sc.nextLine());
		}while(makh.length()!=5);
		
		System.out.print("Nhap ma tien khuyen mai: ");
		this.setMakh(sc.nextLine());
		
		sc.close();
	}
	
	public void xuat()
	{
		System.out.println(ma + " | " + ngxuat + " | " + manv + " | " + ghichu + " | " + tongtien + " | " + makh + " | " + makm + " | " + tienkm);
	}
	
}
