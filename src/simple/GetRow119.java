package simple;

import java.util.ArrayList;
import java.util.List;

//给定一个整数k，k<33，返回杨辉三角的第k行
public class GetRow119 {
    public static List<Integer> getRow(int N){
        List<Integer> res=new ArrayList<Integer>(N+1);
        for(int i=0;i<=N;i++){
            res.add(1);
            for(int j=i-1;j>0;j--){
                res.set(j,res.get(j)+ res.get(j-1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> r=getRow(4);
    }
}
