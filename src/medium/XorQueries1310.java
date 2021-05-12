package medium;
//有一个正整数数组arr，现给你一个对应的查询数组queries，其中queries[i] = [Li,Ri]。
//        对于每个查询i，请你计算从Li到Ri的XOR值（即arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
//        并返回一个包含给定查询queries所有结果的数组。

/**
 * @author wy
 * @date 2021/5/12 8:47
 */
public class XorQueries1310 {
    public int[] xorQueries(int[] arr,int[][] queries){
        int n=queries.length;
        int[] res=new int[n];
        int r;
        for(int i=0;i<n;i++){
            r=0;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                r=r^arr[j];
            }
            res[i]=r;
        }
        return res;
    }

    /**
     * 先求出前i个元素的异或值，保存在一个数组xors中，也就是xors[i]=arr[0]^arr[1]...arr[i-1]。然后分情况：
     * 如果left=0,直接返回xors[right+1];
     * 如果left>0,返回xors[left]^xors[right+1];
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries1(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }
}
