import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import static java.lang.System.out;

import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @todo Bổ sung mã Java kiểm tra lỗi,
 *       rà soát các tình huống dị thường có thể xảy ra.
 *       Ví dụ: chỉ số nằm ngoài phạm vi độ dài mảng.
 *       Mảng bị rỗng.
 */
class// lớp
MảngNhânViên {
    // Dữ liệu
    // static SinhViên[] mảng; // null
    static NhânViên[] mảng = new NhânViên[0];

    static NhânViên[] ds() {
        return mảng;
    }

    // Hành Động, Thao Tác Dữ Liệu
    static void Gán() {

        // Khởi tạo sinh viên
        var nv1 = new NhânViên();
        nv1.HọTên = "Nobita";
        nv1.NămSinh = 1995;
        nv1.ChứcVụ = "Chủ tịch";
        nv1.Lương = 6.5f;
        nv1.NhómMáu = 'A';
        nv1.Giới = true;

        var nv2 = new NhânViên();
        nv2.HọTên = "Xuka";
        nv2.NămSinh = 1996;
        nv2.ChứcVụ = "Giám đốc";
        nv2.Lương = 9.5f;
        nv2.NhómMáu = 'B';
        nv2.Giới = false;

        var nv3 = new NhânViên();
        nv3.HọTên = "Chaien";
        nv3.NămSinh = 1994;
        nv3.ChứcVụ = "Nhân viên";
        nv3.Lương = 7.5f;
        nv3.NhómMáu = 'B';
        nv3.Giới = false;

        mảng = new NhânViên[] {
                nv1, nv2, nv3
        };
    }

    static void Nhập() {
        var scan = new Scanner(System.in);

        // Nhập độ dài mảng
        int độ_dài;
        out.print("\n Nhập độ dài mảng: ");
        độ_dài = scan.nextInt();
        // scan.close();

        // khởi tạo
        mảng = new NhânViên[độ_dài]; // 3 phần tử đang null

        // Nhập dữ liệu cho từng phần tử
        for (int i = 0; i < mảng.length; i++) {

            var nv = new NhânViên();
            out.printf("\n Nhập dữ liệu cho phần tử mảng[%d]: ", i);
            // Nhập tên
            scan.nextLine();
            out.print("\n Nhập tên nhân viên: ");
            nv.HọTên = scan.nextLine();
            // scan.close();

            // Nhập năm
            out.print("\n Nhập năm sinh: ");
            nv.NămSinh = scan.nextInt();
            while (1900 >= nv.NămSinh || nv.NămSinh >= 2023) {
                out.print("\n Năm sinh không hợp lệ. Vui lòng nhập lại năm sinh: ");
                nv.NămSinh = scan.nextInt();
            }

            // Nhập chức vụ
            scan.nextLine();
            out.print("\n Nhập chức vụ: ");
            nv.ChứcVụ = scan.nextLine();
            // Nhập điểm
            out.print("\n Nhập lương: ");
            nv.Lương = scan.nextFloat();

            // Nhập nhóm
            out.print("\n Nhập nhóm máu(A, B, O): ");
            nv.NhómMáu = scan.next().charAt(0);

            // Nhập giới
            out.print("\n Giới tính (1=Nam/0=Nữ): ");
            nv.Giới = scan.nextInt() == 1 ? true : false; // Java không cho chuyển đổi qua lại giữa bool và
                                                          // int

            // Đẩy sinh viên vào mảng/danh sách sau khi khởi tạo
            mảng[i] = nv; // Biến phái sinh
            // String GiớiTính_Text = GiớiTính ? "Đực" : "Cái";
            // scan.close();

        }

        // Thông báo đã nhập
        out.println("\n Đã hoàn tất việc nhập mảng !");
    }

    static void Xuất() {

        // in cột
        Cột();

        // in các dòng
        for (int i = 0; i < mảng.length; i++) {
            int stt = i + 1;
            NhânViên dữ_liệu = mảng[i];

            Dòng(dữ_liệu, stt);
        }

    }

    static void Bảng() {
        out.print("\n Bảng Dữ Liệu Nhân Viên:");

        // in cột
        Cột();

        // in các dòng
        // @todo Nếu dữ liệu dòng NULL thì sao ?
        for (int i = 0; i < mảng.length; i++) {
            int stt = i + 1;
            NhânViên dữ_liệu = mảng[i];
            Dòng(dữ_liệu, stt);
        }

    }

    static// Hàm hiện
    void Cột() {
        out.print("\n+--------------------------------------------------------------------------------------+");
        out.print("\n| STT |    TÊN NHÂN VIÊN    | NĂM SINH |   CHỨC VỤ   |     LƯƠNG     | NHÓM MÁU | GIỚI |");
        out.print("\n+--------------------------------------------------------------------------------------+");
    }

    static// Hàm hiện
    void Dòng(NhânViên đt, int stt) {
        // String GiớiTính_Text = (đt.GiớiTính==true) ? "Nam" : "Nữ";
        String GiớiTính = đt.Giới ? "Nam" : "Nữ";

        out.printf("\n| %3d | %19s | %8d | %11s | %9.3f VNĐ | %8s | %4s |",
                stt, đt.HọTên, đt.NămSinh, đt.ChứcVụ, đt.Lương, đt.NhómMáu, GiớiTính);
        out.print("\n+--------------------------------------------------------------------------------------+");
    }

    static void XếpGiảmDầnTheoLương() {
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var logic = mảng[i].Lương > mảng[j].Lương;

                if// nếu
                (!logic)// logic sai, không thỏa mãn
                {
                    NhânViên tạm = mảng[i];
                    mảng[i] = mảng[j];
                    mảng[j] = tạm;
                }
            }
        }

        out.print("\n Đã sắp xếp giảm dần theo lương: ");
        Xuất();
    }

    static void XếpTăngDầnTheoLương() {
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var logic = mảng[i].Lương < mảng[j].Lương;

                if// nếu
                (!logic)// logic sai, không thỏa mãn
                {
                    NhânViên tạm = mảng[i];
                    mảng[i] = mảng[j];
                    mảng[j] = tạm;
                }
            }
        }

        out.print("\n Đã sắp xếp tăng dần theo lương: ");
        Xuất();
    }

    static void PhânLoạiTheoNhómMáu() {

        // Mảng chứa dữ liệu thống kê
        int[] sl = new int[mảng.length]; // mối phần tử = 0

        for (int i = 0; i < sl.length; i++) {
            sl[i] = 1;
        }

        // Tinh chỉnh dữ liệu thống kê
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var i_j_cùng_loại = mảng[i].NhómMáu == mảng[j].NhómMáu;

                if// nếu
                (i_j_cùng_loại && sl[j] != 0) {
                    sl[i]++;
                    sl[j]--;
                }
            }
        }
        // In dữ liệu thống kê, phân loại ra màn hình
        for (int i = 0; i < sl.length; i++) {
            if (sl[i] != 0) {
                // out.printf("Nhóm máu A có 3 bạn.");
                out.printf("\n Nhóm máu %c có %d nhân viên.", mảng[i].NhómMáu, sl[i]);
            }
        }
    }

    static void PhânLoạiTheoGiớiTính(){
        // Mảng chứa dữ liệu thống kê
        int[] gt = new int[mảng.length]; // mối phần tử = 0

        for (int i = 0; i < gt.length; i++) {
            gt[i] = 1;
        }
        // Tinh chỉnh dữ liệu thống kê
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var i_j_cùng_giới = mảng[i].Giới == mảng[j].Giới;

                if// nếu
                (i_j_cùng_giới && gt[j] != 0) {
                    gt[i]++;
                    gt[j]--;
                }
            }
        }
        // In dữ liệu thống kê, phân loại ra màn hình
        for (int i = 0; i < gt.length; i++) {
            if (gt[i] != 0) {
                String giớitính = mảng[i].Giới ? "Nam" : "Nữ";
                out.printf("\n %s có %d nhân viên.", giớitính, gt[i]);
            }
        }
    }

    public static void LươngMinMax() {
        float min;
        float max;
        // float sum; // tổng

        min = mảng[0].Lương;
        max = mảng[0].Lương;
        // sum = 0.0f;

        for (NhânViên sv : mảng) {
            if (min > sv.Lương)
                min = sv.Lương;
            if (max < sv.Lương)
                max = sv.Lương;

            // sum += sv.Lương;
        }

        out.printf("\n Nhân viên có lương min: %.3f" + " VNĐ ", min);
        out.printf("\n Nhân viên có lương max: %.3f" + " VNĐ ", max);
    }

    public static void Thêm() {
        // - Tạo mảng mới có độ dài lớn hơn độ dài mảng cũ (1 đơn vị)
        // - Copy dữ liệu của mảng cũ sang
        // - Khởi tạo phần tử mới,
        // - Lưu phần tử mới vào cuối mảng mới
        // - Gán mảng mới vào mảng cũ

        // 1. Tạo mảng mới có độ dài lớn hơn
        NhânViên[] mảng_mới = new NhânViên[mảng.length + 1];

        // 2. Copy dữ liệu của mảng cũ sang:
        for (int i = 0; i < mảng.length; i++) {
            mảng_mới[i] = mảng[i];
        }

        // 3. Khởi tạo phần tử mới
        var scan = new Scanner(System.in);

        var nv = new NhânViên();
        out.printf("\n Nhập dữ liệu cho phần tử mới: ");
        // Nhập tên

        out.print("\n Nhập tên nhân viên: ");
        nv.HọTên = scan.nextLine();
        // scan.close();

        // Nhập năm
        out.print("\n Nhập năm sinh: ");
        nv.NămSinh = scan.nextInt();
        while (1900 >= nv.NămSinh || nv.NămSinh >= 2023) {
            out.print("\n Năm sinh không hợp lệ. Vui lòng nhập lại năm sinh: ");
            nv.NămSinh = scan.nextInt();
        }

        scan.nextLine();
        out.print("\n Nhập chức vụ: ");
        nv.ChứcVụ = scan.nextLine();

        // Nhập lương
        out.print("\n Nhập lương: ");
        nv.Lương = scan.nextFloat();

        // Nhập nhóm
        out.print("\n Nhập nhóm máu(A, B, O): ");
        nv.NhómMáu = scan.next().charAt(0);

        // Nhập giới
        out.print("\n Giới tính (1=Nam/0=Nữ): ");
        nv.Giới = scan.nextInt() == 1 ? true : false; // Java không cho chuyển đổi qua lại giữa bool và
                                                      // int
        // 4. Đẩy sinh viên mới vào cuối của mảng mới
        mảng_mới[mảng.length] = nv;

        mảng = mảng_mới;

        out.print("\n Danh sách Nhân Viên sau khi thêm mới:");
        Xuất();

    }

    public static void Sửa() {
        // hiện lại
        Bảng();

        var scan = new Scanner(System.in);
        out.print("\n Chọn số thứ tự để sửa:");
        int stt = scan.nextInt();

        int chỉ_số_cũ = stt - 1;

        var nv = new NhânViên();
        out.printf("\n Cập nhật dữ liệu cho phần tử mảng[%d]: ", chỉ_số_cũ);
        // Nhập tên

        out.print("\n Nhập tên nhân viên: ");
        nv.HọTên = scan.next();
        // scan.close();

        // Nhập năm
        out.print("\n Nhập năm sinh: ");
        nv.NămSinh = scan.nextInt();
        while (1900 >= nv.NămSinh || nv.NămSinh >= 2023) {
            out.print("\n Năm sinh không hợp lệ. Vui lòng nhập lại năm sinh: ");
            nv.NămSinh = scan.nextInt();
        }

        scan.nextLine();
        out.print("\n Nhập chức vụ: ");
        nv.ChứcVụ = scan.nextLine();

        // Nhập điểm
        out.print("\n Nhập lương: ");
        nv.Lương = scan.nextFloat();

        // Nhập nhóm
        out.print("\n Nhập nhóm máu(A, B, O): ");
        nv.NhómMáu = scan.next().charAt(0);

        // Nhập giới
        out.print("\n Giới tính (1=Nam/0=Nữ): ");
        nv.Giới = scan.nextInt() == 1 ? true : false; // Java không cho chuyển đổi qua lại giữa bool và
                                                      // int

        // Lưu dữ liệu mới của sinh viên vào vị trí cũ
        mảng[chỉ_số_cũ] = nv;

        out.print("\n Danh sách nhân viên sau khi sửa: ");

        Bảng();

    }

    public static void Xóa() {
        // hiện lại
        Bảng();

        var scan = new Scanner(System.in);
        out.print("\n Chọn số thứ tự để xóa:");
        int stt = scan.nextInt();

        int chỉ_số_cũ = stt - 1;

        int độ_dài_mới = mảng.length - 1;

        // @todo độ dài mới <= 1 thì sao ?

        NhânViên[] mảng_mới = new NhânViên[độ_dài_mới];

        // Copy dữ liệu mảng cũ sang mảng mới, trừ phần tử muốn xóa
        for (int i = 0; i < mảng_mới.length; i++) {

            if (i < chỉ_số_cũ)
                // Copy những phần tử đứng trước chỉ số cũ
                mảng_mới[i] = mảng[i];
            else
                // Copy những phần tử đứng sau chỉ số cũ
                mảng_mới[i] = mảng[i + 1];
        }

        mảng = mảng_mới;

        out.print("\n Danh sách sau khi xóa: ");
        Bảng();
    }

    public static void Tìm() {
        // thân hàm1
        out.print("\n Vui lòng nhập thông tin cần tìm kiếm: ");
        var scan = new Scanner(System.in);
        String tk = scan.nextLine();
        boolean result = true;

        int dem = 0;
        for (int i = 0; i < mảng.length; i++) {
            NhânViên nv = mảng[i];

            if (result = mảng[i].HọTên.contains(tk)) {
                dem++;
                Dòng(nv, i + 1);
            }
        }
        if (dem == 0) {
            out.print("\n Không có thông tin cần tìm kiếm");

        }

    }

    /**
     * @abstract Lưu dữ liệu mảng vào tệp, với định dạng JSON
     *           Các dị thường có thể xảy ra:
     *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
     *           không hỗ trợ
     *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     */
    public static void GhiFileJSON() {

        // Chuyển đổi mảng Java Array sang chuỗi Java String JSON
        Gson gson = new Gson();
        String jsonContent = gson.toJson(mảng);
        // out.println(jsonContent);

        // Đối tượng chịu trách nhiệm viết/ghi
        // nội dung JSON tiếng Việt vào tệp/file trên ổ cứng
        Writer writer;
        try {
            // Đường dẫn tĩnh để test nhanh
            String filePath = "C:\\Users\\Public\\mang-nhanvien.json";

            // Đường dẫn động nhập từ bàn phím:
            var scan = new Scanner(System.in);
            out.print("\n Nhập đường dẫn tệp file cần ghi dữ liệu: ");
            filePath = scan.next();
            // ví dụ: c:/users/public/mang-sinhvien.json

            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(filePath),
                            "UTF-8"));
            writer.write(jsonContent);
            writer.flush();
            writer.close(); // Viết xong phải đóng nó lại nếu không là công cốc !
                            // Đến lúc mở tệp ra lại chẳng thấy có dữ liệu nào được viết vào

        } catch (Exception ex) {
            out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
            ex.printStackTrace();
        }
        // finally {
        // writer.close();
        // }

        System.out.println("\n Đã ghi file JSON");
    }

    /**
     * @abstract Đọc dữ liệu tệp JSON và chuyển đổi nó thành mảng
     *           Các dị thường có thể xảy ra:
     *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
     *           không hỗ trợ
     *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
     * 
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     */
    public static void ĐọcFileJSON() {
        Gson gson = new Gson();

        try {
            // Đường dẫn tĩnh để test nhanh
            String filePath = "C:\\Users\\Public\\mang-sinhvien.json";

            // Đường dẫn động nhập từ bàn phím:
            var scan = new Scanner(System.in);
            out.print("\n Nhập đường dẫn tệp file cần đọc dữ liệu: ");
            filePath = scan.next();
            // ví dụ: c:/users/public/mang-sinhvien.json

            JsonReader reader = new JsonReader(new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath),
                            "UTF-8")));

            mảng = gson.fromJson(reader, NhânViên[].class);

            Xuất();
        } catch (Exception e) {
            out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
            e.printStackTrace();
        }
    }

}
// kết thúc lớp
