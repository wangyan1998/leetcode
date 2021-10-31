package esay;

/**
 * @author wy
 * @date 2021/5/7 9:08
 */
public class XorOperation1486 {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        nums[0] = start;
        int res = start;
        for (int i = 1; i < n; i++) {
            nums[i] = start + 2 * i;
            res = res ^ nums[i];
        }
        return res;
    }

    public int xorOperation1(int n, int start) {
        int nums = 0;
        int res = start;
        for (int i = 1; i < n; i++) {
            nums = start + 2 * i;
            res = res ^ nums;
        }
        return res;
    }
}
