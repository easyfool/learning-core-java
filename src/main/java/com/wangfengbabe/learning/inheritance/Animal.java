package com.wangfengbabe.learning.inheritance;

/**
 * Created by wangfeng on 11/09/2017.
 */
public class Animal {

  private String name;
  private int age;


  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Anmail{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
