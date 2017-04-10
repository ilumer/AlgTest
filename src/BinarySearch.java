import org.junit.Assert;

/**
 * Created by ilumer on 17-4-10.
 * https://www.zhihu.com/question/36132386/answer/155438728
 */
public class BinarySearch {

  public static int binarySearch(int[] a, int b) {
    int low = 0, high = a.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] < b) {
        low = mid + 1;
      }

      if (a[mid] > b) {
        high = mid - 1;
      }

      if (a[mid] == b) {
        return mid;
      }
    }
    return low;
  }

  public static int BinarySearchRecur(int[] nums, int target, int lo, int hi) {
    if (lo >= hi) {
      return lo;
    }
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] < target) {
      return BinarySearchRecur(nums, target, mid + 1, hi);
    } else {
      return BinarySearchRecur(nums, target, lo, mid - 1);
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals(9, binarySearch(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
    Assert.assertEquals(0, BinarySearchRecur(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 0, 9));
  }
}
