package medium;
//给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//        （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）

public class MonotoneIncreasingDigits738 {
    /*
    该算法超时，但思路是对的，属于暴力算法
     */
    public int monotoneIncreasingDigits(int N){
       while (isincrease(N)==false){
           N--;
       }
       return N;
    }
    public boolean isincrease(int n){
        int a=n%10;
        n=n/10;
        int c=n%10;
        while(n!=0){
            if(c<=a){
                n=n/10;
                a=c;
                c=n%10;
            }else {
                return false;
            }
        }
        return true;
    }

    /*
    该算法时间复杂度为n^2,首先判断每一位数字，如果该数字小于等于前一位数字，直接赋值，如果该数字大于前一位数字,当前位赋该位数字减一，
    前面的所有位数赋值9.保证最大。
     */
    public  int monotoneIncreasingDigits1(int N){
        int n=N;
        int[] r=new int[10];
        int i=0,a;
        while(n!=0){
            a=n%10;
            n=n/10;
            if(i==0){
                r[i]=a;
            }else {
                if(a>r[i-1]){
                    r[i]=a-1;
                    for(int j=0;j<i;j++){
                        r[j]=9;
                    }
                }else {
                    r[i]=a;
                }
            }
            i++;
        }
        String s="";
        for(int k=i;k>=0;k--){
            if(r[k]!=0){
            s=s+r[k];
            }
        }
        return Integer.parseInt(s);
    }
   /*
   官方题解：贪心，和第二种思路一样,但是寻找顺序不一样，该方法只需要找到不符合递增的最高位，该位减一，把后面的全部置为9，就可以了
    */
    public int monotoneIncreasingDigits2(int N){
        char[] strN=Integer.toString(N).toCharArray();
        int i=1;
        while(i<strN.length&&strN[i-1]<=strN[i]){
            i+=1;
        }
        if(i<strN.length){
            while (i>0&&strN[i-1]>strN[i]){
                strN[i-1]-=1;
                i-=1;
            }
            for(i+=1;i<strN.length;++i){
                strN[i]='9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
