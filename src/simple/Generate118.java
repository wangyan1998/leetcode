package simple;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
import java.util.ArrayList;
import java.util.List;

public class Generate118 {
    /*
     纯数学规律法
     */
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> g1=new ArrayList<Integer>();
        g1.add(1);
        List<Integer> g2=new ArrayList<Integer>();
        g2.add(1);
        g2.add(1);
        if(numRows==0){
            return res;
        }
        res.add(g1);
        if(numRows==1){
            return res;
        }
        res.add(g2);
        if(numRows==2){
           return res;
        }
        List<Integer> temp=g2;
        for(int i=3;i<=numRows;i++){
            List<Integer> gi=new ArrayList<Integer>();
            gi.add(1);
            for(int j=0;j<temp.size()-1;j++){
                gi.add(temp.get(j)+temp.get(j+1));
            }
            gi.add(1);
            res.add(gi);
            temp=gi;
        }
        return res;
    }

    /*
    数学规律简洁版
     */
    public List<List<Integer>> generate1(int numRows){
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;++i){
            List<Integer> row=new ArrayList<Integer>();
            for(int j=0;j<=i;++j){
                if(j==0||j==i){
                    row.add(1);
                }else {
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
