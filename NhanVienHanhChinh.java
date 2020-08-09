package Assignment;

public class NhanVienHanhChinh extends NhanVien {
	public NhanVienHanhChinh(String maNV, String hoTen, double luong) {
		super(maNV, hoTen, luong);
	}

	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Thu nhập: " + getThuNhap());
	}
}
