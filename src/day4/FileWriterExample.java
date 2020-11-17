package day4;

import java.io.FileWriter;
public class FileWriterExample{
    public static void main(String args[]){
        try{
            FileWriter fw = new FileWriter("contoh3.txt");
            fw.write("Hello world!");
            fw.close();
        } catch (Exception e){
            System.out.println("Success");
        }
    }
}