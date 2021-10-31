package esay;
//给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
//        对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
//        你可以返回任何满足上述条件的数组作为答案。

public class SortArrayByParityII922 {
    public int[] sortArrayByParityII(int[] A){//暴力，先把奇数偶数取出来，再把奇数偶数放回去
        int n=A.length;
        int[] B=new int[n];
        int[] C=new int[n];
        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(A[i]%2==0){
                B[j]=A[i];
                j++;
            }else{
                C[k]=A[i];
                k++;
            }
        }
        j=0;
        k=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                A[i]=B[j];
                j++;
            }else{
               A[i]=C[k];
               k++;
            }
        }
        return A;
    }
    public int[] sortArrayByParityII1(int[] A){
        int n=A.length;
        int[] ans=new int[n];
        int i=0;
        for(int x:A){
            if(x%2==0){
                ans[i]=x;
                i+=2; 
            }
        }
        i=1;
        for(int x:A){
            if(x%2==1){
                ans[i]=x;
                i+=2;
            }
        }
        return ans;
    }
    public int[] sortArrayByParityII2(int[] A){//双指针
        int n=A.length;
        int j=1;
        for(int i=0;i<n;i+=2){
            if(A[i]%2==1){
                    while(A[j]%2==1){
                        j+=2;
                    }
                    swap(A,i,j);
            }
        }
        return A;
    }
    public void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
