package medium;

import java.util.HashMap;
import java.util.Map;
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//        比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//        请你实现这个将字符串进行指定行数变换的函数：
//        string convert(string s, int numRows);

/**
 * @author wy
 * @date 2022/3/1 9:45
 */
public class Convert6 {
    public String convert(String s,int numRows){
        if (numRows==1){
            return s;
        }
        Map<Integer,String> map=new HashMap<>();
        int x=2*numRows-2;
        for (int i=0;i<s.length();i++){
            int j=i%x;
            if (j<numRows){
                map.put(j,map.getOrDefault(j,"")+s.charAt(i));
            }else {
                map.put(x-j,map.getOrDefault(x-j,"")+s.charAt(i));
            }
        }
        StringBuffer res=new StringBuffer();
        for (int i=0;i<numRows;i++){
            if (map.get(i)!=null){
                res.append(map.get(i));
            }
        }
        return res.toString();
    }
}
