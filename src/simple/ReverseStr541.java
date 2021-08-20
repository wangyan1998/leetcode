package simple;
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
//        如果剩余字符少于 k 个，则将剩余字符全部反转。
//        如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/20 9:24
 */
public class ReverseStr541 {
    /**
     * 按k为轮次，一轮翻转一轮不翻转，交替进行
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s,int k){
       int n=s.length();
       boolean flag=true;
       StringBuffer s1=new StringBuffer();
       StringBuffer res=new StringBuffer();
       for(int i=0;i<n;i++){
           s1.append(s.charAt(i));
           if((i+1)%k==0||i==n-1){
               if(flag==true){
                   s1.reverse();
                   res.append(s1);
                   flag=false;
               }else {
                   res.append(s1);
                   flag=true;
               }
               s1.delete(0,s1.length());
           }
       }
       return res.toString();
    }

    /**
     * 按位交换
     * @param s
     * @param k
     * @return
     */
    public String reverseStr1(String s,int k){
        int n=s.length();
        char[] arr=s.toCharArray();
        for(int i=0;i<n;i+=2*k){
            reverse(arr,i,Math.min(i+k,n)-1);
        }
        return new String(arr);
    }
    public void reverse(char[] arr,int left,int right){
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}
