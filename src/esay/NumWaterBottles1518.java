package esay;
//小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
//        如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
//        请你计算 最多 能喝到多少瓶酒。

/**
 * @author wy
 * @date 2021/12/17 11:23
 */
public class NumWaterBottles1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        while (numBottles >= numExchange) {
            int num = numBottles / numExchange;
            res += num * numExchange;
            numBottles = num + numBottles % numExchange;
        }
        res += numBottles;
        return res;
    }
}
