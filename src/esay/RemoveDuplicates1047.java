package esay;
//给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//        在 S 上反复执行重复项删除操作，直到无法继续删除。
//        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。


import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates1047 {
    /**
     * 采用栈弹出的方法
     * @param S
     * @return
     */
    public String removeDuplicates(String S){
           int n=S.length();
           Deque<Character> r=new ArrayDeque<Character>();
           r.push(S.charAt(0));
           for(int i=1;i<n;i++){
            if(r.isEmpty()){
                r.push(S.charAt(i));
            }else {
                if(r.peek()==S.charAt(i)){
                    r.pop();
                }else {
                    r.push(S.charAt(i));
                }
            }
          }
          String ret="";
          for(int i=r.size()-1;i>=0;i--){
              ret=r.peek()+ret;
              r.pop();
          }
          return ret;
    }

    /**
     * StringBuffer实现stack的功能
     * @param S
     * @return
     */
    public String removeDuplicates1(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    /**
     * 数组实现类似栈的功能
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }
}
