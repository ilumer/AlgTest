import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-4-7.
 */
public class ValidParentheses {

  //我一开始没有想起来栈这个数据结构
  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    //用数组实现可能更快
    for (char c : s.toCharArray()) {
      if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '(') {
        stack.push(')');
      } else if (stack.isEmpty() || stack.pop() != c)//当出现{} [] ()这个时候才会有完整性
      {
        return false;
      }
    }
    return stack.isEmpty();
  }

  @Test
  public static void main(String[] args) {
    Assert.assertTrue(isValid("[]"));
    Assert.assertFalse(isValid("["));
    Assert.assertTrue(isValid("()[]{}"));
    Assert.assertFalse(isValid("([)]"));
    Assert.assertTrue(isValid("(([]){})"));
  }
}
