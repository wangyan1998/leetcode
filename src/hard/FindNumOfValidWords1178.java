package hard;
//外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
//        字谜的迷面puzzle 按字符串形式给出，如果一个单词word符合下面两个条件，那么它就可以算作谜底：
//        单词word中包含谜面puzzle的第一个字母。
//        单词word中的每一个字母都可以在谜面puzzle中找到。
//        例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有
//        "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）
//        以及"based"（其中的 "s" 没有出现在谜面中）。
//        返回一个答案数组answer，数组中的每个元素answer[i]是在给出的单词列表
//        words 中可以作为字谜迷面puzzles[i]所对应的谜底的单词数目。


import java.util.ArrayList;
import java.util.List;

public class FindNumOfValidWords1178 {
    public List<Integer> findNumOfValidWords(String[] words,String[] puzzles){
      List<Integer> res=new ArrayList<Integer>();
      int count=0;
      for(int i=0;i<puzzles.length;i++){
          count=0;
          for(int j=0;j<words.length;j++){
              if(findword(words[j],puzzles[i])){
                  count++;
              }
          }
          res.add(count);
      }
      return res;
    }
    public boolean findword(String s1,String s2){
        boolean a=true;
        boolean b=s1.contains(s2.charAt(0)+"");
        for(int i=0;i<s1.length();i++){
            if(!s2.contains(s1.charAt(i)+"")){
                a=false;
            }
        }
        return a&b;
    }
}
