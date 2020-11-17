package day4;

public class Mahasiswa{
    private String Id;
    private String Nama;
    private String Gender;

    public Mahasiswa(String Id, String Nama, String Gender){
        this.Id=Id;
        this.Nama=Nama;
        this.Gender=Gender;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getId() {
        return Id;
    }
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getNama() {
        return Nama;
    }
        public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getGender() {
        return Gender;
    }

}