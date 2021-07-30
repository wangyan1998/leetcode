package simple;
//给定一个Excel表格中的列名称，返回其相应的列序号。
/**
 * @author wy
 * @date 2021/7/30 9:34
 */
public class TitleToNumber171 {
    /**
     * 26进制逐位求和
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle){
        int n=columnTitle.length();
        int res=0,w=1;
        for(int i=n-1;i>=0;i--){
            int a=columnTitle.charAt(i)-'A'+1;
            res+=a*w;
            w*=26;
        }
        return res;
    }
}

