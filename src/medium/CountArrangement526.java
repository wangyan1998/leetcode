package medium;
//假设有从 1 到 N 的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第 i位 (1 <= i <= N) 满足如下两个条件中的一个，
//        我们就称这个数组为一个优美的排列。条件：
//        (1).第i位的数字能被i整除
//        (2). i 能被第 i 位上的数字整除
//        现在给定一个整数 N，请问可以构造多少个优美的排列？


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/8/16 9:24
 */
public class CountArrangement526 {
    List<Integer>[] match;
    boolean[] vis;
    int num;

    /**
     * 回溯法
     * @param n
     * @return
     */
    public int countArrangement(int n){
       vis=new boolean[n+1];
       match=new List[n+1];
       for(int i=0;i<=n;i++){
           match[i]=new ArrayList<Integer>();
       }
       for(int i=1;i<=n;i++){
           for(int j=1;j<=n;j++){
               if(i%j==0||j%i==0){
                   match[i].add(j);
               }
           }
       }
       backtrack(1,n);
       return num;
    }
    public void backtrack(int index,int n){
        if(index==n+1){
            num++;
            return;
        }
        for(int x:match[index]){
            if(!vis[x]){
                vis[x]=true;
                backtrack(index+1,n);
                vis[x]=false;
            }
        }
    }

    public int countArrangement1(int n){
        int[] f=new int[1<<n];
        f[0]=1;
        for(int mask=1;mask<(1<<n);mask++){
            int num=Integer.bitCount(mask);
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0&&((num%(i+1))==0||(i+1)%num==0)){
                    f[mask]+=f[mask^(1<<i)];
                }
            }
        }
        return f[(1<<n)-1];
    }
}
