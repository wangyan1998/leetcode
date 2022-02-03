package esay;

/**
 * @author wy
 * @date 2022/1/31 11:07
 */
public class NumberOfSteps {
    public int NumberOfSteps(int num){
        int res=0;
        while(num!=0){
            if(num%2==0){
                num/=2;
            }else {
                num--;
            }
            res++;
        }
        return res;
    }
}
