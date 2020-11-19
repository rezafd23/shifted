package day4;

import java.io.*;
public class tugas42{
    public static void main(String args[]){
        try{
        FileOutputStream fout = new FileOutputStream("Mahasiswa.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        Mahasiswa mhs = new Mahasiswa("001","Reza","L");
        String mh="Id: "+mhs.getId()+", Nama: "+mhs.getNama()+", Gender: "+mhs.getGender()+"\n";
       
        byte b[]=mh.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();

        FileInputStream fin = new FileInputStream("Mahasiswa.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);
        int i=0;
        while((i=bin.read())!=-1){
                System.out.print((char)i);
            }
            bin.close();
            fin.close();

        System.out.println("success");
        } catch(Exception e){
            System.out.println("Error "+e);
        }
    }
}