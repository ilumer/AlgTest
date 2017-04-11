import org.junit.Assert;

/**
 * Created by ilumer on 17-4-11.
 * https://leetcode.com/problems/search-insert-position/#/description
 * 找到target
 */
public class SearchInsertPosition {

  public static int searchInsert(int[] nums,int target){
    for (int i = 0;i< nums.length;i++){
      if (nums[i]>=target)
        return i;
    }
    return nums.length;
  }

  public static int BinarySearch(int[] nums,int target){
    int lo = 0,hi = nums.length-1;
    while (lo <= hi){
      int mid = lo + ( hi - lo)/2;
      if (nums[mid] == target){
        return mid;
      }
      if (nums[mid] > target){
        hi = mid - 1;
      }
      if (nums[mid] < target){
        lo = mid +1 ;
      }
    }
    return lo;
  }

  public static void main(String[] args) {
    Assert.assertEquals(2,BinarySearch(new int[]{1,3,5,6},5));
    Assert.assertEquals(1,BinarySearch(new int[]{1,3,5,6},2));
    Assert.assertEquals(4,BinarySearch(new int[]{1,3,5,6},7));
    Assert.assertEquals(0,BinarySearch(new int[]{1,3,5,6},0));
  }
}
