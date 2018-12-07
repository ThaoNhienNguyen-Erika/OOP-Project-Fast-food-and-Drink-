package fastfoodanddrinkstore;

import java.sql.Date;
import java.util.*;
import java.io.*;

public class HoaDonXuat {
	Scanner sc = new Scanner(System.in);
	private String	ma;
	private String	ngayxuat;
	private String thangxuat;
	private String namxuat;
	private String	manv;
	private int		tongtien;
	private String	makh;
	private String	makm;
	private int	tienkm;
	
	/*==========GETTER SETTER==========*/
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getngayxuat() {
		return ngayxuat;
	}
	public void setngayxuat(String ngayxuat) {
		this.ngayxuat = ngayxuat;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
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
	
	public String getThangxuat() {
		return thangxuat;
	}
	public void setThangxuat(String thangxuat) {
		this.thangxuat = thangxuat;
	}
	public String getNamxuat() {
		return namxuat;
	}
	public void setNamxuat(String namxuat) {
		this.namxuat = namxuat;
	}
	/*==========CONSTRUCTOR==========*/
	public HoaDonXuat() {
		
	}
	public HoaDonXuat(String ma, String ngayxuat, String thangxuat, String namxuat, String manv, int tongtien, String makh, String makm,
			int tienkm) {
		this.ma = ma;
		this.ngayxuat = ngayxuat;
		this.thangxuat = thangxuat;
		this.namxuat = namxuat;
		this.manv = manv;
		this.tongtien = tongtien;
		this.makh = makh;
		this.makm = makm;
		this.tienkm = tienkm;
	}
	public HoaDonXuat(HoaDonXuat hd) {
		 this(hd.ma, hd.ngayxuat, hd.thangxuat, hd.namxuat, hd.manv, hd.tongtien, hd.makh, hd.makm, hd.tienkm);
	}
	
	/*=========INPUT & OUTPUT==========*/
	public void nhap() {
		
		
		do{
			System.out.print("Nhap ma hoa don(5 ki tu): ");
			ma = sc.nextLine();
		}while(ma.length()!=5);
		
		System.out.print("Nhap ngay xuat:");
		ngayxuat = sc.nextLine();
		
		System.out.print("Nhap thang xuat: ");
		thangxuat = sc.nextLine();
		
		System.out.print("Nhap nam xuat: ");
		namxuat = sc.nextLine();
		
		do {
			System.out.print("Nhap ma nhan vien(5 ki tu):");
			manv = sc.nextLine();
		}while(manv.length()!=5);
		
		
		System.out.print("Nhap tong tien: ");
		tongtien = sc.nextInt();
		sc.nextLine();
		do {
			System.out.print("Nhap ma khach hang(5 ki tu): ");
			makh = sc.nextLine();
		}while(makh.length()!=5);
		
		do {
			System.out.print("Nhap ma khuyen mai: ");
			makm = sc.nextLine();
		}while(makh.length()!=5);
		
		System.out.print("Nhap tien khuyen mai: ");
		tienkm = sc.nextInt();
		
	}
	
	public void xuat()
	{
		System.out.print(ma + " | " + ngayxuat + "/" + thangxuat + "/" + namxuat + " | " + manv +  " | " + tongtien + " | " + makh + " | " + makm + " | " + tienkm);
	}
	/*==========WRITE FILE===========*/
	public void ghiFile(String fileName)throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName,Boolean.TRUE));
		try {
			out.writeUTF(ma);
			out.writeUTF(ngayxuat);
			out.writeUTF(thangxuat);
			out.writeUTF(namxuat);
			out.writeUTF(manv);
			out.writeInt(tongtien);
			out.writeUTF(makh);
			out.writeUTF(makm);
			out.writeInt(tienkm);
		}catch(IOException e) {}
		finally {
			out.close();
		}
	}
}
