package leetcode.easy;

/**
 * Created by ilumer on 17-5-8.
 */
public class LeetCode190 {
  //you need treat n as an unsigned value
  public int reverseBit(int n) {
    //将n转换成2进制数
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result += n & 1;
      //判断第i位上是否为1
      n >>>= 1;   // 必须进行无符号位移
      if (i < 31) {
        // 最后一次不需要进行位移
        result <<= 1;
        //旋转
      }

      //将n转化为32为无符号bits
      //需要旋转(从右边开始) i+k=32
    }
    return result;
  }
}
