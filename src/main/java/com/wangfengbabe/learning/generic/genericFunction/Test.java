package com.wangfengbabe.learning.generic.genericFunction;

/**
 * Created by wangfeng on 12/09/2017.
 */
public class Test {

  static <T> void genericDisplay(T element) {
    System.out.println(element.getClass().getName() + " = " + element);
  }

  public static void main(String[] args) {
    genericDisplay(11);
    genericDisplay("hello world");
    genericDisplay(1.5D);
  }


}
