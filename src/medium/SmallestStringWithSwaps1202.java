package medium;
//给你一个字符串s，以及该字符串中的一些「索引对」数组pairs，其中pairs[i] =[a, b]
//        表示字符串中的两个索引（编号从 0 开始）。
//        你可以 任意多次交换 在pairs中任意一对索引处的字符。
//        返回在经过若干次交换后，s可以变成的按字典序最小的字符串。

import java.util.*;

public class SmallestStringWithSwaps1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs){
        //初始化连通图
        DisjointSetUnion dsu = new DisjointSetUnion(s.length());
        for(List<Integer> pair:pairs){
            //合并
            dsu.unionSet(pair.get(0),pair.get(1));
        }
        //使用map存储祖先节点到子节点列表的映射，存储并查集结果
        //例如s = "dcab", pairs = [[0,3],[1,2]]
        //0:[d,b]  1:[c,a]
        Map<Integer,List<Character>> map =new HashMap<Integer,List<Character>>();
        for(int i =0;i<s.length();i++){
            int parent = dsu.find(i);//找到该节点的父节点
            if(!map.containsKey(parent)){
                map.put(parent,new ArrayList<Character>());
            }
            map.get(parent).add(s.charAt(i));
        }
        //对map中的值进行排序
        for(Map.Entry<Integer,List<Character>> entry:map.entrySet()){
            Collections.sort(entry.getValue(),new Comparator<Character>(){
                public int compare(Character c1,Character c2){
                    return c2-c1;
                }
            });
        }
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<s.length();i++){
            int x = dsu.find(i);
            List<Character> list =map.get(x);
            sb.append(list.remove(list.size()-1));
        }
        return sb.toString();

    }
}
//定义并差集类
class DisjointSetUnion{
    int n;  //并查集长度
    int[] rank;  //节点等级
    int[] f;   //存储对应的祖先节点

    //构造函数,初始化属性
    public DisjointSetUnion(int n){
        this.n = n;
        rank = new int[n];
        Arrays.fill(rank,1);
        f = new int[n];
        for(int i=0;i<n;i++){
            f[i] = i;
        }
    }

    //方法find,寻找给节点的祖先
    public int find(int x){
        return f[x] == x?x:(f[x]=find(f[x]));
    }

    //合并到一个图中，共同有一个祖先
    public void unionSet(int x, int y) {
        int fx=find(x),fy = find(y);
        if(fx==fy){
            return;
        }
        if(rank[fx]<rank[fy]){
            //swap(fx,fy);
            int temp = fx;
            fx=fy;
            fy=temp;
        }
        //fx级别高，要作为祖先
        rank[fx] +=rank[fy];
        f[fy] = fx;
    }
}
