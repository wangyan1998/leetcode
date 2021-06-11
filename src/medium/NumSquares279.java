package medium;
//给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//        给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
//        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

/**
 * @author wy
 * @date 2021/6/11 8:55
 */
public class NumSquares279 {
    /**
     * f[i]表示最少需要多少个数的平方来表示整数i
     * 这些数必然落在[1,根号n]之内，可以枚举这些数，假设当前枚举到j,那么我们还需要取若干数的平方构成i-j^2
     *此时该问题和原问题类似：f[i]=1+min(j=1->|根号n|)f[i-j^2]
     */
    public int numSquares(int n){
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }


    public int numSquares1(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
