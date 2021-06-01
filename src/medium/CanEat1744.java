package medium;
//给你一个下标从 0 开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。
//        同时给你一个二维数组queries，其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
//        你按照如下规则进行一场游戏：
//        你从第0天开始吃糖果。
//        你在吃完所有第 i - 1类糖果之前，不能吃任何一颗第 i类糖果。
//        在吃完所有糖果之前，你必须每天 至少吃 一颗糖果。
//        请你构建一个布尔型数组answer，满足answer.length == queries.length 。answer[i]为true的条件是：
//        在每天吃 不超过 dailyCapi颗糖果的前提下，你可以在第favoriteDayi天吃到第favoriteTypei类糖果；
//        否则 answer[i]为 false。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
//        请你返回得到的数组answer


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wy
 * @date 2021/6/1 9:33
 */
public class CanEat1744 {
    /**
     * 前缀和，吃的糖果数量应该落在[favoriteDay+1,(favorite+1)*dailyCap]之间
     * 所以只要这个区间包含一颗favoriteType类型糖果就可以了
     * favoriteType类型的糖果的范围是[sum[favoriteType-1]+1,sum[favoriteType]]
     * 特别的，如果favoriteType为0，那么区间左端点是1
     * 只要判断这两个区间是否有交集就好了
     * @param candiesCount
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount,int[][] queries){
        long[] sum=new long[candiesCount.length];
        sum[0]=candiesCount[0];
        for(int i=1;i<candiesCount.length;i++){
            sum[i]=sum[i-1]+candiesCount[i];
        }
       boolean[] res=new boolean[queries.length];
        Arrays.fill(res,false);
       for(int i=0;i<queries.length;i++){
           int[] query=queries[i];
           int favoriteType=query[0],favoriteDay=query[1],dailyCap=query[2];
           long x1=favoriteDay+1;//最少吃的糖果数
           long y1=(long)(favoriteDay+1)*dailyCap;//最多吃的糖果数
           long x2=favoriteType==0?1:sum[favoriteType-1]+1;//最爱类型糖果之前不包括最爱类型有多少糖果
           long y2=sum[favoriteType];//最爱类型前包括最爱类型有多少糖果
           res[i]=!(x1>y2||y1<x2);
       }
       return res;
    }
}
