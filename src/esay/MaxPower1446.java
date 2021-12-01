package esay;
//给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
//        请你返回字符串的能量。
/**
 * @author wy
 * @date 2021/12/1 9:45
 */
public class MaxPower1446 {
    public int maxPower(String s){
       int max=1;
       int count=1;
       Character c=s.charAt(0);
       for(int i=1;i<s.length();i++){
           if(s.charAt(i)==c){
               count++;
               max=Math.max(max,count);
           }else {
               c=s.charAt(i);
               count=1;
           }
       }
       return max;
    }
}
