package main;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ArraysTest {

  @Test
  public void ShouldReverse() {
    Arrays arrays = new Arrays();
    int[] numArray = {4, 8, 15, 16, 23, 42};
    int[] reversedArray = {42, 23, 16, 15, 8, 4};
    Assert.assertArrayEquals(reversedArray, arrays.reverse(numArray));
  }

  @Test
  public void ShouldPush() {
    Arrays arrays = new Arrays();
    int[] numArray = {4, 8, 15, 16, 23, 42};
    int[] pushedArray = {4, 8, 15, 16, 23, 42, 10};
    Assert.assertArrayEquals(pushedArray, arrays.push(numArray, 10));
  }

}
