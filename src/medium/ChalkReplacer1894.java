package medium;
//一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，然后是编号为 1的学生，
//        以此类推，直到编号为 n - 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
//        给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。当编号为i的学生回答问题时，
//        他会消耗 chalk[i]支粉笔。如果剩余粉笔数量严格小于chalk[i]，那么学生 i需要 补充粉笔。
//        请你返回需要补充粉笔的学生编号。


/**
 * @author wy
 * @date 2021/9/10 8:53
 */
public class ChalkReplacer1894 {
    public int chalkReplacer(int[] chalk,int k){
        int n = chalk.length;
        long total = 0;
        for (int num : chalk) {
            total += num;
        }
        k %= total;
        int res = -1;
        for (int i = 0; i < n; ++i) {
            if (chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
