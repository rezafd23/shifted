package day8.tugas1.clientserver;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author REZAFD
 */
public class ServerSederhana1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            ServerSocket ss = new ServerSocket(8080);
            System.out.println("============================");
            System.out.println("Listen");
            Socket sock = ss.accept();
            
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            
            
            //kirim informasi ke client
            dos.writeUTF("Hello");
            dos.writeUTF("Silahkan Masukan Nama Anda");
            
            //read informasi dari client
            String nama = dis.readUTF();
            System.out.println("Dari Client "+nama);
            
            //kirim info
            dos.writeUTF("Silahkan Masukan NRP");
            
            String NRP = dis.readUTF();
            System.out.println("NRP "+NRP);
            
            
            //kirim informasi ke client
            dos.writeUTF("Selamat Datang "+nama);
            
           
        } catch (IOException ex) {
            Logger.getLogger(ServerSederhana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
