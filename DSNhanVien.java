package fastfoodanddrinkstore;

import java.util.*;
public class DSNhanVien {
	Scanner in = new Scanner(System.in);
	private int soLuongNv;
	private NhanVien[] ds;
	//Constructor
    public DSNhanVien() {}
    public DSNhanVien(NhanVien[] ds, int soLuongNv) {
    	this.soLuongNv = soLuongNv;
    	this.ds = new NhanVien[this.soLuongNv];
    }
    public DSNhanVien(int soLuongNv) {
    	this.soLuongNv = soLuongNv;
    	ds = new NhanVien[this.soLuongNv];
    	for(int i = 0; i < soLuongNv; i++) {
    		ds[i] = new NhanVien();
    	}
    }
    public DSNhanVien(NhanVien[] ds) {
    	this.soLuongNv = ds.length;
    	this.ds = new NhanVien[soLuongNv];
    	for(int i = 0;i < soLuongNv; i++) {
    		this.ds[i] = new NhanVien();
    		this.ds[i] = ds[i];
    	}
    }
    //Input & Output
    public void nhap() 
    {
       System.out.print("Nhap so luong nhan vien: ");
       soLuongNv = in.nextInt();
       ds = new NhanVien[soLuongNv];
        for(int i = 0; i < soLuongNv; i++) {
			ds[i] = new NhanVien();
			System.out.println("Nhap thong tin cua nhan vien "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
		for(int i=0 ; i < ds.length; i++) {
			ds[i].xuat();
		}
    }
    //add new employee: use input
    public void them() 
    {   
        System.out.println("Nhap vao thong tin cua nhan vien can them: ");
        NhanVien nv = new NhanVien();
        nv.nhap();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new NhanVien();
        ds[ds.length - 1] = nv;
    }
    //add new employee: use given customer vairable
    public void them(NhanVien nv) {
    	ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = nv;
    }
    //add new employees : use input
    public void them(int soLuongNv) {
    	System.out.println("Nhap vao thong tin cua cac nhan vien: ");
    	int oldLength = ds.length;
    	ds = Arrays.copyOf(ds, ds.length + soLuongNv);
    	for(int i= oldLength; i < ds.length; i++) {
    		ds[i] = new NhanVien();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    //Search with given maNv
    public int timKiem(String maKh) 
    {
        for(int i=0;i<ds.length;i++) 
        {
            if(maKh.equals(ds[i].getMaNv()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maNv
    public int timKiem() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma nhan vien can tim kiem (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < ds.length; i++) {
    		if(maKh.equals(ds[i].getMaNv()) == true) {
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
    		String temp = ds[i].getTenNv().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with name: input name
    public void timTheoTen() {
    	System.out.println("Nhap vao ten nhan vien ma ban can tim kiem: ");
    	String ten = in.nextLine();
    	ten = ten.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTenNv().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with last name: given last name
    public void timTheoHo(String ho) {
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getHoNv().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua nhan vien ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Search with last name: input last name
    public void timTheoHo() {
    	System.out.println("Nhap vao ho cua nhan vien ban can tim kiem: ");
    	String ho = in.nextLine();
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getHoNv().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua nhan vien ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Adjust with given maKh
    public void sua(String maNv) {
    	int pos = timKiem(maNv);
    	ds[pos] = new NhanVien();
    	ds[pos].nhap();
    }
    // Adjust with input makh
    public void sua() {
    	String maNv;
    	while(true) {
			System.out.print("Nhap vao nhan vien can sua thong tin (5 so): ");
			maNv = in.nextLine();
			if(maNv.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maNv);
    	ds[pos] = new NhanVien();
    	ds[pos].nhap();
    }
    //Delete 1 employee with given maKh
    public void xoa(String maNv) {
		int pos = timKiem(maNv);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Delete 1 employee with input makh
    public void xoa() {
    	String maNv;
    	while(true) {
			System.out.print("Nhap vao ma nhan vien can xoa (5 so): ");
			maNv = in.nextLine();
			if(maNv.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maNv);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Statistic by gender: given gender
    public void thongKeGioiTinh(String gioiTinh) {
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
    public void thongKeGioiTinh() {
    	String gioiTinh;
    	System.out.print("Nhap vao gioi tinh nhan vien ma ban muon thong ke: ");
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
    		}
    	}
    }
    //Statistic by birthyear: given year
    public void thongKeNamSinh(int year) {
		int yearNum;
		int cnt = 0;
		System.out.println("********************************************************************************************************************");
		System.out.println("Danh sach cac nhan vien sinh nam " + year + " : ");
		for(int i = 0; i < ds.length; i++) {
			yearNum = Integer.parseInt(ds[i].getNgaySinh().substring(4, 8));
			if(yearNum == year) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nha vien sinh nam " + year + " la: " + cnt);
	}
    //Statistic by birthyear: input
    public void thongKeNamSinh() {
    	int year;
    	System.out.print("Nhap nam sinh cua nhan vien ma ban muon thong ke: ");
    	year = in.nextInt();
		int yearNum;
		int cnt = 0;
		System.out.println("Danh sach cac nhan vien sinh nam " + year + " : ");
		for(int i = 0; i < ds.length; i++) {
			yearNum = Integer.parseInt(ds[i].getNgaySinh().substring(4, 8));
			if(yearNum == year) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nha vien sinh nam " + year + " la: " + cnt);
	}
    public void thongKeCaLam(int calam) {
		int cnt = 0;
		System.out.println("Danh sach cac nhan vien lam ca " + calam + " : ");
		for(int i = 0; i < ds.length; i++) {
			if(ds[i].getCalam() == calam) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nhan vien lam ca " + calam + " la: " + cnt);
    }
}
