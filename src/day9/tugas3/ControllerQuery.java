package day9.tugas3;

import day7.tugas2.Mahasiswa;

import java.sql.*;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerQuery {

    public int addData(Siswa siswa){
        int hasil=0;
        ConnectionManager connectionManager = new ConnectionManager();
        String query = "INSERT INTO tbl_siswa value(?,?,?,?,?,?,?)";
        Connection conn = connectionManager.Logon();

        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,null);
            pstm.setString(2,siswa.getFullName());
            pstm.setString(3,siswa.getAddress());
            pstm.setString(4,siswa.getStatus());
            pstm.setInt(5,siswa.getPhysics());
            pstm.setInt(6,siswa.getBiologi());
            pstm.setInt(7,siswa.getCalculus());
            pstm.executeUpdate();
            hasil=200;
        }catch (Exception e){
            hasil=400;
            System.out.println("Error Add Data: "+e);
        }
        connectionManager.Logoff();
        return hasil;
    }

    public int updateData(Siswa siswa){
        int hasil =0;
        ConnectionManager connectionManager = new ConnectionManager();
        String query ="update tbl_siswa SET fullName='"+siswa.getFullName()+"',address='"+siswa.getAddress()+
                "',status='"+siswa.getStatus()+"',physics='"+siswa.getPhysics()+
                "',calculus='"+siswa.getCalculus()+"',biologi='"+siswa.getBiologi()+
                "'where id='"+siswa.getId()+"'";
        Connection conn = connectionManager.Logon();

        try{
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil=200;
        }catch (Exception e){
            hasil=400;
            System.out.println("Error Update Data: "+e);
        }
        connectionManager.Logoff();
        return hasil;
    }

    public int deleteData(int id){
        int hasil = 0;
        String query="delete from tbl_siswa where id='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil = 200;
        } catch (SQLException ex) {
            System.out.println("Error Delete Data: "+ex);
            hasil=400;
        }
        conMan.Logoff();
        return hasil;
    }

    public void showData(){
        String query="SELECT * from tbl_siswa";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs =stm.executeQuery(query);
            String leftAlignFormat = "| %-11d | %-15s | %-11s | %-11s | %-11d | %-11d | %-11d |%n";
            System.out.format("+-------------+-----------------+-------------+-------------+-------------+-------------+-------------+%n");
            System.out.format("|     ID      |      NAMA       |   ADDRESS   |    STATUS   |    FISIKA   |   CALCULUS  |   BIOLOGI   |%n");
            System.out.format("+-------------+-----------------+-------------+-------------+-------------+-------------+-------------+%n");

            while(rs.next())
                System.out.format(leftAlignFormat, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7));
            System.out.format("+-------------+-----------------+-------------+-------------+-------------+-------------+-------------+%n");
        } catch (SQLException ex) {
            System.out.println("Error Delete Data: "+ex);
        }
        conMan.Logoff();
    }

}
