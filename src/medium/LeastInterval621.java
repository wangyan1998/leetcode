package medium;
//给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
//        任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，
//        CPU 可以完成一个任务，或者处于待命状态。
//        然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续n个单位时间内CPU
//        在执行不同的任务，或者在待命状态。
//        你需要计算完成所有任务所需要的 最短时间 。

import hard.Insert;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeastInterval621 {
    public int leastInterval(char[] tasks,int n){
     Map<Character,Integer> freq=new HashMap<Character,Integer>();
     int maxExec=0;
     for(char ch:tasks){
         int exec=freq.getOrDefault(ch,0)+1;
         freq.put(ch,exec);
         maxExec=Math.max(maxExec,exec);
     }
     int maxCount=0;
        Set<Map.Entry<Character,Integer>> entrySet=freq.entrySet();
        for(Map.Entry<Character, Integer> entry:entrySet){
            int value=entry.getValue();
            if(value==maxExec){
                ++maxCount;
            }
        }
        return Math.max((maxExec-1)*(n+1)+maxCount,tasks.length);
    }
}
