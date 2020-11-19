package day9.practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class exec {
//    public int insertsiswa(Siswa sw){
//        int hasil = 0;
//        String query="Insert into siswa value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            PreparedStatement pstm = conn.prepareStatement(query);
//            pstm.setString(1, sw.getNIS());
//            pstm.setString(2, sw.getNISN());
//            pstm.setString(3, sw.getNama());
//            pstm.setString(4, sw.getKelas());
//            pstm.setString(5, sw.getTahunmasuk());
//            pstm.setString(6, sw.getJeniskelamin());
//            pstm.setString(7, sw.getTmptlahir());
//            pstm.setDate(8, new java.sql.Date (sw.getTglLahir().getTime()));
//            pstm.setString(9, sw.getAlamat());
//            pstm.setString(10, sw.getNoHP());
//            pstm.setString(11, sw.getNamaAyah());
//            pstm.setString(12, sw.getNamaIbu());
//            pstm.setString(13, sw.getAgama());
//            pstm.setString(14, sw.getAsalsekolah());
//            pstm.setString(15, sw.getFoto());
//
//            pstm.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("TERJADI ERROR");
//            Logger.getLogger(ExecuteSiswa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return hasil;
//
//    }
//    public int updatesiswa(Siswa sw){
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        //java.sql.Date TanggalLahir= new java.sql.Date(sw.getTglLahir().getTime());
//        // System.out.println(TanggalLahir.getYear()+'-'+TanggalLahir.toString());
//
//        int hasil = 0;
//        String query ="update siswa SET NISN='"+sw.getNISN()+"',Nama='"+sw.getNama()+"',Kelas='"+sw.getKelas()+
//                "',Tahunmasuk='"+sw.getTahunmasuk()+"',Jeniskelamin='"+sw.getJeniskelamin()+
//                "',TempatLahir='"+sw.getTmptlahir()+"',TTL='"+sw.getTglLahir()+
//                "',Alamat='"+sw.getAlamat()+"',NoHp='"+sw.getNoHP()+
//                "',Namaayah='"+sw.getNamaAyah()+"',NamaIbu='"+sw.getNamaIbu()+"',Agama='"+sw.getAgama()+
//                "',Asalsekolah='"+sw.getAsalsekolah()+
//                "',Foto='"+sw.getFoto()+"'where NIS='"+sw.getNIS()+"'";
//        System.out.println(query);
//        try {
//            Statement stm = conn.createStatement();
//            hasil = stm.executeUpdate(query);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return hasil;
//    }
//    //delete data
//    public int deletesiswa(String sw){
//        int hasil = 0;
//        String query="delete from siswa where NIS='"+sw+"'";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            Statement stm = conn.createStatement();
//            hasil = stm.executeUpdate(query);
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return hasil;
//
//    }
//
//    public List<Siswa> getSiswa(){
//        List<Siswa> lists = new ArrayList<>();
//        String query = "Select * from siswa";
//        ConnectionManager conMan= new ConnectionManager();
//        Connection conn = conMan.Logon();
//
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while(rs.next()){
//                Siswa sw= new Siswa();
//                sw.setNIS(rs.getString("NIS"));
//                sw.setNISN(rs.getString("NISN"));
//                sw.setNama(rs.getString("Nama"));
//                sw.setKelas(rs.getString("Kelas"));
//                sw.setTahunmasuk(rs.getString("Tahunmasuk"));
//                sw.setJeniskelamin(rs.getString("Jeniskelamin"));
//                sw.setTmptlahir(rs.getString("TempatLahir"));
//                sw.setTglLahir(rs.getDate("TTL"));
//                sw.setAlamat(rs.getString("Alamat"));
//                sw.setNoHP(rs.getString("NoHp"));
//                sw.setNamaAyah(rs.getString("Namaayah"));
//                sw.setNamaIbu(rs.getString("NamaIbu"));
//                sw.setAgama(rs.getString("Agama"));
//                sw.setAsalsekolah(rs.getString("Asalsekolah"));
//
//                lists.add(sw);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteSiswa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return lists;
//    }
//
//    public List<Siswa> getSiswaNIS(String NIS){
//        List<Siswa> arrNIS = new ArrayList<>();
//        String query ="Select * from siswa where NIS like '"+NIS+"%'";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while(rs.next()){
//                Siswa sw = new Siswa();
//                sw.setNIS(rs.getString("NIS"));
//                sw.setNISN(rs.getString("NISN"));
//                sw.setNama(rs.getString("Nama"));
//                sw.setKelas(rs.getString("Kelas"));
//                sw.setTahunmasuk(rs.getString("Tahunmasuk"));
//                sw.setJeniskelamin(rs.getString("JenisKelamin"));
//                sw.setTmptlahir(rs.getString("TempatLahir"));
//                sw.setTglLahir(rs.getDate("TTL"));
//                sw.setAlamat(rs.getString("Alamat"));
//                sw.setNamaAyah(rs.getString("Namaayah"));
//                sw.setNamaIbu(rs.getString("NamaIbu"));
//                sw.setAgama(rs.getString("Agama"));
//                sw.setAsalsekolah(rs.getString("Asalsekolah"));
//                arrNIS.add(sw);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return arrNIS;
//    }
//    public List<Siswa> getSiswaNama(String Nama){
//        List<Siswa> arrNIS = new ArrayList<>();
//        String query ="Select * from siswa where Nama like '"+Nama+"%'";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while(rs.next()){
//                Siswa sw = new Siswa();
//                sw.setNIS(rs.getString("NIS"));
//                sw.setNISN(rs.getString("NISN"));
//                sw.setNama(rs.getString("Nama"));
//                sw.setKelas(rs.getString("Kelas"));
//                sw.setTahunmasuk(rs.getString("Tahunmasuk"));
//                sw.setJeniskelamin(rs.getString("JenisKelamin"));
//                sw.setTmptlahir(rs.getString("TempatLahir"));
//                sw.setTglLahir(rs.getDate("TTL"));
//                sw.setAlamat(rs.getString("Alamat"));
//                sw.setNamaAyah(rs.getString("Namaayah"));
//                sw.setNamaIbu(rs.getString("NamaIbu"));
//                sw.setAgama(rs.getString("Agama"));
//                sw.setAsalsekolah(rs.getString("Asalsekolah"));
//                arrNIS.add(sw);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return arrNIS;
//    }
//
//    public List<Siswa> getSiswaKelasN(String Kelas){
//        List<Siswa> arrkls = new ArrayList<>();
//        String query ="Select NIS,Nama from siswa where Kelas like '"+Kelas+"%'";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while(rs.next()){
//                Siswa sw = new Siswa();
//                sw.setNIS(rs.getString("NIS"));
//                sw.setNama(rs.getString("Nama"));
//                arrkls.add(sw);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteSiswa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return arrkls;
//    }
//    public List<Siswa> getSiswaKelas(String Kelas){
//        List<Siswa> arrNIS = new ArrayList<>();
//        String query ="Select * from siswa where Kelas like '"+Kelas+"%'";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while(rs.next()){
//                Siswa sw = new Siswa();
//                sw.setNIS(rs.getString("NIS"));
//                sw.setNISN(rs.getString("NISN"));
//                sw.setNama(rs.getString("Nama"));
//                sw.setKelas(rs.getString("Kelas"));
//                sw.setTahunmasuk(rs.getString("Tahunmasuk"));
//                sw.setJeniskelamin(rs.getString("JenisKelamin"));
//                sw.setTmptlahir(rs.getString("TempatLahir"));
//                sw.setTglLahir(rs.getDate("TTL"));
//                sw.setAlamat(rs.getString("Alamat"));
//                sw.setNamaAyah(rs.getString("Namaayah"));
//                sw.setNamaIbu(rs.getString("NamaIbu"));
//                sw.setAgama(rs.getString("Agama"));
//                sw.setAsalsekolah(rs.getString("Asalsekolah"));
//                arrNIS.add(sw);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return arrNIS;
//    }
//    public List<Siswa> getSiswathn(String Tahunmasuk){
//        List<Siswa> arrNIS = new ArrayList<>();
//        String query ="Select * from siswa where Tahunmasuk like '"+Tahunmasuk+"%'";
//        ConnectionManager conMan = new ConnectionManager();
//        Connection conn = conMan.Logon();
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while(rs.next()){
//                Siswa sw = new Siswa();
//                sw.setNIS(rs.getString("NIS"));
//                sw.setNISN(rs.getString("NISN"));
//                sw.setNama(rs.getString("Nama"));
//                sw.setKelas(rs.getString("Kelas"));
//                sw.setTahunmasuk(rs.getString("Tahunmasuk"));
//                sw.setJeniskelamin(rs.getString("JenisKelamin"));
//                sw.setTmptlahir(rs.getString("TempatLahir"));
//                sw.setTglLahir(rs.getDate("TTL"));
//                sw.setAlamat(rs.getString("Alamat"));
//                sw.setNamaAyah(rs.getString("Namaayah"));
//                sw.setNamaIbu(rs.getString("NamaIbu"));
//                sw.setAgama(rs.getString("Agama"));
//                sw.setAsalsekolah(rs.getString("Asalsekolah"));
//                arrNIS.add(sw);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ExecuteGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        conMan.Logoff();
//        return arrNIS;
//    }
}
