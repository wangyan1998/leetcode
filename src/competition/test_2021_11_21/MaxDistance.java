package competition.test_2021_11_21;
//街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n
//        的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
//        返回 两栋 颜色 不同 房子之间的 最大 距离。
//        第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。

/**
 * @author wy
 * @date 2021/11/21 10:32
 */
public class MaxDistance {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(colors[i]!=colors[j]){
                    ans=Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }
}
