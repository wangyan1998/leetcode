package esay;
//给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
//        你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。


import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/11/1 10:10
 */
public class DistributeCandies575 {
    /**
     * 贪心算法：
     * 一方面，设糖果数量为 nn，由于妹妹只能分到一半的糖果，所以答案不会超过 n/2；另一方面，设这些糖果一共有 m 种，答案也不会超过 m。
     * 若 m<n/2，则可以每种糖果至少分一颗给妹妹，此时答案为 m；若 m>n/2，则妹妹只能分到n/2种糖果，每种糖果分一颗，此时答案为n/2。
     * 综上所述，答案为 min(m,n/2)。
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType){
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
