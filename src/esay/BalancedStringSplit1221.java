package esay;
//在一个平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
//        给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
//        注意：分割得到的每个字符串都必须是平衡字符串。
//        返回可以通过分割得到的平衡字符串的 最大数量 。


/**
 * @author wy
 * @date 2021/9/7 8:56
 */
public class BalancedStringSplit1221 {
    public int balancedStringSplit(String s){
        int left=0,right=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                left++;
            }else {
                right++;
            }
            if(left!=0&&right!=0&&left==right){
                res++;
                left=0;
                right=0;
            }
        }
        return res;
    }

    public int balancedStringSplit1(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
