package Assignment;

import java.util.Scanner;

public class NhanVien extends Main {
	private String maNV;
	private String hoTen;
	private double luong;

	public NhanVien(String maNV, String hoTen, double luong) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public double getThuNhap() {
		return getLuong() - getThueTN();
	}

	public double getThueTN() {
		if (getLuong() < 9000000)
			return 0;
		else if (getLuong() <= 15000000)
			return getLuong() * 0.1;
		else
			return getLuong() * 0.12;
	}

	public void insertNV() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Nhập Họ tên
		while (true) {
			System.out.print("Nhập Họ tên: ");
			setHoTen(sc.nextLine());

			if (!isAlphabet(getHoTen()) || getHoTen().isEmpty()) {
				System.out.println("Nhập dữ liệu sai! Chỉ được nhập ký tự chữ cái!! Mời nhập lại!!!");
				continue;
			} else
				break;
		}

		// Nhập Mức Lương cơ bản
		while (true) {
			System.out.print("Nhập Mức lương cơ bản: ");
			try {
				setLuong(Double.parseDouble(sc.nextLine()));
				if (getLuong() <= 0) {
					System.out.println("Mức lương vừa nhập không hợp lệ! Nhập lại!!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhập Mức lương sai rồi! Nhập lại xem nào!!");
				continue;
			}
		}
	}

	public void xuatThongTin() {
		System.out.println("\nMã nhân viên: " + getMaNV());
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Lương: " + getLuong());
	}
}
