package medium;
//给定一个正整数n ，你可以做如下操作：
//        如果n是偶数，则用n / 2替换n 。
//        如果n是奇数，则可以用n + 1或n - 1替换n 。
//        n变为 1 所需的最小替换次数是多少？

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/11/19 9:27
 */
public class IntegerReplacement397 {
    /**
     * 子问题分解，递归
     *
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return getNum(n - 1);
        }
        return getNum(n);
    }

    public int getNum(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + getNum(n / 2);
        } else {
            int a = 1 + getNum(n + 1);
            int b = 1 + getNum(n - 1);
            return Math.min(a, b);
        }
    }

    /**
     * 偶数直接除以2，没有其他选择，奇数无论是加一还是减一，都会导致其变为偶数，再除以2，其实可以看成两次操作
     * @param n
     * @return
     */
    public int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement1(n / 2);
        }
        return 2 + Math.min(integerReplacement1(n / 2), integerReplacement1(n / 2 + 1));
    }

    /**
     * 记忆搜索
     */
    Map<Integer,Integer> memo=new HashMap<Integer, Integer>();
    public int integerReplacement2(int n){
        if(n==1){
            return 0;
        }
        if(!memo.containsKey(n)){
            if(n%2==0){
                memo.put(n,1+integerReplacement2(n/2));
            }else {
                memo.put(n,2+Math.min(integerReplacement2(n/2),integerReplacement2(n/2+1)));
            }
        }
        return memo.get(n);
    }

    /**
     * 贪心算法，分情况讨论
     * @param n
     * @return
     */
    public int integerReplacement3(int n){
        int ans=0;
        while(n!=1){
            if(n%2==0){
                ++ans;
            }else if(n%4==1){
                ans+=2;
                n/=2;
            }else {
                if(n==3){
                    ans+=2;
                    n=1;
                }else {
                    ans+=2;
                    n=n/2+1;
                }
            }
        }
        return ans;
    }
}
