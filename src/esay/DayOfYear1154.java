package esay;
//给你一个字符串date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
//        通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wy
 * @date 2021/12/21 21:21
 */
public class DayOfYear1154 {
    public int dayOfYear(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8, 10));
        boolean r = false;
        if (y % 4 == 0 && y % 100 != 0) {
            r = true;
        }
        if (y % 400 == 0) {
            r = true;
        }
        int res=0;
        for(int i=1;i<m;i++){
            if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                res+=31;
            }else if(i==2&&r==true){
                res+=29;
            }else if(i==2&&r==false){
                res+=28;
            }else {
                res+=30;
            }
        }
        return res+d;
    }
}
