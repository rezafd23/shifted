package day5.Mobil;

public class Mobil {
    private String tahun;
    private String merk;
    private int kecepatan;

    public Mobil() {
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public void tambahKecepatan(int kecepatan){
        int speed=this.getKecepatan()+kecepatan;
        System.out.println("Kecepatan sekarang adalah "+speed+"kmh");
    }

    public void kurangiKecepatan(int kecepatan){
        int speed=this.getKecepatan()-kecepatan;
        System.out.println("Kecepatan sekarang adalah "+speed+"kmh");
    }
}
