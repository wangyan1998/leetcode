package esay;
//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
//        提示：
//        请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
//        并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//        在 Java 中，编译器使用二进制补码记法来表示有符号整数。


public class HammingWeight191 {
    public int hammingWeight(int n){
        int ret=0;
        for(int i=0;i<32;i++){
            if((n&(1<<i))!=0){
                ret++;
            }
        }
        return ret;
    }

    /**
     * n&(n-1)这个公式的价值是把原来数中最右边的1变为0，通过不断的进行这个运算，执行几次这个运算，就代表有几个1
     * @param n
     * @return
     */
    public int hammingWeight1(int n){
        int ret=0;
        while (n!=0){
            n&=n-1;
            ret++;
        }
        return ret;
    }
}
