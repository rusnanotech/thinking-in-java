/****************** Exercise 15 *****************
 * Stacks are often used to evaluate expressions
 * in programming languages. Using
 * net.mindview.util.Stack, evaluate the following
 * expression, where '+' means "push the following
 * letter onto the stack," and '-' means "pop the
 * top of the stack and print it":
 * "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---"
 ***********************************************/
package biz.markov.thinking.holding;

import net.mindview.util.Stack;

public class Ex15_UsingStack {
    public static void main(String[] args) {
        String string = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
        Stack<Character> stack = new Stack<Character>();

        char[] c = string.toCharArray();
        for (int i = 0; i < c.length; i++)
            switch (c[i]) {
                case '+':
                    stack.push(c[++i]);
                    break;
                case '-':
                    System.out.print(stack.pop());
                    break;
                default:
                    break;
            }
    }
}
