package hard;
//给出矩阵matrix和目标值target，返回元素总和等于目标值的非空子矩阵的数量。
//        子矩阵x1, y1, x2, y2是满足 x1 <= x <= x2且y1 <= y <= y2的所有单元matrix[x][y]的集合。
//        如果(x1, y1, x2, y2) 和(x1', y1', x2', y2')两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/5/29 9:27
 */
public class NumSubmatrixSumTarget1074 {
    /**
     * 前缀和+哈希表
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix,int target){
        int ans=0;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            int[] sum=new int[n];
            for(int j=i;j<m;j++){
                for(int c=0;c<n;c++){
                    sum[c]+=matrix[j][c];
                }
                ans+=subarraySum(sum,target);
            }
        }
        return ans;
    }
    public int subarraySum(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(0,1);
        int count=0,pre=0;
        for(int x:nums){
            pre+=x;
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
