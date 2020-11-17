public class Staff extends Worker{
    private int tunjanganMakan;

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }

    public Staff() {
    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public int hitungTunjanganMakan(){
        int tunjangan=this.absensi*20000;
        return tunjangan;
    }

    @Override
    public String getIdKaryawan() {
        return this.idKaryawan;
    }

    @Override
    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan=idKaryawan;
    }

    @Override
    public String getNama() {
        return this.nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama=nama;
    }

    @Override
    public int getTunjanganPulsa() {
        return this.tunjanganPulsa;
    }

    @Override
    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa=tunjanganPulsa;
    }

    @Override
    public int getGajiPokok() {
        return this.gajiPokok;
    }

    @Override
    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok=gajiPokok;
    }

    @Override
    public int getAbsensi() {
        return this.absensi;
    }

    @Override
    public void setAbsensi(int absensi) {
        this.absensi=absensi;
    }

    @Override
    public int hitungAbsensi() {
        return this.absensi+1;
    }

    @Override
    public int hitungGaji() {
        int gaji=this.gajiPokok+this.tunjanganPulsa+this.tunjanganMakan;
        return gaji;
    }

    @Override
    public int getGajiTotal() {
        return this.gajiTotal;
    }

    @Override
    public void setGajiTotal(int gajiTotal) {
        this.gajiTotal=gajiTotal;
    }
}
