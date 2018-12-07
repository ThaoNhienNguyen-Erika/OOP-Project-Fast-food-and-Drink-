package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;

public class DSKhachHang{
    KhachHang[] ds;
    int soLuongKh;
    Scanner in = new Scanner(System.in);
    /*==========CONSTRUCTOR==========*/
    public DSKhachHang() {
    	ds = new KhachHang[100];
    }
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
    	this.soLuongKh = ds.length;
    	this.ds = new KhachHang[this.soLuongKh];
    	for(int i = 0;i < this.soLuongKh; i++) {
    		this.ds[i] = new KhachHang();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========INPUT & OUTPUT==========*/
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
		for(int i=0 ; i < soLuongKh; i++) {
			ds[i].xuat();
			System.out.println();
		}
    }
    /*===========ADD==========*/
    //add new customer: use input
    public void them() 
    {   
        while(true) {
        	System.out.println("Nhap vao thong tin cua khach hang can them: ");
            KhachHang kh = new KhachHang();
            kh.nhap();
            
            //check id of new customer
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongKh; i++) {
            	if(ds[i].getMaKh().toLowerCase().equals(kh.getMaKh())) {
            		isDuplicate = true;
            	}
            }
            
            if(isDuplicate == false) {
            	ds = Arrays.copyOf(ds, soLuongKh + 1);
            	soLuongKh += 1;
                ds[soLuongKh - 1] = new KhachHang();
                ds[soLuongKh - 1] = kh;
                break;
            }else {
            	System.out.println("Khach hang vua them co ma trung voi khach hang truoc do, xin moi nhap lai thong tin!!!");
            }
        }
    }
    //add new customer: use given customer vairable
    public void them(KhachHang kh) {
    	ds = Arrays.copyOf(ds, soLuongKh + 1);
    	soLuongKh += 1;
        ds[soLuongKh - 1] = kh;
    }
    //add new customers : use input
    public void them(int soLuongKh) {
    	System.out.println("Nhap vao thong tin cua cac khach hang: ");
    	int oldLength = this.soLuongKh;
    	this.soLuongKh += soLuongKh;
    	ds = Arrays.copyOf(ds, this.soLuongKh);
    	for(int i= oldLength; i < this.soLuongKh; i++) {
    		ds[i] = new KhachHang();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    /*===========SEARCH==========*/
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
    /*==========ADJUST===========*/
    //Adjust with given maKh
    public void sua(String maKh) {
    	int pos = timKiem(maKh);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua khach hang nay:");
        	//use temporary variable type KhachHang to check id of new 'nha cung cap'
        	KhachHang khTemp = new KhachHang();
        	khTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soLuongKh; i++) {
        		if(khTemp.getMaKh().equals(ds[i].getMaKh()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new KhachHang(khTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        	}else {
        		System.out.println("Ma cua khach hang moi cua ban trung voi mot khach hang truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    // Adjust with input makh
    public void sua() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma cua khach hang can sua thong tin (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua khach hang nay:");
        	//use temporary variable type KhachHang to check id of new customer
        	KhachHang khTemp = new KhachHang();
        	khTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soLuongKh; i++) {
        		if(khTemp.getMaKh().equals(ds[i].getMaKh()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new KhachHang(khTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        		break;
        	}else {
        		System.out.println("Ma cua khach hang moi cua ban trung voi mot khach hang truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    /*============DELETE===========*/
    //Delete 1 customer with given maKh
    public void xoa(String maKh) {
		int pos = timKiem(maKh);
		for(int i = pos; i < soLuongKh - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soLuongKh - 1);
		soLuongKh -= 1;
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
		for(int i = pos; i < soLuongKh - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soLuongKh - 1);
		soLuongKh -= 1;
	}
    /*===========STATISTIC==========*/
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
    /*=========READ & WRITE FILE=========*/
    public void ghiFile(String fileName)throws IOException {
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soLuongKh; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		out.close();
    	}
    }
    public void docFile(String fileName)throws IOException{
    	DataInputStream inp = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String maKh = inp.readUTF();
    			String tenKh = inp.readUTF();
    			String hoKh = inp.readUTF();
    			boolean gioiTinh = inp.readBoolean();
    			String diaChi = inp.readUTF();
    			String soDt = inp.readUTF();
    			ds[i] = new KhachHang(maKh,tenKh,hoKh,gioiTinh,diaChi,soDt);
    			i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soLuongKh = i;
    		inp.close();
    	}
    }
}
