package medium;
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s){
      boolean[] vis=new boolean[26];
      int[] num=new int[26];//各个字母的个数
      for(int i=0;i<s.length();++i){
          num[s.charAt(i)-'a']++;
      }
      StringBuffer sb=new StringBuffer();
      for(int i=0;i<s.length();++i){//遍历
          char ch=s.charAt(i);//取当前字符
          if(!vis[ch-'a']){//因为每个字符不能重复出现，因此只能出现一次，如果当前字符不存在结果字符串中
              while(sb.length()>0&&sb.charAt(sb.length()-1)>ch){//把当前字符和结果字符串最后一个字符比较，如果大于，则要删除
                  if(num[sb.charAt(sb.length()-1)-'a']>0){//如果结果字符串最后偶一个字符存在
                      vis[sb.charAt(sb.length()-1)-'a']=false;//设置为false，因为要移除
                      sb.deleteCharAt(sb.length()-1);
                  }else {
                      break;
                  }
              }
              vis[ch-'a']=true;//当前字符加入
              sb.append(ch);//添加到结果字符串中
          }
          num[ch-'a']-=1;//已添加减一
      }
      return sb.toString();
    }
}
