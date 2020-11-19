package day8.tugas3;

public class ThreadPrint extends Thread{

    private String[] datafix;

    public String[] getDatafix() {
        return datafix;
    }

    public void setDatafix(String[] datafix) {
        this.datafix = datafix;
    }

    public void run(){
        System.out.println("Data Siswa:");
        System.out.println("========================================");
        for (int i=0;i<this.datafix.length;i++){
            String[]subData=this.datafix[i].split(",");
            System.out.println("Nama: "+subData[0]);
            System.out.println("Fisika: "+subData[1]);
            System.out.println("Kimia: "+subData[2]);
            System.out.println("Biologi: "+subData[3]);
            System.out.println("========================================");
        }
    }
}
