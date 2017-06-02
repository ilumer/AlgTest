package leetcode.easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ilumer on 17-6-2.
 */
public class LeetCode217 {
  public boolean containsDuplicate(int[] nums){
    Set<Integer> set = new HashSet<>();
    for (int i:nums){
      if (set.contains(i)){
        return true;
      }else {
        set.add(i);
      }
    }
    return false;
  }
}
