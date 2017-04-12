import org.junit.Assert;

/**
 * Created by ilumer on 17-4-12.
 */
public class PlusOne {
  public static int[] plusOne(int[] digits){
    int i = digits.length -1;
    int num = digits[i] +1 ;
    while (i>0 && num >= 10){
      digits[i] = num - 10;
      num = digits[--i] +1;
    }
    if (num >= 10){
      return copyAndresize(digits,num);
    }
    digits[i] = num;
    return digits;
  }

  public static int[] copyAndresize(int[] digits,int num){
    int[] resize = new int[digits.length +1];
    for (int i = digits.length-1; i>=0;i--){
      resize[i] = digits[i];
    }
    resize[0] = 1;
    resize[1] = num -10;
    return resize;
  }

  public static void main(String[] args) {
    Assert.assertArrayEquals(new int[]{1,3,6,0},plusOne(new int[]{1,3,5,9}));
    Assert.assertArrayEquals(new int[]{1,0,0,0,0},plusOne(new int[]{9,9,9,9}));
  }
}
