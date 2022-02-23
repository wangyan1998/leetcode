package esay;
//有两种特殊字符：
//        第一种字符可以用一个比特0来表示
//        第二种字符可以用两个比特(10或11)来表示、
//        给定一个以 0 结尾的二进制数组bits，如果最后一个字符必须是一位字符，则返回 true 。

/**
 * @author wy
 * @date 2022/2/20 9:09
 */
public class IsOneBitCharacter717 {
    /**
     * 让i停在最后一步的位置，如果最后一步在n-1处，并且bits[n-1]=0，说明最后一个字符必定是一位字符
     * 如果最后一步停在n处，说明必然是在n-2处跳了两步，说明bits[n-2,n-2]一定是10或11
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits){
        int i=0;
        int n=bits.length;
        while(i<n-1){
            if(bits[i]==1){
                i+=2;
            }else {
                i++;
            }
        }
        if(i==n-1&&bits[n-1]==0){
            return true;
        }else {
            return false;
        }
    }
}
