package medium;
//给你一个整数数组 arr 。
//        现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
//        a 和 b 定义如下：
//        a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
//        b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
//        注意：^ 表示 按位异或 操作。
//        请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。


import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/5/18 8:57
 */
public class CountTriplets1442 {
    /**
     * 异或操作的前缀和问题
     * S[i]定义为长度为n的数组arr的末尾元素为arr[i-1]的前缀和
     * 当i=0时，S[0]=0;当0<=i<=n时，S[i]=S[i-1]^arr[i-1];
     * 所以S[i]=arr[0]^arr[1]^......arr[i-1];
     * S[j]=arr[0]^arr[1]^......arr[j-1];
     * S[i]^S[j]=arr[i]^arr[i+1]^......arr[j-1];
     * 所以arr[i,j]的元素异或可以表示为S[i]^S[j+1]
     * 所以a=S[i]^S[j],b=S[j]^S[k+1];
     * 如果a=b,则有：S[i]^S[j]=S[j]^S[k+1],即S[i]=S[k+1]
     *
     * 三重循环
     * @param arr
     * @return
     */
    public static int countTriplets(int[] arr){
      int n=arr.length;
      int[] s=new int[n+1];
      for(int i=0;i<n;i++){
          s[i+1]=s[i]^arr[i];
      }
      int ans=0;
      for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
              for(int k=j;k<n;k++){
                  if(s[i]==s[k+1]){
                      ans++;
                  }
              }
          }
      }
      return ans;
    }

    /**
     * 当等式S[i]=S[k+1]成立时，[i+1,k]的范围内的任意j都是符合要求的，对用的三元组个数为k-i,因此只需要两层循环就够了
     * @param arr
     * @return
     */
    public int countTriplets1(int[] arr){
        int n=arr.length;
        int[] s=new int[n+1];
        for(int i=0;i<n;i++){
            s[i+1]=s[i]^arr[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int k=i+1;k<n;k++){
                if(s[i]==s[k+1]){
                    ans+=k-i;
                }
            }
        }
        return ans;
    }

    /**
     * 对于下标k，若下标i=i1,i2....im时均满足s[i]=s[k+1],则这些二元组(i1,k),(i2,k)......(im,k)对答案的贡献是：
     *       (k-i1)+(k-i2)+.....+(k-im)=m*k-(i1+i2+......+im);
     *       也就是说，当遍历下标k时，我们只需要知道所有满足s[i]=s[k+1]的
     *       (1)下标i出现的次数m
     *       (2)下标i之和
     *       这可以借助两个哈希表来实现，在遍历下标k的同时，一个哈希表统计s[k]的出现次数，另一个哈希表统计值为s[k]的下标之和。
     * @param arr
     * @return
     */
    public int countTriplets2(int[] arr){
        int n=arr.length;
        int[] s=new int[n+1];
        for(int i=0;i<n;i++){
            s[i+1]=s[i]^arr[i];
        }
        Map<Integer,Integer> cnt=new HashMap<Integer, Integer>();
        Map<Integer,Integer> total=new HashMap<Integer, Integer>();
        int ans=0;
        for(int k=0;k<n;k++){
            if(cnt.containsKey(s[k+1])){
                ans+=cnt.get(s[k+1])*k-total.get(s[k+1]);
            }
            cnt.put(s[k],cnt.getOrDefault(s[k],0)+1);
            total.put(s[k],total.getOrDefault(s[k],0)+k);
        }
        return ans;
    }
}
