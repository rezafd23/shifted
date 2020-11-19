package day9.tugas3;

import day6.tugas3.Manager;
import day6.tugas3.Staff;
import day7.tugas3.MainTugas3Day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainTugas3Day9 {
    public static void main(String args[]) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        showMenu();
        String menu = "";
        try {
            while (!menu.equals("5")) {
                menu = br.readLine();
                switch (menu) {
                    case "1":
                        System.out.println();
                        menu1();
                        break;
                    case "2":
                        menu2();
//                        showMenu();
                        break;
                    case "3":
                        menu3();
                        break;
                    case "4":
                        menu4();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    private static void menu1() {
        String nama = "";
        String address = "";
        String status = "";
        String fisika = "";
        String calculus = "";
        String biologi = "";

        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            System.out.println("Silahkan Masukan Nama: ");
            nama = br.readLine();
            System.out.println("Silahkan Masukan Alamat: ");
            address = br.readLine();
            System.out.println("Silahkan Masukan Status: ");
            status = br.readLine();
            System.out.println("Silahkan Masukan Nilai Fisika: ");
            fisika = br.readLine();
            System.out.println("Silahkan Masukan Nilai Calculus: ");
            calculus = br.readLine();
            System.out.println("Silahkan Masukan Nilai Biologi: ");
            biologi = br.readLine();

            ControllerQuery query = new ControllerQuery();
            Siswa siswa = new Siswa();
            siswa.setFullName(nama);
            siswa.setAddress(address);
            siswa.setStatus(status);
            siswa.setPhysics(Integer.parseInt(fisika));
            siswa.setCalculus(Integer.parseInt(calculus));
            siswa.setBiologi(Integer.parseInt(biologi));

            int res = query.addData(siswa);
            if (res == 200) {
                System.out.println("Success data Berhasil Ditambah!!");
            } else {
                System.out.println("ERROR ADD DATA");
            }
            showMenu();
        } catch (Exception e) {
            System.out.println("Error Menu 1: " + e);
            showMenu();
        }
    }

    private static void menu2() {
        ControllerQuery query = new ControllerQuery();
        query.showData();
        String id = "";
        String nama = "";
        String address = "";
        String status = "";
        String fisika = "";
        String calculus = "";
        String biologi = "";

        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            System.out.println("Silahkan Masukan Id Data Yang akan Diubah: ");
            id = br.readLine();
            System.out.println("Silahkan Masukan Nama: ");
            nama = br.readLine();
            System.out.println("Silahkan Masukan Alamat: ");
            address = br.readLine();
            System.out.println("Silahkan Masukan Status: ");
            status = br.readLine();
            System.out.println("Silahkan Masukan Nilai Fisika: ");
            fisika = br.readLine();
            System.out.println("Silahkan Masukan Nilai Calculus: ");
            calculus = br.readLine();
            System.out.println("Silahkan Masukan Nilai Biologi: ");
            biologi = br.readLine();

            Siswa siswa = new Siswa();
            siswa.setId(Integer.parseInt(id));
            siswa.setFullName(nama);
            siswa.setAddress(address);
            siswa.setStatus(status);
            siswa.setPhysics(Integer.parseInt(fisika));
            siswa.setCalculus(Integer.parseInt(calculus));
            siswa.setBiologi(Integer.parseInt(biologi));

            int res = query.updateData(siswa);
            if (res == 200) {
                System.out.println("Success data Berhasil Diubah!!");
            } else {
                System.out.println("ERROR EDIT DATA");
            }
            showMenu();
        } catch (Exception e) {
            System.out.println("Error Menu 2: " + e);
            showMenu();
        }

    }

    private static void menu3(){
        ControllerQuery query = new ControllerQuery();
        query.showData();
        showMenu();
    }

    private static void menu4() {
        String id="";
        ControllerQuery query = new ControllerQuery();
        query.showData();
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            System.out.println("Silahkan Masukan Id Data Yang akan Dihapus: ");
            id = br.readLine();

            int res = query.deleteData(Integer.parseInt(id));
            if (res == 200) {
                System.out.println("Success Hapus Data!!");
            } else {
                System.out.println("ERROR DELETE DATA");
            }
            showMenu();
        } catch (Exception e) {
            System.out.println("Error Menu 3: " + e);
            showMenu();
        }
    }

    private static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Tambah Data");
        System.out.println("2. Edit Data");
        System.out.println("3. Tampilkan Data");
        System.out.println("4. Hapus Data");
        System.out.println("5. Exit");
        System.out.println("Masukan Menu: ");
    }
}
