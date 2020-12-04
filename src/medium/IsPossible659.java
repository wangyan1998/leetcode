package medium;
//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，
//        其中每个子序列都由连续整数组成且长度至少为 3 。
//        如果可以完成上述分割，则返回 true ；否则，返回 false 。

import hard.Insert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class IsPossible659 {
    /*
    贪心算法，拿到一个x，判断是否存在以x-1结尾的子序列，如果存在，把x加入该子序列，并将该子序列标记为x结尾
    如果不存在，查看x+1、x+2是否还有剩余，如果都有，新建一个子序列[x,x+1,x+2]
    如果没有或者剩余不够，则无法得到长度为3的子序列，无法完成分割。
    如果整个数组便利结束，没有遇到无法完成分割的情况，表示可以分割完成
     */
    public boolean isPossible(int[] nums){
        Map<Integer, Integer> countMap=new HashMap<Integer, Integer>();
        Map<Integer,Integer>  endMap=new HashMap<Integer, Integer>();
        for(int x:nums){
            int count=countMap.getOrDefault(x,0)+1;
            countMap.put(x,count);
        }
        for(int x:nums){
            int count=countMap.getOrDefault(x,0);
            if(count>0){
                int preEndCount=endMap.getOrDefault(x-1,0);
                if(preEndCount>0){//表示存在x-1结尾的子序列
                    countMap.put(x,count-1);
                    endMap.put(x-1,preEndCount-1);
                    endMap.put(x,endMap.getOrDefault(x,0)+1);
                }else {
                    int count1=countMap.getOrDefault(x+1,0);
                    int count2=countMap.getOrDefault(x+2,0);
                    if(count1>0&&count2>0){//可以新建一个子序列
                        countMap.put(x,count-1);
                        countMap.put(x+1,count1-1);
                        countMap.put(x+2,count2-1);
                        endMap.put(x+2,endMap.getOrDefault(x+2,0)+1);
                    }else {
                        return false;
                    }
                }
            }
        }
         return true;
    }
    /*
    哈希表+最小堆：选定一个x，如果存在一个以x-1结尾的子序列，长度为k,将x加入，长度变为k+1
    如果不存在以x-1结尾的子序列，新建一个只包含x的子序列，长度为1。
    当存在多个子序列以x-1结尾，应该把x加入最短的子序列，因为我们需要子序列尽可能长
    哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列的长度，最小对满足堆顶元素最小
    遍历结束后，如果所有子序列的长度都不小于3，则表示可以分割成功。
     */
    public boolean isPossible1(int[] nums){
        Map<Integer, PriorityQueue<Integer>> map=new HashMap<Integer, PriorityQueue<Integer>>();
        for(int x:nums){
            if(!map.containsKey(x)){
                map.put(x,new PriorityQueue<Integer>());
            }
            if(map.containsKey(x-1)){
                int prevLength=map.get(x-1).poll();
                if(map.get(x-1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(prevLength+1);//存在x-1结尾，变成x结尾，长度加1
            }else {
                map.get(x).offer(1);//如果没有，新建一个子序列
            }
        }
        Set<Map.Entry<Integer,PriorityQueue<Integer>>> entrySet=map.entrySet();
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry:entrySet){
            PriorityQueue<Integer> queue=entry.getValue();
            if(queue.peek()<3){
                return false;
            }
        }
        return true;
    }
}
