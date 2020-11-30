package medium;

import java.util.Arrays;

//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//        若可行，输出任意可行的结果。若不可行，返回空字符串。
public class ReorganizeString767 {
    public String reorganizeString(String S) {//计数排序
      if(S.length()<2){
          return S;
      }
      int[] counts=new int[26];
      int maxCount=0;
      int length=S.length();
      for(int i=0;i<length;i++){
          char c=S.charAt(i);
          counts[c-'a']++;
          maxCount=Math.max(maxCount,counts[c-'a']);
      }
      if(maxCount>(length+1)/2){
          return "";
      }
      char[] reorganizeArray=new char[length];
      int evenIndex=0,oddIndex=1;
      int halfLength=length/2;
      for(int i=0;i<26;i++){
          char c=(char)('a'+i);
          while(counts[i]>0&&counts[i]<=halfLength&&oddIndex<length){
              reorganizeArray[oddIndex]=c;
              counts[i]--;
              oddIndex+=2;
          }
          while(counts[i]>0){
              reorganizeArray[evenIndex]=c;
              counts[i]--;
              evenIndex+=2;
          }
      }
      return new String(reorganizeArray);
    }
}
