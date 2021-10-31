package esay;
//如果数组是单调递增或单调递减的，那么它是单调的。
//        如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
//        如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
//        当给定的数组 A是单调数组时返回 true，否则返回 false。

public class IsMonotonic896 {
    /**
     * 条件判断法；
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A){
        int n=A.length;
        int flag=0;
        int k=1;
        if(n<2){
            return true;
        }
        while(k<n){
            if(A[k]==A[k-1]){
                k++;
            }else {
                if(A[k]>=A[k-1]){
                 flag=1;
                }
                break;
            }
        }
        for(int i=2;i<n;i++){
            if(flag==1){
                if(A[i]<A[i-1]){
                return false;
                }
            }else {
                if(A[i]>A[i-1]){
                    return false;
                }
            }
        }
        return true;
    }

}
