package hard;
//设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。
//        注意: 允许出现重复元素。
//        insert(val)：向集合中插入元素 val。
//        remove(val)：当 val 存在时，从集合中移除一个 val。
//        getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。


import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;
    public RandomizedCollection(){
        idx=new HashMap<Integer, Set<Integer>>();
        nums=new ArrayList<Integer>();
    }
    public boolean insert(int val){
        nums.add(val);
        Set<Integer> set=idx.getOrDefault(val,new HashSet<Integer>());
        set.add(nums.size()-1);
        idx.put(val,set);
        return set.size()==1;
    }
    public boolean remove(int val){
        if(!idx.containsKey(val)){
            return false;
        }
        Iterator<Integer> it=idx.get(val).iterator();
        int i=it.next();
        int lastNum=nums.get(nums.size()-1);
        nums.set(i,lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size()-1);
        if(i<nums.size()-1){
            idx.get(lastNum).add(i);
        }
        if(idx.get(val).size()==0){
            idx.remove(val);
        }
        nums.remove(nums.size()-1);
        return true;
    }
    public int getRandom(){
        return nums.get((int)(Math.random()*nums.size()));
    }
}
