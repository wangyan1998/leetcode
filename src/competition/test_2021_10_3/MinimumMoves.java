package competition.test_2021_10_3;
//给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
//        一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
//        返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
/**
 * @author wy
 * @date 2021/10/3 10:30
 */
public class MinimumMoves {
    public int minimumMoves(String s){
        int res=0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='X'){
                res++;
                i+=3;
            }else {
                i++;
            }
        }
        return res;
    }
}
