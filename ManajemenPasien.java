import java.util.Scanner;

public class ManajemenPasien {
    static Scanner input = new Scanner(System.in);

    static String[] nama = new String[100];
    static int[] umur = new int[100];
    static String[] asal = new String[100];
    static String[] tanggalLahir = new String[100];
    static String[] tingkatPenyakit = new String[100];
    static String[] golonganDarah = new String[100];

    static int[] antrian = new int[100];
    static int jumlahAntrian = 0;
    static int jumlahPasien = 0;

    // Menambahkan header (naihar)
    public static void tampilkanHeader() {
        System.out.println("===================================================");
        System.out.println("          SISTEM ANTRIAN KLINIK KESEHATAN          ");
        System.out.println("===================================================");
    }

    // Menambahkan menu (naihar)
    public static void tampilkanMenu() {
        System.out.println();
        System.out.println("+----+--------------------------------------------+");
        System.out.printf("| %-2s | %-42s |\n", "No", "MENU UTAMA");
        System.out.println("+----+--------------------------------------------+");
        System.out.printf("| %-2d | %-42s |\n", 1, "Tampilkan Semua Pasien");
        System.out.printf("| %-2d | %-42s |\n", 2, "Cari Nama Pasien");
        System.out.printf("| %-2d | %-42s |\n", 3, "Cari Golongan Penyakit");
        System.out.printf("| %-2d | %-42s |\n", 4, "Pendaftaran Pasien");
        System.out.printf("| %-2d | %-42s |\n", 5, "Edit Data Pasien");
        System.out.printf("| %-2d | %-42s |\n", 6, "Hapus Data Pasien");
        System.out.printf("| %-2d | %-42s |\n", 7, "Tambah ke Antrian Prioritas");
        System.out.printf("| %-2d | %-42s |\n", 8, "Tampilkan Antrian");
        System.out.printf("| %-2d | %-42s |\n", 0, "Keluar");
        System.out.println("+----+--------------------------------------------+");
        System.out.print("Pilih menu: ");
    }



    // Function untuk membandingkan string A / a (validasi input)
    public static boolean samaString(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 >= 'A' && c1 <= 'Z') c1 += 32;
            if (c2 >= 'A' && c2 <= 'Z') c2 += 32;

