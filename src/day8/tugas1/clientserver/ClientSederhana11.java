package day8.tugas1.clientserver;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author REZAFD
 */
public class ClientSederhana11 {
    
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("192.168.1.2",8080);
            
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            
            //menerma informasi dari server
            System.out.println("Dari Server: "+dis.readUTF());
            System.out.println("Dari Server: "+dis.readUTF());
            
            Scanner sc = new Scanner(System.in);
            int angka1 = sc.nextInt();
            System.out.println("Angka ke-1: "+angka1);
            
            //mengirim informasi ke server
            dos.writeInt(angka1);
            dos.flush();//melepaskan
            
            System.out.println("Dari Server: "+dis.readUTF());
            
            int angka2 = sc.nextInt();
            System.out.println("Angka ke-2: "+angka2);
            
            //mengirim informasi ke server
            dos.writeInt(angka2);
            dos.flush();//melepaskan
            
            //menerima informasi dari server
            System.out.println(dis.readUTF());
            
            //mengirim
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientSederhana11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
}

