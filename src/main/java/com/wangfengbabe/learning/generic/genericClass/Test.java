package com.wangfengbabe.learning.generic.genericClass;

/**
 * Created by wangfeng on 12/09/2017.
 */
public class Test<T> {

  T obj;

  Test(T obj) {
    this.obj = obj;
  }

  public T getObj() {
    return this.obj;
  }

  public static void main(String[] args) {
    Test<Integer> iObj = new Test<Integer>(15);
    System.out.println(iObj.getObj());

    Test<String> strObj = new Test<String>("hello world");
    System.out.println(strObj.getObj());
  }
}
