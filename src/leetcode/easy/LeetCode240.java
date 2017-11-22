package leetcode.easy;

public class LeetCode240 {
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length==0)
      return false;
    return searchMatrix(matrix,0,matrix[0].length-1,0,matrix.length-1,target);
  }

  private static boolean searchMatrix(int[][] matrix, int left, int right,int lo,int hi, int target) {
    if (left >=matrix[0].length || lo>=matrix.length)
      //数组越界
      return false;
    //用最大数和最小数来判断
    if (matrix[hi][right]<target || matrix[lo][left] > target)
      return false;
    if (matrix[hi][right] == target || matrix[lo][left] == target)
      return true;
    if (matrix[hi][right]>target && matrix[lo][left] <target)
      return searchMatrix(matrix,left,left+(right-left)/2,lo,lo+(hi-lo)/2,target) ||
          searchMatrix(matrix,left+(right-left)/2+1,right,lo,lo+(hi-lo)/2,target) ||
          searchMatrix(matrix,left,left+(right-left)/2,lo+(hi-lo)/2+1,hi,target) ||
          searchMatrix(matrix,left+(right-left)/2+1,right,lo+(hi-lo)/2+1,hi,target);
    else
      return false;
  }

  public static void main(String[] args) {
    int[][] matrix ={
        {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
    };
    int[][] a = {
        {-1,3}
    };
    System.out.println(searchMatrix(matrix,20));
    System.out.println(searchMatrix(a,-1));
  }
}
