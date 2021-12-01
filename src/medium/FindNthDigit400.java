package medium;
//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
/**
 * @author wy
 * @date 2021/11/30 9:12
 */
public class FindNthDigit400 {
    public int findNthDigit(int n){
        int d=1,count=9;
        while(n>(long)d*count){
            n-=d*count;
            d++;
            count*=10;
        }
        int index=n-1;
        int start=(int)Math.pow(10,d-1);
        int num=start+index/d;
        int digitIndex=index%d;
        int digit=(num/(int)(Math.pow(10,d-digitIndex-1)))%10;
        return digit;
    }

    public int findNthDigit1(int n) {
        int low = 1, high = 9;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int d = low;
        int prevDigits = totalDigits(d - 1);
        int index = n - prevDigits - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }
}
