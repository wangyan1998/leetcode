package esay;
//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
//        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
/**
 * @author wy
 * @date 2021/9/21 8:58
 */
public class LengthOfLastWord58 {
    /**
     * 使用一个或者多个空格分割字符串，然后返回最后一个字符串的长度
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s){
        String[] str=s.split("\\s+");
        int n=str.length;
        return str[n-1].length();
    }
    public int lengthOfLastWord1(String s){
        int idx=s.length()-1;
        while(s.charAt(idx)==' '){
            idx--;
        }
        int wordLength=0;
        while(idx>=0&&s.charAt(idx)!=' '){
            wordLength++;
            idx--;
        }
        return wordLength;
    }
}
