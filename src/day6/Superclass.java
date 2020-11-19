package day6;

class Superclass {
   int age; //Protected
   Superclass(int age) {
      this.age = age; 		 
   }
   public void getAge() {
      System.out.println("The value of the variable named age in super class is: " +age);
   }
}