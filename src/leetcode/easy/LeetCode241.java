package leetcode.easy;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.List;

public class LeetCode241 {
  public static List<Integer> diffWaysToCompute(String input) {
    return diffWaysToCompute(input,0,input.length()-1);
  }

  public static List<Integer> diffWaysToCompute(String input,int start,int end){
    List<Integer> list = new ArrayList<>();
    for (int i = start;i<end;i++){
      List<Integer> list1;
      List<Integer> list2;
      if (input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
        list1 = diffWaysToCompute(input,start,i-1);
        list2 = diffWaysToCompute(input,i+1,end);
        for (Integer a:list1)
          for (Integer b:list2)
            if (input.charAt(i)=='+'){
              list.add(a+b);
            }else if (input.charAt(i)=='*'){
              list.add(a*b);
            }else {
              list.add(a-b);
            }
      }
    }
    if (list.size()==0)
      list.add(Integer.parseInt(input.subSequence(start,end+1).toString()));
    return list;
  }

  public static void main(String[] args) {
    String s ="2*3-4*5";
    for (int i :diffWaysToCompute(s)){
      System.out.println(i);
    }

    String i ="2-1-1";
    for (int m:diffWaysToCompute(i)){
      System.out.println(m);
    }

    String x ="11";
    for (int m:diffWaysToCompute(x)){
      System.out.println(m);
    }

  }
}
