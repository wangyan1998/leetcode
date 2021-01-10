package classify.array;
//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
//上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。

import java.util.Deque;
import java.util.LinkedList;

public class Trap {
    /**
     *介绍一下单调栈的相关知识，所谓单调栈就是说栈内的元素是单调的，比如说递减栈，如果当前元素
     * 小于栈顶元素，就入栈，如果大于栈顶元素，栈顶弹出，直到当前元素小于栈顶元素或者栈空时入栈
     */
    /**
     * 本题使用递减栈，当前元素大于栈顶元素时，说明有落差，可以存储的水为：
     * 可以存储水=（当前元素的索引-栈顶元素的索引）
     * 这是当前栈顶元素这一层存储的，出栈，继续比较下一个栈顶元素与当前元素的大小
     * 因为数组中元素可能是一样的，所以栈内可以存储index而不存储value
     * @param height
     * @return
     */
    public int trap(int[] height){
        Deque<Integer> stack = new LinkedList<Integer>();
        int water = 0;
        //特殊情况
        if(height.length <3){
            return 0;
        }
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                //栈顶元素
                int popnum = stack.pop();
                //相同元素的情况,比如1，1
                while(!stack.isEmpty()&&height[popnum] == height[stack.peek()]){
                    stack.pop();
                }
                //计算该层的水的单位
                if(!stack.isEmpty()){
                    int temp = height[stack.peek()];//栈顶元素值
                    //高
                    int hig = Math.min(temp-height[popnum],height[i]-height[popnum]);
                    //宽
                    int wid = i-stack.peek()-1;
                    water +=hig * wid;
                }

            }
            //这里入栈的是索引
            stack.push(i);
        }
        return water;
    }

    /**
     * 动态规划：每一列都要求出当前列左边和右边的最大值，如果curheight<min(leftmax,rightmax),
     * 表示当前列可以盛水，盛水量为min(leftmax,rightmax)-curheight
     * 只需要求出每一列能存储水的容量就可以得到总的盛水量
     * @param height
     * @return
     */
    public int trap1(int[] height){
        if(height.length<3){
            return 0;
        }
        int n=height.length;
        int[] rightmax=new int[n];
        rightmax[n-1]=0;
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(height[i+1],rightmax[i+1]);
        }
        int water=0;
        int leftmax=0;
        for(int i=1;i<n-1;i++){
            leftmax=Math.max(height[i-1],leftmax);
            int low=Math.min(leftmax,rightmax[i]);
            if(low>height[i]){
            water+=low-height[i];
            }
        }
        return water;
    }

    /**
     *双指针法：
     * @param height
     * @return
     */
    public int trap2(int[] height){
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
}
