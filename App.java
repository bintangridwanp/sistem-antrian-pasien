import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    // Main program
    public static void main(String[] args) {

        // Load data dummy
        ManajemenPasien.jumlahPasien =
                DataDummy.loadDummy(
                        ManajemenPasien.nama,
                        ManajemenPasien.umur,
                        ManajemenPasien.asal,
                        ManajemenPasien.tanggalLahir,
                        ManajemenPasien.tingkatPenyakit,
                        ManajemenPasien.golonganDarah // Tambahkan golongan darah
                );

        ManajemenPasien.tampilkanHeader();
        System.out.println("Data dummy dimuat: "
                + ManajemenPasien.jumlahPasien + " pasien");

        int pilihan;

        do {
            ManajemenPasien.tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    ManajemenPasien.tampilkanSemuaPasien();
                    break;

                case 2: {
                    int idx = ManajemenPasien.cariPasien();
                    if (idx != -1) {
                        ManajemenPasien.tampilkanPasien(idx);
                    } else {
                        System.out.println("Pasien tidak ditemukan.");
                    }
                    break;
                }

                case 3:
                    ManajemenPasien.cariPasienGolongan();
                    break;

                case 4:
                    ManajemenPasien.tambahPasien();
                    break;

                case 5:
                    ManajemenPasien.editPasien();
                    break;

                case 6:
                    ManajemenPasien.hapusPasien();
                    break;

                case 7:
                    ManajemenPasien.tambahKeAntrianPrioritas();
                    break;

                case 8:
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
