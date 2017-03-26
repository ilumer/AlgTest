import edu.princeton.cs.algs4.StdIn;
import java.util.Calendar;
import java.util.Stack;

/**
 * Created by ilumer on 17-3-26.
 *利用两个栈来实行算数表达式的求值
 * 使用了部分算法书中的API
 * （1+（（2+3）*（4*5）））
 */
public class Evaluate {
  public static void main(String[] args) {
    Stack<String> operator = new Stack<>();
    Stack<Double> number = new Stack<>();
    while (!StdIn.isEmpty()) {
      String character = StdIn.readString();
      switch (character){
        case "+":
        case "-":
        case "*":
        case "/":
          operator.push(character);
          break;
        case "(":{
          break;
        }
        case ")":{
          String op = operator.pop();
          Double second = number.pop();
          Double first = number.pop();
          switch (op){
            case "+":
              number.push(first+second);
              break;
            case "-":
              number.push(first - second);
              break;
            case "*":
              number.push(first*second);
              break;
            case "/":
              number.push(first/second);//排除0的情况
              break;
          }
          break;
        }
        default:
          number.push(Double.parseDouble(character));
      }
    }
    System.out.println(number.pop());
  }
}
