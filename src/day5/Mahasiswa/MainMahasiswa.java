package day5.Mahasiswa;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainMahasiswa {
    public static ArrayList<Mahasiswa> dataMahasiswa=new ArrayList<>();
    public static void main(String[] args) {
        showMenu();
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String menu="";
        try {
            while (!menu.equals("6")){
                System.out.println("Masukan Menu: ");
                menu=br.readLine();
                switch (menu){
                    case "1":
                        System.out.println();
                        menu1();
                        break;
                    case "2":
                        System.out.println();
                        menu2();
                        break;
                    case "3":
                        System.out.println();
                        menu3();
                        break;
                    case "4":
                        menu4();
                        System.out.println();
                        break;
                    case "5":
                        menu5();
                        System.out.println();
                        break;
//                    InputStreamReader r =new InputStreamReader(System.in);
//                    BufferedReader br=new BufferedReader(r);

                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
    private static void menu1(){
        String nama="";
        String tugas="";
        String uts="";
        String uas="";
        try {
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);

            System.out.println("Silahkan Masukan Nama: ");
            nama=br.readLine();
            System.out.println("Silahkan Masukan Nilai Tugas: ");
            tugas=br.readLine();
            System.out.println("Silahkan Masukan Nilai UTS: ");
            uts=br.readLine();
            System.out.println("Silahkan Masukan Nilai UAS: ");
            uas=br.readLine();

            Mahasiswa mhs = new Mahasiswa();
            int id =dataMahasiswa.size()+1;
            mhs.setId(id);
            mhs.setNama(nama);
            mhs.setNilaiTugas(Integer.parseInt(tugas));
            mhs.setNilaiUts(Integer.parseInt(uts));
            mhs.setNilaiUas(Integer.parseInt(uas));
            DecimalFormat df = new DecimalFormat("#.#");
            double akhir= mhs.hitungNilaiAkhir(Integer.parseInt(tugas),Integer.parseInt(uts),Integer.parseInt(uas));
            String ak = df.format(akhir);
            mhs.setNilaiAkhir(ak);
            dataMahasiswa.add(mhs);
            System.out.println("Success data Berhasil Ditambah!!");
            showMenu();
        } catch (Exception e){
            System.out.println("Error Menu 1: "+e);
            showMenu();
        }
    }

    private static void menu2(){
        String id ="";
        String nama="";
        String tugas="";
        String uts="";
        String uas="";

        try{
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.println("Silahkan Masukan Id Mahasiswa: ");
            id=br.readLine();
            for (int i=0;i<dataMahasiswa.size();i++){
                if (dataMahasiswa.get(i).getId()==Integer.parseInt(id)){
                    System.out.println("Nama : "+dataMahasiswa.get(i).getNama());
                    System.out.println("Nilai Tugas : "+dataMahasiswa.get(i).getNilaiTugas());
                    System.out.println("Nilai UTS : "+dataMahasiswa.get(i).getNilaiUts());
                    System.out.println("Nilai UAS : "+dataMahasiswa.get(i).getNilaiUas());
                    System.out.println("Nilai Akhir : "+dataMahasiswa.get(i).getNilaiAkhir());
                    System.out.println();
                    System.out.println("Masukan Nama: ");
                    nama=br.readLine();
                    System.out.println("Silahkan Masukan Nilai Tugas: ");
                    tugas=br.readLine();
                    System.out.println("Silahkan Masukan Nilai UTS: ");
                    uts=br.readLine();
                    System.out.println("Silahkan Masukan Nilai UAS: ");
                    uas=br.readLine();
                    Mahasiswa mhs = new Mahasiswa();
                    mhs.setId(Integer.parseInt(id));
                    mhs.setNama(nama);
                    mhs.setNilaiTugas(Integer.parseInt(tugas));
                    mhs.setNilaiUts(Integer.parseInt(uts));
                    mhs.setNilaiUas(Integer.parseInt(uas));
                    DecimalFormat df = new DecimalFormat("#.#");
                    double akhir= mhs.hitungNilaiAkhir(Integer.parseInt(tugas),Integer.parseInt(uts),Integer.parseInt(uas));
                    String ak = df.format(akhir);
                    mhs.setNilaiAkhir(ak);
                    dataMahasiswa.set(i,mhs);
                    System.out.println("data Berhasil Diedit!!!");
                    showMenu();
                }
            }


        } catch (Exception e){
            System.out.println("error Menu 2: "+e);
        }
    }

    private static void menu3(){
        String id="";
        try{
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.println("Silahkan Masukan Id Mahasiswa: ");
            id=br.readLine();
            for (int i=0;i<dataMahasiswa.size();i++){
                if (dataMahasiswa.get(i).getId()==Integer.parseInt(id)){
                    dataMahasiswa.remove(i);
                    System.out.println("data Berhasil Dihapus!!!");
                    showMenu();
                }
            }

        } catch (Exception e){
            System.out.println("Error Menu 3: "+e);
        }
    }

    private static void menu4(){
        String leftAlignFormat = "| %-11s | %-5d | %-5d | %-5d | %-11s |%n";
        System.out.format("+-------------+-------+-------+-------+-------------+%n");
        System.out.format("| Nama        |  UTS  |  UAS  | Tugas | Nilai Akhir |%n");
        System.out.format("+-------------+-------+-------+-------+-------------+%n");

        for (int i = 0; i < dataMahasiswa.size(); i++) {
            System.out.format(leftAlignFormat, dataMahasiswa.get(i).getNama(),dataMahasiswa.get(i).getNilaiUts(),
                    dataMahasiswa.get(i).getNilaiUas(),dataMahasiswa.get(i).getNilaiTugas(),dataMahasiswa.get(i).getNilaiAkhir());
        }
        System.out.format("+-------------+-------+-------+-------+-------------+%n");
        showMenu();
    }
    private static void menu5(){
        try {
            FileWriter fw = new FileWriter("ujianMhs.txt");
            String leftAlignFormat = "| %-11s | %-5d | %-5d | %-5d | %-11s |%n";
            fw.write("+-------------+-------+-------+-------+-------------+"+"\n");
            fw.write("| Nama        |  UTS  |  UAS  | Tugas | Nilai Akhir |"+"\n");
            fw.write("+-------------+-------+-------+-------+-------------+"+"\n");

            for (int i = 0; i < dataMahasiswa.size(); i++) {
                String mh = String.format(leftAlignFormat, dataMahasiswa.get(i).getNama(),dataMahasiswa.get(i).getNilaiUts(),
                        dataMahasiswa.get(i).getNilaiUas(),dataMahasiswa.get(i).getNilaiTugas(),dataMahasiswa.get(i).getNilaiAkhir());
                fw.write(mh);
            }
            fw.write("+-------------+-------+-------+-------+-------------+");
            fw.close();
            showMenu();
        } catch (Exception e){
            System.out.println("Error "+e);
        }
    }

    private static void showMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Buat Object Mahasiswa");
        System.out.println("2. Edit Data Mahasiswa");
        System.out.println("3. Remove Object Mahasiswa");
        System.out.println("4. Laporan Data Mahasiswa");
        System.out.println("5. Export Laporan");
        System.out.println("6. Exit");
    }
}
