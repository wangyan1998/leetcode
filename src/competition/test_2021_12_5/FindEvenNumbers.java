package competition.test_2021_12_5;
//给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
//        你需要找出所有满足下述条件且互不相同的整数：
//        (1)该整数由 digits 中的三个元素按任意顺序依次连接组成。
//        (2)该整数不含前导零
//        (3)该整数是一个偶数
//        例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
//        将找出的所有互不相同的整数按递增顺序排列，并以数组形式返回。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/12/5 10:32
 */
public class FindEvenNumbers {
    public static int[] findEvenNumbers(int[] digits) {
         Map<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<digits.length;i++){
             map.put(digits[i],map.getOrDefault(digits[i],0)+1);
         }
         ArrayList<Integer> res=new ArrayList<>();
         for(int j=120;j<1000;j++){
             if(j%2==0){
                 int[] flag=new int[3];
                 int[] a=new int[3];
                 int b=j;
                 a[0]=(b/100);
                 a[1]=(b%100)/10;
                 a[2]=b%10;
                 if(map.containsKey(a[0])&&map.containsKey(a[0])&&map.containsKey(a[0])){
                 }else {
                     continue;
                 }
                 if(map.get(a[0])>=1){
                     map.put(a[0],map.get(a[0])-1);
                     flag[0]=1;
                 }
                 if(map.get(a[1])>=1){
                     map.put(a[1],map.get(a[1])-1);
                     flag[1]=1;
                 }
                 if(map.get(a[2])>=1){
                     map.put(a[2],map.get(a[2])-1);
                     flag[2]=1;
                 }
                 if(flag[0]==1&&flag[1]==1&&flag[2]==1){
                     res.add(j);
                 }
                 for(int k=0;k<3;k++){
                     if(flag[k]==1){
                         map.put(a[k],map.getOrDefault(a[k],0)+1);
                     }
                 }
             }
         }
         int[] ans=new int[res.size()];
         for(int i=0;i<res.size();i++){
             ans[i]=res.get(i);
         }
         return ans;
    }

    public static void main(String[] args) {
        int[] digits={2,1,3,0};
        findEvenNumbers(digits);
    }
}
