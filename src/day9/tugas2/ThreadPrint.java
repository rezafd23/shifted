package day9.tugas2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;

public class ThreadPrint extends Thread {
    private String param;


    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void run(){
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonSiswa = (JSONObject) parser.parse(this.param);
            JSONArray elemSiswa = (JSONArray) jsonSiswa.get("Siswa");
            System.out.println("Data Siswa:");
            System.out.println("========================================");
            for (int i = 0; i < elemSiswa.size(); i++) {
                JSONObject elSiswa = (JSONObject) elemSiswa.get(i);
                System.out.println("Nama: " + elSiswa.get("Nama"));
                System.out.println("Biologi: " + elSiswa.get("Biologi"));
                System.out.println("Kimia: " + elSiswa.get("Kimia"));
                System.out.println("Fisika: " + elSiswa.get("Fisika"));
                System.out.println("========================================");
            }
        } catch (Exception e){
            System.out.println("Error thread print: "+e);
        }
    }

}
