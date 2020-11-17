public abstract class Worker {
    protected String idKaryawan;
    protected String nama;
    protected int tunjanganPulsa;
    protected int gajiPokok;
    protected int absensi=20;
    protected int gajiTotal;

    public abstract String getIdKaryawan();

    public abstract void setIdKaryawan(String idKaryawan);

    public abstract String getNama();

    public abstract void setNama(String nama);

    public abstract int getTunjanganPulsa();

    public abstract void setTunjanganPulsa(int tunjanganPulsa);

    public abstract int getGajiPokok();

    public abstract void setGajiPokok(int gajiPokok);

    public abstract int getAbsensi();

    public abstract void setAbsensi(int absensi);

    public abstract int hitungAbsensi();

    public abstract int hitungGaji();

    public abstract int getGajiTotal();

    public abstract void setGajiTotal(int gajiTotal);
}