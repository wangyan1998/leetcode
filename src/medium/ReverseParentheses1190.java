package medium;
//给出一个字符串s（仅含有小写英文字母和括号）。
//        请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
//        注意，您的结果中 不应 包含任何括号。


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wy
 * @date 2021/5/26 9:05
 */
public class ReverseParentheses1190 {
    /**
     * 使用栈来解决，每次匹配到括号就进行翻转
     * @param s
     * @return
     */
    public String reverseParentheses(String s){
        Deque<Character> stack=new ArrayDeque<Character>();
        Deque<Character> s1=new ArrayDeque<Character>();
        Deque<Character> s2=new ArrayDeque<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
            stack.push(s.charAt(i));
            }else {
                while(stack.peek()!='('){
                    s1.push(stack.pop());
                }
                stack.pop();
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                while(!s2.isEmpty()){
                    stack.push(s2.pop());
                }
            }
        }
        StringBuffer res=new StringBuffer();
        while(!stack.isEmpty()){
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    public String reverseParentheses1(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * 括号预处理
     * @param s
     * @return
     */
    public String reverseParentheses2(String s){
        int n=s.length();
        int[] pair=new int[n];
        Deque<Integer> stack=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                int j=stack.pop();
                pair[i]=j;
                pair[j]=i;
            }
        }
        StringBuffer sb=new StringBuffer();
        int index=0,step=1;
        while(index<n){
            if(s.charAt(index)=='('||s.charAt(index)==')'){
                index=pair[index];
                step=-step;
            }else {
                sb.append(s.charAt(index));
            }
            index+=step;
        }
        return sb.toString();
    }
}
