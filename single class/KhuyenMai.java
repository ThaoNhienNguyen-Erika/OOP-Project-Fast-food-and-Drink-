package fastfoodanddrinkstore;

import java.util.Scanner;

public class KhuyenMai {
	private String makm;
	private String mota;
	private String ngbd;
	private String ngkt;
	private String masp;
	
	//GETTER SETTER
	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getNgbd() {
		return ngbd;
	}

	public void setNgbd(String ngbd) {
		this.ngbd = ngbd;
	}

	public String getNgkt() {
		return ngkt;
	}

	public void setNgkt(String ngkt) {
		this.ngkt = ngkt;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}
	
	//Constructor
	public KhuyenMai(String makm, String mota, String ngbd, String ngkt, String masp) {
		super();
		this.makm = makm;
		this.mota = mota;
		this.ngbd = ngbd;
		this.ngkt = ngkt;
		this.masp = masp;
	}
	public KhuyenMai(){
		this("KM001","Khuyen mai duoc giam tien","21/12/2009","12/12/2018","SP001");
	}
	public KhuyenMai(KhuyenMai km) {
		this(km.makm, km.mota, km.ngbd, km.ngkt, km.masp);
	}
	
	//nhap
	public void nhap()
	{
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Nhap ma khuyen mai(5 ki tu):");
			this.setMakm(sc.nextLine());
		}while(makm.length()!=5);
		
		System.out.print("Nhap mo ta:");
		this.setMota(sc.nextLine());
		
		System.out.print("Nhap ngay bat dau:");
		this.setNgbd(sc.nextLine());
		
		System.out.print("Nhap ngay ket thuc:");
		this.setNgkt(sc.nextLine());
		
		do {
			System.out.print("Nhap ma san pham(5 ki tu):");
			this.setMasp(sc.nextLine());
		}while(masp.length()!=5);
	}
	
	//xuat
	public void xuat()
	{
		System.out.print(makm + " | " + mota + " | " + ngbd + " | " + ngkt + " | " + masp);
	}
}
