package medium;
//给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
//        如果我们可以通过上述方式得到2的幂，返回 true；否则，返回 false。

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/10/28 9:10
 */
public class ReorderedPowerOf2869 {
    /**
     * 预处理+哈希表
     * 如果一个数中0-9的个数和某一个2的幂的0-9的个数一致，那么该数一定能够重组成2的幂。
     */
    Set<String> powerOf2Digits=new HashSet<String>();
    public boolean reorderedPowerOf2(int n){
       init();
       return powerOf2Digits.contains(countDigits(n));
    }
    public void init(){
        for(int n=1;n<=1e9;n<<=1){
            powerOf2Digits.add(countDigits(n));
        }
    }
    public String countDigits(int n){
        char[] cnt=new char[10];
        while(n>0){
            ++cnt[n%10];
            n/=10;
        }
        return new String(cnt);
    }
}
