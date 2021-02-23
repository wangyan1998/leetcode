package medium;
//今天，书店老板有一家店打算试营业customers.length分钟。每分钟都有一些顾客（customers[i]）
//        会进入书店，所有这些顾客都会在那一分钟结束后离开。
//        在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，
//        否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
//        书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续X 分钟不生气，但却只能使用一次。
//        请你返回这一天营业下来，最多有多少客户能够感到满意的数量。

public class MaxSatisfied1052 {
    /**
     * 取得一个区间内，grumpy为1的和的最大值对应的区间，将该区间全部设为0，求和
     * @param customers
     * @param grumpy
     * @param x
     * @return
     */
    public int maxSatisfied(int[] customers,int[] grumpy,int x){
        int left=0;
        int l=0;
        int maxsum=0;
        int sum=0;
        while(left<=customers.length-x){
            sum=0;
            for(int i=left;i<left+x;i++){
                if(grumpy[i]==1){
                    sum+=customers[i];
                }
            }
            if(sum>maxsum){
                l=left;
                maxsum=sum;
            }
            left++;
        }
        for(int i=l;i<l+x;i++){
            grumpy[i]=0;
        }
        int count=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                count+=customers[i];
            }
        }
        return count;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
