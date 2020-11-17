package day2.TugasSiswa;

public class MainSiswa {
    public static void main(String[] args) {
        Siswa siswa = new Siswa();//create object siswa berdasarkan class "Siswa"
        siswa.setNama("Reza Fadilah D");//set value nama siswa
        siswa.setGender("Laki-laki");//set value gender siswa
        siswa.setTglLahir("27-07-1997");//set value tanggal lahir siswa
        siswa.setNilai(82);//set value nilai siswa
        String Nilai=siswa.cetakNilai(siswa.getNilai());//panggil method cetak nilai yang di set ke variabel Nilai
        int umur =siswa.hitungUmur(siswa.getTglLahir());//panggil method hitung umur yang di set ke variabel umur
        String kategoriUmur=siswa.kategoriUmur(umur);//panggil method kategori umur yang di set ke variabel kategoriUmur
        String tglLahir=siswa.formatTglLahir(siswa.getTglLahir());//panggil method format tanggal lahir yang diset ke variabel tglLahir

        System.out.println("Nama "+siswa.getNama());//print Nama
        System.out.println("Jenis Kelamin  "+siswa.getGender());//print gender
        System.out.println("Nilainya adalah "+Nilai);//print nama
        System.out.println("Umurnya adalah "+umur);//print umurna
        System.out.println("Kategori Umurnya adalah "+kategoriUmur);//print kategori umur
        System.out.println("Lahirnya pada "+tglLahir);//print tanggal lahir yang bulannya telah diformat
        siswa.printTahunUmur(siswa.getTglLahir());//print tahun beserta usia

    }
}
