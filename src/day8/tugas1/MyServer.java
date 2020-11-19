 package day8.tugas1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
public class MyServer {
    public static void main(String[] args) {

        Properties prop = new Properties();
        String propName="config.properties";

        try {
            InputStream stream = MyServer.class.getResourceAsStream(propName);
            prop.load(stream);
            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            System.out.println("LISTENING......");
            // Socket ss = new Socket(prop.getProperty("IP"), Integer.parseInt(prop.getProperty("PORT")));

            Socket s = ss.accept();//establishes connection
            boolean stat=false;
            while (!stat){
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                if(!str.equals("exit")){
                    System.out.println("message From Client= " + str);
                    Scanner scanner =new Scanner(System.in);
                    String msg = scanner.nextLine();
                    if(!msg.equals("")){
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                        dout.writeUTF(msg);
                        dout.flush();
                    }
                } else{
                    stat=true;
                }

            }
            ss.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
