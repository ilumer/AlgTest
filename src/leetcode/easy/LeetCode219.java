package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilumer on 17-6-2.
 */
public class LeetCode219 {

  public boolean containsNearbyDuplicate(int[] nums,int k){
    HashMap<Integer,Integer> map = new HashMap<>();

    for (int i = 0;i<nums.length;i++){
      if (map.keySet().contains(nums[i])){
        if (i-map.get(nums[i])<=k){
          return true;
        }else {
          map.put(nums[i],i);
          //更新原来的value
        }
      }else {
        map.put(nums[i],i);
      }
    }
    return false;
  }


  //https://discuss.leetcode.com/topic/15305/simple-java-solution
  //只是使用了set数据结构
  //如果i>k set.remove(nums[i-k-1]);
  //保证了出现相等情况下的j-i<=k
  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++){
      if(i > k) set.remove(nums[i-k-1]);
      if(!set.add(nums[i])) return true;
    }
    return false;
  }
}
