package com.wangfengbabe.learning.filerelated;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangfeng on 01/09/2017.
 *
 * read file from resource folder
 */
public class FileReader {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

  public static void main(String[] args) {

    final String fileName = "file/hello.txt";
    ClassLoader classLoader = FileReader.class.getClassLoader();
    File file = null;
    try {
      file = new File(classLoader.getResource(fileName).getFile());
    } catch (NullPointerException e) {
      LOGGER.error(e.getMessage());
    }
    if (file == null) {
      return;
    }
    try {
      List<String> lines = FileUtils.readLines(file);
      System.out.println(lines);
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
      e.printStackTrace();
    }
  }


}
