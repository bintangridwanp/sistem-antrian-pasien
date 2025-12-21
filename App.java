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
    static void tampilkanMenu() {
        System.out.println("\n----------- MENU UTAMA -----------");
        System.out.println("1. Cari Pasien (Nama)");
        System.out.println("2. Cari Pasien (Golongan Penyakit)");
        System.out.println("3. Tambah Data Pasien");
        System.out.println("4. Edit Data Pasien");
        System.out.println("5. Hapus Data Pasien");
        System.out.println("6. Tambah ke Antrian Prioritas");
        System.out.println("7. Tampilkan Antrian");
        System.out.println("0. Keluar");
        System.out.println("---------------------------------");
        System.out.print("Pilih menu: ");
    }

    // Program main
    public static void main(String[] args) {

       // Mendapatkan data dummy
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
