package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ilumer on 17-5-31.
 */
public class LeetCode205 {
  //要求对应位置的映射相同
  public boolean isIsomorphic(String s,String t){
    //将不存在map中的Key添加到map中，存在就获取key
    Map<Character,Character> map = new HashMap<>();
    for (int i = 0; i < s.length();){
      if (map.containsKey(s.charAt(i))){
        if (!map.get(s.charAt(i)).equals(t.charAt(i))){
          return false;
        }
        i++;
      }else {
        if (map.containsValue(t.charAt(i))){
          //判断对应的value是否已经被映射了
          return false;
        }else {
          map.put(s.charAt(i),t.charAt(i));
        }
        i++;
      }
    }
    return true;
  }

  //定义Unicode字符的数组
  public boolean isIsomorphic2(String s1,String s2){
    int[] m = new int[512];//256+256
    for (int i = 0; i < s1.length(); i++) {
      //将对应的char进行映射 如果出现不同的Key但是Vaue不同的时候会出现不等的情况
      //可以用两个数组(算是优化？)
      if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
      m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
    }
    return true;
  }

}
