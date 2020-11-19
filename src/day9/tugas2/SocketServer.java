package day9.tugas2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) {

        Properties prop = new Properties();
        String propName="config.properties";

        try {
            InputStream stream = SocketServer.class.getResourceAsStream(propName);
            prop.load(stream);
            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            System.out.println("LISTENING......");

            boolean stat=false;

//            String
            String str ="";
            while (!str.equals("4")){
                Socket s = ss.accept();//establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                str = dis.readUTF();
                System.out.println("isiSTR: "+str);
                switch (str){
                    case "1":
                        try {
                           String b="";
                            File myObj = new File("/Users/test/IdeaProjects/shifted/src/day9/tugas2/data.txt");
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                                String data = myReader.nextLine();
//                                System.out.println(data);
                                b =b+ data;
                            }
                            String[]data = b.split(",");
                            JSONArray dataSiswa= new JSONArray();
                            JSONObject jsonSiswa = new JSONObject();
                            int k=0;
                            for (int i=0;i< data.length;i=i+4){
                                JSONObject dataTemp = new JSONObject();
                                dataTemp.put("Nama",data[i]);
                                dataTemp.put("Fisika",data[i+1]);
                                dataTemp.put("Kimia",data[i+2]);
                                dataTemp.put("Biologi",data[i+3]);
                                dataSiswa.add(k,dataTemp);
                                k+=1;
                            }
                            jsonSiswa.put("Siswa",dataSiswa);
                            String siswa = jsonSiswa.toJSONString();
                            System.out.println("Siswa: "+siswa);
                            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                            dout.writeUTF(siswa);
                            dout.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
            System.out.println("Server Close!");
            ss.close();


            ss.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}