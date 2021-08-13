package hard;

/**
 * @author wy
 * @date 2021/8/13 9:37
 */
public class CountDigitOne233 {
    /**
     * 逐位计算每个位上出现1的次数
     * @param n
     * @return
     */
    public int countDigitOne(int n){
        long mulk=1;
        int ans=0;
        for(int k=0;n>=mulk;++k){
            ans+=(n/(mulk*10))*mulk+Math.min(Math.max(n%(mulk*10)-mulk+1,0),mulk);
            mulk*=10;
        }
        return ans;
    }
}
