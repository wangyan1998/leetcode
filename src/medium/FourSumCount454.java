package medium;
//给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
//        为了使问题简单化，所有的 A, B, C, D 具有相同的长度N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1
//        之间，最终结果不会超过2^31 - 1 。
//        例如:
//        输入:
//        A = [ 1, 2]
//        B = [-2,-1]
//        C = [-1, 2]
//        D = [ 0, 2]
//        输出:
//        2

import java.util.HashMap;
import java.util.Map;

public class FourSumCount454 {
    /*
    分组+哈希，把数组分成两部分，AB为一组，CD为一组，对于AB使用二重循环遍历，得到A[i]+B[j]存入哈希映射
    哈希键值为A[i]+B[j],哈希值为该和出现次数。
    对于CD，同样使用二重循环遍历，遍历时判断-(C[k]+D[l])出现在哈希表中，将-(C[k]+D[l])累加进答案中
     */
    public int fourSumCount(int[] A,int[] B,int[] C,int[] D){
        Map<Integer,Integer> countAB=new HashMap<Integer, Integer>();
        for(int u:A){
            for(int v:B){
                countAB.put(u+v,countAB.getOrDefault(u+v,0)+1);
            }
        }
        int ans=0;
        for(int u:C){
            for(int v:D){
                if(countAB.containsKey(-u-v)){
                    ans+=countAB.get(-u-v);
                }
            }
        }
        return ans;
    }
}
