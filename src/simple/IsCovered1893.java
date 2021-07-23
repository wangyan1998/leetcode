package simple;
//给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到endi的闭区间。
//        如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
//        已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，那么我们称整数x被覆盖了。


/**
 * @author wy
 * @date 2021/7/23 8:54
 */
public class IsCovered1893 {
    /**
     * 暴力解决
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges,int left,int right){
        int n=ranges.length;
        boolean res=true;
        for(int i=left;i<=right;i++){
           res=res&panduan(ranges,i);
        }
        return res;
    }

    public boolean panduan(int[][] ranges,int num){
        boolean res=false;
        for(int i=0;i<ranges.length;i++){
            if(num>=ranges[i][0]&&num<=ranges[i][1]){
                res=true;
                break;
            }
        }
        return res;
    }
}
