package com.wangfengbabe.learning.classloader;

import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FileClassLoaderTest {

  private FileClassLoader fileClassLoader;

  @Test
  public void findClass() throws Exception {
    String className = "com.wangfengbabe.learning.classloader.HelloWorld";
    fileClassLoader = new FileClassLoader("/Users/wangfeng/Documents/keepme");
    Class clazz = fileClassLoader.loadClass(className);
    assertThat(clazz, CoreMatchers.notNullValue());
    Method method = clazz.getDeclaredMethod("say", String.class);
    Object obj = clazz.newInstance();
    method.invoke(obj, "world");

  }

}
