package medium;
//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
//        总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
//        注意：字符串长度 和 k 不会超过10^4。


public class CharacterReplacement424 {
    /**
     * 双指针法：枚举字符串的每个位置作为右端点，然后找到其最远的左端点的位置，满足该区间内除了出现
     * 次数最多的那一类字符之外，剩余的字符数量不超过k个。每次右指针右移，如果区间仍然满足条件，那么
     * 左指针不移动，否则左指针至多右移一格，保证区间长度不减小。虽然这样的操作会导致部分区间不符合
     * 条件，即该区间内最长重复字符超过了k个。但是这样的区间也同样不可能对答案产生贡献。当我们右指针
     * 移动到尽头，左右指针对应的区间的长度必然对应一个长度最大的符合条件的区间。
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s,int k){
       int[] num=new int[26];
       int n=s.length();
       int maxn=0;
       int left=0,right=0;
       while(right<n){
           num[s.charAt(right)-'A']++;
           maxn=Math.max(maxn,num[s.charAt(right)-'A']);
           if(right-left+1-maxn>k){
               num[s.charAt(left)-'A']--;
               left++;
           }
           right++;
       }
       return right-left;
    }
}
