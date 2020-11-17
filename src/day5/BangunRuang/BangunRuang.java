package day5.BangunRuang;

import java.text.DecimalFormat;
public class BangunRuang {
    private int panjang;
    private int lebar;
    private int tinggi;
    private double jari;

    public BangunRuang() {
    }

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public double getJari() {
        return jari;
    }

    public void setJari(double jari) {
        this.jari = jari;
    }

    public int hitungVolume(int panjang, int lebar, int tinggi){
        return panjang*lebar*tinggi;
    }
    public int hitungVolume(int panjang){
        return panjang*panjang*panjang;
    }
    public double hitungVolume(double jari){
        double volume=(4/3)*3.14*jari*jari*jari;
        return volume;
    }

    public void hitungAverage(int balok,int kubus,double bola){
        double avg= (balok+kubus+bola)/3;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("rata ratanya adalah "+df.format(avg));
    }

    public void hitungSummary(int balok,int kubus,double bola){
        double total= (balok+kubus+bola);
        System.out.println("Totalnya adalah "+total);
    }
}
