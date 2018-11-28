package fastfoodanddrinkstore;
import java.util.*;

public class KhachHang 
{
    private String maKh;
    private String tenKh;
    private String hoKh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDt;
    Scanner in = new Scanner(System.in);
    //Constructor
    public KhachHang() {}
    public KhachHang(String maKh, String hoKh, String tenKh, boolean gioiTinh, String soDt, String diaChi) {
    	this.maKh = maKh;
    	this.hoKh = hoKh;
    	this.tenKh = tenKh;
    	this.gioiTinh = gioiTinh;
    	this.soDt = soDt;
    	this.diaChi = diaChi;
    }
    public KhachHang(KhachHang kh) {
    	maKh = kh.maKh;
    	hoKh = kh.hoKh;
    	tenKh = kh.tenKh;
    	gioiTinh = kh.gioiTinh;
    	soDt = kh.soDt;
    	diaChi = kh.diaChi;
    }
    //Getter & Setter
    public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	public String getHoKh() {
		return hoKh;
	}
	public void setHoKh(String hoKh) {
		this.hoKh = hoKh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDt() {
		return soDt;
	}
	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}
	//Remove redundant space in string
	public String removeRedundantSpace(String myStr) {
		String newStr = myStr.trim();
		int newStrLength = newStr.length();
		String cleanStr = "";
		for(int i = 0; i < newStrLength; i++) {
			if(newStr.substring(i, i+1).equals(" ") == false || newStr.substring(i,i+1).equals(" ") && newStr.substring(i+1,i+2).equals(" ") ==  false){
				cleanStr += newStr.substring(i,i+1);
			}
		}
		return cleanStr;
	}
    //Input & Output
    public void nhap()
    {
    	//Enter maKh
        while(true) {
			System.out.print("Nhap vao ma khach hang (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
        
        //Enter hoKh
		while(true) {
			System.out.print("Nhap vao ho va chu lot cua khach hang: ");
			hoKh = in.nextLine();
			if(hoKh.equals(" ") == false && hoKh.equals("") == false && hoKh.equals(null) == false) {
				break;
			}
		}
		hoKh = removeRedundantSpace(hoKh);		//remove all redundant space from user input
		
		//Enter tenKh
		while(true) {
			System.out.print("Nhap vao ten cua khach hang: ");
			tenKh = in.nextLine();
			if(tenKh.equals(" ") == false && tenKh.equals("") == false && tenKh.equals(null) == false) {
				break;
			}
		}
		tenKh = removeRedundantSpace(tenKh);	 //remove all redundant space from user input
		
		//Enter gender
		String genderText;
		while(true) {
			System.out.print("hap vao gioi tinh cua khach hang (nam hoac nu): ");
			genderText = in.nextLine();
			if(genderText.equals("nam") == true || genderText.equals("nu") == true) {
				break;
			}
		}
		if(genderText.equals("nam") == true) {
			gioiTinh = true;
		}else {
			gioiTinh = false;
		}
		//Enter phone number
				System.out.print("Nhap vao so dien thoai cua khach hang: ");
				soDt = in.nextLine();
		
		//Enter address
		while(true) {
			System.out.print("Nhap vao dia chi cua khach hang: ");
			diaChi = in.nextLine();
			if(diaChi.equals(" ") == false && diaChi.equals("") == false && diaChi.equals(null) == false) {
				break;
			}
		}
    }
    
	public void xuat()
    {
		//handle name output
		String hoTen = hoKh + " " + tenKh;
		hoTen = hoTen.toUpperCase();
		int nameLength = hoTen.length();
		for(int i = 0; i < 28-nameLength; i++) {
			hoTen += " ";
		}
		
		//handle gender output
		String genderText;
		if(gioiTinh == true) {
			genderText = "nam";
		}else {
			genderText = "nu ";
		}
		
		//Handle address
		int addressLength = diaChi.length();
		String diaChiTam = diaChi;
		for(int i = 0; i < 90 - addressLength; i++) {
			diaChiTam += " ";
		}
		//output row
		System.out.print(maKh + " | " + hoTen + " | " + genderText + " | " + soDt + " | " + diaChiTam + " | ");
    }
}
