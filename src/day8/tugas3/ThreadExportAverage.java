package day8.tugas3;

import java.io.FileWriter;
import java.text.DecimalFormat;

public class ThreadExportAverage {
    public static void exportData(String[] datafix){
       try {
           FileWriter fw = new FileWriter("/Users/test/IdeaProjects/shifted/src/day8/tugas3/FileRata2.txt");
           fw.write("Data Nilai Rata-rata Siswa:"+"\n");
           fw.write("========================================"+"\n");
           DecimalFormat df = new DecimalFormat("#.##");
           for (int i=0;i<datafix.length;i++){
               String[]subData=datafix[i].split(",");
               double rata=(Integer.valueOf(subData[1])+Integer.valueOf(subData[2])+Integer.valueOf(subData[3]))/3;
               fw.write("Nama     : "+subData[0]+"\n");
               fw.write("Rata-rata: "+df.format(rata)+"\n");
               fw.write("========================================"+"\n");
           }
           fw.close();
       } catch (Exception e){
           System.out.println("Error Thread Export: "+e);
       }
    }
}
