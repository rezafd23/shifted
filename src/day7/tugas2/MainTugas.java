package day7.tugas2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class MainTugas extends Thread {
    public static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    
    public static void main(String[] args) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

            showMenu();
            String menu = "";
            try {
                while (!menu.equals("4")) {
                    System.out.println("Masukan Menu: ");
                    menu = br.readLine();
                    switch (menu) {
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
                            MainTugas main = new MainTugas();
                            main.start();
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
    }


    private static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Buat Data Mahasiswa");
        System.out.println("2. Edit Data Mahasiswa");
        System.out.println("3. Tampilkan Data Mahasiswa");
        System.out.println("4. Exit");
    }

    private static void menu1() {
        ArrayList<Double> dataNilai = new ArrayList<>();
        String nama = "";
        String inggris = "";
        String fisika = "";
        String algoritma = "";
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            System.out.println("Silahkan Masukan Nama: ");
            nama = br.readLine();
            System.out.println("Silahkan Masukan Nilai Bahasa Inggris: ");
            inggris = br.readLine();
            System.out.println("Silahkan Masukan Nilai Fisika: ");
            fisika = br.readLine();
            System.out.println("Silahkan Masukan Nilai Algoritma: ");
            algoritma = br.readLine();

            Mahasiswa mhs = new Mahasiswa();
            int id = dataMahasiswa.size() + 1;
            mhs.setId(id);
            mhs.setNama(nama);

            dataNilai.add(Double.parseDouble(inggris));
            dataNilai.add(Double.parseDouble(fisika));
            dataNilai.add(Double.parseDouble(algoritma));
            mhs.setArrayList(dataNilai);
            dataMahasiswa.add(mhs);
            System.out.println("Success data Berhasil Ditambah!!");
            showMenu();
        } catch (Exception e) {
            System.out.println("Error Menu 1: " + e);
            showMenu();
        }
    }

    private static void menu2() {
        ArrayList<Double> dataNilai = new ArrayList<>();
        String id = "";
        String nama = "";
        String inggris = "";
        String fisika = "";
        String algoritma = "";

        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            System.out.println("Silahkan Masukan Id Mahasiswa: ");
            id = br.readLine();
            for (int i = 0; i < dataMahasiswa.size(); i++) {
                if (dataMahasiswa.get(i).getId() == Integer.parseInt(id)) {
                    System.out.println("Nama : " + dataMahasiswa.get(i).getNama());
                    System.out.println("Nilai B.Inggris : " + dataMahasiswa.get(i).getArrayList().get(0));
                    System.out.println("Nilai Fisika : " + dataMahasiswa.get(i).getArrayList().get(1));
                    System.out.println("Nilai Algoritma : " + dataMahasiswa.get(i).getArrayList().get(2));
                    System.out.println();
                    System.out.println("Masukan Nama: ");
                    nama = br.readLine();
                    System.out.println("Silahkan Masukan Nilai Bahasa Inggris: ");
                    inggris = br.readLine();
                    System.out.println("Silahkan Masukan Nilai Fisika: ");
                    fisika = br.readLine();
                    System.out.println("Silahkan Masukan Nilai Algoritma: ");
                    algoritma = br.readLine();

                    Mahasiswa mhs = new Mahasiswa();
                    mhs.setId(Integer.parseInt(id));
                    mhs.setNama(nama);
                    dataNilai.add(Double.parseDouble(inggris));
                    dataNilai.add(Double.parseDouble(fisika));
                    dataNilai.add(Double.parseDouble(algoritma));
                    mhs.setArrayList(dataNilai);
                    dataMahasiswa.set(i, mhs);
                    System.out.println("data Berhasil Diedit!!!");
                    showMenu();
                }
            }


        } catch (Exception e) {
            System.out.println("error Menu 2: " + e);
        }
    }

    public void run(){
        printClass print = new printClass();
        print.menu3(dataMahasiswa);
        exportClass export = new exportClass();
        export.menu4(dataMahasiswa);
    }

    private static void menu3() {
        try {

            String leftAlignFormat = "| %-11d | %-11s | %-11f | %-11f | %-11f |%n";
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
            System.out.format("|     ID      |    Nama     |  B.Inggris  |    Fisika   |  Algoritma  |%n");
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");

            Collections.sort(dataMahasiswa);
            for(Mahasiswa str:dataMahasiswa){
                System.out.format(leftAlignFormat, str.getId(), str.getNama(),
                        str.getArrayList().get(0), str.getArrayList().get(1), str.getArrayList().get(2));
            }
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
 
            showMenu();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    private static void menu4(){
        try {
            FileWriter fw = new FileWriter("NilaiMhs.txt");
            String leftAlignFormat = "| %-11d | %-11s | %-11f | %-11f | %-11f |%n";
            fw.write("+-------------+-------------+-------------+-------------+-------------+"+"\n");
            fw.write("|     ID      |    Nama     |  B.Inggris  |    Fisika   |  Algoritma  |"+"\n");
            fw.write("+-------------+-------------+-------------+-------------+-------------+"+"\n");

            for (int i = 0; i < dataMahasiswa.size(); i++) {
                String mh=String.format(leftAlignFormat, dataMahasiswa.get(i).getId(), dataMahasiswa.get(i).getNama(),
                        dataMahasiswa.get(i).getArrayList().get(0), dataMahasiswa.get(i).getArrayList().get(1), dataMahasiswa.get(i).getArrayList().get(2));
                fw.write(mh);
            }
            fw.write("+-------------+-------------+-------------+-------------+-------------+"+"\n");
            fw.close();
        } catch (Exception e){
            System.out.println("Error "+e);
        }
    }

}
