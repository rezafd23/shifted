package day8.tugas3;

public class ThreadPrint {

    public static void printData(String[] datafix){
        System.out.println("Data Siswa:");
        System.out.println("========================================");
        for (int i=0;i<datafix.length;i++){
            String[]subData=datafix[i].split(",");
            System.out.println("Nama: "+subData[0]);
            System.out.println("Fisika: "+subData[1]);
            System.out.println("Kimia: "+subData[2]);
            System.out.println("Biologi: "+subData[3]);
            System.out.println("========================================");
        }
    }
}
