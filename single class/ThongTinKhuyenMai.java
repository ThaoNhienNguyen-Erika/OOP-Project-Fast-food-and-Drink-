package fastfoodanddrinkstore;

import java.util.Scanner;

public class ThongTinKhuyenMai extends KhuyenMai {
	private int percent;
	private String qua;
	
	//Constructor
	public ThongTinKhuyenMai() {
		super();
		percent=50;
		qua="Chai dau an Truong Son";
	}
	public ThongTinKhuyenMai(String makm, String mota, String ngbd, String ngkt, String masp, int percent,
			String qua) {
		super(makm, mota, ngbd, ngkt, masp);
		this.percent = percent;
		this.qua = qua;
	}
	public ThongTinKhuyenMai(ThongTinKhuyenMai in) {
		super((KhuyenMai)in);
		percent = in.percent;
		qua = in.qua;
	}
	
	//GETTER SETTER
	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getQua() {
		return qua;
	}

	public void setQua(String qua) {
		this.qua = qua;
	}
	
	@Override public void nhap()
	{
		Scanner sc = new Scanner(System.in);
		super.nhap();
		do{
			System.out.print("Nhap phan tram giam gia: ");
			this.setPercent(sc.nextInt());
		}while(percent < 0 || percent > 100);
		
		System.out.print("Nhap qua tang:");
		this.setQua(sc.nextLine());
	}
	
	@Override public void xuat()
	{
		super.xuat();
		System.out.println(percent + " | " + qua);
	}
	
}
