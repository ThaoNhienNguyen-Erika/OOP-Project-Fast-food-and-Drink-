package fastfoodanddrinkstore;

import java.util.*;
public class NhaCungCap {
	Scanner in = new Scanner(System.in);
	private String maNcc;
	private String tenNcc;
	private String loaiHang;
	//Constructor
	public NhaCungCap() {}
	public NhaCungCap(String maNcc, String tenNcc, String loaiHang) {
		this.maNcc = maNcc;
		this.tenNcc = tenNcc;
		this.loaiHang = loaiHang;
	}
	public NhaCungCap(NhaCungCap ncc) {
		maNcc = ncc.maNcc;
		tenNcc = ncc.tenNcc;
		loaiHang = ncc.loaiHang;
	}
	//Getter and Setter
	public String getMaNcc() {
		return maNcc;
	}
	public void setMaNcc(String maNcc) {
		this.maNcc = maNcc;
	}
	public String getTenNcc() {
		return tenNcc;
	}
	public void setTenNcc(String tenNcc) {
		this.tenNcc = tenNcc;
	}
	public String getLoaiHang() {
		return loaiHang;
	}
	public void setLoaiHang(String loaiHang) {
		this.loaiHang = loaiHang;
	}
	//Input & Output
	public void nhap() {
		
	}
}
