package esay;
//给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
//        'A'：Absent，缺勤
//        'L'：Late，迟到
//        'P'：Present，到场
//        如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
//        按 总出勤 计，学生缺勤（'A'）严格 少于两天。
//        学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
//        如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。


/**
 * @author wy
 * @date 2021/8/17 9:05
 */
public class CheckRecord551 {
    /**
     * 判断两种情况返回false即可
     * @param s
     * @return
     */
    public boolean checkRecord(String s){
        char[] c=s.toCharArray();
        int n=s.length();
        int count=0;
        int l=0;
        for(int i=0;i<n;i++){
            if(c[i]=='A'){
                count++;
            }
            if(count>1){
                return false;
            }
            if(c[i]=='L'){
                l++;
            }else {
                l=0;
            }
            if(l>=3){
                return false;
            }
        }
        return true;
    }

    /**
     * 答案题解
     * @param s
     * @return
     */
    public boolean checkRecord1(String s) {
        int absents = 0, lates = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absents++;
                if (absents >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                lates++;
                if (lates >= 3) {
                    return false;
                }
            } else {
                lates = 0;
            }
        }
        return true;
    }
}
