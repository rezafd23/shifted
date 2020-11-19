package day6.tugas2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainTugas {
    public static ArrayList<Staff> dataStaff=new ArrayList<>();
    public static void main(String[] args) {
        showMenu();
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String menu="";
        try {
            while (!menu.equals("4")){
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
                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
    }

    private static void menu1(){
//        String id="";
        String nama="";
        String jabatan="";

        try {
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);

            System.out.println("Silahkan Masukan Nama: ");
            nama=br.readLine();
            System.out.println("Silahkan Masukan Jabatan: ");
            jabatan=br.readLine();

            Staff staff = new Staff();
            int id = dataStaff.size()+1;
            staff.setIdKaryawan(String.valueOf(id));
            staff.setNama(nama);
            staff.setJabatan(jabatan);
            staff.setAbsensi(0);
            dataStaff.add(staff);
            System.out.println("Success data Berhasil Ditambah!!");
            showMenu();
        } catch (Exception e){
            System.out.println("Error Menu 1: "+e);
            showMenu();
        }
    }

    private static void menu2(){
        String id="";
        try{
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.println("Silahkan Masukan Id Staff: ");
            id=br.readLine();
            for (int i=0;i<dataStaff.size();i++){
                if (dataStaff.get(i).getIdKaryawan().equals(id)){
                    dataStaff.get(i).setAbsensi(dataStaff.get(i).tambahAbsensi());
                    System.out.println("Absensi Berhasil!!! ");
                    showMenu();
                }
            }

        } catch (Exception e){
            System.out.println("Error Menu 2: "+e);
        }
    }
    private static void menu3(){
        String leftAlignFormat = "| %-11s | %-11s | %-11s | %-11d |%n";
        // System.out.format("+-------------+-------------+-------------+-------------+%n");
        // System.out.format("|     Id      |    Nama     |   Jabatan   |   Absensi   |%n");
        // System.out.format("+-------------+-------------+-------------+-------------+%n");

        System.out.format("+-------------+-------------+-------------+-------------+%n");
        System.out.format("|     Id      |    Nama     |   Jabatan   | Absensi/hari|%n");
        System.out.format("+-------------+-------------+-------------+-------------+%n");

        for (int i = 0; i < dataStaff.size(); i++) {
            System.out.format(leftAlignFormat, dataStaff.get(i).getIdKaryawan(),dataStaff.get(i).getNama(),
                    dataStaff.get(i).getJabatan(),dataStaff.get(i).getAbsensi());
        }
        System.out.format("+-------------+-------------+-------------+-------------+%n");
        showMenu();
    }
    private static void showMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Buat Staff");
        System.out.println("2. Tambah Absensi");
        System.out.println("3. Tampilkan Staff");
        System.out.println("4. Exit");
    }
}
