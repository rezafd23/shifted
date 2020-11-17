package day2.TugasSiswa;

public class Siswa {
    private String nama; //deklarasi variabel string "Nama"
    private Integer nilai;//deklarasi variabel Integer "Nilai"
    private String gender;//deklarasi variabel string "Gender"
    private String tglLahir;//deklarasi variabel string "tglLahir"

    public Siswa() {
    } //constructor class siswa

    public String getNama() {
        return nama;
    } //method getter variabel "nama"

    public void setNama(String nama) {
        this.nama = nama;
    }//method setter variabel "nama"

    public Integer getNilai() {
        return nilai;
    }//method getter variabel "nilai"

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }//method setter variabel "nilai"

    public String getGender() {
        return gender;
    }//method getter variabel "gender"

    public void setGender(String gender) {
        this.gender = gender;
    }//method setter variabel "gender"

    public String getTglLahir() {
        return tglLahir;
    } //method getter variabel "tglLahir"

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    } //method setter variabel "tglLahir"

    public String cetakNilai(int nilai){ //method string untuk cetak nilai A/B/C/D
        if (nilai>=80&&nilai<=100){ //cek kondisi untuk nilai A ketika lebih dari 80 dan kurang dari 100
            return "A";
        } else if (nilai>=60&&nilai<=79){//cek kondisi untuk nilai B ketika lebih dari 60 dan kurang dari 79
            return "B";
        }else if (nilai>=40&&nilai<=59){//cek kondisi untuk nilai C ketika lebih dari 40 dan kurang dari 59
            return "C";
        }else if (nilai>=20&&nilai<=39){//cek kondisi untuk nilai D ketika lebih dari 20 dan kurang dari 39
            return "D";
        } else if (nilai>100){//cek kondisi untuk handling ketika  nilai lebih  100
            return "Nilai Salah";
        }
        else {//cek kondisi untuk handling nilai E
            return "E";
        }
    }

    public int hitungUmur(String tglLahir){//method integer untuk menghitung umur
        int thnLahir=Integer.parseInt(tglLahir.substring(6,10));//create variabel int untuk mendapatkan tahun lahir
        int usia=2020-thnLahir;//hitung umur
        return usia;//return hasil perhitungan
    }

    public String kategoriUmur(int umur){//method string untuk menentukan kategori umur
        String kategori="";//buat local variabel string kategori
        if (umur<18){//cek kondisi jika umur dibawah 18, maka return kategori "Usia Sekolah"
            kategori="Usia Sekolah";
        }
        else if (umur>=18&&umur<=21){//cek kondisi jika umur lebih dari sama dengan 18 dan kurang dari sama dengan 21"
            switch (umur){
                case 18://cek kondisi jika umur 18 maka return kategori "Kuliah tingkat 1"
                    kategori= "Kuliah Tingkat 1";
                    break;
                case 19://cek kondisi jika umur 19 maka return kategori "Kuliah tingkat 2"
                    kategori= "Kuliah Tingkat 2";
                    break;
                case 20://cek kondisi jika umur 20 maka return kategori "Kuliah tingkat 3"
                    kategori= "Kuliah Tingkat 3";
                    break;
                case 21://cek kondisi jika umur 21 maka return kategori "Kuliah tingkat 4"
                    kategori= "Kuliah Tingkat 4";
                    break;
            }
        } else if (umur>=22&&umur<=45){//cek kondisi jika umur lebih dari sama dengan 22 dan kurang dari sama dengan 45 maka return kategori "usia bekerja"
            kategori="Usia Bekerja";
        } else {//cek kondisi jika umur lebih dari sama dengan 45 maka return kategori "usia pensiun"
            kategori="Usia Pensiun";
        }
        return kategori;//return value kategori
    }

    public void printTahunUmur(String tglLahir){//method untuk print tahun beserta usia
        int thnLahir=Integer.parseInt(tglLahir.substring(6,10));//create local variable int berisi tahun lahir
//        System.out.println("tahun "+thnLahir);
        int usia=0;//create local variable untuk usia
        for (int thn=thnLahir;thn<=2020;thn++){//looping untuk pengecekan jika tahun lahir kurang dari tahun sekarang
            System.out.println("Pada Tahun "+thn+" Usianya adalah "+usia);//print tahun beserta usia
            usia=usia+1;//penambahan usia
        }
    }

    public String formatTglLahir(String tglLahir){//method untuk reformat tanggal lahir
        String[] split = tglLahir.split("-");//split tanggal lahir menjadi tanggal,bulan dan tahun
        String bulan="";//buat local variabel bulan
//        System.out.println(split[1]);
        switch (split[1]){//cek kondisi bulan dari array split elemen ke 1
            case "01": //jika bulan sama dengan 01 maka set variabel bulan ="Januari"
                bulan="Januari";
                break;
            case "02"://jika bulan sama dengan 02 maka set variabel bulan ="Februari"
                bulan="Februari";
                break;
            case "03"://jika bulan sama dengan 03 maka set variabel bulan ="Maret"
                bulan="Maret";
                break;
            case "04"://jika bulan sama dengan 04 maka set variabel bulan ="April"
                bulan="April";
                break;
            case "05"://jika bulan sama dengan 05 maka set variabel bulan ="Mei"
                bulan="Mei";
                break;
            case "06"://jika bulan sama dengan 06 maka set variabel bulan ="Juni"
                bulan="Juni";
                break;
            case "07"://jika bulan sama dengan 07 maka set variabel bulan ="Juli"
                bulan="Juli";
                break;
            case "08"://jika bulan sama dengan 08 maka set variabel bulan ="Agustus"
                bulan="Agustus";
                break;
            case "09"://jika bulan sama dengan 09 maka set variabel bulan ="September"
                bulan="September";
                break;
            case "10"://jika bulan sama dengan 10 maka set variabel bulan ="Oktober"
                bulan="Oktober";
                break;
            case "11"://jika bulan sama dengan 11 maka set variabel bulan ="November"
                bulan="November";
                break;
            case "12"://jika bulan sama dengan 12 maka set variabel bulan ="Desember"
                bulan="Desember";
                break;
        }

        return split[0]+" "+bulan+" "+split[2];//return value string hasil reformat bulan
    }
}
