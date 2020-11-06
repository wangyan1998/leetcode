package simple;
//给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
//        如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
//        请你返回排序后的数组。


import java.util.*;

public class SortByBits {
    public int[] sortByBits(int[] arr){ //暴力法
       int[] bit=new int[10001];
        List<Integer> list=new ArrayList<Integer>();
        for(int x:arr){//所有值加入list，标记该值的二进制1的个数
            list.add(x);
            bit[x]=get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {//对list排序，排序函数比较二进制1的个数
            @Override
            public int compare(Integer x, Integer y) {
                if(bit[x]!=bit[y]){//二进制中1的个数不相等，按二进制1的个数排序
                    return bit[x]-bit[y];
                }else {//二进制中1的个数相等，按原数值大小排序
                    return x-y;
                }
            }
        });
        for(int i=0;i<arr.length;i++){//list值覆盖arr，返回arr
            arr[i]=list.get(i);
        }
        return arr;
    }

    public int get(int x){//统计二进制的1的个数
        int res=0;
        while(x!=0){
            res+=x%2;
            x/=2;
        }
        return res;
    }
}
