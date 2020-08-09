package Assignment;

import java.util.*;

import java.util.Map.Entry;

public class Main {
	static HashMap<String, NhanVien> danhSachNhanVien = new HashMap<>();
	static HashMap<String, Double> listSalary = new HashMap<>(); // Chứa key NhanVien - value Thu Nhập NhanVien
	static Scanner sc = new Scanner(System.in);

	/**
	 * 1/ Nhập Danh sách Nhân viên
	 */
	public static void NhapNhanVienHanhChinh() {
		while (true) {
			System.out.println("\n======== NHÂN VIÊN HÀNH CHÍNH ========");

			String maNV;
			while (true) {
				System.out.print("\nNhập Mã số Nhân viên (VD: HC123): HC");
				try {
					maNV = "HC" + Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Chỉ nhập số! Mời nhập lại mã số!!");
				}
			}

			if (danhSachNhanVien.containsKey(maNV)) {
				System.out.println("\nMã Nhân viên đã tồn tại! Mời nhập lại!!");
				continue;
			}

			NhanVienHanhChinh nvhc = new NhanVienHanhChinh(null, null, 0);
			nvhc.setMaNV(maNV);
			nvhc.insertNV();
			danhSachNhanVien.put(maNV, nvhc);
			listSalary.put(maNV, nvhc.getThuNhap());
			break;
		}
	}

	public static void NhapNhanVienTiepThi() {
		while (true) {
			System.out.println("\n======== NHÂN VIÊN TIẾP THỊ ========");

			String maNV;
			while (true) {
				System.out.print("\nNhập Mã số Nhân viên (VD: TT123): TT");
				try {
					maNV = "TT" + Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Chỉ nhập số! Mời nhập lại mã số!!");
				}
			}

			if (danhSachNhanVien.containsKey(maNV)) {
				System.out.println("\nMã Nhân viên đã tồn tại! Mời nhập lại!!");
				continue;
			}

			NhanVienTiepThi nvtt = new NhanVienTiepThi(null, null, 0, 0, 0);
			nvtt.setMaNV(maNV);
			nvtt.insertNV();
			danhSachNhanVien.put(maNV, nvtt);
			listSalary.put(maNV, nvtt.getThuNhap());
			break;
		}
	}

	public static void NhapTruongPhong() {
		while (true) {
			System.out.println("\n======== TRƯỞNG PHÒNG ========");

			String maNV;
			while (true) {
				System.out.print("\nNhập Mã số Nhân viên (VD: TP123): TP");
				try {
					maNV = "TP" + Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Chỉ nhập số! Mời nhập lại mã số!!");
				}
			}

			if (danhSachNhanVien.containsKey(maNV)) {
				System.out.println("\nMã Nhân viên đã tồn tại! Mời nhập lại!!");
				continue;
			}

			TruongPhong tp = new TruongPhong(null, null, 0, 0);
			tp.setMaNV(maNV);
			tp.insertNV();
			danhSachNhanVien.put(maNV, tp);
			listSalary.put(maNV, tp.getThuNhap());
			break;
		}
	}

	public static void NhapNhanVienMoi() {
		while (true) {
			System.out.println("\n================= NHẬP NHÂN VIÊN =================");
			System.out.println("\n1/ Nhân viên Hành chính.");
			System.out.println("2/ Nhân viên Tiếp thị.");
			System.out.println("3/ Trưởng phòng.");
			System.out.println("0/ Quay lại Menu chính.");
			System.out.print("\nNhập chức năng: ");

			String o = sc.nextLine();
			;

			switch (o) {
			case "1": {
				NhapNhanVienHanhChinh();
				break;
			}
			case "2": {
				NhapNhanVienTiepThi();
				break;
			}
			case "3": {
				NhapTruongPhong();
				break;
			}
			case "0":
			case "o":
			case "O": {
				Menu();
				break;
			}
			default:
				System.out.println("Nhập liệu sai! Nhập lại đê!!");
				continue;
			}
		}
	}

	/**
	 * 2/ Xuất Danh sách Nhân viên
	 */
	public static void XuatDanhSachNhanVien() {
		System.out.println("\n================ DANH SÁCH NHÂN VIÊN ================");
		danhSachNhanVien.keySet().forEach(i -> danhSachNhanVien.get(i).xuatThongTin());
	}

