import java.util.ArrayList;

public class DataDummy {

    static ArrayList<Pasien> getDummyPasien() {
        ArrayList<Pasien> list = new ArrayList<>();

        Pasien p1 = new Pasien();
        p1.isiData("Joko", 21, "Bandung", "12-02-2004", "Ringan");

        Pasien p2 = new Pasien();
        p2.isiData("Budi", 34, "Surabaya", "08-09-1990", "Sedang");

        Pasien p3 = new Pasien();
        p3.isiData("Siti", 29, "Jakarta", "01-01-1996", "Berat");

        list.add(p1);
        list.add(p2);
        list.add(p3);

        return list;
    }
}
