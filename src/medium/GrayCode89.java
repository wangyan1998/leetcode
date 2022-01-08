package medium;
//n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
//        (1)每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
//        (2)第一个整数是 0
//        (3)一个整数在序列中出现 不超过一次
//        (4)每对 相邻 整数的二进制表示 恰好一位不同 ，且
//        (5)第一个 和 最后一个 整数的二进制表示 恰好一位不同
//        给你一个整数 n ，返回任一有效的 n 位格雷码序列 。


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/1/8 11:13
 */
public class GrayCode89 {
    /**
     * 格雷码的对称翻转获得法
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n){
        List<Integer> ret=new ArrayList<Integer>();
        ret.add(0);
        for(int i=1;i<=n;i++){
            int m=ret.size();
            for(int j=m-1;j>=0;j--){
                ret.add(ret.get(j)|(1<<(i-1)));
            }
        }
        return ret;
    }
}
