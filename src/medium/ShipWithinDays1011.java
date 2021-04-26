package medium;
//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//    传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//    返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/26 8:21
 */
public class ShipWithinDays1011 {
    /**
     * 二分查找边界法
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            //need为需要运送的天数
            //cur为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
