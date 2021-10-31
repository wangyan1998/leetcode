package esay;
//给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/10/18 9:42
 */
public class FindComplement476 {
    public int findComplement(int num){
        Queue<Integer> queue=new ArrayDeque<Integer>();
        while(num!=0){
            queue.add(num%2);
            num/=2;
        }
        int res=0;
        int c=1;
        while(!queue.isEmpty()){
            int x=queue.poll()==0?1:0;
            res=res+c*x;
            c*=2;
        }
        return res;
    }

    public int findComplement1(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
