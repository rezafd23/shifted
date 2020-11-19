package day7.tugas3;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AscSorting {
    private static ArrayList<Integer> listData=new ArrayList<>();

    public static void sortAsc(String fileName){
        try{
            FileInputStream fin =new FileInputStream(fileName);
            int i=0;
            System.out.print("Success: ");
            int j=0;
            String a="";
            while ((i = fin.read()) != -1) {
                j += 1;
                if ((char) i != ',') {
                    a=a+(char)i;

                } else {
                    System.out.println("nilai A: "+a);
                    int k=Integer.parseInt(a);
                    listData.add(k);
                    a="";
                    System.out.println(",");
                }
            }
            System.out.println();
            List<Integer> fix= bubleSort(listData);
            System.out.println("Hasil Sorting");
            FileWriter fw = new FileWriter("sortAsc.txt");
            fw.write("Hasil Sort Ascending:"+"\n");
            for (int k=0;k<fix.size();k++){
                fw.write(fix.get(k)+","+"\n");
                System.out.println(fix.get(k));
            }
            fw.close();
            fin.close();
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    private static List<Integer> bubleSort(List<Integer> a){
        for (int i=0;i<a.size()-1;i++){
            for(int j=0;j<a.size()-1-i;j++){
//                if(a[j+1]<a[j]){
                if(a.get(j+1)<a.get(j)){
                    int temp = a.get(j);
                    a.add(j, a.get(j+1));
                    a.add(j+1,temp);
                }
            }
        }
        return a;//return array
    }
}
