package day6;

public class Subclass extends Superclass {
   int id;
   Subclass(int age) {
      super(age);
    //   this.id = id;	
   }
   public static void main(String argd[]) {
      Subclass s = new Subclass(24);
      s.getAge();
   }
}