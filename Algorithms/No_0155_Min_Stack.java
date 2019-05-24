package 初级算法.设计问题;

import java.util.LinkedList;

/**
 * @ClassName: No_0155_Min_Stack
 * @Description:
 *
 * 0155. 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @Author: XieQing
 * @Date: 2018/11/6 18:41
 * @Version: 1.0
 */
public class No_0155_Min_Stack {
    class MinStack {
        int[] stack;
        int top;
        int[] min;
        int index;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new int[100005];
            top = 0;
            min = new int[100005];
            index = 1;
            min[0] = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack[top++] = x;
            if (x <= min[index - 1]) {
                min[index++] = x;
            }
        }

        public void pop() {
            if (stack[--top] != min[--index]) {
                index++;
            }
        }

        public int top() {
            return stack[top - 1];
        }

        public int getMin() {
            return min[index - 1];
        }
    }

    class MinStackB {

        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStackB() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek().intValue()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty() || minStack.isEmpty()) { return; }
            if (stack.peek().intValue() == minStack.peek().intValue()) { minStack.pop(); }
            stack.pop();

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
