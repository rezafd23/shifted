package day9.tugas2;

import day8.tugas3.SocketServer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class SocketClient extends Thread {
    private static String serverMsg = "";
    private static String propName = "";
    private static String[] datafix;
    private static Socket s;
    private static Properties prop;

    public static void main(String[] args) {
        prop = new Properties();
        propName = "config.properties";
        InputStream stream = SocketServer.class.getResourceAsStream(propName);

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        showMenu();
        String menu = "";
        try {
            prop.load(stream);
            while (!menu.equals("99")) {
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
                        SocketClient client = new SocketClient();
                        client.start();
                        break;
                    case "4":
                        menu4();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error Menu: " + e);
        }
    }

    private static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Connect Socket");
        System.out.println("2. Send Data to Server");
        System.out.println("3. Thread Process");
        System.out.println("4. Close Connection");
        System.out.println("99. Exit");
        System.out.println("Masukan Menu: ");
    }

    private static void menu1() {
        try {
            s = new Socket(prop.getProperty("IP"), Integer.parseInt(prop.getProperty("PORT")));
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            dout.writeUTF("1");
            dout.flush();
            serverMsg = (String) dis.readUTF();
            dout.close();
            showMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void menu2() {
        try {
//            datafix=serverMsg.split("-");
            JSONParser parser = new JSONParser();
            JSONObject jsonSiswa = (JSONObject) parser.parse(serverMsg);
            JSONArray elemSiswa = (JSONArray) jsonSiswa.get("Siswa");
            FileWriter fw = new FileWriter("/Users/test/IdeaProjects/shifted/src/day9/tugas2/FileProses.txt");
            fw.write("Data Siswa:" + "\n");
            fw.write("========================================" + "\n");
//            System.out.println("elemSiswa: "+elemSiswa);
            for (int i = 0; i < elemSiswa.size(); i++) {
                JSONObject elSiswa = (JSONObject) elemSiswa.get(i);
                fw.write("Nama: " + elSiswa.get("Nama")+ "\n");
                fw.write("Biologi: " + elSiswa.get("Biologi")+ "\n");
                fw.write("Kimia: " + elSiswa.get("Kimia")+ "\n");
                fw.write("Fisika: " + elSiswa.get("Fisika")+ "\n");
                fw.write("========================================" + "\n");
            }
            fw.close();
            showMenu();
        } catch (Exception e) {
            System.out.println("Error Menu 2: " + e);
        }
    }

    public void run() {
       try {
           ThreadPrint threadPrint = new ThreadPrint();
           threadPrint.setParam(serverMsg);
           ThreadUploadFTP uploadFTP = new ThreadUploadFTP();
           uploadFTP.setParam(serverMsg);

       } catch (Exception err){
           System.out.println("Error Thread Run: "+err);
       } finally {
           showMenu();
       }
    }

    private static void menu4(){
        try {
            System.out.println("Socket Stat: "+s.isClosed());
            if (!s.isClosed()){
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF("4");
                dout.flush();
                dout.close();
                s.close();
            } else {
                System.out.println("Connection Closed!");
                s = new Socket(prop.getProperty("IP"), Integer.parseInt(prop.getProperty("PORT")));
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF("4");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            showMenu();
        }
    }
}
