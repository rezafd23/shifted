package day9.tugas2;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

public class ThreadUploadFTP extends Thread {

    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void run(){
        String server = "ftp.myth.co.id";
        int port = 21;
        String user = "ftpuser@myth.co.id";
        String pass = "password";


        FTPClient ftpClient = new FTPClient();
        try {
            FileWriter fw = new FileWriter("/Users/test/IdeaProjects/shifted/src/day9/tugas2/FileFTP.txt");
            fw.write(this.param);
            fw.close();

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File("/Users/test/IdeaProjects/shifted/src/day9/tugas2/FileFTP.txt");

            String firstRemoteFile = "Tugas2Reza.txt";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
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
}
