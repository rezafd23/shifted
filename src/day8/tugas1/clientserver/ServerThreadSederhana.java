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
public class ServerThreadSederhana extends Thread {
     private static ServerSocket ss;
        private static Socket sock;
        private static int PORT=8080;
        private static int maxClient =3;
    public static void main(String[] args) {
         try {
             ss=new ServerSocket(PORT);
             System.out.println("==================");
             System.out.println("Listen");
             
             int i = 0;
             while (i++<maxClient){
                 sock=ss.accept();//menerima koneksi dari client
                 ServerThreadSederhana s = new ServerThreadSederhana();
                 s.start();
                 System.out.println("Membuat Thread untuk Client-"+i);
             }
         } catch (IOException ex) {
             Logger.getLogger(ServerThreadSederhana.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    public void run(){
        DataInputStream dis = null;
         try {
             dis = new DataInputStream(sock.getInputStream());
             DataOutputStream dos =  new DataOutputStream(sock.getOutputStream());
             
             //memberikan info ke client
             dos.writeUTF("Hello");
             dos.writeUTF("Silahkan Masukan Nama: ");
             
             //menerima info dari client
             String nama = dis.readUTF();
             System.out.println("Dari CLient: "+nama);
             
             //mengirimkan informasi ke client
             dos.writeUTF("Selamat Datang: "+nama);

         } catch (IOException ex) {
             Logger.getLogger(ServerThreadSederhana.class.getName()).log(Level.SEVERE, null, ex);
         } finally{//prosedur yg dijalankan mau masuk ke catch ataupun try 
            try {
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThreadSederhana.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
    }
}
//setiap membuat thread harus membuat modul run
