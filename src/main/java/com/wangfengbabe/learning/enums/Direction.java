package com.wangfengbabe.learning.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangfeng on 13/09/2017.
 */
public enum Direction {
  EAST(0) {
    @Override
    public void shout() {
      System.out.println("Direction is East !");
    }
  }, WEST(180) {
    @Override
    public void shout() {
      System.out.println("Direction is West !");
    }
  }, NORTH(90) {
    @Override
    public void shout() {
      System.out.println("Direction is North !");
    }
  }, SOUTH(270) {
    @Override
    public void shout() {
      System.out.println("Direction is South !");
    }
  };
  private int angle;

  private Direction(int angle) {
    this.angle = angle;
  }

  public int getAngle() {
    return this.angle;
  }

  public abstract void shout();

  private static final Map<Integer, Direction> lookup = new HashMap<>();

  static {
    for (Direction direction : EnumSet.allOf(Direction.class)) {
      lookup.put(direction.getAngle(), direction);
    }

  }

  public static Direction get(int angle) {
    return lookup.get(angle);
  }

  public static void main(String[] args) {
    Set enumSet = EnumSet.of(Direction.EAST, Direction.WEST, Direction.SOUTH, Direction.NORTH);

    System.out.println(Direction.NORTH.getAngle());
    System.out.println(Direction.get(90));
  }

}
