import java.util.*;
public class MainMahasiswa2{
      public static void main(String[] args){

        // mahasiswa mhs1=new mahasiswa("123","Reza","L");
        // mahasiswa mhs2=new mahasiswa("124","Reni F","P");

        // ArrayList<mahasiswa> arrMhs= new ArrayList<mahasiswa>();
        // arrMhs.add(mhs1);
        // arrMhs.add(mhs2);
        // Iterator itr = arrMhs.iterator();
        // while(itr.hasNext()){
        //     mahasiswa mh = (mahasiswa) itr.next();
        //     System.out.println("Nama: "+mh.getNama()+", Id: "+mh.getId()+", Gender: "+mh.getGender());
        // }
        int[] a = {3, 7, 10, 15, 91, 110, 150}; // a sorted array not containing duplicates
int target = 91; // the element to be searched
int left = 0;
int middle;
int right = a.length - 1;
while (left <= right) {
    middle = (left + right) / 2;
    if (a[middle] == target) {
        System.out.println("Element found at index " + middle);
        break;
    } else if (a[middle] < target) {
        left = middle + 1;
    } else if (a[middle] > target) {
        right = middle - 1;
    }
}
    }
}

// Student s1 = new Student(101, "Sonoo", 23);
//         Student s2 = new Student(102, "Ravi", 21);
//         Student s3 = new Student(103, "Hanumat", 25);
//         //creating arraylist  
//         ArrayList<Student> al = new ArrayList<Student>();
//         al.add(s1);//adding Student class object  
//         al.add(s2);
//         al.add(s3);
//         //Getting Iterator 
//         Iterator itr = al.iterator();
//         //traversing elements of ArrayList object  
//         while (itr.hasNext()) {
//             Student st = (Student) itr.next();
//             System.out.println(st.rollno + " " + st.name + " " + st.age);
//         }
//     }