            if (c1 != c2) return false;
        }
        return true;
    }

    // Procedure menambahkan data pasien (naihar)
    public static void tambahPasien() {
        System.out.print("Nama: ");
        nama[jumlahPasien] = input.nextLine();

        System.out.print("Umur: ");
        umur[jumlahPasien] = input.nextInt();
        input.nextLine();

        System.out.print("Asal: ");
        asal[jumlahPasien] = input.nextLine();

        System.out.print("Tanggal Lahir: ");
        tanggalLahir[jumlahPasien] = input.nextLine();

        // Memvalidasi tingkat penyakit
        do {
            System.out.print("Tingkat Penyakit (Ringan/Sedang/Berat): ");
            tingkatPenyakit[jumlahPasien] = input.nextLine();

            if (
                !samaString(tingkatPenyakit[jumlahPasien], "Ringan") &&
                !samaString(tingkatPenyakit[jumlahPasien], "Sedang") &&
                !samaString(tingkatPenyakit[jumlahPasien], "Berat")
            ) {
                System.out.println("Input tidak valid! Ulangi.");
            }

        } while (
            !samaString(tingkatPenyakit[jumlahPasien], "Ringan") &&
            !samaString(tingkatPenyakit[jumlahPasien], "Sedang") &&
            !samaString(tingkatPenyakit[jumlahPasien], "Berat")
        );

        System.out.print("Golongan Darah: ");
        golonganDarah[jumlahPasien] = input.nextLine();

        jumlahPasien++;
        System.out.println("Pasien berhasil ditambahkan.");
    }

    // Function Mencari pasien berdasarkan nama, menggunakan index (zaidan)
    public static int cariPasien() {
        System.out.print("Masukkan nama pasien: ");
        String cari = input.nextLine();

        for (int i = 0; i < jumlahPasien; i++) {
            if (samaString(nama[i], cari)) {
                return i;
            }
        }
        return -1;
    }

    // Procedure mengedit data pasien (zaidan)
    public static void editPasien() {
        int idx = cariPasien();
        if (idx == -1) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

       // Mengecek data didalam antrian
        boolean adaDiAntrian = false;
        for (int i = 0; i < jumlahAntrian; i++) {
            if (antrian[i] == idx) {
                adaDiAntrian = true;
                break;
            }
        }

        // Input data baru
        System.out.print("Nama baru: ");
        nama[idx] = input.nextLine();

        System.out.print("Umur baru: ");
        umur[idx] = input.nextInt();
        input.nextLine();

        System.out.print("Asal baru: ");
        asal[idx] = input.nextLine();

        System.out.print("Tanggal lahir baru: ");
        tanggalLahir[idx] = input.nextLine();

        // Memvalidasi tingkat penyakit
        do {
            System.out.print("Tingkat penyakit baru (Ringan/Sedang/Berat): ");
            tingkatPenyakit[idx] = input.nextLine();

            if (
                    !samaString(tingkatPenyakit[idx], "Ringan") &&
                            !samaString(tingkatPenyakit[idx], "Sedang") &&
                            !samaString(tingkatPenyakit[idx], "Berat")
            ) {
                System.out.println("Input tidak valid! Ulangi.");
            }

        } while (
                !samaString(tingkatPenyakit[idx], "Ringan") &&
                        !samaString(tingkatPenyakit[idx], "Sedang") &&
                        !samaString(tingkatPenyakit[idx], "Berat")
        );

        System.out.print("Golongan darah baru: ");
        golonganDarah[idx] = input.nextLine();

        // Jika semisal ada data didalam antrian, hapus dan tambahkan ulang
        if (adaDiAntrian) {
            hapusDariAntrian(idx);
            tambahKeAntrianPrioritas();
        }

        System.out.println("Data pasien berhasil diperbarui dan antrian diperbarui.");
    }


    // Procedure menghapus data pasien (zaidan)
    public static void hapusPasien() {
        int idx = cariPasien();
        if (idx == -1) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        for (int i = idx; i < jumlahPasien - 1; i++) {
            nama[i] = nama[i + 1];
            umur[i] = umur[i + 1];
            asal[i] = asal[i + 1];
            tanggalLahir[i] = tanggalLahir[i + 1];
            tingkatPenyakit[i] = tingkatPenyakit[i + 1];
            golonganDarah[i] = golonganDarah[i + 1]; // Hapus data golongan darah
        }
        jumlahPasien--;

        int i = 0;
        while (i < jumlahAntrian) {
            if (antrian[i] == idx) {
                // Hapus dari antrian
                for (int j = i; j < jumlahAntrian - 1; j++) {
                    antrian[j] = antrian[j + 1];
                }
                jumlahAntrian--;
            } else {
                if (antrian[i] > idx) {
                    antrian[i]--;
                }
                i++;
            }
        }

        System.out.println("Data pasien dan antrian berhasil dihapus.");
    }

    // Procedure mencari pasien berdasarkan golongan penyakit (zaidan)
    public static void cariPasienGolongan() {
        System.out.print("Masukkan tingkat penyakit: ");
        String cari = input.nextLine();

        boolean ada = false;

        for (int i = 0; i < jumlahPasien; i++) {
            if (samaString(tingkatPenyakit[i], cari)) {
                tampilkanPasien(i);
                System.out.println("--------------------");
                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Tidak ada pasien dengan golongan tersebut.");
        }
    }

    // Procedure menambahkan pasien ke antrian berdasarkan prioritas penyakit (bintang)
    public static void tambahKeAntrianPrioritas() {
        int idx = cariPasien();
        if (idx == -1) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        for (int i = 0; i < jumlahAntrian; i++) {
            if (antrian[i] == idx) {
                System.out.println("Pasien sudah ada di antrian.");
                return;
            }
        }

        int posisi = jumlahAntrian;

        // Menentukan posisi berdasarkan prioritas
        if (samaString(tingkatPenyakit[idx], "Berat")) {
            posisi = 0;
        }
        else if (samaString(tingkatPenyakit[idx], "Sedang")) {
            posisi = 0;
            while (posisi < jumlahAntrian &&
                    samaString(tingkatPenyakit[antrian[posisi]], "Berat")) {
                posisi++;
            }
        }

        // Tingkatan ringan selalu diakhir
        for (int i = jumlahAntrian; i > posisi; i--) {
            antrian[i] = antrian[i - 1];
        }

        antrian[posisi] = idx;
        jumlahAntrian++;

        System.out.println("Pasien berhasil masuk antrian sesuai prioritas.");
    }


    // Procedure menampilkan antrian pasien (bintang)
    public static void tampilkanAntrian() {
        if (jumlahAntrian == 0) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println();
        System.out.println("+----+----------------------+-------------------+");
        System.out.printf("| %-2s | %-20s | %-17s |\n", "No", "Nama Pasien", "Tingkat Penyakit");
        System.out.println("+----+----------------------+-------------------+");

        for (int i = 0; i < jumlahAntrian; i++) {
            int idx = antrian[i];
            System.out.printf(
                    "| %-2d | %-20s | %-17s |\n",
                    (i + 1),
                    nama[idx],
                    tingkatPenyakit[idx]
            );
        }

        System.out.println("+----+----------------------+-------------------+");
    }



    // Procedure menampilkan data pasien berdasarkan index (bintang)
    static void tampilkanPasien(int i) {
        System.out.println();
        System.out.println("=================================================================================================");
        System.out.println("                                        DETAIL DATA PASIEN                                       ");
        System.out.println("=================================================================================================");

        System.out.printf(
                "| %-3s | %-15s | %-4s | %-12s | %-13s | %-15s | %-13s |\n",
                "No", "Nama", "Umur", "Asal", "Tgl Lahir", "Penyakit", "Gol. Darah"
        );

        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.printf(
                "| %-3d | %-15s | %-4d | %-12s | %-13s | %-15s | %-13s |\n",
                (i + 1),
                nama[i],
                umur[i],
                asal[i],
                tanggalLahir[i],
                tingkatPenyakit[i],
                golonganDarah[i]
        );

        System.out.println("=================================================================================================");
    }



    // Procedure menampilkan semua data pasien dalam bentuk tabel (bintang)
    public static void tampilkanSemuaPasien() {
        if (jumlahPasien == 0) {
            System.out.println("Belum ada data pasien.");
            return;
        }

        System.out.println("\n========================================== DAFTAR PASIEN ==========================================");
        System.out.printf(
                "| %-3s | %-15s | %-4s | %-12s | %-13s | %-15s | %-15s |\n",
                "No", "Nama", "Umur", "Asal", "Tgl Lahir", "Penyakit", "Gol. Darah"
        );
        System.out.println("---------------------------------------------------------------------------------------------------");

        for (int i = 0; i < jumlahPasien; i++) {
            System.out.printf(
                    "| %-3d | %-15s | %-4d | %-12s | %-13s | %-15s | %-15s |\n",
                    (i + 1),
                    nama[i],
                    umur[i],
                    asal[i],
                    tanggalLahir[i],
                    tingkatPenyakit[i],
                    golonganDarah[i]
            );
        }

        System.out.println("===================================================================================================");
    }

    // Delete data pasien (zaidan)
    static void hapusDariAntrian(int idx) {
        int i = 0;
        while (i < jumlahAntrian) {
            if (antrian[i] == idx) {
                for (int j = i; j < jumlahAntrian - 1; j++) {
                    antrian[j] = antrian[j + 1];
                }
                jumlahAntrian--;
            } else {
                i++;
            }
        }
    }

}
