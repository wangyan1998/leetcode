package medium;
//如果字符串中不含有任何'aaa'，'bbb'或'ccc'这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
//        给你三个整数 a，b ，c，请你返回任意一个满足下列全部条件的字符串 s：
//        s 是一个尽可能长的快乐字符串。
//        s 中 最多 有a 个字母 'a'、b个字母 'b'、c 个字母 'c' 。
//        s 中只含有 'a'、'b' 、'c' 三种字母。
//        如果不存在这样的字符串 s ，请返回一个空字符串 ""。
//        0 <= a, b, c <= 100
//        a + b + c > 0

import java.util.Arrays;

/**
 * @author wy
 * @date 2022/2/7 9:39
 */
public class LongestDiverseString1405 {
    /**
     * 贪心算法：快乐字符串的要求是不含三个连续的字符。贪心策略如下：
     * 尽可能优先使用当前数量最多的字母，因为最后同一种字母剩余的越多，越容易出现字母连续相同的情况。
     * 如果构建完成最长的快乐字符串后还存在剩余未选择的字母，则剩余的字母一定为同一种字母且该字母的
     * 总数量最多。
     * 依次从当前数量最多的字母开始尝试，如果发现加入字母会导致出现三个连续的字母，则跳过当前字母，直到
     * 我们能够找到可以添加的字母为止。实际上每次只会在数量最多和数量次多的字母中选择一个。
     * 如果尝试所有字母都无法添加，则直接退出，此时构成的字符串即为最长的快乐字符串。
     * @param a
     * @param b
     * @param c
     * @return
     */
    public String longestDiverseString(int a,int b,int c){
        StringBuilder res=new StringBuilder();
        Pair[] arr={new Pair(a,'a'),new Pair(b,'b'),new Pair(c,'c')};
        while(true){
            Arrays.sort(arr,(p1,p2)->p2.freq-p1.freq);
            boolean hasNext=false;
            for (Pair pair:arr){
                if(pair.freq<=0){
                    break;
                }
                int m=res.length();
                if(m>=2&&res.charAt(m-2)==pair.ch&&res.charAt(m-1)==pair.ch){
                    continue;
                }
                hasNext=true;
                res.append(pair.ch);
                pair.freq--;
                break;
            }
            if (!hasNext){
                break;
            }
        }
        return res.toString();
    }
    class Pair{
        int freq;
        char ch;
        public Pair(int freq,char ch){
            this.freq=freq;
            this.ch=ch;
        }
    }
}
