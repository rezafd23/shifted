package day4;// import java.io.FileOutputStream;
import java.io.FileInputStream;
public class FileOutputStreamExample{
    public static void main(String args[]){
        try{
            // FileOutputStream fout=new FileOutputStream("name.txt");
            // String name="Reza Fadilah D";
            // byte[] b=name.getBytes();
            // fout.write(b);
            // fout.write(69);
            // fout.write(90);
            // fout.write(65);
            // fout.write(32);
            // fout.close();

            FileInputStream fin =new FileInputStream("name.txt");
            // int i = fin.read();
            // System.out.println("Success: "+(char)i);
            int i=0;
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

//  FileInputStream fin=new FileInputStream("D:\\testout.txt");    
//             int i=fin.read();  
//             System.out.print((char)i);    
//   

// import java.io.FileOutputStream;  
// public class FileOutputStreamExample {  
//     public static void main(String args[]){    
//            try{    
//              FileOutputStream fout=new FileOutputStream("test.txt");   
//              fout.write(65);    
//              fout.close();    
//              System.out.println("success...");    
//             }catch(Exception e){System.out.println(e);}    
//       }    
// } 