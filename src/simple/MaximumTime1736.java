package simple;
//给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//        有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
//        替换time 中隐藏的数字，返回你可以得到的最晚有效时间。

/**
 * @author wy
 * @date 2021/7/24 9:34
 */
public class MaximumTime1736 {
    /**
     * 联合条件判断
     * @param time
     * @return
     */
    public String maximumTime(String time){
        StringBuffer res=new StringBuffer();
        for(int i=0;i<5;i++){
            if(time.charAt(i)=='?'){
                if(i==0){
                    if(time.charAt(1)>='4'&&time.charAt(1)<='9'){
                        res.append('1');
                    }else {
                        res.append('2');
                    }
                }else if(i==1){
                    if(res.charAt(0)=='0'||res.charAt(0)=='1'){
                        res.append('9');
                    }else {
                        res.append('3');
                    }
                }else if(i==3){
                    res.append('5');
                }else {
                    res.append('9');
                }

            }else {
                res.append(time.charAt(i));
            }
        }
        return res.toString();
    }

    /**
     * 贪心算法
     * @param time
     * @return
     */
    public String maximumTime1(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }
}
