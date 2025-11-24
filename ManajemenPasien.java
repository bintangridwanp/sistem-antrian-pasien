import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenPasien {
    // Objek input scanner
    static Scanner input = new Scanner(System.in);

    // Array list untuk menyimpan daftar pasien dan antrian
    static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    static ArrayList<Pasien> antrian = new ArrayList<>();


    // Mencari pasien menggunakan nama
    public static Pasien cariPasienNama() {

        return null;
    }

    // Mencari pasien berdasarkan penyakit
    public static ArrayList<Pasien> cariPasienGolongan() {

        return null;
    }

    // Menambahkan data pasien
    public static void tambahPasien() {

    }

    // Mengedit data pasien
    public static void editPasien() {

    }

    // Menghapus data pasien
    public static void hapusPasien() {

    }

    // Menambahkan pasien ke antrian
    public static void tambahKeAntrian() {


    }

    // Menambahkan pasien ke antria preoritas
    public static void tambahKeAntrianPrioritas() {
        Pasien p = cariPasienNama();

        if (p == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        // logic prioritas
        if (p.tingkatPenyakit.equalsIgnoreCase("berat")) {
            antrian.add(0, p);

        } else if (p.tingkatPenyakit.equalsIgnoreCase("sedang")) {

            int posisi = 0;

            for (int i = 0; i < antrian.size(); i++) {
                if (antrian.get(i).tingkatPenyakit.equalsIgnoreCase("berat")) {
                    posisi = i + 1;
                }
            }
            antrian.add(posisi, p);

        } else {
            antrian.add(p);
        }

        System.out.println("Pasien masuk ke antrian prioritas.");

    }

    // Menampilkan daftar antrian
    public static void tampilkanAntrian() {
        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("\n=== Antrian Pasien ===");
        int i = 1;
        for (Pasien p : antrian) {
            System.out.println(i + ". " + p.nama + " (" + p.tingkatPenyakit + ")");
            i++;
        }
    }

}