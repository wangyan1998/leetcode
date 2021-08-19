package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/8/19 9:12
 */
public class ReverseVowels345 {
    /**
     * 一次遍历
     * @param s
     * @return
     */
    public String reverseVowels(String s){
        char[] c=s.toCharArray();
        int n=s.length();
        int i=0,j=n-1;
        Set<Character> set=new HashSet<Character>();
        set.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(i<j) {
            while (!set.contains(c[i])) {
                if (i == j) {
                    break;
                }
                i++;
            }
            while (!set.contains(c[j])) {
                if (i == j) {
                    break;
                }
                j--;
            }
            char x = c[i];
            c[i] = c[j];
            c[j] = x;
            i++;
            j--;
        }
        return String.valueOf(c);
    }

    /**
     * 答案题解
     * @param s
     * @return
     */
    public String reverseVowels1(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
