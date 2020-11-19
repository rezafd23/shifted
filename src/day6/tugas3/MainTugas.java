package day6.tugas3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainTugas {
    public static ArrayList<Staff> dataStaff = new ArrayList<>();
    public static ArrayList<Manager> dataManager = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String menu = "";
        try {
            while (!menu.equals("6")) {
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
                        menu3();
                        break;
                    case "4":
                        System.out.println();
                        menu4();
                        break;
                    case "5":
                        System.out.println();
                        menu5();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void menu1() {
//        String id="";
        String nama = "";
        String jabatan = "";
        String pulsa = "";
        String pokok = "";
        String transport = "";
        String entertainment = "";

        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            System.out.println("Silahkan Masukan Jabatan: ");
            System.out.println("1. Manager: ");
            System.out.println("2. Staff: ");
            jabatan = br.readLine();
            System.out.println("Silahkan Masukan Nama: ");
            nama = br.readLine();
            System.out.println("Silahkan Gaji Pokok: ");
            pokok = br.readLine();
            System.out.println("Silahkan Tunjangan Pulsa: ");
            pulsa = br.readLine();

            switch (jabatan) {
                case "1":
                    Manager manager = new Manager();
                    int idM = dataManager.size() + 1;
                    manager.setIdKaryawan(String.valueOf(idM));
                    manager.setNama(nama);
                    manager.setGajiPokok(Integer.valueOf(pokok));
                    manager.setTunjanganPulsa(Integer.valueOf(pulsa));
                    manager.setTunjanganEntertaiment(0);
                    manager.setTunjanganTransport(0);
                    dataManager.add(manager);
                    break;
                case "2":
                    Staff staff = new Staff();
                    int id = dataStaff.size() + 1;
                    staff.setIdKaryawan(String.valueOf(id));
                    staff.setNama(nama);
                    staff.setGajiPokok(Integer.valueOf(pokok));
                    staff.setTunjanganPulsa(Integer.parseInt(pulsa));
                    staff.setTunjanganMakan(0);
                    dataStaff.add(staff);
                    break;

            }
            System.out.println("Success data Berhasil Ditambah!!");
            showMenu();
        } catch (Exception e) {
            System.out.println("Error Menu 1: " + e);
            showMenu();
        }
    }

    private static void menu2() {
        String id = "";
        String jabatan = "";
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            System.out.println("Silahkan Masukan Jabatan: ");
            System.out.println("1. Staff ");
            System.out.println("2. Manager ");
            jabatan = br.readLine();
            System.out.println("Masukan Id Karyawan");
            id = br.readLine();
            switch (jabatan) {
                case "1":
                    for (Staff staff : dataStaff) {
                        if (staff.getIdKaryawan().equals(id)) {
                            staff.setAbsensi(staff.hitungAbsensi());
                            System.out.println("Absensi Berhasil!!! ");
                            showMenu();
                        }
                    }
                    break;
                case "2":
                    for (Manager manager : dataManager) {
                        if (manager.getIdKaryawan().equals(id)) {
                            manager.setAbsensi(manager.hitungAbsensi());
                            System.out.println("Absensi Berhasil!!! ");
                            showMenu();
                        }
                    }
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error Menu 2: " + e);
        }
    }

    private static void menu3() {
        String id = "";
        String jabatan = "";
        String enter = "";
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            System.out.println("Silahkan Masukan Jabatan: ");
            System.out.println("1. Staff ");
            System.out.println("2. Manager ");
            jabatan = br.readLine();
            System.out.println("Masukan Id Karyawan");
            id = br.readLine();
            switch (jabatan) {
                case "1":
                    for (Staff staff : dataStaff) {
                        if (staff.getIdKaryawan().equals(id)) {
                            staff.setTunjanganMakan(staff.hitungTunjanganMakan());
                            System.out.println("Perhitungan Tunjangan Berhasil!!! ");
                            showMenu();
                        }
                    }
                    break;
                case "2":
                    System.out.println("Masukan Berapa Kali Entertainment");
                    enter = br.readLine();
                    for (Manager manager : dataManager) {
                        if (manager.getIdKaryawan().equals(id)) {
                            manager.setTunjanganTransport(manager.hitungTunjTransport());
                            manager.setTunjanganEntertaiment(manager.hitungTunjEntertaiment(Integer.parseInt(enter)));
                            System.out.println("Perhitungan Tunjangan Berhasil!!! ");
                            showMenu();
                        }
                    }
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error Menu 3: " + e);
        }
    }

    private static void menu4() {
        for (Staff staff : dataStaff) {
            staff.setGajiTotal(staff.hitungGaji());
        }
        for (Manager manager : dataManager) {
            manager.setGajiTotal(manager.hitungGaji());
        }
        System.out.println("Perhitungan Gaji Berhasil");
        showMenu();
    }

    private static void menu5() {
        String leftAlignFormat = "| %-11s | %-11s | %-11s | %-11d | %-11d |%n";
        System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
        System.out.format("|     Id      |    Nama     |   Jabatan   |   Absensi   |  Gaji Total |%n");
        System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");

        for (int i = 0; i < dataManager.size(); i++) {
            System.out.format(leftAlignFormat, dataManager.get(i).getIdKaryawan(), dataManager.get(i).getNama(),
                    "Manager", dataManager.get(i).getAbsensi(),dataManager.get(i).getGajiTotal());
        }
        System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
        for (int i = 0; i < dataStaff.size(); i++) {
            System.out.format(leftAlignFormat, dataStaff.get(i).getIdKaryawan(), dataStaff.get(i).getNama(),
                    "Staff", dataStaff.get(i).getAbsensi(),dataStaff.get(i).getGajiTotal());
        }
        System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
        showMenu();
    }

    private static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Buat Karyawan");
        System.out.println("2. Tambah Absensi");
        System.out.println("3. Hitung Tunjangan");
        System.out.println("4. Hitung Gaji Total");
        System.out.println("5. Tampilkan Karyawan");
        System.out.println("6. Exit");
    }
}
