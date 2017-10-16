package com.wangfengbabe.learning.classloader;

public class Client {

  public static void main(String[] args) {
    //null, bootstrap classloader, which is written by C++.it is not a java class
    System.out.println(Integer.class.getClassLoader());

    //return an AppClassloader/SystemClassLoader
    System.out.println(Client.class.getClassLoader());

    //return an ExtClassLoader
    System.out.println(Client.class.getClassLoader().getParent());

    //return an AppClassloader/SystemClassLoader
    System.out.println(ClassLoader.getSystemClassLoader().toString());



  }

}
