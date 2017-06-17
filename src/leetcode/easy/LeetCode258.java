package leetcode.easy;

public class LeetCode258 {
  public int addDigits(int num){
    while (num>=10){
      int x = num%10;
      num = num/10;
      num +=x;
    }
    return num;
    //return (num-1)%9+1;
    //num-1分开出来 0 和 9的情况
    //If an integer is like 100a+10b+c, then (100a+10b+c)%9=(a+99a+b+9b+c)%9=(a+b+c)%9
  }
}
