package competition.test_2021_10_17;
//句子是由若干 token 组成的一个列表，token 间用单个空格分隔，句子没有前导或尾随空格。
//        每个 token 要么是一个由数字 0-9 组成的不含前导零的正整数 ，要么是一个由小写英文字母组成的单词 。
//        示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，
//        其他像 "puppy" 这样的 tokens 属于单词。
//        给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增（即，除了最后一个数字，
//        s 中的每个数字都严格小于它右侧的数字）。
//        如果满足题目要求，返回 true ，否则，返回 false 。
/**
 * @author wy
 * @date 2021/10/17 10:30
 */
public class AreNumbersAscending {
    public boolean areNumbersAscending(String s){
       int pre=0;
       for(int i=0;i<s.length();i++){
           if('0'<=s.charAt(i)&&s.charAt(i)<='9'){
               int num=s.charAt(i)-'0';
               i++;
               while(i<s.length()&&'0'<=s.charAt(i)&&s.charAt(i)<='9'){
                   num=num*10+s.charAt(i)-'0';
                   i++;
               }
               if(num>pre){
                   pre=num;
               }else {
                   return false;
               }
           }
       }
       return true;
    }
}
