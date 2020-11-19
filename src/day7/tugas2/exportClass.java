package day7.tugas2;

import java.util.Collections;
import java.util.ArrayList;
import java.io.FileWriter;
public class exportClass{
    
    public static void menu4(ArrayList<Mahasiswa> dataMahasiswa) {
         try {
            FileWriter fw = new FileWriter("NilaiMhs.txt");
            String leftAlignFormat = "| %-11d | %-11s | %-11f | %-11f | %-11f |%n";
            fw.write("+-------------+-------------+-------------+-------------+-------------+"+"\n");
            fw.write("|     ID      |    Nama     |  B.Inggris  |    Fisika   |  Algoritma  |"+"\n");
            fw.write("+-------------+-------------+-------------+-------------+-------------+"+"\n");

            Collections.sort(dataMahasiswa);
            for(Mahasiswa str:dataMahasiswa){
                String mh=String.format(leftAlignFormat, str.getId(), str.getNama(),
                        str.getArrayList().get(0), str.getArrayList().get(1), str.getArrayList().get(2));
                fw.write(mh);
            }
            fw.write("+-------------+-------------+-------------+-------------+-------------+"+"\n");
            fw.close();
        } catch (Exception e){
            System.out.println("Error "+e);
        }
    }
}