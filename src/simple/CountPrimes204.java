package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes204 {
    /*
    枚举法，从2到x-1进行枚举y，判断y是否为x的因数。如果y是x的因数，则x/y也是x的因数，所以只需要检验y或者x/y
    ，如果每次都选择检验两者中比较小的那个，则较小数一定会落在[2，根号x]的区间中,所以只需要枚举[2，根号x]中的
    数进行判断即可。
     */
    public int countPrimes(int n){
        int ans=0;
        for(int i=2;i<n;++i){
            ans+=isPrimes(i)?1:0;
        }
        return ans;
    }
    public boolean isPrimes(int x){
        for(int i=2;i*i<=x;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }

    /*
    埃氏筛：如果x是质数，2x,3x......等大于x的x的倍数一定不是质数。
    设isPrime[i]表示数i是不是质数，如果是质数则为1，否则为0。从小到大遍历每个数，
    如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即0。
    这样在运行结束的时候我们即能知道质数的个数。
    还可以继续优化，我们没必要从2x开始标记，因为2x,3x这些书一定在x之前就被其他数标记了，我嗯可以从x*x开始标记。
     */
    public int countPrimes1(int n){
        int[] isPrime=new int[n];
        Arrays.fill(isPrime,1);
        int ans=0;
        for(int i=2;i<n;++i){
            if(isPrime[i]==1){
                ans+=1;
                if((long)i*i<n){
                    for(int j=i*i;j<n;j+=i){
                        isPrime[j]=0;
                    }
                }
            }
        }
        return ans;
    }
    /*
    线性筛：优化的目标是让每个合数只被标记一次，这样时间复杂度即能保证为 O(n)。
    相较于埃氏筛，我们多维护一个primes数组表示当前得到的质数集合。我们从小到大遍历，
    如果当前的数 x是质数，就将其加入primes数组。
    另一点与埃氏筛不同的是，「标记过程」不再仅当 x为质数时才进行，而是对每个整数 x都进行。
    对于整数x，我们不再标记其所有的倍数 x*x,x*(x+1),…，而是只标记质数集合中的数与 x 相乘的数，
    即 primes0*x,primes1*x,且在发现 x%primesi=0的时候结束当前标记。
     */
    public int countPrimes2(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
