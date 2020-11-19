package day7.tugas3;

import java.io.FileInputStream;

public class ThreadPool implements Runnable {
    private String message;

    public ThreadPool(String s) {
        this.message = s;
    }

    @Override
    public void run() {
        try {
            FileInputStream fin = new FileInputStream(message);
            int i = 0;
            System.out.print("Success: ");
            int j = 0;
            while ((i = fin.read()) != -1) {
                j += 1;
                if ((char) i != ',') {
                    if (j == 1) {
                        System.out.print(Thread.currentThread().getName() + " (Start) Number = " + (char) i);
                    } else {
                        System.out.print((char) i);
                    }
                } else {
                    j=0;
                    System.out.println(",");
                    processmessage();
                }
//                System.out.print(Thread.currentThread().getName() + " (Start) Number = " +(char)i);
//                if ((char)i==','){
//                    System.out.println();
//                }
//                System.out.print((char)i);
            }
            System.out.println(Thread.currentThread().getName() + " (End)");//prints thread name
            System.out.println("Finished all threads");
            MainTugas3Day7 mainTugas3Day7 = new MainTugas3Day7();
            mainTugas3Day7.showMenu();
            fin.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

//        System.out.println(Thread.currentThread().getName() + " (Start) Number = " + message);
//        processmessage();//call processmessage method that sleeps the thread for 2 seconds
//        System.out.println(Thread.currentThread().getName() + " (End)");//prints thread name
    }
    private void processmessage() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
