package day7.tugas3;


import java.io.FileInputStream;
public class SimpleThread{

    public static void printText(String nama){
        try{
            FileInputStream fin =new FileInputStream(nama);
            int i=0;
            System.out.print("Success: ");
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println();
            MainTugas3Day7 mainTugas3Day7 = new MainTugas3Day7();
            mainTugas3Day7.showMenu();
            fin.close();
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
}