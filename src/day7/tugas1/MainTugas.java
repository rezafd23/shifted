
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.io.FileInputStream;


public class MainTugas {
    public static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    
    private static boolean loginStatus=false;

    public static void main(String[] args) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        login();
        System.out.println("Status: "+loginStatus);
        while (loginStatus==false){
            login();
        }
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
                            menu3();
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

//    }

    private static void login(){
        boolean us = false;
        boolean pass = false;
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String username = "";
        String password = "";
        try {
            while (!us) {
                System.out.println("Masukan Username: ");
                username = br.readLine();
                us = Pattern.matches("[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}", username);
            }
            while (!pass) {
                System.out.println("Masukan Password: ");
                password = br.readLine();
                pass = Pattern.matches("(?=.*[A-Za-z])(?=.*[@#$%^&+=]).{8,}", password);
            }

            if (us & pass) {
                String user = "";
                String passwd = "";
                FileInputStream fin = new FileInputStream("username.txt");
                FileInputStream fin2 = new FileInputStream("password.txt");
                int i = 0;
                while ((i = fin.read()) != -1) {
                    user += (char) i;
                }
                while ((i = fin2.read()) != -1) {
                    passwd += (char) i;
                }

                if (username.equals(user)&password.equals(passwd)){
                    loginStatus=true;
                } else {
                    loginStatus=false;
                }
//                System.out.println(user);
//                System.out.println(passwd);
                fin.close();
                fin2.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // return loginStatus;
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

    private static void menu3() {
        try {

            String leftAlignFormat = "| %-11d | %-11s | %-11f | %-11f | %-11f |%n";
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
            System.out.format("|     ID      |    Nama     |  B.Inggris  |    Fisika   |  Algoritma  |%n");
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");


            for (int i = 0; i < dataMahasiswa.size(); i++) {
                System.out.format(leftAlignFormat, dataMahasiswa.get(i).getId(), dataMahasiswa.get(i).getNama(),
                        dataMahasiswa.get(i).getArrayList().get(0), dataMahasiswa.get(i).getArrayList().get(1), dataMahasiswa.get(i).getArrayList().get(2));
            }
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
 
            showMenu();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
