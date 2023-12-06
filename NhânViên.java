class// lớp
NhânViên {
    // Họ Tên: chuỗi
    String HọTên;

    // Năm Sinh: số nguyên
    int NămSinh;

    // Chức vụ
    String ChứcVụ;

    // Điểm: số thực
    float Lương;

    // Nhóm Máu: kí tự
    char NhómMáu;

    // Giới: logic
    Boolean Giới;

    void toScreen() {
        System.out.printf("%s sinh năm %s, lương %.2f, nhóm máu %c",
                HọTên, NămSinh, Lương, NhómMáu);
    }
}
