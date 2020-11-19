package day4;

import java.io.FileOutputStream;
import java.io.FileInputStream;
public class tugas4{
    public static void main(String args[]){
        String nama = args[0];
         try{
            FileOutputStream fout=new FileOutputStream(nama+".txt");
            byte[] b=nama.getBytes();
            fout.write(b);
            fout.close();
           
            FileInputStream fin =new FileInputStream(nama+".txt"); 
            int i=0;
            System.out.print("Success: ");
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
            }
         catch(Exception e){
            System.out.println("Error: "+e);
         }
    }
}
