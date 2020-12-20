package medium;
//返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。和316题一样
public class SmallestSubsequence1081 {
    public String smallestSubsequence(String s){
        boolean[] vis=new boolean[26];
        int[] num=new int[26];
        for(int i=0;i<s.length();++i){
            num[s.charAt(i)-'a']++;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(!vis[ch-'a']){
                while(sb.length()>0&&sb.charAt(sb.length()-1)>ch){
                    if(num[sb.charAt(sb.length()-1)-'a']>0){
                        vis[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }else {
                        break;
                    }
                }
                vis[ch-'a']=true;
                sb.append(ch);
            }
            num[ch-'a']-=1;
        }
        return sb.toString();
    }
}
