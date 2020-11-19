package day7.tugas2;

import java.util.Collections;
import java.util.ArrayList;
public class printClass{
    
    public static void menu3(ArrayList<Mahasiswa> dataMahasiswa) {
        try {
            String leftAlignFormat = "| %-11d | %-11s | %-11f | %-11f | %-11f |%n";
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
            System.out.format("|     ID      |    Nama     |  B.Inggris  |    Fisika   |  Algoritma  |%n");
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");

            Collections.sort(dataMahasiswa);
            for(Mahasiswa str:dataMahasiswa){
                System.out.format(leftAlignFormat, str.getId(), str.getNama(),
                        str.getArrayList().get(0), str.getArrayList().get(1), str.getArrayList().get(2));
            }
            System.out.format("+-------------+-------------+-------------+-------------+-------------+%n");
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}