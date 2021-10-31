package esay;
//给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
//        answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
//        answer[i] == "Fizz" 如果 i 是 3 的倍数。
//        answer[i] == "Buzz" 如果 i 是 5 的倍数。
//        answer[i] == i 如果上述条件全不满足。


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/10/13 14:46
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n){
        List<String> res=new ArrayList<String>();
        for(int i=1;i<n+1;i++){
            if(i%3==0){
                if(i%5==0){
                   res.add("FizzBuzz");
                }else {
                    res.add("Fizz");
                }
            }else {
                if(i%5==0){
                    res.add("Buzz");
                }else {
                    res.add(i+"");
                }
            }
        }
        return res;
    }

    public List<String> fizzBuzz1(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}
