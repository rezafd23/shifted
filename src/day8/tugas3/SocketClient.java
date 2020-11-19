package day8.tugas3;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class SocketClient extends Thread{
    private static String serverMsg="";
    private static String propName="";
    private static String[]datafix;
    private static Socket s;
    private static Properties prop;
    public static void main(String[] args) {
        prop = new Properties();
        propName=args[0];
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
                    case "5":
//                        s.close();
                        menu5();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error Menu: " + e);
        }
    }

    private static void showMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Connect Socket");
        System.out.println("2. Send Data to Server");
        System.out.println("3. Thread Process");
        System.out.println("4. Download File");
        System.out.println("5. Close Connection");
        System.out.println("99. Exit");
        System.out.println("Masukan Menu: ");
    }

    private static void menu1(){
        try {
//            s = new Socket("localhost", 6666);
            s = new Socket(prop.getProperty("IP"), Integer.parseInt(prop.getProperty("PORT")));
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            dout.writeUTF("1");
            dout.flush();
            serverMsg= (String) dis.readUTF();
//            System.out.println("isi MSG: "+msg);
            dout.close();
            showMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void menu2(){
        try {
            FileWriter fw = new FileWriter("/Users/test/IdeaProjects/shifted/src/day8/tugas3/FileProses.txt");
            fw.write("Data Siswa:"+"\n");
            fw.write("========================================"+"\n");
            datafix=serverMsg.split("-");

            for (int i=0;i<datafix.length;i++){
                String[]subData=datafix[i].split(",");
                fw.write("Nama: "+subData[0]+"\n");
                fw.write("Fisika: "+subData[1]+"\n");
                fw.write("Kimia: "+subData[2]+"\n");
                fw.write("Biologi: "+subData[3]+"\n");
                fw.write("========================================"+"\n");
            }
            fw.close();
            showMenu();
        } catch (Exception e){
            System.out.println("Error Menu 2: "+e);
        }
    }

    public void run() {
      try {
          ThreadPrint threadPrint = new ThreadPrint();
          threadPrint.setDatafix(datafix);
          ThreadExportAverage exportAverage = new ThreadExportAverage();
          exportAverage.setDatafix(datafix);
          ThreadUploadFTP uploadFTP = new ThreadUploadFTP();
          uploadFTP.setFilename("/Users/test/IdeaProjects/shifted/src/day8/tugas3/DataSiswa.txt");
      } catch (Exception e){
          System.out.println("Error Thread Running: "+e);
      }finally {
          showMenu();
      }
    }

    private static void menu4(){
        String server = "ftp.myth.co.id";
        int port = 21;
        String user = "ftpuser@myth.co.id";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "./download/avegare.txt";
            File downloadFile1 = new File("/Users/test/IdeaProjects/shifted/src/day8/tugas3/avegare.txt");
//            File downloadFile1 = new File("avegare2.txt");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
                showMenu();
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            showMenu();
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void menu5(){
        try {
//            s = new Socket("localhost", 6666);
//            s.isClosed();
            System.out.println("Socket Stat: "+s.isClosed());
            if (!s.isClosed()){
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF("5");
                dout.flush();
                dout.close();
                s.close();
            }

            System.out.println("Connection Closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
