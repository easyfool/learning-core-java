package com.wangfengbabe.learning.boxing;

/**
 * Created by wangfeng on 11/09/2017.
 * Java program to illustrate various Integer methods
 */
public class IntegerTest {

  public static void main(String[] args) {
    int b = 55;
    String bb = "45";

    //construct two Integer objects
    Integer x = new Integer(b);
    Integer y = new Integer(bb);

    //toString
    System.out.println("toString(b) = " + Integer.toString(b));

    //toHexString(),toOctalString(),toBinaryString()
    //converts into hexadcimal,octal and binary forms
    System.out.println("toHexString(b) = " + Integer.toHexString(b));
    System.out.println("toOctalString(b) = " + Integer.toOctalString(b));
    System.out.println("toBinaryString(b) = " + Integer.toBinaryString(b));

    //valueOf():returns Integer object
    //an overloaded method takes radix as well
    Integer z = Integer.valueOf(b);
    System.out.println("valueOf(b) = " + z);
    z = Integer.valueOf(bb);
    System.out.println("valueOf(bb) = " + z);
    z = Integer.valueOf(bb, 6);
    System.out.println("valueOf(bb,6) = " + z);
  }

}
