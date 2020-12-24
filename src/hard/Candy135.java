package hard;
//老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//        你需要按照以下要求，帮助老师给这些孩子分发糖果：
//        每个孩子至少分配到 1 个糖果。
//        相邻的孩子中，评分高的孩子必须获得更多的糖果。
//        那么这样下来，老师至少需要准备多少颗糖果呢？

public class Candy135 {
    /**
     * 所谓相邻孩子，评分最高的孩子必须获得更多的糖果
     * （1）左边：当ratings[i-1]<ratings[i]时，i号学生的糖果数量将比i-1号孩子的糖果数量多
     * （2）右边：当ratings[i]>ratings[i+1]时，i号学生的糖果数量将比i+1号孩子的糖果数量多
     * 可以对数组进行两次遍历，处理每个学生分别满足左规则和右规则的时候，最少需要被分得的糖果数量，每个人最终分得的糖果数量即为
     * 这两个数量的最大值。
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else {
                left[i]=1;
            }
        }
        int right=0,ret=0;
        for(int i=n-1;i>=0;i--){
            if(i<n-1&&ratings[i]>ratings[i+1]){
                right++;
            }else {
                right=1;
            }
            ret+=Math.max(left[i],right);
        }
        return ret;
    }
    /**
     * 因为注意到糖果总是尽量少给，而且从1开始累计，每次要么比相邻同学多给一个，要么重新置为1.
     * 可以从左到右枚举每一个同学，记前一个同学分得的糖果为pre:
     * 如果当前同学比上一个同学评分高，说明在最近的递增序列中，直接分配该同学pre+1个糖果即可
     * 否则就在一个递减序列中，，我们就直接分配给当前同学一个糖果，并把该同学所在的递减序列中的同学都再分配一个糖果
     * 不需要显式地分配糖果，只需要记录当前递减序列的长度，就可以知道需要额外分配的糖果的数量
     * 同时注意当当前递减序列长度和上一个递增序列等长时，需要把最近的递增序列的最后一个同学也加入到递减序列之中
     */
    public int candy1(int[] ratings){
        int n=ratings.length;
        int ret=1;
        int inc=1,dec=0,pre=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>=ratings[i-1]){
                dec=0;
                pre=ratings[i]==ratings[i-1]?1:pre+1;
                ret+=pre;
                inc=pre;
            }else {
                dec++;
                if(dec==inc){
                    dec++;
                }
                ret+=dec;
                pre=1;
            }
        }
        return ret;
    }
}
