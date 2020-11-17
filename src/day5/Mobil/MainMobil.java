package day5.Mobil;

public class MainMobil {
    public static void main(String[] args) {
        Mobil mobil = new Mobil();
        mobil.setMerk("Ford Mustang");
        mobil.setTahun("2020");
        mobil.setKecepatan(160);
        System.out.println("=====================");
        System.out.println("Merk Mobil: "+mobil.getMerk());
        System.out.println("Tahun Pembuatan Mobil: "+mobil.getTahun());
        System.out.println("Kecepatan Awal: "+mobil.getKecepatan()+"kmh");
        mobil.tambahKecepatan(40);
        mobil.kurangiKecepatan(80);
    }
}
