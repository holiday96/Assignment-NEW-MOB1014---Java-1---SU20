package Assignment;

import java.util.Scanner;

public class NhanVienTiepThi extends NhanVien {
	private double doanhSo;
	private double hueHong;

	public NhanVienTiepThi(String maNV, String hoTen, double luong, double doanhSo, double hueHong) {
		super(maNV, hoTen, luong);
		this.doanhSo = doanhSo;
		this.hueHong = hueHong;
	}

	public double getDoanhSo() {
		return doanhSo;
	}

	public void setDoanhSo(double doanhSo) {
		this.doanhSo = doanhSo;
	}

	public double getHueHong() {
		return hueHong;
	}

	public void setHueHong(double hueHong) {
		this.hueHong = hueHong;
	}

	public double getThuNhap() {
		return getLuong() + getDoanhSo() * getHueHong() - getThueTN();
	}

	public void insertNV() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		super.insertNV();
		// Nhập Doanh số bán hàng
		while (true) {
			System.out.print("Nhập Doanh số bán hàng: ");
			try {
				setDoanhSo(Double.parseDouble(sc.nextLine()));
				if (getDoanhSo() <= 0) {
					System.out.println("Doanh số bán hàng vừa nhập không hợp lệ! Nhập lại!!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhập Doanh số sai rồi! Nhập lại xem nào!!");
				continue;
			}
		}
		// Nhập Tỉ lệ huê hồng
		while (true) {
			System.out.print("Nhập Tỉ lệ huê hồng: ");
			try {
				setHueHong(Double.parseDouble(sc.nextLine()));
				if (getHueHong() <= 0) {
					System.out.println("Tỉ lệ huê hồng vừa nhập không hợp lệ! Nhập lại!!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhập Tỉ lệ huê hồng sai rồi! Nhập lại xem nào!!");
				continue;
			}
		}
	}

	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Doanh số: " + getDoanhSo());
		System.out.println("Tỉ lệ huê hồng: " + getHueHong());
		System.out.println("Thu nhập: " + getThuNhap());

	}
}
