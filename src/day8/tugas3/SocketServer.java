package day8.tugas3;

//import day8.tugas1.MyServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) {

        Properties prop = new Properties();
        String propName=args[0];

        try {
            InputStream stream = SocketServer.class.getResourceAsStream(propName);
            prop.load(stream);
            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            System.out.println("LISTENING......");

            boolean stat=false;

//            String
            String str ="";
            while (!str.equals("5")){
                Socket s = ss.accept();//establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                str = dis.readUTF();
                switch (str){
                    case "1":
                        try {
//                    FileInputStream fin =new FileInputStream("/Users/test/IdeaProjects/shifted/src/day8/tugas3/file.txt");
                            String file="/Users/test/IdeaProjects/shifted/src/day8/tugas3/"+args[1];
                            FileInputStream fin =new FileInputStream(file);
                            int i=0;
                            System.out.print("Success: ");
                            String a="";
                            String b="";
                            while ((i = fin.read()) != -1) {
                                if ((char) i != '\n') {
//                        if ((char) i != ',') {
//                            if((char)i!='\n'){
                                    a=a+(char)i;
//                            } else{
//                                a="";
//                            }
                                } else {
                                    b=b+a;
//                            dataTemp.add(a);
                                    a="-";
                                }
                            }
                            System.out.println("Isi File: "+b);
                            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                            dout.writeUTF(b);
                            dout.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }

            ss.close();
            System.out.println("Server Close!");

            ss.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
