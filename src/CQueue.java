import java.util.Stack;

/**
 * @author banxuan
 * Date : 2020/6/30
 * Time : 11:30 上午
 */
class CQueue {

    private Stack<Integer> saveStack;

    private Stack<Integer> cacheStack;

    public CQueue() {
        saveStack = new Stack<>();
        cacheStack = new Stack<>();
    }

    public void appendTail(int value) {
        saveStack.add(value);
    }

    public int deleteHead() {
        int value = -1;
        if (saveStack.isEmpty()){
            return -1;
        }
       while (!saveStack.isEmpty()) {
            value = saveStack.pop();
            cacheStack.add(value);
        }
       cacheStack.pop();
        while (!cacheStack.isEmpty()) {
            saveStack.add(cacheStack.pop());
        }
        return value;
    }
}
