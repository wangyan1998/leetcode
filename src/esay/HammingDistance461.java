package esay;
//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//        给出两个整数 x 和 y，计算它们之间的汉明距离。
//        注意：
//        0 ≤ x, y < 2^31.


/**
 * @author wy
 * @date 2021/5/27 8:00
 */
public class HammingDistance461 {
    /**
     * 先对x,y取异或，然后看异或结果中有几个1
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x,int y){
       int r=x^y;
       int res=0;
       while(r!=0){
           if((r&1)==1){
               res++;
           }
           r=r>>1;
       }
       return res;
    }
}
