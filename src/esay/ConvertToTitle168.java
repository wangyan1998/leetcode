package esay;
//给定一个正整数，返回它在 Excel 表中相对应的列名称。

/**
 * @author wy
 * @date 2021/6/29 8:45
 */
public class ConvertToTitle168 {
    /**
     * 通过取余确定每一位的字母
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber){
        String res="";
        int c=columnNumber;
        int r=0;
        while(c!=0){
            r=c%26;
            c=c/26;
            if(r==0){
                res="Z"+res;
                c--;
            }else {
                res=(char) ('A'+(r-1))+res;
            }
        }
        return res;
    }

    /**
     * 数学方法，逆推每一位的余数，然后转换成对应的字母，其实就是把一个数字转成26进制，但是范围是[1,26],不是[0,25]
     * @param columnNumber
     * @return
     */
    public String convertToTitle1(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
}
