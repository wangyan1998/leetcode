package medium;
//给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
//        每次转换只能改变一个字母。
//        转换过程中的中间单词必须是字典中的单词。
//        说明:
//        如果不存在这样的转换序列，返回 0。
//        所有单词具有相同的长度。
//        所有单词只由小写字母组成。
//        字典中不存在重复的单词。
//        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

import java.util.*;

public class LadderLength {
    Map<String,Integer> wordId=new HashMap<String, Integer>();
    List<List<Integer>> edge=new ArrayList<List<Integer>>();
    int nodeNum=0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
      for(String word:wordList){
          addEdge(word);
      }
      addEdge(beginWord);
      if(!wordId.containsKey(endWord)){
          return 0;
      }
      int[] dis=new int[nodeNum];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int beginId=wordId.get(beginWord),endId=wordId.get(endWord);
        dis[beginId]=0;
        Queue<Integer> que=new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()){//广度优先遍历
            int x=que.poll();
            if(x==endId){
                return dis[endId]/2+1;
            }
            for(int it:edge.get(x)){
                if(dis[it]==Integer.MAX_VALUE){
                    dis[it]=dis[x]+1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }
    public void addEdge(String word){//分别替换word的每一个字符为*,成为一个新结点，加入结点，加入边
        addWord(word);
        int id1=wordId.get(word);
        char[] array=word.toCharArray();
        int length=array.length;
        for(int i=0;i<length;i++){
            char tmp=array[i];
            array[i]='*';
            String newWord=new String(array);
            addWord(newWord);
            int id2=wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i]=tmp;
        }
    }
    public void addWord(String word){//单词抽象成结点，每个单词分配一个唯一的编号
        if(!wordId.containsKey(word)){
            wordId.put(word,nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
