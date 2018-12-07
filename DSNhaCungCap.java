package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
interface IdanhSach{
	void nhap();
	void xuat();
	void docFile(String fileName) throws IOException;
	void ghiFile(String fileName) throws IOException;
}
public class DSNhaCungCap implements IdanhSach{
    NhaCungCap[] ds;
    int soLuongNCC;
    Scanner in = new Scanner(System.in);
    /*=========CONSTRUCTOR=========*/
    public DSNhaCungCap() {
    	ds = new NhaCungCap[100];
    }
    public DSNhaCungCap(NhaCungCap[] ds, int soLuongNCC) 
    {
    	this.soLuongNCC = soLuongNCC;
    	this.ds = new NhaCungCap[this.soLuongNCC];
    }
    public DSNhaCungCap(int soLuongNCC) 
    {
    	this.soLuongNCC = soLuongNCC;
    	ds = new NhaCungCap[this.soLuongNCC];
    	for(int i = 0; i < soLuongNCC; i++) {
    		ds[i] = new NhaCungCap();
    	}
    }
    public DSNhaCungCap(NhaCungCap[] ds) 
    {
    	int dsLength = ds.length;
    	soLuongNCC = ds.length;
    	this.ds = new NhaCungCap[dsLength];
    	for(int i = 0;i < dsLength; i++) {
    		this.ds[i] = new NhaCungCap();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========INPUT & OUTPUT==========*/
    public void nhap() 
    {
       System.out.print("Nhap so luong nha cung cap: ");
       soLuongNCC = in.nextInt();
       ds = new NhaCungCap[soLuongNCC];
        for(int i = 0; i < soLuongNCC; i++) {
			ds[i] = new NhaCungCap();
			System.out.println("Nhap thong tin nha cung cap "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
		for(int i=0 ; i < soLuongNCC; i++) {
			ds[i].xuat();
			System.out.println();
		}
    }
    /*==========ADD==========*/
    public void them() 
    {   
        while(true) {
        	System.out.println("Nhap vao thong tin cua nha cung cap can them: ");
            NhaCungCap kt = new NhaCungCap();
            kt.nhap();
            //check id of new "nha cung cap"
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongNCC; i++) {
            	if(kt.getMancc().equals(ds[i].getMancc()) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	ds = Arrays.copyOf(ds, soLuongNCC + 1);
                soLuongNCC += 1;
                ds[soLuongNCC - 1] = new NhaCungCap();
                ds[soLuongNCC - 1] = kt;
                System.out.println("Them nha cung cap thanh cong!!!");
                break;
            }else {
            	System.out.println("Ban khong the them nha cung cap moi co ma trung voi nha cung cap truoc do, xin moi them lai!!!");
            }
        }
    }
    public void them(NhaCungCap kt) {
    	while(true) {
    		//check id of new "nha cung cap"
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongNCC; i++) {
            	if(kt.getMancc().equals(ds[i].getMancc()) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
        		ds = Arrays.copyOf(ds, soLuongNCC + 1);
            	soLuongNCC += 1;
                ds[soLuongNCC - 1] = kt;
                break;
        	}else {
        		System.out.println("Ban khong the them nha cung cap moi co ma trung voi nha cung cap truoc do, xin moi them lai!!!");
        	}
            kt = new NhaCungCap();
            kt.nhap();
    	}
    }
    public void them(int soLuongNCC) {
    	System.out.println("Nhap vao thong tin cua cac nha cung cap: ");
    	int oldLength = ds.length;
    	this.soLuongNCC += soLuongNCC;
    	ds = Arrays.copyOf(ds, this.soLuongNCC + soLuongNCC);
    	for(int i= oldLength; i < soLuongNCC; i++) {
    		ds[i] = new NhaCungCap();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    /*==========SEARCH=========*/
    public int timKiem(String mancc) 
    {
        for(int i=0;i<ds.length;i++) 
        {
            if(mancc.equals(ds[i].getMancc()) == true) 
            	return i;
        }
        return -1;
    }
    public int timKiem() {
    	String mancc;
    	while(true) {
			System.out.print("Nhap vao ma nha cung cap can tim kiem (5 so): ");
			mancc = in.nextLine();
			if(mancc.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < ds.length; i++) {
    		if(mancc.equals(ds[i].getMancc()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void timTheoTen(String tenncc) {
    	tenncc = tenncc.toLowerCase();
    	boolean check = false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTenncc().toLowerCase();
    		if(temp.indexOf(tenncc) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nha cung cap ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    public void timTheoTen() {
    	System.out.println("Nhap vao ten ma ban can tim kiem: ");
    	String tenncc = in.nextLine();
    	tenncc = tenncc.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTenncc().toLowerCase();
    		if(temp.indexOf(tenncc) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nha cung cap ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    /*==========ADJUST==========*/
    public void sua(String mancc) {
    	int pos = timKiem(mancc);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua nha cung cap nay:");
        	//use temporary variable type NhaCungCap to check id of new 'nha cung cap'
        	NhaCungCap nccTemp = new NhaCungCap();
        	nccTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soLuongNCC; i++) {
        		if(nccTemp.getMancc().equals(ds[i].getMancc()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new NhaCungCap(nccTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        	}else {
        		System.out.println("Ma nha cung cap moi cua ban trung voi mot nha cung cap truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    public void sua() {
    	String mancc;
    	while(true) {
			System.out.print("Nhap vao ma nha cung cap can sua thong tin (5 so): ");
			mancc = in.nextLine();
			if(mancc.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(mancc);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua nha cung cap nay:");
        	//use temporary variable type NhaCungCap to check id of new 'nha cung cap'
        	NhaCungCap nccTemp = new NhaCungCap();
        	nccTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soLuongNCC; i++) {
        		if(nccTemp.getMancc().equals(ds[i].getMancc()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new NhaCungCap(nccTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        		break;
        	}else {
        		System.out.println("Ma nha cung cap moi cua ban trung voi mot nha cung cap truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    /*===========DELETE=========*/
    public void xoa(String mancc) {
		int pos = timKiem(mancc);
		for(int i = pos; i < soLuongNCC - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soLuongNCC - 1);
		soLuongNCC -= 1;
	}
    public void xoa() {
    	String mancc;
    	while(true) {
			System.out.print("Nhap vao ma nha cung cap can xoa (5 ky tu): ");
			mancc = in.nextLine();
			if(mancc.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(mancc);
		for(int i = pos; i < soLuongNCC - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soLuongNCC - 1);
		soLuongNCC -= 1;
	}
    /*==========READ & WRITE FILE=========*/
    //read file
    public void docFile(String fileName)throws IOException{
    	DataInputStream inp = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String mancc = inp.readUTF();
        		String tenncc = inp.readUTF();
        		String loaihang = inp.readUTF();
        		ds[i] = new NhaCungCap(mancc,tenncc,loaihang);
        		i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soLuongNCC = i;
    		inp.close();
    	}
    }
    //write file
    public void ghiFile(String fileName)throws IOException{
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soLuongNCC; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		System.out.println("Ghi file thanh cong!!!");
    		out.close();
    	}
    }
}
