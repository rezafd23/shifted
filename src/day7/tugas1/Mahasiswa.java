package day7.tugas1;

import java.util.ArrayList;

public class Mahasiswa {
    private int id;
    private String nama;
    private int nilaiInggris;
    private int nilaiFisika;
    private int nilaiAlgoritma;
    private ArrayList<Double> arrayList = new ArrayList<>();

    public Mahasiswa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilaiInggris() {
        return nilaiInggris;
    }

    public void setNilaiInggris(int nilaiInggris) {
        this.nilaiInggris = nilaiInggris;
    }

    public int getNilaiFisika() {
        return nilaiFisika;
    }

    public void setNilaiFisika(int nilaiFisika) {
        this.nilaiFisika = nilaiFisika;
    }

    public int getNilaiAlgoritma() {
        return nilaiAlgoritma;
    }

    public void setNilaiAlgoritma(int nilaiAlgoritma) {
        this.nilaiAlgoritma = nilaiAlgoritma;
    }

    public ArrayList<Double> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }
}
