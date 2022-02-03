package esay;
//给你一个下标从 0 开始的字符串word和一个字符ch。找出ch第一次出现的下标i，反转word中从下标0开始、
//        直到下标i结束(含下标i)的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
//        例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标
//        3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
//        返回结果字符串 。
/**
 * @author wy
 * @date 2022/2/2 9:41
 */
public class ReversePrefix {
    public String reversePrefix(String word,char ch){
        int i=0;
        for(;i<word.length();i++) {
            if (ch == word.charAt(i)) {
                break;
            }
        }
        if(i==word.length()){
            return word;
        }
        StringBuffer res=new StringBuffer();
        for(int j=i;j>=0;j--){
            res.append(word.charAt(j));
        }
        for(int j=i+1;j<word.length();j++){
            res.append(word.charAt(j));
        }
        return res.toString();
    }

    /**
     * 数组方法
     * @param word
     * @param ch
     * @return
     */
    public String reversePrefix1(String word, char ch) {
        int index = word.indexOf(ch);
        if (index >= 0) {
            char[] arr = word.toCharArray();
            int left = 0, right = index;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            word = new String(arr);
        }
        return word;
    }
}
