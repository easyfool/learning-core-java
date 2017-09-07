package com.wangfengbabe.learning.myjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangfeng on 13/08/2017.
 */
public class LogbackApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogbackApp.class);

  public static void main(String[] args) {
    LOGGER.debug("test logback");

  }

}
