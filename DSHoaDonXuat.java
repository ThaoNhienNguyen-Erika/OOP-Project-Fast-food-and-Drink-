package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class DSHoaDonXuat {
	HoaDonXuat[] ds;
    int soluongHd;
    Scanner in = new Scanner(System.in);
    /*=========CONSTRUCTOR=========*/
    public DSHoaDonXuat() {
    	ds = new HoaDonXuat[100];
    }
    public DSHoaDonXuat(HoaDonXuat[] ds, int soluongHd) 
    {
    	this.soluongHd = soluongHd;
    	this.ds = new HoaDonXuat[this.soluongHd];
    }
    public DSHoaDonXuat(int soluongHd) 
    {
    	this.soluongHd = soluongHd;
    	ds = new HoaDonXuat[this.soluongHd];
    	for(int i = 0; i < soluongHd; i++) {
    		ds[i] = new HoaDonXuat();
    	}
    }
    public DSHoaDonXuat(HoaDonXuat[] ds) 
    {
    	soluongHd = ds.length;
    	this.ds = new HoaDonXuat[soluongHd];
    	for(int i = 0;i < soluongHd; i++) {
    		this.ds[i] = new HoaDonXuat();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========INPUT & OUTPUT==========*/
    public void nhap() 
    {
       System.out.print("Nhap so luong hoa don xuat: ");
       soluongHd = in.nextInt();
       ds = new HoaDonXuat[soluongHd];
        for(int i = 0; i < soluongHd; i++) {
			ds[i] = new HoaDonXuat();
			System.out.println("Nhap thong tin cua hoa don xuat "+(i+1) +" : ");
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
		for(int i=0 ; i < soluongHd; i++) {
			ds[i].xuat();
			System.out.println();
		}
    }
    /*==========ADD==========*/
    public void them() 
    {   
        while(true) {
        	System.out.println("Nhap vao thong tin cua hoa don xuat moi: ");
            HoaDonXuat hd = new HoaDonXuat();
            hd.nhap();
            //check id of new "hoa don xuat"
            boolean isDuplicate = false;
            for(int i = 0; i < soluongHd; i++) {
            	if(ds[i].getMa().equals(hd.getMa()) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	ds = Arrays.copyOf(ds, soluongHd + 1);
                soluongHd += 1;
                ds[soluongHd - 1] = new HoaDonXuat();
                ds[soluongHd - 1] = hd;
                System.out.println("Them hoa don xuat moi thanh cong!!!");
                break;
            }else {
            	System.out.println("Ban khong the them hoa don xuat moi co ma trung voi hoa don xuat truoc do, xin moi them lai!!!");
            }
        }
    }
    public void them(HoaDonXuat hd) {
    	while(true) {
    		//check id of new "hoa don xuat"
            boolean isDuplicate = false;
            for(int i = 0; i < soluongHd; i++) {
            	if(ds[i].getMa().equals(hd.getMa()) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
        		ds = Arrays.copyOf(ds, soluongHd + 1);
            	soluongHd += 1;
                ds[soluongHd - 1] = hd;
                break;
        	}else {
        		System.out.println("Ban khong the them hoa don xuat moi co ma trung voi hoa don xuat truoc do, xin moi them lai!!!");
        	}
            hd = new HoaDonXuat();
            hd.nhap();
    	}
    }
    public void them(int soluongHd) {
    	System.out.println("Nhap vao thong tin cua cac hoa don xuat: ");
    	int oldLength = ds.length;
    	this.soluongHd += soluongHd;
    	ds = Arrays.copyOf(ds, this.soluongHd + soluongHd);
    	for(int i= oldLength; i < this.soluongHd; i++) {
    		ds[i] = new HoaDonXuat();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    /*==========SEARCH=========*/
    public int timKiem(String ma) 
    {
        for(int i=0;i<ds.length;i++) 
        {
            if(ma.equals(ds[i].getMa()) == true) 
            	return i;
        }
        return -1;
    }
    public int timKiem() {
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma hoa don xuat can tim kiem (5 so): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < ds.length; i++) {
    		if(ma.equals(ds[i].getMa()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void timTheoNv(String manv) {
    	manv = manv.toLowerCase();
    	boolean check = false;
    	for(int i = 0; i < ds.length; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Khong tim thay nhan vien ban can tim trong danh sach hoa don xuat!!!");
    	}
    }
    public void timTheoTen() {
    	System.out.println("Nhap vao ma nhan vien ma ban can tim kiem: ");
    	String manv = in.nextLine();
    	manv = manv.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Khong tim thay nhan vien ban can tim kiem theo hoa don xuat!!!");
    	}
    }
    /*==========ADJUST==========*/
    public void sua(String ma) {
    	int pos = timKiem(ma);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua hoa don xuat nay:");
        	//use temporary variable type HoaDonXuat to check id of new 'hoa don xuat'
        	HoaDonXuat hdxTemp = new HoaDonXuat();
        	hdxTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soluongHd; i++) {
        		if(hdxTemp.getMa().equals(ds[i].getMa()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new HoaDonXuat(hdxTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        	}else {
        		System.out.println("Ma cua hoa don xuat moi cua ban trung voi mot hoa don xuat truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    public void sua() {
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma cua hoa don xuat can sua thong tin (5 so): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(ma);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua hoa don xuat nay:");
        	//use temporary variable type HoaDonXuat to check id of new 'hoa don xuat'
        	HoaDonXuat hdxTemp = new HoaDonXuat();
        	hdxTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soluongHd; i++) {
        		if(hdxTemp.getMa().equals(ds[i].getMa()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new HoaDonXuat(hdxTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        		break;
        	}else {
        		System.out.println("Ma cua hoa don xuat moi cua trung voi mot hoa don xuat truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    /*===========DELETE=========*/
    public void xoa(String ma) {
		int pos = timKiem(ma);
		for(int i = pos; i < soluongHd - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soluongHd - 1);
		soluongHd -= 1;
	}
    public void xoa() {
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma cua hoa don xuat can xoa (5 ky tu): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(ma);
		for(int i = pos; i < soluongHd - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soluongHd - 1);
		soluongHd -= 1;
	}
    /*==========STATISTIC==========*/
    //statistic from price
    public void thongKeTuGia(int gia) {
    	boolean check = false;
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getTongtien() >= gia) {
    			check = true;
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    	
    	if(check == true) {
    		System.out.println("Khong co hoa don nao tu khoang gia nay!!!");
    	}
    }

    public void thongKeTuGia() {
    	int gia;
    	boolean check = false;
    	System.out.print("Nhap vao gia tien toi thieu cua moi hoa don de thong ke!!!!");
    	gia = in.nextInt();
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getTongtien() >= gia) {
    			check = true;
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    }
    //statistic by employee
    public void thongKeTheoNvien() {
    	boolean check = false;
    	System.out.print("Nhap vao ma nhan vien de thong ke hoa don dua tren nhan vien do: ");
    	String manv = in.nextLine();
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
    			check = true;
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khong co hoa don nao duoc xuat tu nhan vien nay!!!");
    	}
    }
    public void thongKeTheoNvien(String manv) {
    	boolean check = false;
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
    			check = true;
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khong co hoa don nao duoc xuat tu nhan vien nay!!!");
    	}
    }
    //statistic by customer
    public void thongKeTheoKhachHang() {
    	boolean check = false;
    	System.out.print("Nhap vao ma khach de thong ke hoa don ma khach hang do da mua: ");
    	String makh = in.nextLine();
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getMakh().equals(makh) == true) {
    			check = true;
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khach hang nay khong co hoa don nao!!!");
    	}
    }
    public void thongKeTheoKhachHang(String makh) {
    	boolean check = false;
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getMakh().equals(makh) == true) {
    			check = true;
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khach hang nay khong co hoa don nao!!!");
    	}
    }
    /*==========READ & WRITE FILE=========*/
    //read file
    public void docFile(String fileName)throws IOException{
    	DataInputStream inp = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String ma = inp.readUTF();
    			String ngayxuat = inp.readUTF();
    			String thangxuat = inp.readUTF();
    			String namxuat = inp.readUTF();
    			String manv = inp.readUTF();
    			int tongtien = inp.readInt();
    			String makh = inp.readUTF();
    			String makm = inp.readUTF();
    			int	tienkm = inp.readInt();
    			ds[i] = new HoaDonXuat(ma,ngayxuat,thangxuat,namxuat,manv,tongtien,makh,makm,tienkm);
        		i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soluongHd = i;
    		inp.close();
    	}
    }
    //write file
    public void ghiFile(String fileName)throws IOException{
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soluongHd; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		System.out.println("Ghi file thanh cong!!!");
    		out.close();
    	}
    }
}
