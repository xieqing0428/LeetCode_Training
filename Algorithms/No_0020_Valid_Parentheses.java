package 初级算法.其他;

import java.util.Stack;

/**
 * @ClassName: No_0020_Valid_Parentheses
 * @Description:
 *
 * 0020. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author: XieQing
 * @Date: 2018/11/6 22:50
 * @Version: 1.0
 */
public class No_0020_Valid_Parentheses {
    class SolutionA {
        public boolean isValid(String s) {
            int len = s.length();
            if (s == null || len == 0) {
                return true;
            }
            if (len % 2 != 0) {
                return false;
            }
            char[] _s = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                char letter = _s[i];
                if (stack.isEmpty() || !isValidSign(stack.peek(), letter)) {
                    stack.push(letter);
                } else {
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }

        public boolean isValidSign(char a, char b) {
            switch (a) {
                case '(': if (b == ')') { return true; } else { return false; }
                case '{': if (b == '}') { return true; } else { return false; }
                case '[': if (b == ']') { return true; } else { return false; }
                default: return false;
            }
        }
    }

    class SolutionB {
        public boolean isValid(String s) {
            char[] chs = s.toCharArray();
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(':
                    case '[':
                    case '{': chs[cur++] = c;
                        break;

                    case ')': if (cur == 0) { return false; }
                        char c1 = chs[--cur];
                        if (c1 != '(') { return false; }
                        break;
                    case ']': if (cur == 0) { return false; }
                        char c2 = chs[--cur];
                        if (c2 != '[') { return false; }
                        break;
                    case '}': if (cur == 0) { return false; }
                        char c3 = chs[--cur];
                        if (c3 != '{') { return false; }
                        break;
                }
            }
            if (cur != 0) {
                return false;
            }
            return true;
        }
    }
}
