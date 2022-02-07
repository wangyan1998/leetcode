package classify.nuike;

/**
 * @author wy
 * @date 2022/2/4 11:03
 */
public class test {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {3, -2, 4, -1};
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    for (int k = 0; k < i; k++) {
                        sum += arr[k];
                    }
                } else {
                    sum += arr[(j + i-1) % n];
                    sum -= arr[j - 1];
                }
                res = Math.max(res, sum);
            }
        }
        System.out.println(res);
    }
}
