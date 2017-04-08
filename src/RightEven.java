/**
 * Created by ilumer on 17-4-9.
 * 将奇数放在左边偶数放到右边
 */
public class RightEven {
  public static void solution(int[] array) {
    int right = array.length - 1;
    int left = 0;
    while (left < right) {
      if (array[left] % 2 == 0 && array[right] % 2 != 0) {
        exch(array, left++, right--);
      } else {
        if (array[left] % 2 != 0) {
          left++;
        }
        if (array[right] % 2 == 0) {
          right--;
        }
      }
    }
  }

  public static void exch(int[] array, int i, int j) {
    array[i] = array[i] ^ array[j];
    array[j] = array[i] ^ array[j];
    array[i] = array[i] ^ array[j];
  }

  public static void main(String[] args) {
    int[] array1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] array2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    solution(array1);
    solution(array2);
    for (int i : array1) {
      System.out.print(i);
    }
    System.out.println();
    for (int i : array2) {
      System.out.print(i);
    }
  }
}
