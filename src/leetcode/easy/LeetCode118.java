package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilumer on 17-4-23.
 * https://leetcode.com/problems/pascals-triangle/#/description
 */
public class LeetCode118 {
  List<List<Integer>> triangle = new ArrayList<>();
  public List<List<Integer>> generate(int numRows){
    if (numRows == 0){
      return null;
    }
    Integer[] array = new Integer[]{1};
    triangle.add(Arrays.asList(array));
    for (int i = 2; i<=numRows;i++) {
      array = generate(array, i);
      triangle.add(Arrays.asList(array));
    }
    return triangle;
  }

  private Integer[] generate(Integer[] array, int i) {
    Integer[] copyArray = new Integer[i];//构建大一号的数组
    copyArray[0] =1;
    for (int j=1;j<i-1;j++){
      copyArray[j] = array[j]+array[j-1];
    }
    copyArray[copyArray.length-1] = 1;
    return copyArray;
  }

  //TODO:动态规划
}
