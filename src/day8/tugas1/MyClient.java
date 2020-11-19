package day8.tugas1;// package day8.tugas1;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        Properties prop = new Properties();
        String propName="config.properties";
        try {
            InputStream stream = MyClient.class.getResourceAsStream(propName);
            prop.load(stream);
            Socket st = new Socket(prop.getProperty("IP"), Integer.parseInt(prop.getProperty("PORT")));
            DataOutputStream dout = new DataOutputStream(st.getOutputStream());
            DataInputStream dis = new DataInputStream(st.getInputStream());
            // ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            // Socket s = ss.accept();//establishes connection

            Scanner scanner = new Scanner(System.in);
            boolean statCLient=true;
            while(statCLient){
                dout.writeUTF(scanner.nextLine());
                String msg= (String) dis.readUTF();
                dout.flush();
                // DataInputStream dis = new DataInputStream(s.getInputStream());
                // String str = (String) dint.readUTF();    
                // if (!str.equals("")){
                    System.out.println("message From Server= " + msg);
                // }
                if(scanner.nextLine().equals("exit")){
                    statCLient=false;
                }
            }
            // while(!scanner.nextLine().equals("exit")){

            // }
            //     ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            //     Socket s = ss.accept();//establishes connection
            //     boolean stat=false;
            //     while (!stat){
            //         DataInputStream dis = new DataInputStream(s.getInputStream());
            //         String str = (String) dis.readUTF();
            //         if(!str.equals("exit")){
            //             System.out.println("message From Server= " + str);
            //         } else{
            //             stat=true;
            //         }

            //     }
            
            dout.close();
            st.close();

           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
