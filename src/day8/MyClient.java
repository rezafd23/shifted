package day8;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        showMenu();
        String menu = "";
        try {
            while (!menu.equals("99")) {
                menu = br.readLine();
                switch (menu) {
                    case "1":
                        System.out.println();
                        menu1();
                        break;
                    case "2":
                        System.out.println();
//                        menu2();
                        break;
                    case "3":
//                        menu3();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void showMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Connect Socket");
        System.out.println("2. Send Data to Server");
        System.out.println("3. Close Socket");
        System.out.println("4. Exit");
        System.out.println("Masukan Menu: ");
    }

    private static void menu1(){
        try {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            dout.writeUTF("1");
            dout.flush();
            dout.close();
            s.close();
            showMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void menu2(){
//        Create FileProses.txt
//                -> Formatnya
//        Nama : John
//        Nilai Fisika : 10
//        Nilai Kimia : 9
//        Nilai Biologi : 8
//
//        Nama : Peter
//        Nilai Fisika : X
//        Nilai Kimia : X
//        Nilai Biologi : X
//        String[]dataMhs=s
    }
}