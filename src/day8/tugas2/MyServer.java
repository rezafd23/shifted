package day8.tugas2;//package day8.tugas2;

import day8.tugas3.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.regex.Pattern;

public class MyServer {
    private static boolean loginStatus=false;
    public static void main(String[] args) {

        Properties prop = new Properties();
        String propName = args[0];

        try {
            while (!loginStatus){
                System.out.println("Silahkan Login");
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
                        if (username.equals("reza@gmail.com")&password.equals("Password#@")){
                            loginStatus=true;
                            System.out.println("logStatus "+loginStatus);
                        } else {
                            loginStatus=false;
                        }
                    }
                } catch (Exception e){
                    System.out.println("Error: "+e);
                }
            }
            InputStream stream = SocketServer.class.getResourceAsStream(propName);
            prop.load(stream);
            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            System.out.println("LISTENING......");


            Socket s = ss.accept();//establishes connection


            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("isi "+str);

//            ss.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
