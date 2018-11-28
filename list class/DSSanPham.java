package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
import java.lang.String;
interface IdanhSach{
	void nhap();
	void xuat();
	void docFile(String fileName) throws IOException;
	void ghiFile(String fileName) throws IOException;
}
public class DSSanPham implements IdanhSach{
	Scanner in = new Scanner(System.in);
	private int soluong;
	private SanPham[] ds;
	//Constructor
	public DSSanPham() {
		ds = new SanPham[100];
	}
	public DSSanPham(int soluong, SanPham[] sp) {
		this.soluong = soluong;
		ds = new SanPham[soluong];
		for(int i = 0; i < soluong; i++) {
			ds[i] = new SanPham();
			ds[i] = sp[i];
		}
	}
	public DSSanPham(int soluong) {
		this.soluong = soluong;
		ds = new SanPham[soluong];
	}
	public DSSanPham(SanPham[] sp) {
		int spLength = sp.length;
		ds = new SanPham[spLength];
		for(int i = 0; i < spLength; i++) {
			ds[i] = new SanPham();
			ds[i] = sp[i];
		}
	}
	//Getter soluong
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	//Input and Output
	public void nhap() {
		System.out.print("Nhap vao so luong cua san pham: ");
		soluong = in.nextInt();
		ds = new SanPham[soluong];
		System.out.println("Nhap vao danh sach san pham: ");
		for(int i = 0; i < soluong; i++) {
			while(true) {
				int check;
				System.out.print("Ban muon nhap vao thuc an nhanh (phim 1) hay giai khat (phim 2): ");
				check = in.nextInt();
				if(check == 1) {
					ds[i] = new ThucAnNhanh();
					ds[i].nhap();
					break;
				}else if(check == 2) {
					ds[i] = new GiaiKhat();
					ds[i].nhap();
					break;
				}
			}
		}
	}
	public void xuat() {
		System.out.println("Danh sach san pham: ");
		System.out.println("");
		for(int i = 0; i < ds.length; i++) {
			ds[i].xuat();
		}
	}
	//add new product: given product
	public void them(SanPham sp) {
		ds = Arrays.copyOf(ds, ds.length + 1);
		ds[ds.length - 1] = sp;
	}
	//add new product: input product
	public void them() {
		int check;
		SanPham sp;
		while(true) {
			System.out.print("Ban muon them vao danh sach thuc anh nhanh(phim 1) hay giai khat (phim2): ");
			check = in.nextInt();
			if(check == 1) {
				sp = new ThucAnNhanh();
				System.out.println("Nhap vao thong tin cua san pham");
				sp.nhap();
				break;
			}else if(check == 2) {
				sp = new GiaiKhat();
				System.out.println("Nhap vao thong tin cua san pham");
				sp.nhap();
				break;
			}
		}
        ds = Arrays.copyOf(ds, ds.length + 1);
        if(check == 1) {
        	ds[ds.length - 1] = new ThucAnNhanh();
        }else {
        	ds[ds.length - 1] = new GiaiKhat();
        }
        ds[ds.length - 1] = sp;
	}
	//add new products
	public void them(int soluongSp) {
    	System.out.println("Nhap vao thong tin cua cac san pham: ");
    	int oldLength = ds.length;
    	ds = Arrays.copyOf(ds, ds.length + soluongSp);
    	for(int i= oldLength; i < ds.length; i++) {
    		while(true) {
    			int check;
        		System.out.print("Ban muon them vao danh sach thuc anh nhanh(phim 1) hay giai khat (phim2): ");
    			check = in.nextInt();
    			if(check == 1) {
    				ds[i] = new ThucAnNhanh();
    				System.out.println("Nhap vao thong tin cua san pham");
    				ds[i].nhap();
    				break;
    			}else if(check == 2) {
    				ds[i] = new GiaiKhat();
    				System.out.println("Nhap vao thong tin cua san pham");
    				ds[i].nhap();
    				break;
    			}
    		}
    	}
    }
	//search with given masp
	public int timKiem(String masp) 
    {
        for(int i=0;i<ds.length;i++) 
        {
            if(masp.equals(ds[i].getMasp()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maKh and return position
    public int timKiem() {
    	String masp;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can tim kiem (5 so): ");
			masp = in.nextLine();
			if(masp.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < ds.length; i++) {
    		if(masp.equals(ds[i].getMasp()) == true) {
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
    		String temp = ds[i].getTensp().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with name: input name
    public void timTheoTen() {
    	System.out.println("Nhap vao ten ma ban can tim kiem: ");
    	String ten = in.nextLine();
    	ten = ten.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTensp().toLowerCase();
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
    //Search with loai: given loai
    public void timTheoLoai(String loai) {
    	loai = loai.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getLoai().toLowerCase();
    		if(temp.indexOf(loai) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Loai san pham can tim khong co trong danh sach!!!!");
    	}
    }
    //Search with loai: input loai
    public void timTheoLoai() {
    	System.out.println("Nhap vao loai san phan ban can tim kiem: ");
    	String loai = in.nextLine();
    	loai = loai.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getLoai().toLowerCase();
    		if(temp.indexOf(loai) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Loai san pham can tim khong co trong danh sach!!!!");
    	}
    }
    //Adjust with given masp
    public void sua(String masp) {
    	int pos = timKiem(masp);
    	int check;
    	while(true) {
    		System.out.print("Ban muon sua san pham nay thanh san pham loai nao (1: Thuc an nhanh, 2: Giai khat)");
    		check = in.nextInt();
    		in.nextLine();
    		if(check == 1 || check == 2) {
    			break;
    		}
    	}
    	if(check == 1) {
    		ds[pos] = new ThucAnNhanh();
    		ds[pos].nhap();
    	}else {
    		ds[pos] = new GiaiKhat();
    		ds[pos].nhap();
    	}
    }
    // Adjust with input masp
    public void sua() {
    	String masp;
    	while(true) {
			System.out.print("Nhap vao ma san pham can sua (5 so): ");
			masp = in.nextLine();
			if(masp.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(masp);
    	int check;
    	while(true) {
    		System.out.print("Ban muon sua san pham nay thanh san pham loai nao (1: Thuc an nhanh, 2: Giai khat): ");
    		check = in.nextInt();
    		in.nextLine();
    		if(check == 1 || check == 2) {
    			break;
    		}
    	}
    	if(check == 1) {
    		ds[pos] = new ThucAnNhanh();
    		ds[pos].nhap();
    	}else {
    		ds[pos] = new GiaiKhat();
    		ds[pos].nhap();
    	}
    }
    //Delete 1 product with given masp
    public void xoa(String masp) {
		int pos = timKiem(masp);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Delete 1 product with input masp
    public void xoa() {
    	String masp;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can xoa (5 so): ");
			masp = in.nextLine();
			if(masp.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(masp);
		for(int i = pos; i < ds.length - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, ds.length - 1);
	}
    //Statistic by price from: ...
    //Write file
    public void ghiFile(String fileName)throws IOException {
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < ds.length; i++) {
    			ds[i].writeFile(fileName);
    		}
    	}catch(IOException e) {
    		
    	}
    	finally {
    		out.close();
    	}
    }
    //add one product to file
    public void themVaoFile(String fileName)throws IOException{
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName,Boolean.TRUE));
    	try {
    		System.out.println("Nhap san pham de them vao file: ");
    		SanPham sp = new SanPham();
    		sp.nhap();
    		sp.writeFile(fileName);
    	}catch(IOException e) {
    		
    	}
    	finally {
    		out.close();
    	}
    }
    //add products to file
    public void themVaoFile(String fileName, int n)throws IOException {
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName,Boolean.TRUE));
    	try {
    		System.out.println("Nhap vao thong tin cac san pham them vao file: ");
    		for(int i = 0; i < n; i++) {
    			SanPham sp = new SanPham();
        		sp.nhap();
        		sp.writeFile(fileName);
    		}
    	}catch(IOException e) {
    		
    	}
    	finally {
    		out.close();
    	}
    }
    //Read file
    public void docFile(String fileName)throws IOException {
    	DataInputStream input = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String productId;
    			productId = input.readUTF();
    			String checkSp = productId.substring(0,1);
    			if(checkSp.equals("t") == true) {
    				String tensp = input.readUTF();
    				String loaisp = input.readUTF();
    				int gia = input.readInt();
    				int solco = input.readInt();
    				String nlc = input.readUTF();
    				String xx = input.readUTF();
    				ds[i] = new ThucAnNhanh(productId,tensp,loaisp,gia,solco,nlc,xx);
    			}else if(checkSp.equals("g") == true) {
    				String tensp = input.readUTF();
    				String loaisp = input.readUTF();
    				int gia = input.readInt();
    				int solco = input.readInt();
    				String hvi = input.readUTF();
    				String size = input.readUTF();
    				ds[i] = new GiaiKhat(productId,tensp,loaisp,gia,solco,hvi,size);
    			}
    			i++;
    		}
    		
    	}catch(EOFException e) {}
    	finally {
    		this.soluong = i;
    		input.close();
    	}
    }
}
  
