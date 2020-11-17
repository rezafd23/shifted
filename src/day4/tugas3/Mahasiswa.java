 package day4.tugas3;

public class Mahasiswa implements Comparable {
    private int id;
    private String nama;
    private int nilai;

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

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    @Override
    public int compareTo(Object o) {
        int compare= ((Mahasiswa)o).getId();
        return this.id-compare;
    }
}
