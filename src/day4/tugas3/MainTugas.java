package day4.tugas3;// package day4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainTugas {
    public static ArrayList<Mahasiswa> dataMahasiswa=new ArrayList<>();
    public static ArrayList<String> dataId=new ArrayList<>();
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

                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }

    }

    private static void menu1(){
        String id="";
        String nama="";
        String nilai="";
        try {
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.println("Silahkan Masukan Id: ");
            id=br.readLine();
            int length=dataMahasiswa.size();
//            if (length!=0){
                for (int i=0;i<dataMahasiswa.size();i++){
                    if (dataMahasiswa.get(i).getId()==Integer.parseInt(id)){
                        System.out.println("ID sudah Terdaftar");
                        System.out.println("Silahkan Masukan Id lain: ");
                        id=br.readLine();
                    }
                }
//            }

            System.out.println("Silahkan Masukan Nama: ");
            nama=br.readLine();
            System.out.println("Silahkan Masukan Nilai: ");
            nilai=br.readLine();

            Mahasiswa mhs = new Mahasiswa();
            mhs.setId(Integer.parseInt(id));
            mhs.setNama(nama);
            mhs.setNilai(Integer.parseInt(nilai));

            dataMahasiswa.add(mhs);
            System.out.println("Success data Berhasil Ditambah!!");

            showMenu();
        } catch (Exception e){
            System.out.println("Error Menu 1: "+e);
            showMenu();
        }
    }

    private static void menu2(){
        String id="";
        String nama="";
        String nilai="";
//        int idx=0;
        try{
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.println("Silahkan Masukan Id Mahasiswa: ");
            id=br.readLine();
            for (int i=0;i<dataMahasiswa.size();i++){
//                System.out.println("Index "+i);
                if (dataMahasiswa.get(i).getId()==Integer.parseInt(id)){
                    System.out.println("Nama : "+dataMahasiswa.get(i).getNama());
                    System.out.println("Nilai : "+dataMahasiswa.get(i).getNilai());
                    System.out.println();
                    System.out.println("Masukan Nama: ");
                    nama=br.readLine();
                    System.out.println("Masukan Nilai: ");
                    nilai=br.readLine();
                    Mahasiswa mhs = new Mahasiswa();
                    mhs.setId(Integer.parseInt(id));
                    mhs.setNama(nama);
                    mhs.setNilai(Integer.parseInt(nilai));
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
//                System.out.println("Index "+i);
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
        Collections.sort(dataMahasiswa);
        for(Mahasiswa str: dataMahasiswa){
            System.out.print("Id: "+str.getId()+", Nama: "+str.getNama()+", Nilai: "+str.getNilai()+"\n");
        }
        showMenu();
    }
    private static void menu5(){

        try {
            FileWriter fw = new FileWriter("exportMahasiswa.txt");
            Collections.sort(dataMahasiswa);
            for(Mahasiswa str: dataMahasiswa){
                fw.write("Id: "+str.getId()+"\n");
                fw.write("Nama: "+str.getNama()+"\n");
                fw.write("Nilai: "+str.getNilai()+"\n");
                fw.write("\n");
            }
            System.out.println("Success Export Data");
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