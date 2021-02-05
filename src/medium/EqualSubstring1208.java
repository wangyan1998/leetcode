package medium;
//给你两个长度相同的字符串，s 和 t。
//        将 s中的第i个字符变到t中的第 i 个字符需要|s[i] - t[i]|的开销（开销可能为 0），
//        也就是两个字符的 ASCII 码值的差的绝对值。
//        用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，
//        这也意味着字符串的转化可能是不完全的。
//        如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
//        如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。


public class EqualSubstring1208 {
    /**
     * 双指针思想，应该想明白什么时候左指针动，什么时候右指针动
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s,String t,int maxCost){
        int n=s.length();
        int[] re=new int[n];
        for(int i=0;i<n;i++){
            re[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int maxlen=0;
        int sum=0;
        int start=0,end=0;
        while (end<n){
            sum+=re[end];
            while(sum>maxCost){
                sum-=re[start];
                start++;
            }
            maxlen=Math.max(maxlen,end-start+1);
            end++;
        }
        return maxlen;
    }
    public int equalSubstring1(String s, String t, int maxCost) {
        int m = s.length();
        char [] sch  = s.toCharArray();
        char [] tch = t.toCharArray();
        int [] result = new int [m];
        for(int i = 0; i < m; i++) {
            result[i] = Math.abs(sch[i] - tch[i]);
        }

        int  maxLegth = 0;
        int sum = 0;
        for(int left =0, right = 0; right < result.length ; right++) {
            sum += result[right];
            if(sum <= maxCost) { //右指针在走
                maxLegth = Math.max(maxLegth, right - left+1);
            } else { //走左指针
                sum -= result[left];
                left++;
            }
        }
        return maxLegth;

    }
}
