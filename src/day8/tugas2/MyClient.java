package day8.tugas2;//package day8.tugas2;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Pattern;

public class MyClient {
    private static boolean loginStatus=false;
    private static ArrayList<Mahasiswa> dataMahasiswa=new ArrayList<>();
    private static ArrayList<String> dataTemp=new ArrayList<>();
    private static InputStream stream;
    private static Properties prop;
    private static Socket st;
    private static DataOutputStream dout;

    public static void main(String[] args) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
            try {
            while (!loginStatus){
                System.out.println("Silahkan Login");
                boolean us = false;
                boolean pass = false;
                String username = "";
                String password = "";
                try {
                    while (!us) {
                        System.out.println("Masukan Username: ");
                        username = br.readLine();
                        us = Pattern.matches("[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}", username);
                    }
                    while (!pass) {
                        System.out.println("Masukan Password: ");
                        password = br.readLine();
                        pass = Pattern.matches("(?=.*[A-Za-z])(?=.*[@#$%^&+=]).{8,}", password);
                    }

                    if (us & pass) {
                        if (username.equals("rezafd@gmail.com")&password.equals("Password#@")){
                            loginStatus=true;
                        } else {
                            loginStatus=false;
                        }
                    }
                } catch (Exception e){
                    System.out.println("Error: "+e);
                }
            }

                showMenu();
                String menu = "";
                try {
                    while (!menu.equals("4")) {
                        menu = br.readLine();
                        switch (menu) {
                            case "1":
                                System.out.println();
                                menu1(args[0]);
                                break;
                            case "2":
                                System.out.println();
                                menu2();
                                break;
                            case "3":
                                menu3();
                                break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    private static void menu1(String name){
        prop= new Properties();
        try {
            stream = day8.MyClient.class.getResourceAsStream(name);
            prop.load(stream);
            st = new Socket(prop.getProperty("IP"), Integer.parseInt(prop.getProperty("PORT")));
            dout = new DataOutputStream(st.getOutputStream());

            dout.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void menu2(){
        try {
            FileInputStream fin =new FileInputStream("data.txt");
            int i=0;
            System.out.print("Success: ");
            String a="";
            while ((i = fin.read()) != -1) {
                if ((char) i != ',') {
                    if((char)i!='\n'){
                        a=a+(char)i;
                    } else{
                        a="";
                    }
                } else {
                    dataTemp.add(a);
                    a="";
                }
            }
            System.out.println("leng: "+dataTemp.size());
            System.out.println("leng: "+dataTemp.get(5));
            for (String obj : dataTemp)
                System.out.println("["+obj+"]");
            fin.close();

            String msg="";
            for (String obj : dataTemp)
                msg=msg+","+obj;
            dout.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void menu3(){}
    public static void showMenu() {
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Connect Socket");
        System.out.println("2. Send Data to Server");
        System.out.println("3. Close Socket");
        System.out.println("4. Exit");
        System.out.println("Masukan Menu: ");
    }
}
