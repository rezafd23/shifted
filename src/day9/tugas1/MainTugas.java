package day9.tugas1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTugas {
    public static ArrayList<Staff> dataStaff = new ArrayList<>();
    public static ArrayList<Manager> dataManager = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
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

    private static void menu1() {
//        String id="";
        String nama = "";
        String jabatan = "";
        String pulsa = "";
        String jmlhTelepon = "";
        String jmlhEmail = "";
        String telepon = "";
        String email = "";
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
                    ArrayList<String> arrayTelepon = new ArrayList<>();
                    System.out.println("Silahkan Masukan Jumlah No Telepon: ");
                    jmlhTelepon = br.readLine();
                    for (int i = 0; i < Integer.parseInt(jmlhTelepon); i++) {
                        int keT = i + 1;
                        System.out.println("Masukan No Telepon ke-" + keT);
                        telepon = br.readLine();
                        arrayTelepon.add(telepon);
                    }
                    Manager manager = new Manager();
                    int idM = dataManager.size() + 1;
                    manager.setIdKaryawan(String.valueOf(idM));
                    manager.setNama(nama);
                    manager.setGajiPokok(Integer.valueOf(pokok));
                    manager.setTunjanganPulsa(Integer.valueOf(pulsa));
                    manager.setTunjanganEntertaiment(1000000);
                    manager.setTunjanganTransport(1000000);
                    manager.setTelepon(arrayTelepon);
                    manager.setGajiTotal(manager.getGajiPokok() + manager.getTunjanganEntertaiment() + manager.getTunjanganPulsa() + manager.getTunjanganTransport());
                    dataManager.add(manager);
                    break;
                case "2":
                    ArrayList<String> arrayEmail = new ArrayList<>();
                    System.out.println("Silahkan Masukan Jumlah Email: ");
                    jmlhEmail = br.readLine();
                    for (int i = 0; i < Integer.parseInt(jmlhEmail); i++) {
                        int ke = i + 1;
                        System.out.println("Masukan No Email ke-" + ke);
                        email = br.readLine();
                        arrayEmail.add(email);
                    }
                    Staff staff = new Staff();
                    int id = dataStaff.size() + 1;
                    staff.setIdKaryawan(String.valueOf(id));
                    staff.setNama(nama);
                    staff.setGajiPokok(Integer.valueOf(pokok));
                    staff.setTunjanganPulsa(Integer.parseInt(pulsa));
                    staff.setTunjanganMakan(500000);
                    staff.setEmail(arrayEmail);
                    staff.setGajiTotal(staff.getGajiPokok() + staff.getTunjanganMakan() + staff.getTunjanganPulsa());
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
        try {
            JSONObject manager = new JSONObject();
            JSONArray jsonArrayManager = new JSONArray();
            for (int i = 0; i < dataManager.size(); i++) {
                JSONObject jsonManager = new JSONObject();
                JSONArray arrTelepon = new JSONArray();
                jsonManager.put("ID", dataManager.get(i).getIdKaryawan());
                jsonManager.put("Nama", dataManager.get(i).getNama());
                jsonManager.put("Jabatan", "Manager");
                jsonManager.put("GajiPokok", dataManager.get(i).getGajiPokok());
                jsonManager.put("Absensi", dataManager.get(i).getAbsensi());
                jsonManager.put("TunjPulsa", dataManager.get(i).getTunjanganPulsa());
                jsonManager.put("TunjTransport", dataManager.get(i).getTunjanganTransport());
                jsonManager.put("TunjEntertainment", dataManager.get(i).getTunjanganEntertaiment());
                jsonManager.put("GajiTotal", dataManager.get(i).getGajiTotal());
                for (int j = 0; j < dataManager.get(i).getTelepon().size(); j++) {
                    arrTelepon.add(j, dataManager.get(i).getTelepon().get(j));
                }
                jsonManager.put("Telepon", arrTelepon);
                jsonArrayManager.add(i, jsonManager);
            }
            manager.put("Manager", jsonArrayManager);

            JSONObject staff = new JSONObject();
            JSONArray jsonArrayStaff = new JSONArray();
            for (int i = 0; i < dataStaff.size(); i++) {
                JSONObject jsonStaff = new JSONObject();
                JSONArray arrEmail = new JSONArray();
                jsonStaff.put("ID", dataStaff.get(i).getIdKaryawan());
                jsonStaff.put("Nama", dataStaff.get(i).getNama());
                jsonStaff.put("Jabatan", "Staff");
                jsonStaff.put("GajiPokok", dataStaff.get(i).getGajiPokok());
                jsonStaff.put("Absensi", dataStaff.get(i).getAbsensi());
                jsonStaff.put("TunjPulsa", dataStaff.get(i).getTunjanganPulsa());
                jsonStaff.put("TunjMakan", dataStaff.get(i).getTunjanganMakan());
                jsonStaff.put("GajiTotal", dataStaff.get(i).getGajiTotal());
                for (int j = 0; j < dataStaff.get(i).getEmail().size(); j++) {
                    arrEmail.add(j, dataStaff.get(i).getEmail().get(j));
                }
                jsonStaff.put("Email", arrEmail);
                jsonArrayStaff.add(i, jsonStaff);
            }
            staff.put("Staff", jsonArrayStaff);

            FileWriter fw = new FileWriter("/Users/test/IdeaProjects/shifted/src/day9/tugas3/FileProses.txt");
//            FileWriter fw = new FileWriter("manager.txt");
            fw.write(String.valueOf(manager));
            fw.close();
            FileWriter fwS = new FileWriter("staff.txt");
            fwS.write(String.valueOf(staff));
            fwS.close();
        } catch (Exception e) {
            System.out.println("Error Menu 2: " + e);
        }
    }

    private static void menu3() {
        try {
            String file = "manager.txt";
            String fileS = "staff.txt";

            System.out.print("Success: ");
            String b = "";
            String d = "";

//            File myObj = new File(file);
//            File myObj2 = new File(fileS);

//            Scanner myReader = new Scanner("manager.txt");
//            Scanner myReader2 = new Scanner("staff.txt");
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                b=data;
//            }
//            while (myReader2.hasNextLine()) {
//                String data = myReader.nextLine();
//                d=data;
//            }

//            Manager
            File myObj = new File("manager.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                b = data;
            }
            JSONParser parser = new JSONParser();
            JSONObject jsonManager = (JSONObject) parser.parse(b);

            JSONArray elemManager = (JSONArray) jsonManager.get("Manager");
            System.out.println("Manager: "+elemManager);

            System.out.println("Data Manager");
            System.out.println("=================================");
            for (int i=0;i<elemManager.size();i++){
                JSONObject elem = (JSONObject)elemManager.get(i);
                JSONArray tlp = (JSONArray)elem.get("Telepon");
                System.out.println("ID: "+elem.get("ID"));
                System.out.println("Nama: "+elem.get("Nama"));
                for (int t=0;t<tlp.size();t++){
                    int tl=t+1;
                    System.out.println("No Telepon ke-"+tl+": "+tlp.get(t));
                }
                System.out.println("Jabatan: "+elem.get("Jabatan"));
                System.out.println("Absensi: "+elem.get("Absensi"));
                System.out.println("Gaji Pokok: "+elem.get("GajiPokok"));
                System.out.println("Tunjangan Entertainment: "+elem.get("TunjEntertainment"));
                System.out.println("Tunjangan Transport: "+elem.get("TunjTransport"));
                System.out.println("Tunjangan Pulsa: "+elem.get("TunjPulsa"));
                System.out.println("Gaji Total: "+elem.get("GajiTotal"));
                System.out.println("*****************************************");
            }

//            Staff
            File myObj2 = new File("staff.txt");
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                System.out.println(data);
                d = data;
            }
            JSONObject jsonStaff = (JSONObject) parser.parse(d);

            JSONArray elemStaff = (JSONArray) jsonStaff.get("Staff");

            System.out.println("=================================");
            System.out.println("Data Staff");
            System.out.println("=================================");
            for (int i=0;i<elemStaff.size();i++){
                JSONObject elem = (JSONObject)elemStaff.get(i);
                JSONArray email = (JSONArray)elem.get("Email");
                System.out.println("ID: "+elem.get("ID"));
                System.out.println("Nama: "+elem.get("Nama"));
                for (int t=0;t<email.size();t++){
                    int tl=t+1;
                    System.out.println("Email ke-"+tl+": "+email.get(t));
                }
                System.out.println("Jabatan: "+elem.get("Jabatan"));
                System.out.println("Absensi: "+elem.get("Absensi"));
                System.out.println("Gaji Pokok: "+elem.get("GajiPokok"));
                System.out.println("Tunjangan Makan: "+elem.get("TunjMakan"));
                System.out.println("Tunjangan Pulsa: "+elem.get("TunjPulsa"));
                System.out.println("Gaji Total: "+elem.get("GajiTotal"));
                System.out.println("*****************************************");
            }


//                System.out.println("Isi: " + jsonManager.get("Manager"));

//            }
//        System.out.println("Isi: " + jsonManager.get("Manager"));}
//        catch(ParseException e){
//                e.printStackTrace();
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
        private static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Buat Karyawan");
        System.out.println("2. Create and Export JSON");
        System.out.println("3. Read JSON");
        System.out.println("4. Exit");
    }
}
