package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n的最简分数。
// 分数可以以任意顺序返回。

/**
 * @author wy
 * @date 2022/2/10 9:39
 */
public class SimplifiedFractions1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 1) {
            return res;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (i == 1) {
                    if (i / j < n) {
                        res.add(i + "/" + j);
                    }
                } else {
                    if (j % i != 0 && hasnum(i, j)) {
                        res.add(i + "/" + j);
                    }
                }
            }
        }
        return res;
    }

    public boolean hasnum(int a, int b) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                set.add(i);
            }
        }
        for (int i = 2; i < b; i++) {
            if (b % i == 0 && set.contains(i)) {
                return false;
            }
        }
        return true;
    }
    //把分母i枚举从2~n,分子j从1~i，如果两个数的最大公约数是1，则说明分数j/i是最简分数
    public List<String> simplifiedFractions1(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(gcd(j,i)==1){
                    res.add(j+"/"+i);
                }
            }
        }
        return res;
    }
    //求最大公约数的函数，辗转相除法，a是大数，b是小数，temp是余数a%b,当余数不为0时，把b的值给a
    //把temp的值给b。如果余数为0,当前除数就是最大公约数
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
