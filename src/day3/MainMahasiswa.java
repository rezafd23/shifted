public class MainMahasiswa{
      public static void main(String[] args){

        mahasiswa[] mhs = new mahasiswa[2];
        mhs[0]=new mahasiswa("123","Reza","L");
        mhs[1]=new mahasiswa("124","Reza F","L");
        int lengArr=mhs.length;

        for (int i=0;i<lengArr;i++){
          System.out.println("Id: "+mhs[i].getId()+" Nama: "+mhs[i].getNama()+" Gender: "+mhs[i].getGender());
        }
    }
}