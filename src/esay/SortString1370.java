package esay;
//给你一个字符串s，请你根据下面的算法重新构造字符串：
//        1、从 s中选出 最小的字符，将它 接在结果字符串的后面。
//        2、从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
//        3、 重复步骤 2 ，直到你没法从 s中选择字符。
//        4、从 s中选出 最大的字符，将它 接在结果字符串的后面。
//        5、从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
//        6、重复步骤 5，直到你没法从 s中选择字符。
//        重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
//        在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
//        请你返回将s中字符重新排序后的 结果字符串

public class SortString1370 {
    public String sortString(String s) {//桶排序，结果字符串肯定是先升序再降序再升序降序循环
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        StringBuffer ret=new StringBuffer();
        while (ret.length()<s.length()){
            for(int i=0;i<26;i++){
                if(num[i]>0){
                    ret.append((char)(i+'a'));
                    num[i]--;
                }
            }
            for(int i=25;i>=0;i--){
                if(num[i]>0){
                    ret.append((char)(i+'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();
    }

}
