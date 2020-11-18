package medium;

import java.util.Arrays;

//在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
//        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，
//        开始时油箱为空。
//        如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//        说明:
//        如果题目有解，该答案即为唯一答案。
//        输入数组均为非空数组，且长度相同。
//        输入数组中的元素均为非负数。
public class CanCompleteCircuit134 {
    public int canCompleteCircuit(int[] gas,int[] cost){
       int sum=0;
       int n=gas.length;
       int[] res=new int[n];
       for(int i=0;i<n;i++){
           res[i]=gas[i]-cost[i];
           sum+=res[i];
       }
       if(sum<0){
           return -1;
       }else{
           int j=0;
          for(;j<n;j++){
              if(getsum(res,j)==0){
                  break;
              }
          }
          return j;
       }
    }
    public int getsum(int[] num,int i){//判断是否能从i位置走到起点，能走到返回0，走不到返回-1
        int sum=0,j=0,ret=0;
        int n=num.length;
        while(j<n&&i<n){
            sum+=num[i];
            if(sum<0){
                ret=-1;
                break;
            }else {
                if(i!=n-1){
                    i++;
                    j++;
                }else {
                    i=0;
                    j++;
                }
            }
        }
        return ret;
    }
    public int canCompleteCircuit1(int[] gas,int[] cost){
        int n=gas.length;
        int i=0;
        while(i<n){
            int sumOfGas=0,sumOfCost=0;
            int cnt=0;
            while(cnt<n){
                int j=(i+cnt)%n;
                sumOfGas+=gas[j];
                sumOfCost+=cost[j];
                if(sumOfCost>sumOfGas){
                    break;
                }
                cnt++;
            }
            if(cnt==n){
                return i;
            }else {
                i=i+cnt+1;
            }
        }
        return -1;
    }
}
