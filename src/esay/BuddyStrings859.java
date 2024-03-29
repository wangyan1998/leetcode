package esay;
//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；否则返回 false 。
//        交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
//        例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad"。


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wy
 * @date 2021/11/23 9:19
 */
public class BuddyStrings859 {
    /**
     * 首先长度要一致，字符串要么有两个字符不相同可以互换，要么字符相同最大频次字母大于1
     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal){
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            int[] count=new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;
                if(count[s.charAt(i)-'a']>1){
                    return true;
                }
            }
            return false;
        }else {
            int first=-1,second=-1;
            for(int i=0;i<goal.length();i++){
                if(s.charAt(i)!=goal.charAt(i)){
                    if(first==-1){
                        first=i;
                    }else if(second==-1){
                        second=i;
                    }else {
                        return false;
                    }
                }
            }
            return (second!=-1&&s.charAt(first)==goal.charAt(second)&&s.charAt(second)==goal.charAt(first));
        }
    }
}
