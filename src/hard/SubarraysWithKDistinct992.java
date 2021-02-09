package hard;
//给定一个正整数数组 A，如果 A的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、
//        不一定独立的子数组为好子数组。
//        （例如，[1,2,3,1,2] 中有3个不同的整数：1，2，以及3。）
//        返回A中好子数组的数目。


public class SubarraysWithKDistinct992 {
    public int subarrasWithKDistinct(int[] A,int K){
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }
    /**
     * @param A
     * @param K
     * @return 最多包含 K 个不同整数的子区间的个数
     */
    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;
        // [left, right) 包含不同整数的个数小于等于 K
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }
}
