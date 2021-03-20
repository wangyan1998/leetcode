package medium;
//根据 逆波兰表示法，求表达式的值。
//        有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//        说明：
//        整数除法只保留整数部分。
//        给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。


import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN150 {
    public int evalRPN(String[] tokens){
        Deque<Integer> stack=new ArrayDeque<Integer>();
        int n=tokens.length;
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+")){
                a=stack.peek();
                stack.pop();
                b=stack.peek();
                stack.pop();
                stack.push(a+b);
            }else if(tokens[i].equals("-")){
                a=stack.peek();
                stack.pop();
                b=stack.peek();
                stack.pop();
                stack.push(b-a);
            }else if(tokens[i].equals("*")){
                a=stack.peek();
                stack.pop();
                b=stack.peek();
                stack.pop();
                stack.push(a*b);
            }else if(tokens[i].equals("/")){
                a=stack.peek();
                stack.pop();
                b=stack.peek();
                stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
