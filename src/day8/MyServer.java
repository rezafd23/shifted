package day8;

import java.io.*;
import java.net.*;
import java.util.Properties;

public class MyServer {
    public static void main(String[] args) {
        try {

//            FileInputStream fis = new FileInputStream("config.properties");
//            Properties prop = new Properties();
//            prop.load(fis);
//            String param="ENV.properties";
//            InputStream propertiesInputStream = MyServer.class.getClassLoader().getResourceAsStream(param);
//            prop.load(propertiesInputStream);

//            System.out.println("PORT: "+prop.getProperty("PORT"));

            int port =6666;
            ServerSocket ss = new ServerSocket(port);
            System.out.println("============================");
            System.out.println("Listening........");
            Socket sock = ss.accept();
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);


//            InputStream stream = day8.MyServer.class.getResourceAsStream("config.properties");
//            prop.load(stream);
//            Properties prop = new Properties();
//            String propFileName = "config.properties";
//
//            InputStream inputStream = MyServer.class.getClassLoader().getResourceAsStream(propFileName);
//            prop.load(inputStream);
//            System.out.println("Isi Param: "+prop.getProperty("PORT"));
//            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
//            ServerSocket ss = new ServerSocket(8080);
//            System.out.println("Listening");
//            Socket s = ss.accept();//establishes connection

            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}