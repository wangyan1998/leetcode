package esay;
//在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
//        例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
//        分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
//        上例中的 "xxxx" 分组用区间表示为 [3,6] 。
//        我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
//        找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。


import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions830 {
    /**
     * 双指针法，当同一元素连续出现三次的时候就新建一个List把初始位置和末位置加入
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s){
      int i=0,j=1;
      List<List<Integer>> res=new ArrayList<List<Integer>>();
      while(i<s.length()&&j<s.length()){
          while(j<s.length()){
              if(s.charAt(j)==s.charAt(j-1)){
                  j++;
              }else{
                  break;
              }
          }
          if((j-i)>=3){
              List<Integer> r=new ArrayList<Integer>();
              r.add(i);
              r.add(j-1);
              res.add(r);
          }
          i=j;
          j=i+1;
      }
      return res;
    }
}
