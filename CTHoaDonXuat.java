package fastfoodanddrinkstore;

import java.util.Scanner;

public class CTHoaDonXuat {
	private String mahd;
	private String masp;
	private int dongia;
	private int thanhtien;
	private int soluong;
	private String makm;
	
	
	//Constructor;
	public CTHoaDonXuat() {
		this("HD001","SP001",6000,75000,3,"KM001");
	}
	public CTHoaDonXuat(String mahd, String masp, int dongia, int thanhtien, int soluong, String makm) {
		super();
		this.mahd = mahd;
		this.masp = masp;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
		this.soluong = soluong;
		this.makm = makm;
	}
	
	public CTHoaDonXuat(CTHoaDonXuat hd) {
		this(hd.mahd, hd.masp, hd.dongia,hd.thanhtien, hd.soluong, hd.makm);
	}
	//GETTER SETTER
	public String getMahd() {
		return mahd;
	}


	public void setMahd(String mahd) {
		this.mahd = mahd;
	}


	public String getMasp() {
		return masp;
	}


	public void setMasp(String masp) {
		this.masp = masp;
	}


	public int getDongia() {
		return dongia;
	}


	public void setDongia(int dongia) {
		this.dongia = dongia;
	}


	public int getThanhtien() {
		return thanhtien;
	}


	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public String getMakm() {
		return makm;
	}


	public void setMakm(String makm) {
		this.makm = makm;
	}
	
	//nhap
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Nhap ma hoa don(5 ki tu): ");
			this.setMahd(sc.nextLine());
		}while(mahd.length()!=5);
		
		do {
			System.out.print("Nhap ma san pham(5 ki tu): ");
			this.setMasp(sc.nextLine());
		}while(masp.length()!=5);
		
		do{
			System.out.print("Nhap don gia: ");
			this.setDongia(sc.nextInt());
		}while(dongia%1000!=0);
		
		do{
			System.out.print("Nhap thanh tien: ");
			this.setThanhtien(sc.nextInt());
		}while(thanhtien%1000!=0);

		do{
			System.out.print("Nhap so luong: ");
			this.setSoluong(sc.nextInt());
		}while(soluong <= 0);
		
		do{
			System.out.print("Nhap ma khuyen mai(5 ki tu): ");
			this.setMakm(sc.nextLine());
		}while(makm.length()!=5);

	}
	
	public void xuat() {
		System.out.println(mahd + " | " + masp + " | " + dongia + " | " + thanhtien + " | " + soluong + " | " + makm);
	}
	
	
	
	
}
