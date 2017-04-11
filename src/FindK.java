import org.junit.Assert;

/**
 * Created by ilumer on 17-4-10.
 * https://leetcode.com/submissions/detail/99695825/
 */
public class FindK {

  /**
   *
   * @param nums
   * @param k 为第几个数 index = k -1;
   * @return
   */
  public static int select(int[] nums,int k){
    int lo = 0,hi = nums.length-1;
    while (lo < hi){
      int j = partition(nums,lo,hi);
      if (j == nums.length - k){
        return nums[j];
      }else if (j< nums.length - k){
        lo = j +1;
      }else if (j> nums.length - k){
        hi = j -1;
      }
    }
    return nums[lo];
  }

  private static int partition(int nums[],int lo,int hi) {
    int temp = nums[lo];
    int left = lo, right = hi+1;
    while (true){
      while (nums[++left] < temp){
        if (left == hi)
          break;
      }
      while (temp<nums[--right]){
        if (right==0){
          break;
        }
      }
      if (left>=right){
        break;
      }
      exch(nums,left,right);
      //可以停止循环
    }
    exch(nums,lo,right);
    return right;
  }

  private static void exch(int[] nums,int i,int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
