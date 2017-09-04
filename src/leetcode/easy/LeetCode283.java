package leetcode.easy;

public class LeetCode283 {
  public void moveZeroes(int[] nums) {
    int right;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        right = i + 1;
        while (right < nums.length && nums[right] == 0) {
          right++;
        }
        if (right >= nums.length) {
          return;
        } else {
          nums[i] = nums[right];
          nums[right] = 0;
        }
      }
    }
  }

  //使用快慢指针
  // last用来记录0的位置
  // last = 0
  // for(int i = 0 ; i<nums.length; i++){
  //  if(nums[i]!=0){
  //    nums[last++] = nums[i]用来覆盖值不会出现重复
  //  }
  //}
}
