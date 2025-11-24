public class Pasien {
    String nama;
    int umur;
    String asal;
    String tanggalLahir;
    String tingkatPenyakit;

    void isiData(String namaBaru, int umurBaru, String asalBaru,
                 String tanggalBaru, String tingkatBaru) {

        nama = namaBaru;
        umur = umurBaru;
        asal = asalBaru;
        tanggalLahir = tanggalBaru;
        tingkatPenyakit = tingkatBaru;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Umur: " + umur + ", Asal: " + asal +
                ", Tgl Lahir: " + tanggalLahir + ", Penyakit: " + tingkatPenyakit;
    }
}
