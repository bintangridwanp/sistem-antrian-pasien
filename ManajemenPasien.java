import java.util.Scanner;

public class ManajemenPasien {
    static Scanner input = new Scanner(System.in);

    static String[] nama = new String[100];
    static int[] umur = new int[100];
    static String[] asal = new String[100];
    static String[] tanggalLahir = new String[100];
    static String[] tingkatPenyakit = new String[100];

    static int[] antrian = new int[100]; // simpan INDEX pasien
    static int jumlahAntrian = 0;

    // Menambahkan header
    public static void tampilkanHeader() {
        System.out.println("===============================================");
        System.out.println("        SISTEM ANTRIAN KLINIK KESEHATAN        ");
        System.out.println("===============================================");
    }

    // Menambahkan menu
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


    static int jumlahPasien = 0;

    // Function untuk membandingkan string A / a
    static boolean samaString(String a, String b) {
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

    // Procedure menambahkan data pasien
    static void tambahPasien() {
        System.out.print("Nama: ");
        nama[jumlahPasien] = input.nextLine();

        System.out.print("Umur: ");
        umur[jumlahPasien] = input.nextInt();
        input.nextLine();

        System.out.print("Asal: ");
        asal[jumlahPasien] = input.nextLine();

        System.out.print("Tanggal Lahir: ");
        tanggalLahir[jumlahPasien] = input.nextLine();

        System.out.print("Tingkat Penyakit: ");
        tingkatPenyakit[jumlahPasien] = input.nextLine();

        jumlahPasien++;
        System.out.println("Pasien berhasil ditambahkan.");
    }

    // Function Mencari pasien berdasarkan nama (menggunakan index)
    static int cariPasien() {
        System.out.print("Masukkan nama pasien: ");
        String cari = input.nextLine();

        for (int i = 0; i < jumlahPasien; i++) {
            if (samaString(nama[i], cari)) {
                return i;
            }
        }
        return -1;
    }

    // Procedure mengedit data pasien
    public static void editPasien() {
        int idx = cariPasien();
        if (idx == -1) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        System.out.print("Nama baru: ");
        nama[idx] = input.nextLine();

        System.out.print("Umur baru: ");
        umur[idx] = input.nextInt();
        input.nextLine();

        System.out.print("Asal baru: ");
        asal[idx] = input.nextLine();

        System.out.print("Tanggal lahir baru: ");
        tanggalLahir[idx] = input.nextLine();

        System.out.print("Tingkat penyakit baru: ");
        tingkatPenyakit[idx] = input.nextLine();

        System.out.println("Data pasien berhasil diperbarui.");
    }

    // Procedure menghapus data pasien
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
        }

        jumlahPasien--;
        System.out.println("Data pasien berhasil dihapus.");
    }

    // Procedure mencari pasien berdasarkan golongan penyakit
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

    // Procedure menambahkan pasien ke antrian prioritas
    public static void tambahKeAntrianPrioritas() {
        int idx = cariPasien();
        if (idx == -1) return;

        if (samaString(tingkatPenyakit[idx], "Berat")) {
            for (int i = jumlahAntrian; i > 0; i--) {
                antrian[i] = antrian[i - 1];
            }
            antrian[0] = idx;
        }
        else if (samaString(tingkatPenyakit[idx], "Sedang")) {
            int pos = 0;
            for (int i = 0; i < jumlahAntrian; i++) {
                if (samaString(tingkatPenyakit[antrian[i]], "Berat")) {
                    pos = i + 1;
                }
            }
            for (int i = jumlahAntrian; i > pos; i--) {
                antrian[i] = antrian[i - 1];
            }
            antrian[pos] = idx;
        }
        else {
            antrian[jumlahAntrian] = idx;
        }

        jumlahAntrian++;
        System.out.println("Pasien masuk ke antrian prioritas.");
    }

    // Procedure menampilkan antrian pasien
    public static void tampilkanAntrian() {
        if (jumlahAntrian == 0) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("\n=== DAFTAR ANTRIAN ===");
        for (int i = 0; i < jumlahAntrian; i++) {
            int idx = antrian[i];
            System.out.println(
                    (i + 1) + ". " + nama[idx] +
                            " (" + tingkatPenyakit[idx] + ")"
            );
        }
    }


    // Procedure menampilkan data pasien berdasarkan index
    static void tampilkanPasien(int i) {
        System.out.println("Nama   : " + nama[i]);
        System.out.println("Umur   : " + umur[i]);
        System.out.println("Asal   : " + asal[i]);
        System.out.println("Lahir  : " + tanggalLahir[i]);
        System.out.println("Penyakit: " + tingkatPenyakit[i]);
    }
}
