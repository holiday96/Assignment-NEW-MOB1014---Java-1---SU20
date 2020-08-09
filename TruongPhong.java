package Assignment;

import java.util.Scanner;

public class TruongPhong extends NhanVien {
	private double luongTrachNhiem;

	public TruongPhong(String maNV, String hoTen, double luong, double luongTrachNhiem) {
		super(maNV, hoTen, luong);
		this.luongTrachNhiem = luongTrachNhiem;
	}

	public double getLuongTrachNhiem() {
		return luongTrachNhiem;
	}

	public void setLuongTrachNhiem(double luongTrachNhiem) {
		this.luongTrachNhiem = luongTrachNhiem;
	}

	public double getThuNhap() {
		return getLuong() + getLuongTrachNhiem() - getThueTN();
	}

	public void insertNV() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		super.insertNV();
		// Nhập Lương trách nhiệm
		while (true) {
			System.out.print("Nhập Lương trách nhiệm: ");
			try {
				setLuongTrachNhiem(Double.parseDouble(sc.nextLine()));
				if (getLuongTrachNhiem() <= 0) {
					System.out.println("Lương trách nhiệm vừa nhập không hợp lệ! Nhập lại!!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhập Lương trách nhiệm sai rồi! Nhập lại xem nào!!");
				continue;
			}
		}
	}

	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Lương trách nhiệm: " + getLuongTrachNhiem());
		System.out.println("Thu nhập: " + getThuNhap());
	}
}
