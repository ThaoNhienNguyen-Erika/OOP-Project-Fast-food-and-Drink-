/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodanddrinkstore;
import java.util.*;
import java.io.*;
/**
 *
 * @author Admin
 */
public class DSTheoDoiKhachHang 
{
    Scanner in = new Scanner(System.in);
	private int soLuongKhTD;
	private TheoDoiKhachHang[] ds;
	//Constructor
    public DSTheoDoiKhachHang() {}
    public DSTheoDoiKhachHang(TheoDoiKhachHang[] ds, int soLuongKhTD) {
    	this.soLuongKhTD = soLuongKhTD;
    	this.ds = new TheoDoiKhachHang[this.soLuongKhTD];
    }
    public DSTheoDoiKhachHang(int soLuongKhTD) {
    	this.soLuongKhTD = soLuongKhTD;
    	ds = new TheoDoiKhachHang[this.soLuongKhTD];
    	for(int i = 0; i < soLuongKhTD; i++) {
    		ds[i] = new TheoDoiKhachHang();
    	}
    }
    public DSTheoDoiKhachHang(TheoDoiKhachHang[] ds) {
    	int dsLength = ds.length;
    	this.ds = new TheoDoiKhachHang[dsLength];
    	for(int i = 0;i < dsLength; i++) {
    		this.ds[i] = new TheoDoiKhachHang();
    		this.ds[i] = ds[i];
    	}
    }
    //Input & Output
    public void nhap() 
    {
       System.out.print("Nhap so luong khach hang can theo doi: ");
       soLuongKhTD = in.nextInt();
       ds = new TheoDoiKhachHang[soLuongKhTD];
        for(int i = 0; i < soLuongKhTD; i++) {
			ds[i] = new TheoDoiKhachHang();
			System.out.println("Nhap thong tin cua khach hang can theo doi "+(i+1));
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
        System.out.println("Nhap vao thong tin cua khach hang can theo doi can them: ");
        TheoDoiKhachHang kt = new TheoDoiKhachHang();
        kt.nhap();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new TheoDoiKhachHang();
        ds[ds.length - 1] = kt;
    }
    //add new employee: use given customer vairable
    public void them(TheoDoiKhachHang kt) {
    	ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = kt;
    }
    //add new employees : use input
    public void them(int soLuongKhTD) {
    	System.out.println("Nhap vao thong tin cua cac khach hang can theo doi: ");
    	int oldLength = ds.length;
    	ds = Arrays.copyOf(ds, ds.length + soLuongKhTD);
    	for(int i= oldLength; i < ds.length; i++) {
    		ds[i] = new TheoDoiKhachHang();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    //Search with given maNv
    public int timKiem(String maKh) 
    {
        for(int i=0;i<ds.length;i++) 
        {
            if(maKh.equals(ds[i].getMaKh()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maNv
    public int timKiem() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can theo doi can tim kiem (5 so): ");
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
    //Adjust with given maKh
    public void sua(String maKh) {
    	int pos = timKiem(maKh);
    	ds[pos] = new TheoDoiKhachHang();
    	ds[pos].nhap();
    }
    // Adjust with input makh
    public void sua() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can theo doi can sua thong tin (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
    	ds[pos] = new TheoDoiKhachHang();
    	ds[pos].nhap();
    }
    //Delete 1 employee with given maKh
    public void xoa(String maKh) {
		int pos = timKiem(maKh);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Delete 1 employee with input makh
    public void xoa() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can theo doi can xoa (5 so): ");
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
    public void thongKeTongTienChi(int tongtienchi) {
		int cnt = 0;
		System.out.println("Tong tien chi cua cac khach hang can theo doi: ");
		for(int i = 0; i < ds.length; i++) {
			if(ds[i].getTongtienchi() == tongtienchi) {
				cnt++;
				ds[i].xuat();
			}
		}
    }
}
