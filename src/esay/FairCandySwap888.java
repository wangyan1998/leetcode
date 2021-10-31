package esay;
//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，
//        B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
//        因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。
//        （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//        返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，
//        ans[1]是 Bob 必须交换的糖果棒的大小。
//        如果有多个答案，你可以返回其中任何一个。保证答案存在。

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap888 {
    /**
     * 暴力求解
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A,int[] B){
      int[] ans=new int[2];
      int sum1=0,sum2=0;
      for(int i=0;i<A.length;i++){
          sum1+=A[i];
      }
      for(int i=0;i<B.length;i++){
          sum2+=B[i];
      }
      for(int i=0;i<A.length;i++){
          for(int j=0;j<B.length;j++){
              if(sum1-A[i]+B[j]==sum2-B[j]+A[i]){
                  ans[0]=A[i];
                  ans[1]=B[j];
                  break;
              }
          }
      }
      return ans;
    }

    /**
     * 利用求差运算把双层循环转换成单层循环
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap1(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();//存储A中的数的类别
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
