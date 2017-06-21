package leetcode.easy;

/**
 * Created by ilumer on 17-6-21.
 */
public class LeetCode263 {
  public boolean isUgly(int num) {
    if (num <= 0) {
      return false;
    }
    if (num == 1) {
      return true;
    }
    /*如何修改这部分代码
      while (num > 0 && (num%2 == 0 || num %3 == 0 || num%5==0)){
      if (num %2 == 0)
        num = num/2;
      if (num%3 == 0)
        num = num/3;
      if (num%5 == 0)
        num = num/5;
    }*/
    while (num % 2 == 0) num = num >>> 1;
    while (num % 3 == 0) num = num / 3;
    while (num % 5 == 0) num = num / 5;
    return num == 1;//并不是等于0
  }


  //https://discuss.leetcode.com/topic/21873/simple-java-solution-with-explanation
  //使用递归 将数字不断的缩小
}
