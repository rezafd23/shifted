package day7.tugas3;

//import day7.tugas3.AscSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTugas3Day7 extends Thread{
    private static String filename="";
    private static String pilihmenu="";
    private static String thread="";
    public static void main(String args[]){
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        filename=args[0];
        thread=args[1];
//        filename="data.txt";
//        thread="10";

        showMenu();
        String menu = "";
        try {
            while (!menu.equals("4")) {
                menu = br.readLine();
                switch (menu) {
                    case "1":
                        System.out.println();
                        pilihmenu="1";
                        MainTugas3Day7 mainTugas3Day7 = new MainTugas3Day7();
                        mainTugas3Day7.start();
//                        System.out.println("asu");
                        break;
                    case "2":
                        System.out.println();
                        System.out.println("Asu2");
                        pilihmenu="2";
                        MainTugas3Day7 mainTugas3Day72 = new MainTugas3Day7();
                        mainTugas3Day72.start();
//                        showMenu();
                        break;
                    case "3":
                        System.out.println();
                        pilihmenu="3";
                        MainTugas3Day7 mainTugas3Day73 = new MainTugas3Day7();
                        mainTugas3Day73.start();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


    }
    public void run(){
        switch (pilihmenu){
            case "1":
                SimpleThread simpleThread = new SimpleThread();
                simpleThread.printText(filename);
                break;
            case "2":
                int th=Integer.parseInt(thread);
                System.out.println("jumlah thread: "+th);
                ExecutorService executor = Executors.newFixedThreadPool(th);
                Runnable threadPool= new ThreadPool(filename);
                executor.execute(threadPool);
                executor.shutdown();
                while (!executor.isTerminated()) {
                }
                break;
            case "3":
                SimpleThread simpleThread2 = new SimpleThread();
                simpleThread2.printText(filename);
                AscSorting ascSorting = new AscSorting();
                ascSorting.sortAsc(filename);
                DescSorting sorting = new DescSorting();
                sorting.sortDsc(filename);
                break;
        }
    }
    public static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Print With Simple Thread");
        System.out.println("2. Print with Thread Pool");
        System.out.println("3. Print by Sorting");
        System.out.println("4. Exit");
        System.out.println("Masukan Menu: ");
    }
}