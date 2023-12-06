import java.util.Scanner;
import static java.lang.System.out;

class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            out.print("\n+--------------------------------------------------------------------------------+");
            out.print("\n|                        CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN.                         |");
            out.print("\n+--------------------------------MENU--------------------------------------------+");
            out.print("\n| 1.Thêm | 2.Sửa | 3.Xoá | 4.Sắp Xếp | 5.Thống Kê | 6.Lương Min Max | 7.Tìm Kiếm |");
            out.print("\n| 8.Ghi File | 9. Đọc File | 0. Thoát                                            |");
            out.print("\n+--------------------------------------------------------------------------------+");

            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();
            // scan.close();

            switch (menu) {
                case 1:
                    // làm việc 1
                    MảngNhânViên.Thêm();
                    break;
                case 2:
                    // làm việc 2
                    MảngNhânViên.Sửa();
                    break;
                case 3:
                    // làm việc 3
                    MảngNhânViên.Xóa();
                    break;
                case 4:
                    // làm việc 4
                    out.print("1. Lương giảm dần | 2. Lương tăng dần");

                    out.print("\n Chọn: ");
                    var chon = scan.nextInt();
                    switch (chon) {
                        case 1:
                            MảngNhânViên.XếpGiảmDầnTheoLương();
                            break;
                        case 2:
                            MảngNhânViên.XếpTăngDầnTheoLương();
                            break;
                        default:
                            out.print("\n Hãy chọn hợp lệ !");
                            break;
                    }
                    break;
                case 5:
                    // làm việc 5
                    out.print("Phân loại theo: ");
                    out.print("1. Nhóm máu | 2. Giới tính");

                    out.print("\n Chọn: ");
                    var ChọnPhânloại = scan.nextInt();
                    switch (ChọnPhânloại) {
                        case 1:
                            MảngNhânViên.PhânLoạiTheoNhómMáu();
                            break;
                        case 2:
                            MảngNhânViên.PhânLoạiTheoGiớiTính();
                            break;
                        default:
                            out.print("\n Hãy chọn hợp lệ !");
                            break;
                    }
                    break;
                case 6:
                    // làm việc 6
                    MảngNhânViên.LươngMinMax();
                    break;
                case 7:
                    // làm việc 7
                    MảngNhânViên.Tìm();
                    break;
                case 8:
                    // làm việc 8
                    MảngNhânViên.GhiFileJSON();
                    break;
                case 9:
                    // làm việc 9
                    MảngNhânViên.ĐọcFileJSON();
                case 0:
                    out.print("\n Đang thoát...");
                    // Thread.sleep(3000);
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    out.print("\n Hãy nhập menu hợp lệ !");
                    break;
            }

        } // kết thúc vòng lặp menu
    }
}
