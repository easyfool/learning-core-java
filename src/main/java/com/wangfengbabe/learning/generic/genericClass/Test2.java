package com.wangfengbabe.learning.generic.genericClass;

/**
 * Created by wangfeng on 12/09/2017.
 */
public class Test2<T, U> {

  T obj1;
  U obj2;

  public Test2(T obj1, U obj2) {
    this.obj1 = obj1;
    this.obj2 = obj2;
  }

  public void print() {
    System.out.println(obj1);
    System.out.println(obj2);
  }

  public static void main(String[] args) {
    Test2<String, Integer> obj = new Test2<String, Integer>("GFG", 15);
    obj.print();
  }
}
