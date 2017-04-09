import org.junit.Assert;

/**
 * Created by ilumer on 17-4-9.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 * 不是很懂这条题的剔除什么意思。。。。。
 */
public class RemoveDuplicates {

  //https://discuss.leetcode.com/topic/3102/my-solution-time-o-n-space-o-1/2
  static int removeDuplicates(int A[]) {
    if (A.length < 2) return A.length;
    int id = 1;
    for (int i = 1; i < A.length; ++i)
      if (A[i] != A[i - 1]) A[id++] = A[i];
    return id;
  }
}
