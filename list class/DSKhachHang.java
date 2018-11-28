package fastfoodanddrinkstore;

import java.util.*;


public class DSKhachHang 
{
    KhachHang[] ds;
    int soLuongKh;
    Scanner in = new Scanner(System.in);
    //Constructor
    public DSKhachHang() {}
    public DSKhachHang(KhachHang[] ds, int soLuongKh) {
    	this.soLuongKh = soLuongKh;
    	this.ds = new KhachHang[this.soLuongKh];
    }
    public DSKhachHang(int soLuongKh) {
    	this.soLuongKh = soLuongKh;
    	ds = new KhachHang[this.soLuongKh];
    	for(int i = 0; i < soLuongKh; i++) {
    		ds[i] = new KhachHang();
    	}
    }
    public DSKhachHang(KhachHang[] ds) {
    	int dsLength = ds.length;
    	this.ds = new KhachHang[dsLength];
    	for(int i = 0;i < dsLength; i++) {
    		this.ds[i] = new KhachHang();
    		this.ds[i] = ds[i];
    	}
    }
    //Input & Output
    public void nhap() 
    {
       System.out.print("Nhap so luong khach hang: ");
       soLuongKh = in.nextInt();
       ds = new KhachHang[soLuongKh];
        for(int i = 0; i < soLuongKh; i++) {
			ds[i] = new KhachHang();
			System.out.println("Nhap thong tin khach hang "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
		for(int i=0 ; i < ds.length; i++) {
			ds[i].xuat();
			System.out.println();
		}
    }
    //add new customer: use input
    public void them() 
    {   
        System.out.print("Nhap vao thong tin cua khach hang can them: ");
        KhachHang kh = new KhachHang();
        kh.nhap();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new KhachHang();
        ds[ds.length - 1] = kh;
    }
    //add new customer: use given customer vairable
    public void them(KhachHang kh) {
    	ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = kh;
    }
    //add new customers : use input
    public void them(int soLuongKh) {
    	System.out.println("Nhap vao thong tin cua cac khach hang: ");
    	int oldLength = ds.length;
    	ds = Arrays.copyOf(ds, ds.length + soLuongKh);
    	for(int i= oldLength; i < ds.length; i++) {
    		ds[i] = new KhachHang();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    //Search with given maKh
    public int timKiem(String maKh) 
    {
        for(int i=0;i<ds.length;i++) 
        {
            if(maKh.equals(ds[i].getMaKh()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maKh
    public int timKiem() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can tim kiem (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < ds.length; i++) {
    		if(maKh.equals(ds[i].getMaKh()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    //Search with name: given name
    public void timTheoTen(String ten) {
    	ten = ten.toLowerCase();
    	boolean check = false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTenKh().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua khach hang ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with name: input name
    public void timTheoTen() {
    	System.out.println("Nhap vao ten ma ban can tim kiem: ");
    	String ten = in.nextLine();
    	ten = ten.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTenKh().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua khach hang ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with last name: given last name
    public void timTheoHo(String ho) {
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getHoKh().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua khach hang ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Search with last name: input last name
    public void timTheoHo() {
    	System.out.println("Nhap vao ho cua khach hang ban can tim kiem: ");
    	String ho = in.nextLine();
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getHoKh().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua khach hang ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Adjust with given maKh
    public void sua(String maKh) {
    	int pos = timKiem(maKh);
    	ds[pos] = new KhachHang();
    	ds[pos].nhap();
    }
    // Adjust with input makh
    public void sua() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can tim kiem (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
    	ds[pos] = new KhachHang();
    	ds[pos].nhap();
    }
    //Delete 1 customer with given maKh
    public void xoa(String maKh) {
		int pos = timKiem(maKh);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Delete 1 customer with input makh
    public void xoa() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can xoa (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Statistic by gender: given gender
    public void thongKe(String gioiTinh) {
    	boolean temp;
    	if(gioiTinh.equals("nam") == true) {
    		temp = true;
    	}else{
    		temp = false;
    	}
    	for(int i = 0; i < ds.length; i++) {
    		if(ds[i].isGioiTinh() == temp) {
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    }
    //Statistic by gender: input gender
    public void thongKe() {
    	String gioiTinh;
    	System.out.print("Nhap vao gioi tinh cua khach hang ma ban muon thong ke: ");
    	gioiTinh = in.nextLine();
    	boolean temp;
    	if(gioiTinh.equals("nam") == true) {
    		temp = true;
    	}else{
    		temp = false;
    	}
    	for(int i = 0; i < ds.length; i++) {
    		if(ds[i].isGioiTinh() == temp) {
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    }
}
