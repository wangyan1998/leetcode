package simple;
//给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
//        这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
//        示例1:
//        输入: pattern = "abba", str = "dog cat cat dog"
//        输出: true

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    /*
    判断是否是一对一，需要使用双射结构，也就是要使用两个map
     */
    public boolean wordPattern(String pattern, String s) {
      String[] res=getword(s);
      int index=0;
      for(int i=0;i<res.length;i++){
          if(res[i]!=null){
              index++;
          }
      }
      if(pattern.length()!=index){
          return false;
      }
      Map<Character,String> map=new HashMap<Character, String>();
      Map<String,Character> map1=new HashMap<String, Character>();
      for(int i=0;i<pattern.length();i++){
          String s1=map.getOrDefault(pattern.charAt(i),"");
          char s2=map1.getOrDefault(res[i],' ');
          if(s1==""&&s2==' '){
              map.put(pattern.charAt(i),res[i]);
              map1.put(res[i],pattern.charAt(i));
          }else {
              if(!s1.equals(res[i])){
                  return false;
              }
              if(s2!=pattern.charAt(i)){
                  return false;
              }
          }
      }
      return true;
    }
    public String[] getword(String s) {
        String[] res = new String[s.length()];
        int i = 0, j = 0, k = 0;
        String ss = "";
        s=s+" ";
        while (j < s.length()) {
            if (s.charAt(j) != ' ') {
                j++;
            } else {
                ss = s.substring(i, j);
                res[k] = ss;
                k++;
                j++;
                i=j;
            }
        }
        return res;
    }
    /*
    题解方法，思想大同小异，代码比较简洁
     */
    public boolean wordPattern1(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }
}

