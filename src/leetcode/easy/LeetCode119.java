package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilumer on 17-4-23.
 * https://leetcode.com/problems/pascals-triangle-ii/#/solutions
 */
public class LeetCode119 {
  public List<Integer> getRow(int rowIndex){
    Integer[] array = new Integer[]{1};
    for (int i = 1;i<=rowIndex;i++){
      array = generate(array,i);
    }
    return Arrays.asList(array);
  }

  private Integer[] generate(Integer[] array, int i) {
    Integer[] temp = new Integer[i+1];
    for (int j = 0; j <=i;j++){
      if (j==0||j==i){
        temp[j] = 1;
      }else {
        temp[j] = array[j] + array[j - 1];
      }
    }
    return temp;
  }

  //https://discuss.leetcode.com/topic/16110/my-8-lines-java-solution-use-arraylist
  //通过list更新list
  public static List<Integer> getRows(int rowIndex){
    List<Integer> res = new ArrayList<>();
    for(int i = 0;i<rowIndex+1;i++) {
      //保证了数据量和起点和终点为1
      res.add(1);
      for(int j=i-1;j>0;j--) {
        res.set(j, res.get(j-1)+res.get(j));
      }
    }
    return res;
  }

  public static void main(String[] args) {
    getRows(4);
  }
}
