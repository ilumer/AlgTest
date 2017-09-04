package leetcode.easy;

public class LeetCode278 {
  public int firstBadVersion(int n) {
    int low = 1, high = n;
    int mid;
    //判断搜索空间为0的时 low就是第一个坏的版本
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (isBadVersion(mid)) {
        if (!isBadVersion(mid - 1)) {
          return mid;
        } else {
          high = mid - 1;
        }
      } else if (!isBadVersion(mid)) {
        low = mid + 1;
      }
    }
    return low;
  }

  //检查是否是有问题的版本
  private boolean isBadVersion(int l) {
    return true;
  }
}
