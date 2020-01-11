package sinyj0622.mytrip.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  Scanner input;
  
  public Prompt(Scanner input) {
    this.input = input;
  }
  
  public String inputString(String label) {
    System.out.print(label);
    return input.nextLine();
  }
  
  public String inputString(String label, String defaultValue) {
    System.out.println(label);
    String value = input.nextLine();
    if (value.length() == 0) {
      return defaultValue;
    }
    return value;
  }
  
  public int inputInt(String label) {
    System.out.println(label);
    return Integer.parseInt(input.nextLine());
  }
  
  public int inputInt(String label, int dafaultValue) {
    System.out.println(label);
    String value = input.nextLine();
    if (value.length() == 0) {
      return dafaultValue;
    }
    return Integer.parseInt(value); 
  }
  
  public Date inputDate(String label) {
    System.out.println(label);
    return Date.valueOf(input.nextLine());
  }
  
  public Date inputDate(String label, Date defaultValue) {
    System.out.println(label);
    String value = input.nextLine();
    if (value.length() == 0) {
      return defaultValue;
    }
    return Date.valueOf(value);
  }
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}