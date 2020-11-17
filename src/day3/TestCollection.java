import java.util.*;
class TestCollection{
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<String>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ajay");
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
// public class TestCollection{  
//  public static void main(String args[]){  
//   ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
//   list.add("Ravi");//Adding object in arraylist  
//   list.add("Vijay");  
//   list.add("Ravi");  
//   list.add("Ajay");  
//   //Traversing list through Iterator  
//   Iterator itr=list.iterator();  
//   while(itr.hasNext()){  
//    System.out.println(itr.next());  
//   }  
//  }  
// }  