	/**
	 * 3/ Tìm kiếm và hiển thị nhân viên theo lương
	 */
	public static void TimKiemNhanVien() {
		System.out.println("\n================= TÌM KIẾM NHÂN VIÊN =================");
		System.out.print("\nNhập Mã Nhân viên cần tìm: ");
		String key = sc.nextLine();
		if (danhSachNhanVien.containsKey(key)) {
			System.out.println("\nĐã tìm thấy!!!\n");
			danhSachNhanVien.get(key).xuatThongTin();
		} else
			System.out.println("\nKhông tìm thấy Nhân viên chứa Mã Nhân viên: " + key);
	}

	/**
	 * 4/ Xoá Nhân viên theo mã nhập từ bàn phím
	 */
	public static void XoaNhanVien() {
		System.out.println("\n=================== XOÁ NHÂN VIÊN ===================");
		System.out.print("\nNhập Mã Nhân viên cần xoá: ");
		String key = sc.nextLine();
		if (danhSachNhanVien.containsKey(key)) {
			System.out.println("\nĐã tìm thấy Nhân viên chứa Mã: " + key);
			danhSachNhanVien.remove(key);
			System.out.println("Đã xoá thành công");
		} else
			System.out.println("\nKhông tìm thấy Nhân viên chứa Mã Nhân viên: " + key);
	}

	/**
	 * 5/ Cập nhật thông tin nhân viên
	 */
	public static void updateInfo() {
		System.out.println("\n============ CẬP NHẬT THÔNG TIN NHÂN VIÊN ============");
		System.out.print("\nNhập Mã Nhân viên cần cập nhật: ");
		String key = sc.nextLine();
		if (danhSachNhanVien.containsKey(key)) {
			System.out.println("\nĐã tìm thấy Nhân viên chứa Mã: " + key);
			System.out.println("Bắt đầu Cập nhật!");
			danhSachNhanVien.get(key).insertNV();
			System.out.println("====> Cập nhật thành công <====");
		} else
			System.out.println("\nKhông tìm thấy Nhân viên chứa Mã Nhân viên: " + key);
	}

	/**
	 * 6/ Tìm các nhân viên theo khoảng lương nhập từ bàn phím.
	 */

	public static void findByRangeSalary() {
		System.out.println("\n======== TÌM CÁC NHÂN VIÊN THEO KHOẢNG LƯƠNG ========");
		System.out.println("Nhập khoảng lương cần tìm [a - b]");
		double a, b;

		while (true) {
			System.out.println("a = ");
			try {
				a = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhập Số sai! Mời nhập lại!!");
			}
		}
		while (true) {
			System.out.println("b = ");
			try {
				b = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhập Số sai! Mời nhập lại!!");
			}
		}

		System.out.println("\n======== DANH SÁCH NHÂN VIÊN THEO LƯƠNG TỪ " + a + " đến " + b + " ========");
		Set<Entry<String, NhanVien>> setListSalary = danhSachNhanVien.entrySet();
		for (Entry<String, NhanVien> entry : setListSalary) {
			if (entry.getValue().getLuong() >= a && entry.getValue().getLuong() <= b)
				danhSachNhanVien.get(entry.getKey()).xuatThongTin();
		}
	}

	/**
	 * 7/ Sắp xếp nhân viên theo họ tên
	 */

	public static void SortByName() {
		// Khởi tạo 1 set entries
		Set<Entry<String, NhanVien>> entries = danhSachNhanVien.entrySet();

		// Convert Set to List
		List<Entry<String, NhanVien>> listEntries = new ArrayList<>(entries);

		// Sắp xếp List
		Collections.sort(listEntries, (o1, o2) -> o1.getValue().getHoTen().compareTo(o2.getValue().getHoTen()));

		System.out.println("Sắp xếp nhân viên thành công");
		System.out.println("\n======== DANH SÁCH NHÂN VIÊN SAU KHI SẮP XẾP ========");
		listEntries.forEach(i -> i.getValue().xuatThongTin());
	}

	/**
	 * 8/ Sắp xếp nhân viên theo thu nhập
	 */

