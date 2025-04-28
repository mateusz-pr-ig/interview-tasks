package com.infogain.interview.task0;

public class Streets {
  static String [] streets = {
            "1st Street",
            "2nd Street",
            "3rd Street",
            "4th Street"
  };
  
  public static String rideTo (int pos){
      try{
         return streets[pos] + "is";
      }
      catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
        System.out.print("not");
        return "";
      }finally {
          System.out.print(" in our neighborhood.");
      }
  }

  public static void main(String[] args) {
    //  System.out.println(rideTo(4));
  }
}

