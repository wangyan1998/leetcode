package simple;
//对于非负整数X而言，X的数组形式是每位数字按从左到右的顺序形成的数组。
//        例如，如果X = 1231，那么其数组形式为[1,2,3,1]。
//        给定非负整数 X 的数组形式A，返回整数X+K的数组形式。

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm989 {
    /**
     * 按位相加，进位处理，最后使用Collections逆转获得正确的List顺序
     * @param A
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm(int[] A,int k){
        List<Integer> res=new ArrayList<Integer>();
        int n=A.length;
        for(int i=n-1;i>=0;--i){
            int sum=A[i]+k%10;
            k/=10;
            if(sum>=10){
                k++;
                sum-=10;
            }
            res.add(sum);
        }
        for(;k>0;k/=10){
            res.add(k%10);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * k+A[i],对10取余就是当前位的数值，对10整除就是下一次使用的K
     * @param A
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm1(int[] A,int k){
        List<Integer> res=new ArrayList<Integer>();
        int n=A.length;
        for(int i=n-1;i>=0||k>0;i--,k/=10){
            if(i>=0){
                k+=A[i];
            }
            res.add(k%10);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {
        LinkedList<Integer> res= new LinkedList<>();
        int i=A.length-1,c=0;
        while(i>=0 || K>0){
            if(i>=0)K+=A[i--];
            res.addFirst(K%10);
            K/=10;
        }
        return res;
    }
}
