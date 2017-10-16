package com.wangfengbabe.learning.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * Created by wangfeng on 01/09/2017. load class from file system
 */
public class FileClassLoader extends ClassLoader {


  private String filePath;

  public FileClassLoader(String filePath) {
    this.filePath = filePath;
  }

  public FileClassLoader(ClassLoader parent, String filePath) {

    super(parent);
    this.filePath = filePath;
  }

  public String getFilePath() {

    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public Class<?> findClass(String name) throws ClassNotFoundException {
    String fileName = getFileName(name);
    File file = new File(filePath, fileName);
    try {
      FileInputStream inputStream = new FileInputStream(file);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      int len = 0;
      while ((len = inputStream.read()) != -1) {
        outputStream.write(len);
      }
      byte[] data = outputStream.toByteArray();
      inputStream.close();
      outputStream.close();

    } catch (IOException e) {

    }

    return super.findClass(name);
  }


  private String getFileName(String className) {
    int index = className.lastIndexOf(".");
    if (index == -1) {
      return className + ".class";
    } else {
      return className.substring(index) + ".class";
    }

  }
}
