package simple;

//实现strStr()函数。
//        给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置
//        （下标从 0 开始）。如果不存在，则返回 -1 。


/**
 * @author wy
 * @date 2021/4/20 8:16
 */
public class StrStr28 {
    public static int strStr(String haystack,String needle){
        if(needle==null||needle.equals("")){
            return 0;
        }
        int n=haystack.length();
        int m=needle.length();
        int res=-1;
        int j;
        for(int i=0;i<=n-m;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                res=i;
                j=1;
                while(j<m){
                    if(haystack.charAt(i+j)==needle.charAt(j)){
                        j++;
                    }else {
                        res=-1;
                        break;
                    }
                }
            }
            if(res!=-1){
                break;
            }
        }
        return res;
    }

    /**
     * 这种方法和上一种自己写的方法都是暴力匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 直接比较字符串
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        boolean b=true;
        String s="";
        int i;
        for(i=0;i<=(n-m);i++){
            s=haystack.substring(i,i+m);
            if(s.equals(needle)){
                b=false;
                break;

            }
        }
        if(b==false){
            return i;
        }else{
            return -1;
        }
    }
}
