package competition.test_2021_10_24;
//句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。
//        每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
//        如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
//        仅由小写字母、连字符和/或标点（不含数字）。
//        至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
//        至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
//        这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
//        给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/10/24 10:30
 */
public class CountValidWords {
    public int countValidWords(String sentence) {
      String[] tokens=sentence.split("\\s+");
      int res=0;
      for(String s:tokens){
          if(!s.equals("")&&!s.equals(" ")){
          res+=validToken(s);
          }
      }
      return res;
    }
    public int validToken(String s){
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='!'||s.charAt(i)=='.'||s.charAt(i)==','){
                if(i!=n-1){return 0;}
            }
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                return 0;
            }
            if(s.charAt(i)=='-'){
                count++;
                if(count>1){
                    return 0;
                }
                if(i>0&&i<n-1&&s.charAt(i-1)>='a'&&s.charAt(i-1)<='z'&&s.charAt(i+1)>='a'&&s.charAt(i+1)<='z'){

                }else{
                    return 0;
                }
            }
        }
        return 1;
    }
}
