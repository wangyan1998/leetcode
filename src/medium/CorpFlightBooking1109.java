package medium;
//这里有n个航班，它们分别从 1 到 n 进行编号。
//        有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]
//        意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
//        请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。

/**
 * @author wy
 * @date 2021/8/31 9:27
 */
public class CorpFlightBooking1109 {
    /**
     * 依次统计到数组中
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings,int n){
        int[] res=new int[n];
        for (int[] booking : bookings) {
            for(int k=booking[0];k<=booking[1];k++){
                res[k]+=booking[2];
            }
        }
        return res;
    }

    /**
     * 差分数组
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
