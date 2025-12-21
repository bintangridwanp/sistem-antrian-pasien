import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    // Header
    static void tampilkanHeader() {
        System.out.println("==========================================");
        System.out.println("   SISTEM ANTRIAN KLINIK KESEHATAN");
        System.out.println("==========================================");
    }

    // Menampilkan menu
    public static void tampilkanMenu() {
        System.out.printf(
                "\n%-30s\n" +
                        "----------------------------------------------\n" +
                        "1. %-30s\n" +
                        "2. %-30s\n" +
                        "3. %-30s\n" +
                        "4. %-30s\n" +
                        "5. %-30s\n" +
                        "6. %-30s\n" +
                        "7. %-30s\n" +
                        "8. %-30s\n" +
                        "0. %-30s\n" +
                        "----------------------------------------------\n" +
                        "Pilih menu: ",
                "MENU UTAMA",
                "Cari Nama Pasien",
                "Cari Golongan Penyakit",
                "Pendaftaran Pasien",
                "Edit Data Pasien",
                "Hapus Data Pasien",
                "Tambah ke Antrian Biasa",
                "Tambah ke Antrian Prioritas",
                "Tampilkan Antrian",
                "Keluar"
        );
    }

    // main program
    public static void main(String[] args) {

        // Load data dummy
        ManajemenPasien.jumlahPasien =
                DataDummy.loadDummy(
                        ManajemenPasien.nama,
                        ManajemenPasien.umur,
                        ManajemenPasien.asal,
                        ManajemenPasien.tanggalLahir,
                        ManajemenPasien.tingkatPenyakit
                );

        tampilkanHeader();
        System.out.println("Data dummy dimuat: "
                + ManajemenPasien.jumlahPasien + " pasien");

        int pilihan;

        do {
            tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine(); // bersihkan buffer

            switch (pilihan) {
                case 1: {
                    int idx = ManajemenPasien.cariPasien();
                    if (idx != -1) {
                        ManajemenPasien.tampilkanPasien(idx);
                    } else {
                        System.out.println("Pasien tidak ditemukan.");
                    }
                    break;
                }

                case 2:
                    ManajemenPasien.cariPasienGolongan();
                    break;

                case 3:
                    ManajemenPasien.tambahPasien();
                    break;

                case 4:
                    ManajemenPasien.editPasien();
                    break;

                case 5:
                    ManajemenPasien.hapusPasien();
                    break;

                case 6:
                    ManajemenPasien.tambahKeAntrianPrioritas();
                    break;

                case 7:
                    ManajemenPasien.tampilkanAntrian();
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }

        } while (pilihan != 0);
    }
}
