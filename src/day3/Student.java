public class Student{
    private String Id;
    private String Nama;
    private int Umur;

    public Student(String Id, String Nama, int Umur){
        this.Id=Id;
        this.Nama=Nama;
        this.Umur=Umur;
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
        public void setGender(int Umur) {
        this.Umur = Umur;
    }

    public int getUmur() {
        return Umur;
    }
}