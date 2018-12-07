package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
import java.nio.*;
//read binary file: reference
public class Launcher {
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(System.in);
		//Create NhanVien array
//		NhanVien[] nv = new NhanVien[5];
//		nv[0] = new NhanVien("00001", "Nguyen Van", "A", "01011999", true, 2, 6000000);
//		nv[1] = new NhanVien("00002", "Nguyen Thi", "C", "02031999", false, 1, 3000000);
//		nv[2] = new NhanVien("00003", "Nguyen Hung", "D", "11111999", true, 2, 10000000);
//		nv[3] = new NhanVien("00004", "Nguyen Ly", "F", "21011999", false, 3, 15000000);
//		nv[4] = new NhanVien("00005", "Nguyen Tan", "Huy", "02101999", true, 3, 20000000);
//		DSNhanVien dsnv = new DSNhanVien(nv);
		//Create SanPham array
		SanPham[] sp = new SanPham[3];
		sp[0] = new ThucAnNhanh("t0001","wonderburger","hamburger",55000,35,"chicken","russia");
		sp[1] = new GiaiKhat("g0001","Let it go cream", "ice cream", 35000, 50, "strawberry", "m");
		sp[2] = new ThucAnNhanh("t0002","volcano burger","hamburger", 65000, 90, "germany flour", "germany");
		DSSanPham dssp = new DSSanPham(sp);
		//create KhachHang array
		KhachHang[] kh = new KhachHang[5];
		kh[0] = new KhachHang("00001", "Nguyen Tan ", "huy", true, "305/30 duong Le Van Quoi, Binh Tri Dong, Binh Tan","0397097276");
		kh[1] = new KhachHang("00002", "Nguyen buu ", "vinh", true,  "O dau do trong quan 8 gan voi binh chanh do","0397097276");
		kh[2] = new KhachHang("00003", "Nguyen thi thu ", "tuyet", false, "cai gi/ cai gsdfsd Luoc, Binh Tri Dong, Binh Tan","0397097276");
		kh[3] = new KhachHang("00004", "Le thi thu ", "tuyen", false, "cai gi/ caifdsfsdf Binh Tri Dong, Binh Tan", "0397097276");
		kh[4] = new KhachHang("00005", "Vo thi thu ", "tuyet", false, "cai gi/ cai gi Chiengfgdfgfdgdfg, Binh Tri Dong, Binh Tan", "0397097276");
		DSKhachHang dskh = new DSKhachHang(kh);
		
		String fileName = "D:\\Eclipse\\SchoolPractice\\product list.txt";
		String fileName2 = "D:\\Eclipse\\SchoolPractice\\test.txt";
		String fileName3 = "D:\\Eclipse\\SchoolPractice\\nha cung cap.txt";
		String fileName4 = "D:\\Eclipse\\SchoolPractice\\khach hang.txt";
		String fileName5 = "D:\\Eclipse\\SchoolPractice\\hoa don xuat.txt";
		
		
		
		NhanVien nvnv = new NhanVien();
		nvnv.nhap();
		nvnv.xuat();
		
		
		
		
		
		
		
		
		
		

//		DSNhaCungCap dsncc1 = new DSNhaCungCap();
//		dsncc1.nhap();
//		
//		dsncc1.ghiFile(fileName3);
		
//		DSNhaCungCap dsncc2 = new DSNhaCungCap();
//		dsncc2.docFile(fileName3);
//		dsncc2.xuat();
//		dsncc2.them();
//		dsncc2.ghiFile(fileName3);
//		dsncc2.docFile(fileName3);
//		dsncc2.xuat();
//		dsncc2.xoa();
//		dsncc2.ghiFile(fileName3);
//		dsncc2.docFile(fileName3);
//		dsncc2.xuat();
//		dsncc2.sua("00008");
//		dsncc2.ghiFile(fileName3);
//		dsncc2.docFile(fileName3);
//		dsncc2.xuat();
//		System.out.println(dsncc2.timKiem());
		
	}

}
