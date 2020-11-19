package day7.tugas3;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DescSorting {
    private static ArrayList<Integer> listData=new ArrayList<>();

//    public static void sortDsc(String fileName){
//        try{
//            FileInputStream fin =new FileInputStream(fileName);
//            int i=0;
//            System.out.print("Success: ");
//            int j=0;
//            String a="";
//            while ((i = fin.read()) != -1) {
//                j += 1;
//                if ((char) i != ',') {
//                    a=a+(char)i;
//
//                } else {
//                    System.out.println("nilai A: "+a);
//                    int k=Integer.parseInt(a);
//                    listData.add(k);
//                    a="";
//                    System.out.println(",");
//                }
//            }
//            System.out.println();
//
//
//            ArrayList<Integer> arrtemp= new ArrayList<>();
//            arrtemp.add(10);
//            arrtemp.add(1);
//            arrtemp.add(5);
//            arrtemp.add(2);
//            arrtemp.add(7);
//            arrtemp.add(3);
//            List<Integer> fix= bubleSort(arrtemp);
////            List<Integer> fix= listData;
//            System.out.println("Hasil Sorting");
//            System.out.println(fix.get(0));
////            FileWriter fw = new FileWriter("sortDsc.txt");
////            fw.write("Hasil Sort Descending:");
////            for (int k=0;k<fix.size();k++){
////                fw.write(fix.get(k)+","+"\n");
////                System.out.println(fix.get(k));
////            }
////            fw.close();
//            fin.close();
//
//
//            MainTugas mainTugas = new MainTugas();
//            mainTugas.showMenu();
//
//        }
//        catch(Exception e){
//            System.out.println("Error: "+e);
//        }
//    }

//     for(int i=0; i < n; i++){
//        for(int j=1; j < (n-i); j++){
//
//            if(intArray[j-1] < intArray[j]){
//                //swap the elements!
//                temp = intArray[j-1];
//                intArray[j-1] = intArray[j];
//                intArray[j] = temp;
//            }

//    private static List<Integer> bubleSort(List<Integer> a){
//        for (int i=0;i<a.size()-1;i++){
//            for(int j=0;j<a.size()-1-i;j++){
////                if(a[j+1]<a[j]){
//                if(a.get(j+1)<a.get(j)){
//                    int temp = a.get(j);
//                    a.add(j, a.get(j+1));
//                    a.add(j+1,temp);
//                }
//            }
//        }
//        return a;//return array
//    }
public static void sortDsc(String fileName){
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
//                System.out.println("nilai A: "+a);
                int k=Integer.parseInt(a);
                listData.add(k);
                a="";
//                System.out.println(",");
            }
        }
        System.out.println();
//        List<Integer> fix= bubleSort(listData);
        Integer[] arrtemp=listData.toArray(new Integer[0]);
        System.out.println("Hasil Sorting");
        Integer[] arrSort=bubleSort(arrtemp);
        for (Integer obj : arrSort)
            System.out.println(obj);
        FileWriter fw = new FileWriter("sortDsc.txt");
        fw.write("Hasil Sort Descending:"+"\n");
        for (int k=0;k<arrSort.length;k++){
            fw.write(arrSort[k]+","+"\n");
            System.out.println(arrSort[k]);
        }
        fw.close();
        fin.close();


        MainTugas mainTugas = new MainTugas();
        mainTugas.showMenu();

    }
    catch(Exception e){
        System.out.println("Error: "+e);
    }
}
//    private static List<Integer> bubleSort(List<Integer> a){
    private static Integer[] bubleSort(Integer[] a){
//        for (int i=0;i<a.size()-1;i++){
//            for(int j=0;j<a.size()-1-i;j++){
//                if(a.get(j+1)<a.get(j)){
//                    int temp = a.get(j);
//                    a.add(j, a.get(j+1));
//                    a.add(j+1,temp);
//                }
//            }
//        }
        for (int i = 0; i < ( a.length - 1 ); i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;//return array
    }
}
