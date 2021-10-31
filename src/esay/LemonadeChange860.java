package esay;
//在柠檬水摊上，每一杯柠檬水的售价为5美元。
//        顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
//        每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零,也就是说净交易是每位顾客向你支付 5 美元。
//        注意，一开始你手头没有任何零钱。
//        如果你能给每位顾客正确找零，返回true，否则返回 false。

import java.util.Arrays;

public class LemonadeChange860 {
    /*
    题解贪心算法
     */
    public boolean lemonadeChange(int[] bills){
       int five=0,ten=0;
       for(int bill:bills){
           if(bill==5){
               five++;
           }else if(bill==10){
               if(five==0){
                   return false;
               }
               five--;
               ten++;
           }else {
               if(five>0&&ten>0){
                   five--;
                   ten--;
               }else if(five>=3){
                   five-=3;
               }else {
                   return false;
               }
           }
       }
       return true;
    }
     /*
       自写贪心算法
     */
    public boolean lemonadeChange1(int[] bills) {
        int[] num=new int[3];
        boolean re=true;
        Arrays.fill(num,0);
        if(bills.length==0||bills.length==1){
            return true;
        }
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                num[0]++;
            }else if(bills[i]==10){
                if(num[0]>0){
                    num[0]--;
                    num[1]++;
                }else {
                    re=false;
                }
            }else {
                if(num[0]>0&&num[1]>0){
                    num[0]--;
                    num[1]--;
                    num[2]++;
                }else if(num[0]>2){
                    num[0]=num[0]-3;
                    num[2]++;
                }else {
                    re=false;
                }
            }
        }
        return re;
    }
}
