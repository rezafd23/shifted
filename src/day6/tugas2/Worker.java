public abstract class Worker {
    public String idKaryawan;
    public String nama;
    public int absensi;

    // public String getIdKaryawan() {
    //     return idKaryawan;
    // }

    // public void setIdKaryawan(String idKaryawan) {
    //     this.idKaryawan = idKaryawan;
    // }

    // public String getNama() {
    //     return nama;
    // }

    // public void setNama(String nama) {
    //     this.nama = nama;
    // }

    // public int getAbsensi() {
    //     return absensi;
    // }

    // public void setAbsensi(int absensi) {
    //     this.absensi = absensi;
    // }

    // public int tambahAbsensi() {
    //     int absen = this.absensi + 1;
    //     return absen;
    // }

    // public abstract int tambahAbsensi() {
    //     int absen = this.absensi + 1;
    //     return absen;
    // }
    
    public abstract String getIdKaryawan();

    public abstract void setIdKaryawan(String idKaryawan);

    public abstract String getNama();

    public abstract void setNama(String nama);

    public abstract int getAbsensi();

    public abstract void setAbsensi(int absensi);

    public abstract int tambahAbsensi();
}