	public static void SortByMoney() {
		// Khởi tạo 1 Set các entry chứa các cặp key-value của HashMap
		Set<Entry<String, Double>> entriesSalary = listSalary.entrySet();

		// Convert Set to List
		List<Entry<String, Double>> listEntries = new ArrayList<Map.Entry<String, Double>>(entriesSalary);

		// Sort
		Collections.sort(listEntries, (o1, o2) -> (int) (o1.getValue() - o2.getValue())); // sortAscending
//		Collections.reverse(listEntries); // sortDescending

		System.out.println("Sắp xếp nhân viên thành công");
		System.out.println("\n======== DANH SÁCH NHÂN VIÊN SAU KHI SẮP XẾP ========");
		listEntries.forEach(i -> danhSachNhanVien.get(i.getKey()).xuatThongTin());
	}

	/**
	 * 9/ Xuất 5 nhân viên có thu nhập cao nhất công ty
	 */
	public static void TopNhanVien() {
		// Khởi tạo 1 Set các entry chứa các cặp key-value của HashMap
		Set<Entry<String, Double>> entriesSalary = listSalary.entrySet();

		// Convert Set to List
		List<Entry<String, Double>> listEntries = new ArrayList<Map.Entry<String, Double>>(entriesSalary);

		// Sort
		Collections.sort(listEntries, (o1, o2) -> (int) (o1.getValue() - o2.getValue())); // sortAscending
		Collections.reverse(listEntries); // sortDescending

		System.out.println("\n===== TOP 5 NHÂN VIÊN CÓ THU NHẬP CAO NHẤT CÔNG TY =====");

		int i = 0;
		for (Entry<String, Double> entry : listEntries) {
			if (i == 5)
				break;
			danhSachNhanVien.get(entry.getKey()).xuatThongTin();
			i++;
		}
	}

	// Hàm check chuỗi chứa toàn bộ ký tự chữ hay k??
	public boolean isAlphabet(String str) {
		for (char c : str.toCharArray()) {
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c == 32))
				continue;
			else
				return false;
		}
		return true;
	}

	// ********************* MENU **********************
	public static void Menu() {
		String o = "";

		while (o != "o" || o != "0") {
			System.out.println("\n=========================================================================");
			System.out.println("|\t1/ Nhập Danh sách Nhân viên.\t\t\t\t\t|");
			System.out.println("|\t2/ Xuất Danh sách Nhân viên.\t\t\t\t\t|");
			System.out.println("|\t3/ Tìm kiếm và hiển thị nhân viên theo mã nhập từ bàn phím.\t|");
			System.out.println("|\t4/ Xoá Nhân viên theo mã nhập từ bàn phím.\t\t\t|");
			System.out.println("|\t5/ Cập nhật thông tin nhân viên theo mã nhập từ bàn phím.\t|");
			System.out.println("|\t6/ Tìm các nhân viên theo khoảng lương nhập từ bàn phím.\t|");
			System.out.println("|\t7/ Sắp xếp nhân viên theo họ tên.\t\t\t\t|");
			System.out.println("|\t8/ Sắp xếp nhân viên theo thu nhập.\t\t\t\t|");
			System.out.println("|\t9/ Xuất 5 nhân viên có thu nhập cao nhất công ty.\t\t|");
			System.out.println("|\t0/ Thoát chương trình\t\t\t\t\t\t|");
			System.out.println("=========================================================================");
			System.out.print("\nNhập phím chức năng: ");

			o = new Scanner(System.in).nextLine();

			switch (o) {
			case "1": {
				NhapNhanVienMoi();
				break;
			}
			case "2": {
				XuatDanhSachNhanVien();
				break;
			}
			case "3": {
				TimKiemNhanVien();
				break;
			}
			case "4": {
				XoaNhanVien();
				break;
			}
			case "5": {
				updateInfo();
				break;
			}
			case "6": {
				findByRangeSalary();
				break;
			}
			case "7": {
				SortByName();
				break;
			}
			case "8": {
				SortByMoney();
				break;
			}
			case "9": {
				TopNhanVien();
				break;
			}
			case "0":
			case "o":
			case "O": {
				System.exit(0);
			}
			default:
				System.out.println("Nhập liệu sai! Nhập lại đê!!");
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Menu();
	}
}
