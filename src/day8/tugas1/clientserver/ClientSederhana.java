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
public class ClientSederhana {
    
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost",8080);
            
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            
            //menerma informasi dari server
            System.out.println("Dari Server: "+dis.readUTF());
            System.out.println("Dari Server: "+dis.readUTF());
            
            Scanner sc = new Scanner(System.in);
            String nama = sc.next();
            System.out.println("Nama Anda: "+nama);
            
            
            //mengirim informasi ke server
            dos.writeUTF(nama);
            dos.flush();//melepaskan
            
            //menerima informasi dari server
            System.out.println(dis.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(ClientSederhana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
}

