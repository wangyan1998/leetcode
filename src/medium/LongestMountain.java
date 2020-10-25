package medium;

public class LongestMountain {
    public int longestMountain(int[] A){//山顶枚举，动态规划
        int n=A.length;
        if(n==0){
            return 0;
        }
        int[] left=new int[n];
        for(int i=1;i<n;++i){
            left[i]=A[i-1]<A[i]?left[i-1]+1:0;
        }
        int[] right=new int[n];
        for(int i=n-2;i>=0;--i){
            right[i]=A[i+1]<A[i]?right[i+1]+1:0;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(left[i]>0&&right[i]>0){
                ans=Math.max(ans,left[i]+right[i]+1);
            }
        }
        return ans;
    }
    public int longestMountain1(int[] A){//枚举山脚
        int n=A.length;
        int ans=0;
        int left=0;
        while(left+2<n){
            int right=left+1;
            if(A[left]<A[left+1]){
                while(right+1<n&&A[right]<A[right+1]){
                    ++right;
                }
                if(right<n-1&&A[right]>A[right+1]){
                    while(right+1<n&&A[right]>A[right+1]){
                        ++right;
                    }
                    ans=Math.max(ans,right-left+1);
                }else {
                    ++right;
                }
            }
            left=right;
        }
        return ans;
    }
}
