package hard;

/**
 * @author wy
 * @date 2021/4/2 8:39
 */
public class Trap1712 {
    /**
     * 从左右两遍记录最高值，通过添加最高值和当前的差值得到水量。对于下标 ii，水能到达的最大高度等于下标 ii 两边的最大高度的最小值
     * 所以对于每次左右两边最大值比较的时候总是选择较小的那一侧操作。
     * @param height
     * @return
     */
    public int trap(int[] height){
        if(height.length<3){
            return 0;
        }
        int left=0,right=height.length-1;
        int leftmax=height[left],rightmax=height[right];
        int res=0;
        while(left<right){
            if(leftmax < rightmax){
                res += leftmax - height[left++];
                leftmax = Math.max(height[left], leftmax);
            }else{
                res += rightmax - height[right--];
                rightmax = Math.max(height[right], rightmax);
            }
        }
        return res;
    }

    /**
     * 动态规划，一个位置能存放水量是左右两边最大值中的最小值和当前位置水量的差值。
     * 即：water[i]=Math.min(leftMax,rightMax)-height[i]
     * 因此可以开辟两个数组分别存储当前位置左边的最大值和右边的最大值。
     * @param height
     * @return
     */
    public int trap1(int[] height){
        int n=height.length;
        if(n<3){
          return 0;
        }
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        leftmax[0]=height[0];
        rightmax[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return res;
    }

}
