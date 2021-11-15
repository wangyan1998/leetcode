package medium;
//实现一个 MapSum 类，支持两个方法，insert和sum：
//        MapSum() 初始化 MapSum 对象
//        void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，
//        整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
//        int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。


import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/11/14 9:48
 */
public class MapSum677 {
    Map<String, Integer> map;

    public MapSum677() {
        map = new HashMap<String, Integer>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
           if(entry.getKey().startsWith(prefix)){
             res+=entry.getValue();
           }
        }
        return res;
    }
}
