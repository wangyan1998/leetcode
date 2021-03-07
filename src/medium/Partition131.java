package medium;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition131 {
    boolean[][] f;
    List<List<String>> ret=new ArrayList<List<String>>();
    List<String> ans=new ArrayList<String>();
    int n;

    /**
     * 回溯+动态规划预处理
     * 动态规划预处理指的是提前判断S的子串是否是回文字符串，然后通过回溯，首先一层一层的划分
     * 当划分完整个字符串的时候，如果能够划分完毕，添加到结果List中。
     * 然后弹出当前情况进行回溯。
     * @param s
     * @return
     */
    public List<List<String>> partition(String s){
       n=s.length();
       f=new boolean[n][n];
       for(int i=0;i<n;++i){
           Arrays.fill(f[i],true);
       }
       for(int i=n-1;i>=0;--i){
           for(int j=i+1;j<n;++j){
               f[i][j]=(s.charAt(i)==s.charAt(j))&&f[i+1][j-1];
           }
       }
       dfs(s,0);
       return ret;
    }
    public void dfs(String s,int i){
        if(i==n){
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for(int j=i;j<n;++j){
            if(f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}
