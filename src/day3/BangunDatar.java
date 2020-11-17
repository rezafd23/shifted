package day3;

public class BangunDatar {
    private int lebar;
    private int panjang;
    private int tinggi;

    public BangunDatar() {
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public void hitungLuas(int panjang, int lebar){
        double luas = 0.5*panjang*lebar;
        System.out.println("Luas bangun datarnya adalah "+luas);
    }
    public void hitungLuas(float alas){
        double luas = 3.14*Math.pow(alas,2);
        System.out.println("Luas bangun datarnya adalah "+luas);
    }

    public void hitungLuas(int alas){
        int luas = alas*alas;
        System.out.println("Luas bangun datarnya adalah "+luas);
    }
    public void hitungUmur(int tahunLahir,int tahunSkrg){
        int umur = tahunSkrg-tahunLahir;
        System.out.println("Usianya adalah "+umur);
    }

}
