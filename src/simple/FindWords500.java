package simple;
//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
//        美式键盘 中：
//        第一行由字符 "qwertyuiop" 组成。
//        第二行由字符 "asdfghjkl" 组成。
//        第三行由字符 "zxcvbnm" 组成。


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/10/31 9:30
 */
public class FindWords500 {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<String> s = new ArrayList<String>();
        List<String> res=new ArrayList<String>();
        s.add("qwertyuiop");
        s.add("asdfghjkl");
        s.add("zxcvbnm");
        for(int i=0;i<s.size();i++){
            String s1=s.get(i);
            String s2=s1.toUpperCase();
            for(int j=0;j<s1.length();j++){
                map.put(s1.charAt(j),i);
                map.put(s2.charAt(j),i);
            }
        }
        boolean flag=true;
        int idx;
        for (String word:words) {
            flag=true;
            idx=map.get(word.charAt(0));
            for (int i=1;i<word.length();i++){
                if(map.get(word.charAt(i))!=idx){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }


    /**
     * 为每一个英文字母标记其对应键盘上的行号，然后检测字符串中所有字符对应的行号是否相同。
     * (1)可以预处理计算出每个字符对应的行号。
     * (2)遍历字符串时，统一将大写字母转化为小写字母方便计算。
     * @param words
     * @return
     */
    public String[] findWords1(String[] words) {
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
