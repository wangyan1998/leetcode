package competition.test_2021_11_21;
//请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
//        子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
//        请你实现 RangeFreqQuery 类：
//        RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
//        int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
//        一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/11/21 10:54
 */
public class RangeFreqQuery {
    List<List<Integer>> all=new ArrayList<>();
    public RangeFreqQuery(int[] arr) {
       for(int i=0;i<=10000;i++){
           all.add(new ArrayList<>());
       }
       for(int i=0;i<arr.length;i++){
           all.get(arr[i]).add(i);
       }
    }

    public int query(int left, int right, int value) {
        if(all.get(value).size()==0)return 0;
        List<Integer> now=all.get(value);
        //第一次二分找左端点下标
        int l=0,r=now.size()-1;
        while(l<r){
            int mid=(r-l)/2+l;
            if(now.get(mid)<left){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        int a=l;
        //不存在这样的点
        if(now.get(a)>right||now.get(a)<left)return 0;
        //第二次二分，找右端点的下标
        l=a;
        r=now.size()-1;
        while(l<r){
            int mid=(r-l)/2+l;
            if(now.get(mid)<right){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        int b=l;
        if(now.get(b)>right){
            b--;
        }
        return b-a+1;
    }
}
