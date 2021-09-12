package medium;
//给定一个只包含三种字符的字符串：（,）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
//        1.任何左括号 (必须有相应的右括号 )。
//        2.任何右括号 )必须有相应的左括号 (。
//        3.左括号 ( 必须在对应的右括号之前 )。
//        4.*可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
//        5.一个空字符串也被视为有效字符串。

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wy
 * @date 2021/9/12 9:44
 */
public class checkValidString678 {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public boolean checkValidString(String s){
       int n=s.length();
       boolean[][] dp=new boolean[n][n];
       for(int i=0;i<n;i++){
           if(s.charAt(i)=='*'){
               dp[i][i]=true;
           }
       }
       for(int i=1;i<n;i++){
           char c1=s.charAt(i-1),c2=s.charAt(i);
           dp[i-1][i]=(c1=='('||c1=='*')&&(c2==')'||c2=='*');
       }
       for(int i=n-3;i>=0;i--){
           char c1=s.charAt(i);
           for(int j=i+2;j<n;j++){
               char c2=s.charAt(j);
               if((c1=='('||c1=='*')&&(c2==')'||c2=='*')){
                   dp[i][j]=dp[i+1][j-1];
               }
               for(int k=i;k<j&&!dp[i][j];k++){
                   dp[i][j]=dp[i][k]&&dp[k+1][j];
               }
           }
       }
       return dp[0][n-1];
    }

    /**
     * 栈实现
     * @param s
     * @return
     */
    public boolean checkValidString1(String s){
         Deque<Integer> leftStack=new LinkedList<Integer>();
        Deque<Integer> asteriskStack=new LinkedList<Integer>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                leftStack.push(i);
            }else if(c=='*'){
                asteriskStack.push(i);
            }else {
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else if(!asteriskStack.isEmpty()){
                    asteriskStack.pop();
                }else {
                    return false;
                }
            }
        }
        while(!leftStack.isEmpty()&&!asteriskStack.isEmpty()){
            int leftIndex=leftStack.pop();
            int asteriskIndex=asteriskStack.pop();
            if(leftIndex>asteriskIndex){
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
